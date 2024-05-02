/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerOnOffhireDBDAO.java
*@FileTitle : ContainerOnOffhire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.07.03 이호선
* 1.0 Creation
* =======================================================
* 2010.08.20 남궁진호 / Ticket ID : CHM-201005431-01,메소드 파라메타 변경
*            searchCntrManufactureInfoListData,searchCntrManufactureInfoData 
* 2010.10.23 남궁진호 [CHM-201006507-01] EES_MST_0047 신규화면추가
*            searchCntrReeferUnitInfoListData,searchCntrReeferUnitInfoData
*            modifyCntrReeferUnitInfoData 
* 2013.03.13 채창호 [CHM-201323498-01] ALPS Maater-Status에서 SOC 장비의 OC/OP상태에서 Movement XX 처리 로직 Upgarde  요청
* 2013.06.19 채창호 [CHM-201324954-01] Master에서 SOC creation시 CTM의 OC event date 확인기능 추가                              
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.LongStayUclmDetailVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.vo.ImmediateExitCreationVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.integration.LeaseSubleaseDBDAOMstContainerVORSQL;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrMstHeadVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.ApprovalListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrLotVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureInfoVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterInquiryVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterUpdateIFVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitInfoVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrStatusCreationVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.FaCntrListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.FaTargetListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.IFGateVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.LeasedCntrVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.LostFoundVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.LotNoListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.MovementVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusHistoryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS ContainerOnOffhireDBDAO <br>
 * - ALPS-EquipmentManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Ho Sun Lee
 * @see ContainerOnOffhireBCImpl 참조
 * @since J2EE 1.6
 */
