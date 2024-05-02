/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IndiaCustomsTransmissionDBDAO.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.11
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.06.11 경종윤
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.basic.IndiaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaBlListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaCntrListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaCntrMtDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaIgmVslResultVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaIgmVslVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaMaxSeqModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaTransmitCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaTransmitDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.TransmitDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS IndiaCustomsTransmissionDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kyoung Jong Yun
 * @see IndiaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class IndiaCustomsTransmissionDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * container list대상 조회하는 오퍼레이션<br>
	 *
	 * @param indiaTransmitCondVO
	 * @return Object
	 * @throws DAOException
	 */
	public List<TransmitDetailVO> searchContainerList(IndiaTransmitCondVO indiaTransmitCondVO) throws DAOException {

		int processType = 0;
		List<TransmitDetailVO> obj = null;

		if(indiaTransmitCondVO != null) {
			processType = Integer.parseInt(indiaTransmitCondVO.getProcessType());

			switch(processType) {
				case 1 : { // Contaniner List(EDI)
					obj = searchContainerEdiList(indiaTransmitCondVO);
					break;
				}
				case 3 : { // TP Request (EDI)
					obj = searchTPRequestEDI(indiaTransmitCondVO);
					break;
				}
				default : {}
			} // end switch()

		} // end if()

		return obj;

	}

	/**
	 * container list대상 조회하는 오퍼레이션 - CNTR List 버튼 클릭시<br>
	 *
	 * @param IndiaTransmitCondVO indiaTransmitCondVO
	 * @return List<TransmitDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TransmitDetailVO> searchContainerEdiList(IndiaTransmitCondVO indiaTransmitCondVO) throws DAOException {

		List<TransmitDetailVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (indiaTransmitCondVO != null)
			{
				Map<String, String> mapVO = indiaTransmitCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaCustomsTransmissionDBDAOsearchContainerListRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,IndiaTransmitDetailVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;

	}

	/**
	 * container list대상 조회하는 오퍼레이션 - TP Request (EDI) 버튼 클릭시<br>
	 *
	 * @param IndiaTransmitCondVO indiaTransmitCondVO
	 * @return List<IndiaTransmitDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TransmitDetailVO> searchTPRequestEDI(IndiaTransmitCondVO indiaTransmitCondVO) throws DAOException {

		List<TransmitDetailVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (indiaTransmitCondVO != null)
			{
				Map<String, String> mapVO = indiaTransmitCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaCustomsTransmissionDBDAOsearchTPRequestEDIRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,IndiaCntrListDetailVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;

	}

	/**
	 * 인도세관테이블에서 VVD의 상세 정보를 가져온다.
	 *
	 * @param IndiaTransmitCondVO indiaTransmitCondVO
	 * @return IndiaIgmVslResultVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public IndiaIgmVslResultVO searchIgmVslByVvdPod(IndiaTransmitCondVO indiaTransmitCondVO) throws DAOException {

		IndiaIgmVslResultVO indiaIgmVslResultVO = new IndiaIgmVslResultVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (indiaTransmitCondVO != null)
			{
				Map<String, String> mapVO = indiaTransmitCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaCustomsTransmissionDBDAOsearchIgmVslByVvdPodRSQL(), param, velParam);

			List<IndiaIgmVslResultVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,IndiaIgmVslResultVO.class);

			if (list != null && list.size() > 0) {
				indiaIgmVslResultVO = (IndiaIgmVslResultVO) list.get(list.size() - 1);
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return indiaIgmVslResultVO;
	}

	/**
	 * 전송 대상 B/L을 가져옴
	 *
	 * @param IndiaTransmitCondVO indiaTransmitCondVO
	 * @return List<IndiaBlListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IndiaBlListDetailVO> searchBlListByVvdPolPod(IndiaTransmitCondVO indiaTransmitCondVO) throws DAOException {
		List<IndiaBlListDetailVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (indiaTransmitCondVO != null)
			{
				Map<String, String> mapVO = indiaTransmitCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaCustomsTransmissionDBDAOsearchBlListByVvdPolPodRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,IndiaBlListDetailVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 전송대상 컨테이너 리스트를 가져옴
	 *
	 * @param IndiaTransmitCondVO indiaTransmitCondVO
	 * @return List<IndiaCntrMtDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IndiaCntrMtDetailVO> searchCntrListByVvdPodMt(IndiaTransmitCondVO indiaTransmitCondVO) throws DAOException {
		List<IndiaCntrMtDetailVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (indiaTransmitCondVO != null)
			{
				Map<String, String> mapVO = indiaTransmitCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaCustomsTransmissionDBDAOsearchCntrListByVvdPodMtRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,IndiaCntrMtDetailVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Agent Code,Seq 정보를 조회해 온다. - TP Request (EDI) 버튼 클릭시<br>
	 *
	 * @param IndiaTransmitCondVO indiaTransmitCondVO
	 * @return IndiaIgmVslVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public IndiaIgmVslVO searchIgmVsl(IndiaTransmitCondVO indiaTransmitCondVO) throws DAOException {

		IndiaIgmVslVO indiaIgmVslVO = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (indiaTransmitCondVO != null)
			{
				Map<String, String> mapVO = indiaTransmitCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IndiaCustomsTransmissionDBDAOsearchIgmVslRSQL(), param, velParam);

			List<IndiaIgmVslVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,IndiaIgmVslVO.class);

			if (list != null && list.size() > 0) {
				indiaIgmVslVO = (IndiaIgmVslVO) list.get(list.size() - 1);
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return indiaIgmVslVO;

	}

	/**
	 * Max Seq.를 조회해 온다. - TP Request (EDI) 버튼 클릭시<br>
	 *
	 * @param IndiaTransmitCondVO indiaTransmitCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchIgmMaxSeq(IndiaTransmitCondVO indiaTransmitCondVO) throws DAOException {

		int maxSeq = 0;
		String retMaxSeq = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (indiaTransmitCondVO != null)
			{
				Map<String, String> mapVO = indiaTransmitCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaCustomsTransmissionDBDAOsearchIgmMaxSeqRSQL(), param, velParam);

			if(dbRowset.next()) {
				maxSeq = dbRowset.getInt(1);
			}

			if(maxSeq == 0) {
				maxSeq = 1;
			} else {
				maxSeq++;
			}


			DecimalFormat fmt = new DecimalFormat("00");
			retMaxSeq = fmt.format(maxSeq);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retMaxSeq;
	}

	/**
	 * Agent Code별 전송번호 업데이트 하는 오퍼레이션<Br>
	 *
	 * @param IndiaMaxSeqModiVO indiaMaxSeqModiVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyIgmMaxSeq(IndiaMaxSeqModiVO indiaMaxSeqModiVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = indiaMaxSeqModiVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new IndiaCustomsTransmissionDBDAOmodifyIgmMaxSeqUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				//throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getUserMessage());
				throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getUserMessage());
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Agent Code별 전송번호 생성 오퍼레이션 -  최초에만 발생 <Br>
	 *
	 * @param IndiaMaxSeqModiVO indiaMaxSeqModiVO
	 * @return int
	 * @throws DAOException
	 */
	public int addIgmMaxSeq(IndiaMaxSeqModiVO indiaMaxSeqModiVO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = indiaMaxSeqModiVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new IndiaCustomsTransmissionDBDAOaddIgmMaxSeqCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				//throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getUserMessage());
				throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getUserMessage());
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

}
