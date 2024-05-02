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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.basic.AncsCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsFltFileCusrepVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsSndHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsSndHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgCstmsAnrBlLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrCntrLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrEdiHisVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrEdiMsgVO;

/**
 * NIS2010 AncsCustomsTransmissionDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	public List<CstmsSndHisVO> searchAncsCstmsSndHisList( AncsCstmsSndHisListCondVO ancsCstmsSndHisListCondVO )
			throws DAOException {

		List<CstmsSndHisVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (ancsCstmsSndHisListCondVO != null)
			{
				Map<String, String> mapVO = ancsCstmsSndHisListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			//UI_BKG-0186
			if ( ancsCstmsSndHisListCondVO.getTarget().equals( "" ) ){
			
				DBRowSet dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new AncsCustomsTransmissionDBDAOsearchAncsCstmsSndHisListRSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, AncsCstmsSndHisVO.class);
			//UI_BKG-0183
			} else {
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
	public List<CstmsLogDtlVO> searchAncsCstmsLogDtl( AncsCstmsLogDtlCondVO ancsCstmsLogDtlCondVO )
			throws DAOException {

		List<CstmsLogDtlVO> list = null;

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
			int updCnt[] = null;
			if( bkgCstmsAnrEdiHisVOs.size() > 0){
				
				updCnt = sqlExe.executeBatch((ISQLTemplate) new AncsCustomsTransmissionDBDAOaddBkgCstmsAnrEdiHisCSQL(), bkgCstmsAnrEdiHisVOs, null);
			}							
			for (int i = 0; i < updCnt.length; i++)
			{
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify No" + i + " SQL");
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
			int updCnt[] = null;
			
			if( bkgCstmsAnrEdiMsgVOs.size() > 0){
				
				updCnt = sqlExe.executeBatch((ISQLTemplate) new AncsCustomsTransmissionDBDAOaddBkgCstmsAnrEdiMsgCSQL(), bkgCstmsAnrEdiMsgVOs, null);
				
			}							
			for (int i = 0; i < updCnt.length; i++)
			{
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify No" + i + " SQL");
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
			int updCnt[] = null;
			if( bkgCstmsAnrBlLogVOs.size() > 0){
				
				updCnt = sqlExe.executeBatch((ISQLTemplate) new AncsCustomsTransmissionDBDAOaddBkgCstmsAnrBlLogCSQL(), bkgCstmsAnrBlLogVOs, null);
			}							
			for (int i = 0; i < updCnt.length; i++)
			{
				if (updCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify No" + i + " SQL");
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
}