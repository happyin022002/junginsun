/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BrcsCustomsTransmissionDBDAO.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.05.25 경종윤
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2012.06.20 김보배 [CHM-201218404] [BKG] [EXS] "Hold Release" Manual Update 기능
 * 2013.06.25 김보배 [CHM-201324814] [ENS FI] Finland 세관 ENS 개발 요청 (IE344, IE347)
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.basic.BrcsCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eu24RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCMinfoListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCMinfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCntrListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCntrMfListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCntrMfListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCntrSealListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCntrSealListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCustListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCustListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlDgCgoListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlDgCgoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlForEmlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlRouteCntListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlinfoOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlinfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24DiversionRequestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24SendHistoryOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24SendHistoryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24VesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselFIArrivalNoticeDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS BrcsCustomsTransmissionDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kyoung Jong Yun
 * @see BrcsCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class Eur24CustomsTransmissionDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	public Eur24CustomsTransmissionDBDAO() {}

	/**
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다. <br>
	 * 
	 * @param eur24VesselArrivalTransmitVO
	 * @param signOnUserAccount
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24VesselArrivalVO> searchVesselArrival (Eur24VesselArrivalTransmitVO eur24VesselArrivalTransmitVO,  SignOnUserAccount signOnUserAccount) throws DAOException {
		List<Eur24VesselArrivalVO> list = null;
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(eur24VesselArrivalTransmitVO != null){
				Map<String, String> mapVO = eur24VesselArrivalTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOsearchVesselArrivalRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24VesselArrivalVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다. <br>
	 * 
	 * @param Eur24VesselFIArrivalNoticeDetailVO eur24VesselArrivalTransmitVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24VesselArrivalVO> searchVesselArrivalFI (Eur24VesselFIArrivalNoticeDetailVO eur24VesselArrivalTransmitVO,  SignOnUserAccount signOnUserAccount) throws DAOException {
		List<Eur24VesselArrivalVO> list = null;
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(eur24VesselArrivalTransmitVO != null){
				Map<String, String> mapVO = eur24VesselArrivalTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOsearchVesselArrivalFIRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24VesselArrivalVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다. <br>
	 * 
	 * @param eur24VesselArrivalTransmitVO
	 * @param signOnUserAccount
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24DiversionRequestVO> searchDiversionRequest (Eur24VesselArrivalTransmitVO eur24VesselArrivalTransmitVO,  SignOnUserAccount signOnUserAccount) throws DAOException {
		List<Eur24DiversionRequestVO> list = null;
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(eur24VesselArrivalTransmitVO != null){
				Map<String, String> mapVO = eur24VesselArrivalTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOsearchDiversionRequestRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24DiversionRequestVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * 세관 신고 대상 Vessel Arrival Notice를 입력한다.
	 * 
	 * @param Eur24SendHistoryVO eur24SendHistoryVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @throws EventException
	 * @throws DAOException 
	 */
	public int addSendLog(Eur24SendHistoryVO eur24SendHistoryVO, SignOnUserAccount account) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		int result = -1;
		try	{
			Map<String, String> mapVO = eur24SendHistoryVO.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOAddSendHistoryCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	

	/**
	 * BL 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String pType
	 * @return List<Eur24BlinfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlinfoVO>  searchBlGeneral ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd , String pType)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlinfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("p_type", pType);

			velParam.put("bl_no", blNo);
			velParam.put("vsl_cd", vslCd);
			velParam.put("skd_voy_no", skdVoyNo);
			velParam.put("skd_dir_cd", skdDirCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			velParam.put("p_type", pType);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlGeneralRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlinfoVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
		
	/**
	 * Eur24 세관전송 시 이태리일 경우 IT_SEQ 및 IT_FILE_SEQ를 채번해야 한다.<br>
	 * 
	 * @return List<Eur24BlinfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlinfoVO>  searchEur24ItarySeq()throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlinfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchEur24ItarySeq2RSQL(), param,velParam);
			String it_seq_n = "";
			if (dbRowset.first()){
				
				it_seq_n = dbRowset.getString(1);
			}
			
			param.put("it_seq_n", it_seq_n);
			velParam.put("it_seq_n", it_seq_n);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchEur24ItarySeqRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlinfoVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * BL 고객 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @return List<Eur24BlCustListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCustListVO>  searchBlCust ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCustListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlCustRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCustListVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * BL 컨테이너 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @return List<Eur24BlCntrListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCntrListVO>  searchBlCntr ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCntrListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlCntrRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCntrListVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * BL 컨테이너별 DG Cargo 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String cntrNo 
	 * @return List<Eur24BlDgCgoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlDgCgoListVO>  searchBlDgCgo ( String blNo , String vslCd , String skdVoyNo , String skdDirCd ,String cstmsPortCd, String cntrNo)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlDgCgoListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlDgCgoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlDgCgoListVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * BL 컨테이너별 Manifest 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String cntrNo 
	 * @return List<Eur24BlCntrMfListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCntrMfListVO>  searchBlCntrMfDesc ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd, String cntrNo)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCntrMfListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlCntrMfDescRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCntrMfListVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * BL 컨테이너 Seal No 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String cntrNo 
	 * @return List<Eur24BlCntrSealListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCntrSealListVO>  searchBlCntrSealNo ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd, String cntrNo)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCntrSealListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlCntrSealNoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCntrSealListVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * BL 컨테이너 Manifest 정보 조회(BL별 MF 리스트)<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String msgIdCd 
	 * @return List<Eur24BlCMinfoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCMinfoListVO>  searchBlCMinfo ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd, String msgIdCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCMinfoListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("cnt_cd", cstmsPortCd.substring(0,2));
			param.put("msg_id_cd", msgIdCd);
			velParam.put("cnt_cd", cstmsPortCd.substring(0,2));
			velParam.put("msg_id_cd", msgIdCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlCMinfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCMinfoListVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	/**
	 * BL별 Route정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String pType
	 * @return List<Eur24BlRouteCntListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlRouteCntListVO>  searchBlRouteCountry ( String blNo,String vslCd , String skdVoyNo , String skdDirCd, String pType )throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlRouteCntListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);	
			param.put("p_type", pType);

			velParam.put("bl_no", blNo);
			velParam.put("vsl_cd", vslCd);
			velParam.put("skd_voy_no", skdVoyNo);
			velParam.put("skd_dir_cd", skdDirCd);
			velParam.put("p_type", pType);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlRouteCountryRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlRouteCntListVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 세관 신고 이력을 입력한다.
	 * 
	 * @param Eur24SendHistoryVO eur24SendHistoryVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addSendLog(Eur24SendHistoryVO eur24SendHistoryVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eur24SendHistoryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOAddSendLogCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
	/**
	 * BKG_CSTMS_EUR_CNTR_MF_SND 이력을 입력한다.
	 * 
	 * @param Eur24SendHistoryVO eur24SendHistoryVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addBlCntrMFSndHist(Eur24SendHistoryVO eur24SendHistoryVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = -1;
		try	{
			Map<String, String> mapVO = eur24SendHistoryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOAddBlCntrMFSndHistCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
	
	/**
	 * Arrival Notice table에 Mgs No를 입력한다.
	 * 
	 * @param Eur24SendHistoryVO eur24SendHistoryVO
	 * @return int
	 * @throws EventException
	 * @throws DAOException 
	 */
	public int updateMsgNoVesselArrival(Eur24SendHistoryVO eur24SendHistoryVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		int result = -1;
		try	{
			Map<String, String> mapVO = eur24SendHistoryVO.getColumnValues();
			mapVO.put("msg_snd_no", eur24SendHistoryVO.getMsgSndNo());
			mapVO.put("vvd", eur24SendHistoryVO.getVslCd() + eur24SendHistoryVO.getSkdVoyNo() + eur24SendHistoryVO.getSkdDirCd());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOUpdateMsgNoVesselArrivalUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Arrival Notice table에 Mgs No를 입력한다.
	 * 
	 * @param Eur24SendHistoryVO eur24SendHistoryVO
	 * @return int
	 * @throws EventException
	 * @throws DAOException 
	 */
	public int updateMsgNoBLArrival(Eur24SendHistoryVO eur24SendHistoryVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		int result = -1;
		try	{
			Map<String, String> mapVO = eur24SendHistoryVO.getColumnValues();
			mapVO.put("msg_snd_no", eur24SendHistoryVO.getMsgSndNo());
			mapVO.put("bl_no", eur24SendHistoryVO.getBlNo());
			mapVO.put("vvd", eur24SendHistoryVO.getVslCd() + eur24SendHistoryVO.getSkdVoyNo() + eur24SendHistoryVO.getSkdDirCd());
			mapVO.put("cstms_port_cd", eur24SendHistoryVO.getCstmsPortCd());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOUpdateMsgNoBLArrivalUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * 세관 수신 데이타 저장.
	 * 
	 * @param Eu24RcvMsgVO eu24RcvMsgVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addRcvLogMst(Eu24RcvMsgVO eu24RcvMsgVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eu24RcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOAddRcvLogMstCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 세관 수신 에러 데이타 저장.
	 * 
	 * @param Eu24RcvMsgVO eu24RcvMsgVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addRcvLogErr(Eu24RcvMsgVO eu24RcvMsgVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eu24RcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOAddRcvLogErrCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * BL 컨테이너 Manifest 정보 조회(BL별 MF 리스트)<br>
	 * 
	 * @return Eu24RcvMsgVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24RcvMsgVO>  searchEur24EdiRcvKey() throws DAOException {
		DBRowSet dbRowset = null;
		List<Eu24RcvMsgVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchEur24EdiRcvKeyRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24RcvMsgVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * EDI 전송후  BKG_CSTMS_EUR_BL.MSG_SND_NO 업데이트
	 * 
	 * @param Eur24SendHistoryVO eur24SendHistoryVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void modifyEU24BlMsgSndNo(Eur24SendHistoryVO eur24SendHistoryVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eur24SendHistoryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOModifyEU24BlMsgSndNoUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 세관 수신 후  BKG_CSTMS_EUR_BL.MVMT_REF_NO 업데이트.
	 * 
	 * @param Eu24RcvMsgVO eu24RcvMsgVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void modifyRcvLogBlMvmtRefNo(Eu24RcvMsgVO eu24RcvMsgVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eu24RcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			log.error("([EUR24 RECEIVE INFO (DAO)] mvmt_ref_no : [" + param.get("mvmt_ref_no") + "]");
			log.error("([EUR24 RECEIVE INFO (DAO)] msg_rcv_no : [" + param.get("msg_rcv_no") + "]");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOModifyRcvLogBlMvmtRefNoUSQL(), param,	velParam);
			log.error("([EUR24 RECEIVE INFO (DAO)] result : [" + result + "]");
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BL 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @return List<Eur24BlinfoOBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlinfoOBVO>  searchBlGeneralOB ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlinfoOBVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
	
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlGeneralOBRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlinfoOBVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BL 고객 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @return List<Eur24BlCustListOBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCustListOBVO>  searchBlCustOB ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCustListOBVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlCustOBRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCustListOBVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BL 컨테이너 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @return List<Eur24BlCntrListOBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCntrListOBVO>  searchBlCntrOB ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCntrListOBVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlCntrOBRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCntrListOBVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BL 컨테이너별 DG Cargo 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String cntrNo 
	 * @return List<Eur24BlDgCgoListOBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlDgCgoListOBVO>  searchBlDgCgoOB ( String blNo , String vslCd , String skdVoyNo , String skdDirCd ,String cstmsPortCd, String cntrNo)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlDgCgoListOBVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlDgCgoOBRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlDgCgoListOBVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BL 컨테이너별 Manifest 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String cntrNo 
	 * @return List<Eur24BlCntrMfListOBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCntrMfListOBVO>  searchBlCntrMfDescOB ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd, String cntrNo)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCntrMfListOBVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlCntrMfDescOBRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCntrMfListOBVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BL 컨테이너 Seal No 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String cntrNo 
	 * @return List<Eur24BlCntrSealListOBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCntrSealListOBVO>  searchBlCntrSealNoOB ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd, String cntrNo)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCntrSealListOBVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlCntrSealNoOBRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCntrSealListOBVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BL 컨테이너 Manifest 정보 조회(BL별 MF 리스트)<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String msgIdCd 
	 * @return List<Eur24BlCMinfoListOBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCMinfoListOBVO>  searchBlCMinfoOB ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd, String msgIdCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCMinfoListOBVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("cnt_cd", cstmsPortCd.substring(0,2));
			param.put("msg_id_cd", msgIdCd);
			velParam.put("cnt_cd", cstmsPortCd.substring(0,2));
			velParam.put("msg_id_cd", msgIdCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlCMinfoOBRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCMinfoListOBVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BL별 Route정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @return List<Eur24BlRouteCntListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlRouteCntListVO>  searchBlRouteCountryOB ( String blNo,String vslCd , String skdVoyNo , String skdDirCd )throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlRouteCntListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlRouteCountryOBRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlRouteCntListVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 세관 신고 이력을 입력한다.
	 * 
	 * @param Eur24SendHistoryOBVO eur24SendHistoryOBVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addSendLogOB(Eur24SendHistoryOBVO eur24SendHistoryOBVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		int result = -1;
		try	{
			Map<String, String> mapVO = eur24SendHistoryOBVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOAddSendLogOBCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BKG_CSTMS_EUR_CNTR_MF_SND 이력을 입력한다.
	 * 
	 * @param Eur24SendHistoryVO eur24SendHistoryVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addBlCntrMFSndHistOB(Eur24SendHistoryVO eur24SendHistoryVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = -1;
		try	{
			Map<String, String> mapVO = eur24SendHistoryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOAddBlCntrMFSndHistOBCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EDI 전송후  BKG_CSTMS_EUR_BL.MSG_SND_NO 업데이트
	 * 
	 * @param Eur24SendHistoryOBVO eur24SendHistoryOBVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void modifyEU24BlMsgSndNoOB(Eur24SendHistoryOBVO eur24SendHistoryOBVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		int result = -1;
		try	{
			Map<String, String> mapVO = eur24SendHistoryOBVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOModifyEU24BlMsgSndNoOBUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EXS 세관 수신 데이타 저장.
	 * 
	 * @param Eu24RcvMsgVO eu24RcvMsgVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addRcvLogMstOB(Eu24RcvMsgVO eu24RcvMsgVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		int result = -1;
		try	{
			Map<String, String> mapVO = eu24RcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOAddRcvLogMstOBCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EXS 세관 수신 후  BKG_CSTMS_EUR_BL.MVMT_REF_NO 업데이트.
	 * 
	 * @param Eu24RcvMsgVO eu24RcvMsgVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void modifyRcvLogBlMvmtRefNoOB(Eu24RcvMsgVO eu24RcvMsgVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		int result = -1;
		try	{
			Map<String, String> mapVO = eu24RcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOModifyRcvLogBlMvmtRefNoOBUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EXS 세관 수신 에러 데이타 저장.
	 * 
	 * @param Eu24RcvMsgVO eu24RcvMsgVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addRcvLogErrOB(Eu24RcvMsgVO eu24RcvMsgVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		int result = -1;
		try	{
			Map<String, String> mapVO = eu24RcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOAddRcvLogErrOBCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EXS 세관 수신 데이타 Hold / Hold Release
	 * 
	 * @param Eu24RcvMsgVO eu24RcvMsgVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addMnlRcvLogMstOB(Eu24RcvMsgVO eu24RcvMsgVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		int result = -1;
		try	{
			Map<String, String> mapVO = eu24RcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24CustomsTransmissionDBDAOAddMnlRcvLogMstOBCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * {IE347) BL 정보 조회<br>
	 * 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @return List<Eur24BlinfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlinfoVO>  searchVesselArrivalBlInfo (String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd )throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlinfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);

			velParam.put("vsl_cd", vslCd);
			velParam.put("skd_voy_no", skdVoyNo);
			velParam.put("skd_dir_cd", skdDirCd);
			velParam.put("cstms_port_cd", cstmsPortCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchVesselArrivalBlInfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlinfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * {IE347) BL 정보 조회<br>
	 * 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @param String blNo
	 * @return List<Eur24BlinfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlinfoVO>  searchVesselFIArrivalBlInfo (String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd , String blNo)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlinfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			param.put("bl_no", blNo);

			velParam.put("vsl_cd", vslCd);
			velParam.put("skd_voy_no", skdVoyNo);
			velParam.put("skd_dir_cd", skdDirCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			velParam.put("bl_no", blNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchVesselFIArrivalBlInfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlinfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * {IE347) BL별 CM 리스트<br>
	 * @param String blNo
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String cstmsPortCd
	 * @return List<Eur24BlCMinfoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCMinfoListVO>  searchVesselArrivalCMInfo ( String blNo, String vslCd, String skdVoyNo, String skdDirCd, String cstmsPortCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCMinfoListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);

			velParam.put("bl_no", blNo);
			velParam.put("vsl_cd", vslCd);
			velParam.put("skd_voy_no", skdVoyNo);
			velParam.put("skd_dir_cd", skdDirCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchVesselArrivalCMInfoRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCMinfoListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	

	/**
	 * 수신메세지로 BL정보 조회
	 * 
	 * @param eu24RcvMsgVO
	 * @return
	 * @throws DAOException
	 */
	public Eur24BlForEmlVO searchBlForEml(Eu24RcvMsgVO eu24RcvMsgVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Eur24BlForEmlVO emlVo = null;
		try
		{
			Map<String, String> mapVO = eu24RcvMsgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlForEmlRSQL(), param, velParam);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlForEmlVO.class);
			if (list.size() > 0)
				emlVo = (Eur24BlForEmlVO)list.get(0);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return emlVo;
	}

	/**
	 * EDI 오류로 인한 BL정보 조회
	 * @param msgKey
	 * @return
	 * @throws DAOException
	 */
	public Eur24BlForEmlVO searchBlForEdiErr(String msgKey) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Eur24BlForEmlVO emlVo = null;
		try
		{
			param.put("msg_key", msgKey);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Eur24CustomsTransmissionDBDAOSearchBlForEdiErrRSQL(), param, velParam);
			List list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlForEmlVO.class);
			if (list.size() > 0)
				emlVo = (Eur24BlForEmlVO)list.get(0);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return emlVo;
	}
}