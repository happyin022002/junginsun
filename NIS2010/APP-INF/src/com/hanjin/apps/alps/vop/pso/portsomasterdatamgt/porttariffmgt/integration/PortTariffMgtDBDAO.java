/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : porttariffmgtDAO.java
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.31
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.04.28 김진일
* 1.0 Creation
* 
* History
* 2010.10.26 진마리아 CHM-201006714-01 추정결산 로직 보완
* 2010.11.24 CHM-201006949-01 박희동 특정 Tariff가 존재하는 Yard List를 조회한다.
* 2011.07.28 김기종 CHM-201112475-01 [VOP_PSO] Port Tariff Inquiry 메뉴 수정 요청건
* 2011.10.31 진마리아 선처리(SRM-201121014) [VOP-PSO] Tariff Value Management 화면 로직 변경
* 2014.03.12 박다은 CHM-201429104 [PSO] Tariff Attribute 내 불필요 Tariff 삭제 기능 요청
* 2014.03.19 최문환 CHM-201428969 [PSO] Port tariff Inquiry - 조회조건 및 화면 변경
* 2014.07.16 이성훈 CHM-201430928 [PSO] Port Tariff Contract 및 URL 저장
* 2015.02.10 CHM-201533892 Tariff내 Formula 및 Condition 생성 로직변경  
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration.GeneralInvoiceAuditDBDAOaddPsoChargeDetailCSQL;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration.GeneralInvoiceAuditDBDAOgetArvTugPwrRSQL;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoObjListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.basic.PortTariffMgtBCImpl;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.AccountAndCostVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.ConditionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CondtionOpertionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CostCodeVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.CurrencyVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.EffectiveDateListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.FormulaVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffCodeGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.SearchTariffConditionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffBaseVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffCodeVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffListGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffListWithYdNmVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffAtchFileVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConForVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaDtlVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.VendorVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVersionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgObjVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgNoDataInfoVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.SearchChgXprNoVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAOAddScgNonDgCgoKwCSQL;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgNonDgCgoKwVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.syscommon.common.table.PsoChgXprDtlVO;
import com.hanjin.syscommon.common.table.PsoChgXprVO;
import com.hanjin.syscommon.common.table.PsoCondDtlVO;
import com.hanjin.syscommon.common.table.PsoConditionVO;
import com.hanjin.syscommon.common.table.PsoFomlDtlVO;
import com.hanjin.syscommon.common.table.PsoFormulaVO;
import com.hanjin.syscommon.common.table.PsoTariffVO;
import com.hanjin.syscommon.common.table.PsoTrfAtchFileVO;
import com.hanjin.syscommon.common.table.PsoTrfDtlVO;
import com.hanjin.syscommon.common.table.PsoYdChgObjListVO;
import com.hanjin.syscommon.common.table.PsoYdChgVO;
import com.hanjin.syscommon.common.table.PsoYdChgXprVO;

