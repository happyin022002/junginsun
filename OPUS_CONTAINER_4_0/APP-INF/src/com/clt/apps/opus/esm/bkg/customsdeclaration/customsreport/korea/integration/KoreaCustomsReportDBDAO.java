/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomsTransmissionDAO.java
*@FileTitle : UI_BKG-0017
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.05.20 손윤석
* 1.0 Creation
* 2011.11.16 변종건[CHM-201114372-01] 한국지역 적하목록 사전 제출 관련 SYS보완 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorCntrDgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDiscEtbVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDiscHeadInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCYCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCYVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischLocCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischLocVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorEntryTpCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorEntryTpVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrtBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrtCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrtCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrtLocNmVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrtMsnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrtVslNmVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorMrnCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorMrnInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorMrnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorMsnInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorOFMCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorPntBlQtyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorPntCustNmVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorPntDchgLocVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorRcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorRcvHistVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorTransHistVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorTransmitHistDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorTransmitHistDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorWareHouseCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo.KorWareHouseVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgCstmsKrDlHisVO;


/**
 * OPUS CustomsTransmissionDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author charves
 * @see KoreaCustomsReportBCImpl 참조
 * @since J2EE 1.4
 */
public class KoreaCustomsReportDBDAO extends DBDAOSupport
{
	private static final long serialVersionUID = 9034783146124082510L;

	/**
	 * 한국세관 Manifest DownLoad History를 조회한다.
	 * @param BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO
	 * @return List<BkgCstmsKrDlHisVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsKrDlHisVO> searchDownLoadHistList(BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO) throws DAOException
	{
		List <BkgCstmsKrDlHisVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgCstmsKrDlHisVO != null)
			{
				//int ss = list.size();
				Map<String, String> mapVO = bkgCstmsKrDlHisVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				String vRadMrn = bkgCstmsKrDlHisVO.getRadMrn();
				String vRadVvd = bkgCstmsKrDlHisVO.getRadVvd();
				String vRadDat = bkgCstmsKrDlHisVO.getRadDat();
				String vTxtPol = bkgCstmsKrDlHisVO.getTxtPol();
				String vTxtPod = bkgCstmsKrDlHisVO.getTxtPod();

				if(!"".equals(vRadMrn))
				{
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustRPTDAOMRNRSQL(), param, velParam);
				}
				else if(!"".equals(vRadVvd))
				{
					if(!"".equals(vTxtPol))
					{
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustRPTDAOVvdPolRSQL(), param, velParam);
					}
					else if(!"".equals(vTxtPod))
					{
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustRPTDAOVvdPodRSQL(), param, velParam);
					}
					else
					{
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustRPTDAOVvdPolRSQL(), param, velParam);
					}
				}
				else if(!"".equals(vRadDat))
				{
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustRPTDAODateRSQL(), param, velParam);
				}
				else
				{
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustRPTDAOMRNRSQL(), param, velParam);
				}
			}
			else
			{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KorCustRPTDAOMRNRSQL(), param, velParam);
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrDlHisVO.class);
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
	 * 한국/인도 세관에 적하 목록 전송할 Discharging CY Code 리스트 조회
	 *
	 * @param KorDischLocCondVO korDischLocCondVO
	 * @return KorDischLocVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDischLocVO[] searchDiscCYCodeList(KorDischLocCondVO korDischLocCondVO) throws DAOException {
		KorDischLocVO[] korDischLocVOs = null;
		List<KorDischLocVO> korDischLocVOList = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = korDischLocCondVO.getColumnValues();
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try{
			if(korDischLocCondVO != null) {

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchDiscCYCodeListRSQL(), param, velParam);
				korDischLocVOList = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDischLocVO.class);
				if (korDischLocVOList!=null) korDischLocVOs = korDischLocVOList.toArray(new KorDischLocVO[0]);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korDischLocVOs;
	}

	/**
	 * Discharging CY Code List 삭제
	 *
	 * @param KorDischLocCondVO[] korDischLocCondVOs
	 * @exception DAOException
	 */
	public void removeDiscCYCodeList(KorDischLocCondVO[] korDischLocCondVOs) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;

