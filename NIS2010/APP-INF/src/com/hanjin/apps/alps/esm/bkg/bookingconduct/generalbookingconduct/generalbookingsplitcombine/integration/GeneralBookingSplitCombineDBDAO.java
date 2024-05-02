/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAO.java
*@FileTitle : DG Split
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.15 최영희
* 1.0 Creation
* -------------------------------------------------------
* history
* 2011.06.15 김영철 [CHM-201111434-01] 전체 VVD 및 Location, Yard 비교 (Pre/Trunk/Post 순서대로 점검)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.AkSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BbSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgBlForSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForCombineVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForMstBkgSelectVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForVslSkdCngNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CntrListForCombineVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CntrSpclTroSelectVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CodQtyForSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByBkgInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByRouteInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineCommonInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CustCdSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.DgSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.LastSplitNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.RfSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.SpclSeqForSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.TroSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.VslSkdCngNoticeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgQuantityVO;


/**
 * ALPS GeneralBookingSplitCombineDBDAO <br>
 * - ALPS-GeneralBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Choi Yeoung Hee
 * @see GeneralBookingSplitCombineBCImpl 참조
 * @since J2EE 1.6
 */
public class GeneralBookingSplitCombineDBDAO extends DBDAOSupport {

	/**
	 * dg cargo split시 참고할 data를 조회한다.<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<DgSplitVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DgSplitVO> searchDgSplit(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DgSplitVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchDgSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DgSplitVO .class);
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
	  * reefer cargo split시 참고할 data를 조회한다.<br>
	  * 
	  * @param  BkgBlNoVO bkgBlNoVO
	  * @return List<RfSplitVO>
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<RfSplitVO> searchRfSplit(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RfSplitVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchRfSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RfSplitVO.class);
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
	 * awkward cargo split시 참고할 data를 조회한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<AkSplitVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AkSplitVO> searchAkSplit(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AkSplitVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchAkSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AkSplitVO.class);
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
	 *  break bulk cargo split시 참고할 data를 조회한다.<br>
	 *  
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<BbSplitVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BbSplitVO> searchBbSplit(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BbSplitVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchBbSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BbSplitVO.class);
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
	 * tro split시 참고할 data를 조회한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<TroSplitVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TroSplitVO> searchTroSplit(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TroSplitVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchTroSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroSplitVO.class);
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
	 * booking split 화면에서 split시 참고할 data를 조회한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<BkgBlForSplitVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgBlForSplitVO> searchBkgForSplit(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBlForSplitVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchBkgForSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBlForSplitVO.class);
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
	 * split시 참고할 qty data를 조회한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<BkgQuantityVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgQuantityVO> searchQtyForSplit(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgQuantityVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchQtyForSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQuantityVO.class);
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
	 * split시 참고할 Container data 조회<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<CntrSpclTroSelectVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrSpclTroSelectVO> searchCntrForSplit(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrSpclTroSelectVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchCntrForSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrSpclTroSelectVO.class);
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
	 * cod에서 new BKG에 assign하는 cntr list를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @return List<CntrSpclTroSelectVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrSpclTroSelectVO> searchCodCntrForSplit(BkgBlNoVO bkgBlNoVO,String codRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrSpclTroSelectVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchCodCntrForSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrSpclTroSelectVO.class); 
			
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
	 * 원본 qty와 신규 qty조회<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String codRqstSeq
	 * @return List<CodQtyForSplitVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CodQtyForSplitVO> searchCodQtyForSplit(BkgBlNoVO bkgBlNoVO,String codRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CodQtyForSplitVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.put("cod_rqst_seq", codRqstSeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchCodQtyForSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodQtyForSplitVO.class);
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
	 * 해당 bkg의 마지막 split no를 찾는다(다음 split no를 계산하기 위해)<br>
	 * customer split이면 R1 이전, memo split이면 R1 이후의 spli tno를 찾는다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<LastSplitNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<LastSplitNoVO> searchLastSplitNo(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LastSplitNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchLastSplitNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LastSplitNoVO.class);
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
	 * 변경된 VVD,POL로 기존에 생성되어 있는 Booking을 조회한다.
	 * @author	Kim Byung Kyu
	 * @param 	VslSkdCngNoticeVO vslSkdCngNoticeVO
	 * @return		List<BkgListForVslSkdCngNoticeVO>
	 * @exception 	DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgListForVslSkdCngNoticeVO> searchBkgListForVslSkdCngNotice(VslSkdCngNoticeVO vslSkdCngNoticeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgListForVslSkdCngNoticeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslSkdCngNoticeVO != null){
				Map<String, String> mapVO = vslSkdCngNoticeVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOSearchBkgListForVslSkdCngNoticeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgListForVslSkdCngNoticeVO.class);
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
	 * BKG의 컨테이너 목록을 조회한다.(ESM_BKG_0732)
	 * @author	Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<CntrListForCombineVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrListForCombineVO> searchCntrListForCombine(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrListForCombineVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchCntrListForCombineRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrListForCombineVO.class);
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
	 * Combine할 Booking List를 조회한다.(ESM_BKG_0974)
	 * @author	Jun Yong Jin
	 * @param BkgBlNoVO[] bkgBlNoVOs
	 * @return List<BkgListForMstBkgSelectVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgListForMstBkgSelectVO> searchBkgListForMstBkgSelect(BkgBlNoVO[] bkgBlNoVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgListForMstBkgSelectVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> arrString = new ArrayList();

		try{
			if(bkgBlNoVOs != null){
				for(int i=0;i<bkgBlNoVOs.length;i++) {
					arrString.add(bkgBlNoVOs[i].getBkgNo());
				}
			}
			velParam.put("bkg_no_list", arrString);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchBkgListForMstBkgSelectRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgListForMstBkgSelectVO.class);
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
	 * Combine할 Booking 목록을 조회한다. - by Route(ESM_BKG_0076)
	 * @author	Jun Yong Jin
	 * @param CombineCommonInputVO combineCommonInputVO
	 * @param CombineByRouteInputVO combineByRouteInputVO
	 * @return List<BkgListForCombineVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgListForCombineVO> searchBkgListForCombineByRoute(CombineCommonInputVO combineCommonInputVO, CombineByRouteInputVO combineByRouteInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgListForCombineVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(combineCommonInputVO != null){
				Map<String, String> mapVO = combineCommonInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if(combineByRouteInputVO != null){
				Map<String, String> mapVO2 = combineByRouteInputVO .getColumnValues();

				param.putAll(mapVO2);
				velParam.putAll(mapVO2);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchBkgListForCombineByRouteRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgListForCombineVO.class);
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
	 * Combine할 Booking 목록을 조회한다. - by BKG(ESM_BKG_0076)
	 * @author	Jun Yong Jin
	 * @param CombineCommonInputVO combineCommonInputVO
	 * @param CombineByBkgInputVO[] CombineByBkgInputVOs
	 * @return List<BkgListForCombineVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgListForCombineVO> searchBkgListForCombineByBkg(CombineCommonInputVO combineCommonInputVO, CombineByBkgInputVO[] CombineByBkgInputVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgListForCombineVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> bkgNoString = new ArrayList();
		ArrayList<String> blNoString = new ArrayList();

		try{
			if(combineCommonInputVO != null){
				Map<String, String> mapVO = combineCommonInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if(CombineByBkgInputVOs != null){
				for(int i=0;i<CombineByBkgInputVOs.length;i++) {
					bkgNoString.add(CombineByBkgInputVOs[i].getBkgNo());
					blNoString.add(CombineByBkgInputVOs[i].getBlNo());
				}
			}
			velParam.put("bkg_no_list", bkgNoString);
			velParam.put("bl_no_list", blNoString);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchBkgListForCombineByBkgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgListForCombineVO.class);
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
	 * Combine할 Booking의 Validate을 검사한다. - by BKG(ESM_BKG_0076)
	 * @author	Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<CustCdSeqVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustCdSeqVO> searchBkgCustForCombine(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustCdSeqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchBkgCustForCombineRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustCdSeqVO.class);
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
	 *  해당 Booking에 대한 SpcCargo 키 조회<br>
	 *  
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<SpclSeqForSplitVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SpclSeqForSplitVO> searchSpclSeqForSplit(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpclSeqForSplitVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchSpclSeqForSplitRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpclSeqForSplitVO.class);
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
	 * split시 변경된 route의 정보를 조회한다.
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return 	String
	 * @exception 	DAOException
	 */
	public String searchNewTsRoute(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingsplitCombineDBDAOSearchSplitNewRouteRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("RTN_ROUTE");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}
	/** 
	 * cod의 변경된 route의 pctl_no를 조회한다.
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param   String codRqstSeq
	 * @return 	String
	 * @exception 	DAOException
	 */
	public String searchCodPctlNo(BkgBlNoVO bkgBlNoVO, String codRqstSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String pctlNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				param.put("cod_rqst_seq", codRqstSeq);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingsplitCombineDBDAOSearchCodPctlNoRSQL(), param, velParam);
			if(dbRowset.next()){
				pctlNo = dbRowset.getString("pctl_no");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return pctlNo;
	}

	/**
	 * Combine할 Booking의 Validate을 검사한다. - 전체 VVD 및 Location, Yard 비교 (Pre/Trunk/Post 순서대로 점검)
	 * @author	Young Chul Kim
	 * @param String sourceBkg
	 * @param String targetBkg
	 * @return String
	 * @exception DAOException
	 */
	public String searchVvdDiff(String sourceBkg, String targetBkg) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(targetBkg != null && sourceBkg != null){
				param.put("target_bkg", targetBkg);
				param.put("source_bkg", sourceBkg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralBookingSplitCombineDBDAOsearchVvdDiffRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("DIFF");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnString;
	}
}