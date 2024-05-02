/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : CLMReceiveEAIDBDAO.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-01
*@LastModifier : Y
*@LastVersion : 1.0
* 2009-11-01 Y
* 1.0 최초 생성
* 2010.10.29 김진승 [소스결함 보완] 중첩 try문장 private 메서드로 전환
=========================================================*/


package com.clt.apps.opus.esd.sce.receiveeai.clmreceiveeai.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.receiveeai.clmreceiveeai.vo.SearchCLMReceiveEAICNMVVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * SCE에 대한 DB 처리를 담당<br>
 * - SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see CLMReceiveEAIBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CLMReceiveEAIDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * create EDI CLM Temp Data
	 * @param ArrayList paramArrList
	 * @throws DAOException 
	 */
	public void createEDIClmTmpData(ArrayList paramArrList) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Iterator itr =paramArrList.iterator();
			
			while(itr.hasNext()){
				createEDIClmTmpDataUnit(param, itr);
			}	
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 
	 * @param param
	 * @param itr
	 */
	private void createEDIClmTmpDataUnit(Map<String, Object> param, Iterator itr) {
		List<SearchCLMReceiveEAICNMVVO> list =null;

		try{
			param =(HashMap)itr.next();
			
			list =searchCLMReceiveEAICNMV(param);
			if(list.size() >0){
				param.put("CNTR_NO",list.get(0).getCntrNo());
				param.put("CNMV_YR",list.get(0).getCnmvYr());
				param.put("CNMV_ID_NO",list.get(0).getCnmvIdNo());
				param.put("CLM_SEQ",list.get(0).getClmSeq());
				param.put("CNMV_CYC_NO",list.get(0).getCnmvCycNo());
			}

			int rowCnt = 0; 
			rowCnt = new SQLExecuter("").executeUpdate(new CLMReceiveEAIDBDAOAddClmEAIUSQL(), param, param);
			log.debug( rowCnt );
			
		}catch( SQLException se) {
			log.error(se.getMessage());
			log.error("\n===========================   Error  CLM Layout Start ==========================");
			log.error(param);
			log.error("\n===========================   Error  CLM Layout End   ==========================");
		}catch( Exception e) {
			log.error(e.getMessage());
			log.error("\n===========================   Error  CLM Layout Start ==========================");
			log.error(param);
			log.error("\n===========================   Error  CLM Layout End   ==========================");
		}	

		
	}

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param Map param
	 * @return List<SearchCLMReceiveEAICNMVVO>
	 * @throws DAOException
	 */
	public List<SearchCLMReceiveEAICNMVVO> searchCLMReceiveEAICNMV(Map param)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCLMReceiveEAICNMVVO> list = null;
		try {

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CLMReceiveEAIDBDAOSearchCLMReceiveEAICNMVRSQL(),
					param, null);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCLMReceiveEAICNMVVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}			
}