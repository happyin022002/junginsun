/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpaceAllocationManageDBDAO.java
*@FileTitle : Allocation Change by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.07.29 최윤성
* 1.0 Creation
* History ------------------------------------------
* 2010.08.27 이행지 [CHM-201005552-01] Allocation Control by Main Office 화면 Remark 기능 보완
                                   - Remark 가능한 Office인지 체크하기
* 2011.05.03 이석준 [CHM-201110568-01] Bottleneck Check 화면 조건 보완(VVD Input 조회시 VVD 정보 조회)
                                   - SearchSpaceAllocationManage045VVDInfo method 추가
* 2011.08.08 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 1차 - 주차별 CMB 항목 조회되도록 searchWeek() 추가
* 2011.08.16 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 2차 - WAFIE Allocation 팝업 추가로 인한 메소드 추가
* 2011.08.25 김종준 [CHM-201113071-01] control by HO/RHQ 화면과 COA 링크 팝업 추가로 인한 메소드 추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.06.26 진마리아 [CHM-201325016-01] 성수기 Alloc copy 기능 개발
* 2013.08.13 진마리아 [trouble shooting] 성수기 Alloc 저장시 비수기로 말아올리는 과정에 mnl_aloc_rmk 가 3으로 하드코딩된 것 수정
* 2013.08.09 박찬민 [CHM-201325692] Bottleneck 산출 로직 추가 - 신규 메뉴
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.12.08 신자영 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
* 2015.01.02 Arie [CHM-201433401]Control Option Registration - Upload기능 추가 요청
* 2015.01.30 신자영 [CHM-201533908] Control Option 보완 - SC/RFA컬럼 제거 - Sheet3, 4 추가, sheet2, 3, 4에 delete check box 추가(9014754 김성욱)
* 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
* 2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청 
=========================================================
*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.basic.SpaceAllocationManageBCImpl;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchActualCustomerVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchNoShowAdjustmentListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchNoShowDownloadDateListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchRemarkFlagOfficeVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchRptItemVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSPCAllocBKGListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0033LaneRgstVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042DetailListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042MListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044DetailListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044MasterListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047DetailListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047MasterListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0053ManageListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045QtyListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045VVDInfoVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045VVDListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationModelListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationModelRun0054ListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchVesselSKDListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageSummaryVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageTempListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcAlocCtrlOptVO;
import com.hanjin.syscommon.common.table.SpcAlocCustPolPodVO;
import com.hanjin.syscommon.common.table.SpcAlocPolPodVO;
import com.hanjin.syscommon.common.table.SpcFcastDwnLodSkdVO;
import com.hanjin.syscommon.common.table.SpcMdlVerMstVO;
import com.hanjin.syscommon.common.table.SpcNshwRsltVO;