		try {
			for(int i=0; i < korDischLocCondVOs.length; i++) {
				mapVO = korDischLocCondVOs[i].getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				new SQLExecuter("").executeUpdate((ISQLTemplate) new KoreaCustomsReportDBDAOremoveDiscCYCodeListDSQL(),param, velParam);
			}
		}catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Discharging CY Code List 추가
	 *
	 * @param KorDischLocCondVO[] korDischLocCondVOs
	 * @exception DAOException
	 */
	public void addDiscCYCodeList(KorDischLocCondVO[] korDischLocCondVOs) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;

		try {
			for(int i=0; i < korDischLocCondVOs.length; i++) {
				mapVO = korDischLocCondVOs[i].getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				new SQLExecuter("").executeUpdate((ISQLTemplate) new KoreaCustomsReportDBDAOaddDiscCYCodeListCSQL(),param, velParam);
			}
		}catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Discharging CY Code List 수정
	 *
	 * @param KorDischLocCondVO[] korDischLocCondVOs
	 * @exception DAOException
	 */
	public void modifyDiscCYCodeList(KorDischLocCondVO[] korDischLocCondVOs) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;

		try {
			for(int i=0; i < korDischLocCondVOs.length; i++) {
				mapVO = korDischLocCondVOs[i].getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				new SQLExecuter("").executeUpdate((ISQLTemplate) new KoreaCustomsReportDBDAOmodifyDiscCYCodeListUSQL(),param, velParam);
			}
		}catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code를 Inquiry
	 *
	 * @param KorEntryTpCondVO korEntryTpCondVO
	 * @return KorEntryTpVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorEntryTpVO[] searchCstmEntryTpList(KorEntryTpCondVO korEntryTpCondVO) throws DAOException {
		KorEntryTpVO[] korEntryTpVOs = null;
		List<KorEntryTpVO> korEntryTpVOList = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = korEntryTpCondVO.getColumnValues();
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try{
			if(korEntryTpCondVO != null) {

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchCstmEntryTpListRSQL(), param, velParam);
				korEntryTpVOList = (List)RowSetUtil.rowSetToVOs(dbRowset, KorEntryTpVO.class);
				if (korEntryTpVOList!=null) korEntryTpVOs = korEntryTpVOList.toArray(new KorEntryTpVO[0]);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korEntryTpVOs;
	}

	/**
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code를 Insert
	 *
	 * @param KorEntryTpCondVO[] korEntryTpCondVOs
	 * @exception DAOException
	 */
	public void addCstmEntryTpList(KorEntryTpCondVO[] korEntryTpCondVOs) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;

		try {
			for(int i=0; i < korEntryTpCondVOs.length; i++) {
				// Flag 가 'I' 인 경우만 INSERT
				if (korEntryTpCondVOs[i].getIbflag().equals("I")) {
					mapVO = korEntryTpCondVOs[i].getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					// INSERT 처리
					new SQLExecuter("").executeUpdate((ISQLTemplate) new KoreaCustomsReportDBDAOaddCstmEntryTpListCSQL(),param, velParam);
				}
			}
		}catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 한국세관 Manifest Transmit History를 조회한다.
	 * @param KorTransHistVO korTransHistVO
	 * @return List<KorTransHistVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorTransHistVO> searchTransHistByVVDList(KorTransHistVO korTransHistVO) throws DAOException
	{
		List<KorTransHistVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = korTransHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchTransHistByVVDRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorTransHistVO.class);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}


