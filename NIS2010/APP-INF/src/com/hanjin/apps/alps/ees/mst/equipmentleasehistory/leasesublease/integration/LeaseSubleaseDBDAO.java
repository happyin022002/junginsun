/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseSubleaseDBDAO.java
*@FileTitle : 임차 및 반납 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.09 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.basic.LeaseSubleaseBCImpl;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrMstHeadVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusOptionVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusReportListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration.ContainerOnOffhireDBDAOSearchContainerExsitRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS LeaseSubleaseDBDAO <br>
 * - ALPS-EquipmentLeaseHistory system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Ho Sun
 * @see LeaseSubleaseBCImpl 참조
 * @since J2EE 1.6
 */

public class LeaseSubleaseDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EES_MST_0029 : retrieve<br>
	 * Container Status 정보를 조회합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0029_1
	 * @category searchCntrMasterInfoByCntrNoData    
	 * @param CntrStatusOptionVO cntrStatusOptionVO
	 * @return List<CntrMstHeadVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CntrMstHeadVO> searchCntrMasterInfoByCntrNoData(CntrStatusOptionVO cntrStatusOptionVO) throws DAOException 
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
			if(cntrStatusOptionVO != null){
				Map<String, String> mapVO = cntrStatusOptionVO .getColumnValues();
			
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
		return list;
	}
	 
	/**
	 * ees_mst_0029  : retrieve<br>
	 * Container Status 상세정보를 조회합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0029_2
	 * @category searchCntrStatusListByCntrNoData    
	 * @param CntrStatusOptionVO cntrStatusOptionVO
	 * @return List<CntrStatusListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")	 
	public List<CntrStatusListVO> searchCntrStatusListByCntrNoData(CntrStatusOptionVO cntrStatusOptionVO) throws DAOException 
	{
		DBRowSet dbRowset = null;
		DBRowSet dbRowset1 = null;
		List<CntrStatusListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String noExist = "E";
		
		try{
			if(cntrStatusOptionVO != null){
				Map<String, String> mapVO = cntrStatusOptionVO .getColumnValues();
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseSubleaseDBDAOMstContainerDetailVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrStatusListVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ees_mst_0035 : retrieve<br>
	 * Container Check Digit and Container Checking 데이타를 조회합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0035_1
	 * @category searchCntrCheckDigitListData    
	 * @param CntrStatusOptionVO cntrStatusOptionVO
	 * @return List<CntrStatusListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CntrStatusListVO> searchCntrCheckDigitListData(CntrStatusOptionVO cntrStatusOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrStatusListVO> list = null;
		List<CntrStatusListVO> listTmp = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = null;
			
			if(cntrStatusOptionVO != null){
				
				//separate로 값 받아오기..
				String[] arrTmp = null;
				String allCntrNo = cntrStatusOptionVO.getCntrNo();
				
				arrTmp = allCntrNo.split(",");
				list = new ArrayList<CntrStatusListVO>();
				for(int i = 0; i < arrTmp.length; i++){
					cntrStatusOptionVO.setCntrNo(arrTmp[i]);
					if (cntrStatusOptionVO.getCntrNo().length() == 10){
						cntrStatusOptionVO.setChklen("1");
					} else {
						cntrStatusOptionVO.setChklen("0");
					}
					mapVO = cntrStatusOptionVO .getColumnValues();			
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseSubleaseDBDAOMstCheckDetailRSQL(), param, velParam);
					listTmp = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrStatusListVO .class);
					
					if (listTmp.size() > 0){
					   list.add(i,(CntrStatusListVO)listTmp.get(0));
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
	 * EES_MST_0027 : retrieve<br>
	 * Container Status List by Lost & Found 데이타를 조회합니다.<br>
	 * 
	 * @author J.H.Min
	 * @category EES_MST_0027
	 * @category searchCntrStatusReportListData 
	 * 
	 * @param CntrStatusOptionVO cntrStatusOptionVO
	 * @return List<CntrStatusReportListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")	 
	public List<CntrStatusReportListVO> searchCntrStatusReportListData(CntrStatusOptionVO cntrStatusOptionVO) throws DAOException 
	{
		DBRowSet dbRowset = null;
		List<CntrStatusReportListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(cntrStatusOptionVO != null){
				Map<String, String> mapVO = cntrStatusOptionVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseSubleaseDBDAOSearchCntrStatusReportRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrStatusReportListVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}