/**
 * ALPS porttariffmgtDAO <br>
 * - ALPS-portsomasterdatamgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jin Ihl
 * @see PortTariffMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class PortTariffMgtDBDAO extends DBDAOSupport {

	/**
	 * Service Providor Help 팝업화면의 서비스프로바이더의 Code 및 이름을 데이터베이스에서 쿼리한다.<br>
	 *
	 * @param VendorVO vendorVo
	 * @return List<VendorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VendorVO> searchOfficeVendor(VendorVO vendorVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VendorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vendorVo != null){
				Map<String, String> mapVO = vendorVo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchOfficeVendorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	/**
	 *  condition 의 and,or 연산자를 조회한다.
	 * @return List<CondtionOpertionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CondtionOpertionVO> searchConditonAndOrOperator() throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<CondtionOpertionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchConditonAndOrOperatorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CondtionOpertionVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	


	/**
	 *  condition 의 비교 연산자를 조회한다.
	 * @return List<CondtionOpertionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CondtionOpertionVO> searchConditionCompairingOperator() throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<CondtionOpertionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchConditionCompairingOperatorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CondtionOpertionVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 *  Object List를 조회한다.
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoObjListVO> searchObjectListA() throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<PsoObjListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchObjectListARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoObjListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 *  Object List를 조회한다.
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoObjListVO> searchObjectListAll() throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<PsoObjListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchObjectListAllRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoObjListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 *  로그인 유저가 소속한 Office가 설정한 Object List를 조회한다.
	 * @param String psoOfcCd
	 * @param String types
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoObjListVO> searchOfficeObjectList1(String psoOfcCd,String types) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<PsoObjListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(psoOfcCd != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("ofc_cd", psoOfcCd);
				types = types == null ? "" : types;
				hMap.put("types", types);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchOfficeObjectListARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoObjListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	

	/**
	 *  로그인 유저가 소속한 Office가 설정한 Object List를 조회한다.
	 * @param String psoOfcCd
	 * @param String psoObjCd
	 * @param String types
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoObjListVO> searchOfficeObjectList2(String psoOfcCd, String psoObjCd, String types) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<PsoObjListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(psoOfcCd != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("ofc_cd", psoOfcCd);
				hMap.put("pso_obj_cd", psoObjCd);
				hMap.put("types", types);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchOfficeObjectList2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoObjListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	
	/**
	 *  로그인 유저가 소속한 Office가 설정한 Object List를 조회한다.
	 * @param PsoObjListVO psoObjListVO
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 */
	/*[2009.11.20:jmh] Overloaded Method중 사용하지 않는 것 주석처리
	@SuppressWarnings("unchecked")
	public List<PsoObjListVO> searchOfficeObjectList(PsoObjListVO psoObjListVO) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<PsoObjListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(psoObjListVO != null){
				Map<String, String> mapVO = psoObjListVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchObjectListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoObjListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	*/

	/**
	 * 로그인 유저가 소속한 Office가 설정한 Object List를 조회한다.
	 * @param String ofcCd
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoObjListVO> searchOfficeObjectList(String ofcCd)  throws DAOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<PsoObjListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(ofcCd != null){
				param.put("pso_ofc_cd", ofcCd);
				velParam.put("pso_ofc_cd", ofcCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchOfficeObjectListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoObjListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
	

	
	/**
	 * 로그인 유저가 소속한 Office가 설정한 cost code정보를 조회한다.
	 * @param String ofcCd
	 * @return List<CostCodeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CostCodeVO>  searchCostCodeList( String ofcCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<CostCodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(ofcCd != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("ofc_cd", ofcCd);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchCostCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CostCodeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	


	
	/**
	 * condition 정보를 조회한다.
	 * @param UseStatusConForVO useStatusConForVO
	 * @return List<UseStatusConditonFormulaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UseStatusConditonFormulaVO>  searchUseStatusConditon( UseStatusConForVO useStatusConForVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<UseStatusConditonFormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(useStatusConForVO != null){
				Map<String, String> mapVO = useStatusConForVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchUseStatusConditonRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UseStatusConditonFormulaVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	

	/**
	 * formula 정보를 조회한다.
	 * @param UseStatusConForVO useStatusConForVO 
	 * @return List<UseStatusConditonFormulaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UseStatusConditonFormulaVO>  searchUseStatusFormulaDetaill( UseStatusConForVO useStatusConForVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<UseStatusConditonFormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(useStatusConForVO != null){
				Map<String, String> mapVO = useStatusConForVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchUseStatusFormulaDetaillRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UseStatusConditonFormulaVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	/**
	 * formula 정보를 조회한다.
	 * @param UseStatusConForVO useStatusConForVO 
	 * @return List<UseStatusConditonFormulaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UseStatusConditonFormulaVO>  searchUseStatusFormula( UseStatusConForVO useStatusConForVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<UseStatusConditonFormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(useStatusConForVO != null){
				Map<String, String> mapVO = useStatusConForVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchUseStatusFormulaDetaillRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UseStatusConditonFormulaVO.class);
			//log.debug("DAO>> " + list.get(0).getFomlSysDesc());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	

	
	
	/**
	 * condition table의 cond_no를 가져온다.
	 * @return List<PsoConditionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoConditionVO>  searchConditionNumber() throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoConditionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchConditionNumberRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoConditionVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	

	
	/**
	 * formula table의 foml_no를 가져온다.
	 * @return List<PsoFormulaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoFormulaVO>  searchFormularNumber() throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoFormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchFormularNumberRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoFormulaVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	
	/**
	 * formula table의 foml_no를 가져온다.
	 * @param  String fomlNo 
	 * @return List<PsoFormulaVO> 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoFormulaVO>  searchFormularDesc(String fomlNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoFormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fomlNo != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("foml_no", fomlNo);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchFormularDescRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoFormulaVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	

	/**
	 * pso_chg_xpr table의 키값을 가져온다.
	 * @return List<PsoChgXprVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoChgXprVO>  searchChgXprNumber() throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoChgXprVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchChgXprNumberRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoChgXprVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * pso_tariff table의 키값을 가져온다.
	 * @return List<PsoTariffVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoTariffVO>  searchTariffNumber() throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoTariffVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchTariffNumberRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoTariffVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	
	/**
	 * pso_yd_chg table의 키값을 가져온다.
	 * @return List<PsoYdChgVO> 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoYdChgVO>  searchYardChgNumber() throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoYdChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchYardChgNumberRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoYdChgVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * pso_yd_chg table의 키값을 가져온다.
	 * @param  String ydChgNo 
	 * @param  String ydChgNoSeq 
	 * @return List<SearchChgXprNoVO> 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchChgXprNoVO>  searchChgXprNo(String ydChgNo, String ydChgNoSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchChgXprNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{

			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgNoSeq);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchChgXprNoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchChgXprNoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * pso_yd_chg table의 키값을 가져온다.
	 * @param  String chgxprno 
	 * @return List<PsoTariffVO> 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoTariffVO>  searchPsoTariff(String chgXprNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoTariffVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{

			param.put("chg_xpr_no", chgXprNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoTariffRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoTariffVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	
	/**
	 * pso_yd_chg table의 키값을 가져온다.
	 * @param  List<YdChgNoDataInfoVO> insertVoList
	 * @throws DAOException
	 */	
	
	@SuppressWarnings("unchecked")
	public void copyPsoChgNo(List<YdChgNoDataInfoVO> insertVoList ) throws DAOException,Exception {
	
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			//if(insertVoList.size() > 0){		
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOCopyPsoChgNoCSQL(), insertVoList, null);
		
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
	  				 throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				
				//}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		//return result;
	}
	
	/**
	 * pso_yd_chg table의 키값을 가져온다.
	 * @param  List<YdChgNoDataInfoVO> insertVoList
	 * @throws DAOException
	 */	
	
	@SuppressWarnings("unchecked")
	public void copyPsoYdChgObjList(List<YdChgNoDataInfoVO> insertVoList ) throws DAOException,Exception {
	
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			//if(insertVoList.size() > 0){		
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOCopyPsoYdChgObjListCSQL(), insertVoList, null);
		
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
	  				 throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				
				//}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		//return result;
	}
	
	/**
	 * pso_yd_chg_xpr table에 copy한다
	 * @param List<YdChgNoDataInfoVO> insertVoList
	 * @throws DAOException
	 */	
	
	@SuppressWarnings("unchecked")
	public void copyPsoYdChgXpr(List<YdChgNoDataInfoVO> insertVoList ) throws DAOException,Exception {
	
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOCopyPsoYdChgXprCSQL(), insertVoList, null);
		
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
	  				 throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		//return result;
	}
	
	/**
	 * pso_yd_chg_xpr table에 copy한다
	 * @param  String ChgXprNo
	 * @param  String NewChgXprNo
	 * @param  String UsrId
	 * @throws DAOException
	 */	
	
	@SuppressWarnings("unchecked")
	public void copyPsoChgXpr(String ChgXprNo , String NewChgXprNo, String UsrId ) throws DAOException,Exception {
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
					
			param.put("chg_xpr_no", ChgXprNo);
			param.put("new_chg_xpr_no", NewChgXprNo);
			param.put("cre_usr_id", UsrId);

			
				updCnt = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOCopyPsoChgXprCSQL(), param, null);
			
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL ");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * pso_yd_chg_xpr table에 copy한다
	 * @param  String ChgXprNo
	 * @param  String NewChgXprNo
	 * @throws DAOException
	 */	
	
	@SuppressWarnings("unchecked")
	public void copyPsoTriff(String ChgXprNo , String NewChgXprNo ) throws DAOException,Exception {
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
		
			param.put("chg_xpr_no", ChgXprNo);
			param.put("new_chg_xpr_no", NewChgXprNo);

				updCnt = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOCopyPsoChgXprCSQL(), param, null);
			
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL ");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * pso_yd_chg_xpr_dtl table에 copy한다
	 * @param  String ChgXprNo
	 * @param  String NewChgXprNo
	 * @param  String UsrId
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public void copyPsoChgXprDtl(String ChgXprNo , String NewChgXprNo,  String UsrId  ) throws DAOException,Exception {
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			
			
			param.put("chg_xpr_no", ChgXprNo);
			param.put("new_chg_xpr_no", NewChgXprNo);
		    param.put("cre_usr_id", UsrId);
			
				updCnt = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOCopyPsoChgXprDtlCSQL(), param, null);
			
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL ");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * pso_tariff table에 copy한다
	 * @param  String Psotrfno
	 * @param  String Newtrfno
     * @param  String NewChgXprNo
     * @param  String UsrId
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public void copyPsoTariff(String Psotrfno, String Newtrfno , String NewChgXprNo,  String UsrId  ) throws DAOException,Exception {
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			
			
			param.put("pso_trf_no"    , Psotrfno);
			param.put("new_pso_trf_no", Newtrfno);
			param.put("new_chg_xpr_no", NewChgXprNo);
		    param.put("cre_usr_id",     UsrId);
			
			
				updCnt = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOCopyPsoTariffCSQL(), param, null);
			
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL ");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * pso_tariff table에 copy한다
	 * @param  String psoTrfNo
	 * @param  String newTrfNo
	 * @param  String UsrId
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public void copyPsoTrfDtl(String psoTrfNo, String newTrfNo ,  String UsrId ) throws DAOException,Exception {
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			
			
			param.put("pso_trf_no"    , psoTrfNo);
			param.put("new_pso_trf_no", newTrfNo);
			 param.put("cre_usr_id",    UsrId);
			
				updCnt = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOCopyPsoTrfDtlCSQL(), param, null);
			
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL ");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
 
	/**
	 * pso_tariff table에 copy한다
	 * @param  String NewYdChgNo
	 * @param  String NewChgXprNo
	 * @param  String YdChgNo
	 * @param  String YdChgVerSeq
	 * @param  String ChgXprNo
	 * @param  String UsrId
	 * @throws DAOException
	 */	
	public void copyPsoYdChgXpr(String NewYdChgNo, String NewChgXprNo, String YdChgNo, String YdChgVerSeq, String ChgXprNo, String UsrId ) throws DAOException,Exception {
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			
			
			param.put("new_yd_chg_no"    , NewYdChgNo);
			param.put("new_chg_xpr_no"   , NewChgXprNo);
			param.put("yd_chg_no"        , YdChgNo);
			param.put("yd_chg_ver_seq"   , YdChgVerSeq);
			param.put("chg_xpr_no"       , ChgXprNo);
			param.put("cre_usr_id"       , UsrId);
			
				updCnt = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOCopyPsoYdChgXprCSQL(), param, null);
			
				if(updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL ");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * pso_yd_chg_xpr table의 키값을 가져온다.
	 * @return List<PsoYdChgXprVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoYdChgXprVO>  searchYardChgXprNumber() throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoYdChgXprVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchYardChgXprNumberRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoYdChgXprVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
		

	
	/**
	 * currency 정보를 조회한다.
	 * @param  String ofcCd
	 * @return List<CurrencyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CurrencyVO> searchCurrencyList(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CurrencyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchCurrencyListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CurrencyVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	

	
	/**
	 * BaseTariff 정보를 조회한다.
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @return List<TariffBaseVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TariffBaseVO> searchBaseTariff(PortTariffCodeGRPVO portTariffCodeGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffBaseVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(portTariffCodeGRPVO != null){
				if(portTariffCodeGRPVO.getPortCd() == null)
					portTariffCodeGRPVO.setPortCd("");

				Map<String, String> mapVO = portTariffCodeGRPVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if( portTariffCodeGRPVO.getType() == null) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchBaseTariffRSQL(), param, velParam);
				} else {
					if( portTariffCodeGRPVO.getType().equals("2")) {
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchBaseTariff2RSQL(), param, velParam);
					} else if( portTariffCodeGRPVO.getType().equals("A")) {
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchBaseTariffARSQL(), param, velParam);
					} else {
						dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchBaseTariffRSQL(), param, velParam);
					}
				}
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, TariffBaseVO.class);
			}
					
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	

	/**
	 * BaseTariff condition정보를 조회한다.
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @return List<ConditionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ConditionVO> searchBaseCondition(PortTariffCodeGRPVO portTariffCodeGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ConditionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(portTariffCodeGRPVO != null){
				if(portTariffCodeGRPVO.getPortCd() == null)
					portTariffCodeGRPVO.setPortCd("");
				Map<String, String> mapVO = portTariffCodeGRPVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchBaseConditionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ConditionVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
		

	
	
	/**
	 * BaseTariff condition의 sysdesc정보를 조회한다.
	 * @param String condNo
	 * @return List<PsoConditionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoConditionVO> searchConditionDesc( String condNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoConditionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(condNo != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("cond_no", condNo);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchConditionDescRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoConditionVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	
	
	/**
	 * TariffList의 version 정보를 조회한다.
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @param String uid
	 * @return List<TariffListGRPVO> 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TariffListGRPVO> searchEffectiveDateList(PortTariffCodeGRPVO portTariffCodeGRPVO, String uid) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffListGRPVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(portTariffCodeGRPVO != null){
				Map<String, String> mapVO = portTariffCodeGRPVO.getColumnValues();
				
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("uid", uid);
				velParam.put("uid", uid);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchEffectiveDateListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TariffListGRPVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

	
	/**
	 * TariffList copy 의 version 정보를 조회한다.
	 * @param String combo1
	 * @param String vndrSeq
	 * @param String acctCd
	 * @param String ofcCd
	 * @return List<TariffListGRPVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TariffListGRPVO> searchEffectiveDateList2( String combo1, String vndrSeq , String acctCd, String ofcCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffListGRPVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(combo1 != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put( "combo1"  , combo1 );
				hMap.put( "vndr_seq", vndrSeq );
				hMap.put( "acct_cd", acctCd );
				hMap.put( "ofc_cd", ofcCd );
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchEffectiveDateList2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TariffListGRPVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
	
	
	/**
	 * TariffList의 version 날짜의 유효여부를 조회한다.
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @return List<TariffListGRPVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TariffListGRPVO> checkEfffectiveDate(PortTariffCodeGRPVO portTariffCodeGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffListGRPVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(portTariffCodeGRPVO != null){
				Map<String, String> mapVO = portTariffCodeGRPVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOcheckEfffectiveDateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TariffListGRPVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	
	/**
	 * TariffList의 의 invoice 사용여부를 조회한다.
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @return List<TariffListGRPVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TariffListGRPVO> checkPortChargeUsing(PortTariffCodeGRPVO portTariffCodeGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffListGRPVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(portTariffCodeGRPVO != null){
				Map<String, String> mapVO = portTariffCodeGRPVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOcheckPortChargeUsingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TariffListGRPVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	

	
	/**
	 * 저장된 fomula의 번호를 조회한다.
	 * @param String fomlDesc
	 * @return List<PsoFormulaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoFormulaVO>  searchFomularNo( String fomlDesc ) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoFormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fomlDesc != null){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("foml_desc", fomlDesc);
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchFomularNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoFormulaVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	
	
	/**
	 * 저장된 fomula의 번호를 조회한다.
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO 
	 * @return List<TariffCodeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TariffCodeVO>  searchTariffCode( PortTariffCodeGRPVO portTariffCodeGRPVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffCodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(portTariffCodeGRPVO != null){
				Map<String, String> mapVO = portTariffCodeGRPVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchTariffCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TariffCodeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	
	
	/**
	 * 저장된 condition의 번호를 조회한다.
	 * @param String condDesc
	 * @return List<PsoConditionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoConditionVO>  searchConditionNo( String condDesc ) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoConditionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if( condDesc != null ){
				HashMap hMap = new HashMap<String, String>();
				hMap.put("cond_desc", condDesc );
				Map<String, String> mapVO = hMap;
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchConditionNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoConditionVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	
	
	/**
	 * 1~3번째 로우로 설정된 Office의 Favorite정보를 삭제한다.
	 * @param String psoOfcCd
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void removeOfficeObjectList(String psoOfcCd)  throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt = 0;
			Map<String, Object> velParam = new HashMap<String, Object>();
			ArrayList lst = new ArrayList();
			lst.add(velParam);
			if(!psoOfcCd.equals("")){
				velParam.put("pso_ofc_cd", (Object)psoOfcCd);
				//delCnt = sqlExe.eexecuteBatch((ISQLTemplate)new PortTariffMgtBCDBDAOremoveOfficeObjectListDSQL(), lst,null);
				delCnt = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOremoveOfficeObjectListDSQL(), velParam, velParam);
				//for(int i = 0; i < delCnt.length; i++){
					if(delCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete SQL ");
				//}
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
	 * 1~3번째 로우로 설정된 Office의 Favorite정보를 입력한다.
	 * @param List<PsoObjListVO> psoObjListVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addOfficeObjectList(List<PsoObjListVO> psoObjListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(psoObjListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddOfficeObjectListCSQL(), psoObjListVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_CHG_XPR 데이터를 저장한다.<br>
	 * 
	 * @param List<PsoChgXprVO> psoChgXprVOs
	 * @throws DAOException
	 */
	public void addChargeExpressions(List<PsoChgXprVO> psoChgXprVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(psoChgXprVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddChargeExpressionCSQL(), psoChgXprVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_CHG_XPR 데이터를 수정한다.<br>
	 * 
	 * @param List<PsoChgXprVO> psoChgXprVOs
	 * @throws DAOException
	 */
	public void modifyChargeExpression(List<PsoChgXprVO> psoChgXprVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(psoChgXprVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOmodifyChargeExpressionUSQL(), psoChgXprVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 *  PSO_CHG_XPR 데이터를 삭제한다.<br>
	 * 
	 * @param List<PsoChgXprVO> psoChgXprVOs
	 * @throws DAOException
	 */
	public void removeChargeExpression(List<PsoChgXprVO> psoChgXprVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(psoChgXprVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOremoveChargeExpressionDSQL(), psoChgXprVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_CHG_XPR_DTL 데이터를 저장한다.<br>
	 * 
	 * @param List<PsoChgXprDtlVO> psoChgXprDtlVOs
	 * @throws DAOException
	 */
	public void addChargeExpressionDetail(List<PsoChgXprDtlVO> psoChgXprDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(psoChgXprDtlVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddChargeExpressionDetailCSQL(), psoChgXprDtlVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_CHG_XPR_DTL 데이터를 수정한다.<br>
	 * 
	 * @param List<PsoChgXprDtlVO> psoChgXprDtlVOs
	 * @throws DAOException
	 */
	public void modifyChargeExpressionDetail(List<PsoChgXprDtlVO> psoChgXprDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(psoChgXprDtlVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOmodifyChargeExpressionDetailUSQL(), psoChgXprDtlVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_CHG_XPR_DTL 데이터를 삭제한다.<br>
	 * 
	 * @param List<PsoChgXprDtlVO> psoChgXprDtlVOs
	 * @throws DAOException
	 */
	public void removeChargeExpressionDetail(List<PsoChgXprDtlVO> psoChgXprDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(psoChgXprDtlVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOremoveChargeExpressionDetailDSQL(), psoChgXprDtlVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_YD_CHG 데이터를 저장한다.<br>
	 * 
	 * @param List<PsoYdChgVO> psoYdChgVOs
	 * @throws DAOException
	 */
	public void addYardCharge(List<PsoYdChgVO> psoYdChgVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(psoYdChgVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddYardChargeCSQL(), psoYdChgVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_YD_CHG 데이터를 수정한다.<br>
	 * 
	 * @param List<PsoYdChgVO> psoYdChgVOs
	 * @throws DAOException
	 */
	public void modifyYardCharge(List<PsoYdChgVO> psoYdChgVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(psoYdChgVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOmodifyYardChargeUSQL(), psoYdChgVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_YD_CHG 데이터를 삭제한다.<br>
	 * 
	 * @param List<PsoYdChgVO> psoYdChgVOs
	 * @throws DAOException
	 */
	public void removeYardCharge(List<PsoYdChgVO> psoYdChgVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(psoYdChgVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOremoveYardChargeDSQL(), psoYdChgVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_YD_CHG_XPR 데이터를 저장한다.<br>
	 * 
	 * @param List<PsoYdChgXprVO> psoYdChgXprVOs
	 * @throws DAOException
	 */
	public void addYardChargeExpression(List<PsoYdChgXprVO> psoYdChgXprVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(psoYdChgXprVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddYardChargeExpressionCSQL(), psoYdChgXprVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_YD_CHG_XPR 데이터를 수정한다.<br>
	 * 
	 * @param List<PsoYdChgXprVO> psoYdChgXprVOs
	 * @throws DAOException
	 */
	public void modifyYardChargeExpression(List<PsoYdChgXprVO> psoYdChgXprVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(psoYdChgXprVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOmodifyYardChargeExpressionUSQL(), psoYdChgXprVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_YD_CHG_XPR 데이터를 삭제한다.<br>
	 * 
	 * @param List<PsoYdChgXprVO> psoYdChgXprVOs
	 * @throws DAOException
	 */
	public void removeYardChargeExpression(List<PsoYdChgXprVO> psoYdChgXprVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(psoYdChgXprVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOremoveYardChargeExpressionDSQL(), psoYdChgXprVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_TARIFF 데이터를 저장한다.<br>
	 * 
	 * @param List<PsoTariffVO> psoTariffVOs
	 * @throws DAOException
	 */
	public void addTariff(List<PsoTariffVO> psoTariffVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(psoTariffVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddTariffCSQL(), psoTariffVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_TARIFF 데이터를 수정한다.<br>
	 * 
	 * @param List<PsoTariffVO> psoTariffVOs
	 * @throws DAOException
	 */
	public void modifyTariff(List<PsoTariffVO> psoTariffVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(psoTariffVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOmodifyTariffUSQL(), psoTariffVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_TARIFF 데이터를 삭제한다.<br>
	 * 
	 * @param List<PsoTariffVO> psoTariffVOs
	 * @throws DAOException
	 */
	public void removeTariff(List<PsoTariffVO> psoTariffVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(psoTariffVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOremoveTariffDSQL(), psoTariffVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_TRF_DTL 데이터를 저장한다.<br>
	 * 
	 * @param List<PsoTrfDtlVO> psoTrfDtlVOs
	 * @throws DAOException
	 */
	public void addTariffDetail(List<PsoTrfDtlVO> psoTrfDtlVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(psoTrfDtlVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddTariffDetailCSQL(), psoTrfDtlVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
//			System.out.println(">>DAO 1 ********* insCnt.length : " + insCnt.length);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
//			System.out.println(">>DAO 2 ********* insCnt.length : " + insCnt.length);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * PSO_TRF_DTL 데이터를 수정한다.<br>
	 * 
	 * @param List<PsoTrfDtlVO> psoTrfDtlVOs
	 * @throws DAOException
	 */
	public void modifyTariffDetail(List<PsoTrfDtlVO> psoTrfDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(psoTrfDtlVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOmodifyTariffDetailUSQL(), psoTrfDtlVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_TRF_DTL 데이터를 삭제한다.<br>
	 * 
	 * @param List<PsoTrfDtlVO> psoTrfDtlVOs
	 * @throws DAOException
	 */
	public void removeTariffDetail(List<PsoTrfDtlVO> psoTrfDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(psoTrfDtlVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOremoveTariffDetailDSQL(), psoTrfDtlVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_YD_CHG_OBJ_LIST 데이터를 저장한다.<br>
	 * 
	 * @param List<PsoYdChgObjListVO> psoYdChgObjListVOs
	 * @throws DAOException
	 */
	public void addYardChargeObjectList(List<PsoYdChgObjListVO> psoYdChgObjListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(psoYdChgObjListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddYardChargeObjectListCSQL(), psoYdChgObjListVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_YD_CHG_OBJ_LIST 데이터를 수정한다.<br>
	 * 
	 * @param List<PsoYdChgObjListVO> psoYdChgObjListVOs
	 * @throws DAOException
	 */
	public void modiyYardChargeObjectList(List<PsoYdChgObjListVO> psoYdChgObjListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(psoYdChgObjListVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOmodiyYardChargeObjectListUSQL(), psoYdChgObjListVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_YD_CHG_OBJ_LIST 데이터를 삭제한다.<br>
	 * 
	 * @param List<PsoYdChgObjListVO> psoYdChgObjListVOs
	 * @throws DAOException
	 */
	public void removeYardChargeObjectList(List<PsoYdChgObjListVO> psoYdChgObjListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(psoYdChgObjListVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOremoveYardChargeObjectListDSQL(), psoYdChgObjListVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 2015.04 PSO_YD_CHG_OBJ_LIST 데이터를 저장한다.<br>
	 * 
	 * @param  String vYdChgNo
	 * @param  String oldYdChgVerSeq
	 * @param  String newYdChgVerSeq
	 * @param  String vCreUsrId
	 * @throws DAOException
	 */
	public void addPsoYdChgObjList(String vYdChgNo, String oldYdChgVerSeq , String newYdChgVerSeq, String vCreUsrId ) throws DAOException,Exception {
		//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
			
				int result = 0; 
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			log.debug("vYdChgNoaa+"+vYdChgNo);
			if( vYdChgNo != null ){
				param.put("yd_chg_no", vYdChgNo);
				param.put("old_chg_seq", oldYdChgVerSeq);
				param.put("new_chg_seq", newYdChgVerSeq);
				param.put("cre_usr_id", vCreUsrId);
				velParam.put("yd_chg_no", vYdChgNo);
				velParam.put("old_chg_seq", oldYdChgVerSeq);
				velParam.put("new_chg_seq", newYdChgVerSeq);
				velParam.put("cre_usr_id", vCreUsrId);
				 
				
				log.debug("param1+"+vYdChgNo);
				log.debug("param2+"+oldYdChgVerSeq);
				log.debug("param3+"+newYdChgVerSeq);	
				log.debug("param4+"+vCreUsrId);
				
				result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOaddPsoYdChgObjListCSQL(), param, velParam);
				
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
	 * 2015.04 PSO_YD_CHG_OBJ_LIST 데이터를 수정한다.<br>
	 * 
	 * @param  String vYdChgNo
	 * @param  String vYdChgVerSeq
	 * @param  String vCreUsrId
	 * @throws DAOException
	 */
	public void modifyPsoYdChgObjList(String vYdChgNo, String vYdChgVerSeq, String vCreUsrId ) throws DAOException,Exception {
		//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
			
				int result = 0; 
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			log.debug("vYdChgNoaa+"+vYdChgNo);
			log.debug("vYdChgVerSeqbb+"+vYdChgVerSeq);
			if( vYdChgNo != null ){
				param.put("yd_chg_no", vYdChgNo);
				param.put("yd_chg_seq", vYdChgVerSeq);
				param.put("cre_usr_id", vCreUsrId);
				velParam.put("yd_chg_no", vYdChgNo);
				velParam.put("yd_chg_seq", vYdChgVerSeq);
				velParam.put("cre_usr_id", vCreUsrId);
				 
				
				log.debug("param1+"+vYdChgNo);

				log.debug("param4+"+vCreUsrId);
				
				result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOmodifyPsoYdChgObjListCSQL(), param, velParam);
				
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
	 * 2015.04 PSO_YD_CHG_OBJ_LIST 데이터를 삭제한다.<br>
	 * 
	 * @param  String vYdChgNo
	 * @param  String vYdChgVerSeq
	 * @throws DAOException
	 */
	public void deletePsoYdChgObjList(String vYdChgNo, String vYdChgVerSeq ) throws DAOException,Exception {
		//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
			
				int result = 0; 
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			log.debug("vYdChgNoaa+"+vYdChgNo);
			if( vYdChgNo != null ){
				param.put("yd_chg_no", vYdChgNo);
				param.put("yd_chg_seq", vYdChgVerSeq);
				velParam.put("yd_chg_no", vYdChgNo);
				velParam.put("yd_chg_seq", vYdChgVerSeq);
						
				result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOdeletePsoYdChgObjListDSQL(), param, velParam);
				
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
	 * PSO_CONDITION 데이터를 저장한다.<br>
	 * 
	 * @param List<PsoConditionVO> psoConditionVOs
	 * @throws DAOException
	 */
	/*[2009.11.20:jmh] Overloaded Method중 사용하지 않는 것 주석처리 
	public void addPsoCondition(List<PsoConditionVO> psoConditionVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(psoConditionVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddPsoConditionCSQL(), psoConditionVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	*/
	

	/**
	 * PSO_CONDITION 데이터를 수정한다.<br>
	 * 
	 * @param List<PsoConditionVO> psoConditionVOs
	 * @throws DAOException
	 */
	public void modifyPsoCondition(List<PsoConditionVO> psoConditionVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(psoConditionVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOmodifyPsoConditionUSQL(), psoConditionVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(">> SQLException DAO : " + se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	

	/**
	 * PSO_CONDITION 데이터를 삭제한다.<br>
	 * 
	 * @param List<PsoConditionVO> psoConditionVOs
	 * @throws DAOException
	 */
	/*[2009.11.20:jmh] Overloaded Method중 사용하지 않는 것 주석처리
	public void removeCondition(List<PsoConditionVO> psoConditionVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(psoConditionVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOremoveConditionDSQL(), psoConditionVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	*/
	

	/**
	 * PSO_COND_DTL 데이터를 저장한다.<br>
	 * 
	 * @param List<PsoCondDtlVO> psoCondDtlVOs
	 * @throws DAOException
	 */
	/*[2009.11.20:jmh] Overloaded Method중 사용하지 않는 것 주석처리
	public void addPsoConditionDetail(List<PsoCondDtlVO> psoCondDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(psoCondDtlVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddPsoConditionDetailCSQL(), psoCondDtlVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	*/
	

	/**
	 * PSO_COND_DTL 데이터를 수정한다.<br>
	 * 
	 * @param List<PsoCondDtlVO> psoCondDtlVOs
	 * @throws DAOException
	 */
	public void modifyPsoConditionDetail(List<PsoCondDtlVO> psoCondDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(psoCondDtlVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOmodifyPsoConditionDetailUSQL(), psoCondDtlVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_COND_DTL 데이터를 삭제한다.<br>
	 * 
	 * @param List<PsoCondDtlVO> psoCondDtlVOs
	 * @throws DAOException
	 */
	public void removeConditionDetail(List<PsoCondDtlVO> psoCondDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(psoCondDtlVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOremoveConditionDetailDSQL(), psoCondDtlVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_FORMULA 데이터를 저장한다.<br>
	 * 
	 * @param List<PsoFormulaVO> psoFormulaVOs
	 * @throws DAOException
	 */
	public void addPsoFormular(List<PsoFormulaVO> psoFormulaVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(psoFormulaVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddPsoFormularCSQL(), psoFormulaVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_FORMULA 데이터를 수정한다.<br>
	 * 
	 * @param List<PsoFormulaVO> psoFormulaVOs
	 * @throws DAOException
	 */
	/*[2009.11.20:jmh] Overloaded Method중 사용하지 않는 것 주석처리
	public void modifyPsoFormula(List<PsoFormulaVO> psoFormulaVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(psoFormulaVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOmodifyPsoFormulaUSQL(), psoFormulaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	*/
	

	/**
	 * PSO_FORMULA 데이터를 삭제한다.<br>
	 * 
	 * @param String formulaNo
	 * @throws DAOException
	 */
	public void removeFormula(String formulaNo) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt = 0;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(!formulaNo.equals("")){
				velParam.put("foml_no", (Object)formulaNo);
				delCnt = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOremoveFormulaDSQL(), velParam, velParam);
				if(delCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
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
	 * PSO_FOML_DTL 데이터를 저장한다.<br>
	 * 
	 * @param List<PsoFomlDtlVO> psoFomlDtlVOs
	 * @throws DAOException
	 */
	/*[2009.11.20:jmh] Overloaded Method중 사용하지 않는 것 주석처리
	public void addPsoFormulaDetail(List<PsoFomlDtlVO> psoFomlDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(psoFomlDtlVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddPsoFormulaDetailCSQL(), psoFomlDtlVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	*/
	

	/**
	 * PSO_FOML_DTL 데이터를 수정한다.<br>
	 * 
	 * @param List<PsoFomlDtlVO> psoFomlDtlVOs
	 * @throws DAOException
	 */
	public void modifyPsoFormularDetail(List<PsoFomlDtlVO> psoFomlDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(psoFomlDtlVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOmodifyPsoFormularDetailUSQL(), psoFomlDtlVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_FOML_DTL 데이터를 삭제한다.<br>
	 * 
	 * @param List<PsoFomlDtlVO> psoFomlDtlVOs
	 * @throws DAOException
	 */
	/*[2009.11.20:jmh] Overloaded Method중 사용하지 않는 것 주석처리
	public void removeFormulaDetail(List<PsoFomlDtlVO> psoFomlDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(psoFomlDtlVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOremoveFormulaDetailDSQL(), psoFomlDtlVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	*/

	/**
	 * 현재 Terminal에서 해당 Condtion를 사용하고 있는 Terminal List를 조회한다.
	 * @param UseStatusConditonFormulaVO useStatusConditonFormulaVO
	 * @return List<UseStatusConditonFormulaDtlVO>
	 * @throws DAOException
	 */
	/*[2009.12.10:jmh] 사용하지 않는 메소드 제거
	@SuppressWarnings("unchecked")
	public List<UseStatusConditonFormulaDtlVO>  searchUseIDConditonDetaill( UseStatusConditonFormulaVO useStatusConditonFormulaVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<UseStatusConditonFormulaDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(useStatusConditonFormulaVO != null){
				Map<String, String> mapVO = useStatusConditonFormulaVO.getColumnValues();
				
				mapVO.put("no", useStatusConditonFormulaVO.getId());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchUseIDConditonDetaillRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UseStatusConditonFormulaDtlVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	*/
	
	/**
	 * 현재 Terminal에서 해당 Formula를 사용하고 있는 Terminal List를 조회한다.
	 * @param UseStatusConditonFormulaVO useStatusConditonFormulaVO
	 * @return List<UseStatusConditonFormulaDtlVO>
	 * @throws DAOException
	 */
	/*[2009.12.10:jmh] 사용하지 않는 메소드 제거
	@SuppressWarnings("unchecked")
	public List<UseStatusConditonFormulaDtlVO>  searchUseIDFormulaDetaill( UseStatusConditonFormulaVO useStatusConditonFormulaVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<UseStatusConditonFormulaDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(useStatusConditonFormulaVO != null){
				Map<String, String> mapVO = useStatusConditonFormulaVO .getColumnValues();
				
				mapVO.put("no", useStatusConditonFormulaVO.getId());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchUseIDFormulaDetaillRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UseStatusConditonFormulaDtlVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	*/


	/**
	 * Object를 조회합니다. 
	 * @param PsoObjListVO psoObjListVO
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoObjListVO> searchObjectList(PsoObjListVO psoObjListVO) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<PsoObjListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(psoObjListVO != null){
				Map<String, String> mapVO = psoObjListVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchObjectListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoObjListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	

	/**
	 * 현재 Terminal에서 해당 Condtion를 사용하고 있는 Terminal List를 조회한다.
	 * @param UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO
	 * @return List<UseStatusConditonFormulaDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UseStatusConditonFormulaDtlVO>  searchUseIdConditonDetail( UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<UseStatusConditonFormulaDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(useStatusConditonFormulaDtlVO != null){
				Map<String, String> mapVO = useStatusConditonFormulaDtlVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchUseIDConditonDetaillRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UseStatusConditonFormulaDtlVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 현재 Terminal에서 해당 Formula를 사용하고 있는 Terminal List를 조회한다.
	 * @param UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO 
	 * @return List<UseStatusConditonFormulaDtlVO> 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UseStatusConditonFormulaDtlVO>  searchUseIdFormulaDetail( UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<UseStatusConditonFormulaDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(useStatusConditonFormulaDtlVO != null){
				Map<String, String> mapVO = useStatusConditonFormulaDtlVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchUseIDFormulaDetaillRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UseStatusConditonFormulaDtlVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Terminal 별로  Tariff List(Account/Vendor/Update ID/Update Date)를 조회함
	 * @category VOP_PSO_0036_RetrieveBtnClick 
	 * @param String ydCd
	 * @param String year
	 * @param String acctCd
	 * @return List<PortTariffListVO>
	 */
	@SuppressWarnings("unchecked")
	public List<PortTariffListVO> searchPortChargeList(String ydCd, String year, String acctCd)  throws DAOException {
		DBRowSet dbRowset = null;
		List<PortTariffListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(ydCd != null && !ydCd.equals("")){
				
				String[] arrYdCd = ydCd.substring(5).split(",");
				List<String> ydCdList  = new ArrayList();
				for(int i=0; i<arrYdCd.length; i++){
					ydCdList.add(arrYdCd[i]);
					log.debug("arrYdCd[i]++"+arrYdCd[i]);
				}
				
				param.put("port_cd", ydCd.substring(0, 5));
				param.put("yd_cd", ydCd.substring(5));
				param.put("arr_yd_cd", ydCdList);
				
				log.debug("port_cd"+ydCd.substring(0, 5));
				log.debug("ydCd.substring(5)+++"+ydCd.substring(5));
				log.debug("ydCdList+++"+ydCdList);
				
				velParam.put("port_cd", ydCd.substring(0, 5));
				velParam.put("yd_cd", ydCd.substring(5));
				velParam.put("arr_yd_cd", ydCdList);
			}
			
			if(acctCd != null && !acctCd.equals("")){
				String[] arrAcctCd = acctCd.split(",");
				List<String> acctCdList  = new ArrayList<String>();
				for(int i=0; i<arrAcctCd.length; i++){
					acctCdList.add(arrAcctCd[i]);
				}
				
				param.put("acct_cd", acctCd);
				param.put("arr_acct_cd", acctCdList);
				
				log.debug("acct_cd+++"+acctCd);
				log.debug("arr_acct_cd+++"+acctCdList);
				
				velParam.put("acct_cd", acctCd);
				velParam.put("arr_acct_cd", acctCdList);
			}
			
			param.put("year", year);
			velParam.put("year", year);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchPortChargeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortTariffListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Charge Creation(Invoice 생성)시에 필요한 Effective Date(지불일)를 조회한다.
	 * @category VOP_PSO_0036_VerClick
	 * @param PortTariffListVO portTariffListVO
	 * @return List<EffectiveDateListVO> 
	 */
	@SuppressWarnings("unchecked")
	public List<EffectiveDateListVO> searchDistinctEffectiveDateList(
			PortTariffListVO portTariffListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EffectiveDateListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(portTariffListVO != null){
				Map<String, String> mapVO = portTariffListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchDistinctEffectiveDateListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EffectiveDateListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	/**
	 * Charge Creation(Invoice 생성)시에 필요한 Effective Date(지불일)의 Version 을 조회한다.
	 * @category VOP_PSO_0036_EffDateClick
	 * @param PortTariffListVO portTariffListVO
	 * @return List<YardChargeVersionVO>
	 */
	@SuppressWarnings("unchecked")
	public List<YardChargeVersionVO> searchYardChargeVersion(
			PortTariffListVO portTariffListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardChargeVersionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(portTariffListVO != null){
				Map<String, String> mapVO = portTariffListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchYardChargeVersionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardChargeVersionVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * yard 정보와 년도정보에 맞는 Account & Cost를 조회한다.
	 * @category VOP_PSO_0036
	 * @param String ydCd
	 * @param String year
	 * @return List<AccountAndCostVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<AccountAndCostVO> searchAccountAndCostByCondition(String ydCd, String year) throws DAOException {
		DBRowSet dbRowset = null;
		List<AccountAndCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
//			String portCd ="";
//			String yardCd ="";
//			if(ydCd != null && !ydCd.equals("")){
//				portCd = ydCd.substring(0,5);
//				if(ydCd.length()>6){
//					yardCd = ydCd.substring(5, ydCd.length());
//					yardCd = yardCd.replaceAll("," ,"','");
//				}
//			}				
			
			if(ydCd != null && !ydCd.equals("")){
				
				String[] arrYdCd = ydCd.substring(5).split(",");
				List<String> ydCdList  = new ArrayList<String>();
				for(int i=0; i<arrYdCd.length; i++){
					ydCdList.add(arrYdCd[i]);
				}
				
				param.put("port_cd", ydCd.substring(0, 5));
				param.put("yd_cd", ydCd.substring(5));
				param.put("arr_yd_cd", ydCdList);
				
				velParam.put("port_cd", ydCd.substring(0, 5));
				velParam.put("yd_cd", ydCd.substring(5));
				velParam.put("arr_yd_cd", ydCdList);
			}
				
			param.put("year", year);
			velParam.put("year", year);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchAccountAndCostByConditionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountAndCostVO.class);
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
	  * Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Formula 정보 조회 
	  * @category VOP_PSO_0007_RetrieveBtnClickFormula
	  * @param String formulaNo
	  * @return List<FormulaVO> 
	 */
	@SuppressWarnings("unchecked")
	public List<FormulaVO> searchPsoFormula(String formulaNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<FormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(formulaNo != null){
				param.put("foml_no", formulaNo);
				velParam.put("foml_no", formulaNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchPsoFormulaRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FormulaVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	  * Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Formula 정보 조회 (Hidden Grid 용)
	  * @category VOP_PSO_0007_RetrieveBtnClickFormula
	  * @param String formulaNo
	  * @return List<FormulaVO>
	 */
	@SuppressWarnings("unchecked")
	public List<FormulaVO> searchPsoFormulaSys(String formulaNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<FormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(formulaNo != null){
				param.put("foml_no", formulaNo);
				velParam.put("foml_no", formulaNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchPsoFormulaSysRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FormulaVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	/**
	 * Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Condition 정보 조회
	 * @category VOP_PSO_0007_RetrieveBtnClickCondition
	 * @param String conditionNo
	 * @return List<FormulaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FormulaVO> searchPsoCondition(String conditionNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<FormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionNo != null){
				param.put("cond_no", conditionNo);
				velParam.put("cond_no", conditionNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchPsoConditionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FormulaVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Condition 정보 조회 (Hidden Grid 용) 
	 * @category VOP_PSO_0007_RetrieveBtnClickCondition
	 * @param String conditionNo
	 * @return List<FormulaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FormulaVO> searchPsoConditionSys(String conditionNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<FormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionNo != null){
				param.put("cond_no", conditionNo);
				velParam.put("cond_no", conditionNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchPsoConditionSysRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FormulaVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	/**
	 * Formula N' Condition Creation 화면의 Delete Button을 ClicK 했을 경우 해당 Formula가 사용되는지 여부 확인 
	 * @category VOP_PSO_0007_DeleteBtnClickFormula
	 * @param String formulaNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] checkFormulaUsing(String formulaNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String strCnt = "";
		String updMnuNo = "";
		try{
			if(formulaNo != null){
				param.put("foml_no", formulaNo);
				velParam.put("foml_no", formulaNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOcheckFormulaUsingRSQL(), param, velParam);
			
			if(dbRowset.next()){
				strCnt = dbRowset.getString(1);
				updMnuNo = dbRowset.getString(2);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return new String[]{strCnt, updMnuNo};
	}

	/**
	 *  Formula N' Condition Creation 화면의 Delete Button을 ClicK 했을 경우 처리
	 * @category VOP_PSO_0007_DeleteBtnClickFormula
	 * @param String formulaNo
	 */	public void removeFormulaDetail(String formulaNo)  throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int delCnt = 0;
				Map<String, Object> velParam = new HashMap<String, Object>();
				if(!formulaNo.equals("")){
					velParam.put("foml_no", (Object)formulaNo);
					delCnt = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOremoveFormulaDetailDSQL(), velParam, velParam);
					if(delCnt == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to Delete SQL ");
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
	  * Formula N' Condition Creation 화면의 Delete Button을 ClicK 했을 경우 처리
	  * @category VOP_PSO_0007_DeleteBtnClickCondition
	  * @param String conditionNo
	  * @return String[]
	  */
	public String[] checkConditionUsing(String conditionNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String strCnt = "";
		String updMnuNo = "";

		try{
			if(conditionNo != null){
				param.put("cond_no", conditionNo);
				velParam.put("cond_no", conditionNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOcheckConditionUsingRSQL(), param, velParam);
			
			if(dbRowset.next()){
				strCnt = dbRowset.getString(1);
				updMnuNo = dbRowset.getString(2);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return new String[]{strCnt, updMnuNo};
	}

	/**
	 * Formula N' Condition Creation 화면의 Delete Button을 ClicK 했을 경우 처리
	 * @category VOP_PSO_0007_DeleteBtnClickCondition
	 * @param String conditionNo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeConditionDetail(String conditionNo)  throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt = 0;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(!conditionNo.equals("")){
				velParam.put("cond_no", (Object)conditionNo);
				delCnt = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOremoveConditionDetailDSQL(), velParam, velParam);
				if(delCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete SQL ");
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
	 * Formula N' Condition Creation 화면의 Delete Button을 ClicK 했을 경우 처리
	 * @category VOP_PSO_0007_DeleteBtnClickCondition
	 * @param String conditionNo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCondtion(String conditionNo)  throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt = 0;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(!conditionNo.equals("")){
				velParam.put("cond_no", (Object)conditionNo);
				delCnt = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOremoveConditionDSQL(), velParam, velParam);
				if(delCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete SQL ");
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
	 * Formula 정보를 저장한다. 
	 * @category VOP_PSO_0007_SaveBtnClickFormula
	 * @param FormulaGRPVO formulaGRPVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPsoFormula(FormulaGRPVO formulaGRPVO) throws DAOException,Exception {
		
		//FOML_DESC,
		//FOML_SYS_DESC
		//의 정보를 만들어야 한다. 
		List<FormulaVO> lstFoml = Arrays.asList(formulaGRPVO.getFormulaVOs());
		List<FormulaVO> lstFomlSys = Arrays.asList(formulaGRPVO.getFormulaSysVOs());
		
		if(lstFoml==null) return;
		
		StringBuilder sbFomlDesc = new StringBuilder();
		StringBuilder sbSysDesc  = new StringBuilder();
		
		makeFomlDesc(lstFoml, lstFomlSys, sbFomlDesc, sbSysDesc);
		
		List<PsoFormulaVO> insertVoList = new ArrayList<PsoFormulaVO>();
		log.debug("FomlDesc:="+sbFomlDesc.toString());
		log.debug("SysDesc:="+sbSysDesc.toString());
		
		//[2010.03.17:jmh] FOML_SYS_DESC가 존재하는지 체크		
		List<PsoFormulaVO> checkPsoFormulaVOs = searchPsoFormulaBySysDesc(sbSysDesc.toString().trim());
		if(checkPsoFormulaVOs != null && checkPsoFormulaVOs.size() != 0){
			String existsNo = checkPsoFormulaVOs.get(0).getFomlNo();
			throw new DAOException(new ErrorHandler("PSO90011", new String[]{"Formula already exists in No " + existsNo + "."}).getMessage());
		}
		
		PsoFormulaVO vo = new PsoFormulaVO(); 
		
		vo.setFomlNo(formulaGRPVO.getId());//Foml_NO
		vo.setFomlDesc(sbFomlDesc.toString());
		vo.setFomlSysDesc(sbSysDesc.toString());
		vo.setCreUsrId(formulaGRPVO.getUsrId());
		vo.setUpdUsrId(formulaGRPVO.getUsrId());
		vo.setUpdMnuNo("2");//복잡으로 설정
		/**
		 * FORMULA 가 AMOUNT 산출 방식인지 PERCENT에 의해 산출 되는 방식인지 지정함
A : AMOUNT
P : PERCENT
		 */
		vo.setPsoFomlMzdCd(""); 
		
		if(lstFoml!=null)
			insertVoList.add(vo);
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("foml_no", vo.getFomlNo());

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(insertVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddPsoFormularCSQL(), insertVoList,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * formula 의 Description 필드정보를 만든다.
	 * @param List<FormulaVO> lstFoml
	 * @param List<FormulaVO> lstFomlSys
	 * @param StringBuilder sbFomlDesc
	 * @param StringBuilder sbSysDesc
	 */
	private void makeFomlDesc(List<FormulaVO> lstFoml,
			List<FormulaVO> lstFomlSys, StringBuilder sbFomlDesc,
			StringBuilder sbSysDesc) {
		String[] strTmp = null;
		
		for(int i=0; i<lstFoml.size();i++){
			FormulaVO vo    = (FormulaVO) lstFoml.get(i);
			FormulaVO voSys = (FormulaVO) lstFomlSys.get(i);
			sbFomlDesc.append(" "+vo.getCol1());
			sbFomlDesc.append(" "+vo.getCol2());
			sbFomlDesc.append(" "+vo.getCol3());
			sbFomlDesc.append(" "+vo.getCol4());
			sbFomlDesc.append(" "+vo.getCol5());
			sbFomlDesc.append(" "+vo.getCol6());
			sbFomlDesc.append(" "+vo.getCol7());
			sbFomlDesc.append(" "+vo.getCol8());
			sbFomlDesc.append(" "+vo.getCol9());
			sbFomlDesc.append(" "+vo.getCol10());
			sbFomlDesc.append(" "+vo.getCol11());
			sbFomlDesc.append(" "+vo.getCol12());
			sbFomlDesc.append(" "+vo.getCol13());
			/**
			 * 산식에 사용하는 요소 구분 코드임
OBJECT ID, CHARGE EXPRESSION ID 구분함

O : OBJECT LIST
P : 산식에 사용 가능한 연산자.[사칙연산자, () ]
C : 상수값
			 */
			strTmp = voSys.getCol1().split("@");
			if(strTmp != null && strTmp.length > 1){
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol2().split("@");
			if(strTmp != null && strTmp.length > 1){
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else 
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol3().split("@");
			if(strTmp != null && strTmp.length > 1){
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else 
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol4().split("@");
			if(strTmp != null && strTmp.length > 1){
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else 
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol5().split("@");
			if(strTmp != null && strTmp.length > 1){
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else 
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol6().split("@");
			if(strTmp != null && strTmp.length > 1){
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else 
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol7().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol8().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol9().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol10().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol11().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol12().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol13().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
		}
	}


	/**
	 * Formula 정보를 저장한다. PSO_FOML_DTL 정보를 저장 
	 * @category VOP_PSO_0007_SaveBtnClickFormula
	 * @param FormulaGRPVO formulaGRPVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPsoFormulaDetail(FormulaGRPVO formulaGRPVO) throws DAOException,Exception {
		//GroupVO를 해석하여 PSO_FOML_DTL VO에 설정 후 INSERT한다. 
		List<FormulaVO> lstFomlSys = Arrays.asList(formulaGRPVO.getFormulaSysVOs());
		
		if(lstFomlSys==null) return;
		
		String[] strTmp = null;
		List<PsoFomlDtlVO> insertList = new ArrayList<PsoFomlDtlVO>();
		
		int seq = 0;
		
		for(int i=0; i<lstFomlSys.size();i++){
			FormulaVO voSys = (FormulaVO) lstFomlSys.get(i);
			PsoFomlDtlVO[] vos = new PsoFomlDtlVO[13];
			for(int j=0; j<vos.length;j++){
				vos[j] = new PsoFomlDtlVO();
				vos[j].setFomlNo(formulaGRPVO.getId());
				vos[j].setCreUsrId(formulaGRPVO.getUsrId());
				vos[j].setUpdUsrId(formulaGRPVO.getUsrId());
			}
			/**
			 * 산식에 사용하는 요소 구분 코드임
				OBJECT ID, CHARGE EXPRESSION ID 구분함
				
				O : OBJECT LIST
				P : 산식에 사용 가능한 연산자.[사칙연산자, () ]
				C : 상수값
				M : Cell에서 DoubleClick하여 Insert한 데이터 
			 */
			if(voSys.getIbflag().equals("D"))//Delete Flag를 처리 하지 않음 
				continue;
			strTmp = voSys.getCol1().split("@");
			if(setPsoFomlDtlVO(strTmp, vos[0])){
				vos[0].setFomlSeq(++seq+"");
				insertList.add(vos[0]);
			}
			strTmp = voSys.getCol2().split("@");
			if(setPsoFomlDtlVO(strTmp, vos[1])){
				vos[1].setFomlSeq(++seq+"");
				insertList.add(vos[1]);
			}
			strTmp = voSys.getCol3().split("@");
			if(setPsoFomlDtlVO(strTmp, vos[2])){
				vos[2].setFomlSeq(++seq+"");
				insertList.add(vos[2]);
			}
			strTmp = voSys.getCol4().split("@");
			if(setPsoFomlDtlVO(strTmp, vos[3])){
				vos[3].setFomlSeq(++seq+"");
				insertList.add(vos[3]);
			}
			strTmp = voSys.getCol5().split("@");
			if(setPsoFomlDtlVO(strTmp, vos[4])){
				vos[4].setFomlSeq(++seq+"");
				insertList.add(vos[4]);
			}
			strTmp = voSys.getCol6().split("@");
			if(setPsoFomlDtlVO(strTmp, vos[5])){
				vos[5].setFomlSeq(++seq+"");
				insertList.add(vos[5]);
			}
			strTmp = voSys.getCol7().split("@");
			if(setPsoFomlDtlVO(strTmp, vos[6])){
				vos[6].setFomlSeq(++seq+"");
				insertList.add(vos[6]);
			}
			strTmp = voSys.getCol8().split("@");
			if(setPsoFomlDtlVO(strTmp, vos[7])){
				vos[7].setFomlSeq(++seq+"");
				insertList.add(vos[7]);
			}
			strTmp = voSys.getCol9().split("@");
			if(setPsoFomlDtlVO(strTmp, vos[8])){
				vos[8].setFomlSeq(++seq+"");
				insertList.add(vos[8]);
			}
			strTmp = voSys.getCol10().split("@");
			if(setPsoFomlDtlVO(strTmp, vos[9])){
				vos[9].setFomlSeq(++seq+"");
				insertList.add(vos[9]);
			}
			strTmp = voSys.getCol11().split("@");
			if(setPsoFomlDtlVO(strTmp, vos[10])){
				vos[10].setFomlSeq(++seq+"");
				insertList.add(vos[10]);
			}
			strTmp = voSys.getCol12().split("@");
			if(setPsoFomlDtlVO(strTmp, vos[11])){
				vos[11].setFomlSeq(++seq+"");
				insertList.add(vos[11]);
			}
			strTmp = voSys.getCol13().split("@");
			if(setPsoFomlDtlVO(strTmp, vos[12])){
				vos[12].setFomlSeq(++seq+"");
				insertList.add(vos[12]);
			}
		}
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			int insCnt[] = null;
			if(insertList.size() > 0){
				velParam.put("foml_no", (String)formulaGRPVO.getId());
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddPsoFormulaDetailCSQL(), insertList, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_FOML_DTL의 정보를 채우기 위해 Method TYPE별로 VO의 필드를 설정한다.
	 * @param String[] strTmp
	 * @param PsoFomlDtlVO psoFomlDtlVO
	 * @return boolean
	 */
	private boolean setPsoFomlDtlVO(String[] strTmp, PsoFomlDtlVO psoFomlDtlVO) {
		boolean bRet = false;
		if(strTmp != null && strTmp.length > 1){
			if(strTmp[1].equals("C")){
				//TODO 우선 데이터가 들어 가도록 처리 함. 추후 변경 필요 
				psoFomlDtlVO.setFomlPrtCtnt(strTmp[0]);//Constant Value
				psoFomlDtlVO.setPsoFomlDtlTpCd("C");
				bRet = true;
			}
			else if(strTmp[1].equals("O")){
				//[##]<##>형태 처리 
				String[] strVal = strTmp[0].split("<");
				if(strVal.length > 1){
					psoFomlDtlVO.setObjListNo(strVal[0]);
					psoFomlDtlVO.setRtObjListNo(strVal[1].replace(">", ""));
				}
				else
					psoFomlDtlVO.setObjListNo(strTmp[0]);
				psoFomlDtlVO.setPsoFomlDtlTpCd("O");
				bRet = true;
			}
			else if(strTmp[1].equals("P")){
				psoFomlDtlVO.setPsoFomlOprCd(strTmp[0]);
				psoFomlDtlVO.setPsoFomlDtlTpCd("P");
				bRet = true;
			}
			else if(strTmp[1].equals("M")){
				//TODO 우선 데이터가 들어 가도록 처리 함. 추후 변경 필요 
//				vo.setObjListNo(strTmp[0]);//일단 Constant Value와 똑같이 취급
				psoFomlDtlVO.setConsNm(strTmp[0]);//Constant Value
				psoFomlDtlVO.setPsoFomlDtlTpCd("M");
				bRet = true;
			}
		}
		return bRet ;
	}


	/**
	 * Formula 정보를 저장한다. 기존 Formula 의 정보를 Update 한다. 
	 * @category VOP_PSO_0007_SaveBtnClickFormula
	 * @param FormulaGRPVO formulaGRPVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyPsoFormula(FormulaGRPVO formulaGRPVO) throws DAOException,Exception {
		
		String id = formulaGRPVO.getId().trim() + "";
		
		//FOML_DESC,
		//FOML_SYS_DESC
		//의 정보를 만들어야 한다. 
		List<FormulaVO> lstFoml = Arrays.asList(formulaGRPVO.getFormulaVOs());
		List<FormulaVO> lstFomlSys = Arrays.asList(formulaGRPVO.getFormulaSysVOs());
		
		if(lstFoml==null) return;
		
		StringBuilder sbFomlDesc = new StringBuilder();
		StringBuilder sbSysDesc  = new StringBuilder();
		
		makeFomlDesc(lstFoml, lstFomlSys, sbFomlDesc, sbSysDesc);
		
		List<PsoFormulaVO> updateVoList = new ArrayList<PsoFormulaVO>();
		log.debug("FomlDesc:="+sbFomlDesc.toString());
		log.debug("SysDesc:="+sbSysDesc.toString());
		
		
		
		//[2010.03.17:jmh] FOML_SYS_DESC가 존재하는지 체크		
		List<PsoFormulaVO> checkPsoFormulaVOs = searchPsoFormulaBySysDesc(sbSysDesc.toString().trim());
		if(checkPsoFormulaVOs != null && checkPsoFormulaVOs.size() != 0){
			String existsNo = checkPsoFormulaVOs.get(0).getFomlNo();
			if(!id.equals(existsNo)){
				throw new DAOException(new ErrorHandler("PSO90011", new String[]{"Formula already exists in No " + existsNo + "."}).getMessage());
			}
		}
		
		PsoFormulaVO vo = new PsoFormulaVO(); 
		
		vo.setFomlNo(id);//Foml_NO
		vo.setFomlDesc(sbFomlDesc.toString());
		vo.setFomlSysDesc(sbSysDesc.toString());
		vo.setCreUsrId(formulaGRPVO.getUsrId());
		vo.setUpdUsrId(formulaGRPVO.getUsrId());
		vo.setUpdMnuNo("2");//복잡으로 설정
		/**
		 * FORMULA 가 AMOUNT 산출 방식인지 PERCENT에 의해 산출 되는 방식인지 지정함
A : AMOUNT
P : PERCENT
		 */
		vo.setPsoFomlMzdCd(""); 
		
		if(lstFoml!=null)
			updateVoList.add(vo);
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("foml_no", vo.getFomlNo());
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOmodifyPsoFormulaUSQL(), updateVoList, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * Condition 정보를 저장한다.
	 * @category VOP_PSO_0007_SaveBtnClickCondtion
	 * @param FormulaGRPVO formulaGRPVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPsoCondition(FormulaGRPVO formulaGRPVO)throws DAOException,Exception {
		
		//FOML_DESC,
		//FOML_SYS_DESC
		//의 정보를 만들어야 한다. 
		List<FormulaVO> lstFoml = Arrays.asList(formulaGRPVO.getFormulaVOs());
		List<FormulaVO> lstFomlSys = Arrays.asList(formulaGRPVO.getFormulaSysVOs());
		
		if(lstFoml==null) return;
		
		StringBuilder sbCondDesc = new StringBuilder();
		StringBuilder sbSysDesc  = new StringBuilder();
		
		makeCondDesc(lstFoml, lstFomlSys, sbCondDesc, sbSysDesc);
		
		List<PsoConditionVO> insertVoList = new ArrayList<PsoConditionVO>();
		log.debug("FomlDesc:="+sbCondDesc.toString());
		log.debug("SysDesc:="+sbSysDesc.toString());
		
		//[2010.03.17:jmh] COND_SYS_DESC가 존재하는지 체크		
		List<PsoConditionVO> checkPsoConditionVOs = searchPsoConditionBySysDesc(sbSysDesc.toString().trim());
		if(checkPsoConditionVOs != null && checkPsoConditionVOs.size() != 0){
			String existsNo = checkPsoConditionVOs.get(0).getCondNo();
			throw new DAOException(new ErrorHandler("PSO90011", new String[]{"Condition already exists in No " + existsNo + "."}).getMessage());
		}
		
		PsoConditionVO vo = new PsoConditionVO(); 
		
		vo.setCondNo(formulaGRPVO.getId());//Foml_NO
		vo.setCondDesc(sbCondDesc.toString());
		vo.setCondSysDesc(sbSysDesc.toString());
		vo.setCreUsrId(formulaGRPVO.getUsrId());
		vo.setUpdUsrId(formulaGRPVO.getUsrId());
		vo.setUpdMnuNo("2");//복잡으로 설정

		if(lstFoml!=null)
			insertVoList.add(vo);
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("cond_no", vo.getCondNo());

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(insertVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddPsoConditionCSQL(), insertVoList,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Condition 의 Description 필드정보를 만든다.
	 * @param List<FormulaVO> lstFoml
	 * @param List<FormulaVO> lstFomlSys
	 * @param StringBuilder sbFomlDesc
	 * @param StringBuilder sbSysDesc
	 */
	private void makeCondDesc(List<FormulaVO> lstFoml,
			List<FormulaVO> lstFomlSys, StringBuilder sbFomlDesc,
			StringBuilder sbSysDesc) {
		String[] strTmp = null;
		
		for(int i=0; i<lstFoml.size();i++){
			FormulaVO vo    = (FormulaVO) lstFoml.get(i);
			FormulaVO voSys = (FormulaVO) lstFomlSys.get(i);
			sbFomlDesc.append(" "+vo.getCol1());
			sbFomlDesc.append(" "+vo.getCol2());
			sbFomlDesc.append(" "+vo.getCol3());
			sbFomlDesc.append(" "+vo.getCol4());
			sbFomlDesc.append(" "+vo.getCol5());
			sbFomlDesc.append(" "+vo.getCol6());
			sbFomlDesc.append(" "+vo.getCol7());
			sbFomlDesc.append(" "+vo.getCol8());
			sbFomlDesc.append(" "+vo.getCol9());
			sbFomlDesc.append(" "+vo.getCol10());
			sbFomlDesc.append(" "+vo.getCol11());
			sbFomlDesc.append(" "+vo.getCol12());
			sbFomlDesc.append(" "+vo.getCol13());
			/**
			 * 조건 사용 가능 연산자, 괄호 이거나 조건 사용 OBJECT 구분

C : 조건 사용 가능 연산자, 괄호  --> P로 변경 
O : 조건 사용 OBJECT
V : 조건 사용 OBJECT VALUE       --> C로 변경 
			 */
			
			//[##]<##>형태 처리 
//			String[] strVal = strTmp[0].split("<");
//			if(strVal.length > 1){
//				sbSysDesc.append("["+strVal[0]+"]");
//				sbSysDesc.append("<"+strVal[1]);
//			}
//			else
//				sbSysDesc.append("["+strTmp[0]+"]");
			
			strTmp = voSys.getCol1().split("@");
			if(strTmp != null && strTmp.length > 1){
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol2().split("@");
			if(strTmp != null && strTmp.length > 1){
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else 
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol3().split("@");
			if(strTmp != null && strTmp.length > 1){
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else 
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol4().split("@");
			if(strTmp != null && strTmp.length > 1){
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else 
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol5().split("@");
			if(strTmp != null && strTmp.length > 1){
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else 
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol6().split("@");
			if(strTmp != null && strTmp.length > 1){
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else 
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol7().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol8().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol9().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol10().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					
					// CHM-201006714-01 보완 //sbSysDesc.append("'" + strTmp[0] + "'");
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol11().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol12().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
			strTmp = voSys.getCol13().split("@");
			if(strTmp != null && strTmp.length > 1) {
				sbSysDesc.append(" ");
				if(strTmp[1].equals("C"))
					sbSysDesc.append(strTmp[0]);
				else if(strTmp[1].equals("O")){
					//[##]<##>형태 처리 
					String[] strVal = strTmp[0].split("<");
					if(strVal.length > 1){
						sbSysDesc.append("["+strVal[0]+"]");
						sbSysDesc.append("<"+strVal[1]);
					}
					else
						sbSysDesc.append("["+strTmp[0]+"]");
				}
				else
					sbSysDesc.append(strTmp[0]);
			}
		}
	}

	/**
	 * Condition 정보를 저장한다.
	 * @category VOP_PSO_0007_SaveBtnClickCondtion
	 * @param FormulaGRPVO formulaGRPVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPsoConditionDetail(FormulaGRPVO formulaGRPVO) throws DAOException,Exception {
		//GroupVO를 해석하여 PSO_FOML_DTL VO에 설정 후 INSERT한다. 
		List<FormulaVO> lstFomlSys = Arrays.asList(formulaGRPVO.getFormulaSysVOs());
		
		if(lstFomlSys==null) return;
		
		String[] strTmp = null;
		List<PsoCondDtlVO> insertList = new ArrayList<PsoCondDtlVO>();
		
		int seq = 0;
		
		for(int i=0; i<lstFomlSys.size();i++){
			FormulaVO voSys = (FormulaVO) lstFomlSys.get(i);
			PsoCondDtlVO[] vos = new PsoCondDtlVO[13];
			for(int j=0; j<vos.length;j++){
				vos[j] = new PsoCondDtlVO();
				vos[j].setCondNo(formulaGRPVO.getId());
				vos[j].setCreUsrId(formulaGRPVO.getUsrId());
				vos[j].setUpdUsrId(formulaGRPVO.getUsrId());
			}
			/**
			 * 	조건 사용 가능 연산자, 괄호 이거나 조건 사용 OBJECT 구분

				P(C) : 조건 사용 가능 연산자, 괄호
				O : 조건 사용 OBJECT
				C(V) : 조건 사용 OBJECT VALUE
				M : Cell에서 DoubleClick하여 Insert한 데이터 
			 */
			if(voSys.getIbflag().equals("D"))//Delete Flag를 처리 하지 않음 
				continue;
			strTmp = voSys.getCol1().split("@");
			if(setPsoCondDtlVO(strTmp, vos[0])){
				vos[0].setCondSeq(++seq+"");
				insertList.add(vos[0]);
			}
			strTmp = voSys.getCol2().split("@");
			if(setPsoCondDtlVO(strTmp, vos[1])){
				vos[1].setCondSeq(++seq+"");
				insertList.add(vos[1]);
			}
			strTmp = voSys.getCol3().split("@");
			if(setPsoCondDtlVO(strTmp, vos[2])){
				vos[2].setCondSeq(++seq+"");
				insertList.add(vos[2]);
			}
			strTmp = voSys.getCol4().split("@");
			if(setPsoCondDtlVO(strTmp, vos[3])){
				vos[3].setCondSeq(++seq+"");
				insertList.add(vos[3]);
			}
			strTmp = voSys.getCol5().split("@");
			if(setPsoCondDtlVO(strTmp, vos[4])){
				vos[4].setCondSeq(++seq+"");
				insertList.add(vos[4]);
			}
			strTmp = voSys.getCol6().split("@");
			if(setPsoCondDtlVO(strTmp, vos[5])){
				vos[5].setCondSeq(++seq+"");
				insertList.add(vos[5]);
			}
			strTmp = voSys.getCol7().split("@");
			if(setPsoCondDtlVO(strTmp, vos[6])){
				vos[6].setCondSeq(++seq+"");
				insertList.add(vos[6]);
			}
			strTmp = voSys.getCol8().split("@");
			if(setPsoCondDtlVO(strTmp, vos[7])){
				vos[7].setCondSeq(++seq+"");
				insertList.add(vos[7]);
			}
			strTmp = voSys.getCol9().split("@");
			if(setPsoCondDtlVO(strTmp, vos[8])){
				vos[8].setCondSeq(++seq+"");
				insertList.add(vos[8]);
			}
			strTmp = voSys.getCol10().split("@");
			if(setPsoCondDtlVO(strTmp, vos[9])){
				vos[9].setCondSeq(++seq+"");
				insertList.add(vos[9]);
			}
			strTmp = voSys.getCol11().split("@");
			if(setPsoCondDtlVO(strTmp, vos[10])){
				vos[10].setCondSeq(++seq+"");
				insertList.add(vos[10]);
			}
			strTmp = voSys.getCol12().split("@");
			if(setPsoCondDtlVO(strTmp, vos[11])){
				vos[11].setCondSeq(++seq+"");
				insertList.add(vos[11]);
			}
			strTmp = voSys.getCol13().split("@");
			if(setPsoCondDtlVO(strTmp, vos[12])){
				vos[12].setCondSeq(++seq+"");
				insertList.add(vos[12]);
			}
		}
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			int insCnt[] = null;
			if(insertList.size() > 0){
				velParam.put("cond_no", (Object)formulaGRPVO.getId());
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddPsoConditionDetailCSQL(), insertList, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * PSO_COND_DTL의 정보를 채우기 위해 Method TYPE별로 VO의 필드를 설정한다.
	 * @param String[] strTmp
	 * @param PsoCondDtlVO psoCondDtlVO
	 * @return boolean
	 */
	private boolean setPsoCondDtlVO(String[] strTmp, PsoCondDtlVO psoCondDtlVO) {
		boolean bRet = false;
		if(strTmp != null && strTmp.length > 1){
			//TODO 확인필요필드
			psoCondDtlVO.setObjListNo("-1");//NotNull이라 일단 이렇게 강제화 
			if(strTmp[1].equals("P")){
				psoCondDtlVO.setPsoCondOprCd(strTmp[0]);//Constant Value
				psoCondDtlVO.setPsoCondDtlTpCd("P");
				bRet = true;
			}
			else if(strTmp[1].equals("O")){
				/**
				if(strVal.length > 1){
					psoFomlDtlVO.setObjListNo(strVal[0]);
					psoFomlDtlVO.setRtObjListNo(strVal[1].replace(">", ""));
				}
				else
					psoFomlDtlVO.setObjListNo(strTmp[0]);
				psoFomlDtlVO.setPsoFomlDtlTpCd("O");
				bRet = true;
				 */
//<##> 형태를 해석할 수 있도록 추가 로직 추가필요.. 2009.11.12				
				//[##]<##>형태 처리 
				String[] strVal = strTmp[0].split("<");
				if(strVal.length > 1){
					psoCondDtlVO.setObjListNo(strVal[0]);
					psoCondDtlVO.setRtObjListNo(strVal[1].replace(">", ""));
				}
				else
					psoCondDtlVO.setObjListNo(strTmp[0]);
				psoCondDtlVO.setPsoCondDtlTpCd("O");
				bRet = true;
			}
			else if(strTmp[1].equals("C")||strTmp[1].equals("V")){//코드값일단 이렇게 처리
				psoCondDtlVO.setCondOprValCtnt(strTmp[0]);
				psoCondDtlVO.setPsoCondDtlTpCd("C");
				bRet = true;
			}
			else if(strTmp[1].equals("M")){
				psoCondDtlVO.setCondOprValCtnt(strTmp[0]);//코드값일단 이렇게 처리
				psoCondDtlVO.setPsoCondDtlTpCd("C");
				bRet = true;
			}
		}
		return bRet ;
	}

	/**
	 * Condition 정보를 저장한다.
	 * @category VOP_PSO_0007_SaveBtnClickCondtion
	 * @param FormulaGRPVO formulaGRPVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyPsoCondition(FormulaGRPVO formulaGRPVO) throws DAOException,Exception {
		String id = formulaGRPVO.getId().trim() + "";
		//FOML_DESC,
		//FOML_SYS_DESC
		//의 정보를 만들어야 한다. 
		List<FormulaVO> lstCond = Arrays.asList(formulaGRPVO.getFormulaVOs());
		List<FormulaVO> lstCondSys = Arrays.asList(formulaGRPVO.getFormulaSysVOs());
		
		if(lstCond==null) return;
		
		StringBuilder sbCondDesc = new StringBuilder();
		StringBuilder sbSysDesc  = new StringBuilder();
		
		makeCondDesc(lstCond, lstCondSys, sbCondDesc, sbSysDesc);
		
		List<PsoConditionVO> updateVoList = new ArrayList<PsoConditionVO>();
		log.debug("CondDesc:="+sbCondDesc.toString());
		log.debug("SysDesc:="+sbSysDesc.toString());
		
		//[2010.03.17:jmh] COND_SYS_DESC가 존재하는지 체크		
		List<PsoConditionVO> checkPsoConditionVOs = searchPsoConditionBySysDesc(sbSysDesc.toString().trim());
		if(checkPsoConditionVOs != null && checkPsoConditionVOs.size() != 0){
			String existsNo = checkPsoConditionVOs.get(0).getCondNo();
			if(!id.equals(existsNo)){
				throw new DAOException(new ErrorHandler("PSO90011", new String[]{"Condition already exists in No " + existsNo + "."}).getMessage());
			}
		}
		
		PsoConditionVO vo = new PsoConditionVO(); 
		
		vo.setCondNo(id);//Foml_NO
		vo.setCondDesc(sbCondDesc.toString());
		vo.setCondSysDesc(sbSysDesc.toString());
		vo.setCreUsrId(formulaGRPVO.getUsrId());
		vo.setUpdUsrId(formulaGRPVO.getUsrId());
		vo.setUpdMnuNo("2");//복잡으로 설정
		
		if(lstCond!=null)
			updateVoList.add(vo);
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("cond_no", vo.getCondNo());
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOmodifyPsoConditionUSQL(), updateVoList, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * PSO_YD_CHG_OBJ_LIST 정보를 저장한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param PsoYdChgObjListVO psoYdChgObjListVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int mergePsoYdChgObjList(PsoYdChgObjListVO psoYdChgObjListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if(psoYdChgObjListVO != null){
				Map<String, String> mapVO = psoYdChgObjListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOMergePsoYdChgObjListCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Merge SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PSO_YD_CHG_OBJ_LIST 정보를 삭제한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param PsoYdChgObjListVO psoYdChgObjListVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removePsoYdChgObjList(PsoYdChgObjListVO psoYdChgObjListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if(psoYdChgObjListVO != null){
				Map<String, String> mapVO = psoYdChgObjListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemovePsoYdChgObjListDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * Formula 정보를 조회한다.
	 * @category VOP_PSO_0002_PageLoading (jmh)
	 * @return List<PsoFormulaVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PsoFormulaVO>  searchFormulaNoForLoading() throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoFormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchFormulaNoForLoadingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoFormulaVO.class);
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
	 * PSO_YD_CHG 정보를 조회한다.
	 * @category VOP_PSO_0002_SaveButtonClick (jmh)
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @return List<PsoYdChgVO> 
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PsoYdChgVO> searchPsoYdChgByPK(String ydChgNo, String ydChgVerSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoYdChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("yd_chg_no", ydChgNo);
		param.put("yd_chg_ver_seq", ydChgVerSeq);
		velParam.put("yd_chg_no", ydChgNo);
		velParam.put("yd_chg_ver_seq", ydChgVerSeq);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoYdChgByPKRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoYdChgVO.class);
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
	 * PSO_YD_CHG 정보를 저장한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param  PsoYdChgVO psoYdChgVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addPsoYdChg(PsoYdChgVO psoYdChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if(psoYdChgVO != null){
				Map<String, String> mapVO = psoYdChgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOAddPsoYdChgCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Add SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PSO_YD_CHG : Version을 채번한다.
	 * @category VOP_PSO_0002_SaveButtonClick (jmh)
	 * @param  String ydChgNo
	 * @return String  
	 * @throws DAOException
	 */
	public String searchPsoYdChgVersionByNo(String ydChgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String version = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("yd_chg_no", ydChgNo);
		velParam.put("yd_chg_no", ydChgNo);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoYdChgVersionByNoRSQL(), param, velParam);
			dbRowset.next();
			version = dbRowset.getInt(1) + "";
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return version;
	}
	
	/**
	 * PSO_YD_CHG : 동일 Cost/Yard/Vendor의 EXP_DT 최대값을 조회한다.
	 * @category VOP_PSO_0002_SaveButtonClick (jmh)
	 * @param  String lgsCostCd
	 * @param  String ydCd
	 * @param  String vndrSeq
	 * @return String 
	 * @throws DAOException
	 */
	public String searchPsoYdChgMaxExpDtByYdCostVndr(String lgsCostCd, String ydCd, String vndrSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String expDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("lgs_cost_cd", lgsCostCd);
		param.put("yd_cd", ydCd);
		param.put("vndr_seq", vndrSeq);
		
		velParam.put("lgs_cost_cd", lgsCostCd);
		velParam.put("yd_cd", ydCd);
		velParam.put("vndr_seq", vndrSeq);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoYdChgMaxExpDtByYdCostVndrRSQL(), param, velParam);
			dbRowset.next();
			expDt = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return expDt;
	}
	
	/**
	 * PSO_YD_CHG EXP_DT/LST_FLG를 수정한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param  String ydChgNo
	 * @param  String expDt
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyPsoYdChgExpDtLstFlgByNo(String ydChgNo, String expDt) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			param.put("yd_chg_no", ydChgNo);
			param.put("exp_dt", expDt);
			
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("exp_dt", expDt);	

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOModifyPsoYdChgExpDtLstFlgByNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Add SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PSO_YD_CHG 를 수정한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param  PsoYdChgVO psoYdChgVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyPsoYdChg(PsoYdChgVO psoYdChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if(psoYdChgVO != null){
				Map<String, String> mapVO = psoYdChgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOModifyPsoYdChgUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Modify SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * [VOP_PSO_0002화면] OBJECT_LIST_NO와 Rate_Type으로 FORMULA_NO를 조회한다.
	 * @category VOP_PSO_0002_SaveButtonClick (jmh)
	 * @param  String psoObjCd
	 * @param  String psoMeasUtCd
	 * @param  String psoTrfTpCd
	 * @return List<PsoFormulaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoFormulaVO> searchFomlNoByObjListNo(String psoObjCd, String psoMeasUtCd, String psoTrfTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoFormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("pso_obj_cd", psoObjCd);
		param.put("pso_meas_ut_cd", psoMeasUtCd);
		param.put("pso_trf_tp_cd", psoTrfTpCd);
		
		velParam.put("pso_obj_cd", psoObjCd);
		velParam.put("pso_meas_ut_cd", psoMeasUtCd);
		velParam.put("pso_trf_tp_cd", psoTrfTpCd);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchFomlNoByObjListNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoFormulaVO.class);
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
	 * [VOP_PSO_0004화면] OBJECT_LIST_NO와 Rate_Type으로 FORMULA_NO를 조회한다.
	 * @category VOP_PSO_0004_SaveButtonClick (jmh)
	 * @param  String objListNo
	 * @param  String psoTrfTpCd
	 * @return List<PsoFormulaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoFormulaVO> searchFomlNoByObjAndType(String objListNo, String psoTrfTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoFormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("obj_list_no", objListNo);
		param.put("pso_trf_tp_cd", psoTrfTpCd);
		
		velParam.put("obj_list_no", objListNo);
		velParam.put("pso_trf_tp_cd", psoTrfTpCd);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchFomlNoByObjAndTypeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoFormulaVO.class);
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
	 * PSO_OBJ_CD,PSO_MEAS_UT_CD로 OBJECT_LIST_NO를 조회한다.
	 * @category VOP_PSO_0002_SaveButtonClick (jmh)
	 * @param  String psoObjCd
	 * @param  String psoMeasUtCd
	 * @return String 
	 * @throws DAOException
	 */
	public String searchObjListNoByObjUom(String psoObjCd, String psoMeasUtCd) throws DAOException {
		DBRowSet dbRowset = null;
		String objListNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("pso_obj_cd", psoObjCd);
		param.put("pso_meas_ut_cd", psoMeasUtCd);
		
		velParam.put("pso_obj_cd", psoObjCd);
		velParam.put("pso_meas_ut_cd", psoMeasUtCd);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchObjListNoByObjUomRSQL(), param, velParam);
			if(dbRowset.next()){
				objListNo = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return objListNo;
	}

	/**
	 * PSO_YD_CHG 정보를 조회한다.
	 * @category VOP_PSO_0002_SaveButtonClick (jmh)
	 * @param  String fomlNo
	 * @param  String condNo
	 * @return List<PsoChgXprDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PsoChgXprDtlVO> searchChgXprNoByFomlCond(String fomlNo, String condNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoChgXprDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("foml_no", fomlNo);
		param.put("cond_no", condNo);
		velParam.put("foml_no", fomlNo);
		velParam.put("cond_no", condNo);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchChgXprNoByFomlCondRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoChgXprDtlVO.class);
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
	 * PSO_CHG_XPR 채번한다.
	 * @category VOP_PSO_0002_SaveButtonClick (jmh)
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsoChgXprPK() throws DAOException {
		DBRowSet dbRowset = null;
		String chgXprNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoChgXprPKRSQL(), param, velParam);
			dbRowset.next();
			chgXprNo = dbRowset.getInt(1) + "";
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return chgXprNo;
	}
	
	/**
	 * PSO_CHG_XPR 정보를 저장한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param PsoChgXprVO psoChgXprVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int mergePsoChgXpr(PsoChgXprVO psoChgXprVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if(psoChgXprVO != null){
				Map<String, String> mapVO = psoChgXprVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOMergePsoChgXprCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Merge SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PSO_CHG_XPR_DTL 정보를 저장한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param PsoChgXprDtlVO psoChgXprDtlVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int mergePsoChgXprDtl(PsoChgXprDtlVO psoChgXprDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if(psoChgXprDtlVO != null){
				Map<String, String> mapVO = psoChgXprDtlVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOMergePsoChgXprDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Merge SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PSO_YD_CHG_XPR 정보를 저장한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param PsoYdChgXprVO psoYdChgXprVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int mergePsoYdChgXpr(PsoYdChgXprVO psoYdChgXprVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(psoYdChgXprVO != null){
				Map<String, String> mapVO = psoYdChgXprVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOMergePsoYdChgXprCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Merge SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PSO_YD_CHG_XPR 정보를 저장한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param PsoYdChgXprVO psoYdChgXprVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int mergePsoYdChgXprByFK(PsoYdChgXprVO psoYdChgXprVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(psoYdChgXprVO != null){
				Map<String, String> mapVO = psoYdChgXprVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOMergePsoYdChgXprByFKCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Merge SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PSO_TARIFF 채번한다.
	 * @category VOP_PSO_0002_SaveButtonClick (jmh)
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchPsoTariffPK() throws DAOException {
		DBRowSet dbRowset = null;
		String portTrfNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoTariffPKRSQL(), param, velParam);
			dbRowset.next();
			portTrfNo = dbRowset.getInt(1) + "";
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return portTrfNo;
	}
	
	/**
	 * PSO_TRF_DTL 정보를 저장한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param PsoTrfDtlVO psoTrfDtlVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addPsoTrfDtl(PsoTrfDtlVO psoTrfDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(psoTrfDtlVO != null){
				Map<String, String> mapVO = psoTrfDtlVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOaddTariffDetailCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PSO_TRF_DTL 정보를 저장한다.
	 * @category VOP_PSO_0004_SaveBtnClick (jmh)
	 * @param  List<PsoTrfDtlVO> psoTrfDtlVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPsoTrfDtl(List<PsoTrfDtlVO> psoTrfDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(psoTrfDtlVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOaddTariffDetailCSQL(), psoTrfDtlVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No "+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PSO_TRF_DTL 정보를 삭제한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String chargeType
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removePsoTrfDtlByChgNoChgVerTpCd(String ydChgNo, String ydChgVerSeq, String chargeType) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("charge_type", chargeType);
			
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("charge_type", chargeType);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemovePsoTrfDtlByChgNoChgVerTpCdDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PSO_TARIFF 정보를 삭제한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String chargeType
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removePsoTariffByChgNoChgVerTpCd(String ydChgNo, String ydChgVerSeq, String chargeType) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("charge_type", chargeType);
			
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("charge_type", chargeType);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemovePsoTariffByChgNoChgVerTpCdDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PSO_CHG_XPR_DTL 정보를 삭제한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param  String ydChgNo
	 * @param  String ydChgVerSeq
	 * @param  String chargeType
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removePsoChgXprDtlByChgNoChgVerTpCd(String ydChgNo, String ydChgVerSeq, String chargeType) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("charge_type", chargeType);
			
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("charge_type", chargeType);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemovePsoChgXprDtlByChgNoChgVerTpCdDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PSO_CHG_XPR 정보를 삭제한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String chargeType
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removePsoChgXprByChgNoChgVerTpCd(String ydChgNo, String ydChgVerSeq, String chargeType) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("charge_type", chargeType);
			
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("charge_type", chargeType);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemovePsoChgXprByChgNoChgVerTpCdDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PSO_CONDITION 채번한다.
	 * @category VOP_PSO_0206_OKButtonClick (jmh)
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchPsoConditionPK() throws DAOException {
		DBRowSet dbRowset = null;
		String condNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoConditionPKRSQL(), param, velParam);
			dbRowset.next();
			condNo = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return condNo;
	}

	/**
	 * PSO_CONDITION 채번한다. (비어있는 Condition No. 채번)
	 * @category VOP_PSO_0206_OKButtonClick (jmh)
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchPsoConditionContinuousPK() throws DAOException {
		DBRowSet dbRowset = null;
		String condNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoConditionContinuousPKRSQL(), param, velParam);
			dbRowset.next();
			condNo = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return condNo;
	}
	
	/**
	 * PSO_FORMULA 채번한다.
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchPsoFormulaPK() throws DAOException {
		DBRowSet dbRowset = null;
		String fomlNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoFormulaPKRSQL(), param, velParam);
			dbRowset.next();
			fomlNo = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return fomlNo;
	}

	/**
	 * PSO_FORMULA 채번한다. (비어있는 Formula No. 채번)
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchPsoFormulaContinuousPK() throws DAOException {
		DBRowSet dbRowset = null;
		String fomlNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoFormulaContinuousPKRSQL(), param, velParam);
			dbRowset.next();
			fomlNo = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return fomlNo;
	}

	/**
	 * PSO_CONDITION 정보를 저장한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param PsoConditionVO psoConditionVO
	 * @return int 
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addPsoConditionByRow(PsoConditionVO psoConditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(psoConditionVO != null){
				Map<String, String> mapVO = psoConditionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOaddPsoConditionCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PSO_COND_DTL 정보를 저장한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param PsoCondDtlVO psoCondDtlVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addPsoCondDtlByRow(PsoCondDtlVO psoCondDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(psoCondDtlVO != null){
				Map<String, String> mapVO = psoCondDtlVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOaddPsoConditionDetailCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * Condition를 조회한다.
	 * @category VOP_PSO_0206_Search (jmh)
	 * @param  String condNo
	 * @return List<SearchTariffConditionVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTariffConditionVO> searchTariffCondition(String condNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTariffConditionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("cond_no", condNo);
		velParam.put("cond_no", condNo);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchTariffConditionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTariffConditionVO.class);
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
	 * Condition를 조회한다.
	 * @category VOP_PSO_0206_Search (jmh)
	 * @param  String condNo
	 * @return List<SearchTariffConditionVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PsoConditionVO> searchTariffConditionDesc(String condNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoConditionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("cond_no", condNo);
		velParam.put("cond_no", condNo);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchTariffConditionDescRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoConditionVO.class);
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
	 * PSO_CONDITION 채번한다.
	 * @category VOP_PSO_0206_OKButtonClick (jmh)
	 * @param  String portCd
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchLocalCurrencyByPortCd(String portCd) throws DAOException {
		DBRowSet dbRowset = null;
		String localCurrency = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("port_cd", portCd);
		velParam.put("port_cd", portCd);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchLocalCurrencyByPortCdRSQL(), param, velParam);
			if(dbRowset.next()){
				localCurrency = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return localCurrency;
	}
	
	/**
	 * PSO_YD_CHG_XPR 정보를 삭제한다.
	 * @category VOP_PSO_0002_DeleteBtnClick (jmh)
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @param String chargeType
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removePsoYdChgXprByChgNoChgVerTpCd(String ydChgNo, String ydChgVerSeq, String chargeType) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("charge_type", chargeType);
			
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("charge_type", chargeType);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemovePsoYdChgXprByChgNoChgVerTpCdDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PSO_YD_CHG 정보를 삭제한다.
	 * @category VOP_PSO_0002_DeleteBtnClick (jmh)
	 * @param String ydChgNo
	 * @param String ydChgVerSeq
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removePsoYdChg(String ydChgNo, String ydChgVerSeq) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemovePsoYdChgDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Charge Expression Description를 조회한다.
	 * @category VOP_PSO_0002_Save (jmh)
	 * @param  String chgXprNo
	 * @return List<PsoChgXprVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PsoChgXprVO> searchChgXprDescByChgXprNo(String chgXprNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoChgXprVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("chg_xpr_no", chgXprNo);
		velParam.put("chg_xpr_no", chgXprNo);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchChgXprDescByChgXprNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoChgXprVO.class);
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
	 * PSO_CHG_XPR 정보를 수정한다.
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param String chgXprNo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyChgXprDescByChgXprNo(String chgXprNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("chg_xpr_no", chgXprNo);
			velParam.put("chg_xpr_no", chgXprNo);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOModifyChgXprDescByChgXprNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PSO_CHG_XPR 정보의 validation check  
	 * @category VOP_PSO_0002_SaveBtnClick (jmh)
	 * @param String chgXprNo
	 * @return String 
	 * @throws DAOException 
	 */
	public String validateChgXprDescByChgXprNo(String chgXprNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		DBRowSet dbRowset = null;
		String strRet = "";

		try {
			param.put("chg_xpr_no", chgXprNo);
			velParam.put("chg_xpr_no", chgXprNo);
			param.put("exp_cnd", "[45]<");
			velParam.put("exp_cnd","[45]<");
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOvalidateChgXprNoRSQL(), param, velParam);
			
			if(dbRowset.next())
				strRet = dbRowset.getString(1);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strRet;
	}
	
	/**
	 * Object List를 조회한다.
	 * @category VOP_PSO_0004_Save (jmh)
	 * @param  String psoObjListTpCd
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PsoObjListVO> searchPsoObjListByPsoObjListTpCd(String psoObjListTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoObjListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("pso_obj_list_tp_cd", psoObjListTpCd);
		velParam.put("pso_obj_list_tp_cd", psoObjListTpCd);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoObjListByPsoObjListTpCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoObjListVO.class);
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
	 * Object List를 조회한다.
	 * @category VOP_PSO_0004_Save (jmh)
	 * @param  PsoYdChgObjListVO psoYdChgObjListVO
	 * @return List<YdChgObjVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<YdChgObjVO> searchPsoYdChgObjListByPK(PsoYdChgObjListVO psoYdChgObjListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YdChgObjVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			if(psoYdChgObjListVO != null){
				Map<String, String> mapVO = psoYdChgObjListVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoYdChgObjListByPKRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YdChgObjVO.class);
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
	 * Vendor List를 조회한다.
	 * @category VOP_PSO_0211,2 (jmh)
	 * @param  String ydCd
	 * @param  String costCd
	 * @param  String year
	 * @param  String uid
	 * @param  String acctcd
	 * @return List<MdmVendorVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MdmVendorVO> searchVendorByYardAndCost(String ydCd, String costCd, String year, String uid, String acctcd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVendorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("yd_cd", ydCd);
			param.put("lgs_cost_cd", costCd);
			param.put("year", year);
			param.put("uid", uid);
			param.put("acct_cd", acctcd);
			
			velParam.put("yd_cd", ydCd);
			velParam.put("lgs_cost_cd", costCd);
			velParam.put("year", year);
			velParam.put("uid", uid);
			velParam.put("acct_cd", acctcd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchVendorByYardAndCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVendorVO.class);
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
	 * 해당 Formula가 Validate한지 체크한다.
	 * @param FormulaGRPVO formulaGRPVO
	 * @param String flag
	 * @return String
	 * @throws DAOException
	 */
	public String validateFormulaCondition(FormulaGRPVO formulaGRPVO, String flag) throws DAOException{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String strRet = "";
		//FOML_DESC,
		//FOML_SYS_DESC
		//의 정보를 만들어야 한다. 
		List<FormulaVO> lstFoml = Arrays.asList(formulaGRPVO.getFormulaVOs());
		List<FormulaVO> lstFomlSys = Arrays.asList(formulaGRPVO.getFormulaSysVOs());
		
		if(lstFoml==null) return "";
		
		StringBuilder sbDesc = new StringBuilder();
		StringBuilder sbSysDesc  = new StringBuilder();
		
		if(flag.equals("1"))
			makeFomlDesc(lstFoml, lstFomlSys, sbDesc, sbSysDesc);
		else
			makeCondDesc(lstFoml, lstFomlSys, sbDesc, sbSysDesc);

		log.debug("FomlCondDesc:="+sbDesc.toString());
		log.debug("SysDesc:="+sbSysDesc.toString());
			
		
		try{
			param.put("sys_desc", sbSysDesc.toString());
			param.put("flag", flag);
			velParam.put("sys_desc", sbSysDesc.toString());
			velParam.put("flag", flag);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOvalidateFormulaConditionRSQL(), param, velParam);
			if(dbRowset.next())
				strRet = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strRet;
	}
	
	/**
	 * 해당 Formula가 Validate한지 체크한다. 모든 formula는 RATE Object가 기본적으로 산식에 들어가 잇어야 함. rate object 잇는지 체크로직
	 * @param FormulaGRPVO formulaGRPVO
	 * @return String
	 * @throws DAOException
	 */
	public String validateFormulaRate(FormulaGRPVO formulaGRPVO ) throws DAOException{
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String strRet = "";
		//FOML_DESC,
		//FOML_SYS_DESC
		//의 정보를 만들어야 한다. 
		List<FormulaVO> lstFoml = Arrays.asList(formulaGRPVO.getFormulaVOs());
		List<FormulaVO> lstFomlSys = Arrays.asList(formulaGRPVO.getFormulaSysVOs());
		
		if(lstFoml==null) return "";
		
		StringBuilder sbDesc = new StringBuilder();
		StringBuilder sbSysDesc  = new StringBuilder();
		
		makeFomlDesc(lstFoml, lstFomlSys, sbDesc, sbSysDesc);
	
 		log.debug("rate_SysDesc:="+sbSysDesc.toString());
			
 
		try{
			param.put("foml_sys_desc", sbSysDesc.toString());
			velParam.put("foml_sys_desc", sbSysDesc.toString());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOvalidateFormulaRateRSQL(), param, velParam);
			log.debug("dbRowset:="+dbRowset);
			if(dbRowset.next())
				strRet = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strRet;
	}
	
	/**
	 * 모든 Account & Cost를 조회한다.
	 * @category VOP_PSO_0037 (jmh)
	 * @return List<AccountAndCostVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<AccountAndCostVO> searchAccountAndCost() throws DAOException {
		DBRowSet dbRowset = null;
		List<AccountAndCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchAccountAndCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountAndCostVO.class);
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
	 * 모든 Account & Cost를 조회한다.
	 * @category VOP_PSO_0237 (jmh)
     * @param YdChgNoDataInfoVO ydChgNoDataInfoVO 
	 * @return List<YdChgNoDataInfoVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<YdChgNoDataInfoVO> searchYdChgNoDataInfo(YdChgNoDataInfoVO ydChgNoDataInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YdChgNoDataInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			String ydCd    = ydChgNoDataInfoVO.getYdCd();
			String allInfo = ydChgNoDataInfoVO.getAllInfo();
		
			param.put("acct_cd", allInfo);
			param.put("yd_cd", ydCd);
	


            if(allInfo != null && !allInfo.equals("")){
				
				String[] acct_vndr = allInfo.split(",");
			
				List<String> acctvndrList  = new ArrayList<String>();
				for(int i=0; i<acct_vndr.length; i++){
					acctvndrList.add(acct_vndr[i]);
					log.debug(i+"acct_vndr[i]"+acct_vndr[i]);
			 	
			     	//	arracctvndr.add(arr_acct_vndr[j]);
				
				 }
			
				log.debug("allInfo+"+allInfo);
				log.debug("aaaaaa+"+acctvndrList);
	                      
				param.put("acct_vndr",     allInfo);
				param.put("all_acct_vndr", acctvndrList);
			
				velParam.put("acct_vndr",    allInfo);
				velParam.put("all_acct_vndr",acctvndrList);
				
//				param.put("port_cd", allInfo.substring(0, 6));
//				param.put("yd_cd", ydCd.substring(5));
//				param.put("arr_yd_cd", ydCdList);
//				
//				velParam.put("port_cd", ydCd.substring(0, 5));
//				velParam.put("yd_cd", ydCd.substring(5));
//				velParam.put("arr_yd_cd", ydCdList);
			}
		
	
			//log.debug("param++**"+acctCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOsearchYdChgNoDataInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YdChgNoDataInfoVO.class);
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
	 * Tariff Value Management를 조회한다.
	 * @category VOP_PSO_0037 (jmh)
	 * @param  YardChargeVO yardChargeVO
	 * @return List<YardChargeVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<YardChargeVO> searchYardChargeList(YardChargeVO yardChargeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardChargeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			String fromDt = yardChargeVO.getFromDate();
			String toDt   = yardChargeVO.getToDate();
			String portCd = yardChargeVO.getPortCd();
			String yardCd = yardChargeVO.getYardCd();
			String acctCd = yardChargeVO.getAcctCd().trim();
			String costCd = yardChargeVO.getCostCd().trim();
			
			String[] arrYardCd = yardCd.split(",");
			List<String> yardCdList  = new ArrayList();
			for(int i=0; i<arrYardCd.length; i++){
				yardCdList.add(arrYardCd[i]);
			}
			
			param.put("from_dt", fromDt);
			param.put("to_dt", toDt);
			param.put("port_cd", portCd);
			param.put("yard_cd", yardCd);
			param.put("arr_yard_cd", yardCdList);
			param.put("acct_cd", acctCd);
			param.put("cost_cd", costCd);
			
			velParam.put("from_dt", fromDt);
			velParam.put("to_dt", toDt);
			velParam.put("port_cd", portCd);
			velParam.put("yard_cd", yardCd);
			velParam.put("arr_yard_cd", yardCdList);
			velParam.put("acct_cd", acctCd);
			velParam.put("cost_cd", costCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoYdChgByCondRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardChargeVO.class);
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
	 * YD_CHG_NO, YD_CHG_VER_SEQ별로 Object를 조회한다.
	 * @category VOP_PSO_0037 (jmh)
	 * @param  YdChgObjVO ydChgObjVO
	 * @return List<YdChgObjVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<YdChgObjVO> searchObjByYdChg(YdChgObjVO ydChgObjVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YdChgObjVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("yd_chg_no", ydChgObjVO.getYdChgNo());
			param.put("yd_chg_ver_seq", ydChgObjVO.getYdChgVerSeq());

			velParam.put("yd_chg_no", ydChgObjVO.getYdChgNo());
			velParam.put("yd_chg_ver_seq", ydChgObjVO.getYdChgVerSeq());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchObjByYdChgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YdChgObjVO.class);
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
	 * Expired Date 유효성 체크
	 * @category VOP_PSO_0037 (jmh)
	 * @param  YardChargeVO yardChargeVO
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String checkExpDateForTariffMgt(YardChargeVO yardChargeVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String flag = "";
		
		try{
			if(yardChargeVO != null){
				Map<String, String> mapVO = yardChargeVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOCheckExpDateForTariffMgtRSQL(), param, velParam);
			
			if(dbRowset.next()){
				flag = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return flag;
	}
	
	/**
	 * Invoice Count 체크
	 * @category VOP_PSO_0037
	 * @param  YardChargeVO yardChargeVO
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String getInvCnt(YardChargeVO yardChargeVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String invCnt = "";
		
		try{
			if(yardChargeVO != null){
				Map<String, String> mapVO = yardChargeVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOGetInvCntRSQL(), param, velParam);
			
			if(dbRowset.next()){
				invCnt = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invCnt;
	}
	
	/**
	 * PSO_YD_CHG EXP_DT/CPLS_FLG를 수정한다.
	 * @category VOP_PSO_0037_SaveBtnClick (jmh)
	 * @param  String ydChgNo
	 * @param  String ydChgVerSeq
	 * @param  String expDt
	 * @param  String cplsFlg
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyPsoYdChgExpDtCplsFlgByNo(String ydChgNo, String ydChgVerSeq, String expDt, String cplsFlg) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("exp_dt", expDt);
			param.put("cpls_flg", cplsFlg);
			
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("exp_dt", expDt);	
			velParam.put("cpls_flg", cplsFlg);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAOModifyPsoYdChgExpDtCplsFlgByNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Add SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * Expression Description 유효성 체크
	 * @category VOP_PSO_0002/0004 (jmh)
	 * @param  String desc
	 * @param  String flag
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String checkXprDesc(String desc, String flag) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String check = "";
		
		try{
			param.put("sys_desc", desc);
			param.put("sys_desc", desc);
			
			velParam.put("flag", flag);
			velParam.put("flag", flag);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOvalidateFormulaConditionRSQL(), param, velParam);
			
			if(dbRowset.next()){
				check = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return check;
	}
	
	/**
	 * Formula에 속한 Object를 조회한다.
	 * @category VOP_PSO_0004 (jmh)
	 * @param  String fomlNo
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PsoObjListVO> searchObjectsByFormula(String fomlNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoObjListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("foml_no", fomlNo);

			velParam.put("foml_no", fomlNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchObjectsByFormulaRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoObjListVO.class);
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
	 * FOML_SYS_DESC로 Formula 조회하기
	 * @category VOP_PSO_0007 (jmh)
	 * @param  String fomlSysDesc
	 * @return List<PsoFormulaVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PsoFormulaVO> searchPsoFormulaBySysDesc(String fomlSysDesc) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoFormulaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("foml_sys_desc", fomlSysDesc);
			param.put("foml_sys_desc", fomlSysDesc);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoFormulaBySysDescRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoFormulaVO.class);
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
	 * COND_SYS_DESC로 Condition 조회하기
	 * @category VOP_PSO_0007 (jmh)
	 * @param  String condSysDesc
	 * @return List<PsoConditionVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PsoConditionVO> searchPsoConditionBySysDesc(String condSysDesc) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoConditionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("cond_sys_desc", condSysDesc);
			param.put("cond_sys_desc", condSysDesc);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoConditionBySysDescRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoConditionVO.class);
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
	 * 동일 Yard/Cost, LST_FLG='Y' 인 경우, 같은 CURR_CD인지 체크
	 * @category VOP_PSO_0004_SaveButtonClick (jmh)
	 * @param  String ydCd
	 * @param  String costCd
	 * @return String[]  
	 * @throws DAOException
	 */
	public String[] searchCurrByYardAndCost(String ydCd, String costCd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrCurr = new String[2];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("yd_cd", ydCd);
		param.put("cost_cd", costCd);

		velParam.put("yd_cd", ydCd);
		velParam.put("cost_cd", costCd);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchCurrByYardAndCostRSQL(), param, velParam);
			dbRowset.next();
			arrCurr[0] = dbRowset.getString(1) + "";
			arrCurr[1] = dbRowset.getString(2) + "";
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arrCurr;
	}

	/**
	 * INV_OFC에 등록된 Yard/Cost/Vendor인지 체크
	 * @category VOP_PSO_0004_SaveButtonClick (jmh)
	 * @param  String ofcCd
	 * @param  String ydCd
	 * @param  String costCd
	 * @param  String vndrSeq
	 * @return String[]  
	 * @throws DAOException
	 */
	public String[] checkRegisteredYardOrCostOrVendor(String ofcCd, String ydCd, String costCd, String vndrSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String[] retArr = new String[3];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("ofc_cd", ofcCd);
		param.put("yd_cd", ydCd);
		param.put("cost_cd", costCd);
		param.put("vndr_seq", vndrSeq);
		
		velParam.put("ofc_cd", ofcCd);
		velParam.put("yd_cd", ydCd);
		velParam.put("cost_cd", costCd);
		velParam.put("vndr_seq", vndrSeq);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOCheckRegisteredYardOrCostOrVendorRSQL(), param, velParam);
			dbRowset.next();
			retArr[0] = dbRowset.getString(1) + "";
			retArr[1] = dbRowset.getString(2) + "";
			retArr[2] = dbRowset.getString(3) + "";
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retArr;
	}
	
	/*
	 * CHM-201006949-01
	 */
	/**
	 * 해당 PortCd와 CostCd를 가지는 Tariff List를 조회한다.
	 * 
	 * @param String portCd
	 * @param String costCd
	 * @return List<TariffListWithYdNmVO>
	 * @exception DAOException
	 */
	public List<TariffListWithYdNmVO> searchTariffWithCostCd(String portCd, String costCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffListWithYdNmVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("port_cd", portCd);
			param.put("cost_cd", costCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtDBDAOSearchTariffListWithCostCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TariffListWithYdNmVO.class);
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PSO_YD_CHG EXP_DT를 수정한다.
	 * @category VOP_PSO_0037_SaveBtnClick (jmh)
	 * @param  String ydChgNo
	 * @param  String ydChgVerSeq
	 * @param  String expDt
	 * @param  String cplsFlg
	 * @return int
	 * @throws DAOException
	 */
	public int modifyPsoYdChgExpDtByNo(String ydChgNo, String ydChgVerSeq, String expDt, String cplsFlg) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("exp_dt", expDt);
			param.put("cpls_flg", cplsFlg);
			
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("exp_dt", expDt);	
			velParam.put("cpls_flg", cplsFlg);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtDBDAOModifyPsoYdChgExpDtByNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PSO_YD_CHG CPLS_FLG를 수정한다.
	 * @category VOP_PSO_0037_SaveBtnClick (jmh)
	 * @param  String ydChgNo
	 * @param  String ydChgVerSeq
	 * @param  String expDt
	 * @param  String cplsFlg
	 * @return int
	 * @throws DAOException
	 */
	public int modifyPsoYdChgCplsFlgByNo(String ydChgNo, String ydChgVerSeq, String expDt, String cplsFlg) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			param.put("yd_chg_no", ydChgNo);
			param.put("yd_chg_ver_seq", ydChgVerSeq);
			param.put("exp_dt", expDt);
			param.put("cpls_flg", cplsFlg);
			
			velParam.put("yd_chg_no", ydChgNo);
			velParam.put("yd_chg_ver_seq", ydChgVerSeq);
			velParam.put("exp_dt", expDt);	
			velParam.put("cpls_flg", cplsFlg);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtDBDAOModifyPsoYdChgCplsFlgByNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * 1.PSO_YD_CHG_OBJ_LIST 데이터 삭제
	 * 
	 * @param yardChargeVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeTariffFromPsoYdChgObjList(YardChargeVO yardChargeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if(yardChargeVO != null){
				Map<String, String> mapVO = yardChargeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemoveTariffFromPsoYdChgObjListDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 2.PSO_YD_CHG 데이터 삭제
	 * 
	 * @param yardChargeVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeTariffFromPsoYdChg(YardChargeVO yardChargeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(yardChargeVO != null){
				Map<String, String> mapVO = yardChargeVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemoveTariffFromPsoYdChgDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 3.PSO_YD_CHG_XPR 데이터 삭제
	 * 
	 * @param yardChargeVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeTariffFromPsoYdChgXpr(YardChargeVO yardChargeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(yardChargeVO != null){
				Map<String, String> mapVO = yardChargeVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemoveTariffFromPsoYdChgXprDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 4.PSO_CONDITION 데이터 삭제
	 * 
	 * @param yardChargeVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeTariffFromPsoCondition(YardChargeVO yardChargeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(yardChargeVO != null){
				Map<String, String> mapVO = yardChargeVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemoveTariffFromPsoConditionDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 5.PSO_COND_DTL 데이터 삭제
	 * 
	 * @param yardChargeVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeTariffFromPsoCondDtl(YardChargeVO yardChargeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(yardChargeVO != null){
				Map<String, String> mapVO = yardChargeVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemoveTariffFromPsoCondDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 6.PSO_FORMULA 데이터 삭제
	 * 
	 * @param yardChargeVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeTariffFromPsoFormula(YardChargeVO yardChargeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(yardChargeVO != null){
				Map<String, String> mapVO = yardChargeVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemoveTariffFromPsoFormulaDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 7.PSO_FOML_DTL 데이터 삭제
	 * 
	 * @param yardChargeVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeTariffFromPsoFomlDtl(YardChargeVO yardChargeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(yardChargeVO != null){
				Map<String, String> mapVO = yardChargeVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemoveTariffFromPsoFomlDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 8.PSO_CHG_XPR 데이터 삭제
	 * 
	 * @param yardChargeVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeTariffFromPsoChgXpr(YardChargeVO yardChargeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(yardChargeVO != null){
				Map<String, String> mapVO = yardChargeVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemoveTariffFromPsoChgXprDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 9.PSO_CHG_XPR_DTL 데이터 삭제
	 * 
	 * @param yardChargeVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeTariffFromPsoChgXprDtl(YardChargeVO yardChargeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(yardChargeVO != null){
				Map<String, String> mapVO = yardChargeVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemoveTariffFromPsoChgXprDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 10.PSO_TRF_DTL 데이터 삭제
	 * 
	 * @param yardChargeVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeTariffFromPsoTrfDtl(YardChargeVO yardChargeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(yardChargeVO != null){
				Map<String, String> mapVO = yardChargeVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemoveTariffFromPsoTrfDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 11.PSO_TARIFF 데이터 삭제
	 * 
	 * @param yardChargeVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeTariffFromPsoTariff(YardChargeVO yardChargeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(yardChargeVO != null){
				Map<String, String> mapVO = yardChargeVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new PortTariffMgtBCDBDAORemoveTariffFromPsoTariffDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	
	/**
	 * 
	 * @category VOP_PSO_0004_OKButtonClick (lsh)
	 * @param  String vndrSeq
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchCurrencyByVndrSeq(String vndrSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String localCurrency = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("vndr_seq", vndrSeq);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchCurrencyByVndrSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				localCurrency = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return localCurrency;
	}
	
	/**
	 * YD_CHG_NO, YD_CHG_VER_SEQ 로 업로드된 파일목록 조회하기
	 * @category VOP_PSO_0041
	 * @param  TariffAtchFileVO tariffAtchFileVO
	 * @return List<PsoTrfAtchFileVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PsoTrfAtchFileVO> searchPsoTrfAtchFileList(TariffAtchFileVO tariffAtchFileVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PsoTrfAtchFileVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("yd_chg_no", tariffAtchFileVO.getYdChgNo());
			//param.put("yd_chg_ver_seq", tariffAtchFileVO.getYdChgVerSeq());
			param.put("atch_file_div_cd", tariffAtchFileVO.getAtchFileDivCd());
			
			velParam.put("atchFileAuth", tariffAtchFileVO.getAtchFileAuth());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoTrfAtchFileListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsoTrfAtchFileVO.class);
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
	 * 
	 * @category VOP_PSO_0041_SaveButtonClick (lsh)
	 * @param  List<PsoTrfAtchFileVO> psoTrfAtchFileVOs
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void addPsoTrfAtchFile(List<PsoTrfAtchFileVO> psoTrfAtchFileVOs)  throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(psoTrfAtchFileVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAOAddPsoTrfAtchFileCSQL(), psoTrfAtchFileVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 
	 * @category VOP_PSO_0041_SaveButtonClick (lsh)
	 * @param  List<PsoTrfAtchFileVO> psoTrfAtchFileVOs
	 * @throws DAOException
	 * @throws Exception
	 */	
	public void removePsoTrfAtchFile(List<PsoTrfAtchFileVO> psoTrfAtchFileVOs)  throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(psoTrfAtchFileVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PortTariffMgtBCDBDAORemovePsoTrfAtchFileDSQL(), psoTrfAtchFileVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * vendor 로 생성된 tariff 존재 여부 체크
	 * @category VOP_PSO_0237
	 * @param String vndrseq
	 * @param String ydcd
	 * @param String acctcd
	 */
	@SuppressWarnings("unchecked")
	public void searchVendorTariffCheck(String vndrseq,String ydcd, String acctcd) throws DAOException{
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			
			param.put("vndr_seq", vndrseq);
			velParam.put("vndr_seq", vndrseq);
			param.put("yd_cd", ydcd);
			velParam.put("yd_cd", ydcd);
			param.put("acct_cd", acctcd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchPsoYdChgExistRSQL(), param, velParam);
			
			
			dbRowset.next();
			String cnt = dbRowset.getString(1);
			if(cnt.equals("Y")){
			throw new DAOException("Fail to insert No" + cnt);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * yard  존재 여부 체크
	 * @category VOP_PSO_0237
	 * @param String ydcd
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public String searchMdmYardCheck(String ydcd) throws DAOException{
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			
			param.put("yd_cd", ydcd);
			velParam.put("yd_cd", ydcd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchMdmYardRSQL(), param, velParam);
			
			if(dbRowset.next()){
				return dbRowset.getString(1);
			}
			else 
				return "";
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}

	
	/**
	 * Port Tariff Creation에서 생성한 Remark 을 조회한다.
	 * @category VOP_PSO_0042
	 * @param PortTariffListVO portTariffListVO
	 * @return List<YardChargeVersionVO>
	 */
	@SuppressWarnings("unchecked")
	public List<YardChargeVersionVO> searchYardChargeRemark(
			PortTariffListVO portTariffListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardChargeVersionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(portTariffListVO != null){
				Map<String, String> mapVO = portTariffListVO .getColumnValues();
				
				param.putAll(mapVO);
			
				if(portTariffListVO.getViewFlag().equals("DTL")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtDBDAOsearchPortTariffDtlRemarkRSQL(), param, null);
				}else{
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortTariffMgtBCDBDAOSearchYardChargeRemarkRSQL(), param, null);
				}
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardChargeVersionVO.class);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
}