	/**
	 * 한국세관 Manifest Transmit History를 조회한다.
	 * @param KorTransHistVO korTransHistVO
	 * @return List<KorTransHistVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorTransHistVO> searchTransHistBySndDtList(KorTransHistVO korTransHistVO) throws DAOException
	{
		List<KorTransHistVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = korTransHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchTransHistBySndDtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorTransHistVO.class);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 한국세관 Manifest Transmit History (by ETA) 조회
	 * @param KorTransHistVO korTransHistVO
	 * @return List<KorTransHistVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorTransHistVO> searchTransHistByETAList(KorTransHistVO korTransHistVO) throws DAOException
	{
		List<KorTransHistVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = korTransHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchTransHistByETARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorTransHistVO.class);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 한국세관 Manifest Transmit History (by ETD) 조회
	 * @param KorTransHistVO korTransHistVO
	 * @return List<KorTransHistVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorTransHistVO> searchTransHistByETDList(KorTransHistVO korTransHistVO) throws DAOException
	{
		List<KorTransHistVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = korTransHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchTransHistByETDRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorTransHistVO.class);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}


	/**
	 * 한국세관 Manifest Transmit History를 조회한다.
	 * @param KorTransHistVO korTransHistVO
	 * @return List<KorTransHistVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorTransHistVO> searchTransHistByBlList(KorTransHistVO korTransHistVO) throws DAOException
	{
		List<KorTransHistVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = korTransHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchTransHistByBlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorTransHistVO.class);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}


	/**
	 * 한국세관 Manifest Transmit History를 조회한다.
	 * @param KorTransHistVO korTransHistVO
	 * @return List<KorTransHistVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KorTransHistVO> searchTransHistBySubmitNoList(KorTransHistVO korTransHistVO) throws DAOException
	{
		List<KorTransHistVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = korTransHistVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchTransHistBySubmitNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorTransHistVO.class);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}


	/**
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code를 Update
	 *
	 * @param KorEntryTpCondVO[] korEntryTpCondVOs
	 * @exception DAOException
	 */
	public void modifyCstmEntryTpList(KorEntryTpCondVO[] korEntryTpCondVOs) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;

		try {
			for(int i=0; i < korEntryTpCondVOs.length; i++) {
				// Flag 가 'U' 인 경우만 UPDATE
				if (korEntryTpCondVOs[i].getIbflag().equals("U")) {
					mapVO = korEntryTpCondVOs[i].getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					// UPDATE 처리
					new SQLExecuter("").executeUpdate((ISQLTemplate) new KoreaCustomsReportDBDAOmodifyCstmEntryTpListUSQL(),param, velParam);
				}
			}
		}catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code를 Delete
	 *
	 * @param KorEntryTpCondVO[] korEntryTpCondVOs
	 * @exception DAOException
	 */
	public void removeCstmEntryTpList(KorEntryTpCondVO[] korEntryTpCondVOs) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;