/**
 * ALPS SpaceAllocationManageDBDAO <br>
 * - ALPS-SpaceAllocationManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI Yun Sung
 * @see SpaceAllocationManageBCImpl 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0042DetailListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0042DetailListVO> searchSpaceAllocationDetailList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0042DetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0042DetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0042DetailListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	  
	 /**
	  * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	  * 
	  * @param ConditionVO conditionVO
	  * @return List<SearchSpaceAllocation0042DetailListVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchSpaceAllocation0042DetailListVO> searchSpaceAllocationDetailListSMP(ConditionVO conditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchSpaceAllocation0042DetailListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(conditionVO != null){
				 Map<String, String> mapVO = conditionVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0042DetailListSMPRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0042DetailListVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list; 
	 }         
	 
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0042MListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0042MListVO> searchSpaceAllocationMasterList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0042MListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0042MListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0042MListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO vo
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiSpaceAllocation(SpcAlocPolPodVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			velParam.put("rmk_size", vo.getSpcCtrlAlocRmk().length());
			velParam.put("pol_rmk_size", vo.getSpcCtrlAlocPolRmk().length());
			velParam.put("pod_rmk_size", vo.getSpcCtrlAlocPodRmk().length());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(    (vo.getIocCd().equals("IPC") && !vo.getSubTrdCd().equals("IA"))
				|| (vo.getIocCd().equals("T/S") && !vo.getSubTrdCd().equals("IA")) ) {
				if(vo.getModeRmk().equals("UPD")){
					result = sqlExe.executeUpdate((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPodRmkUSQL(), param, velParam);
				} 
			} else {
				result = sqlExe.executeUpdate((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPodRmk2USQL(), param, velParam);
			}
			
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpaceAllocationS(List<SpcAlocPolPodVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod042CSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	

    /**
     * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
     * addmultiSpaceAllocationS와 동일한 내용인데 Merge문으로 쿼리를 변경해 Insert또는 update하도록 변경
     * @param List<SpcAlocPolPodVO> insModels
     * @return int[]
     * @throws DAOException
     * @throws Exception
     */
    public int[] addmultiSpaceAllocationSMerge(List<SpcAlocPolPodVO> insModels) throws DAOException,Exception {
        int insCnt[] = null;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            if(insModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod042MergeCSQL(), insModels,null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return insCnt;
    }
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocCustPolPodVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpaceAllocationSmpS(List<SpcAlocCustPolPodVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocCustPolPod042CSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
				
				// SPC_ALOC_CUST_HIS 에 입력 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocCustHis42CSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocCustPolPodVO> insModels
	 * @param String mnlAlocRmk
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpaceAllocationSmpS(List<SpcAlocCustPolPodVO> insModels, String mnlAlocRmk) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				for(SpcAlocCustPolPodVO vo : insModels){
					vo.setMnlAlocRmk(mnlAlocRmk);
				}
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPodSmp042CSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [ESM_SPC_0071] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchVesselSKDListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchVesselSKDListVO> searchVesselSKDList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVesselSKDListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchVesselSKDListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVesselSKDListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [0044] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpaceAllocationS0044(List<SpcAlocPolPodVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod044CSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [0047] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpaceAllocationS0047(List<SpcAlocPolPodVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod047CSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [0070] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcNshwRsltVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiNoShowAdjustment(List<SpcNshwRsltVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOSpcNshwRsltVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [0070] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcFcastDwnLodSkdVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiForcastDownloadDate(List<SpcFcastDwnLodSkdVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOSpcFcastDwnLodSkdVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpaceAllocationS(List<SpcAlocPolPodVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod042USQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [0044] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpaceAllocationS0044(List<SpcAlocPolPodVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod044USQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [0047] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpaceAllocationS0047(List<SpcAlocPolPodVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod047USQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [0070] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcNshwRsltVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiNoShowAdjustment(List<SpcNshwRsltVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOSpcNshwRsltVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [0070] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcFcastDwnLodSkdVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiForcastDownloadDate(List<SpcFcastDwnLodSkdVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOSpcFcastDwnLodSkdVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSpaceAllocationS(List<SpcAlocPolPodVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod042DSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocCustPolPodVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSpaceAllocationSmpS(List<SpcAlocCustPolPodVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocCustPolPod042DSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod042DSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * [0044] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSpaceAllocationS0044(List<SpcAlocPolPodVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod044DSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * [0047] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSpaceAllocationS0047(List<SpcAlocPolPodVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod047DSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * [0070] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcNshwRsltVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiNoShowAdjustment(List<SpcNshwRsltVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOSpcNshwRsltVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * [0070] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcFcastDwnLodSkdVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiForcastDownloadDate(List<SpcFcastDwnLodSkdVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOSpcFcastDwnLodSkdVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocCtrlOptVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiControlOptionS(List<SpcAlocCtrlOptVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocCtrlOptVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiControlOptionS(List<SpcAlocCtrlOptVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocCtrlOptVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiControlOptionS(List<SpcAlocCtrlOptVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * Tab 1 (Trade Tab) 및 Tab 2(Sub Trade Tab) 메인 조회전 Key 체크
	 * @param ConditionVO conditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSpaceAllocationControlFlagList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocationControlFlagListRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * [ESM_SPC_0065] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpaceAllocationTemp1stS(List<SpcAlocPolPodVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPodTemp1stCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [ESM_SPC_0066] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpaceAllocationTemp3rdS(List<SpcAlocPolPodVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPodTemp3rdCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [ESM_SPC_0066] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0042DetailListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SpaceAllocationManageTempListVO> searchSpaceAllocationManageTemp(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpaceAllocationManageTempListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("ts_flg", conditionVO.getIocCd().indexOf("T/S") >= 0 ? "Y":"N");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSpaceAllocationManageTempListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpaceAllocationManageTempListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [ESM_SPC_0066] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSpaceAllocationTemp3rdS(List<SpcAlocPolPodVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPodTemp3rdDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * [ESM_SPC_0044] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0044DetailListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0044DetailListVO> searchSpaceAllocation0044DetailList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0044DetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0044DetailListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0044DetailListVO .class);
			
			log.debug("list.size():"+list.size());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * [ESM_SPC_0044] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0044MasterListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0044MasterListVO> searchSpaceAllocation0044MasterList(ConditionVO conditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0044MasterListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0044MasterListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0044MasterListVO .class);
			
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
 
 
	/**
	 * [ESM_SPC_0045] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0044MasterListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocationManage045VVDListVO> searchSpaceAllocationManage045VVDList(ConditionVO conditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		List<SearchSpaceAllocationManage045VVDListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocationManage045VVDListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocationManage045VVDListVO .class);
			
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		/**
		 * [ESM_SPC_0045] VVD Input 입력시 VVD의 Lane,Week 정보 조회.<br>
		 * 
		 * @param ConditionVO conditionVO
		 * @return List<SearchSpaceAllocation0044MasterListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchSpaceAllocationManage045VVDInfoVO> searchSpaceAllocationManage045VVDInfo(ConditionVO conditionVO) throws DAOException {			                                                 
			 DBRowSet dbRowset = null;
			List<SearchSpaceAllocationManage045VVDInfoVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(conditionVO != null){
					Map<String, String> mapVO = conditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocationManage045VVDInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocationManage045VVDInfoVO .class);
				
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}	 
	 
		/**
		 * [ESM_SPC_0045] 정보를 [행위] 합니다.<br>
		 * 
		 * @param ConditionVO conditionVO
		 * @return List<SearchSpaceAllocationManage045QtyListVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchSpaceAllocationManage045QtyListVO> searchSpaceAllocationManage045QtyList(ConditionVO conditionVO) throws DAOException {
			 DBRowSet dbRowset = null;
			List<SearchSpaceAllocationManage045QtyListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(conditionVO != null){
					Map<String, String> mapVO = conditionVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocationManage045QtyListVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocationManage045QtyListVO .class);
				
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
	/**
	 * [ESM_SPC_0047] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0047DetailListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0047DetailListVO> searchSpaceAllocation0047DetailList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0047DetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0047DetailListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0047DetailListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	  * [ESM_SPC_0047] 정보를 [행위] 합니다.<br>
	  * 
	  * @param ConditionVO conditionVO
	  * @return List<SearchSpaceAllocation0047DetailListVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchSpaceAllocation0047DetailListVO> searchSpaceAllocation0047DetailListSMP(ConditionVO conditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchSpaceAllocation0047DetailListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(conditionVO != null){
				 Map<String, String> mapVO = conditionVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0047DetailListSMPRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0047DetailListVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	/**
	 * [ESM_SPC_0047] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0047MasterListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0047MasterListVO> searchSpaceAllocation0047MasterList(ConditionVO conditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0047MasterListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0047MasterListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0047MasterListVO .class);
			
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_SPC_0053] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0053ManageListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0053ManageListVO> searchSpaceAllocationManageList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0053ManageListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0053ManageListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0053ManageListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_SPC_0070] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNoShowAdjustmentListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchNoShowAdjustmentListVO> searchNoShowAdjustmentList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchNoShowAdjustmentListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchNoShowAdjustmentListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNoShowAdjustmentListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_SPC_0070] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNoShowDownloadDateListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchNoShowDownloadDateListVO> searchNoShowDownloadDateList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchNoShowDownloadDateListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchNoShowDownloadDateListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNoShowDownloadDateListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [ESM_SPC_0054] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocationModelRun0054ListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocationModelRun0054ListVO> searchSpaceAllocationModelRun0054List(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocationModelRun0054ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocationModelRun0054ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocationModelRun0054ListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	 }
	 
	/**
	 * [ESM_SPC_0041] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocationModelListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocationModelListVO> searchSpaceAllocationModelList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocationModelListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocationModelListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocationModelListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	} 
	 
	/**
	 * [ESM_SPC_0044] 정보를 [행위] 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return List<SearchRemarkFlagOfficeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchRemarkFlagOfficeVO> searchRemarkFlagOffice(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRemarkFlagOfficeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				param.put("ofc_cd",ofcCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchRemarkFlagOfficeRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRemarkFlagOfficeVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_SPC_0042, ESM_SPC_0047]을 Weekly CMB 4주를 표현하기 위한 Header.<br>
	 * 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchWeek () throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchWeekRSQL(), param, null);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	
	/**
	 * SAQ에 Alloction Confirm하여 넘긴 Volumn((SQM_ALOC_QTA) 존재 여부 체크<br>
	 * 
	 * @param String rlaneCd
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAllocationConfirmFlag(String rlaneCd, String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnFlg   = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(rlaneCd != null && vvd != null){
				param.put("lane",rlaneCd);
				param.put("vvd",vvd);
			}
			
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0042ConfirmRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					rtnFlg = dbRowset.getString(1);
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnFlg;
	}
	
	
	/**
	 * [ESM_SPC_0048] WAF Allocation 정보를 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpcAlocPolPodVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SpcAlocPolPodVO> searchWAFAlloc(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpcAlocPolPodVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchWAFAllocRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcAlocPolPodVO .class);
		}catch(SQLException se){ 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * [ESM_SPC_0048] WAF Allocation 정보를 [삽입] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addSpcAlocPolPodVOs(List<SpcAlocPolPodVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod0048CSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [ESM_SPC_0048] WAF Allocation 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifySpcAlocPolPodVOs(List<SpcAlocPolPodVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod0048USQL(), updModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [ESM_SPC_0048] WAF Allocation 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeSpcAlocPolPodVOs(List<SpcAlocPolPodVO> delModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod0048DSQL(), delModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * Inquiry by Customized Condition 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SalesRPTCommonVO vo
	 * @return SalesRPTCommonVO
	 * @throws DAOException
	 */
    public SalesRPTCommonVO searchInqByCondition0049List(SalesRPTCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        SalesRPTCommonVO retVo = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchInqByCondition0049ListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            retVo = new SalesRPTCommonVO();
            retVo.setRowSet(dbRowset);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
        	log.error("err "+se.toString(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
        	log.error("err "+ex.toString(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return retVo;
    }

    /**
     * coa_rpt_itm_info_dtl 목록을 가져온다.<br>
     *  - List 타입의 View Adapter용 조회
     *
     * @param SalesRPTCommonVO vo
     * @return List<SearchRptItemVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SearchRptItemVO> searchRptItem(SalesRPTCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchRptItemVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchRptItemRSQL(), vo.getIndirectQueryParameter(), null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRptItemVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
        	log.error("err "+se.toString(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
        	log.error("err "+ex.toString(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	
	/**
	 * [ESM_SPC_0049]을 Select Customized RPT Form 조회.<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRptFormList (SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("code"    ,account.getUsr_id());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchRptFormListRSQL(), param, null);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}	
	
	/**
	 * [ESM_SPC_0046] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0042MListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0042MListVO> searchSpaceAllocation0046List(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0042MListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0046ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0042MListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * [ESM_SPC_0046] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> delModels
	 * @return  int[] 
	 * @throws DAOException
	 */
	 public int[] removemultiSpaceAllocation0046ByHOList( List<SpcAlocPolPodVO> delModels ) throws DAOException {
		 
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();					
				
			if(delModels.size() > 0){
				//for ( int i=0; i<delModels.size(); i++ ) {
				Map<String, String> mapVO = delModels.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				delCnt =  sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod1stDSQL(), delModels, velParam);						
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	 
	 /**
	  * 성수기 - [ESM_SPC_0046] 정보를 [행위] 합니다.<br>
	  * 
	  * @param List<SpcAlocPolPodVO> delModels
	  * @return  int[] 
	  * @throws DAOException
	  */
	 public int[] removemultiSpaceAllocation0046ByHOSmpList( List<SpcAlocPolPodVO> delModels ) throws DAOException {
		 
		 int delCnt[] = null;
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();					
			 
			 if(delModels.size() > 0){
				 //for ( int i=0; i<delModels.size(); i++ ) {
				 Map<String, String> mapVO = delModels.get(0).getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 delCnt =  sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod1stSmpDSQL(), delModels, velParam);						
			 }
		 } catch (SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return delCnt;
	 }
	 
	 /**
	 * [ESM_SPC_0046] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO>  insModels
	 * @return int[]
	 * @throws DAOException
	 */
	 public int[]  addmultiSpaceAllocation0046ByHOList(List<SpcAlocPolPodVO>  insModels) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(insModels.size() > 0){
				Map<String, String> mapVO = insModels.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod1stCSQL(), insModels, velParam);	
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	 
	 /**
	  * 성수기 - [ESM_SPC_0046] 정보를 [행위] 합니다.<br>
	  * 
	  * @param List<SpcAlocPolPodVO>  insModels
	  * @return int[]
	  * @throws DAOException
	  */
	 public int[]  addmultiSpaceAllocation0046ByHOSmpList(List<SpcAlocPolPodVO>  insModels) throws DAOException {
		 int insCnt[] = null;
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 if(insModels.size() > 0){
				 Map<String, String> mapVO = insModels.get(0).getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod1stSmpCSQL(), insModels, velParam);	
			 }
			 
		 } catch (SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return insCnt;
	 }
	 
	 /**
	  * 성수기 - [ESM_SPC_0046] aloc_cust_pol_pod 입력 후 history 생성<br>
	  * 
	  * @param List<SpcAlocPolPodVO>  insModels
	  * @return int[]
	  * @throws DAOException
	  */
	 public int[]  addmultiSpaceAllocation0046CustHis(List<SpcAlocPolPodVO>  insModels) throws DAOException {
		 int insCnt[] = null;
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 if(insModels.size() > 0){
				 Map<String, String> mapVO = insModels.get(0).getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOAddmultiSpaceAllocation0046CustHisCSQL(), insModels, velParam);	
			 }
			 
		 } catch (SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return insCnt;
	 }
	 
	 /**
	 * [ESM_SPC_0046] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO> delModels
	 * @return int[] 
	 * @throws DAOException
	 */
	 public int[] removemultiSpaceAllocation0046ByRHQList( List<SpcAlocPolPodVO> delModels ) throws DAOException,Exception {
		 
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(delModels.size() > 0){								
				Map<String, String> mapVO = delModels.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);								
				delCnt =  sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod2ndDSQL(), delModels, velParam);								
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	 
	 /**
	  * [ESM_SPC_0046] 정보를 [행위] 합니다.<br>
	  * 
	  * @param List<SpcAlocPolPodVO> delModels
	  * @return int[] 
	  * @throws DAOException
	  */
	 public int[] removemultiSpaceAllocation0046ByRHQSmpList( List<SpcAlocPolPodVO> delModels ) throws DAOException,Exception {
		 
		 int delCnt[] = null;
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 if(delModels.size() > 0){								
				 Map<String, String> mapVO = delModels.get(0).getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);								
				 delCnt =  sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod2ndSmpDSQL(), delModels, velParam);								
			 }
		 } catch (SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return delCnt;
	 }
			 
	 /**
	 * [ESM_SPC_0046] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocPolPodVO>  insModels
	 * @return int[] 
	 * @throws DAOException
	 */
	 public int[]  addmultiSpaceAllocation0046ByRHQList(List<SpcAlocPolPodVO>  insModels) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(insModels.size() > 0){
				Map<String, String> mapVO = insModels.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);									
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod2ndCSQL(), insModels, velParam);	
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	 
	 /**
	  * [ESM_SPC_0046] 정보를 [행위] 합니다.<br>
	  * 
	  * @param List<SpcAlocPolPodVO>  insModels
	  * @return int[] 
	  * @throws DAOException
	  */
	 public int[]  addmultiSpaceAllocation0046ByRHQSmpList(List<SpcAlocPolPodVO>  insModels) throws DAOException {
		 int insCnt[] = null;
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 if(insModels.size() > 0){
				 Map<String, String> mapVO = insModels.get(0).getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);									
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocPolPod2ndSmpCSQL(), insModels, velParam);	
			 }
		 } catch (SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return insCnt;
	 }

	/**
	 * TRD, SUB TRD, VVD, 주차에 해당하는 정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageSummaryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SpaceAllocationManageSummaryVO> searchStatusByVvd(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpaceAllocationManageSummaryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchStatusByVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpaceAllocationManageSummaryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * TRD, SUB TRD, OFC, 주차에 해당하는 항차들의 정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageSummaryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SpaceAllocationManageSummaryVO> searchStatusByLofc(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpaceAllocationManageSummaryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchStatusByLofcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpaceAllocationManageSummaryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchSpaceAllocationData(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		int list = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSpaceAllocationManageDataRSQL(), param, velParam);
			if(dbRowset.next()){
				list = dbRowset.getInt("CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * [ESM_SPC_0042] 정보를 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removemultiSpaceAllocationPolPod(ConditionVO conditionVO) throws DAOException,Exception {
		int delCnt = 0;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			delCnt = sqlExe.executeUpdate((ISQLTemplate)new SpaceAllocationManageDBDAOSpcAlocPolPodDSQL(), param,null);
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * [ESM_SPC_0044] 성수기 항차의 detail 정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0044DetailListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0044DetailListVO> searchSpaceAllocation0044DetailSMPList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0044DetailListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0044DetailSMPListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0044DetailListVO .class);
			
			log.debug("list.size():"+list.size());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_SPC_0044] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SpcAlocCustPolPodVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpaceAllocationSmpS0044(List<SpcAlocCustPolPodVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocCustPolPod044CSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
				
				// SPC_ALOC_CUST_HIS 에 입력 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOMultiSpcAlocCustHis42CSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	
	/**
	 * [ESM_SPC_0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033LaneRgstList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0033LaneRgstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceAllocation0033LaneRgstVO != null){
				Map<String, String> mapVO = searchSpaceAllocation0033LaneRgstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0033LaneRgstListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0033LaneRgstVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
 	/**
	 * [ESM_SPC_0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033LanePortRgstList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0033LaneRgstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceAllocation0033LaneRgstVO != null){
				Map<String, String> mapVO = searchSpaceAllocation0033LaneRgstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0033LanePortRgstListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0033LaneRgstVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

 	/**
	 * [ESM_SPC_0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033VVDLaneRgstList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0033LaneRgstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceAllocation0033LaneRgstVO != null){
				Map<String, String> mapVO = searchSpaceAllocation0033LaneRgstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0033VVDLaneRgstListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0033LaneRgstVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
 	/**
	 * [ESM_SPC_0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033VVDLanePortRgstList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0033LaneRgstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceAllocation0033LaneRgstVO != null){
				Map<String, String> mapVO = searchSpaceAllocation0033LaneRgstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0033VVDLanePortRgstListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0033LaneRgstVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	 /**
	 * [ESM_SPC_0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033BSACapaList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0033LaneRgstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceAllocation0033LaneRgstVO != null){
				Map<String, String> mapVO = searchSpaceAllocation0033LaneRgstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0033BSACapaListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0033LaneRgstVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * [ESM_SPC_0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033BSACapaByPort(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSpaceAllocation0033LaneRgstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchSpaceAllocation0033LaneRgstVO != null){
				Map<String, String> mapVO = searchSpaceAllocation0033LaneRgstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchSpaceAllocation0033BSACapaByPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpaceAllocation0033LaneRgstVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * [0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocation0033LaneRgstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMultiSpaceAllocation0033LaneRgstList(List<SearchSpaceAllocation0033LaneRgstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOAddMultiSpaceAllocation0033LaneRgstListCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocation0033LaneRgstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMultiSpaceAllocation0033LaneRgstList(List<SearchSpaceAllocation0033LaneRgstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOModifyMultiSpaceAllocation0033LaneRgstListUSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocation0033LaneRgstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeMultiSpaceAllocation0033LaneRgstList(List<SearchSpaceAllocation0033LaneRgstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAORemoveMultiSpaceAllocation0033LaneRgstListDSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocation0033LaneRgstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMultiSpaceAllocation0033LanePortRgstList(List<SearchSpaceAllocation0033LaneRgstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOAddMultiSpaceAllocation0033LanePortRgstListCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocation0033LaneRgstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMultiSpaceAllocation0033LanePortRgstList(List<SearchSpaceAllocation0033LaneRgstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOModifyMultiSpaceAllocation0033LanePortRgstListUSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocation0033LaneRgstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeMultiSpaceAllocation0033LanePortRgstList(List<SearchSpaceAllocation0033LaneRgstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAORemoveMultiSpaceAllocation0033LanePortRgstListDSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocation0033LaneRgstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMultiSpaceAllocation0033VVDLaneRgstList(List<SearchSpaceAllocation0033LaneRgstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOAddMultiSpaceAllocation0033VVDLaneRgstListCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocation0033LaneRgstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMultiSpaceAllocation0033VVDLaneRgstList(List<SearchSpaceAllocation0033LaneRgstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOModifyMultiSpaceAllocation0033VVDLaneRgstListUSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocation0033LaneRgstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeMultiSpaceAllocation0033VVDLaneRgstList(List<SearchSpaceAllocation0033LaneRgstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAORemoveMultiSpaceAllocation0033VVDLaneRgstListDSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocation0033LaneRgstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMultiSpaceAllocation0033VVDLanePortRgstList(List<SearchSpaceAllocation0033LaneRgstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOAddMultiSpaceAllocation0033VVDLanePortRgstListCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocation0033LaneRgstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMultiSpaceAllocation0033VVDLanePortRgstList(List<SearchSpaceAllocation0033LaneRgstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOModifyMultiSpaceAllocation0033VVDLanePortRgstListUSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [0033] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchSpaceAllocation0033LaneRgstVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeMultiSpaceAllocation0033VVDLanePortRgstList(List<SearchSpaceAllocation0033LaneRgstVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAORemoveMultiSpaceAllocation0033VVDLanePortRgstListDSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * Season 내 first version의 적용 시작 주차 이후에 기입력되어 있는 Alloc을 조회합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @return List<SpcAlocCustPolPodVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SpcAlocCustPolPodVO> searchTargetCustAlloc(SpcMdlVerMstVO spcMdlVerMstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpcAlocCustPolPodVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(spcMdlVerMstVO != null){
				Map<String, String> mapVO = spcMdlVerMstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchTargetCustAllocRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcAlocCustPolPodVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Season 내 first version의 적용 시작 주차 이후에 기입력되어 있는 Alloc을 삭제합니다.<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int deleteTargetCustAlloc(SpcMdlVerMstVO spcMdlVerMstVO) throws DAOException,Exception {
		int delCnt = 0;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(spcMdlVerMstVO != null){
				Map<String, String> mapVO = spcMdlVerMstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			delCnt = sqlExe.executeUpdate((ISQLTemplate)new SpaceAllocationManageDBDAODeleteTargetCustAllocDSQL(), param,null);
			
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * 조회해놓은 Alloc을 새 Season에 존재하는 그룹으로 변경하여 입력합니다.<br>
	 * 
	 * @param List<SpcAlocCustPolPodVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addTargetCustAlloc(List<SpcAlocCustPolPodVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOAddTargetCustAllocCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	

	/**
	 * Customer Code 조회
	 * @param SearchActualCustomerVO searchActualCustomerVO
	 * @return List<SearchActualCustomerVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchActualCustomerVO> searchActualCustomer(SearchActualCustomerVO searchActualCustomerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchActualCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = searchActualCustomerVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSearchActualCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchActualCustomerVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 

		
		/**
		 * Allocation HO 에서 aloc 물량 변경시 Standby bkg 물량 찾음, - SMP 인 경우
		 * @param SpcAlocCustPolPodVO spcAlocCustPolPodVO
		 * @param ConditionVO conVo
		 * @return List<String>
		 * @throws DAOException
		 * @throws Exception
		 */
		public List<String> searchSpaceAllocationSmp( SpcAlocCustPolPodVO spcAlocCustPolPodVO, ConditionVO conVo ) throws DAOException , Exception {
			DBRowSet dbRowset = null;
			List<String> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(spcAlocCustPolPodVO != null){
					Map<String, String> mapVO = spcAlocCustPolPodVO.getColumnValues();
					param.putAll(mapVO);
					param.put("week", conVo.getWeek());
					param.put("year", conVo.getYear());
					param.put("ofc_cd", conVo.getOfcCd());
					velParam.putAll(mapVO);
					velParam.put("week", conVo.getWeek());
					velParam.put("year", conVo.getYear());
					velParam.put("ofc_cd", conVo.getOfcCd());
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSPCAllocBKGCountSMPRSQL(), param, velParam);
				
				if(dbRowset != null){
					int count = dbRowset.getRowCount();
					list = new ArrayList<String>();
					
					for( int x=0 ; x<count ; x++ ) {
						if(dbRowset.next()){
							list.add( dbRowset.getString("bkg_no") );
						}
					}
				}
//				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerControlGroupVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		/**
		 * Allocation HO 에서 aloc 물량 변경시 Standby bkg 물량 찾음, 
		 * @param SpcAlocPolPodVO spcAlocPolPodVO
		 * @param ConditionVO conVo
		 * @return List<String> : Standby bkg_no
		 * @throws DAOException
		 * @throws Exception
		 */
		public List<String> searchSpaceAllocationHO( SpcAlocPolPodVO spcAlocPolPodVO, ConditionVO conVo ) throws DAOException , Exception {
			DBRowSet dbRowset = null;
			List<String> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(spcAlocPolPodVO != null){
					Map<String, String> mapVO = spcAlocPolPodVO.getColumnValues();
//					param.putAll(mapVO);
//					velParam.putAll(mapVO);
					param.putAll(mapVO);
					param.put("week", conVo.getWeek());
					param.put("year", conVo.getYear());
					param.put("ofc_cd", conVo.getOfcCd());
					velParam.putAll(mapVO);
					velParam.put("week", conVo.getWeek());
					velParam.put("year", conVo.getYear());
					velParam.put("ofc_cd", conVo.getOfcCd());
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSPCAllocBKGCountRSQL(), param, velParam);
				
				if(dbRowset != null){
					int count = dbRowset.getRowCount();
					list = new ArrayList<String>();
					
					for( int x=0 ; x<count ; x++ ) {
						if(dbRowset.next()){
							list.add( dbRowset.getString("bkg_no") );
						}
					}
				}
//				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerControlGroupVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
		/**
		 * Allocation HO 에서 aloc 물량 변경시 Standby bkg 물량 찾음, 
		 * @param SpcAlocPolPodVO spcAlocPolPodVO
		 * @return List<String> : Standby bkg_no
		 * @throws DAOException
		 * @throws Exception
		 */
		public List<String> searchSpaceAllocation( SpcAlocPolPodVO spcAlocPolPodVO ) throws DAOException , Exception {
			DBRowSet dbRowset = null;
			List<String> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(spcAlocPolPodVO != null){
					Map<String, String> mapVO = spcAlocPolPodVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSPCAllocBKGCountRSQL(), param, velParam);
				
				if(dbRowset != null){
					int count = dbRowset.getRowCount();
					list = new ArrayList<String>();
					
					for( int x=0 ; x<count ; x++ ) {
						if(dbRowset.next()){
							list.add( dbRowset.getString("bkg_no") );
						}
					}
				}
//				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerControlGroupVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
		/**
		 * Allocation HO 에서 aloc 물량 변경 후 결과 Standby bkg LIST - Not SMP 
		 * @param SpcAlocPolPodVO spcAlocPolPodVO
		 * @return List<SearchSPCAllocBKGListVO> : Standby bkg_no
		 * @throws DAOException
		 * @throws Exception
		 */
		public List<SearchSPCAllocBKGListVO> searchSPCAllocBKGList( SpcAlocPolPodVO spcAlocPolPodVO ) throws DAOException , Exception {
			List<SearchSPCAllocBKGListVO> list = null;
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(spcAlocPolPodVO != null){
					Map<String, String> mapVO = spcAlocPolPodVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSPCAllocBKGListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSPCAllocBKGListVO.class);
				if( list != null ){
					for( int x=0 ; x<list.size() ; x++ ) {
						if( spcAlocPolPodVO != null )
							list.get(x).setRowNum( spcAlocPolPodVO.getAlocMdfy() );
					}
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
		/**
		 * Allocation HO 에서 aloc 물량 변경 후 결과 Standby bkg LIST - SMP 
		 * @param SpcAlocCustPolPodVO spcAlocCustPolPodVO
		 * @param ConditionVO conVo
		 * @return List<SearchSPCAllocBKGListVO> : Standby bkg_no
		 * @throws DAOException
		 * @throws Exception
		 */
		public List<SearchSPCAllocBKGListVO> searchSPCAllocBKGSMPList( SpcAlocCustPolPodVO spcAlocCustPolPodVO, ConditionVO conVo ) throws DAOException , Exception {
			List<SearchSPCAllocBKGListVO> list = null;
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(spcAlocCustPolPodVO != null){
					Map<String, String> mapVO = spcAlocCustPolPodVO.getColumnValues();
					param.putAll(mapVO);
					param.put("week", conVo.getWeek());
					param.put("year", conVo.getYear());
					param.put("ofc_cd", conVo.getOfcCd());
					velParam.putAll(mapVO);
					velParam.put("week", conVo.getWeek());
					velParam.put("year", conVo.getYear());
					velParam.put("ofc_cd", conVo.getOfcCd());
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpaceAllocationManageDBDAOSPCAllocBKGListSMPRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSPCAllocBKGListVO.class);
				if( list != null ){
					for( int x=0 ; x<list.size() ; x++ ) {
						if(spcAlocCustPolPodVO != null){
							list.get(x).setRowNum( spcAlocCustPolPodVO.getAlocMdfy() );
						}
					}
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
		/**
		 * Desync동작
		 * @param List<SpcAlocCtrlOptVO> spcAlocCtrlOptVO
		 * @throws DAOException
		 * @throws Exception
		 */
		public void multiSpaceAllocationDeSync( List<SpcAlocCtrlOptVO> spcAlocCtrlOptVO ) throws DAOException , Exception {
			int insCnt[] = null;
			try{
				SQLExecuter sqlExe = new SQLExecuter("");
				if(spcAlocCtrlOptVO.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new SpaceAllocationManageDBDAOAllocationControlDesyncUSQL(), spcAlocCtrlOptVO , null);
				}
				if( insCnt != null ){
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to Update No"+ i + " SQL");
					}
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
}