public class ContainerOnOffhireDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ees_mst_0019 : retrieve <br>
	 * Container Master Inquiry, Container Master Update를 리스트 조회처리합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0019_1
	 * @category searchCntrMasterInquiryData    
	 * @param MstEtcVO mstEtcVO
	 * @return CntrMasterInquiryVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	 public CntrMasterInquiryVO searchCntrMasterInquiryData(MstEtcVO mstEtcVO) throws DAOException {
			DBRowSet dbRowset = null;
			DBRowSet dbRowset1 = null;
			List<CntrMasterInquiryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
            String noExist = "E";
			try{
				if(mstEtcVO != null){
					Map<String, String> mapVO = mstEtcVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset1 = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchContainerExsitRSQL(), param, velParam);
				if (dbRowset1.next()){
					if (!dbRowset1.getString("CNTR_NO").equals("") || dbRowset1.getString("CNTR_NO") == null ){
						noExist ="A";
					}
				}
				    param.put("noExit", noExist);
				    velParam.put("noExit", noExist);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOsearchCntrMasterInquiryDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrMasterInquiryVO .class);
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			if (list.size() > 0)
			   return list.get(0);
			else
				return null;	
	 }
	 
	/**
	 * ees_mst_0044  : retrieve <br>
	 * Container Master Inquiry, Container Master Update를 리스트 조회처리합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0044_1
	 * @category searchCntrMasterUpdateInquiryData    
	 * @param MstEtcVO mstEtcVO
	 * @return CntrMasterInquiryVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	 public CntrMasterInquiryVO searchCntrMasterUpdateInquiryData(MstEtcVO mstEtcVO) throws DAOException {
			DBRowSet dbRowset = null;
			DBRowSet dbRowset1 = null;
			List<CntrMasterInquiryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String noExist = "E";

			try{
				if(mstEtcVO != null){
					Map<String, String> mapVO = mstEtcVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset1 = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchContainerExsitRSQL(), param, velParam);
				if (dbRowset1.next()){
					if (!dbRowset1.getString("CNTR_NO").equals("") || dbRowset1.getString("CNTR_NO") == null ){
						noExist ="A";
					}
				}
				    param.put("noExit", noExist);
				    velParam.put("noExit", noExist);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchCntrMasterUpdateInquiryRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrMasterInquiryVO .class);
				
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			if (list.size() > 0)
			     return list.get(0);
			else 
				return null;
	 }	
	 

	/**
	 * Lot No가 기존에 존재하는지 조회합니다.<br>
	 * 
     * @author J.H.Min
     * @category EES_MST_0016_02
     * @category searchCntrLotSerialRangeData
     * 
     * @param	CntrLotVO cntrLotVO
     * @return	CntrLotVO 
	 * @throws DAOException
	 */	
	public CntrLotVO searchCntrLotSerialRangeData(CntrLotVO cntrLotVO) throws DAOException 
	{	
		DBRowSet dbRowset = null;		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String lot_no = "";			
		try{			
			String lot_pln_yr = "";
			String lot_loc_cd = "";
			String cntr_tpsz_cd = "";
			String lot_seq = "";			
			
			if(cntrLotVO != null){
				Map<String, String> mapVO = cntrLotVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchCntrLotSerialRangeRSQL(), param, velParam);
			if(dbRowset.next()){
				lot_pln_yr = dbRowset.getString("LOT_PLN_YR");
				lot_loc_cd = dbRowset.getString("LOT_LOC_CD");
				cntr_tpsz_cd = dbRowset.getString("CNTR_TPSZ_CD");
				lot_seq = dbRowset.getString("LOT_SEQ");
				
				
				String lot_seq2 = lot_seq;
				if(lot_seq2.length() == 1){
					lot_seq2 = "00"+lot_seq2;
				}else if(lot_seq2.length() == 2){
					lot_seq2 = "0"+lot_seq2;				
				}

				lot_no = lot_pln_yr +"-"+
						 lot_loc_cd +"-"+
						 cntr_tpsz_cd +"-"+lot_seq2;				
			}				
			   cntrLotVO.setLotNo(lot_no);
			
		   }
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
		return cntrLotVO;
	}
		
	/**
	 * Own Container 에 대한 Lot 정보를 생성함에 있어 Last Sequence를 조회합니다.<br>
	 * 
     * @author J.H.Min
     * @category EES_MST_0016_02
     * @category searchCntrLotLastSeqData
     * 
     * @param	CntrLotVO cntrLotVO
     * @return	CntrLotVO 
	 * @throws DAOException
	 */	
	public CntrLotVO searchCntrLotLastSeqData(CntrLotVO cntrLotVO) throws DAOException 
	{
		DBRowSet dbRowset = null;		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String lot_no = "";	
		
		try{
			if(cntrLotVO != null){
				Map<String, String> mapVO = cntrLotVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchCntrLotLastSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				lot_no = dbRowset.getString("LOT_NO");
			}		
			
			 cntrLotVO.setLotNo2(lot_no);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	
		return cntrLotVO;
	}
	
	/** ees_mst_0016  : save <br>
	 * Own Container Creation (New Van) 대한 입력을 합니다.<br>
	 * 
	 * @param CntrLotVO cntrLotVO 
	 * @throws DAOException
	 */		 
	public void addCntrLotData(CntrLotVO cntrLotVO) throws DAOException,Exception 
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = cntrLotVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOAddCntrLotCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}				
	}
	
	/** ees_mst_0016  : save <br>
	 * Own Container Creation (New Van) 대한 입력을 합니다.<br>
     * 
	 * @param CntrLotVO cntrLotVO 
	 * @throws DAOException
	 */		 
	public void addOwnCntrMastersData(CntrLotVO cntrLotVO) throws DAOException,Exception 
	{	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = cntrLotVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOAddOwnCntrMastersCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}			
	}
	
	/** ees_mst_0016  : save <br>
	 * Own Container Creation (New Van) 대한 입력을 합니다.<br> 
	 * 
	 * @param CntrLotVO cntrLotVO 
	 * @throws DAOException
	 */	
	public void addOwnCntrStatusHistorysData(CntrLotVO cntrLotVO) throws DAOException,Exception 
	{	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = cntrLotVO.getColumnValues();
			
			param.putAll(mapVO);			
			param.put("fm_no", mapVO.get("lot_cntr_pfx_cd")+mapVO.get("fm_ser_no"));
			param.put("to_no", mapVO.get("lot_cntr_pfx_cd")+mapVO.get("to_ser_no"));			
			
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOAddOwnCntrStatusHistorysCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * Lot No 정보를 조회 합니다.<br>
	 * 
     * @author J.H.Min
     * @category EES_MST_0016_01
     * @category searchLotInfoData
     * 
     * @param	CntrLotVO cntrLotVO
     * @return	CntrLotVO 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CntrLotVO searchLotInfoData(CntrLotVO cntrLotVO) throws DAOException 
	{
		DBRowSet dbRowset = null;
		List<CntrLotVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cntrLotVO != null){
				Map<String, String> mapVO = cntrLotVO.getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchLotInfoRSQL(), param, velParam);			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrLotVO.class);													
			cntrLotVO = list.get(0);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntrLotVO;
	}
	
	/**
	 * MST_CNTR_LOT 테이블을 수정합니다.<br>
	 * 
	 * @author J.H.Min
     * @category EES_MST_0016_03
     * @category modifyCntrLotData
	 * 
	 * @param CntrLotVO cntrLotVO
	 * @throws DAOException
	 */	
	public void modifyCntrLotData (CntrLotVO cntrLotVO) throws DAOException,Exception 
	{	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = cntrLotVO.getColumnValues();
			
			param.putAll(mapVO);				
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrLotUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}	
	
	/**
	 * MST_CONTAINER 테이블을 수정합니다.<br>
	 * 
	 * @author J.H.Min
	 * @category EES_MST_0016_03
	 * @category modifyOwnCntrMastersData	 
	 * 
	 * @param CntrLotVO cntrLotVO
	 * @throws DAOException
	 */		
	public void modifyOwnCntrMastersData (CntrLotVO cntrLotVO) throws DAOException,Exception 
	{	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = cntrLotVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("fm_no", mapVO.get("lot_cntr_pfx_cd")+mapVO.get("fm_ser_no"));
			param.put("to_no", mapVO.get("lot_cntr_pfx_cd")+mapVO.get("to_ser_no"));
			
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyOwnCntrMastersUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}			
	}
	
	/**
	 * MST_CNTR_STS_HIS 테이블을 수정합니다. <br>
	 * 
	 * @author J.H.Min
	 * @category EES_MST_0016_03
	 * @category modifyOwnCntrStatusHistorysData	 
	 * 
	 * @param CntrLotVO cntrLotVO
	 * @throws DAOException
	 */		
	public void modifyOwnCntrStatusHistorysData (CntrLotVO cntrLotVO) throws DAOException,Exception 
	{	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = cntrLotVO.getColumnValues();
			
			param.putAll(mapVO);						
			param.put("fm_no", mapVO.get("lot_cntr_pfx_cd")+mapVO.get("fm_ser_no"));
			param.put("to_no", mapVO.get("lot_cntr_pfx_cd")+mapVO.get("to_ser_no"));
			
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyOwnCntrStatusHistorysUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}			
	}	
	
	/**
	 * 컨테이너의 Lot No를 조회합니다. <br>
	 * 
	 * @author J.H.Min
	 * @category EES_MST_0038
	 * @category searchLotNoListBrieflyData	
	 * 
	 * @param MstEtcVO mstEtcVO
	 * @return List<LotNoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LotNoListVO> searchLotNoListBrieflyData(MstEtcVO mstEtcVO) throws DAOException 
	{
		DBRowSet dbRowset = null;
		List<LotNoListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mstEtcVO != null){
				Map<String, String> mapVO = mstEtcVO.getColumnValues();			
				param.putAll(mapVO);				
	        	velParam.put("cntr_no", mstEtcVO.getCntrNo());
	        	velParam.put("de_yrmon", mstEtcVO.getDeYrmon());
	        	velParam.put("cntr_tpsz_cd", mstEtcVO.getCntrTpszCd() ); 				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchLotNoListBrieflyRSQL(), param, velParam);			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LotNoListVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/** EES_MST_0014 : retrieve <br>
	 * Leased Container를 조회합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0014_1
	 * @category searchApprovalListData    
	 * @param mstEtcVO   MstEtcVO
	 * @return List<CntrMasterInquiryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")		 
	 public List<ApprovalListVO> searchApprovalListData(MstEtcVO mstEtcVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<ApprovalListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(mstEtcVO != null){
					Map<String, String> mapVO = mstEtcVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOsearchApprovalListDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApprovalListVO .class);
				
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
	 }

	/**
	* EES_MST_0014 : save <br>
	* Leased Container를 입력데이타의 유효성(Check digit, 중복확인)을 체크합니다. <br>
	* @author LEE HO SUN
	* @category EES_MST_0014_2
	* @category validationLeasedCntrData    
	* @param List<LeasedCntrVO> leasedCntrVOs
	* @return List<LeasedCntrVO> 
	* @throws DAOException, Exception
	*/	 		 
	public List<LeasedCntrVO> validationLeasedCntrData(List<LeasedCntrVO> leasedCntrVOs) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (leasedCntrVOs != null){
			for (int i = 0; i < leasedCntrVOs.size(); i++){
				if (!leasedCntrVOs.get(i).getIbflag().equals("R")){
					if(leasedCntrVOs != null){
						Map<String, String> mapVO = leasedCntrVOs.get(i).getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOValidationLeasedCntrDataRSQL(), param, velParam);
					int rcnt = 0;
					String fcntr_no = "";
					for (int j=0; j<dbRowset.getRowCount(); j++) { 
						dbRowset.next(); 
						String resstr = dbRowset.getString("resstr");
						//rcnt 0 => check digit validation(ceflg : E)  (General만 해당)
						//     1 => cntr_no 중복(ceflg : D)             (모두해당) 						
						if (rcnt == 0) {
							fcntr_no = resstr;
							if (leasedCntrVOs.get(i).getCtype().equals("0")){
							    if (!leasedCntrVOs.get(i).getCntrNo().equals(resstr)){
							    	leasedCntrVOs.get(i).setCeflg("E");
							    	break;
							    }
							} 
							else if (leasedCntrVOs.get(i).getCtype().equals("2")){
								leasedCntrVOs.get(i).setCntrNo(fcntr_no);
							}
						} 
						else if (rcnt == 1){
							if (!resstr.equals("0"))
								leasedCntrVOs.get(i).setCeflg("D");
						}
						rcnt++;
					}
					// 값 설정
				}
			}
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return leasedCntrVOs;
	}
		
	/**
	* EES_MST_0014  : save <br>
	* Leased Container에서 입력데이타의 유효성을 체크한다.(중복 데이타 중에서 Status cd와 On Hire 확인)<br>
	* @author LEE HO SUN
	* @category EES_MST_0014_3
	* @category validationLeasedUpdateCntrData     
	* @param List<LeasedCntrVO> leasedCntrVOs
	* @return List<LeasedCntrVO>
	* @throws DAOException, Exception
	*/		
	public List<LeasedCntrVO> validationLeasedUpdateCntrData(List<LeasedCntrVO> leasedCntrVOs) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
		 if(leasedCntrVOs != null){
			for (int i = 0; i < leasedCntrVOs.size(); i++){
				if (!leasedCntrVOs.get(i).getIbflag().equals("R")){
					if(leasedCntrVOs.get(i).getCeflg().equals("D")){
						if(leasedCntrVOs != null){
							Map<String, String> mapVO = leasedCntrVOs.get(i) .getColumnValues();
						
							param.putAll(mapVO);
							velParam.putAll(mapVO);
						}
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOValidationLeasedUpdateCntrDataRSQL(), param, velParam);
						int rcnt = 0;
						for (int j=0; j<dbRowset.getRowCount(); j++) { 
							dbRowset.next(); 
							String resstr = dbRowset.getString("resstr");
							//rcnt 0 => status code 잘못됨 (eeflg : E)      (모두해당 General, W.O.Check digit, Serial Range)     
							//     1 => hire_date 잘못 등록됨(heflg : E),    (모두해당)
							if (rcnt == 0){
								if (resstr.equals("0"))
									leasedCntrVOs.get(i).setEeflg("E");
							}
							else if (rcnt == 1){
								if (resstr.equals("E"))
									leasedCntrVOs.get(i).setHeflg("E");
							}
							rcnt++;
						}
						// 값 설정
					}
				}
			}
		}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return leasedCntrVOs;				
	}
	
	/**
	* EES_MST_0014  : save <br>
	* Leased Container에서 입력데이타의 유효성을 체크한다.(Container의 sts의 마지막 update 날짜와 On hire date를 비교한다)<br>
	* @author LEE HO SUN
	* @category EES_MST_0014_4
	* @category validationLeasedUpdateCntrHisData     
	* @param List<LeasedCntrVO> leasedCntrVOs
	* @return List<LeasedCntrVO>
	* @throws DAOException, Exception
	*/		 
	public List<LeasedCntrVO> validationLeasedUpdateCntrHisData(List<LeasedCntrVO> leasedCntrVOs) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (leasedCntrVOs != null){
				for (int i = 0; i < leasedCntrVOs.size(); i++){
					if(leasedCntrVOs != null){
						Map<String, String> mapVO = leasedCntrVOs.get(i).getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOValidationLeasedUpdateCntrHisDataRSQL(), param, velParam);
					String fcntr_no = "";
					for (int j=0; j<dbRowset.getRowCount(); j++) { 
						dbRowset.next(); 
						String resstr = dbRowset.getString("resstr");
						fcntr_no = resstr;
						if (!resstr.equals("0")){
							leasedCntrVOs.get(i).setCntrUpdflg("E");
						}else{
							leasedCntrVOs.get(i).setCntrUpdflg("S");
						}
					}
				}
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return leasedCntrVOs;
	}	
		
	/**
	 * EES_MST_0014  : save <br>
     * Leased Container에서  단건의 데이터를 생성한다.<br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0014_4
	 * @category addLeasedCntrMasterData    
	 * @return int
	 * @param LeasedCntrVO leasedCntrVO
	 * @throws DAOException, Exception
	 */
	public int addLeasedCntrMasterData (LeasedCntrVO leasedCntrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;		
		try {
			if(leasedCntrVO != null){
				//seq nextval로 가져옴.
				Map<String, String> mapVO = leasedCntrVO.getColumnValues();

				param.clear();
				velParam.clear();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOAddLeasedCntrMasterDataCSQL(), param, velParam);
//				if(result == Statement.EXECUTE_FAILED){         
					//leasedCntrVO.setIeflg("E");
//					throw new DAOException("");
//				}		
			}					
		} catch (SQLException se) {
			//leasedCntrVO.setIeflg("E");
			throw new DAOException(se.getMessage());
		}catch(Exception ex){
			//leasedCntrVO.setIeflg("E");
			throw new DAOException(ex.getMessage());
		}
		return result;
	}
	
	/**
	 * EES_MST_0014  : save <br>
     * Leased Container에서  NexVal을 얻어온다.<br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0014
	 * @category searchMaxCntrStatusHistorySeqData
	 * @return String
	 * @throws DAOException, Exception
	 */
	public String searchMaxCntrStatusHistorySeqData () throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String seq_no = "";		
		try {
				//seq nextval로 가져옴.
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOGetLeasedCntrStatusHistorySequenceRSQL(), param, velParam);
				                                            
				for (int j=0; j<dbRowset.getRowCount(); j++) { 
					dbRowset.next(); 
					seq_no = dbRowset.getString("seq");
				}
		} catch (SQLException se) {
			throw new DAOException(se.getMessage());
		}catch(Exception ex){
			throw new DAOException(ex.getMessage());
		}
		return seq_no;
	}
	
	/**
	* EES_MST_0014  : save <br>
    * Leased Container에서  단건의 데이터를 수정한다. <br>
    * @author LEE HO SUN
	* @category EES_MST_0014_5
	* @category modifyLeasedCntrMasterData     
	* @param LeasedCntrVO leasedCntrVO
	* @return int
	* @throws DAOException, Exception
	*/
	public int modifyLeasedCntrMasterData(LeasedCntrVO leasedCntrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			
			//seq nextval로 가져옴.
			Map<String, String> mapVO = leasedCntrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyLeasedCntrMasterDataUSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//				throw new DAOException("");
		} catch (SQLException se) {
			throw new DAOException(se.getMessage());
		}catch(Exception ex){
			throw new DAOException(ex.getMessage());
		}  
		return result;
	}
	
	/**
	* EES_MST_0014  : save <br>
    * Leased Container에서  단건의 이력 데이터를 등록한다. <br>
    * @author LEE HO SUN
	* @category EES_MST_0014_6
	* @category addLeasedCntrStatusHistoryData    
	* @param LeasedCntrVO leasedCntrVO
	* @return int
	* @throws DAOException
	*/		
	public int addLeasedCntrStatusHistoryData(LeasedCntrVO leasedCntrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;		
		try {
			if(leasedCntrVO != null){
				Map<String, String> mapVO = leasedCntrVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOAddLeasedCntrStatusHistoryDataCSQL(), param, velParam);
//				if(result == Statement.EXECUTE_FAILED){
					//leasedCntrVO.setIeflg("E");
//					throw new DAOException("");
//				}
			}
		} catch (SQLException se) {
			//leasedCntrVO.setIeflg("E");
			throw new DAOException(se.getMessage());
		}catch(Exception ex){
			//leasedCntrVO.setIeflg("E");
			throw new DAOException(ex.getMessage());
		}
		return result;
	}
	
	/**
	* ees_mst_0044 : save <br>
	* Container Master Update를 수정한다. <br>
    * @author LEE HO SUN
	* @category EES_MST_0044_1
	* @category modifyCntrMasterData     
	* @param MstEtcVO mstEtcVO
	* @throws DAOException, Exception
	*/
	public void modifyCntrMasterData(MstEtcVO mstEtcVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = mstEtcVO.getColumnValues();
			
			param.putAll(mapVO);						

			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrMasterDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}				
	}				 		

	 /** EES_MST_0025 : Save<br>
	 * 해당 컨테이너의 장비 상태(Movement,Status) 정보를 조회한다.<br>
	 * 
     * @author J.H.Min
     * @category EES_MST_0025
     * @category searchLostFoundListData
	 * 
	 * @param List<LostFoundVO> lostFoundVOs
	 * @return List<LostFoundVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	 public List<LostFoundVO> searchLostFoundListData(List<LostFoundVO> lostFoundVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<LostFoundVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(lostFoundVOs.size() > 0){				
				for(int i=0; i<lostFoundVOs.size(); i++){
					Map<String, String> mapVO = lostFoundVOs.get(i).getColumnValues(); 
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchLostFoundListDataRSQL(), param, velParam);
						
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, LostFoundVO.class);
					if(list.size() > 0){
						lostFoundVOs.set(i, list.get(0));
					}
				}					
			}												
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return lostFoundVOs;
	 }		
	 
	/**
	* EES_MST_0024 : retrieve <br>
	* Container Status Creation(SBI, SBO, MUO)을 조회합니다. <br>
    * @author LEE HO SUN
	* @category EES_MST_0024_1
	* @category searchLeaseOutTargetListData  
	* @param List<CntrStatusCreationVO> cntrStatusCreationVOs
	* @return List<CntrStatusCreationVO>
	* @throws DAOException, Exception
	*/
	@SuppressWarnings("unchecked")
	 public List<CntrStatusCreationVO> searchLeaseOutCntrStatusData(List<CntrStatusCreationVO> cntrStatusCreationVOs) throws DAOException {
			DBRowSet dbRowset = null;
			List<CntrStatusCreationVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(cntrStatusCreationVOs.size() > 0){
					for(int i=0; i<cntrStatusCreationVOs.size(); i++){

						Map<String, String> mapVO = cntrStatusCreationVOs.get(i).getColumnValues(); 
						
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOsearchLeaseOutCntrStatusDataRSQL(), param, velParam);
							
						list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrStatusCreationVO.class);
						if(list.size() > 0){
							cntrStatusCreationVOs.set(i, list.get(0));
						}
					
					}
				}
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return cntrStatusCreationVOs;
	 }
	
	/**
	* EES_MST_0024 : retrieve <br>
	* Container Status Creation(LSO)을 조회합니다. <br>
    * @author LEE HO SUN
	* @category EES_MST_0024
	* @category searchLeaseOutTargetListData  
	* @param CntrStatusCreationVO cntrStatusCreationVO
	* @return List<CntrStatusCreationVO>
	* @throws DAOException, Exception
	*/	
	@SuppressWarnings("unchecked")
	public List<CntrStatusCreationVO> searchLeaseOutTargetListData(CntrStatusCreationVO cntrStatusCreationVO) throws DAOException {
	    DBRowSet dbRowset = null;
		List<CntrStatusCreationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cntrStatusCreationVO != null){
				Map<String, String> mapVO = cntrStatusCreationVO.getColumnValues(); 
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchLeaseOutTargetListOfLSODataRSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrStatusCreationVO.class);
			}												
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	* EES_MST_0024 : retrieve <br>
	* Container Status Creation(MUI)을 조회합니다. <br>
    * @author LEE HO SUN
	* @category EES_MST_0024
	* @category searchLeaseOutTargetListData  
	* @param List<CntrStatusCreationVO> cntrStatusCreationVOs
	* @return List<CntrStatusCreationVO>
	* @throws DAOException, Exception
	*/	
	@SuppressWarnings("unchecked")
	public List<CntrStatusCreationVO> searchMisUseOutTargetListData(List<CntrStatusCreationVO> cntrStatusCreationVOs) throws DAOException {
	    DBRowSet dbRowset = null;
		List<CntrStatusCreationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cntrStatusCreationVOs.size() > 0){
				for(int i=0; i<cntrStatusCreationVOs.size(); i++){

					Map<String, String> mapVO = cntrStatusCreationVOs.get(i).getColumnValues(); 
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOsearchMisUseOutTargetListDataRSQL(), param, velParam);
						
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrStatusCreationVO.class);
					if(list.size() > 0){
						cntrStatusCreationVOs.set(i, list.get(0));
					}
				
				}
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntrStatusCreationVOs;
	}	
	 
	/**
	 * EES_MST_0024 : save <br>
	 * Container Status Creation을 수정합니다. <br>
     * @author LEE HO SUN
	 * @category EES_MST_0024_2
	 * @category modifyCntrMasterByLastStatusData   
	 * @param CntrStatusCreationVO cntrStatusCreationVO
	 * @return int
	 * @throws DAOException, Exception
	 */
	public int modifyCntrMasterByLastStatusData(CntrStatusCreationVO cntrStatusCreationVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			//seq nextval로 가져옴.
			Map<String, String> mapVO = cntrStatusCreationVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrMasterStatusDataUSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//				throw new DAOException("");				
		} catch (SQLException se) {
			throw new DAOException(se.getMessage());
		}catch(Exception ex){
			throw new DAOException(ex.getMessage());
		}
		return result;
	}
	
	/**
	 * EES_MST_0024 : save <br>
	 * Container Status Creation에서 History를 등록한다. <br> 
     * Insert시 에러 발생 할 경우 exception 처리 안함. 에러 flag 이용 화면에서 메시지 처리 <br>
     * @author LEE HO SUN
	 * @category EES_MST_0024_3
	 * @category addCntrStatusHistorysData    
	 * @param CntrStatusCreationVO cntrStatusCreationVO
	 * @return int
	 * @throws DAOException, Exception
	 */
	public int addCntrStatusHistorysData(CntrStatusCreationVO cntrStatusCreationVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			//seq nextval로 가져옴.
			Map<String, String> mapVO = cntrStatusCreationVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOAddCntrMasterStatusHisDataCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//				throw new DAOException("");
		}catch (SQLException se) {
			throw new DAOException(se.getMessage());			
		}catch(Exception ex){
			throw new DAOException(ex.getMessage());
		}
		return result;
	}
	
	/**
	* EES_MST_0024 : save <br>
	* Container Status Creation에서 저장시 입력데이타의 유효성을 체크한다.<br>
	* 1.Pre Status Check <br>
	* 2.Input Yard와 movement yard가 서로 다르면 error message 처리 <br>
	* 3.Input date가 movement date보다 크거나 같아야 하며, 그외는 error message 처리 <br>
	* 4.LSO 경우 MVMT Status 가 ‘MT’, ‘XX’ , ‘ID’, ‘TN’ 가 아니면 에러 <br>
    * @author LEE HO SUN
	* @category EES_MST_0024_4
	* @category validationCurrentStatusData     
	* @param CntrStatusCreationVO cntrStatusCreationVO
	* @return CntrStatusCreationVO 
	* @throws DAOException, Exception
	*/		
	public CntrStatusCreationVO validationCurrentStatusData(CntrStatusCreationVO cntrStatusCreationVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
				if(cntrStatusCreationVO != null){
					Map<String, String> mapVO = cntrStatusCreationVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOValidationCurrentStatusDataRSQL(), param, velParam);
				int rcnt = 0;
				for (int j=0; j<dbRowset.getRowCount(); j++) { 
					dbRowset.next(); 
					String resstr = dbRowset.getString("resstr");
					String resstr1 = dbRowset.getString("resstr1");
					
					//1.Pre Status Check
					//2.Input Yard와 movement yard가 서로 다르면 error message 처리
					//3.Input date가 movement date보다 크거나 같아야 하며, 그외는 error message 처리
					
					if (rcnt == 0){
						if (resstr.equals("0"))
							cntrStatusCreationVO.setAeflg("E");
					}
					else if (rcnt == 1){
						if(!cntrStatusCreationVO.getStCd().equals("2") && !cntrStatusCreationVO.getStCd().equals("4")){ 
							if (!resstr.equals("1"))
								cntrStatusCreationVO.setBeflg("E");
						}
						if (!resstr1.equals("0"))
							cntrStatusCreationVO.setCeflg("E");
					}
					else if (rcnt == 2){
						if(cntrStatusCreationVO.getStCd().equals("1") || cntrStatusCreationVO.getStCd().equals("3")){
							if (resstr.equals("0"))
								cntrStatusCreationVO.setFeflg("E");
						}
					}
					if (cntrStatusCreationVO.getStCd().equals("7")){
						if (rcnt == 3){
							if (resstr.equals("0")){
									cntrStatusCreationVO.setTeflg("E");
							}
						}
					   if (rcnt == 4){
							if (!(resstr.equals("1") && resstr1.equals("1"))){
								cntrStatusCreationVO.setSeflg("E");
							}
					   }
					}
					rcnt++;
					
				}
			
				//4.LSO 경우 MVMT Status 가 ‘MT’, ‘ID’, ‘EN’, ‘TN’ 가 아니면 에러	
				if(cntrStatusCreationVO.getStCd().equals("0") && 
				  !(cntrStatusCreationVO.getCnmvStsCd().equals("MT") ||
				   cntrStatusCreationVO.getCnmvStsCd().equals("ID") ||
				   cntrStatusCreationVO.getCnmvStsCd().equals("EN") ||
				   cntrStatusCreationVO.getCnmvStsCd().equals("TN"))){
				   cntrStatusCreationVO.setDeflg("E");
				}
				if(cntrStatusCreationVO.getStCd().equals("1") &&
				   !cntrStatusCreationVO.getCnmvStsCd().equals("MT")){
				   cntrStatusCreationVO.setEeflg("E");
				}
				
				}	
						
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
		return cntrStatusCreationVO;
	}
	
	 /**
	 * EES_MST_0017  : retrieve<br>
	 * Own Container Interface to ERP FA를 조회합니다. <br>
     * @author LEE HO SUN
	 * @category EES_MST_0017_1
	 * @category searchFATargetListData      
	 * @param MstEtcVO mstEtcVO
	 * @return List<FaTargetListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")		 
	 public List<FaTargetListVO> searchFATargetListData(MstEtcVO mstEtcVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<FaTargetListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(mstEtcVO != null){
					Map<String, String> mapVO = mstEtcVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchFATargetListDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, FaTargetListVO .class);
				
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
	 }	
	
	/**
	 * EES_MST_0017  : save <br>
	 * Own Container Interface to ERP FA를 다중 등록 합니다. <br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0017_2
	 * @category modifyCntrMastersSendToFAData
	 * @param List<FaTargetListVO> faTargetListVOs
	 * @return List<FaTargetListVO>
	 * @throws DAOException, Exception
	 */
	public List<FaTargetListVO> modifyCntrMastersSendToFAData(List<FaTargetListVO> faTargetListVOs) throws DAOException,Exception {
		int[] updCnt = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(faTargetListVOs.size() > 0){
				velParam.put("hid_type",faTargetListVOs.get(0).getHidType());
			
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrMastersSendToFADataUSQL(), faTargetListVOs, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
			return faTargetListVOs;
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}				
//		try {
//			int updCnt = 0;
//			if (faTargetListVOs != null){
//				if(faTargetListVOs.size() > 0){
//					for(int i = 0; i < faTargetListVOs.size(); i++){
//						updCnt = modifyCntrMastersSendToFASubData(faTargetListVOs.get(i));
//						
//						if(updCnt== Statement.EXECUTE_FAILED)
//						{
//							throw new DAOException("Fail to Update No"+ i + " SQL");
//						}					
//					}
//				}
//			}
//			return faTargetListVOs;
//		} catch (SQLException se) {
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}	
	}
	
	/**
	 * EES_MST_0017  : save <br>
	 * Own Container Interface to ERP FA에서 마스터 데이터를 등록 합니다. <br>  
	 * @author LEE HO SUN
	 * @category EES_MST_0017_3
	 * @category modifyCntrMastersSendToFASubData 
	 * @param FaTargetListVO faTargetListVO
	 * @return int
	 * @throws DAOException, Exception
	 */	
