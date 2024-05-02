/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ManualCntrlMappDBDAO.java
*@FileTitle : Manual Container Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-03
*@LastModifier : Hun-Il Jung
*@LastVersion : 1.0
* 2008-03-03 Hun-Il Jung
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.vo.ManualReplanInfoVO;
import com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.vo.SearchCntrMapgListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.basic.ExceptionDataBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SceCopHdrVO;

/**
 * SCEM에 대한 DB 처리를 담당<br> - SCEM Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author yong_cheon_shin
 * @see ExceptionDataBCImpl 참조
 * @since J2EE 1.4
 */
public class ManualCntrlMappDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

    /**
     * Manual Container Mapping(상단리스트 조회) &&&
     * @param ManualReplanInfoVO inqVO
     * @return List<SearchCntrMapgListVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCntrMapgListVO> searchCntrMapgList(ManualReplanInfoVO inqVO) throws DAOException {
		DBRowSet dbRowset = null;
		String bkgcrt_fm_dt=inqVO.getBkgcrtFmDt();
		List<SearchCntrMapgListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

	    try{
	 		Map<String, String> mapVO = inqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			log.debug("\n param:"+param);
			if(bkgcrt_fm_dt != null && bkgcrt_fm_dt.length() > 0){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualCntrlMappDBDAOsearchCntrMapgListByDtRSQL(), param, velParam);
				
			}else{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualCntrlMappDBDAOsearchCntrMapgListRSQL(), param, velParam);
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCntrMapgListVO .class);				
         } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		 } catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		 } 
		 return list;
	}

    /**
     * Manual Container Mapping(하단리스트 조회) &&&
     * @param ManualReplanInfoVO[] inqVOs
     * @return List<SceCopHdrVO>
     * @throws DAOException
     */
	public List<SceCopHdrVO> searchCopMapgList(ManualReplanInfoVO[] inqVOs) throws DAOException {
		int nCnt = inqVOs != null ? inqVOs.length : 0;
		List<SceCopHdrVO> list = new ArrayList<SceCopHdrVO>();

	    try{
	    	for(int i=0; i<nCnt; i++){
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		Map<String, Object> velParam = new HashMap<String, Object>();	    		
		 		Map<String, String> mapVO = inqVOs[i].getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				log.debug("\n param:"+param);
				DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualCntrlMappDBDAOSearchCopMapgListRSQL(), param, velParam);
				
				if(dbRowset.next()){
					SceCopHdrVO vo = new SceCopHdrVO();
					vo.setCopNo(dbRowset.getString("cop_no"));
					vo.setBkgNo(dbRowset.getString("bkg_no"));
					vo.setCntrNo(dbRowset.getString("cntr_no"));
					vo.setCntrTpszCd(dbRowset.getString("cntr_tpsz_cd"));
					vo.setUpdDt(dbRowset.getString("upd_dt"));	
					list.add(vo);
				}
	    	}

         } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		 } catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		 } 
		 return list;
	}

}
