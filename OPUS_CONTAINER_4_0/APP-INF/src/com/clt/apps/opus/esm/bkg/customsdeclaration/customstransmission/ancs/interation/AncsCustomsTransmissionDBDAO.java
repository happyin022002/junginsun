/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AncsCustomsTransmissionDBDAO.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.10
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.06.10 정재엽
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.basic.AncsCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsFltFileCusrepVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsLogDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsLogDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsSndHisListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsSndHisVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsTransBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsTransCmVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsTransCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgCstmsAnrBlLogVO;
import com.clt.syscommon.common.table.BkgCstmsAnrCntrLogVO;
import com.clt.syscommon.common.table.BkgCstmsAnrEdiHisVO;
import com.clt.syscommon.common.table.BkgCstmsAnrEdiMsgVO;

/**
 * OPUS AncsCustomsTransmissionDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jeong Jae Yoeb
 * @see AncsCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class AncsCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * 세관 내역 조회
	 *
	 * @param ancsCstmsSndHisListCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsSndHisVO> searchAncsCstmsSndHisList(AncsCstmsSndHisListCondVO ancsCstmsSndHisListCondVO) throws DAOException {

		List<CstmsSndHisVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = ancsCstmsSndHisListCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			if ("".equals(ancsCstmsSndHisListCondVO.getTarget())) {
				//UI_BKG-0186
				DBRowSet dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new AncsCustomsTransmissionDBDAOsearchAncsCstmsSndHisListRSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, AncsCstmsSndHisVO.class);
			} else {
				//UI_BKG-0183
				DBRowSet dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new AncsCustomsTransmissionDBDAOsearchAncsCstmsSndHisList2RSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, AncsCstmsSndHisVO.class);
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * ANCS 세관 전송, 수신 메시지 상세 내용 조회
	 *
	 * @param ancsCstmsLogDtlCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AncsCstmsLogDtlVO> searchAncsCstmsLogDtl(AncsCstmsLogDtlCondVO ancsCstmsLogDtlCondVO) throws DAOException {

		List<AncsCstmsLogDtlVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (ancsCstmsLogDtlCondVO != null)
			{
				Map<String, String> mapVO = ancsCstmsLogDtlCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AncsCustomsTransmissionDBDAOsearchAncsCstmsLogDtlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AncsCstmsLogDtlVO.class);

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	/**
	 * antwrep 세관에 보낼 플랫파일 정보를 가져온다.
	 *
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @param transFlag
	 * @return List<AncsCstmsFltFileCusrepVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AncsCstmsFltFileCusrepVO> searchAncsCstmsFltFileCusrep( String vslCd, String skdVoyNo, String skdDirCd, String transFlag ) throws DAOException {

		DBRowSet dbRowset = null;
		List<AncsCstmsFltFileCusrepVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if ( vslCd != null && skdVoyNo !=null && skdDirCd != null)
			{
				Map<String, String> mapVO = new HashMap<String, String>();//ancsCstmsVesselArrivalCondVO.getColumnValues();
				mapVO.put("vsl_cd", vslCd );
				mapVO.put("skd_voy_no", skdVoyNo );
				mapVO.put("skd_dir_cd", skdDirCd );
				mapVO.put("trans_flag", transFlag );
				param.putAll( mapVO );
				velParam.putAll( mapVO );
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AncsCustomsTransmissionDBDAOsearchAncsCstmsFltFileCusrepRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AncsCstmsFltFileCusrepVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 벨기에 세관 전송 기록을 남김
	 *
	 * @param bkgCstmsAnrEdiHisVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBkgCstmsAnrEdiHis ( List<BkgCstmsAnrEdiHisVO> bkgCstmsAnrEdiHisVOs ) throws DAOException,Exception {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] ;
			if( bkgCstmsAnrEdiHisVOs.size() > 0){

				updCnt = sqlExe.executeBatch((ISQLTemplate) new AncsCustomsTransmissionDBDAOaddBkgCstmsAnrEdiHisCSQL(), bkgCstmsAnrEdiHisVOs, null);

				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 벨기에 세관 전송 기록 메시지를 기록 함
	 *
	 * @param bkgCstmsAnrEdiMsgVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBkgCstmsAnrEdiMsg ( List<BkgCstmsAnrEdiMsgVO> bkgCstmsAnrEdiMsgVOs ) throws DAOException,Exception {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[];

			if( bkgCstmsAnrEdiMsgVOs.size() > 0){

				updCnt = sqlExe.executeBatch((ISQLTemplate) new AncsCustomsTransmissionDBDAOaddBkgCstmsAnrEdiMsgCSQL(), bkgCstmsAnrEdiMsgVOs, null);

				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 벨기에 세관 전송 기록을 B/L 단위로 기록
	 *
	 * @param List<BkgCstmsAnrBlLogVO> bkgCstmsAnrBlLogVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBkgCstmsAnrBlLog ( List<BkgCstmsAnrBlLogVO> bkgCstmsAnrBlLogVOs ) throws DAOException,Exception {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[];
			if( bkgCstmsAnrBlLogVOs.size() > 0){

				updCnt = sqlExe.executeBatch((ISQLTemplate) new AncsCustomsTransmissionDBDAOaddBkgCstmsAnrBlLogCSQL(), bkgCstmsAnrBlLogVOs, null);

				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 벨기에 세관 전송 기록을 CNTR 단위로 기록
	 *
	 * @param  List<BkgCstmsAnrCntrLogVO> bkgCstmsAnrCntrLogVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBkgCstmsAnrCntrLog ( List<BkgCstmsAnrCntrLogVO> bkgCstmsAnrCntrLogVOs ) throws DAOException,Exception {

		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if( bkgCstmsAnrCntrLogVOs.size() > 0){

				updCnt = sqlExe.executeBatch((ISQLTemplate) new AncsCustomsTransmissionDBDAOaddBkgCstmsAnrCntrLogCSQL(), bkgCstmsAnrCntrLogVOs, null);

				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 해당 VVD에 관련있는 B/L 또는 CNTR별로 CUSCAR 전송 후 Accepted Status를 가지고 있는 건이 있는지 확인
	 *
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public boolean checkIfAcptCuscarExist( String vslCd, String skdVoyNo, String skdDirCd ) throws DAOException,Exception{
		boolean isExt = false;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try	{

			Map<String, String> mapVO = new HashMap<String, String> ();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", skdVoyNo);
			mapVO.put("skd_dir_cd", skdDirCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AncsCustomsTransmissionDBDAOcheckIfAcptCuscarExistRSQL(), param, velParam);

			if( dbRowset.next() ){
				String sCnt = dbRowset.getString("CNT");
				if( Integer.parseInt(sCnt) > 0 )
					isExt = true;
				else
					isExt = false;
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isExt;
	}

	/**
	 * CTransmission Flag 가 Replace 일때 [시작]
	 * 1. 변환된 데이터가 없을때는 업데이트 하지 않고 예외 처리를 한다.
	 * 2. 변환된 데이터가 있을때는 바뀐 데이터 만 추출하여 전송을 한다.
	 *
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @param anrDeclNo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AncsCstmsManifestVO> searchAncsCusrepCngList(String vslCd, String skdVoyNo, String skdDirCd, String anrDeclNo ) throws DAOException {

		DBRowSet dbRowset = null;
		List<AncsCstmsManifestVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", skdVoyNo);
			mapVO.put("skd_dir_cd", skdDirCd);
			mapVO.put("anr_decl_no", anrDeclNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AncsCustomsTransmissionDBDAOsearchAncsCusrepCngListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AncsCstmsManifestVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * EDI 수신 이력을 저장한다.
	 *
	 * @param bkgCstmsAnrEdiHisVO
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAnrEdiHis(List<BkgCstmsAnrEdiHisVO> bkgCstmsAnrEdiHisVO  )throws DAOException{

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAnrEdiHisVO.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new AncsCustomsTransmissionDBDAOmodifyBkgCstmsAnrEdiHisUSQL(),
						bkgCstmsAnrEdiHisVO, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EDI 수신 이력을 저장한다.
	 *
	 * @param bkgCstmsAnrBlLogVOs
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAnrBlLog(List<BkgCstmsAnrBlLogVO> bkgCstmsAnrBlLogVOs  )throws DAOException{

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAnrBlLogVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new AncsCustomsTransmissionDBDAOmodifyBkgCstmsAnrBlLogUSQL(),
						bkgCstmsAnrBlLogVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EDI 수신 이력을 저장한다.
	 *
	 * @param bkgCstmsAnrCntrLogVOs
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAnrCntrLog(List<BkgCstmsAnrCntrLogVO> bkgCstmsAnrCntrLogVOs  )throws DAOException{

		try
		{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAnrCntrLogVOs.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new AncsCustomsTransmissionDBDAOmodifyBkgCstmsAnrCntrLogUSQL(),
						bkgCstmsAnrCntrLogVOs, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CUSCAR 전송을 위한 BL조회
	 * @param blNo
	 * @param vvd
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AncsCstmsTransBlVO searchTransBl(String blNo, String vvd) throws DAOException {

		AncsCstmsTransBlVO blInfo = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try
		{
			param.put("bl_no", blNo);
			param.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new AncsCustomsTransmissionDBDAOsearchTransBlRSQL(), param, null);
			List<AncsCstmsTransBlVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, AncsCstmsTransBlVO.class);
			if (list.size() > 0)
			{
				blInfo = (AncsCstmsTransBlVO)list.get(0);
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return blInfo;
	}

	/**
	 * CUSCAR 전송을 위한 CM조회
	 * @param blNo
	 * @param vvd
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AncsCstmsTransCmVO> searchTransCm(String blNo, String vvd) throws DAOException {

		List<AncsCstmsTransCmVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try
		{
			param.put("bl_no", blNo);
			param.put("vvd", vvd);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new AncsCustomsTransmissionDBDAOsearchTransCmRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AncsCstmsTransCmVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * CUSCAR 전송을 위한 CNTR조회
	 * @param blNo
	 * @param arrCntrNo
	 * @param vvd
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AncsCstmsTransCntrVO> searchTransCntr(String blNo, List<String> arrCntrNo, String vvd) throws DAOException {

		List<AncsCstmsTransCntrVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			param.put("bl_no", blNo);
			param.put("cntr_no", arrCntrNo);
			param.put("vvd", vvd);
			if (arrCntrNo.size() == 0)
				param.put("cntr_chk", "");
			else
				param.put("cntr_chk", "Y");
			velParam.putAll(param);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new AncsCustomsTransmissionDBDAOsearchTransCntrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AncsCstmsTransCntrVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * CUSCAR 전송 할 때 B/L 테이블의 ANR_MSG_STS_CD 초기화
	 * @param String blNo
	 * @param String vvd
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAnrBlAnrMsgStsCd(String blNo, String vvd) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = -1;
		try
		{
			param.put("bl_no", blNo);
			param.put("vvd", vvd);
			velParam.putAll(param);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new AncsCustomsTransmissionDBDAOmodifyBlAnrMsgStsCdUSQL(),param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CUSCAR 전송 할 때 CNTR 테이블의 ANR_MSG_STS_CD 초기화
	 * @param String bkgNo
	 * @param List<String> arrCntrNo
	 * @param String vvd
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAnrCntrAnrMsgStsCd(String bkgNo, List<String> arrCntrNo, String vvd) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = -1;
		try
		{
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", arrCntrNo);
			param.put("vvd", vvd);
			if (arrCntrNo.size() == 0){
				param.put("cntr_chk", "");
			}
			else{
				param.put("cntr_chk", "Y");
			}
			velParam.putAll(param);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new AncsCustomsTransmissionDBDAOmodifyCntrAnrMsgStsCdUSQL(),param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CUSCAR 전송 할 때 BKG_CSTMS_ANR_BL 테이블에 같은 VVD의 MAX(VVD_SEQ)+1 업데이트
	 * @param String vvd
	 * @param String bkgNo
	 * @param String dupSsrNo
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAnrBlVvdSeq(String vvd, String bkgNo, String dupSsrNo) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = -1;
		try
		{
			param.put("vvd", vvd);
			param.put("bkg_no", bkgNo);
			param.put("dup_ssr_no", dupSsrNo);
			velParam.putAll(param);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new AncsCustomsTransmissionDBDAOmodifyBlVvdSeqUSQL(),param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VVD_SEQ 입력을 위해서 중복 SSR 검색
	 * @param vvd
	 * @return String retVal
	 * @throws DAOException
	 */
	public String searchDuplicatedSsrNo(String vvd) throws DAOException {

		String retVal ="";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			param.put("vvd", vvd);
			velParam.putAll(param);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AncsCustomsTransmissionDBDAOsearchDupSsrNoRSQL(), param, velParam);
			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

}