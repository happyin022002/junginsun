/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAO.java
*@FileTitle : Kor24CustomsTransmissionDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.05.20 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.BkgCstmsKrBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.BkgCstmsKrSndLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.BkgCstmsKrSndLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.BkgCstmsKrVvdSmryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24AutoImfSndDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24AutoImfSndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24AutoMacSndDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24AutoMacSndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24CntrCntVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24CorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24CusmanVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24CusrepVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24DiscFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24EmpImfmodVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24EmpMacamdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24ImfmodVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24MacamdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24MakeSubNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24UNLocVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 CustomsTransmissionDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author charves
 * @see Kor24eaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
public class Kor24CustomsTransmissionDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = -6816308847573890143L;

	/**
	 * 전송 일시(현재일시) 조회
	 * @return String
	 * @exception DAOException
	 */
	public String searchSysDate() throws DAOException
	{
		String sysDate = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOSearchSysDateRSQL(), param, velParam);
			if(dbRowset.next()) sysDate = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sysDate;
	}

	/**
	 * 한국세관 BL INFO 조회
	 * @param BkgCstmsKrBlVO bkgCstmsKrBlVO
	 * @return BkgCstmsKrBlVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsKrBlVO searchBlInfoKor24(BkgCstmsKrBlVO bkgCstmsKrBlVO) throws DAOException
	{
		List <BkgCstmsKrBlVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		BkgCstmsKrBlVO returnVal = null;
		try
		{
			Map<String, String> mapVO = bkgCstmsKrBlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOSearchBlInfoKorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrBlVO.class);
			if(list == null) return null;
			if(list.size() > 0)
			{
				returnVal = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return returnVal;
	}

	/**
	 * OUTBOUND 의 POL에 대한 UNLOCODE 검색
	 * @param String polCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchOBUNLocCd(String polCd) throws DAOException
	{
		String unPolCd = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("pol_cd", polCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOsearchOBUNLocCdRSQL(), param, velParam);
			if (dbRowset.next()) unPolCd = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return unPolCd;
	}

	/**
	 * INBOUND 의 POD에 대한 UNLOCODE 검색
	 * @param String podCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchIBUNLocCd(String podCd) throws DAOException
	{
		String unPodCd = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("pod_cd", podCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOsearchIBUNLocCdRSQL(), param, velParam);
			if (dbRowset.next()) unPodCd = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return unPodCd;
	}

	/**
	 * CUSREP 전송 로그 기록
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void addCUSREPSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddCUSREPSndLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * CUSREP 전송 세부 로그 기록
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @exception DAOException
	 */
	public void addCUSREPSndDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddCUSREPSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * CUSMAN LOG 관리를 위한 작업(DETAIL) : 전송 결과를 남긴다
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @exception DAOException
	 */
	public void addCUSMANSndDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddCUSMANSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * LOG 관리를 위한 작업(DETAIL) => 하선신고서의 Body Flat File에 대한 (56번 조회 데이터) 전송결과 저장
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @exception DAOException
	 */
	public void addDiscBodySendDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddDiscBodySendDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Export License No 전송 LOG 관리를 위한 작업(DETAIL) => CUSMAN flat file에 같이 붙여서 전송됨
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @exception DAOException
	 */
	public void addCUSMANExpSndDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO) throws DAOException
	{

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddCUSMANExpSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * CNTR 전송 LOG 관리를 위한 작업(DETAIL)
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVOs
	 * @exception DAOException
	 */
	public void addCUSMANCNTRSndDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVOs) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVOs.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddCUSMANCNTRSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 일괄정정, 일괄삭제(MACAMD) Master LOG Table로 전송일, VVD, B/L Info. 저장
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void addMACAMDModiDelSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddMACAMDModiDelSndLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MACAMD Detail LOG Table로 전송일 및 Flat File 내용 저장
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @exception DAOException
	 */
	public void addMACAMDModiDelSndDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO)throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddMACAMDModiDelSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 하선신고서의 전송결과에 대한 Log를 기록
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void addDiscSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddDiscSndLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * LOG 관리를 위한 작업(DETAIL) => 하선신고서의 CNTR Flat File에 대한 (60번 조회 데이터) 전송결과 저장
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @exception DAOException
	 */
	public void addDiscCNTRSendDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddDiscCNTRSendDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 정정부호 전송 내역을 Detail LOG Table로 전송일 및 Flat File 내용 저장
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @exception DAOException
	 */
	public void addMACAMDModiCdSndDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO)throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddMACAMDModiCdSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * LOG 관리를 위한 작업(DETAIL) => 하선신고서의 Header File에 대한 (52번 조회 데이터) 전송결과 저장
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @exception DAOException
	 */
	public void addDiscHeadSndDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddDiscHeadSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Flat File 처리후 결과 리턴
	 * @return String
	 * @exception DAOException
	 */
	public String makeFlatFileEnd()throws DAOException
	{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String flatData = null;
		try
		{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOMakeFlatFileEndRSQL(), param, velParam);
			if(dbRowset.next())
			{
				flatData = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flatData;
	}

	/**
	 * UNLOC 코드 조회
	 * @param String polCd
	 * @param String podCd
	 * @return Kor24UNLocVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24UNLocVO searchUNLocCd(String polCd, String podCd)throws DAOException
	{
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<Kor24UNLocVO> list = null;
		Kor24UNLocVO returnVal = null;
		try
		{
			param.put("pol_cd", polCd);
			param.put("pod_cd", podCd);
			velParam.put("pol_cd", polCd);
			velParam.put("pod_cd", podCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOSearchUNLocCdRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24UNLocVO.class);
			if(list == null) return null;
			if(list.size() > 0)
			{
				returnVal = list.get(0);
			}
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return returnVal;
	}

	/**
	 * 한국세관의 VVD Table로 Download된 상태를 조회한다.
	 * @param BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO
	 * @return BkgCstmsKrVvdSmryVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsKrVvdSmryVO searchMrnNoKor24(BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO) throws DAOException
	{
		BkgCstmsKrVvdSmryVO outVO = null;
		List<BkgCstmsKrVvdSmryVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = bkgCstmsKrVvdSmryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOsearchMrnNoKorRSQL(),param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsKrVvdSmryVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return outVO;
	}

	/**
	 * FLATFILE 헤더 생성
	 * @param Kor24DiscFlatFileVO discFlatFileVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeDiscHeadFlatFile(Kor24DiscFlatFileVO discFlatFileVO) throws DAOException
	{
		String header = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = discFlatFileVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOmakeDiscHeadFlatFileRSQL(),param, velParam);
			if(dbRowset.next()) header = dbRowset.getString(1);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return header;
	}

	/**
	 * Transmit시 BL FlatFile 의 BODY 부분 추출
	 * @param Kor24DiscFlatFileVO discFlatFileVO
	 * @return Kor24DiscFlatFileVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24DiscFlatFileVO[] makeDiscBodyFlatFile(Kor24DiscFlatFileVO discFlatFileVO) throws DAOException
	{
		Kor24DiscFlatFileVO[] kor24DiscFlatFileVOs = null;
		List<Kor24DiscFlatFileVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = discFlatFileVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOmakeDiscBodyFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24DiscFlatFileVO.class);
			if (list.size() < 1) return null;
			kor24DiscFlatFileVOs = list.toArray(new Kor24DiscFlatFileVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24DiscFlatFileVOs;

	}

	/**
	 * Container FlatFile 생성
	 * @param Kor24DiscFlatFileVO discFlatFileVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] makeDiscCntrFlatFile(Kor24DiscFlatFileVO discFlatFileVO) throws DAOException
	{
		String[] cntrDatas = null;
		List<String> list = new ArrayList<String>();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = discFlatFileVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOmakeDiscCntrFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			while(dbRowset.next()) {
				list.add(dbRowset.getString(1));
			}
			cntrDatas = list.toArray(new String[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cntrDatas;
	}

	/**
	 * BKG_CSTMS_KR_SND_LOG 테이블에 CNTR의 Type Size count정보를 남기기위해서 조회
	 * @param Kor24CntrCntVO cntrCntVO
	 * @return Kor24CntrCntVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24CntrCntVO searchTeuFeuCnt(Kor24CntrCntVO cntrCntVO) throws DAOException
	{
		Kor24CntrCntVO kor24CntrCntVO = null;
		List<Kor24CntrCntVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = cntrCntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOsearchTeuFeuCntRSQL(),param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24CntrCntVO.class);
			if (list!=null && list.size() > 0) kor24CntrCntVO = list.get(0);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24CntrCntVO;
	}

	/**
	 * FLAT FILE의 마지막 END 부분 생성
	 * @return
	 * @exception DAOException
	 */
	public String makeDiscEndFlatFile() throws DAOException
	{
		String endData = null;

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOmakeDiscEndFlatFileRSQL(),param, velParam);
			if(dbRowset.next()) endData = dbRowset.getString(1);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return endData;
	}

	/**
	 *  TEU, FEU CNTR Type Size Count를 Update
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void modifyDiscSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOmodifyDiscSndLogUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * CUSREP Flat File Header를 만든다.
	 * @param Kor24CusrepVO cusrepVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeCUSREPFlatFile(Kor24CusrepVO cusrepVO) throws DAOException
	{
		String header = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = cusrepVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOmakeCUSREPFlatFileRSQL(),param, velParam);
			if(dbRowset.next()) header = dbRowset.getString(1);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return header;
	}

	/**
	 * 공동 VVD 용 CUSREP Flat File Header를 만든다.
	 * @param Kor24CusrepVO cusrepVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeCUSREPNoneBLVVDFlatFile(Kor24CusrepVO cusrepVO) throws DAOException
	{
		String header = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = cusrepVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOmakeCUSREPNoneBlVVDFlatFileRSQL(),param, velParam);
			if(dbRowset.next()) header = dbRowset.getString(1);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return header;
	}

	/**
	 * CUSMAN 의 BL Info Flat File을 만든다.
	 * @param Kor24CusmanVO cusmanVO
	 * @return Kor24CusmanVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24CusmanVO[] makeCUSMANBlFlatFile(Kor24CusmanVO cusmanVO) throws DAOException
	{
		Kor24CusmanVO[] kor24CusmanVOs = null;
		List<Kor24DiscFlatFileVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = cusmanVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOmakeCUSMANBlFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24CusmanVO.class);
			if (list.size() < 1) return null;
			kor24CusmanVOs = list.toArray(new Kor24CusmanVO[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24CusmanVOs;
	}

	/**
	 * Export License Flat File 생성
	 * @param Kor24CusmanVO cusmanVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] makeCUSMANExpFlatFile(Kor24CusmanVO cusmanVO) throws DAOException
	{
		String[] elDatas = null;
		List<String> list = new ArrayList<String>();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = cusmanVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOmakeCUSMANExpFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			while(dbRowset.next()) {
				list.add(dbRowset.getString(1));
			}
			elDatas = list.toArray(new String[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return elDatas;
	}

	/**
	 * CUSMAN의 CNTR정보에 대한 Flat file을 만든다.
	 * @param Kor24CusmanVO cusmanVO
	 * @return String
	 * @exception DAOException
	 */
	public String[] makeCUSMANCntrFlatFile(Kor24CusmanVO cusmanVO) throws DAOException
	{
		String[] cntrDatas = null;
		List<String> list = new ArrayList<String>();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = cusmanVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOmakeCUSMANCntrFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			while(dbRowset.next()) {
				list.add(dbRowset.getString(1));
			}
			cntrDatas = list.toArray(new String[0]);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cntrDatas;
	}

	/**
	 * TEU, FEU CNTR Type Size Count를 Update한다.
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void modifyCUSREPSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOmodifyCUSREPSndLogUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MACAMD Flatfile을 만든다. (HEADER)
	 * @param Kor24MacamdVO macamdVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeMACAMDFlatFile(Kor24MacamdVO macamdVO) throws DAOException
	{
		String header = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = macamdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOmakeMACAMDFlatFileRSQL(),param, velParam);
			if(dbRowset.next()) header = dbRowset.getString(1);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return header;
	}

	/**
	 * 정정부호 전송내역 FlatFile 생성
	 * @param Kor24CorrVO corrVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeCorrFlatFile(Kor24CorrVO corrVO) throws DAOException
	{
		String corrData = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = corrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOmakeCorrFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			while(dbRowset.next())  corrData = dbRowset.getString(1);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return corrData;
	}

	/**
	 * End Flat file LOG 관리를 위한 작업(DETAIL)
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @exception DAOException
	 */
	public void addDiscEndSendDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddDiscEndSendDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 전송 되었던 정정신고인지 다시 확인
	 * @param String subNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchTransmitChk(String subNo) throws DAOException
	{
		String transChk = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sub_no", subNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOsearchTransmitChkRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) transChk = dbRowset.getString(1);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return transChk;
	}

	/**
	 * 사용자 ID로 사용자 이름 조회
	 * @param String userId
	 * @return String
	 * @exception DAOException
	 */
	public String searchComUser(String userId) throws DAOException
	{
		String userName = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("user_id", userId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOsearchComUserRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) userName = dbRowset.getString(1);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return userName;
	}

	/**
	 * CUSMOD 전송 로그 기록
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void addCUSMODSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddCUSMODSndLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * CUSMOD 세부 전송 로그 기록
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @exception DAOException
	 */
	public void addCUSMODSndDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddCUSMODSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 전송여부 CHECK
	 * @param String bkgNo
	 * @param String ktPort
	 * @param String kcdTp
	 * @return String
	 * @exception DAOException
	 */
	public String searchTransndChk(String bkgNo, String ktPort, String kcdTp) throws DAOException
	{
		String transChk = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", 			bkgNo);
			mapVO.put("port_cd", 			ktPort);
			mapVO.put("cstms_decl_tp_cd", 	kcdTp);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOsearchTransndChkRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) transChk = dbRowset.getString(1);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return transChk;
	}

	/**
	 * IMFMOD BL Flat File 생성
	 * @param Kor24ImfmodVO imfmodVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeIMFMODBlFlatFile(Kor24ImfmodVO imfmodVO) throws DAOException
	{
		String flatFile = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = imfmodVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOmakeIMFMODBlFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) flatFile = dbRowset.getString(1);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return flatFile;
	}

	/**
	 * IMFMOD 전송 로그 기록
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void addIMFMODSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddIMFMODSndLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * IMFMOD 전송 Detail 내역(Flat File)을 기록
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @exception DAOException
	 */
	public void addIMFMODSndDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddIMFMODSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * IMFMOD CNTR Flat File 생성
	 * @param Kor24ImfmodVO imfmodVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeIMFMODCntrFlatFile(Kor24ImfmodVO imfmodVO) throws DAOException
	{
		String flatFile = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = imfmodVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOmakeIMFMODCntrFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) flatFile = dbRowset.getString(1);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return flatFile;
	}

	/**
	 * IMFMOD Correction Flat File 생성
	 * @param Kor24ImfmodVO imfmodVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeIMFMODCorrFlatFile(Kor24ImfmodVO imfmodVO) throws DAOException
	{
		String flatFile = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = imfmodVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOmakeIMFMODCorrFlatFileRSQL(), param, velParam);
			if (dbRowset==null) return null;
			if (dbRowset.next()) flatFile = dbRowset.getString(1);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return flatFile;
	}

	/**
	 * MACAMD Flatfile 생성
	 * @param Kor24MacamdVO macamdVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeMACAMDAmdFlatFile(Kor24MacamdVO macamdVO) throws DAOException
	{
		String flatFile = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = macamdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			log.debug(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOmakeMACAMDAmdFlatFileRSQL(),param, velParam);
			if(dbRowset.next()) flatFile = dbRowset.getString(1);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return flatFile;
	}

	/**
	 * MACAMD Send Log를 기록
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @exception DAOException
	 */
	public void addMACAMDSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddMACAMDSndLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MACAMD Send Detail Log를 기록
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @exception DAOException
	 */
	public void addMACAMDSndDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddMACAMDSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MACAMD CNTR Flat File 생성
	 * @param Kor24MacamdVO macamdVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeMACAMDAmdCntrFlatFile(Kor24MacamdVO macamdVO) throws DAOException
	{
		String flatFile = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = macamdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOmakeMACAMDAmdCntrFlatFileRSQL(),param, velParam);
			if(dbRowset.next()) flatFile = dbRowset.getString(1);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return flatFile;
	}

	/**
	 * MACAMD CORR Flat File 생성
	 * @param Kor24MacamdVO macamdVO
	 * @return String
	 * @exception DAOException
	 */
	public String makeMACAMDAmdCorrFlatFile(Kor24MacamdVO macamdVO) throws DAOException
	{
		String flatFile = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = macamdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOmakeMACAMDAmdCorrFlatFileRSQL(),param, velParam);
			if(dbRowset.next()) flatFile = dbRowset.getString(1);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return flatFile;
	}

	/**
	 * 응답메시지 수신에 앞서서 Seq값의 Max + 1 값을 조회
	 * @param String flatNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchCstmMaxAckSeq(String flatNo) throws DAOException
	{
		String maxRcvSeq = "1";
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("flt_file_ref_no", flatNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOsearchCstmMaxAckSeqRSQL(),param, velParam);
			if(dbRowset.next()) maxRcvSeq = dbRowset.getString(1);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return maxRcvSeq;
	}

	/**
	 * Empty B/L Type 정정에 대한 IMFMOD Flat File 생성
	 * @param Kor24EmpImfmodVO empImfModVO
	 * @return Kor24EmpImfmodVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24EmpImfmodVO makeAutoIMFMODFlatFile(Kor24EmpImfmodVO empImfModVO) throws DAOException
	{
		Kor24EmpImfmodVO kor24EmpImfmodVO = null;
		List<Kor24EmpImfmodVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = empImfModVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOmakeAutoIMFMODFlatFileRSQL(),param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24EmpImfmodVO.class);
			if (list!=null && list.size() > 0) kor24EmpImfmodVO = list.get(0);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24EmpImfmodVO;
	}

	/**
	 * Send Log 의 Max Seq+1 조회
	 *
	 * @param String logDate
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxImfSndLogSeq(String logDate, String ofcCd) throws DAOException
	{
		String maxSeq = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("log_date", logDate);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOsearchMaxImfSndLogSeqRSQL(),param, velParam);
			if(dbRowset.next()) maxSeq = dbRowset.getString(1);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return maxSeq;
	}

	/**
	 * Master LOG Table로 전송일, VVD, B/L Info. 저장
	 *
	 * @param Kor24AutoImfSndVO autoImfSndVO
	 * @throws DAOException
	 */
	public void addAutoIMFMODSndLog(Kor24AutoImfSndVO autoImfSndVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = null;
		try
		{
			mapVO = autoImfSndVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddAutoIMFMODSndLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Detail LOG Table로 전송일, VVD, B/L Info. 저장
	 *
	 * @param Kor24AutoImfSndDtlVO autoImfSndDtlVO
	 * @throws DAOException
	 */
	public void addAutoIMFMODSndDtlLog(Kor24AutoImfSndDtlVO autoImfSndDtlVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = null;
		try
		{
			mapVO = autoImfSndDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddAutoIMFMODSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 단일항목 정정 FlatFile 생성
	 * @return String
	 * @throws DAOException
	 */
	public String makeAutoIMFMODCorrFlatFile() throws DAOException
	{
		String corrData = "";
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOmakeAutoIMFMODCorrFlatFileRSQL(),param, velParam);
			if(dbRowset.next()) corrData = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return corrData;
	}

	/**
	 * Empty B/L Type 정정에 대한 MACAMD Flat File 생성
	 *
	 * @param Kor24EmpMacamdVO empMacamdVO
	 * @return Kor24EmpMacamdVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Kor24EmpMacamdVO makeAutoMACAMDFlatFile(Kor24EmpMacamdVO empMacamdVO) throws DAOException
	{
		Kor24EmpMacamdVO kor24EmpMacamdVO = null;
		List<Kor24EmpMacamdVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = empMacamdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOmakeAutoMACAMDFlatFileRSQL(),param, velParam);
			if (dbRowset==null) return null;
			list =  (List)RowSetUtil.rowSetToVOs(dbRowset, Kor24EmpMacamdVO.class);
			if (list!=null && list.size() > 0) kor24EmpMacamdVO = list.get(0);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return kor24EmpMacamdVO;
	}

	/**
	 * MAC Send Log 의 Max Seq+1 조회
	 *
	 * @param String sndDt
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxMacSndLogSeq(String sndDt, String ofcCd) throws DAOException
	{
		String maxSeq = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("snd_dt", sndDt);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOsearchMaxMacSndLogSeqRSQL(),param, velParam);
			if(dbRowset.next()) maxSeq = dbRowset.getString(1);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return maxSeq;
	}

	/**
	 * Master LOG Table로 전송일, VVD, B/L Info. 저장
	 *
	 * @param Kor24AutoMacSndVO autoMacSndVO
	 * @throws DAOException
	 */
	public void addAutoMACAMDSndLog(Kor24AutoMacSndVO autoMacSndVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = null;
		try
		{
			mapVO = autoMacSndVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddAutoMACAMDSndLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Detail LOG Table로 전송일, VVD, B/L Info. 저장
	 *
	 * @param Kor24AutoMacSndDtlVO autoMacSndDtlVO
	 * @throws DAOException
	 */
	public void addAutoMACAMDSndDtlLog(Kor24AutoMacSndDtlVO autoMacSndDtlVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = null;
		try
		{
			mapVO = autoMacSndDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddAutoMACAMDSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 단일항목 정정 FlatFile 생성
	 * @return String
	 * @throws DAOException
	 */
	public String makeAutoMACAMDCorrFlatFile() throws DAOException
	{
		String corrData = "";
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOmakeAutoMACAMDCorrFlatFileRSQL(),param, velParam);
			if(dbRowset.next()) corrData = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return corrData;
	}

	/**
	 * CUSMAN FlatFile 의 MULTI Seal Number 조회
	 *
	 * @param Kor24CusmanVO cusmanVO
	 * @return String
	 * @throws DAOException
	 */
	public String makeCUSMANSealFlatFile(Kor24CusmanVO cusmanVO) throws DAOException
	{
		String sealNumbers = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = cusmanVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Kor24CustomsTransmissionDBDAOmakeCUSMANSealFlatFileRSQL(), param, velParam);
			if (dbRowset!=null && dbRowset.next()) sealNumbers = dbRowset.getString(1);
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return sealNumbers;
	}

	/**
	 * CUSDMR 전송 로그 기록
	 *
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @throws DAOException
	 */
	public void addCUSDMRSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddCUSDMRSndLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * CUSDMR 전송 상세 로그 기록
	 *
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @throws DAOException
	 */
	public void addCUSDMRSndDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddCUSDMRSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Submit No 생성
	 * @param Kor24MakeSubNoVO makeSubNoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMakeSubNo(Kor24MakeSubNoVO makeSubNoVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		String subNo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = makeSubNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOsearchMakeSubNoRSQL(),param, velParam);
			if (dbRowset.next()) subNo = dbRowset.getString(1);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return subNo;
	}

	/**
	 * PORTAL 전송 로그 기록
	 *
	 * @param BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO
	 * @throws DAOException
	 */
	public void addPORTALSndLog(BkgCstmsKrSndLogVO bkgCstmsKrSndLogVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddPORTALSndLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PORTAL 전송 상세 로그 기록
	 *
	 * @param BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO
	 * @throws DAOException
	 */
	public void addPORTALSndDtlLog(BkgCstmsKrSndLogDtlVO bkgCstmsKrSndLogDtlVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsKrSndLogDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new Kor24CustomsTransmissionDBDAOaddPORTALSndDtlLogCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PORTAL 전송 Seq값의 Max + 1 값을 조회
	 *
	 * @param String sndDt
	 * @param String ofcCd
	 * @return maxSeq
	 * @throws DAOException
	 */
	public String searchMaxPortalSndSeq(String sndDt, String ofcCd) throws DAOException
	{
		String maxSeq = "";
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("snd_dt", sndDt);
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Kor24CustomsTransmissionDBDAOsearchMaxPortalSndLogSeqRSQL(),param, velParam);
			if(dbRowset.next()) maxSeq = dbRowset.getString(1);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return maxSeq;
	}

	   /**
     * DEL_CD 가져오는 쿼리 .
     *
     *
     * @param String vvdCd
     * @param String polCd
     * @return String flg
     * @exception DAOException
     */
    public String searchDelCd(String vvdCd, String polCd) throws DAOException {
    	// input_text
        String flg = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("vvd_cd", vvdCd);
        	velParam.put("vvd_cd", vvdCd);
        	param.put("pol_cd", polCd);
        	velParam.put("pol_cd", polCd);
			SQLExecuter sqlExe = new SQLExecuter("");
			Kor24CustomsTransmissionDBDAOsearchDelCdRSQL template = new Kor24CustomsTransmissionDBDAOsearchDelCdRSQL();

			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);


			if (dbRowset.next()) {
				flg = dbRowset.getString("del_cd");
			} else {
				flg = "";
			}


        } catch(SQLException ex) {
            // log.error(se.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return flg;
    }

}