//	 private int modifyCntrMastersSendToFASubData(FaTargetListVO faTargetListVO) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();			
//	
//		int result = 0;		
//		try {
//
//			Map<String, String> mapVO = faTargetListVO.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrMastersSendToFADataUSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to Update SQL");		
//		} catch (SQLException se) {
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}		
//		return result;		
//	}
	
	/**
	 * EES_MST_0017  : save <br>
	 * Own Container Interface to ERP FA에서 Lot 데이터를 등록 합니다. <br>   
	 * @author LEE HO SUN
	 * @category EES_MST_0017_4
	 * @category modifyCntrLotsFAInterfaceData  
	 * @param List<FaTargetListVO> faTargetListVOs
	 * @throws DAOException, Exception
	 */
	public void modifyCntrLotsFAInterfaceData(List<FaTargetListVO> faTargetListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(faTargetListVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrLotsFAInterfaceDataUSQL(), faTargetListVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * ees_mst_0017  : save <br>
	 * Own Container Interface to ERP FA에서 Term Cng 데이터를 등록 합니다. <br>    
	 * @author LEE HO SUN
	 * @category EES_MST_0017_5
	 * @category modifyCntrTermChangesFAInterfaceData   
	 * @param List<FaTargetListVO> faTargetListVOs
	 * @throws DAOException, Exception
	 */
	public void modifyCntrTermChangesFAInterfaceData(List<FaTargetListVO> faTargetListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(faTargetListVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrTermChangesFAInterfaceDataUSQL(), faTargetListVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * EES_MST_0017  : save <br>
	 * Own Container Interface to ERP FA에서 주어진 조건의 EAI 연계를 위한 준비데이타를 조회한다.<br>   
	 * @author LEE HO SUN
	 * @category EES_MST_0017_6
	 * @category searchCntrToFAData    
	 * @param FaTargetListVO faTargetListVO
	 * @return List<FaCntrListVO>
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<FaCntrListVO> searchCntrToFAData(FaTargetListVO faTargetListVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<FaCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(faTargetListVO != null){
				Map<String, String> mapVO = faTargetListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSelectSendEaiCntrListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FaCntrListVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	/**
	 * ees_mst_0017  : save <br>
	 * Own Container Interface to ERP FA에서 주어진 조건의 EAI 연계를 위한 GROUP Seq.를 조회한다.<br>   
	 * @author LEE HO SUN
	 * @category EES_MST_0017_7
	 * @category searchFAGrpSeqNoData  
	 * @param FaTargetListVO faTargetListVO
	 * @return String
	 * @throws DAOException, Exception
	 */
	public String searchFAGrpSeqNoData(FaTargetListVO faTargetListVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String strReturn = "";

		try{
			if(faTargetListVO != null){
				Map<String, String> mapVO = faTargetListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchFAGrpSeqNoDataRSQL(), param, velParam);
			
			for (int i=0; i<dbRowset.getRowCount(); i++) {
				dbRowset.next();
				strReturn = dbRowset.getString("GRP_SEQ_NO");
			}			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;		
	}	 
	
	 /** EES_MST_0025 : Save<br>
	 * 해당 컨테이너의 장비 상태(Movement,Status) 정보를 수정한다.<br>
	 * 
	 * @author J.H.Min
	 * @category EES_MST_0025
	 * @category modifyCntrMasterByLostFoundData
	 * @param List<LostFoundVO> lostFoundVOs
	 * @throws DAOException
	 */		 
	 public void modifyCntrMasterByLostFoundData(List<LostFoundVO> lostFoundVOs) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{						
			for(int i=0; i<lostFoundVOs.size(); i++){
				Map<String, String> mapVO = lostFoundVOs.get(i).getColumnValues(); 
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrMasterByLostFoundDataUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}																	
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	 }		 
	 
	 /** EES_MST_0025 : Save<br>
	 * 해당 컨테이너의 장비 상태(Movement,Status) 정보를 입력한다.<br>
	 * 
	 * @author J.H.Min
	 * @category EES_MST_0025
	 * @category addCntrStatusHistorysByLostFoundData
	 * @param List<LostFoundVO> lostFoundVOs
	 * @throws DAOException
	 */		 
	 public void addCntrStatusHistorysByLostFoundData(List<LostFoundVO> lostFoundVOs) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{						
			for(int i=0; i<lostFoundVOs.size(); i++){
				Map<String, String> mapVO = lostFoundVOs.get(i).getColumnValues(); 
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOAddCntrStatusHistorysByLostFoundDataCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}																	
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	 }			 	
	 
	/**
	 * Immediate Exit Creation 대상 장비목록을 일괄 갱신합니다.<br>
	 * 
	 * @param List<ImmediateExitCreationVO> immediateExitCreationVOs
	 * @throws DAOException, Exception
	 */
	public void modifyCntrImdtExitData(List<ImmediateExitCreationVO> immediateExitCreationVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(immediateExitCreationVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrImdtExitDataUSQL(), immediateExitCreationVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * Term Change Creation 대상 장비목록을 일괄 저장합니다.(DI FLG가 Y인 경우)<br>
	 * 
	 * @param List<TermChangeCreationVO> termChangeListSearchVOs
	 * @throws DAOException, Exception
	 */	
	public void addTermChangeCntrStatusHistoryDiFlgYData(List<TermChangeCreationVO> termChangeListSearchVOs ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(termChangeListSearchVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOAddTermChangeCntrStatusHistoryDiFlgYDataCSQL(), termChangeListSearchVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}	
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}				
	}	
	
	/**
	 * Term Change Creation 대상 장비목록을 일괄 저장합니다.(Di Flg가 N이고 Cntr Status Code가 SBO가 아닌경우)<br>
	 * 
	 * @param List<TermChangeCreationVO> termChangeListSearchVOs
	 * @throws DAOException, Exception
	 */	
	public void addTermChangeCntrStatusHistoryDiFlgNData(List<TermChangeCreationVO> termChangeListSearchVOs ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(termChangeListSearchVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOAddTermChangeCntrStatusHistoryDiFlgNDataCSQL(), termChangeListSearchVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}	
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}				
	}	
	
	/**
	 * Term Change Creation 대상 장비목록을 일괄 저장합니다.(DI FLG='N' AND STSTUS CODE='SBO' 경우 Term Change 정보)<br>
	 * 
	 * @param List<TermChangeCreationVO> termChangeListSearchVOs
	 * @throws DAOException, Exception
	 */	
	public void addTermChangeCntrStatusHistoryDiFlgNSBOData(List<TermChangeCreationVO> termChangeListSearchVOs ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(termChangeListSearchVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOAddTermChangeCntrStatusHistoryDiFlgNSBODataCSQL(), termChangeListSearchVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}	
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}				
	}	
	
	/**
	 * Term Change Creation 대상 장비목록을 일괄 저장합니다.<br>
	 * 
	 * @param List<TermChangeCreationVO> termChangeListSearchVOs
	 * @throws DAOException, Exception
	 */
	public void modifyCntrMasterByTermChangeData(List<TermChangeCreationVO> termChangeListSearchVOs ) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(termChangeListSearchVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrMasterByTermChangeDataUSQL(), termChangeListSearchVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	 /**
	 * Term Change Creation 대상 장비목록을 일괄 저장합니다.<br>
	 * 
	 * @param List<TermChangeCreationVO> termChangeListSearchVOs 
	 * @throws DAOException
	 */		 
	 public void addTermChangeData(List<TermChangeCreationVO> termChangeListSearchVOs) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{						
            if(termChangeListSearchVOs.size() >0){	
                       	
				Map<String, String> mapVO = termChangeListSearchVOs.get(0).getColumnValues(); 
				
				String sSeqSet = termChangeListSearchVOs.get(0).getSeqSet();				
			
				List<String> seqSetList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(sSeqSet.trim(), "*");
				
		        while (st.hasMoreTokens()) {
		        	seqSetList.add(st.nextToken());
		        }				
				
				velParam.put("vel_seq_set", seqSetList);				
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOAddTermChangeDataCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}																	
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	 }
	 		 
	/**
	 * EES_MST_0028 : retrieve <br>
	 * Container Status Update에서 일반적인 cntr 정보를 조회합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0028_1
	 * @category searchCntrStatusUpdateMasterData     
	 * @param MstEtcVO mstEtcVO
	 * @return CntrMstHeadVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CntrMstHeadVO searchCntrStatusUpdateMasterData(MstEtcVO mstEtcVO) throws DAOException 
	{
		DBRowSet dbRowset = null;
		DBRowSet dbRowset1 = null;
		List<CntrMstHeadVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String noExist = "E";
		try{
			if(mstEtcVO != null){
				Map<String, String> mapVO = mstEtcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset1 = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchContainerExsitRSQL(), param, velParam);
			if (dbRowset1.next()){
				if (!dbRowset1.getString("CNTR_NO").equals("") || dbRowset1.getString("CNTR_NO") == null ){
					noExist ="A";
					}
			}
			param.put("noExit", noExist);
		    velParam.put("noExit", noExist);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseSubleaseDBDAOMstContainerVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrMstHeadVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0){
		   return list.get(0);
		}   
		else {
		   return null;
		}   
	}
	 
	/**
	 * EES_MST_0028 : save <br>
	 * Container Status Update에서 주어진 조건의 History 데이터를 수정한다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0028_2
	 * @category modifyCntrStatusHistoryByUpdateData      
	 * @param StatusHistoryVO statusHistoryVO
	 * @return StatusHistoryVO
	 * @throws DAOException, Exception
	 */	
	public StatusHistoryVO modifyCntrStatusHistoryByUpdateData(StatusHistoryVO statusHistoryVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
	
		int result = 0;		
		try {

			Map<String, String> mapVO = statusHistoryVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrStatusHistoryByUpdateDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");		
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
		return statusHistoryVO;		
	} 
	
	/**
	 * EES_MST_0028 : save <br>
	 * Container Status Update에서 주어진 조건의  Master 데이터를 수정한다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0028_3
	 * @category modifyCntrMasterByUpdateData    
	 * @param StatusHistoryVO statusHistoryVO
	 * @return StatusHistoryVO
	 * @throws DAOException, Exception
	 */	
	public StatusHistoryVO modifyCntrMasterByUpdateData(StatusHistoryVO statusHistoryVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
	
		int result = 0;		
		try {

			Map<String, String> mapVO = statusHistoryVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrMasterByUpdateDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");		
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
		return statusHistoryVO;		
	}	
	 
	
	/**
	 * EES_MST_0028 : save <br>
	 * Container Status Update에서 Container Movement 정보를 조회합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0028
	 * @category searchCntrStatusUpdateMovementData      
	 * @param MstEtcVO mstEtcVO
	 * @return List<MovementVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MovementVO> searchCntrStatusUpdateMovementData(MstEtcVO mstEtcVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		DBRowSet dbRowset1 = null;
		List<MovementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String noExist = "E";
		try{
			if(mstEtcVO != null){
				Map<String, String> mapVO = mstEtcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset1 = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchContainerExsitRSQL(), param, velParam);
			if (dbRowset1.next()){
				if (!dbRowset1.getString("CNTR_NO").equals("") || dbRowset1.getString("CNTR_NO") == null ){
					noExist ="A";
				}
			}
			    param.put("noExit", noExist);
			    velParam.put("noExit", noExist);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchCntrStatusUpdateMovementDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MovementVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}	 
	 
	/**
	 * EES_MST_0028 : retrieve <br>
	 * Container Status Update에서 Container StatusContainer Status 정보를 조회합니다.<br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0028
	 * @category searchCntrStatusUpdateHistoryData     
	 * @param MstEtcVO mstEtcVO
	 * @return List<StatusHistoryVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<StatusHistoryVO> searchCntrStatusUpdateHistoryData(MstEtcVO mstEtcVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		DBRowSet dbRowset1 = null;
		List<StatusHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String noExist = "E";
		
		try{
			if(mstEtcVO != null){
				Map<String, String> mapVO = mstEtcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset1 = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchContainerExsitRSQL(), param, velParam);
			if (dbRowset1.next()){
				if (!dbRowset1.getString("CNTR_NO").equals("") || dbRowset1.getString("CNTR_NO") == null ){
					noExist ="A";
					}
			}
			param.put("noExit", noExist);
			velParam.put("noExit", noExist);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchCntrStatusUpdateHistoryDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StatusHistoryVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}

	/**
	 * CIM/CTM 에서 요청한 Master 정보를 수정합니다.<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @throws DAOException
	 */
	public void modifyCntrMasterByMvmtData(CusCtmMovementVO cusCtmMovementVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrMasterByMvmtDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		

	/**
	 * On hire Approval  된 OW Term 컨테이너에 Approval Number 를 Update 시킨다.<br>
	 * 
	 * @param List<OnhireApprovalOwnListVO> onhireApprovalOwnListVOs
	 * @throws DAOException, Exception
	 */
	public void modifyAuthNoCntrMasterData(List<OnhireApprovalOwnListVO> onhireApprovalOwnListVOs ) throws DAOException,Exception {
		try {			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(onhireApprovalOwnListVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOModifyAuthNoCntrMasterDataUSQL(), onhireApprovalOwnListVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * On hire Approval  된 OW Term 컨테이너에 Approval Number 를 Update 시킨다.<br>
	 * 
	 * @param List<OnhireApprovalOwnListVO> onhireApprovalOwnListVOs
	 * @throws DAOException, Exception
	 */
	public void modifyAutnNoCntrStatusHistoryData(List<OnhireApprovalOwnListVO> onhireApprovalOwnListVOs ) throws DAOException,Exception {
		try {			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(onhireApprovalOwnListVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOModifyAutnNoCntrStatusHistoryDataUSQL(), onhireApprovalOwnListVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}	
		
	/**
	 * CTM 에서 요청한 ID/XX 처리에 대한 LSO 정보를 생성한다.<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @throws DAOException
	 */	
	public void addCntrStatusHistoryByMvmtData(CusCtmMovementVO cusCtmMovementVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOAddCntrStatusHistoryByMvmtDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CTM 에서 SH 장비인 경우이면서 MOVEMENT에서 XX를 삭제,LSO데이타 삭제 후 
	 * 또는 LSI, LSO 삭제 후 마스터 정리위해 호출<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @throws DAOException
	 */	
	public void modifyCntrMasterByMvmtDeleteData(CusCtmMovementVO cusCtmMovementVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOmodifyCntrMasterByMvmtDeleteDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	/**
	 * CTM 에서 요청한 신조 인수/취소시 HISTORY 정보를 수정한다.<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @throws DAOException
	 */	
	public void modifyCntrStatusHistoryByMvmtData(CusCtmMovementVO cusCtmMovementVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOmodifyCntrStatusHistoryByMvmtDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Fns0260001 : save <br> 
	 * F/A IF EAI 연계에서 Receive Master를 주어진 데이타로 수정한다.<br>
	 * @author LEE HO SUN
	 * @category Fns0260001_01
	 * @category modifyCntrMastersReceiveFAData      
	 * @param List<CntrMasterUpdateIFVO> cntrMasterUpdateIFVOs
	 * @throws DAOException
	 * @throws Exception 
	 */	
	public void modifyCntrMastersReceiveFAData(List<CntrMasterUpdateIFVO> cntrMasterUpdateIFVOs) throws DAOException,Exception {
		int[] updCnt = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(cntrMasterUpdateIFVOs.size() > 0){
				velParam.put("gubun",cntrMasterUpdateIFVOs.get(0).getGubun());
			
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrMastersReceiveFADataUSQL(), cntrMasterUpdateIFVOs, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}				
    }
	
	/**
	 * Fns0260001 : save <br> 
	 * F/A IF EAI 연계에서 Receive Master를 주어진 데이타로 수정한다.<br>
	 * @author LEE HO SUN
	 * @category Fns0260001_02
	 * @category modifyCntrMastersReceiveFASubData     
	 * @param CntrMasterUpdateIFVO cntrMasterUpdateIFVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */	
//	private int modifyCntrMastersReceiveFASubData(CntrMasterUpdateIFVO cntrMasterUpdateIFVO) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();			
//	
//		int result = 0;		
//		try {
//
//			Map<String, String> mapVO = cntrMasterUpdateIFVO.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrMastersReceiveFADataUSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to Update SQL");		
//		} catch (SQLException se) {
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}		
//		return result;		
//	}	
	
	/**
	 * Fns0260001 : save <br> 
	 * F/A IF EAI 연계에서 Receive Lot를 주어진 데이타로 수정한다.<br> 
	 * @author LEE HO SUN
	 * @category Fns0260001_04
	 * @category modifyCntrLotsFAReceiveData   
	 * @param CntrMasterUpdateIFVO cntrMasterUpdateIFVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */	
	 public int modifyCntrLotsFAReceiveData(CntrMasterUpdateIFVO cntrMasterUpdateIFVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
	
		int result = 0;		
		try {

			Map<String, String> mapVO = cntrMasterUpdateIFVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrLotsFAReceiveDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");		
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
		return result;		
	}		
	
	/**
	 * Fns0260001 : save <br> 
	 * F/A IF EAI 연계에서 Receive Term Change를 주어진 데이타로 수정한다.<br> 	  
	 * @author LEE HO SUN
	 * @category Fns0260001_06
	 * @category modifyCntrTermChangesFAReceiveData   
	 * @param CntrMasterUpdateIFVO cntrMasterUpdateIFVO
	 * @return int
	 * @throws DAOException, Exception
	 */	
	public int modifyCntrTermChangesFAReceiveData(CntrMasterUpdateIFVO cntrMasterUpdateIFVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();			
	
		int result = 0;		
		try {

			Map<String, String> mapVO = cntrMasterUpdateIFVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrTermChangesFAReceiveDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");		
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
		return result;		
	}	
	
	/**
	 * Miss Use Approval 된 컨테이너르 Status를 추가시킨다.<br>
	 * 
	 * @param List<IFMnrFlagVO> iFMnrFlagVOs
	 * @throws DAOException, Exception
	 */
	public void modifyCntrMasterByMNRFlaggingData(List<IFMnrFlagVO> iFMnrFlagVOs ) throws DAOException,Exception {
		try {			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(iFMnrFlagVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrMasterByMNRFlaggingDataUSQL(), iFMnrFlagVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Fns026R001 : Receive <br> 
	 * F/A IF EAI 연계에서 Receive Count를 주어진 데이타로 조회한다.<br> 	  
	 * @author LEE HO SUN
	 * @category Fns0260001_07
	 * @category checkCountReceiveFAData   
	 * @param CntrMasterUpdateIFVO cntrMasterUpdateIFVO
	 * @return String
	 * @throws DAOException, Exception
	 */		
	public String checkCountReceiveFAData(CntrMasterUpdateIFVO cntrMasterUpdateIFVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String strReturn = "";
		try {
			Map<String, String> mapVO = cntrMasterUpdateIFVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOCheckCountReceiveFADataRSQL(), param, velParam);
			for (int i=0; i<dbRowset.getRowCount(); i++) {
				dbRowset.next();
				strReturn = dbRowset.getString("CNT");
			}
			
			/*if (!strEReturn.equals("0")){
				strReturn = "E";
			}*/
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}
	
	/**
	 * Fns026R001 : Receive <br> 
	 * F/A IF EAI 연계에서 Receive Error Count를 주어진 데이타로 조회한다.<br> 	  
	 * @author LEE HO SUN
	 * @category Fns0260001_07
	 * @category checkErrorCountReceiveFAData   
	 * @param CntrMasterUpdateIFVO cntrMasterUpdateIFVO
	 * @return String
	 * @throws DAOException, Exception
	 */		
	public String checkErrorCountReceiveFAData(CntrMasterUpdateIFVO cntrMasterUpdateIFVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String strEReturn = "";
		try {
			Map<String, String> mapVO = cntrMasterUpdateIFVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOCheckCountReceiveFAErrDataRSQL(), param, velParam);
			for (int i=0; i<dbRowset.getRowCount(); i++) {
				dbRowset.next();
				strEReturn = dbRowset.getString("ECNT");
			}			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strEReturn;
	}		
	
	/**
	 * CTM 에서 요청한 Master 정보를 수정한다.<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @throws DAOException
	 */	
	public void modifyCntrMasterByOnOffHireData(CusCtmMovementVO cusCtmMovementVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOModifyCntrMasterByOnOffHireDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 장기체화장비(L/Staying) 및 Unclaim 장비 Flag 와 해소 방안을 등록한다.<br>
	 * 
	 * @param List<LongStayUclmDetailVO> longStayUclmDetailVOs
	 * @throws DAOException
	 */
	public void modifyCntrMasterByLongStayCreationData(List<LongStayUclmDetailVO> longStayUclmDetailVOs) throws DAOException,Exception
	{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updateCnt[] = null;
			if(longStayUclmDetailVOs.size() > 0){
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOupdateCntrMasterByLongStayCreationBasicUSQL(), longStayUclmDetailVOs,null);
				for(int i = 0; i < updateCnt.length; i++){
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Container Status History를 저장합니다.<br>
	 *
	 * @param IFMnrFlagVO iFMnrFlagVO
	 * @throws DAOException
	 */	
	public void addCntrStatusHistorysByMNRStatusData(IFMnrFlagVO iFMnrFlagVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = iFMnrFlagVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAOAddCntrStatusHistorysByMNRStatusDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
	
	/**
	 * Container Status History를 삭제합니다.<br>
	 *
	 * @param StatusHistoryVO statusHistoryVO
	 * @throws DAOException
	 */	
	public void removeMstCntrStsHisData(StatusHistoryVO statusHistoryVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = statusHistoryVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAORemoveMstCntrStsHisDataDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * EES_MST_0046 : retrieve <br>
	 * Manufacture Date & Manufacturer Inquiry and Update를 조회합니다.<br>	 
	 * @author LEE HO SUN
	 * @category EES_MST_0046
	 * @category searchCntrManufactureInfoListData     
	 * @param CntrManufactureListVO cntrManufactureListVO
	 * @return List<CntrManufactureInfoVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CntrManufactureInfoVO> searchCntrManufactureInfoListData(CntrManufactureListVO cntrManufactureListVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CntrManufactureInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cntrManufactureListVO != null){
				Map<String, String> mapVO = cntrManufactureListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOsearchCntrManufactureInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrManufactureInfoVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	/**
	 * EES_MST_0046 : retrieve <br>
	 * Manufacture Date & Manufacturer Inquiry and Update를 조회합니다.<br>	 
	 * @author LEE HO SUN
	 * @category EES_MST_0046
	 * @category searchCntrManufactureInfoData     
	 * @param CntrManufactureListVO[] cntrManufactureListVOs
	 * @return List<CntrManufactureInfoVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CntrManufactureInfoVO> searchCntrManufactureInfoData(CntrManufactureListVO[] cntrManufactureListVOs) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CntrManufactureInfoVO> list = null;
		List<CntrManufactureInfoVO> listTmp = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(cntrManufactureListVOs != null){
				
				list = new ArrayList<CntrManufactureInfoVO>();
				for(int i = 0; i < cntrManufactureListVOs.length; i++){
					Map<String, String> mapVO = cntrManufactureListVOs[i] .getColumnValues();					
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOsearchCntrManufactureInfo2RSQL(), param, velParam);
					listTmp = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrManufactureInfoVO .class);
					if (listTmp.size() > 0){
					   list.addAll(listTmp);
					}
				}
			}	
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * EES_MST_0046 : save <br>
	 * Manufacture Date & Manufacturer Inquiry and Update를 수정합니다.<br>	 
	 * @author LEE HO SUN
	 * @category EES_MST_0046
	 * @category modifyCntrManufactureInfoData     
	 * @param List<CntrManufactureInfoVO> cntrManufactureInfoVOs
	 * @throws DAOException, Exception
	 */	
	public void modifyCntrManufactureInfoData(List<CntrManufactureInfoVO> cntrManufactureInfoVOs) throws DAOException,Exception{
		int updateCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(cntrManufactureInfoVOs.size() > 0){
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOmodifyCntrManufactureInfoUSQL(), cntrManufactureInfoVOs,null);
				for(int i = 0; i < updateCnt.length; i++){
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * EES_MST_0047 : retrieve <br>
	 * Reefer Unit Info Inquiry and Update를 조회합니다.<br>	 
	 * @author NamKoong JinHo
	 * @category EES_MST_0047
	 * @category searchCntrReeferUnitInfoListData     
	 * @param CntrReeferUnitListVO cntrReeferUnitListVO
	 * @return List<CntrReeferUnitInfoVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CntrReeferUnitInfoVO> searchCntrReeferUnitInfoListData(CntrReeferUnitListVO cntrReeferUnitListVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CntrReeferUnitInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cntrReeferUnitListVO != null){
				Map<String, String> mapVO = cntrReeferUnitListVO .getColumnValues();
				List<String> arrLstmCd      = null;
				List<String> arrCntrTpszCd   = null;
				
				arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(cntrReeferUnitListVO.getLstmCd(),",","|"));
		        arrCntrTpszCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(cntrReeferUnitListVO.getCntrTpszCd(),",","|"));
		            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arr_lstm_cd",arrLstmCd);
				velParam.put("arr_cntr_tpsz_cd", arrCntrTpszCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrReeferUnitInfoVO .class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;		
	}
	
	/**
	 * EES_MST_0047 : retrieve <br>
	 * Reefer Unit Info Inquiry and Update를 조회합니다.<br>	 
	 * @author NamKoong JinHO
	 * @category EES_MST_0047
	 * @category searchCntrReeferUnitInfoData     
	 * @param CntrReeferUnitListVO[] cntrReeferUnitListVOs
	 * @return List<CntrReeferUnitInfoVO> 
	 * @throws DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CntrReeferUnitInfoVO> searchCntrReeferUnitInfoData(CntrReeferUnitListVO[] cntrReeferUnitListVOs) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CntrReeferUnitInfoVO> list = null;
		List<CntrReeferUnitInfoVO> listTmp = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(cntrReeferUnitListVOs != null){
				
				list = new ArrayList<CntrReeferUnitInfoVO>();
				for(int i = 0; i < cntrReeferUnitListVOs.length; i++){
					Map<String, String> mapVO = cntrReeferUnitListVOs[i] .getColumnValues();					
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoRSQL(), param, velParam);
					listTmp = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrReeferUnitInfoVO .class);
					if (listTmp.size() > 0){
					   list.addAll(listTmp);
					}
				}
			}	
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * EES_MST_0047 : save <br>
	 * Reefer Unit Info Inquiry and Update를 수정합니다.<br>	 
	 * @author NamKoong JinHO
	 * @category EES_MST_0047
	 * @category modifyCntrReeferUnitInfoData     
	 * @param List<CntrReeferUnitInfoVO> cntrReeferUnitInfoVOs
	 * @throws DAOException, Exception
	 */	
	public void modifyCntrReeferUnitInfoData(List<CntrReeferUnitInfoVO> cntrReeferUnitInfoVOs) throws DAOException,Exception{
		int updateCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(cntrReeferUnitInfoVOs.size() > 0){
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerOnOffhireDBDAOmodifyCntrReeferUnitInfoUSQL(), cntrReeferUnitInfoVOs,null);
				for(int i = 0; i < updateCnt.length; i++){
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * MASTER 테이블의 CNMV_DT가 CNMV_EVNT_DT와 같은지 조회합니다.<br>
	 * 
     * @author H.S.Lee
     * @category EES_MST_0014,24,28
     * @category searchMvmtTimeData
     * 
     * @param	IFGateVO iFGateVO
     * @return	String
	 * @throws DAOException
	 */	
	public String searchMvmtTimeData(IFGateVO iFGateVO) throws DAOException 
	{	
		DBRowSet dbRowset = null;		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String evntDt = "";			
		try{			
			
			if(iFGateVO != null){
				Map<String, String> mapVO = iFGateVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOsearchMvmtTimeDataRSQL(), param, velParam);
			if(dbRowset.next()){
				evntDt = dbRowset.getString("DT");
			}				
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
		return evntDt;
	}
	
	/**
	 * ees_mst_0028 : re-creation <br>
	 * Sold status를 re-cration하기 위한 정보를 조회처리합니다.<br>
	 * @author Sang-bo La
	 * @category EES_MST_0028
	 * @param IFMnrFlagVO iFMnrFlagVO
	 * @return IFMnrFlagVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	 public IFMnrFlagVO searchStatusSoldData(IFMnrFlagVO iFMnrFlagVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<IFMnrFlagVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(iFMnrFlagVO != null){
					Map<String, String> mapVO = iFMnrFlagVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerOnOffhireDBDAOSearchStatusSoldDataRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, IFMnrFlagVO .class);
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			if (list.size() > 0)
			   return list.get(0);
			else
				return null;	
	 }
	 
	/**
	 * CNTR STS 삭제 시 MST_CONTAINER의 정보도 삭제합니다.<br>
	 *
	 * @param String CntrNo
	 * @throws DAOException
	 */	
	public void removeMstContainerData(String CntrNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("cntr_no", CntrNo);
			velParam.put("cntr_no", CntrNo);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerOnOffhireDBDAORemoveMstContainerDataDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}