/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PopupDBDAO.java
*@FileTitle : S/P Help
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.11 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.popup.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.spe.common.popup.basic.PopupBCImpl;
import com.hanjin.apps.alps.esd.spe.common.popup.vo.SpePopupVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.oracle.vmm.client.provider.ovm22.ws.sps.ArrayList;


/**
 * ALPS PopupDBDAO <br>
 * - ALPS-Common system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see PopupBCImpl 참조
 * @since J2EE 1.6
 */
public class PopupDBDAO extends DBDAOSupport {

	/**
	 * Service Provider 를 조회한다.<br>
	 * 
	 * @param SpePopupVO spePopupVO
	 * @return List<SpePopupVO>
	 * @exception EventException
	 */
	public List<SpePopupVO> searchSPList(SpePopupVO spePopupVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpePopupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(spePopupVO != null){
				Map<String, String> mapVO = spePopupVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PopupDBDAOSearchSPListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpePopupVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 조직트리룰 조회한다.<br>
	 * 
	 * @param SpePopupVO spePopupVO
	 * @return List<SpePopupVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SpePopupVO> searchDeptList(SpePopupVO spePopupVO) throws DAOException {
		DBRowSet dbRowset1 = null;
		DBRowSet dbRowset2 = null;
		List<SpePopupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{

			if(spePopupVO.getEfptOfcCd().equals("A")){
				dbRowset1 = new SQLExecuter("").executeQuery((ISQLTemplate)new PopupDBDAOSearchDeptListOrderRSQL(), null, null);
				
				while(dbRowset1.next()){
					dbRowset1.getString("intg_cd_val_ctnt");
					param.put("efpt_ofc_cd",dbRowset1.getString("intg_cd_val_ctnt"));
					dbRowset2 = new SQLExecuter("").executeQuery((ISQLTemplate)new PopupDBDAOSearchDeptListRSQL(), param, velParam);
					if(dbRowset1.getRow()==1){
						list = ((List)RowSetUtil.rowSetToVOs(dbRowset2, SpePopupVO .class));
					}else{ 
						if(list!=null){
							list.addAll((List)RowSetUtil.rowSetToVOs(dbRowset2, SpePopupVO .class));
						}
						
					}
				}
				
			}else{
				Map<String, String> mapVO = spePopupVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset1 = new SQLExecuter("").executeQuery((ISQLTemplate)new PopupDBDAOSearchDeptListRSQL(), param, velParam);
				list = ((List)RowSetUtil.rowSetToVOs(dbRowset1, SpePopupVO .class));
			}
			
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}