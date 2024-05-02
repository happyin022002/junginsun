/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TerminalAgreementManageDBDAO.java
*@FileTitle : Terminal Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-08
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-08 jongbaemoon
* 1.0 최초 생성
* 
*@LastModifyDate : 2009.08.10
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.08.10 yOng hO lEE
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic.TerminalAgreementManageBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0034Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0039Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0040Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9070Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.TesAgreementManageCommonVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgCodCostVO;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtAplyDyVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtDgCgoClssVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtDtlVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtHdrVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtThrpCostVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtTpSzVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtVrfyMzdVO;
import com.hanjin.syscommon.common.table.TesTmlSoAccmCostVO;
import com.hanjin.syscommon.common.table.TesTmlSoAccmMzdVO;
import com.hanjin.syscommon.common.table.TesTmlSoAccmYdVO;


/**
 * ALPS MarineTerminalInvoiceManageDBDAO <br>
 * - ALPS-ServiceProviderInvoiceManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author yOng hO lEE
 * @see TerminalAgreementManageBCImpl 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAO extends DBDAOSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * Cost Code Verify List Select.<br>
	 * @param lgsCostCd
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchCostCodeVerifyList(String lgsCostCd) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( lgsCostCd != null && !"".equals( lgsCostCd ) ) {
				param.put( "lgs_cost_cd", lgsCostCd);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchCostCodeVerifyListRSQL(), param, velParam);
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
		return dbRowset;
	}

	/**
	 * Throughput Cost Code List Select.<br>
	 * @param TesTmlAgmtThrpCostVO tesTmlAgmtThrpCostVO
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchThorougputCostCode(TesTmlAgmtThrpCostVO tesTmlAgmtThrpCostVO) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			Map<String, String>	mapVO	= tesTmlAgmtThrpCostVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll(mapVO);
			}
		
			if ( tesTmlAgmtThrpCostVO.getLgsCostCd() != null && "TP".equals( tesTmlAgmtThrpCostVO.getLgsCostCd().substring(0, 2) ) ) {
				velParam.put("lgsCostCdFlg", "Y");
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchThorougputCostCodeRSQL(), param, velParam);

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

		return dbRowset;
	}

	/**
	 * Agreement Header Info List Select.<br>
	 * 
	 * @param event EsdTes9070Event
	 * @return List<TesTmlAgmtHdrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesTmlAgmtHdrVO> searchAgreementPopUpList(EsdTes9070Event event) throws DAOException {
		List<TesTmlAgmtHdrVO>	list		= null;
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {

			if ( event.getTesTmlAgmtHdrVO().getYdCd() != null && !"".equals( event.getTesTmlAgmtHdrVO().getYdCd() ) ) {
				param	.put( "yd_cd", event.getTesTmlAgmtHdrVO().getYdCd() );
				velParam.put( "yd_cd", event.getTesTmlAgmtHdrVO().getYdCd() );
			}

			if ( event.getTesTmlAgmtHdrVO().getVndrSeq() != null && !"".equals( event.getTesTmlAgmtHdrVO().getVndrSeq() ) ) {
				param	.put( "vndr_seq", event.getTesTmlAgmtHdrVO().getVndrSeq() );
				velParam.put( "vndr_seq", event.getTesTmlAgmtHdrVO().getVndrSeq() );
			}

			if ( event.getTesAgreementManageCommonVO().getLocCd() != null && !"".equals( event.getTesAgreementManageCommonVO().getLocCd() ) ) {
				param	.put( "loc_cd", event.getTesAgreementManageCommonVO().getLocCd() );
				velParam.put( "loc_cd", event.getTesAgreementManageCommonVO().getLocCd() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchAgreementPopUpListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs( dbRowset, TesTmlAgmtHdrVO .class);
			
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
	 * Agreement Summary List Select.<br>
	 * 
	 * @param event EsdTes0039Event
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchTerminalAgreeementSummaryList(EsdTes0039Event event) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			Map<String, String> comMapVO	= event.getTesAgreementManageCommonVO().getColumnValues();
			if ( comMapVO != null ) {
				param	.putAll(comMapVO);
				velParam.putAll(comMapVO);				
			}

			Map<String, String> hdrMapVO	= event.getTesTmlAgmtHdrVO().getColumnValues();
			if ( hdrMapVO != null ) {
				param	.putAll(hdrMapVO);
				velParam.putAll(hdrMapVO);				
			}
			
			if ( event.getSignOnUserAccount().getOfc_cd() != null && !"".equals( event.getSignOnUserAccount().getOfc_cd() ) ) {
				param	.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
				velParam.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			}
			
			if ( event.getTesAgreementManageCommonVO().getCreOfcCd2() != null && !"".equals( event.getTesAgreementManageCommonVO().getCreOfcCd2() ) ) {
				log.error(" event.getTesAgreementManageCommonVO().getCreOfcCd2()====>"+ event.getTesAgreementManageCommonVO().getCreOfcCd2());
				param	.put("cre_ofc_cd2", event.getTesAgreementManageCommonVO().getCreOfcCd2() );
				velParam.put("cre_ofc_cd2", event.getTesAgreementManageCommonVO().getCreOfcCd2() );
			}
			
			
			//ctrt sub ofc list 포함
			if( event.getTesCommonVO().getSubOfcCd1() != null && event.getTesCommonVO().getSubOfcCd1() != "" ){
				String subOfcCd1 = event.getTesCommonVO().getSubOfcCd1();
				List<String> subOfcList1 = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(subOfcCd1, ",");

				while (st.hasMoreTokens()) {
					subOfcList1.add(st.nextToken().trim());
			    }
			    velParam.put("sub_ofc_cd1", subOfcList1);
			}	
			
			//cre sub ofc list 포함
			if( event.getTesCommonVO().getSubOfcCd2() != null && event.getTesCommonVO().getSubOfcCd2() != "" ){
				String subOfcCd2 = event.getTesCommonVO().getSubOfcCd2();
				List<String> subOfcList2 = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(subOfcCd2, ",");

				while (st.hasMoreTokens()) {
					subOfcList2.add(st.nextToken().trim());
			    }
			    velParam.put("sub_ofc_cd2", subOfcList2);
			}	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchTerminalAgreeementSummaryListRSQL(), param, velParam);

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

		return dbRowset;
	}


	/**
	 * Agreement Terminal Detail List Select.<br>
	 * 
	 * @param tesTmlAgmtHdrVO TesTmlAgmtHdrVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchTerminalAgreementDetail(TesTmlAgmtHdrVO tesTmlAgmtHdrVO) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd() != null && !"".equals( tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd() ) ) {
				param.put( "tml_agmt_ofc_cty_cd", tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(0, 3) );
				param.put( "tml_agmt_seq"		, tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(3, 8) );
			}
			
			if ( tesTmlAgmtHdrVO.getTmlAgmtVerNo() != null && !"".equals( tesTmlAgmtHdrVO.getTmlAgmtVerNo() ) ) {
				param.put( "tml_agmt_ver_no"	, tesTmlAgmtHdrVO.getTmlAgmtVerNo().replaceAll("\\.", "") );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchTerminalAgreementDetailRSQL(), param, velParam);
						
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
		return dbRowset;
	}

	/**
	 * Agreement Storage Detail List Select.<br>
	 * @param tesTmlAgmtHdrVO TesTmlAgmtHdrVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchStorageAgreementDetail(TesTmlAgmtHdrVO tesTmlAgmtHdrVO) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd() != null && !"".equals( tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd() ) ) {
				param.put( "tml_agmt_ofc_cty_cd", tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(0, 3) );
				param.put( "tml_agmt_seq"		, tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(3, 8) );
			}
			
			if ( tesTmlAgmtHdrVO.getTmlAgmtVerNo() != null && !"".equals( tesTmlAgmtHdrVO.getTmlAgmtVerNo() ) ) {
				param.put( "tml_agmt_ver_no"	, tesTmlAgmtHdrVO.getTmlAgmtVerNo().replaceAll("\\.", "") );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchStorageAgreementDetailRSQL(), param, velParam);
			
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
		return dbRowset;
	}

	
	/**
	 * Throughput Cost Code List Select
	 *
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchThoroughputCC() throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchThoroughputCCRSQL(), param, velParam);

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
		return dbRowset;
	}

	/**
	 * Agreement Yard Flag Select.<br>
	 * @param  tesTmlAgmtHdrVO TesTmlAgmtHdrVO
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchYardFlg(TesTmlAgmtHdrVO tesTmlAgmtHdrVO) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( tesTmlAgmtHdrVO.getYdCd() != null && !"".equals( tesTmlAgmtHdrVO.getYdCd() ) ) {
				param.put("yd_cd", tesTmlAgmtHdrVO.getYdCd() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchYardFlgRSQL(), param, velParam);

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
		return dbRowset;
	}

	/**
	 * Agreement Cost Code Select.<br>
	 * 
	 * @param mdmYardVO MdmYardVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAgreementCost(MdmYardVO mdmYardVO) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= mdmYardVO.getColumnValues();

			if ( mapVO != null ) {
				param.putAll( mapVO );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchAgreementCostRSQL(), param, velParam);
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
		return dbRowset;
	}

	/**
	 * Throughput Cost Code Select.<br>
	 * @param  tesTmlAgmtThrpCostVO TesTmlAgmtThrpCostVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchThrpflg(TesTmlAgmtThrpCostVO tesTmlAgmtThrpCostVO) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
//		String				thrPCostCd		= "";
		StringBuilder		sbuThrPCostCdTmp	= new StringBuilder();
		StringBuilder		sbuThrPCostCd		= new StringBuilder();

		try {
		
			Map<String, String>		mapVO	= tesTmlAgmtThrpCostVO.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param	.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
				velParam.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchThrpflgRSQL(), param, velParam);
			
            if (dbRowset != null) {
				// 소스품질 개선사항 반영 - 4347.07.02 yOng hO lEE
            	while (dbRowset.next()) {
//            		thrPCostCd = dbRowset.getString("thrp_lgs_cost_cd") + "|" + thrPCostCd;
            		sbuThrPCostCdTmp.setLength(0);
            		sbuThrPCostCdTmp.append(dbRowset.getString("thrp_lgs_cost_cd")).append("|");
            		sbuThrPCostCd.insert(0, sbuThrPCostCdTmp.toString() );
            		
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
		return sbuThrPCostCd.toString();
	}


	/**
	 * Cost Code Verify Flag Select.<br>
	 * @param tesTmlAgmtDtlVO TesTmlAgmtDtlVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchThrpExitsFlg(TesTmlAgmtDtlVO tesTmlAgmtDtlVO) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		StringBuilder		sbuThrPCostCdTmp	= new StringBuilder();
		StringBuilder		sbuThrPCostCd		= new StringBuilder();
//		String				thrPCostCd		= "";

		try {
		
			Map<String, String> mapVO	= tesTmlAgmtDtlVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param	.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
				velParam.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchThrpExitsFlgRSQL(), param, velParam);
			
            if (dbRowset != null) {
            	// 소스품질 개선사항 반영 - 4347.07.02 yOng hO lEE
            	while (dbRowset.next()) {
//            		thrPCostCd = dbRowset.getString("thrp_lgs_cost_cd") + "|" + thrPCostCd;
            		sbuThrPCostCdTmp.setLength(0);
            		sbuThrPCostCdTmp.append(dbRowset.getString("thrp_lgs_cost_cd")).append("|");
            		sbuThrPCostCd.insert(0, sbuThrPCostCdTmp.toString() );
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
		return sbuThrPCostCd.toString();
	}

	/**
	 * Cost Code List Select.<br>
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchCostCodeList() throws DAOException {

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchCostCodeListRSQL(), param, velParam);
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
		return dbRowset;
	}

	/**
	 * Currency Code List Select.<br>
	 * @param  ofcCd
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchCurrencyList(String ofcCd) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {

			if ( ofcCd != null && !"".equals( ofcCd ) ) {
				param.put("ofc_cd", ofcCd);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchCurrencyListRSQL(), param, velParam);

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
		return dbRowset;
	}

	/**
	 * Lane Code List Select.<br>
	 * @param  tesTmlAgmtHdrVO TesTmlAgmtHdrVO
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchLaneList(TesTmlAgmtHdrVO tesTmlAgmtHdrVO) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {

			if ( tesTmlAgmtHdrVO.getYdCd() != null && !"".equals( tesTmlAgmtHdrVO.getYdCd() ) ) {
				param	.put("yd_cd", tesTmlAgmtHdrVO.getYdCd());
				velParam.put("yd_cd", tesTmlAgmtHdrVO.getYdCd());
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchLaneListRSQL(), param, velParam);
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
		return dbRowset;
	}

	/**
	 * Container Type List Select.<br>
	 *
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchTypeList() throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchTypeListRSQL(), param, velParam);
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
		return dbRowset;
	}

	/**
	 * Container Size List Select.<br>
	 *
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchSizeList() throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchSizeListRSQL(), param, velParam);
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
		return dbRowset;
	}


	/**
	 * Agreement Invoice Use List select.<br>
	 * @param  tmlAgmtOfcNo
	 * @param  tmlAgmtVerNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchInvoiceHDR(String tmlAgmtOfcNo, String tmlAgmtVerNo) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		String				invoiceUseFlg	= "";

		try {
			
			if ( tmlAgmtOfcNo != null && !"".equals( tmlAgmtOfcNo ) ) {
				param.put( "tml_agmt_ofc_cty_cd", tmlAgmtOfcNo.substring(0,3) );
				param.put( "tml_agmt_seq"		, tmlAgmtOfcNo.substring(3,8) );
			}
			
			if ( tmlAgmtVerNo != null && !"".equals( tmlAgmtVerNo ) ) {
				param.put( "tml_agmt_ver_no", tmlAgmtVerNo.replaceAll("\\.", "") );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchInvoiceHDRRSQL(), param, velParam);

            if (dbRowset != null && dbRowset.next()) {
            	invoiceUseFlg	= "Y";
            } else {
            	invoiceUseFlg	= "N";
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
		return invoiceUseFlg;
	}

	/**
	 * Agreement Maximum Version No Select.<br>
	 * @param  tmlAgmtOfcNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxAgmtVer(String tmlAgmtOfcNo) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		String				ver_no			= "";

		try {
			
			if ( tmlAgmtOfcNo != null && !"".equals( tmlAgmtOfcNo ) ) {
				param.put( "tml_agmt_ofc_cty_cd", tmlAgmtOfcNo.substring(0, 3) );
				param.put( "tml_agmt_seq"		, tmlAgmtOfcNo.substring(3, 8) );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchMaxAgmtVerRSQL(), param, velParam);

            if (dbRowset != null) {
            	while(dbRowset.next()){
            		ver_no = dbRowset.getString("tml_agmt_ver_no");
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
		return ver_no;
	}

	/**
	 * Agreement Terminal Detail List Select.<br>
	 * @param tesTmlAgmtHdrVO
	 * @param tesTmlAgmtDtlVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchTerminalAgreementInfo(TesTmlAgmtHdrVO tesTmlAgmtHdrVO, TesTmlAgmtDtlVO tesTmlAgmtDtlVO) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( tesTmlAgmtDtlVO.getTmlAgmtTpCd() != null && !"".equals( tesTmlAgmtDtlVO.getTmlAgmtTpCd() ) ) {
				param.put( "tml_agmt_tp_cd", tesTmlAgmtDtlVO.getTmlAgmtTpCd()  );
			}
			
			if ( tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd() != null && !"".equals( tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd() ) ) {
				param	.put( "tml_agmt_ofc_cty_cd"	, tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(0, 3)  );
				param	.put( "tml_agmt_seq"		, tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(3, 8)  );
				velParam.put( "tml_agmt_ofc_cty_cd"	, tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd()  );
			}

			if ( tesTmlAgmtHdrVO.getTmlAgmtVerNo() != null && !"".equals( tesTmlAgmtHdrVO.getTmlAgmtVerNo() ) ) {
				param	.put( "tml_agmt_ver_no", tesTmlAgmtHdrVO.getTmlAgmtVerNo().replaceAll("\\.", "") );
				velParam.put( "tml_agmt_ver_no", tesTmlAgmtHdrVO.getTmlAgmtVerNo() );
			}

			if ( tesTmlAgmtHdrVO.getYdCd() != null && !"".equals( tesTmlAgmtHdrVO.getYdCd() ) ) {
				param	.put( "yd_cd", tesTmlAgmtHdrVO.getYdCd()  );
				velParam.put( "yd_cd", tesTmlAgmtHdrVO.getYdCd()  );
			}

			if ( tesTmlAgmtHdrVO.getVndrSeq() != null && !"".equals( tesTmlAgmtHdrVO.getVndrSeq() ) ) {
				param	.put( "vndr_seq", tesTmlAgmtHdrVO.getVndrSeq()  );
				velParam.put( "vndr_seq", tesTmlAgmtHdrVO.getVndrSeq()  );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchTerminalAgreementInfoRSQL(), param, velParam);

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
		return dbRowset;
	}

	/**
	 * Throughput Cost Code Select.<br>
	 * 
	 * @param tmlAgmtOfcCtyCd
	 * @param tmlAgmtSeq
	 * @param tmlAgmtVerNo
	 * @return List<TesTmlAgmtDtlVO>
	 * @exception DAOException
	 */
	public List<TesTmlAgmtDtlVO> searchThrpTerminalAgreement(String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String tmlAgmtVerNo) throws DAOException {
		List<TesTmlAgmtDtlVO>	list		= null;
		
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			param.put( "tml_agmt_ofc_cty_cd", tmlAgmtOfcCtyCd );
			param.put( "tml_agmt_seq"		, tmlAgmtSeq );
			param.put( "tml_agmt_ver_no"	, tmlAgmtVerNo );
			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchThrpTerminalAgreementRSQL(), param, velParam);
			
			TesTmlAgmtDtlVO		tesTmlAgmtDtlVO	= new TesTmlAgmtDtlVO();
			list	= new ArrayList<TesTmlAgmtDtlVO>();
			if ( dbRowset != null ) {
				while ( dbRowset.next() ) {
					tesTmlAgmtDtlVO	= new TesTmlAgmtDtlVO();
					tesTmlAgmtDtlVO.setLgsCostCd( dbRowset.getString("lgs_cost_cd") );
					tesTmlAgmtDtlVO.setThrpLgsCostCd( dbRowset.getString("thrp_lgs_cost_cd").trim() );
					list.add(tesTmlAgmtDtlVO);
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

	/**
	 * Agreement Header Info Select.<br>
	 *
	 * @param tesTmlAgmtHdrVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAgreementYardVendor(TesTmlAgmtHdrVO tesTmlAgmtHdrVO) throws DAOException  {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {

			if ( tesTmlAgmtHdrVO.getYdCd() != null && !"".equals( tesTmlAgmtHdrVO.getYdCd() ) ) {
				param.put("yd_cd", tesTmlAgmtHdrVO.getYdCd());
			}

			if ( tesTmlAgmtHdrVO.getYdCd() != null && !"".equals( tesTmlAgmtHdrVO.getYdCd() ) ) {
				param.put("vndr_seq", tesTmlAgmtHdrVO.getVndrSeq());
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchAgreementYardVendorRSQL(), param, velParam);

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
		return dbRowset;
	}


	/**
	 * Agreement Header Info Check Select.<br>
	 *
	 * @param TesTmlAgmtHdrVO tesTmlAgmtHdrVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchTerminalAgreementInfoCheckHdr(TesTmlAgmtHdrVO tesTmlAgmtHdrVO) throws DAOException  {
		DBRowSet				dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO	= tesTmlAgmtHdrVO.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchTerminalAgreementInfoCheckHdrRSQL(), param, velParam);

            if (dbRowset != null && dbRowset.next()) {
//            	String	tml_agmt_ofc_cty_cd	= dbRowset.getString("tml_agmt_ofc_cty_cd");
            	StringBuilder sbuTmlAgmtOfcCtyCd	= new StringBuilder( dbRowset.getString("tml_agmt_ofc_cty_cd") );
            	String	tml_agmt_seq_no		= dbRowset.getString("tml_agmt_seq");
            	String	tml_agmt_ver_no		= dbRowset.getString("tml_agmt_ver_no");
//            	String	tml_agmt_seq = "";
            	StringBuilder		sbuTmlAgmtSeq = new StringBuilder();
            	
				// 소스품질 개선사항 반영 - 4347.07.02 yOng hO lEE
				for (int i = 0; i < (5 - tml_agmt_seq_no.length()); i++) {
//					tml_agmt_seq  = "0"+tml_agmt_seq;
					sbuTmlAgmtSeq.insert(0, "0");
				}
//				tml_agmt_ofc_cty_cd  = tml_agmt_ofc_cty_cd+tml_agmt_seq+tml_agmt_seq_no ;
				sbuTmlAgmtOfcCtyCd.append( sbuTmlAgmtSeq.toString() ).append( tml_agmt_seq_no) ;

//            	throw new DAOException(new ErrorHandler("USR", "E:동일한 Agreement가 존재합니다. (Agreement "+tml_agmt_ofc_cty_cd+"번, Version "+tml_agmt_ver_no+")").getMessage());
				// 소스품질 개선사항 반영 - 4347.07.02 yOng hO lEE
//				throw new DAOException(new ErrorHandler("TES00073", new String[]{tml_agmt_ofc_cty_cd, tml_agmt_ver_no}).getMessage());
				throw new DAOException(new ErrorHandler("TES00073", new String[]{sbuTmlAgmtOfcCtyCd.toString(), tml_agmt_ver_no}).getMessage());
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
		return dbRowset;
	}
	
	
	/**
	 * Agreement Detail Info Check Select.<br>
	 *
	 * @param TesTmlAgmtHdrVO tesTmlAgmtHdrVO
	 * @param TesTmlAgmtDtlVO tesTmlAgmtDtlVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchTerminalAgreementInfoCheckHdrDtl(TesTmlAgmtHdrVO tesTmlAgmtHdrVO, TesTmlAgmtDtlVO tesTmlAgmtDtlVO) throws DAOException  {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO	= tesTmlAgmtHdrVO.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
			}
			
			if ( tesTmlAgmtDtlVO.getLgsCostCd() != null && !"".equals( tesTmlAgmtDtlVO.getLgsCostCd() ) ) {
				param.put("lgs_cost_cd", tesTmlAgmtDtlVO.getLgsCostCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchTerminalAgreementInfoCheckHdrDtlRSQL(), param, velParam);


            if (dbRowset != null && dbRowset.next()) {
//            	String tml_agmt_ofc_cty_cd	= dbRowset.getString("tml_agmt_ofc_cty_cd");
            	StringBuilder sbuTmlAgmtOfcCtyCd	= new StringBuilder( dbRowset.getString("tml_agmt_ofc_cty_cd") );
            	String tml_agmt_seq_no		= dbRowset.getString("tml_agmt_seq");
            	String tml_agmt_ver_no		= dbRowset.getString("tml_agmt_ver_no");
//            	String tml_agmt_seq = "";
            	StringBuilder		sbuTmlAgmtSeq = new StringBuilder();

				// 소스품질 개선사항 반영 - 4347.07.02 yOng hO lEE
				for (int i = 0; i < (5 - tml_agmt_seq_no.length()); i++) {
//					tml_agmt_seq  = "0"+tml_agmt_seq;
					sbuTmlAgmtSeq.insert(0, "0");
				}
//				tml_agmt_ofc_cty_cd  = tml_agmt_ofc_cty_cd + tml_agmt_seq + tml_agmt_seq_no ;
				sbuTmlAgmtOfcCtyCd.append( sbuTmlAgmtSeq.toString() ).append( tml_agmt_seq_no) ;

//            	throw new DAOException(new ErrorHandler("USR", "E:동일한 Agreement가 존재합니다. (Agreement "+tml_agmt_ofc_cty_cd+"번, Version "+tml_agmt_ver_no+")").getMessage());
				// 소스품질 개선사항 반영 - 4347.07.02 yOng hO lEE
//				throw new DAOException(new ErrorHandler("TES00073", new String[]{tml_agmt_ofc_cty_cd, tml_agmt_ver_no}).getMessage());
				throw new DAOException(new ErrorHandler("TES00073", new String[]{sbuTmlAgmtOfcCtyCd.toString(), tml_agmt_ver_no}).getMessage());
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
		return dbRowset;
	}
	
	/**
	 *  Agreement Load Excel 의 Verify 조건 조회.<br>
	 *   
	 * @param tesTmlAgmtVrfyMzdVO TesTmlAgmtVrfyMzdVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet verifyExcelAgreement(TesTmlAgmtVrfyMzdVO tesTmlAgmtVrfyMzdVO) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {

			if ( tesTmlAgmtVrfyMzdVO.getLgsCostCd() != null && !"".equals( tesTmlAgmtVrfyMzdVO.getLgsCostCd() ) ) {
				param.put("lgs_cost_cd", tesTmlAgmtVrfyMzdVO.getLgsCostCd() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOVerifyExcelAgreementRSQL(), param, velParam);

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
		return dbRowset;
	}

	
	/**
	 * 등록전 Throughput Check
	 * 
	 * @param tesTmlAgmtDtlVOs TesTmlAgmtDtlVO[]
	 * @param tesTmlAgmtHdrVO TesTmlAgmtDtlVO[]
	 * @return String
	 * @exception DAOException
	 */
	public String regBeforeCheckThrp(TesTmlAgmtDtlVO[] tesTmlAgmtDtlVOs, TesTmlAgmtHdrVO tesTmlAgmtHdrVO) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		String				thrpFlg			= "Y";
		
		try {
		
			for ( int i = 0; tesTmlAgmtDtlVOs != null &&  i < tesTmlAgmtDtlVOs.length; i++) {

				if ( !"".equals( tesTmlAgmtDtlVOs[i].getThrpLgsCostCd() )  ) {
				
					param.put( "tml_agmt_ofc_cty_cd", tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(0, 3) );
					param.put( "tml_agmt_seq"		, tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(3, 8) );
					param.put( "tml_agmt_ver_no"	, tesTmlAgmtHdrVO.getTmlAgmtVerNo().replaceAll("\\.", "") );
					param.put( "thrp_lgs_cost_cd"	, tesTmlAgmtDtlVOs[i].getLgsCostCd() );
	
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAORegBeforeCheckThrpRSQL(), param, velParam);

					if ( dbRowset != null && dbRowset .next() ) {
						thrpFlg	= "Y";
					} else {
						thrpFlg	= "N";
					}
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

		return thrpFlg;
	}

	/**
	 * 등록전 Accumulate Check
	 * 
	 * @param tesTmlAgmtDtlVOs TesTmlAgmtDtlVO[]
	 * @param tesTmlAgmtHdrVO TesTmlAgmtHdrVO
	 * @return String
	 * @exception DAOException
	 */
	public String regBeforeCheckAccm(TesTmlAgmtDtlVO[] tesTmlAgmtDtlVOs, TesTmlAgmtHdrVO tesTmlAgmtHdrVO) throws DAOException {

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		String				accmFlg			= "Y";
		String				toTrVolVal		= "";
		
		try {
		
			for ( int i = 0; tesTmlAgmtDtlVOs != null &&  i < tesTmlAgmtDtlVOs.length; i++) {

				if(	!"".equals(tesTmlAgmtDtlVOs[i].getFmTrVolVal()) && 
					!"".equals(tesTmlAgmtDtlVOs[i].getToTrVolVal()) &&
					"Y".equals(tesTmlAgmtDtlVOs[i].getAutoCalcFlg()) ) {
					
					toTrVolVal = tesTmlAgmtDtlVOs[i].getToTrVolVal().toUpperCase().equals("MAX") ? "9999999" : tesTmlAgmtDtlVOs[i].getToTrVolVal();
					
					if( !"1".equals( tesTmlAgmtDtlVOs[i].getFmTrVolVal() ) || !"9999999".equals(toTrVolVal) ) {
						if(Integer.parseInt(tesTmlAgmtDtlVOs[i].getFmTrVolVal())==1 && Integer.parseInt(toTrVolVal)<9999999){
							param.put( "vndr_seq"		, tesTmlAgmtHdrVO.getVndrSeq() );
							param.put( "yd_cd"			, tesTmlAgmtHdrVO.getYdCd() );
							param.put( "lgs_cost_cd"	, tesTmlAgmtDtlVOs[i].getLgsCostCd() );
	
							dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAORegBeforeCheckAccmRSQL(), param, velParam);
	
						}
						else if ( Integer.parseInt(tesTmlAgmtDtlVOs[i].getFmTrVolVal())>1 && Integer.parseInt(toTrVolVal)<9999999 ) {
							param.put( "vndr_seq"		, tesTmlAgmtHdrVO.getVndrSeq() );
							param.put( "yd_cd"			, tesTmlAgmtHdrVO.getYdCd() );
							param.put( "lgs_cost_cd"	, tesTmlAgmtDtlVOs[i].getLgsCostCd() );
							
							dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAORegBeforeCheckAccmRSQL(), param, velParam);
	
						}
						else if(Integer.parseInt(tesTmlAgmtDtlVOs[i].getFmTrVolVal())>1 && Integer.parseInt(toTrVolVal)==9999999) {
							param.put( "vndr_seq"		, tesTmlAgmtHdrVO.getVndrSeq() );
							param.put( "yd_cd"			, tesTmlAgmtHdrVO.getYdCd() );
							param.put( "lgs_cost_cd"	, tesTmlAgmtDtlVOs[i].getLgsCostCd() );
							
							dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAORegBeforeCheckAccmRSQL(), param, velParam);
						}
		
	
						if ( dbRowset != null && dbRowset .next() ) {
							accmFlg	= "Y";
						} else {
							accmFlg	= "N";
						}
					}
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
		return accmFlg;
	}
	
	/**
	 * TerminalAgreementManage의 Agreement Confirm 처리한다.<br>
	 *
	 * @param tesTmlAgmtHdrVO
	 * @exception DAOException
	 */
	public void registerAgreementConfirm(TesTmlAgmtHdrVO tesTmlAgmtHdrVO) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		
		try {
		
			if ( tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd() != null && !"".equals( tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd() ) ) {
				param.put( "tml_agmt_ofc_cty_cd", tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(0, 3) );
				param.put( "tml_agmt_seq"		, tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(3, 8) );
			}
			
			if ( tesTmlAgmtHdrVO.getTmlAgmtVerNo() != null && !"".equals( tesTmlAgmtHdrVO.getTmlAgmtVerNo() ) ) {
				param.put( "tml_agmt_ver_no"	, tesTmlAgmtHdrVO.getTmlAgmtVerNo().replaceAll("\\.", "") );
			}
				
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAORegisterAgreementConfirmUSQL(), param, velParam);
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
	}

	/**
	 * Agreement Header Info Insert.<br>
	 *
	 * @param tesTmlAgmtHdrVO
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void createTerminalAgreementBasicInfo(TesTmlAgmtHdrVO tesTmlAgmtHdrVO, String ofcCd) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( tesTmlAgmtHdrVO != null ) {
				Map<String, String> mapVO	= tesTmlAgmtHdrVO.getColumnValues();

				param.putAll(mapVO);
				param.put("tml_agmt_ver_no", "0101");
				
				if(tesTmlAgmtHdrVO.getAgmtCfmDt()!=null && !tesTmlAgmtHdrVO.getAgmtCfmDt().equals("")){
					param.put("agmt_cfm_usr_id", tesTmlAgmtHdrVO.getUpdUsrId());
					
				}
			}
			
			param.put( "ofc_cd", ofcCd );

			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAOCreateTerminalAgreementBasicInfoCSQL(), param, velParam);

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
	}
	

	/**
	 * Agreement Version No Detail Insert.<br>
	 *
	 * @param tesTmlAgmtDtlVO
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void createTerminalAgreementNo(TesTmlAgmtDtlVO tesTmlAgmtDtlVO, String ofcCd) throws DAOException {
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO	= tesTmlAgmtDtlVO.getColumnValues();
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param	.put( "tml_agmt_ver_no"	, mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
				param	.put( "cmnc_hrmnt"		, mapVO.get("cmnc_hrmnt").replaceAll("\\:", "") );
			}
			
			param	.put( "ofc_cd", ofcCd );
			velParam.put( "ofc_cd", ofcCd );

			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAOCreateTerminalAgreementNoCSQL(), param, velParam);

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
	}

	/**
	 * Agreement Header Info Update.<br>
	 *
	 * @param tesTmlAgmtHdrVO
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void modifyTerminalAgreementInfo(TesTmlAgmtHdrVO tesTmlAgmtHdrVO, String ofcCd) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		int					updCnt			= 0;
		
		try {		
			if ( tesTmlAgmtHdrVO != null ) {
				Map<String, String> mapVO	= tesTmlAgmtHdrVO.getColumnValues();
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			
				String tmlAgmtOfcCtyCd = tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd();
				if ( tmlAgmtOfcCtyCd != null && !"".equals( tmlAgmtOfcCtyCd ) ) {
					param.put( "tml_agmt_ofc_cty_cd", tmlAgmtOfcCtyCd.substring(0, 3) );
					param.put( "tml_agmt_seq"		, tmlAgmtOfcCtyCd.substring(3, 8) );
				}
				
				String tmlAgmtVerNo = tesTmlAgmtHdrVO.getTmlAgmtVerNo();
				if ( tmlAgmtVerNo != null && !"".equals( tmlAgmtVerNo ) ) {
					param.put( "tml_agmt_ver_no"	, tmlAgmtVerNo.replaceAll("\\.", "") );
				}
				
				// AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : 양양선B 4347-08-27) 
	//			if ( tesTmlAgmtHdrVO.getAgmtCfmDt() != null && !"".equals( tesTmlAgmtHdrVO.getAgmtCfmDt() ) ) {
	//				param.put( "agmt_cfm_usr_id"	, tesTmlAgmtHdrVO.getUpdUsrId() );
	//			}
				
				if ( tesTmlAgmtHdrVO.getAgmtCfmFlg() != null && "".equals( tesTmlAgmtHdrVO.getAgmtCfmFlg() ) ) {
					if("Y".equals( tesTmlAgmtHdrVO.getAgmtCfmFlg())) {
						param.put( "agmt_cfm_usr_id"	, tesTmlAgmtHdrVO.getUpdUsrId() );
					}
				}
			}
			
			if ( ofcCd != null && !"".equals( ofcCd )) {
				param.put( "ofc_cd"	, ofcCd );
			}

			updCnt	= new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAOModifyTerminalAgreementInfoUSQL(), param, velParam);


			if (updCnt < 1) {
				// 데이터 반영에 실패하였습니다.
				throw new DAOException(new ErrorHandler("COM11001").getMessage());
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
	}

	/**
	 * Agreement Header Info GW Link Update.<br>
	 *
	 * @param tesTmlAgmtHdrVO
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void modifyTerminalAgreementContractInfo(TesTmlAgmtHdrVO tesTmlAgmtHdrVO, String ofcCd) throws DAOException {
		
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		int					updCnt			= 0;
		
		try {
			
			if ( tesTmlAgmtHdrVO != null ) {
				Map<String, String> mapVO	= tesTmlAgmtHdrVO.getColumnValues();
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			
				String tmlAgmtOfcCtyCd = JSPUtil.getNull(tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd());
				if ( tmlAgmtOfcCtyCd != null && !"".equals( tmlAgmtOfcCtyCd ) ) {
					param.put( "tml_agmt_ofc_cty_cd", tmlAgmtOfcCtyCd.substring(0, 3) );
					param.put( "tml_agmt_seq"		, tmlAgmtOfcCtyCd.substring(3, 8) );
				}
				
				String tmlAgmtVerNo = JSPUtil.getNull(tesTmlAgmtHdrVO.getTmlAgmtVerNo());
				if ( tmlAgmtVerNo != null && !"".equals( tmlAgmtVerNo ) ) {
					param.put( "tml_agmt_ver_no"	, tmlAgmtVerNo.replaceAll("\\.", "") );
				}
			}
			
			if ( ofcCd != null && !"".equals( ofcCd )) {
				param.put( "ofc_cd"	, ofcCd );
			}
			
			updCnt	= new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAOModifyTerminalAgreementContractInfoUSQL(), param, velParam);
			
			
			if (updCnt < 1) {
				// 데이터 반영에 실패하였습니다.
				throw new DAOException(new ErrorHandler("COM11001").getMessage());
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
	}
	
	/**
	 * TerminalAgreementManage HDR 정보의 DB에서 DELT_FLG를 Y로 수정한다.<br>
	 *
	 * @param tesTmlAgmtHdrVO
	 * @exception DAOException
	 */
	public void modifyTerminalAgreementDelete(TesTmlAgmtHdrVO tesTmlAgmtHdrVO) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		int					updCnt			= 0;
		
		try {
		
			if ( tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd() != null && !"".equals( tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd() ) ) {
				param.put( "tml_agmt_ofc_cty_cd", tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(0, 3) );
				param.put( "tml_agmt_seq"		, tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(3, 8) );
			}
			
			if ( tesTmlAgmtHdrVO.getTmlAgmtVerNo() != null && !"".equals( tesTmlAgmtHdrVO.getTmlAgmtVerNo() ) ) {
				param.put( "tml_agmt_ver_no"	, tesTmlAgmtHdrVO.getTmlAgmtVerNo().replaceAll("\\.", "") );
			}
			
			updCnt	= new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAOModifyTerminalAgreementDeleteUSQL(), param, velParam);

			if (updCnt < 1) {
				// 데이터 삭제에 실패하였습니다.
				throw new DAOException(new ErrorHandler("COM11001").getMessage());
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
	}

	
	/**
	 * Agreement Detail Maximum Sequence No. Select<br>
	 *
	 * @param tesTmlAgmtDtlVO
	 * @param tmlAgmtVerNoNew
	 * @see EsdTes0034Event
	 * @return int
	 * @exception DAOException
	 */
	public int insertTerminalAgreementSeq(TesTmlAgmtDtlVO tesTmlAgmtDtlVO, String tmlAgmtVerNoNew ) throws DAOException {

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		int				maxSeq			= 0;
		
		try {

			if ( tesTmlAgmtDtlVO.getTmlAgmtOfcCtyCd() != null && !"".equals( tesTmlAgmtDtlVO.getTmlAgmtOfcCtyCd() ) ) {
				param.put("tml_agmt_ofc_cty_cd"	, tesTmlAgmtDtlVO.getTmlAgmtOfcCtyCd().substring( 0, 3 ) );
				param.put("tml_agmt_seq"		, tesTmlAgmtDtlVO.getTmlAgmtOfcCtyCd().substring( 3, 8 ) );
			}

			if ( tmlAgmtVerNoNew != null && !"".equals( tmlAgmtVerNoNew ) ) {
				param.put("tml_agmt_ver_no"	, tmlAgmtVerNoNew.replaceAll("\\.", "") );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOInsertTerminalAgreementSeqRSQL(), param, velParam);

			if ( dbRowset != null && dbRowset.next() ) {
				maxSeq	= dbRowset.getInt("MAX_NUM");
			}
			

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		return maxSeq;
	}
	
	/**
	 * TerminalAgreementManage의 Type Size 조회한다.<br>
	 *
	 * @return DBRowSet
	 * @see EsdTes0034Event
	 * @exception DAOException
	 */
	public DBRowSet insertTerminalAgreementTPSZ( ) throws DAOException {

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOInsertTerminalAgreementTPSZRSQL(), param, velParam);
			
			return dbRowset;

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * TerminalAgreementManage의 Terminal Detail Data Insert.<br>
	 *
	 * @param insertList List<TesTmlAgmtDtlVO>
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void insertTerminalAgreementDTLInsert(List<TesTmlAgmtDtlVO> insertList, String ofcCd) throws DAOException {
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			if ( ofcCd != null && !"".equals( ofcCd ) ) {
				param	.put( "ofc_cd", ofcCd );
				velParam.put( "ofc_cd", ofcCd );
			}

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOInsertTerminalAgreementDTLInsertCSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	


		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * TerminalAgreementManage의 Terminal Container Type Seiz Data Insert.<br>
	 *
	 * @param insertList List<TesTmlAgmtTpSzVO>
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void insertTerminalAgreementTPSZInsert(List<TesTmlAgmtTpSzVO> insertList, String ofcCd) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			if ( ofcCd != null && !"".equals( ofcCd ) ) {
				param	.put( "ofc_cd", ofcCd );
				velParam.put( "ofc_cd", ofcCd );
			}

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOInsertTerminalAgreementTPSZInsertCSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * TerminalAgreementManage의 Terminal Apply Days Data Insert <br>
	 *
	 * @param insertList List<TesTmlAgmtAplyDyVO>
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void insertTerminalAgreementAPLYDYInsert(List<TesTmlAgmtAplyDyVO> insertList, String ofcCd) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			if ( ofcCd != null && !"".equals( ofcCd ) ) {
				param	.put( "ofc_cd", ofcCd );
				velParam.put( "ofc_cd", ofcCd );
			}

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOInsertTerminalAgreementAPLYDYInsertCSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	


		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * TerminalAgreementManage의 Terminal Danger Cargo Class Data Insert.<br>
	 *
	 * @param insertList List<TesTmlAgmtDgCgoClssVO>
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void insertTerminalAgreementDGCGOInsert(List<TesTmlAgmtDgCgoClssVO> insertList, String ofcCd) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			if ( ofcCd != null && !"".equals( ofcCd ) ) {
				param	.put( "ofc_cd", ofcCd );
				velParam.put( "ofc_cd", ofcCd );
			}

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOInsertTerminalAgreementDGCGOInsertCSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	


		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	

	
	/**
	 * TerminalAgreementManage의 Storage Detail Data Insert.<br>
	 *
	 * @param insertList List<TesTmlAgmtDtlVO>
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void insertStorageAgreementDTLInsert(List<TesTmlAgmtDtlVO> insertList, String ofcCd) throws DAOException {
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			if ( ofcCd != null && !"".equals( ofcCd ) ) {
				param	.put( "ofc_cd", ofcCd );
				velParam.put( "ofc_cd", ofcCd );
			}

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOInsertStorageAgreementDTLInsertCSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	


		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * TerminalAgreementManage의 Storage Container Type Size Data Insert.<br>
	 *
	 * @param insertList List<TesTmlAgmtTpSzVO>
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void insertStorageAgreementTPSZInsert(List<TesTmlAgmtTpSzVO> insertList, String ofcCd) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			if ( ofcCd != null && !"".equals( ofcCd ) ) {
				param	.put( "ofc_cd", ofcCd );
				velParam.put( "ofc_cd", ofcCd );
			}

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOInsertStorageAgreementTPSZInsertCSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * TerminalAgreementManage의 Storage Apply Days Data Insert.<br>
	 *
	 * @param insertList List<TesTmlAgmtAplyDyVO>
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void insertStorageAgreementAPLYDYInsert(List<TesTmlAgmtAplyDyVO> insertList, String ofcCd) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			if ( ofcCd != null && !"".equals( ofcCd ) ) {
				param	.put( "ofc_cd", ofcCd );
				velParam.put( "ofc_cd", ofcCd );
			}

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOInsertStorageAgreementAPLYDYInsertCSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * TerminalAgreementManage의 Storage Danger Cargo Data Insert.<br>
	 *
	 * @param insertList List<TesTmlAgmtDgCgoClssVO>
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void insertStorageAgreementDGCGOInsert(List<TesTmlAgmtDgCgoClssVO> insertList, String ofcCd) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			if ( ofcCd != null && !"".equals( ofcCd ) ) {
				param	.put( "ofc_cd", ofcCd );
				velParam.put( "ofc_cd", ofcCd );
			}

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOInsertTerminalAgreementDGCGOInsertCSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * TerminalAgreementManage의 Agreement Confirm 처리한다.<br>
	 *
	 * @param tesTmlAgmtHdrVO
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void modifySTSAgreement(TesTmlAgmtHdrVO tesTmlAgmtHdrVO, String ofcCd) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		
		try {
		
			if ( tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd() != null && !"".equals( tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd() ) ) {
				param.put( "tml_agmt_ofc_cty_cd", tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(0, 3) );
				param.put( "tml_agmt_seq"		, tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(3, 8) );
			}
			
			if ( tesTmlAgmtHdrVO.getTmlAgmtVerNo() != null && !"".equals( tesTmlAgmtHdrVO.getTmlAgmtVerNo() ) ) {
				param.put( "tml_agmt_ver_no"	, tesTmlAgmtHdrVO.getTmlAgmtVerNo().replaceAll("\\.", "") );
			}

			if ( tesTmlAgmtHdrVO.getAgmtRmk() != null && !"".equals( tesTmlAgmtHdrVO.getAgmtRmk() ) ) {
				param.put( "agmt_rmk"	, tesTmlAgmtHdrVO.getAgmtRmk() );
			}

			if ( tesTmlAgmtHdrVO.getTmlAgmtVerNo() != null && !"".equals( tesTmlAgmtHdrVO.getTmlAgmtVerNo() ) ) {
				param.put( "upd_usr_id"	, tesTmlAgmtHdrVO.getCreUsrId() );
			}
			
			if ( ofcCd != null && !"".equals( ofcCd ) ) {
				param.put( "ofc_cd"	, ofcCd );
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAOModifySTSAgreementUSQL(), param, velParam);

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
	}
	

	/**
	 * TerminalAgreement Type Size Delete.<br>
	 *
	 * @param tesTmlAgmtDtlVO TesTmlAgmtDtlVO
	 * @exception DAOException
	 */
	public void deleteAgreement_modifyDelete01(TesTmlAgmtDtlVO tesTmlAgmtDtlVO) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			Map<String, String>		mapVO	= tesTmlAgmtDtlVO.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				param.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAODeleteAgreement_modifyDelete01DSQL(), param, velParam);

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
	}

	/**
	 * TerminalAgreementManage Apply Day Delete.<br>
	 *
	 * @param tesTmlAgmtDtlVO TesTmlAgmtDtlVO
	 * @exception DAOException
	 */
	public void deleteAgreement_modifyDelete02(TesTmlAgmtDtlVO tesTmlAgmtDtlVO) throws DAOException {
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			Map<String, String>		mapVO	= tesTmlAgmtDtlVO.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				param.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAODeleteAgreement_modifyDelete02DSQL(), param, velParam);

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
	}
	
	/**
	 * TerminalAgreementManage Danger Cargo Class Delete.<br>
	 *
	 * @param tesTmlAgmtDtlVO TesTmlAgmtDtlVO
	 * @exception DAOException
	 */
	public void deleteAgreement_modifyDelete03(TesTmlAgmtDtlVO tesTmlAgmtDtlVO) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			Map<String, String>		mapVO	= tesTmlAgmtDtlVO.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				param.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAODeleteAgreement_modifyDelete03DSQL(), param, velParam);

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
	}
	
	/**
	 * TerminalAgreementManage Throughput Cost Code Delete.<br>
	 *
	 * @param tesTmlAgmtDtlVO
	 * @exception DAOException
	 */
	public void deleteAgreement_modifyDelete04(TesTmlAgmtDtlVO tesTmlAgmtDtlVO) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			Map<String, String>		mapVO	= tesTmlAgmtDtlVO.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				param.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAODeleteAgreement_modifyDelete04DSQL(), param, velParam);

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
	}
	
	/**
	 * TerminalAgreementManage Detail Delete.<br>
	 *
	 * @param tesTmlAgmtDtlVO
	 * @exception DAOException
	 */
	public void deleteAgreement_modifyDelete05(TesTmlAgmtDtlVO tesTmlAgmtDtlVO) throws DAOException {
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			Map<String, String>		mapVO	= tesTmlAgmtDtlVO.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				param.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAODeleteAgreement_modifyDelete05DSQL(), param, velParam);


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
	}

	
	/**
	 * Throughput Cost Code Delete.<br>
	 * 
	 * @param tesTmlAgmtThrpCostVO
	 * @exception DAOException
	 */
	public void deleteThoroughputCC (TesTmlAgmtThrpCostVO tesTmlAgmtThrpCostVO) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			Map<String, String>		mapVO	= tesTmlAgmtThrpCostVO.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param	.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
				velParam.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAODeleteThoroughputCCDSQL(), param, velParam);


		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	
	
	/**
	 * Throughput Cost Code 의 Max Sequence 값을 조회한다.
	 * 
	 * @param tesTmlAgmtThrpCostVO
	 * @return int
	 * @throws DAOException
	 */
	public int createThoroughputCCSeq (TesTmlAgmtThrpCostVO tesTmlAgmtThrpCostVO) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		int					maxSeq			= 0;

		try {
		
			Map<String, String>		mapVO	= tesTmlAgmtThrpCostVO.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param	.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
				velParam.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
			}
			

			dbRowset	= new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOCreateThoroughputCCRSQL(), param, velParam);


			if ( dbRowset != null && dbRowset.next() ) {
				maxSeq	= dbRowset.getInt("max_num");
			}
			

			return maxSeq;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}

	
	/**
	 * Throughput Cost Code Insert.<br>
	 * 
	 * @param insertList List<TesTmlAgmtThrpCostVO>
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void createThoroughputCCInsert (List<TesTmlAgmtThrpCostVO> insertList, String ofcCd) throws DAOException {
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			param.put( "ofc_cd", ofcCd );

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOCreateThoroughputCCCSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}


	/**
	 * Agreement Header Insert.<br>
	 * 
	 * @param tmlAgmtOfcCtyCd
	 * @param tmlAgmtSeq
	 * @param tmlAgmtVerNo
	 * @param tmlAgmtVerNoNew
	 * @param tesTmlAgmtHdrVO
	 * @param amendGb
	 * @param versionGb
	 * @param ofcCd
	 * @param userId
	 * @exception DAOException
	 */
	public void agreementHistoryHDR(String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String tmlAgmtVerNo, String tmlAgmtVerNoNew,
									TesTmlAgmtHdrVO tesTmlAgmtHdrVO, String amendGb, String versionGb, String ofcCd, String userId) throws DAOException {
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO	= tesTmlAgmtHdrVO.getColumnValues();
			if ( mapVO != null ) {
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put( "tml_agmt_ofc_cty_cd", tmlAgmtOfcCtyCd );
				param.put( "tml_agmt_seq"		, tmlAgmtSeq );
				param.put( "tml_agmt_ver_no"	, tmlAgmtVerNo );
				param.put( "tml_agmt_ver_no_new", tmlAgmtVerNoNew );
			}
			
			param	.put( "cre_usr_id"	, userId );
			velParam.put( "cre_usr_id"	, userId );
			param	.put( "ofc_cd"		, ofcCd );
			velParam.put( "ofc_cd"		, ofcCd );

			velParam.put( "amend_gb"	, amendGb );
			velParam.put( "version_gb"	, versionGb );
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAOAgreementHistoryHDRCSQL(), param, velParam);
			
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
	}

	/**
	 * Agreement Detail Insert.<br>
	 * 
	 * @param tmlAgmtOfcCtyCd
	 * @param tmlAgmtSeq
	 * @param tmlAgmtVerNo
	 * @param tmlAgmtVerNoNew
	 * @param ofcCd
	 * @param userId
	 * @exception DAOException
	 */
	public void agreementHistoryDTL(String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String tmlAgmtVerNo, String tmlAgmtVerNoNew, String ofcCd, String userId) throws DAOException {
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			param.put( "tml_agmt_ofc_cty_cd", tmlAgmtOfcCtyCd );
			param.put( "tml_agmt_seq"		, tmlAgmtSeq );
			param.put( "tml_agmt_ver_no"	, tmlAgmtVerNo );
			param.put( "tml_agmt_ver_no_new", tmlAgmtVerNoNew );
			param.put( "cre_usr_id"			, userId );
			param.put( "ofc_cd"				, ofcCd );

			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAOAgreementHistoryDTLCSQL(), param, velParam);

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
	}

	
	/**
	 * Agreement Type Size Insert.<br>
	 * 
	 * @param tmlAgmtOfcCtyCd
	 * @param tmlAgmtSeq
	 * @param tmlAgmtVerNo
	 * @param tmlAgmtVerNoNew
	 * @param ofcCd
	 * @param userId
	 * @exception DAOException
	 */
	public void agreementHistoryTS(String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String tmlAgmtVerNo, String tmlAgmtVerNoNew, String ofcCd, String userId) throws DAOException {
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			param.put( "tml_agmt_ofc_cty_cd", tmlAgmtOfcCtyCd );
			param.put( "tml_agmt_seq"		, tmlAgmtSeq );
			param.put( "tml_agmt_ver_no"	, tmlAgmtVerNo );
			param.put( "tml_agmt_ver_no_new", tmlAgmtVerNoNew );
			param.put( "cre_usr_id"			, userId );
			param.put( "ofc_cd"				, ofcCd );

			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAOAgreementHistoryTSCSQL(), param, velParam);
	

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
	}

	/**
	 * Agreement Apply Day Insert.<br>
	 * 
	 * @param tmlAgmtOfcCtyCd
	 * @param tmlAgmtSeq
	 * @param tmlAgmtVerNo
	 * @param tmlAgmtVerNoNew
	 * @param ofcCd
	 * @param userId
	 * @exception DAOException
	 */
	public void agreementHistoryAD(String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String tmlAgmtVerNo, String tmlAgmtVerNoNew, String ofcCd, String userId) throws DAOException {
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			param.put( "tml_agmt_ofc_cty_cd", tmlAgmtOfcCtyCd );
			param.put( "tml_agmt_seq"		, tmlAgmtSeq );
			param.put( "tml_agmt_ver_no"	, tmlAgmtVerNo );
			param.put( "tml_agmt_ver_no_new", tmlAgmtVerNoNew );
			param.put( "cre_usr_id"			, userId );
			param.put( "ofc_cd"				, ofcCd );

			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAOAgreementHistoryADCSQL(), param, velParam);
			

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
	}

	
	/**
	 * Agreement DG Cargo Class Insert.<br>
	 * 
	 * @param tmlAgmtOfcCtyCd
	 * @param tmlAgmtSeq
	 * @param tmlAgmtVerNo
	 * @param tmlAgmtVerNoNew
	 * @param ofcCd
	 * @param userId
	 * @exception DAOException
	 */
	public void agreementHistoryDCC(String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String tmlAgmtVerNo, String tmlAgmtVerNoNew, String ofcCd, String userId) throws DAOException {
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			param.put( "tml_agmt_ofc_cty_cd", tmlAgmtOfcCtyCd );
			param.put( "tml_agmt_seq"		, tmlAgmtSeq );
			param.put( "tml_agmt_ver_no"	, tmlAgmtVerNo );
			param.put( "tml_agmt_ver_no_new", tmlAgmtVerNoNew );
			param.put( "cre_usr_id"			, userId );
			param.put( "ofc_cd"				, ofcCd );

			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAOAgreementHistoryDCCCSQL(), param, velParam);

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
	}

	/**
	 * Agreement Throughput Cost Insert.<br>
	 * 
	 * @param tmlAgmtOfcCtyCd
	 * @param tmlAgmtSeq
	 * @param tmlAgmtVerNo
	 * @param tmlAgmtVerNoNew
	 * @param ofcCd
	 * @param userId
	 * @exception DAOException
	 */
	public void agreementHistoryThrp(String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String tmlAgmtVerNo, String tmlAgmtVerNoNew, String ofcCd, String userId) throws DAOException {
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			param.put( "tml_agmt_ofc_cty_cd", tmlAgmtOfcCtyCd );
			param.put( "tml_agmt_seq"		, tmlAgmtSeq );
			param.put( "tml_agmt_ver_no"	, tmlAgmtVerNo );
			param.put( "tml_agmt_ver_no_new", tmlAgmtVerNoNew );
			param.put( "cre_usr_id"			, userId );
			param.put( "ofc_cd"				, ofcCd );

			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAOAgreementHistoryThrpCSQL(), param, velParam);

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
	}


	/**
	 * Agreement Throughput Cost Insert.<br>
	 * 
	 * @param insertList List<TesTmlAgmtThrpCostVO>
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void insertAgmtListThrpInsert(List<TesTmlAgmtThrpCostVO> insertList, String ofcCd) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			if( ofcCd != null && !"".equals( ofcCd ) ) {
				param	.put("ofc_cd", ofcCd );
				velParam.put("ofc_cd", ofcCd );
			}

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOInsertAgmtListThrpInsertCSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
	}

	
	/**
	 * Agreement Throughput Cost Max Sequence 조회.<br>
	 * 
	 * @param tmlAgmtOfcCtyCd
	 * @param tmlAgmtSeq
	 * @param tmlAgmtVerNo
	 * @return String
	 * @exception DAOException
	 */
	public int insertAgmtListThrpSeq(String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String tmlAgmtVerNo ) throws DAOException {

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		int		maxSeq		= 1;

		try {
			
			if ( tmlAgmtOfcCtyCd != null && !"".equals( tmlAgmtOfcCtyCd ) ) {
				param.put( "tml_agmt_ofc_cty_cd", tmlAgmtOfcCtyCd );
			}

			if ( tmlAgmtSeq != null && !"".equals( tmlAgmtSeq ) ) {
				param.put( "tml_agmt_seq", tmlAgmtSeq );
			}

			if ( tmlAgmtVerNo != null && !"".equals( tmlAgmtVerNo ) ) {
				param.put( "tml_agmt_ver_no", tmlAgmtVerNo );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOInsertAgmtListThrpSeqRSQL(), param, velParam);

			if (dbRowset != null && dbRowset.next()) {
            	maxSeq = dbRowset.getInt("max_thrp_seq");
            }

			return maxSeq;

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
	}
	
	/**
	 * Agreement Throughput Cost Insert.<br>
	 * 
	 * @param tmlAgmtOfcCtyCd
	 * @param tmlAgmtSeq
	 * @param tmlAgmtVerNo
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet insertAgmtListThrpList(String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String tmlAgmtVerNo) throws DAOException {

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( tmlAgmtOfcCtyCd != null && !"".equals( tmlAgmtOfcCtyCd ) ) {
				param.put( "tml_agmt_ofc_cty_cd", tmlAgmtOfcCtyCd );
			}

			if ( tmlAgmtSeq != null && !"".equals( tmlAgmtSeq ) ) {
				param.put( "tml_agmt_seq", tmlAgmtSeq );
			}

			if ( tmlAgmtVerNo != null && !"".equals( tmlAgmtVerNo ) ) {
				param.put( "tml_agmt_ver_no", tmlAgmtVerNo );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOInsertAgmtListThrpListRSQL(), param, velParam);
			
			return dbRowset;
			
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
	}
	
	/**
	 * Agreement Throughput Cost Update.<br>
	 * 
	 * @param insertList List<TesTmlAgmtDtlVO>
	 * @exception DAOException
	 */
	public void insertAgmtListThrpUpdate(List<TesTmlAgmtDtlVO> insertList) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	updCnt		= null;
			

			if( insertList.size() > 0){
				updCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOInsertAgmtListThrpUpdateUSQL(), insertList, param, velParam);
				
				for(int i = 0; i < updCnt.length; i++){
					if( updCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
	}

	

	
	/**
	 * Agreement Detail Delete.<br>
	 * 
	 * @param deleteList List<TesTmlAgmtDtlVO>
	 * @exception DAOException
	 */
	public void removeAgreementDTL(List<TesTmlAgmtDtlVO> deleteList) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	delCnt		= null;
			

			if( deleteList.size() > 0){
				delCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAORemoveAgreementDTLDSQL(), deleteList, param, velParam);
				
				for(int i = 0; i < delCnt.length; i++){
					if( delCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
	}
	
	/**
	 * Agreement Type Size Delete.<br>
	 * 
	 * @param deleteList List<TesTmlAgmtTpSzVO>
	 * @exception DAOException
	 */
	public void removeAgreementTPSZ(List<TesTmlAgmtTpSzVO> deleteList) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	delCnt		= null;
			

			if( deleteList.size() > 0){
				delCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAORemoveAgreementTPSZDSQL(), deleteList, param, velParam);
				
				for(int i = 0; i < delCnt.length; i++){
					if( delCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
	}
	
	/**
	 * Agreement Apply Day Delete.<br>
	 * 
	 * @param deleteList List<TesTmlAgmtAplyDyVO>
	 * @exception DAOException
	 */
	public void removeAgreementAPLYDY(List<TesTmlAgmtAplyDyVO> deleteList) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	delCnt		= null;
			
			if( deleteList.size() > 0){
				delCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAORemoveAgreementAPLYDYDSQL(), deleteList, param, velParam);
				
				for(int i = 0; i < delCnt.length; i++){
					if( delCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
	}
	
	/**
	 * Agreement DG Cargo Class Delete.<br>
	 * 
	 * @param deleteList List<TesTmlAgmtDgCgoClssVO>
	 * @exception DAOException
	 */
	public void removeAgreementDGCGO(List<TesTmlAgmtDgCgoClssVO> deleteList) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	delCnt		= null;
			

			if( deleteList.size() > 0){
				delCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAORemoveAgreementDGCGODSQL(), deleteList, param, velParam);
				
				for(int i = 0; i < delCnt.length; i++){
					if( delCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
	}
	
	/**
	 * Agreement Throughput Cost Code Delete.<br>
	 * 
	 * @param deleteList List<TesTmlAgmtDgCgoClssVO>
	 * @exception DAOException
	 */
	public void removeAgreementTHRPCOST(List<TesTmlAgmtDgCgoClssVO> deleteList) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	delCnt		= null;
			
			if( deleteList.size() > 0){
				delCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAORemoveAgreementTHRPCOSTDSQL(), deleteList, param, velParam);
				
				for(int i = 0; i < delCnt.length; i++){
					if( delCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
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
	}
//===== Vol. Accumulate Method ========================================================

	//----- Method ------------------------------------------------------------------------

	/**
	 * Vol. Accumulate Method 정보를 가져온다.<br>
	 *
	 * @param TesAgreementManageCommonVO tesAgreementManageCommonVO
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchVolumeAccumulatedMethod(TesAgreementManageCommonVO tesAgreementManageCommonVO) throws DAOException {

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( tesAgreementManageCommonVO.getVndrSeq() != null && !"".equals( tesAgreementManageCommonVO.getVndrSeq())) {
				param.put("vndr_seq", tesAgreementManageCommonVO.getVndrSeq() );
			}
			
			if ( tesAgreementManageCommonVO.getAccmSeq() != null && !"".equals( tesAgreementManageCommonVO.getAccmSeq())) {
				param.put("accm_seq", tesAgreementManageCommonVO.getAccmSeq() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchVolumeAccumulatedMethodRSQL(), param, velParam);

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
		return dbRowset;
	}




	/**
	 * Vol. Accumulate Method 데이타 모델을 DB에 저장한다. <br>
	 *
	 * @param TesAgreementManageCommonVO tesAgreementManageCommonVO
	 * @see UI_ESD_TES_9200
	 * @exception DAOException
	 */
    public void removeVolumeAccumulatedMethod(TesAgreementManageCommonVO tesAgreementManageCommonVO) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			if ( tesAgreementManageCommonVO.getVndrSeq() != null && !"".equals(tesAgreementManageCommonVO.getVndrSeq() ) ) {
				param.put( "vndr_seq", tesAgreementManageCommonVO.getVndrSeq() );
			}

			if ( tesAgreementManageCommonVO.getAccmSeq() != null && !"".equals(tesAgreementManageCommonVO.getAccmSeq() ) ) {
				param.put( "accm_seq", tesAgreementManageCommonVO.getAccmSeq() );
			}


			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAORemoveVolumeAccumulatedMethodDSQL(), param, velParam);

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
    }
    

	/**
	 * Volume. Accumulate Method Insert<br>
	 *
	 * @param TesAgreementManageCommonVO tesAgreementManageCommonVO
	 * @param List<TesTmlSoAccmMzdVO> insertList
	 * @see UI_ESD_TES_9200
	 * @exception DAOException
	 */
	public void multiVolumeAccumulatedMethodInsert(TesAgreementManageCommonVO tesAgreementManageCommonVO, List<TesTmlSoAccmMzdVO> insertList) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			if ( tesAgreementManageCommonVO.getOfcCd() != null && !"".equals( tesAgreementManageCommonVO.getOfcCd() ) ) {
				param.put( "ofc_cd", tesAgreementManageCommonVO.getOfcCd() );
			}
			

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOMultiVolumeAccumulatedMethodCSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	
			

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}

	
	/**
	 * Volume. Accumulate Method Update<br>
	 *
	 * @param TesAgreementManageCommonVO tesAgreementManageCommonVO
	 * @param List<TesTmlSoAccmMzdVO> insertList
	 * @see UI_ESD_TES_9200
	 * @exception DAOException
	 */
	public void multiVolumeAccumulatedMethodUpdate(TesAgreementManageCommonVO tesAgreementManageCommonVO, List<TesTmlSoAccmMzdVO> insertList) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			if ( tesAgreementManageCommonVO.getOfcCd() != null && !"".equals( tesAgreementManageCommonVO.getOfcCd() ) ) {
				param.put( "ofc_cd", tesAgreementManageCommonVO.getOfcCd() );
			}
			

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOMultiVolumeAccumulatedMethodUSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	
	
	/**
	 * Volume. Accumulate Method Delete<br>
	 *
	 * @param List<TesTmlSoAccmMzdVO> deleteList
	 * @see UI_ESD_TES_9200
	 * @exception DAOException
	 */
	public void multiVolumeAccumulatedMethodDelete(List<TesTmlSoAccmMzdVO> deleteList) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			if( deleteList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOMultiVolumeAccumulatedMethodDSQL(), deleteList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	
			

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	//----- CostCode ------------------------------------------------------------------------

	/**
	 * Volume. Accumulate Cost Code List Select.<br>
	 *
	 * @param TesAgreementManageCommonVO tesAgreementManageCommonVO
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchListVolumeAccumulatedCostCode(TesAgreementManageCommonVO tesAgreementManageCommonVO) throws DAOException {

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( tesAgreementManageCommonVO.getVndrSeq() != null && !"".equals( tesAgreementManageCommonVO.getVndrSeq())) {
				param.put("vndr_seq", tesAgreementManageCommonVO.getVndrSeq() );
			}
			
			if ( tesAgreementManageCommonVO.getAccmSeq() != null && !"".equals( tesAgreementManageCommonVO.getAccmSeq())) {
				param.put("accm_seq", tesAgreementManageCommonVO.getAccmSeq() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchListVolumeAccumulatedCostCodeRSQL(), param, velParam);
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
		return dbRowset;
	}

	/**
	 * Volume. Accumulate Cost Code Delete.<br>
	 *
	 * @param TesAgreementManageCommonVO tesAgreementManageCommonVO
	 * @see UI_ESD_TES_9200
	 * @exception DAOException
	 */
	public void removeListVolumeAccumulatedCostCode(TesAgreementManageCommonVO tesAgreementManageCommonVO) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			if ( tesAgreementManageCommonVO.getVndrSeq() != null && !"".equals(tesAgreementManageCommonVO.getVndrSeq() ) ) {
				param.put( "vndr_seq", tesAgreementManageCommonVO.getVndrSeq() );
			}

			if ( tesAgreementManageCommonVO.getAccmSeq() != null && !"".equals(tesAgreementManageCommonVO.getAccmSeq() ) ) {
				param.put( "accm_seq", tesAgreementManageCommonVO.getAccmSeq() );
			}


			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAORemoveListVolumeAccumulatedCostCodeDSQL(), param, velParam);


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
    }

	/**
	 * Volume. Accumulate Yard Delete.<br>
	 *
	 * @param TesAgreementManageCommonVO tesAgreementManageCommonVO
	 * @see UI_ESD_TES_920Event
	 * @exception DAOException
	 */
	public void removeListVolumeAccumulatedYard(TesAgreementManageCommonVO tesAgreementManageCommonVO) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			if ( tesAgreementManageCommonVO.getVndrSeq() != null && !"".equals(tesAgreementManageCommonVO.getVndrSeq() ) ) {
				param.put( "vndr_seq", tesAgreementManageCommonVO.getVndrSeq() );
			}

			if ( tesAgreementManageCommonVO.getAccmSeq() != null && !"".equals(tesAgreementManageCommonVO.getAccmSeq() ) ) {
				param.put( "accm_seq", tesAgreementManageCommonVO.getAccmSeq() );
			}


			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAORemoveListVolumeAccumulatedYardDSQL(), param, velParam);


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
    }

	/**
	 * Volume. Accumulate Delete.<br>
	 *
	 * @param TesAgreementManageCommonVO tesAgreementManageCommonVO
	 * @see UI_ESD_TES_920Event
	 * @exception DAOException
	 */
	public void removeVolumeAccm(TesAgreementManageCommonVO tesAgreementManageCommonVO) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			if ( tesAgreementManageCommonVO.getVndrSeq() != null && !"".equals(tesAgreementManageCommonVO.getVndrSeq() ) ) {
				param.put( "vndr_seq", tesAgreementManageCommonVO.getVndrSeq() );
			}

			if ( tesAgreementManageCommonVO.getAccmSeq() != null && !"".equals(tesAgreementManageCommonVO.getAccmSeq() ) ) {
				param.put( "accm_seq", tesAgreementManageCommonVO.getAccmSeq() );
			}


			new SQLExecuter("").executeUpdate((ISQLTemplate)new TerminalAgreementManageDBDAORemoveVolumeAccmDSQL(), param, velParam);


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
    }

	/**
	 * Volume. Accumulate CostCode Insert<br>
	 *
	 * @param tesAgreementManageCommonVO TesAgreementManageCommonVO
	 * @param insertList List<TesTmlSoAccmCostVO>
	 * @see UI_ESD_TES_920Event
	 * @exception DAOException
	 */
	public void multiVolumeAccumulatedCostCode(TesAgreementManageCommonVO tesAgreementManageCommonVO, List<TesTmlSoAccmCostVO> insertList) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			
			if( tesAgreementManageCommonVO.getOfcCd() != null && !"".equals( tesAgreementManageCommonVO.getOfcCd() ) ) {
				param	.put("ofc_cd", tesAgreementManageCommonVO.getOfcCd());
				velParam.put("ofc_cd", tesAgreementManageCommonVO.getOfcCd());
			}

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOMultiVolumeAccumulatedCostCodeCSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}

	//----- Yard ------------------------------------------------------------------------

	/**
	 * Volume. Accumulate Yard 정보를 가져온다.<br>
	 *
	 * @param tesAgreementManageCommonVO
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchListVolumeAccumulatedYard(TesAgreementManageCommonVO tesAgreementManageCommonVO) throws DAOException {

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			if ( tesAgreementManageCommonVO.getVndrSeq() != null && !"".equals( tesAgreementManageCommonVO.getVndrSeq())) {
				param.put("vndr_seq", tesAgreementManageCommonVO.getVndrSeq() );
			}
			
			if ( tesAgreementManageCommonVO.getAccmSeq() != null && !"".equals( tesAgreementManageCommonVO.getAccmSeq())) {
				param.put("accm_seq", tesAgreementManageCommonVO.getAccmSeq() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchListVolumeAccumulatedYardRSQL(), param, velParam);

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
		return dbRowset;
	}

	
	/**
	 * Volume. Accumulate Yard Insert<br>
	 *
	 * @param TesAgreementManageCommonVO tesAgreementManageCommonVO
	 * @param List<TesTmlSoAccmYdVO> insertList
	 * @see UI_ESD_TES_9200
	 * @exception DAOException
	 */
	public void multiVolumeAccumulatedYardInsert(TesAgreementManageCommonVO tesAgreementManageCommonVO, List<TesTmlSoAccmYdVO> insertList) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			

			if( insertList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOMultiVolumeAccumulatedYardCSQL(), insertList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	
	
	/**
	 * Volume. Accumulate Yard Update<br>
	 *
	 * @param TesAgreementManageCommonVO tesAgreementManageCommonVO
	 * @param List<TesTmlSoAccmYdVO> updateList
	 * @see UI_ESD_TES_920Event
	 * @exception DAOException
	 */
	public void multiVolumeAccumulatedYardUpdate(TesAgreementManageCommonVO tesAgreementManageCommonVO, List<TesTmlSoAccmYdVO> updateList) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			

			if( updateList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOMultiVolumeAccumulatedYardUSQL(), updateList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	
	
	/**
	 * Volume. Accumulate Yard Delete<br>
	 *
	 * @param List<TesTmlSoAccmYdVO> deleteList
	 * @see UI_ESD_TES_9200
	 * @exception DAOException
	 */
	public void multiVolumeAccumulatedYardDelete(List<TesTmlSoAccmYdVO> deleteList) throws DAOException {

		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
		
			int	[]	insCnt		= null;
			

			if( deleteList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new TerminalAgreementManageDBDAOMultiVolumeAccumulatedYardDSQL(), deleteList, param, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if( insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}	

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	


//  ----- 김진주 Detail inquiry --------------------------------------------------------------------------
	/**
	 * Terminal Agreement Detail Inqueiry	-	Header부분 조회<br>
	 *
	 * @param event EsdTes0040Event
	 * @see UI_ESD_TES_040Event
	 * @return DBRowSet
	 * @exception DAOException
	 * @author kimjinjoo - 2006.11.09 최초 작성
	 */
	public DBRowSet searchTerminalAgreementManage(EsdTes0040Event event) throws DAOException {
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
		
			Map<String, String> mapVO	= event.getTesTmlAgmtHdrVO().getColumnValues();
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param	.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
				velParam.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
			}
			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchTerminalAgreementManageRSQL(), param, velParam);
			
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

		return dbRowset;
	}


	/**
	 * Agreement Terminal Rate Detail List 조회.<br>
	 * 미사용 Method 확인 (2016-01-19)
	 * @param event EsdTes0040Event
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchTerminalAgreementTerminalRateDetail(EsdTes0040Event event) throws DAOException {
		if(log.isDebugEnabled()) log.debug("\\n\n============ TerminalAgreementManageDBDao :::: searchTerminalAgreementInquiryDetail ===========\n");

		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
		
			Map<String, String> mapVO	= event.getTesTmlAgmtHdrVO().getColumnValues();
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
				velParam.put( "tml_agmt_ver_no", mapVO.get("tml_agmt_ver_no").replaceAll("\\.", "") );
			}
			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchTerminalAgreementTerminalRateDetailRSQL(), param, velParam);
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

		return dbRowset;
	}




//  ----- 김진주 Detail inquiry  끝--------------------------------------------------------------------------

	
	/**
	 * 요청된 Port에서 Re-handling될 화물의 Cost를 산출한다.<br>
	 * 
	 * @param bkgCodCostListVO BkgCodCostListVO 
	 * @return list List<BkgCodCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCodCostVO> searchRehandlingCost(BkgCodCostListVO bkgCodCostListVO) throws DAOException {

		List<BkgCodCostVO>	list			= null;
		DBRowSet			dbRowset		= null;
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO	= bkgCodCostListVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TerminalAgreementManageDBDAOSearchRehandlingCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs( dbRowset, BkgCodCostVO .class);
			
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