		try {
			for(int i=0; i < korEntryTpCondVOs.length; i++) {
				// Flag 가 'D' 인 경우만 DELETE
				if (korEntryTpCondVOs[i].getIbflag().equals("D")) {
					mapVO = korEntryTpCondVOs[i].getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					// DELETE 처리
					new SQLExecuter("").executeUpdate((ISQLTemplate) new KoreaCustomsReportDBDAOremoveCstmEntryTpListDSQL(),param, velParam);
				}
			}
		}catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * VVD, PORT 등으로 MRN 정보 조회
	 * @param mrnInfoVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMrnInfoVO searchMRNInfo(KorMrnInfoVO mrnInfoVO) throws DAOException {
		KorMrnInfoVO outKorMrnInfoVO = null;
		List<KorMrnInfoVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = mrnInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchMRNInfoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnInfoVO.class);
			if (list!=null && list.size() > 0 ) outKorMrnInfoVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outKorMrnInfoVO;
	}

	/**
	 * MRN 으로 VVD 정보 조회
	 * @param mrnInfoVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMrnInfoVO searchMRNVVDInfo(KorMrnInfoVO mrnInfoVO) throws DAOException {
		KorMrnInfoVO outKorMrnInfoVO = null;
		List<KorMrnInfoVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = mrnInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchMRNVVDInfoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnInfoVO.class);
			if (list!=null && list.size() > 0 ) outKorMrnInfoVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outKorMrnInfoVO;
	}

	/**
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회
	 * @param dischCYCondVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDischCYVO[] searchDischCYList(KorDischCYCondVO dischCYCondVO) throws DAOException
	{
		KorDischCYVO[] outKorDischCYVOs = null;
		List<KorDischCYVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = dischCYCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchDischCYListRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDischCYVO.class);
			if (list.size() < 1) return null;
			outKorDischCYVOs = list.toArray(new KorDischCYVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outKorDischCYVOs;
	}

	/**
	 * BKG별 Customer Type, Name등의 정보 조회
	 * @param KorDischCYCondVO korDischCYCondVO
	 * @return KorDischCYVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDischCYVO searchCustInfo(KorDischCYCondVO korDischCYCondVO) throws DAOException
	{
		KorDischCYVO outKorDischCYVO = null;
		List<KorDischCYVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = korDischCYCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchCustInfoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDischCYVO.class);
			if (list!=null && list.size() > 0 ) outKorDischCYVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outKorDischCYVO;
	}

	/**
	 * OFM Customer Info 조회
	 * @param String bkgNo
	 * @return KorOFMCustVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorOFMCustVO searchOFMCustInfo(String bkgNo) throws DAOException
	{
		KorOFMCustVO korOFMCustVO = null;
		List<KorOFMCustVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchOFMCustInfoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorOFMCustVO.class);
			if (list!=null && list.size() > 0 ) korOFMCustVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korOFMCustVO;
	}

	/**
	 * Bonded WareHouse Name을 조회
	 *
	 * @param korDischCYCondVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDischCYVO searchBondWHName(KorDischCYCondVO korDischCYCondVO) throws DAOException
	{
		KorDischCYVO outKorDischCYVO = null;
		List<KorDischCYVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = korDischCYCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchBondWHNameRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDischCYVO.class);
			if (list!=null && list.size() > 0 ) outKorDischCYVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outKorDischCYVO;
	}

	/**
	 * Inward Foreign Manifest List를 조회
	 * @param KorDischCYCondVO dischCYCondVO
	 * @return KorDischCYVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDischCYVO[] searchIFMList(KorDischCYCondVO dischCYCondVO) throws DAOException
	{
		KorDischCYVO[] outKorDischCYVOs = null;
		List<KorDischCYVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = dischCYCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchIFMListRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDischCYVO.class);
			if (list.size() < 1) return null;
			outKorDischCYVOs = list.toArray(new KorDischCYVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outKorDischCYVOs;
	}

	/**
	 * OutBound Foreign Manifest List 조회
	 * @param KorDischCYCondVO dischCYCondVO
	 * @return KorDischCYVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDischCYVO[] searchOFMList(KorDischCYCondVO dischCYCondVO) throws DAOException
	{
		KorDischCYVO[] outKorDischCYVOs = null;
		List<KorDischCYVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = dischCYCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchOFMListRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDischCYVO.class);
			if (list.size() < 1) return null;
			outKorDischCYVOs = list.toArray(new KorDischCYVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outKorDischCYVOs;
	}

	/**
	 * DG Application의 위험물의 Class No를 조회
	 *
	 * @param dischCYCondVO
	 * @return
	 * @exception DAOException
	 */
	public String searchDGClass(KorDischCYCondVO dischCYCondVO) throws DAOException
	{
		String dgClass = null;

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = dischCYCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchDGClassRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) {
				dgClass = dbRowset.getString("IMDG_CLSS_CD");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return dgClass;
	}

	/**
	 * 전송 상세 내역 조회
	 * @param KorTransmitHistDtlCondVO transmitHistDtlCondVO
	 * @return KorTransmitHistDtlVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public KorTransmitHistDtlVO[] searchTransmitHistDtl(KorTransmitHistDtlCondVO transmitHistDtlCondVO) throws DAOException
	{
		KorTransmitHistDtlVO[] korTransmitHistDtlVOs = null;
		List<KorTransmitHistDtlVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = transmitHistDtlCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchTransmitHistDtlRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorTransmitHistDtlVO.class);
			if (list.size() < 1) return null;
			korTransmitHistDtlVOs = list.toArray(new KorTransmitHistDtlVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korTransmitHistDtlVOs;
	}

	/**
	 * 한국세관, 일본세관, 인도세관 Manifest 신고 등록시 Warehouse (Bonded Area) Detail을 조회
	 *
	 * @param KorWareHouseCondVO wareHouseCondVO
	 * @return KorWareHouseVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorWareHouseVO[] searchWareHouseInfo(KorWareHouseCondVO wareHouseCondVO) throws DAOException {
		KorWareHouseVO[] korWareHouseVOs = null;
		List<KorWareHouseVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = wareHouseCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchWareHouseInfoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorWareHouseVO.class);
			if (list.size() < 1) return null;
			korWareHouseVOs = list.toArray(new KorWareHouseVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korWareHouseVOs;
	}

	/**
	 * 한국 세관 신고용 화물 관리 번호 Master Reference Number를 조회
	 * @param KorMrnCondVO mrnCondVO
	 * @return KorMrnVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMrnVO[] searchMRNNoList(KorMrnCondVO mrnCondVO) throws DAOException
	{
		KorMrnVO[] korMrnVOs = null;
		List<KorMrnVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = mrnCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchMRNNoListRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMrnVO.class);
			if (list.size() < 1) return null;
			korMrnVOs = list.toArray(new KorMrnVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korMrnVOs;
	}

	/**
	 * 하선신고서 Print form내역중 BL 및 Weight, Package정보 조회
	 * @param String bkgNo
	 * @return KorPntBlQtyVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorPntBlQtyVO searchDiscPntBlQtyInfo(String bkgNo) throws DAOException
	{
		KorPntBlQtyVO korPntBlQtyVO = null;
		List<KorPntBlQtyVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchDiscPntBlQtyInfoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorPntBlQtyVO.class);
			if (list!=null && list.size() > 0 ) korPntBlQtyVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korPntBlQtyVO;
	}

	/**
	 * 하선장소, Bonded W/H, Bonded Type조회
	 * @param String bkgNo
	 * @param String mrnNo
	 * @return KorPntDchgLocVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorPntDchgLocVO searchDiscPntDchgLoc(String bkgNo, String mrnNo) throws DAOException
	{
		KorPntDchgLocVO korPntDchgLocVO = null;
		List<KorPntDchgLocVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("mrn_no", mrnNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchDiscPntDchgLocRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorPntDchgLocVO.class);
			if (list!=null && list.size() > 0 ) korPntDchgLocVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korPntDchgLocVO;
	}

	/**
	 * CNTR List를 조회한다.
	 * @param String bkgNo
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchDiscPntCntrList(String bkgNo) throws DAOException
	{
		List<String> list = new ArrayList<String>();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchDiscPntCntrListRSQL(), param, velParam);
			if (dbRowset==null) return null;
			while(dbRowset.next()) {
				list.add(dbRowset.getString(1));
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list.toArray(new String[0]);
	}

	/**
	 * Customer Name조회
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorPntCustNmVO searchDiscPntCustNm(String bkgNo) throws DAOException
	{
		KorPntCustNmVO korPntCustNmVO = null;
		List<KorPntCustNmVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchDiscPntCustNmRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorPntCustNmVO.class);
			if (list!=null && list.size() > 0 ) korPntCustNmVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korPntCustNmVO;
	}

	/**
	 * 하선신고서 Header정보(VVD 정보)
	 * @param KorDiscHeadInfoVO discHeadInfoVO
	 * @return KorDiscHeadInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorDiscHeadInfoVO searchDiscPntHeadVvd(KorDiscHeadInfoVO discHeadInfoVO) throws DAOException
	{
		KorDiscHeadInfoVO korDiscHeadInfoVO = null;
		List<KorDiscHeadInfoVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = discHeadInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchDiscPntHeadVvdRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorDiscHeadInfoVO.class);
			if (list!=null && list.size() > 0 ) korDiscHeadInfoVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korDiscHeadInfoVO;
	}

	/**
	 * VSL ENGLISH NAME 조회
	 * @param String vslCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchDiscPntHeadVslNm(String vslCd) throws DAOException
	{
		String vslNm = "";

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchDiscPntHeadVslNmRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) {
				vslNm = dbRowset.getString("VSL_ENG_NM");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return vslNm;
	}

	/**
	 * ETB Date 조회
	 * @param KorDiscEtbVO discEtbVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchDiscPntHeadEtbDt(KorDiscEtbVO discEtbVO) throws DAOException
	{
		String etbDt = "";

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = discEtbVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchDiscPntHeadEtbDtRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) {
				etbDt = dbRowset.getString("VPS_ETB_DT");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return etbDt;
	}

	/**
	 * Import Cargo Manifest Print를 위한 Customer Information 조회
	 * @param String bkgNo
	 * @return KorImpPrtCustVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorImpPrtCustVO[] searchImpCgoManiPrtCustInfo(String bkgNo) throws DAOException
	{
		KorImpPrtCustVO[] korImpPrtCustVOs = null;
		List<KorImpPrtCustVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchImpCgoManiPrtCustInfoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorImpPrtCustVO.class);
			if (list.size() > 0 ) korImpPrtCustVOs = list.toArray(new KorImpPrtCustVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korImpPrtCustVOs;
	}

	/**
	 * Import Cargo Manifest Print를 위한 Container Information 조회
	 * @param String bkgNo
	 * @return KorImpPrtCntrVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorImpPrtCntrVO[] searchImpCgoManiPrtCNTRInfo(String bkgNo) throws DAOException
	{
		KorImpPrtCntrVO[] korImpPrtCntrVOs = null;
		List<KorImpPrtCntrVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchImpCgoManiPrtCNTRInfoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorImpPrtCntrVO.class);
			if (list.size() > 0 ) korImpPrtCntrVOs = list.toArray(new KorImpPrtCntrVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korImpPrtCntrVOs;
	}

	/**
	 * Import Cargo Manifest Print를 위한 Description of Goods Information 조회
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchImpCgoManiPrtCstmDesc(String bkgNo) throws DAOException
	{
		String cstmDesc = "";

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchImpCgoManiPrtCstmDescRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) {
				cstmDesc = dbRowset.getString("CSTMS_DESC");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cstmDesc;
	}

	/**
	 * Import Cargo Manifest Print를 위한 MSN 조회
	 * @param String bkgNo
	 * @param String mrnNo
	 * @return KorImpPrtMsnVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorImpPrtMsnVO searchImpCgoManiPrtMSN(String bkgNo, String mrnNo) throws DAOException
	{
		KorImpPrtMsnVO korImpPrtMsnVO = null;
		List<KorImpPrtMsnVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("mrn_no", mrnNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchImpCgoManiPrtMSNRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorImpPrtMsnVO.class);
			if (list!=null && list.size() > 0 ) korImpPrtMsnVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korImpPrtMsnVO;
	}

	/**
	 * Print Header 정보의 적재항, 양륙항을 조회
	 * @param String polCd
	 * @param String podCd
	 * @return KorImpPrtLocNmVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorImpPrtLocNmVO searchImpCgoManiPrtLocNm(String polCd, String podCd) throws DAOException
	{
		KorImpPrtLocNmVO korImpPrtLocNmVO = null;
		List<KorImpPrtLocNmVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("pol_cd", polCd);
			mapVO.put("pod_cd", podCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchImpCgoManiPrtLocNmRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorImpPrtLocNmVO.class);
			if (list!=null && list.size() > 0 ) korImpPrtLocNmVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korImpPrtLocNmVO;
	}

	/**
	 * Import Cargo Manifest Print를 위한 VSL Information을 조회
	 * @param String vslCd
	 * @return KorImpPrtVslNmVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorImpPrtVslNmVO searchImpCgoManiVslNm(String vslCd) throws DAOException
	{
		KorImpPrtVslNmVO korImpPrtVslNmVO = null;
		List<KorImpPrtVslNmVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchImpCgoManiVslNmRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorImpPrtVslNmVO.class);
			if (list!=null && list.size() > 0 ) korImpPrtVslNmVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korImpPrtVslNmVO;
	}

	/**
	 * Import Cargo Manifest Print를 위한 B/L No, 총중량, 포장개수를 조회
	 * @param String bkgNo
	 * @return KorImpPrtBlInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorImpPrtBlInfoVO searchImpCgoManiBlInfo(String bkgNo) throws DAOException
	{
		KorImpPrtBlInfoVO korImpPrtBlInfoVO = null;
		List<KorImpPrtBlInfoVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchImpCgoManiBlInfoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorImpPrtBlInfoVO.class);
			if (list!=null && list.size() > 0 ) korImpPrtBlInfoVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korImpPrtBlInfoVO;
	}

	/**
	 * BKG별 Danger Cargo의 Seq갯수 조회
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchImpCgoManiDgSeq(String bkgNo) throws DAOException
	{
		String cnt = null;

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchImpCgoManiDgSeqRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) {
				cnt = dbRowset.getString("CNT");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * Import Cargo Manifest Print를 위한 특수화물 코드를 조회
	 * @param String bkgNo
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchImpCgoManiDgCd(String bkgNo) throws DAOException
	{
		List<String> list = new ArrayList<String>();

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchImpCgoManiDgCdRSQL(), param, velParam);
			if (dbRowset==null) return null;
			while (dbRowset.next()) {
				list.add(dbRowset.getString("IMDG_UN_NO"));
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list.toArray(new String[0]);
	}

	/**
	 * Import Cargo Manifest Print를 위한 배정신청 현황을 조회
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchImpCgoManiBondWhName(String bkgNo) throws DAOException
	{
		String whName = "";

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchImpCgoManiBondWhNameRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) {
				whName = dbRowset.getString("WH_NM");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return whName;
	}

	/**
	 * Import Cargo Manifest Print를 위한 Container Information과 DG Class Code를 조회
	 * @param String bkgNo
	 * @return KorImpPrtCntrVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorImpPrtCntrVO[] searchImpCgoManiPrtCNTRDgClssInfo(String bkgNo) throws DAOException
	{
		KorImpPrtCntrVO[] korImpPrtCntrVOs = null;
		List<KorImpPrtCntrVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchImpCgoManiPrtCNTRDgClssInfoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorImpPrtCntrVO.class);
			if (list.size() > 0 ) korImpPrtCntrVOs = list.toArray(new KorImpPrtCntrVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korImpPrtCntrVOs;
	}

	/**
	 * 관세청에서 수신된 응답문서들의 현황을 MSG Type과 VVD로 조회
	 * @param KorRcvHistCondVO rcvHistCondVO
	 * @return KorRcvHistVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorRcvHistVO[] searchReceiveHistByVVD(KorRcvHistCondVO rcvHistCondVO) throws DAOException {
		KorRcvHistVO[] korRcvHistVOs = null;
		List<KorRcvHistVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = rcvHistCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchReceiveHistByVVDRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorRcvHistVO.class);
			if (list.size() > 0 ) korRcvHistVOs = list.toArray(new KorRcvHistVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korRcvHistVOs;
	}

	/**
	 * 관세청에서 수신된 응답문서들의 현황을 MSG Type(5CG)과 B/L No로 조회
	 * @param KorRcvHistCondVO rcvHistCondVO
	 * @return KorRcvHistVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorRcvHistVO[] searchReceiveHistByBl(KorRcvHistCondVO rcvHistCondVO) throws DAOException
	{
		KorRcvHistVO[] korRcvHistVOs = null;
		List<KorRcvHistVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = rcvHistCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchReceiveHistByBlRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorRcvHistVO.class);
			if (list.size() > 0 ) korRcvHistVOs = list.toArray(new KorRcvHistVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korRcvHistVOs;
	}

	/**
	 * 관세청에서 수신된 응답문서들의 현황을 Submit No로 조회
	 * @param KorRcvHistCondVO rcvHistCondVO
	 * @return KorRcvHistVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorRcvHistVO[] searchReceiveHistBySubmitNo(KorRcvHistCondVO rcvHistCondVO) throws DAOException
	{
		KorRcvHistVO[] korRcvHistVOs = null;
		List<KorRcvHistVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = rcvHistCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchReceiveHistBySubmitNoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorRcvHistVO.class);
			if (list.size() > 0 ) korRcvHistVOs = list.toArray(new KorRcvHistVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korRcvHistVOs;
	}

	/**
	 * 관세청에서 수신된 응답문서들의 현황을 Receive Date 로 조회
	 * @param KorRcvHistCondVO rcvHistCondVO
	 * @return KorRcvHistVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorRcvHistVO[] searchReceiveHistByRcvDt(KorRcvHistCondVO rcvHistCondVO) throws DAOException
	{
		KorRcvHistVO[] korRcvHistVOs = null;
		List<KorRcvHistVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = rcvHistCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchReceiveHistByRcvDtRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorRcvHistVO.class);
			if (list.size() > 0 ) korRcvHistVOs = list.toArray(new KorRcvHistVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korRcvHistVOs;
	}

	/**
	 * 적재항의 ETD를 조회
	 * @param String vvdCd
	 * @param String polCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchOfmEtdDt(String vvdCd, String polCd) throws DAOException
	{
		String etdDt = "";

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd_cd", vvdCd);
			mapVO.put("pol_cd", polCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchOfmEtdDtRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) {
				etdDt = dbRowset.getString("VPS_ETD_DT");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return etdDt;
	}

	/**
	 * OutBound MSN Info 조회
	 * @param String bkgNo
	 * @param String mrnNo
	 * @return KorMsnInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorMsnInfoVO searchOfmMsnInfo(String bkgNo, String mrnNo) throws DAOException
	{
		KorMsnInfoVO korMsnInfoVO = null;
		List<KorMsnInfoVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("mrn_no", mrnNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchOfmMsnInfoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorMsnInfoVO.class);
			if (list!=null && list.size() > 0 ) korMsnInfoVO = list.get(0);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korMsnInfoVO;
	}

	/**
	 * OutBound Container Info 조회
	 * @param String bkgNo
	 * @return KorCntrDgVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorCntrDgVO[] searchOfmCntrInfo(String bkgNo) throws DAOException
	{
		KorCntrDgVO[] korCntrDgVOs = null;
		List<KorCntrDgVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchOfmCntrInfoRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorCntrDgVO.class);
			if (list.size() > 0 ) korCntrDgVOs = list.toArray(new KorCntrDgVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korCntrDgVOs;
	}

	/**
	 * CUSMOD, IMFMOD 전송시 수신자가 A (관세청, 해수부), C (관세청), P (해수부) 인지 여부 조회
	 *
	 * @param String submitAmdNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchAmdRcvCd(String submitAmdNo) throws DAOException
	{
		String rcvCd = "";

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("smt_amd_no", submitAmdNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOsearchAmdRcvCdRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) {
				rcvCd = dbRowset.getString("AMDT_RCVR_CD");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return rcvCd;
	}

	/**
	 * 5VJ(PORTAL) 수신 Receive Date로 조회
	 * @param rcvHistCondVO
	 * @return KorRcvHistVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public KorRcvHistVO[] searchReceiveHistByCxlRcvDt(KorRcvHistCondVO rcvHistCondVO) throws DAOException {
		KorRcvHistVO[] korRcvHistVOs = null;
		List<KorRcvHistVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = rcvHistCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new KoreaCustomsReportDBDAOSearchReceiveHistByCxlRcvDtRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KorRcvHistVO.class);
			if (list.size() > 0 ) korRcvHistVOs = list.toArray(new KorRcvHistVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return korRcvHistVOs;
	}
}