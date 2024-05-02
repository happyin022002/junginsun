/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : porttariffmgtBCImpl.java
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.04.28 김진일
* 1.0 Creation
*
* History
* 2010.10.01 진마리아 [CHM-201006264-01] Session User ID 설정로직 변경
* 2010.11.24 CHM-201006949-01 박희동 특정 Tariff가 존재하는 Yard List를 조회한다.
* 2011.06.27 진마리아 CHM-201111838-01 소스품질 결함수정 - 문자열 비교는 문자열 비교 메소드를 사용해야 한다.
* 2011.07.28 김기종 CHM-201112475-01 [VOP_PSO] Port Tariff Inquiry 메뉴 수정 요청건
* 2011.09.20 진마리아 CHM-201112149-01 Compulsory Flag 의 checking/unchecking이 모든 Tariff에 대해 변경/저장이 가능하도록 로직 변경
* 2011.10.31 진마리아 선처리(SRM-201121014) [VOP-PSO] Tariff Value Management 화면 로직 변경
* 2011.11.23 진마리아 CHM-201114406-01 Tariff Value Management 화면 로직 변경(EDIT_ENBL_FLG 추가)
* 2013.08.12 SkY    CHM-201325992  [VOP-PSO] 중복 formula 저장 시 메세지  내용 변경
* 2014.03.12 박다은 	CHM-201429104  [PSO] Tariff Attribute 내 불필요 Tariff 삭제 기능 요청
* 2014.03.19 CHM-201428969 최문환  [PSO] Port tariff Inquiry - 조회조건 및 화면 변경
* 2014.07.16 CHM-201430928 이성훈  [PSO] Port Tariff Contract 및 URL 저장
* 2015.02.10 CHM-201533892 Tariff내 Formula 및 Condition 생성 로직변경  
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoObjListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration.PortTariffMgtDBDAO;
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
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.SearchChgXprNoVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.SearchTariffConditionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffAtchFileVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffBaseVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffListGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffValueMgtGRPVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConForVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaDtlVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.UseStatusConditonFormulaVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.VendorVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YardChargeVersionVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgNoDataInfoVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgObjVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgNonDgCgoKwVO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.syscommon.common.table.PsoChgXprDtlVO;
import com.hanjin.syscommon.common.table.PsoChgXprVO;
import com.hanjin.syscommon.common.table.PsoCondDtlVO;
import com.hanjin.syscommon.common.table.PsoConditionVO;
import com.hanjin.syscommon.common.table.PsoFormulaVO;
import com.hanjin.syscommon.common.table.PsoTariffVO;
import com.hanjin.syscommon.common.table.PsoTrfAtchFileVO;
import com.hanjin.syscommon.common.table.PsoTrfDtlVO;
import com.hanjin.syscommon.common.table.PsoYdChgObjListVO;
import com.hanjin.syscommon.common.table.PsoYdChgVO;
import com.hanjin.syscommon.common.table.PsoYdChgXprVO;

/**
 * NIS2010-portsomasterdatamgt Business Logic Basic Command implementation<br>
 * - NIS2010-portsomasterdatamgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jin Ihl
 * @see UI_PSO-0205EventResponse,porttariffmgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class PortTariffMgtBCImpl extends BasicCommandSupport implements PortTariffMgtBC {

	// Database Access Object
	private transient PortTariffMgtDBDAO dbDao = null;

	/**
	 * porttariffmgtBCImpl 객체 생성<br>
	 * porttariffmgtDBDAO를 생성한다.<br>
	 */
	public PortTariffMgtBCImpl() {
		dbDao = new PortTariffMgtDBDAO();
	}

	/**
	 * SSO의 User의 Office CD로 해당 밴더의 정보를 조회한다.
	 * @param VendorVO vendorVO
	 * @return List<VendorVO>
	 * @exception EventException
	 */
	public List<VendorVO> searchOfficeVendor(VendorVO vendorVO)	throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchOfficeVendor(vendorVO);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Vendors"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Vendors"}).getMessage(), ex);
		}
	}


	/**
	 * condition 의 and,or 연산자를 조회한다.
	 * @return List<CondtionOpertionGRPVO>
	 * @throws DAOException
	 */
	public List<CondtionOpertionVO> searchConditonAndOrOperator () throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchConditonAndOrOperator();
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Operators"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Operators"}).getMessage(), ex);
		}
	}
	

	/**
	 * condition 의 비교 연산자를 조회한다.
	 * @return List<CondtionOpertionGRPVO>
	 * @throws DAOException
	 */
	public List<CondtionOpertionVO> searchConditionCompairingOperator () throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchConditionCompairingOperator();
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Operators"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Operators"}).getMessage(), ex);
		}
	}
	

	
	/**
	 * 로그인 유저가 소속한 Office가 설정한 cost code정보를 조회한다.
	 * @param ofcCd
	 * @return List<CostCodeVO>
	 * @throws DAOException
	 */
	public List<CostCodeVO> searchCostCodeList( String ofcCd ) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchCostCodeList(ofcCd);
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Cost"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Cost"}).getMessage(), ex);
		}
	}
	

	
	/**
	 * 로그인 유저가 소속한 Office가 설정한 Currency 정보를 조회한다.
	 * @param ofcCd
	 * @return List<CurrencyVO>
	 * @throws DAOException
	 */
	public List<CurrencyVO> searchCurrencyList(String ofcCd) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchCurrencyList(ofcCd);
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Currency"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Currency"}).getMessage(), ex);
		}
	}

	/**
	 * Object List를 조회한다.
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 */
	public List<PsoObjListVO> searchObjectListA() throws EventException {
		try {
			return dbDao.searchObjectListA();
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Object"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Object"}).getMessage(), ex);
		}
	}
	
	/**
	 * Object List를 조회한다.
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 */
	public List<PsoObjListVO> searchObjectListAll() throws EventException {
		try {
			return dbDao.searchObjectListAll();
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Object"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Object"}).getMessage(), ex);
		}
	}
	
	/**
	 * 로그인 유저가 소속한 Office가 설정한 Object List를 조회한다.
	 * @param String psoOfcCd
	 * @param String types
	 * @return List<PsoObjListVO>
	 * @throws DAOException
	 */
	public List<PsoObjListVO> searchOfficeObjectList1(String psoOfcCd, String types ) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchOfficeObjectList1(psoOfcCd, types);
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Object"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Object"}).getMessage(), ex);
		}
	}
		

	
	/**
	 * 로그인 유저가 소속한 Office가 설정한 Object List의 두번째row정보를 조회한다.
	 * @param String psoOfcCd
	 * @param String psoObjCd
	 * @param String types
	 * @return List<PsoObjListVO> 
	 * @throws EventException
	 */
	public List<PsoObjListVO> searchOfficeObjectList2(String psoOfcCd, String psoObjCd, String types ) throws EventException {
		try {
			return dbDao.searchOfficeObjectList2(psoOfcCd , psoObjCd, types);
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Object"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Object"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 등록되어 있는 Object List를 조회한다.
	 * 
	 * @param PsoObjListVO psoObjListVO
	 * @return List<PsoObjListVO>
	 * @throws EventException
	 */
	public List<PsoObjListVO> searchObjectList(PsoObjListVO psoObjListVO)
			throws EventException {
		// TODO Auto-generated method stub
		// List<PsoObjListVO> list = new ArrayList<PsoObjListVO>();
		// PsoObjListVO vo = new PsoObjListVO();
		try {
			// vo.setList1(dbDao.searchObjectList(psoObjListVO));
			// vo.setList2(dbDao.searchOfficeObject1stList(psoObjListVO));
			// vo.setList3(dbDao.searchOfficeObject2stList(psoObjListVO));
			// vo.setList4(dbDao.searchOfficeObject3stList(psoObjListVO));

			// list.add(vo);

			// return list;
			return dbDao.searchObjectList(psoObjListVO);
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Object"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Object"}).getMessage(), ex);
		}
	}

	/**
	 * Office의 Object List를 조회한다.
	 * 
	 * @category VOP_PSO_0208_OfficeObjectList
	 * @param String ofcCd
	 * @return List<PsoObjListVO>
	 */
	@Override
	public List<PsoObjListVO> searchOfficeObjectList(String ofcCd)
			throws EventException {
		// TODO Auto-generated method stub
		List<PsoObjListVO> list = new ArrayList<PsoObjListVO>();
		List<PsoObjListVO> list1 = new ArrayList<PsoObjListVO>();
		List<PsoObjListVO> list2 = new ArrayList<PsoObjListVO>();
		List<PsoObjListVO> list3 = new ArrayList<PsoObjListVO>();
		PsoObjListVO vo = new PsoObjListVO();
		PsoObjListVO rvo = null;
		try {
			List<PsoObjListVO> lst = dbDao.searchOfficeObjectList(ofcCd);
			
			// 1~3row를 분리하여 저장한다.
			for (int i = 0; i < lst.size(); i++) {
				rvo = lst.get(i);
				if (rvo.getRowNo().equals("1"))
					list1.add(rvo);
				else if (rvo.getRowNo().equals("2"))
					list2.add(rvo);
				else if (rvo.getRowNo().equals("3"))
					list3.add(rvo);
			}
			vo.setList1(list1);
			vo.setList2(list2);
			vo.setList3(list3);
			list.add(vo);
			return list;
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Object"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Object"}).getMessage(), ex);
		}
	}


	/**
	 *  base tariff의 formula를 가져온다.
	 * @category VOP_PSO_0002_Retrieve
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @return List<TariffBaseVO>
	 * @throws EventException
	 */
	public List<TariffBaseVO> searchBaseTariff(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchBaseTariff(portTariffCodeGRPVO);
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Formula"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Formula"}).getMessage(), ex);
		}
	}


	/**
	 *  base tariff의 condition를 가져온다.
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @return List<ConditionVO>
	 * @throws EventException
	 */
	public List<ConditionVO> searchBaseCondition(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchBaseCondition(portTariffCodeGRPVO);
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Condition"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Condition"}).getMessage(), ex);
		}
	}


	/**
	 *  search formula & conditon의 condition을 가져온다.
	 * @param UseStatusConForVO useStatusConForVO
	 * @return List<UseStatusConditonFormulaVO>
	 * @throws EventException
	 */
	public List<UseStatusConditonFormulaVO>  searchUseStatusConditon( UseStatusConForVO useStatusConForVO ) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchUseStatusConditon(useStatusConForVO);
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Condition"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Condition"}).getMessage(), ex);
		}
	}
	

	/**
	 *    search formula & conditon의 formula를 가져온다.
	 * @param UseStatusConForVO useStatusConForVO
	 * @return List<UseStatusConditonFormulaVO>
	 * @throws EventException
	 */
	public List<UseStatusConditonFormulaVO>  searchUseStatusFormulaDetaill( UseStatusConForVO useStatusConForVO ) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchUseStatusFormulaDetaill(useStatusConForVO);
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Formula"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Formula"}).getMessage(), ex);
		}
	}
	/**
	 * search formula & conditon의 formula를 가져온다.
	 * @param  UseStatusConForVO useStatusConForVO
	 * @return List<UseStatusConditonFormulaVO>
	 * @throws EventException
	 */
	public List<UseStatusConditonFormulaVO>  searchUseStatusFormula( UseStatusConForVO useStatusConForVO ) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchUseStatusFormula(useStatusConForVO);
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Formula"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Formula"}).getMessage(), ex);
		}
	}
	
	/**
	 * TariffList의 version 정보를 조회한다.
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @param String uid
	 * @return List<TariffListGRPVO>
	 * @exception EventException
	 */
	public List<TariffListGRPVO> searchEffectiveDateList(PortTariffCodeGRPVO portTariffCodeGRPVO, String uid) throws EventException {
		// TODO Auto-generated method stub
		try {
			return  dbDao.searchEffectiveDateList(portTariffCodeGRPVO, uid);
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Version"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Version"}).getMessage(), ex);
		}
	}	
	

	/**
	 * TariffList copy 의 version 정보를 조회한다.
	 * @param String combo1
	 * @param String vndrSeq
	 * @param String acctCd
	 * @param String ofcCd
	 * @return List<TariffListGRPVO>
	 * @exception EventException
	 */
	public List<TariffListGRPVO> searchEffectiveDateList2( String combo1, String vndrSeq , String acctCd, String ofcCd ) throws EventException {
		// TODO Auto-generated method stub
		try {
			return  dbDao.searchEffectiveDateList2(combo1, vndrSeq , acctCd, ofcCd );
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Version"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Retrieval of Version"}).getMessage(), ex);
		}
	}	
	
	/**
	 *  Office 별 Favorite Object List의 CRUD처리
	 * @param psoObjListVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageOfficeObjectList(PsoObjListVO[] psoObjListVOs, SignOnUserAccount account)throws EventException {
		try {
			dbDao.removeOfficeObjectList(account.getOfc_cd());//로긴Ofce의 기등록 OjbectList를 삭제 한다.
			List<PsoObjListVO> insertVoList = new ArrayList<PsoObjListVO>();
			if(psoObjListVOs == null || psoObjListVOs.length==0) return;
			for ( int i=0; i<psoObjListVOs.length; i++ ) {
				if(!psoObjListVOs[i].getPsoObjCd().equals("")){
					psoObjListVOs[i].setCreUsrId(account.getUsr_id());
					psoObjListVOs[i].setPsoOfcCd(account.getOfc_cd());
					insertVoList.add(psoObjListVOs[i]);
				}
			}
			if(insertVoList.size() > 0 ){//처리건수가 1건이라 있으면 처리한다.
				dbDao.addOfficeObjectList(insertVoList);//신규 ObjectList를 등록한다.
			}
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011",new String[]{"Favorite Object List"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011",new String[]{"Favorite Object List"}).getMessage(), ex);
		}
	}

	/**
	 * Tariff 정보를 삭제한다.
	 * @category VOP_PSO_0002
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @throws EventException
	 */
	public void deletePortChargeSimple( PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException{
		
		/***************************************************************************************************************************************
		 * <Delete Sequence>
		 ***************************************************************************************************************************************
		 * 0. PSO_YD_CHG 존재 확인
		 * 1. PSO_YD_CHG_OBJ_LIST 데이터 삭제
		 * 2. PSO_TRF_DTL		  데이터 삭제	
		 * 3. PSO_TARIFF		  데이터 삭제	
		 * 4. PSO_CHG_XPR_DTL	  데이터 삭제
		 * 5. PSO_CHG_XPR		  데이터 삭제
		 * 6. PSO_YD_CHG_XPR	  데이터 삭제 	
		 * 7. PSO_YD_CHG		  데이터 삭제	
		 * 8. PSO_YD_CHG		  LST_FLG 업데이트
		 ***************************************************************************************************************************************/
		
		String vYdChgNo 	= portTariffCodeGRPVO.getYdChgNo();
		String vYdChgVerSeq	= portTariffCodeGRPVO.getCombo4();
		
		try {
			
			//0. PSO_YD_CHG 존재 확인 (RETURN : 0 or 1 row )
			List<PsoYdChgVO> resultPsoYdChg = dbDao.searchPsoYdChgByPK(vYdChgNo, vYdChgVerSeq);
			if(resultPsoYdChg == null || resultPsoYdChg.size() == 0){
				throw new EventException(new ErrorHandler("PSO90002", new String[]{}).getMessage());	//Data를 찾을 수 없습니다.
			} else{
				String resIssCtyCd = resultPsoYdChg.get(0).getCreUsrId();	//PSO_CHG_DTL 존재여부 (없으면  'X')
				if(!"X".equalsIgnoreCase(resIssCtyCd)){
					//삭제불가
					throw new EventException(new ErrorHandler("PSO91001", new String[]{}).getMessage());	//Invoice 존재-> PSO01001
				}
			}
			
			//1. PSO_YD_CHG_OBJ_LIST 데이터 삭제
			PsoYdChgObjListVO deletePsoYdChgObjListVO = new PsoYdChgObjListVO();
			deletePsoYdChgObjListVO.setYdChgNo(vYdChgNo);
			deletePsoYdChgObjListVO.setYdChgVerSeq(vYdChgVerSeq);
			deletePsoYdChgObjListVO.setObjListNo("");	//YardCharge 모두를 삭제하기 위해
			dbDao.removePsoYdChgObjList(deletePsoYdChgObjListVO);
			
			
			//2. PSO_TRF_DTL		  데이터 삭제	
			dbDao.removePsoTrfDtlByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");
			
			//3. PSO_TARIFF		 	 데이터 삭제
			dbDao.removePsoTariffByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");
			
			//4. PSO_CHG_XPR_DTL	  데이터 삭제
			dbDao.removePsoChgXprDtlByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");
			
			//5. PSO_CHG_XPR		  데이터 삭제
			dbDao.removePsoChgXprByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");
			
			//6. PSO_YD_CHG_XPR	  	데이터 삭제 	
			dbDao.removePsoYdChgXprByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");
			
			//7. PSO_YD_CHG		  	데이터 삭제	
			dbDao.removePsoYdChg(vYdChgNo, vYdChgVerSeq);
			
			//8. PSO_YD_CHG		  LST_FLG 업데이트
			dbDao.modifyPsoYdChgExpDtLstFlgByNo(vYdChgNo, "");
			
		} catch (EventException ex) {
			throw ex;	
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90012",new String[]{"Tariff"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90012",new String[]{"Tariff"}).getMessage(), ex);
		}
	}	
	
	/**
	 * Tariff 정보를 삭제한다.
	 * @category VOP_PSO_0004
	 * @param portTariffCodeGRPVO
	 * @throws EventException
	 */
	public void deletePortChargeComplex( PortTariffCodeGRPVO portTariffCodeGRPVO )throws EventException{
		
		/***************************************************************************************************************************************
		 * <Delete Sequence>
		 ***************************************************************************************************************************************
		 * 0. PSO_YD_CHG 존재 확인
		 * 1. PSO_YD_CHG_OBJ_LIST 데이터 삭제
		 * 2. PSO_TRF_DTL		  데이터 삭제	
		 * 3. PSO_TARIFF		  데이터 삭제	
		 * 4. PSO_CHG_XPR_DTL	  데이터 삭제
		 * 5. PSO_CHG_XPR		  데이터 삭제
		 * 6. PSO_YD_CHG_XPR	  데이터 삭제 	
		 * 7. PSO_YD_CHG		  데이터 삭제	
		 * 8. PSO_YD_CHG		  LST_FLG 업데이트
		 ***************************************************************************************************************************************/
		
		String vYdChgNo 	= portTariffCodeGRPVO.getYdChgNo();
		String vYdChgVerSeq	= portTariffCodeGRPVO.getCombo4();
		
		try {
			
			//0. PSO_YD_CHG 존재 확인 (RETURN : 0 or 1 row )
			List<PsoYdChgVO> resultPsoYdChg = dbDao.searchPsoYdChgByPK(vYdChgNo, vYdChgVerSeq);
			if(resultPsoYdChg == null || resultPsoYdChg.size() == 0){
				throw new EventException(new ErrorHandler("PSO90002", new String[]{}).getMessage());	//Data를 찾을 수 없습니다.
			} else{
				String resIssCtyCd = resultPsoYdChg.get(0).getCreUsrId();	//PSO_CHG_DTL 존재여부 (없으면  'X')
				//삭제불가
				if(!"X".equalsIgnoreCase(resIssCtyCd)){
					throw new EventException(new ErrorHandler("PSO91001", new String[]{}).getMessage());	//Invoice 존재-> PSO01001
				}
			}
			
			//1. PSO_YD_CHG_OBJ_LIST 데이터 삭제
			PsoYdChgObjListVO deletePsoYdChgObjListVO = new PsoYdChgObjListVO();
			deletePsoYdChgObjListVO.setYdChgNo(vYdChgNo);
			deletePsoYdChgObjListVO.setYdChgVerSeq(vYdChgVerSeq);
			deletePsoYdChgObjListVO.setObjListNo("");	//YardCharge 모두를 삭제하기 위해
			dbDao.removePsoYdChgObjList(deletePsoYdChgObjListVO);
			
			//2. PSO_TRF_DTL		  데이터 삭제	
			dbDao.removePsoTrfDtlByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");
			
			//3. PSO_TARIFF		 	 데이터 삭제
			dbDao.removePsoTariffByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");
			
			//4. PSO_CHG_XPR_DTL	  데이터 삭제
			dbDao.removePsoChgXprDtlByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");
			
			//5. PSO_CHG_XPR		  데이터 삭제
			dbDao.removePsoChgXprByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");
			
			//6. PSO_YD_CHG_XPR	  	데이터 삭제 	
			dbDao.removePsoYdChgXprByChgNoChgVerTpCd(vYdChgNo, vYdChgVerSeq, "ALL");
			
			//7. PSO_YD_CHG		  	데이터 삭제	
			dbDao.removePsoYdChg(vYdChgNo, vYdChgVerSeq);
			
			//8. PSO_YD_CHG		  LST_FLG 업데이트
			dbDao.modifyPsoYdChgExpDtLstFlgByNo(vYdChgNo, "");
			
		} catch (EventException ex) {
			throw ex;	
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90012",new String[]{"Tariff"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90012",new String[]{"Tariff"}).getMessage(), ex);
		}
	}	

	/**
	 * Tariff를 생성한다. (Tariff List)
	 * @category VOP_PSO_0002_SaveClick (jmh)
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @throws EventException
	 */
	public void managePortChargeSimple(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException{
		
		/***************************************************************************************************************************************
		 * <Save Sequence>
		 ***************************************************************************************************************************************
		 * 1. PSO_YD_CHG 테이블에 데이터 생성
		 * 2. PSO_YD_CHG_OBJ_LIST 테이블에 데이터 생성	*[2010.01.13] ReadOnly로 변경
		 * 3. PSO_TRF_DTL, PSO_TARIFF, PSO_CHG_XPR_DTL, PSO_CHG_XPR, PSO_YD_CHG_XPR 테이블의 이전 데이터 삭제 ("UPDATE"일 경우)
		 * 4. PSO_CHG_XPR, (PSO_CHG_XPR_DTL,) PSO_YD_CHG_XPR 테이블에 데이터 생성
		 * 		- FOML_NO와 COND_NO를 가지고 PSO_CHG_XPR_DTL 테이블에서 CHG_XPR_NO를 찾는다. (개발시 Fetch ROWNUM=1)
		 * 		- CHG_XPR_NO를 찾지 못하면 PSO_CHG_XPR 테이블에 데이터 생성, PSO_CHG_XPR_DTL 테이블(Simple화면에서는 CHG_XPR_SEQ=1)에 데이터 생성
		 * 		- PSO_YD_CHG_XPR 테이블에 의미상 Key의 중복여부를 체크하여 데이터를 생성 
		 * 5. (PSO_CHG_XPR_DTL,) PSO_TARIFF, PSO_TRF_DTL 테이블에 데이터 생성
		 * 6. PSO_CHG_XPR 테이블에 Description Update
		 ***************************************************************************************************************************************/

		try {
			//화면에서 넘어온 조건 (prefix = v)
			String vYdCd 		= portTariffCodeGRPVO.getPortCd() + portTariffCodeGRPVO.getCombo1();
			//String vAcctCd	 	= portTariffCodeGRPVO.getCombo2();
			String vCostCd	 	= portTariffCodeGRPVO.getCombo3();
			String vVndrSeq 	= portTariffCodeGRPVO.getVndrSeq();
			String vOrgVndrNm 	= portTariffCodeGRPVO.getOrgVndrNm();
			String vFromDate 	= portTariffCodeGRPVO.getFromDate().replace("-", "");	//YYYYMMDD
			String vToDate 		= portTariffCodeGRPVO.getToDate().replace("-", "");		//YYYYMMDD
			String vVersion		= portTariffCodeGRPVO.getCombo4();
			String vCurrency	= portTariffCodeGRPVO.getCombo5();
			String vYdChgNo 	= portTariffCodeGRPVO.getYdChgNo();
			String vCreUsrId 	= portTariffCodeGRPVO.getCreUsrId();
			//String vOfcCd	 	= portTariffCodeGRPVO.getOfcCd();
			String vCplsFlg	 	= portTariffCodeGRPVO.getCplsFlg();
			String portTrfUrl	= portTariffCodeGRPVO.getPortTrfUrl();
			String portTrfRmk	= portTariffCodeGRPVO.getPortTrfRmk();
			
			TariffBaseVO[] arrBase		= portTariffCodeGRPVO.getTariffBaseVOs();
			TariffBaseVO[] arrSurcharge	= portTariffCodeGRPVO.getTariffSurchargeVOs();
			TariffBaseVO[] arrDiscount	= portTariffCodeGRPVO.getTariffDiscountVOs();
			
			//화면에서 넘어온 조건, From sheet1 (prefix = sheet1_)
			//String sheet1_psoObjCd 			= "";			//[화면] Object
			//String sheet1_psoMeasUtCd 		= "";			//[화면] Unit of Measure
			String sheet1_objListNo 		= "";			//[화면] OBJ_LIST_NO
			String sheet1_psoTrfTpCd 		= "";			//[화면] Rate Type
			//String sheet1_dfltVal 			= "";			//[화면] Regular Value		*[2010.01.13] ReadOnly로 변경
			String sheet1_fomlNo 			= "";			//[서버] Formula
			String sheet1_condNo 			= "";			//[화면] Condition
			String sheet1_chgXprNo 			= "";			//[서버] CHG_XPR_NO
			String sheet1_chgXprSeq			= "";			//[서버] CHG_XPR_SEQ
			String sheet1_psoChgXprTpCd		= "";			//[서버] PSO_CHG_XPR_TP_CD
			String sheet1_psoCtrlStmtTpCd	= "";			//[서버] PSO_CTRL_STMT_TP_CD
			if(arrBase != null && arrBase.length > 0){
				//sheet1_psoObjCd 	= arrBase[0].getObject();
				//sheet1_psoMeasUtCd 	= arrBase[0].getObjectCode();
				sheet1_objListNo    = arrBase[0].getObjListNo();
				sheet1_psoTrfTpCd 	= arrBase[0].getRateCode();
				//sheet1_dfltVal 		= arrBase[0].getRegularValue();	//	*[2010.01.13] ReadOnly로 변경
				
				
				//Object, UOM, Rate Type을 이용하여 Formula No를 얻는다. 
				/*
				List<PsoFormulaVO> fomlNoList = dbDao.searchFomlNoByObjListNo(sheet1_psoObjCd, sheet1_psoMeasUtCd, sheet1_psoTrfTpCd);
				if(fomlNoList.size() > 0){
					sheet1_fomlNo 	= fomlNoList.get(0).getFomlNo();
				} else{
					throw new EventException(new ErrorHandler("PSO90002", new String[]{"[Formula No] "}).getMessage());	//Data를 찾을 수 없습니다.
				}
				*/
				
				//OBJ_LIST_NO, Rate Type을 이용하여 Formula No를 얻는다.
				List<PsoFormulaVO> fomlNoList = dbDao.searchFomlNoByObjAndType(sheet1_objListNo, sheet1_psoTrfTpCd);
				if(fomlNoList.size() > 0){
					sheet1_fomlNo 		= fomlNoList.get(0).getFomlNo();
				} else{
					throw new EventException(new ErrorHandler("PSO90002", new String[]{"[Formula No] "}).getMessage());	//Data를 찾을 수 없습니다.
				}
				
				sheet1_condNo 		= arrBase[0].getCondition();
				///////////////////////////////////////////////////////////
				//매번 신규데이터를 생성해야 함 (아래만 주석처리하면 PSO_CHG_XPR, PSO_YD_CHG_XPR, PSO_CHG_XPR_DTL 테이블에 데이터 생성됨)
				//Formula와 Condition을 이용하여 CHG_XPR_NO를 얻는다.
				//List<PsoChgXprDtlVO> checkPsoChgXprDtlVO = dbDao.searchChgXprNoByFomlCond(sheet1_fomlNo, sheet1_condNo);	//0 or 1row 반환
				//if(checkPsoChgXprDtlVO.size() > 0){
				//	sheet1_chgXprNo 	= checkPsoChgXprDtlVO.get(0).getChgXprNo();
				//	sheet1_chgXprSeq 	= checkPsoChgXprDtlVO.get(0).getChgXprSeq();
				//}
				///////////////////////////////////////////////////////////
				
				sheet1_psoChgXprTpCd = "".equals(sheet1_condNo) ? "1" : "2";	//Condition이 없으면 1, 있으면 2
				sheet1_psoCtrlStmtTpCd = "".equals(sheet1_condNo) ? "4" : "1";	//Condition이 없으면 4, 있으면 4
			}
			
			//화면에서 넘어온 조건, From sheet2 (prefix = sheet2_)
			String sheet2_chgXprNo 			= "";			//[서버] CHG_XPR_NO
			//String sheet2_chgXprSeq			= "";			//[서버] CHG_XPR_SEQ

			//화면에서 넘어온 조건, From sheet3 (prefix = sheet3_)
			String sheet3_chgXprNo 			= "";			//[서버] CHG_XPR_NO
			//String sheet3_chgXprSeq			= "";			//[서버] CHG_XPR_SEQ
			
			//Search PSO_YD_CHG By PK (prefix = res) [조회조건과 비교하여 CREATE/VERSIONUP/UPDATE 결정]
			String resIssCtyCd 	= "";
			String resFromDt 	= "";
			//String resToDt 		= "";
			String resLstFlg 	= "";
			
			//사용자 정의 GLOBAL VARIABLES (prefix = g)
			String gYdChgNo 		= "";
			String gYdChgVerSeq 	= "";
			
			/***************************************************************************************************************************************
			 * 1. PSO_YD_CHG 테이블에 데이터 생성
			 *************************************************************************************************************************************** 
			 * PSO_YD_CHG (의미상 KEY : [LGS_COST_CD, YD_CD, VNDR_SEQ, EFF_DT, EXP_DT]=[YD_CHG_NO])
			 * 	- 동일 LGS_COST_CD, YD_CD, VNDR_SEQ 끼리는 같은 EFF_DT~EXP_DT를 갖는다.	
			 * 	- 동일 LGS_COST_CD, YD_CD, VNDR_SEQ 끼리는 날짜가 Overlap될 수 없다.
			 *  - 동일 LGS_COST_CD, YD_CD           끼리는 같은 CURR_CD를 가져야 한다. [2010.03.19]
			 * 
			 * [CREATE]
			 *	1. 화면에서 보낸 조건(YD_CHG_NO, YD_CHG_VER_SEQ)의 데이터가 없는 경우 
			 *  2. 화면에서 보낸 조건(YD_CHG_NO, YD_CHG_VER_SEQ)의 데이터 존재시 From_Date가 변경되었을 때
			 * 		※ 동일 LGS_COST_CD/YD_CD/VNDR_SEQ의 MAX(EXP_DT)보다 From_Date가 커야 함.
			 * 
			 * [VERSION_UP]
			 * 	1. 화면에서 보낸 조건(YD_CHG_NO, YD_CHG_VER_SEQ)의 데이터 존재하고 PSO_CHG_DTL에도 있을 때 (최종 버전에 LST_FLG='Y', 나머지는 NULL로 업데이트)
			 * 
			 * [UPDATE]
			 * 	1. 일반 업데이트 조건 (To_Date가 변경되면 동일 NO의 다른 VERSION의 To_Date도 같은 날짜로 업데이트)
			 * 
			 * [DELETE]
			 * 	1. LST_FLG='Y' 이고 PSO_CHG_DTL 테이블에 없는 경우 삭제 가능 
			 ***************************************************************************************************************************************/
			
			//PSO_YD_CHG 존재 확인 (RETURN : 0 or 1 row )
			List<PsoYdChgVO> resultPsoYdChg = dbDao.searchPsoYdChgByPK(vYdChgNo, vVersion);
			
			String checkPsoYdChg = "";	//PSO_YD_CHG (CREATE/VERSIONUP/UPDATE)
			
			if(resultPsoYdChg.size() == 0){
				checkPsoYdChg = "CREATE";
			} else{
				resIssCtyCd = resultPsoYdChg.get(0).getCreUsrId();	//PSO_CHG_DTL 존재여부 (없으면  'X')
				resFromDt = resultPsoYdChg.get(0).getEffDt();	//YYYYMMDD
				//resToDt += resultPsoYdChg.get(0).getExpDt();		//YYYYMMDD
				resLstFlg = resultPsoYdChg.get(0).getLstFlg();
				
				if(!resFromDt.equals(vFromDate)){
					//checkPsoYdChg = "CREATE"; -> from date가 수정되는 경우 create가 아닌 version up 으로 변경
					checkPsoYdChg = "VERSION_UP";
				} else{
					if("X".equals(resIssCtyCd)){		//PSO_CHG_DTL 테이블에 없으면	
						checkPsoYdChg = "UPDATE";
					} else{								//PSO_CHG_DTL 테이블에 있으면
						checkPsoYdChg = "VERSION_UP";
					}
				}
			}
			
			//PSO_YD_CHG C/U/D 작업
			if(checkPsoYdChg.equals("CREATE")){
				
				//Cost,Yard,Vendor 별 MAX(EXP_DT) 구하기
				String maxExpDt = dbDao.searchPsoYdChgMaxExpDtByYdCostVndr(vCostCd, vYdCd, vVndrSeq);
				if(!"".equals(maxExpDt)){
					if(Integer.parseInt(vFromDate) <= Integer.parseInt(maxExpDt)){		//From_Date는 MAX(EXP_DT)보다 커야 한다.
						throw new EventException(new ErrorHandler("PSO99002", new String[]{}).getMessage());	//Effective Date의 시작일은 기입력된 데이터의 종료일보다 커야 합니다. (You should input the beginning date that is greater than the former data.)
					}
				}
				
				String newYdChgNo = dbDao.searchYardChgNumber().get(0).getYdChgNo();	//PSO_YD_CHG.YD_CHG_NO 채번
				
				PsoYdChgVO createPsoYdChgVO = new PsoYdChgVO();
				createPsoYdChgVO.setYdChgNo(newYdChgNo);
				createPsoYdChgVO.setYdChgVerSeq("1");		//Version 1
				createPsoYdChgVO.setLgsCostCd(vCostCd);
				createPsoYdChgVO.setYdCd(vYdCd);
				createPsoYdChgVO.setVndrSeq(vVndrSeq);
				createPsoYdChgVO.setEffDt(vFromDate);
				createPsoYdChgVO.setExpDt(vToDate);
				createPsoYdChgVO.setCurrCd(vCurrency);
				createPsoYdChgVO.setCplsFlg(vCplsFlg);
				createPsoYdChgVO.setOrgVndrNm(vOrgVndrNm);
				createPsoYdChgVO.setRltAgmtNo("");
				createPsoYdChgVO.setLstFlg("Y");
				createPsoYdChgVO.setCreUsrId(vCreUsrId);
				createPsoYdChgVO.setPortTrfUrl(portTrfUrl);
				createPsoYdChgVO.setPortTrfRmk(portTrfRmk);
				dbDao.addPsoYdChg(createPsoYdChgVO);		//새로운 No, 1 Version으로 Insert
				
				//PSO_YD_CHG 테이블의 PK
				gYdChgNo = newYdChgNo;
				gYdChgVerSeq = "1";
				
			} else if(checkPsoYdChg.equals("VERSION_UP")){
				
				String newYdChgVerSeq = dbDao.searchPsoYdChgVersionByNo(vYdChgNo);	//Version 채번
				
				PsoYdChgVO versionUpPsoYdChgVO = new PsoYdChgVO();
				versionUpPsoYdChgVO.setYdChgNo(vYdChgNo);
				versionUpPsoYdChgVO.setYdChgVerSeq(newYdChgVerSeq);
				versionUpPsoYdChgVO.setLgsCostCd(vCostCd);
				versionUpPsoYdChgVO.setYdCd(vYdCd);
				versionUpPsoYdChgVO.setVndrSeq(vVndrSeq);
				versionUpPsoYdChgVO.setEffDt(vFromDate);
				versionUpPsoYdChgVO.setExpDt(vToDate);
				versionUpPsoYdChgVO.setCurrCd(vCurrency);
				versionUpPsoYdChgVO.setCplsFlg(vCplsFlg);
				versionUpPsoYdChgVO.setOrgVndrNm(vOrgVndrNm);
				versionUpPsoYdChgVO.setRltAgmtNo("");
				versionUpPsoYdChgVO.setLstFlg("Y");
				versionUpPsoYdChgVO.setCreUsrId(vCreUsrId);
				versionUpPsoYdChgVO.setPortTrfUrl(portTrfUrl);
				versionUpPsoYdChgVO.setPortTrfRmk(portTrfRmk);				
				dbDao.addPsoYdChg(versionUpPsoYdChgVO);		//기존 No, 새로운 Version으로 Insert
				
				dbDao.modifyPsoYdChgExpDtLstFlgByNo(vYdChgNo, vToDate);	//EXP_DT,LST_FLG 바꾸기 
				
				//PSO_YD_CHG 테이블의 PK
				gYdChgNo = vYdChgNo;
				gYdChgVerSeq = newYdChgVerSeq;
				
			} else if(checkPsoYdChg.equals("UPDATE")){
				
				PsoYdChgVO updatePsoYdChgVO = new PsoYdChgVO();
				updatePsoYdChgVO.setYdChgNo(vYdChgNo);
				updatePsoYdChgVO.setYdChgVerSeq(vVersion);
				updatePsoYdChgVO.setLgsCostCd(vCostCd);
				updatePsoYdChgVO.setYdCd(vYdCd);
				updatePsoYdChgVO.setVndrSeq(vVndrSeq);
				updatePsoYdChgVO.setEffDt(vFromDate);
				updatePsoYdChgVO.setExpDt(vToDate);
				updatePsoYdChgVO.setCurrCd(vCurrency);
				updatePsoYdChgVO.setCplsFlg(vCplsFlg);
				updatePsoYdChgVO.setOrgVndrNm(vOrgVndrNm);
				updatePsoYdChgVO.setRltAgmtNo("");
				updatePsoYdChgVO.setLstFlg(resLstFlg);
				updatePsoYdChgVO.setCreUsrId(vCreUsrId);
				updatePsoYdChgVO.setPortTrfUrl(portTrfUrl);
				updatePsoYdChgVO.setPortTrfRmk(portTrfRmk);				
				dbDao.modifyPsoYdChg(updatePsoYdChgVO);	//UPDATE
				
				dbDao.modifyPsoYdChgExpDtLstFlgByNo(vYdChgNo, vToDate);	//EXP_DT,LST_FLG 바꾸기
				
				//PSO_YD_CHG 테이블의 PK
				gYdChgNo = vYdChgNo;
				gYdChgVerSeq = vVersion;
			}
			
			//[2010.03.19] 제약사항 체크 : PSO_YD_CHG (동일 Yard/Cost인 경우, 같은 CURR_CD를 가져야 한다. 값 입력후, 중복 Currency가 있는지 조사)
//			String[] arrCurr = dbDao.searchCurrByYardAndCost(vYdCd, vCostCd);
//			if(!"".equals(arrCurr[0])){
//				if(!arrCurr[0].equals(arrCurr[1])){
//					throw new EventException(new ErrorHandler("PSO90011", new String[]{"The currency is different from what is input as the same yard and cost before."}).getMessage());	//
//				}
//			}
			
			/***************************************************************************************************************************************
			 * 2. PSO_YD_CHG_OBJ_LIST 테이블에 데이터 생성	*[2010.01.13] ReadOnly로 변경
			 *************************************************************************************************************************************** 
			 *		- PSO_YD_CHG_OBJ_LIST 테이블 YardCharge별로 삭제한다. 
			 *		- PSO_OBJ_CD와 PSO_MEAS_UT_CD로 OBJ_LIST_NO를 구한다. (X)
			 *		- PSO_YD_CHG_OBJ_LIST 테이블에 Insert
			 ***************************************************************************************************************************************/
			/*
			//PSO_YD_CHG_OBJ_LIST 테이블 YardCharge별로 삭제한다. 
			PsoYdChgObjListVO deletePsoYdChgObjListVO = new PsoYdChgObjListVO();
			deletePsoYdChgObjListVO.setYdChgNo(gYdChgNo);
			deletePsoYdChgObjListVO.setYdChgVerSeq(gYdChgVerSeq);
			deletePsoYdChgObjListVO.setObjListNo("");	//YardCharge 모두를 삭제하기 위해
			dbDao.removePsoYdChgObjList(deletePsoYdChgObjListVO);
			
			if(arrBase != null && arrBase.length > 0){
				//PSO_OBJ_CD와 PSO_MEAS_UT_CD로 OBJ_LIST_NO를 구한다. [2009.11.17] 삭제
				//sheet1_objListNo = dbDao.searchObjListNoByObjUom(sheet1_psoObjCd, sheet1_psoMeasUtCd);
				//if("".equals(sheet1_objListNo)){
				//	throw new EventException(new ErrorHandler("PSO90002", new String[]{"[Object List No ] "}).getMessage());
				//}
				
				//PSO_YD_CHG_OBJ_LIST 테이블에 Insert
				PsoYdChgObjListVO insertPsoYdChgObjListVO = new PsoYdChgObjListVO();
				insertPsoYdChgObjListVO.setYdChgNo(gYdChgNo);
				insertPsoYdChgObjListVO.setYdChgVerSeq(gYdChgVerSeq);
				insertPsoYdChgObjListVO.setObjListNo(sheet1_objListNo);
				insertPsoYdChgObjListVO.setDfltCtnt("");
				insertPsoYdChgObjListVO.setDfltVal(sheet1_dfltVal);
				insertPsoYdChgObjListVO.setDfltFlg("");
				insertPsoYdChgObjListVO.setCreUsrId(vCreUsrId);
				dbDao.mergePsoYdChgObjList(insertPsoYdChgObjListVO);
			}
			*/
			
			/***************************************************************************************************************************************
			 * 3. PSO_TRF_DTL, PSO_TARIFF, PSO_CHG_XPR_DTL, PSO_CHG_XPR, PSO_YD_CHG_XPR 테이블의 이전 데이터 삭제
			 *************************************************************************************************************************************** 
			 *		- "UPDATE"일 경우, PSO_TRF_DTL, PSO_TARIFF, PSO_CHG_XPR_DTL, PSO_CHG_XPR, PSO_YD_CHG_XPR 삭제	 	
			 ***************************************************************************************************************************************/
			//
			if("UPDATE".equals(checkPsoYdChg)){	
				//PSO_TRF_DTL		 삭제
				dbDao.removePsoTrfDtlByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				//PSO_TARIFF 		삭제	
				dbDao.removePsoTariffByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				//PSO_CHG_XPR_DTL 	삭제
				dbDao.removePsoChgXprDtlByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				//PSO_CHG_XPR 		삭제
				dbDao.removePsoChgXprByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				//PSO_YD_CHG_XPR	삭제
				dbDao.removePsoYdChgXprByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
			}

			/***************************************************************************************************************************************
			 * 4. PSO_CHG_XPR, (PSO_CHG_XPR_DTL,) PSO_YD_CHG_XPR 테이블에 데이터 생성
			 *************************************************************************************************************************************** 
			 * 	[Base]
			 * 		- PSO_CHG_XPR 		채번, 신규
			 * 		- PSO_CHG_XPR_DTL 	신규
			 * 		- PSO_YD_CHG_XPR 	업데이트
			 * 	[Surcharge]
			 * 		- PSO_CHG_XPR 		채번, 신규
			 * 		- PSO_YD_CHG_XPR 	업데이트
			 * 	[Discount]
			 * 		- PSO_CHG_XPR 		채번, 신규
			 * 		- PSO_YD_CHG_XPR 	업데이트
			 ***************************************************************************************************************************************/
			//[Base]
			if(arrBase != null && arrBase.length > 0){
				if("".equals(sheet1_chgXprNo)){
					//PSO_CHG_XPR Insert (채번, 신규)
					sheet1_chgXprNo = dbDao.searchPsoChgXprPK();	//채번
					sheet1_chgXprSeq = "1";	//단순은 1
					PsoChgXprVO insertPsoChgXprVO = new PsoChgXprVO();
					insertPsoChgXprVO.setChgXprNo(sheet1_chgXprNo);
					insertPsoChgXprVO.setPsoChgXprTpCd(sheet1_psoChgXprTpCd);		//Condition 有 : 2, Condition 無 : 1
					//XPR_DESC, DFLT_XPR_DESC, SYS_XPR_DESC, DFLT_SYS_XPR_DESC 입력은 PSO_CHG_XPR_DTL 생성후 업데이트 처리함
					insertPsoChgXprVO.setUpdMnuNo("1");
					insertPsoChgXprVO.setCreUsrId(vCreUsrId);
					insertPsoChgXprVO.setUpdUsrId(vCreUsrId);
					dbDao.mergePsoChgXpr(insertPsoChgXprVO);		//신규
					
					//PSO_CHG_XPR_DTL Insert (신규)
					PsoChgXprDtlVO insertPsoChgXprDtlVO = new PsoChgXprDtlVO();
					insertPsoChgXprDtlVO.setChgXprNo(sheet1_chgXprNo);
					insertPsoChgXprDtlVO.setChgXprSeq("1");
					insertPsoChgXprDtlVO.setPsoCtrlStmtTpCd(sheet1_psoCtrlStmtTpCd);	//Condition 有 : 1, Condition 無 : 4  
					insertPsoChgXprDtlVO.setCondNo(sheet1_condNo);
					insertPsoChgXprDtlVO.setFomlNo(sheet1_fomlNo);
					insertPsoChgXprDtlVO.setCreUsrId(vCreUsrId);
					insertPsoChgXprDtlVO.setUpdUsrId(vCreUsrId);
					dbDao.mergePsoChgXprDtl(insertPsoChgXprDtlVO);
					
				}
				
				//PSO_YD_CHG_XPR (신규 or CHG_XPR_NO업데이트)
				PsoYdChgXprVO insertPsoYdChgXprVO = new PsoYdChgXprVO();
				insertPsoYdChgXprVO.setPsoChgTpCd("B");
				insertPsoYdChgXprVO.setYdChgNo(gYdChgNo);
				insertPsoYdChgXprVO.setYdChgVerSeq(gYdChgVerSeq);
				insertPsoYdChgXprVO.setChgXprNo(sheet1_chgXprNo);
				insertPsoYdChgXprVO.setCreUsrId(vCreUsrId);
				dbDao.mergePsoYdChgXprByFK(insertPsoYdChgXprVO);
			}
			
			//[Surcharge]
			if(arrSurcharge != null && arrSurcharge.length > 0){
				if("".equals(sheet2_chgXprNo)){
					//PSO_CHG_XPR Insert (채번, 신규)
					sheet2_chgXprNo = dbDao.searchPsoChgXprPK();	//채번
					//sheet2_chgXprSeq = "1";	//단순은 1
					PsoChgXprVO insertPsoChgXprVO = new PsoChgXprVO();
					insertPsoChgXprVO.setChgXprNo(sheet2_chgXprNo);
					insertPsoChgXprVO.setPsoChgXprTpCd("7");		//Surcharge, Discount는 7
					//XPR_DESC, DFLT_XPR_DESC, SYS_XPR_DESC, DFLT_SYS_XPR_DESC 입력要
					//insertPsoChgXprVO.setXprDesc(xprDesc)
					insertPsoChgXprVO.setUpdMnuNo("1");
					insertPsoChgXprVO.setCreUsrId(vCreUsrId);
					dbDao.mergePsoChgXpr(insertPsoChgXprVO);		//신규
				}
				
				//PSO_YD_CHG_XPR (신규 or CHG_XPR_NO업데이트)
				PsoYdChgXprVO insertPsoYdChgXprVO = new PsoYdChgXprVO();
				insertPsoYdChgXprVO.setPsoChgTpCd("S");
				insertPsoYdChgXprVO.setYdChgNo(gYdChgNo);
				insertPsoYdChgXprVO.setYdChgVerSeq(gYdChgVerSeq);
				insertPsoYdChgXprVO.setChgXprNo(sheet2_chgXprNo);
				insertPsoYdChgXprVO.setCreUsrId(vCreUsrId);
				dbDao.mergePsoYdChgXprByFK(insertPsoYdChgXprVO);
			}
			
			//[Discount]
			if(arrDiscount != null && arrDiscount.length > 0){
				if("".equals(sheet3_chgXprNo)){
					//PSO_CHG_XPR Insert (채번, 신규)
					sheet3_chgXprNo = dbDao.searchPsoChgXprPK();	//채번
					//sheet3_chgXprSeq += "1";	//단순은 1
					PsoChgXprVO insertPsoChgXprVO = new PsoChgXprVO();
					insertPsoChgXprVO.setChgXprNo(sheet3_chgXprNo);
					insertPsoChgXprVO.setPsoChgXprTpCd("7");		//Surcharge, Discount는 7
					//XPR_DESC, DFLT_XPR_DESC, SYS_XPR_DESC, DFLT_SYS_XPR_DESC 입력要
					//insertPsoChgXprVO.setXprDesc(xprDesc)
					insertPsoChgXprVO.setUpdMnuNo("1");
					insertPsoChgXprVO.setCreUsrId(vCreUsrId);
					dbDao.mergePsoChgXpr(insertPsoChgXprVO);		//신규
				}
				
				//PSO_YD_CHG_XPR (신규 or CHG_XPR_NO업데이트)
				PsoYdChgXprVO insertPsoYdChgXprVO = new PsoYdChgXprVO();
				insertPsoYdChgXprVO.setPsoChgTpCd("D");
				insertPsoYdChgXprVO.setYdChgNo(gYdChgNo);
				insertPsoYdChgXprVO.setYdChgVerSeq(gYdChgVerSeq);
				insertPsoYdChgXprVO.setChgXprNo(sheet3_chgXprNo);
				insertPsoYdChgXprVO.setCreUsrId(vCreUsrId);
				dbDao.mergePsoYdChgXprByFK(insertPsoYdChgXprVO);
			}
			
			/***************************************************************************************************************************************
			 * 5. (PSO_CHG_XPR_DTL,) PSO_TARIFF, PSO_TRF_DTL 테이블에 데이터 생성
			 *************************************************************************************************************************************** 
			 * 	[Base]
			 * 		- PSO_TARIFF 		채번, 신규
			 * 		- PSO_TRF_DTL	 	신규
			 * 	[Surcharge]
			 * 		- PSO_CHG_XPR_DTL	신규
			 * 		- PSO_TARIFF 		채번, 신규
			 * 		- PSO_TRF_DTL 		신규
			 * 	[Discount]
			 * 		- PSO_CHG_XPR_DTL	신규
			 * 		- PSO_TARIFF 		채번, 신규
			 * 		- PSO_TRF_DTL 		신규
			 ***************************************************************************************************************************************/
			//[Base]
			if(arrBase != null && arrBase.length > 0){ 
				
				//PSO_TARIFF 채번
				String newPortTrfNo = dbDao.searchPsoTariffPK();
				//PSO_TARIFF 입력
				List<PsoTariffVO> insertPsoTariffVOList = new ArrayList<PsoTariffVO>();
				PsoTariffVO insertPsoTariffVO = new PsoTariffVO();
				insertPsoTariffVO.setPortTrfNo(newPortTrfNo);
				insertPsoTariffVO.setPsoTrfTpCd(sheet1_psoTrfTpCd);
				insertPsoTariffVO.setFomlNo(sheet1_fomlNo);
				insertPsoTariffVO.setFomlSeq("1");			//단순은 1
				insertPsoTariffVO.setChgXprNo(sheet1_chgXprNo);
				insertPsoTariffVO.setChgXprSeq(sheet1_chgXprSeq);
				insertPsoTariffVO.setObjListNo(sheet1_objListNo);
				insertPsoTariffVO.setCurrCd(vCurrency);
				insertPsoTariffVO.setPsoRtTpCd(null);
				insertPsoTariffVO.setDpNo("10");
				insertPsoTariffVO.setCreUsrId(vCreUsrId);
				insertPsoTariffVOList.add(insertPsoTariffVO);
				dbDao.addTariff(insertPsoTariffVOList);
				
				//PSO_TRF_DTL 입력
				for(int i=0; i<arrBase.length; i++){
					PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					insertPsoTrfDtlVO.setTrfSeq(i + 1 + "");
					insertPsoTrfDtlVO.setFmVal(arrBase[i].getRangeFrom().replace(":", "").replace(",", ""));	//From Value
					insertPsoTrfDtlVO.setToVal(arrBase[i].getRangeTo().replace(":", "").replace(",", ""));		//To   Value
					insertPsoTrfDtlVO.setTrfRtAmt(arrBase[i].getRateValue());
					insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					insertPsoTrfDtlVO.setCondNo(sheet1_condNo);
					dbDao.addPsoTrfDtl(insertPsoTrfDtlVO);
				}
				
			}
			
			//[Surcharge]
			if(arrSurcharge != null && arrSurcharge.length > 0){ 
				
				for(int i=0; i<arrSurcharge.length; i++){
					//PSO_CHG_XPR_DTL Insert (신규)
					PsoChgXprDtlVO insertPsoChgXprDtlVO = new PsoChgXprDtlVO();
					insertPsoChgXprDtlVO.setChgXprNo(sheet2_chgXprNo);
					insertPsoChgXprDtlVO.setChgXprSeq(i + 1 + "");
					insertPsoChgXprDtlVO.setPsoCtrlStmtTpCd(arrSurcharge[i].getSumOption());
					insertPsoChgXprDtlVO.setCondNo(arrSurcharge[i].getCondition());
					insertPsoChgXprDtlVO.setFomlNo(arrSurcharge[i].getFormulaNo());
					insertPsoChgXprDtlVO.setCreUsrId(vCreUsrId);
					dbDao.mergePsoChgXprDtl(insertPsoChgXprDtlVO);
		
					//PSO_TARIFF 채번
					String newPortTrfNo = dbDao.searchPsoTariffPK();
					//PSO_TARIFF 입력
					List<PsoTariffVO> insertPsoTariffVOList = new ArrayList<PsoTariffVO>();
					PsoTariffVO insertPsoTariffVO = new PsoTariffVO();
					insertPsoTariffVO.setPortTrfNo(newPortTrfNo);
					insertPsoTariffVO.setPsoTrfTpCd(null);
					insertPsoTariffVO.setFomlNo(arrSurcharge[i].getFormulaNo());
					insertPsoTariffVO.setFomlSeq("1");			//단순은 1
					insertPsoTariffVO.setChgXprNo(sheet2_chgXprNo);
					insertPsoTariffVO.setChgXprSeq(i + 1 + "");
					insertPsoTariffVO.setObjListNo(null);
					insertPsoTariffVO.setCurrCd(vCurrency);
					insertPsoTariffVO.setPsoRtTpCd(arrSurcharge[i].getMethodCode());
					insertPsoTariffVO.setDpNo("10");
					insertPsoTariffVO.setCreUsrId(vCreUsrId);
					insertPsoTariffVOList.add(insertPsoTariffVO);
					dbDao.addTariff(insertPsoTariffVOList);
					
					//PSO_TRF_DTL 입력
					PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					insertPsoTrfDtlVO.setTrfSeq("1");
					insertPsoTrfDtlVO.setFmVal(null);
					insertPsoTrfDtlVO.setToVal(null);
					insertPsoTrfDtlVO.setTrfRtAmt(arrSurcharge[i].getRateValue());
					insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					insertPsoTrfDtlVO.setCondNo(null);
					dbDao.addPsoTrfDtl(insertPsoTrfDtlVO);
				}
				
			}			

			//[Discount]	
			if(arrDiscount != null && arrDiscount.length > 0){ 
				
				for(int i=0; i<arrDiscount.length; i++){
					//PSO_CHG_XPR_DTL Insert (신규)
					PsoChgXprDtlVO insertPsoChgXprDtlVO = new PsoChgXprDtlVO();
					insertPsoChgXprDtlVO.setChgXprNo(sheet3_chgXprNo);
					insertPsoChgXprDtlVO.setChgXprSeq(i + 1 + "");
					insertPsoChgXprDtlVO.setPsoCtrlStmtTpCd(arrDiscount[i].getSumOption());
					insertPsoChgXprDtlVO.setCondNo(arrDiscount[i].getCondition());
					insertPsoChgXprDtlVO.setFomlNo(arrDiscount[i].getFormulaNo());
					insertPsoChgXprDtlVO.setCreUsrId(vCreUsrId);
					dbDao.mergePsoChgXprDtl(insertPsoChgXprDtlVO);
					
					//PSO_TARIFF 채번
					String newPortTrfNo = dbDao.searchPsoTariffPK();
					//PSO_TARIFF 입력
					List<PsoTariffVO> insertPsoTariffVOList = new ArrayList<PsoTariffVO>();
					PsoTariffVO insertPsoTariffVO = new PsoTariffVO();
					insertPsoTariffVO.setPortTrfNo(newPortTrfNo);
					insertPsoTariffVO.setPsoTrfTpCd(null);
					insertPsoTariffVO.setFomlNo(arrDiscount[i].getFormulaNo());
					insertPsoTariffVO.setFomlSeq("1");			//단순은 1
					insertPsoTariffVO.setChgXprNo(sheet3_chgXprNo);
					insertPsoTariffVO.setChgXprSeq(i + 1 + "");
					insertPsoTariffVO.setObjListNo(null);
					insertPsoTariffVO.setCurrCd(vCurrency);
					insertPsoTariffVO.setPsoRtTpCd(arrDiscount[i].getMethodCode());
					insertPsoTariffVO.setDpNo("10");
					insertPsoTariffVO.setCreUsrId(vCreUsrId);
					insertPsoTariffVOList.add(insertPsoTariffVO);
					dbDao.addTariff(insertPsoTariffVOList);
					
					//PSO_TRF_DTL 입력
					PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					insertPsoTrfDtlVO.setTrfSeq("1");
					insertPsoTrfDtlVO.setFmVal(null);
					insertPsoTrfDtlVO.setToVal(null);
					insertPsoTrfDtlVO.setTrfRtAmt(arrDiscount[i].getRateValue());
					insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					insertPsoTrfDtlVO.setCondNo(null);
					dbDao.addPsoTrfDtl(insertPsoTrfDtlVO);
				}
			}	
			/***************************************************************************************************************************************
			 * 6. PSO_CHG_XPR 테이블에 Description Update
			 *************************************************************************************************************************************** 
			 * 	[Base]
			 * 		- PSO_CHG_XPR 		Description Update
			 * 	[Surcharge]
			 * 		- PSO_CHG_XPR 		Description Update
			 * 	[Discount]
			 * 		- PSO_CHG_XPR 		Description Update
			 ***************************************************************************************************************************************/
			//[Base]	
			if(arrBase != null && arrBase.length > 0){ 
				if(dbDao.modifyChgXprDescByChgXprNo(sheet1_chgXprNo) < 1){
					throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invalid Expression Description, Base"}).getMessage());	//Unexpected Error Occurred.
				}
			}

			//[Surcharge]	
			if(arrSurcharge != null && arrSurcharge.length > 0){ 
				if(dbDao.modifyChgXprDescByChgXprNo(sheet2_chgXprNo) < 1){
					throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invalid Expression Description, Surcharge"}).getMessage());	//Unexpected Error Occurred.
				}
			}
			
			//[Discount]	
			if(arrDiscount != null && arrDiscount.length > 0){ 
				if(dbDao.modifyChgXprDescByChgXprNo(sheet3_chgXprNo) < 1){
					throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invalid Expression Description, Discount"}).getMessage());	//Unexpected Error Occurred.
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Tariff Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Tariff Creation"}).getMessage(), de);
		}
	}	

	/**
	 * Tariff를 생성한다. (Formula Selection)
	 * @category VOP_PSO_0004_SaveClick (jmh)
	 * @param PortTariffCodeGRPVO portTariffCodeGRPVO
	 * @throws EventException
	 */
	public void managePortChargeComplex(PortTariffCodeGRPVO portTariffCodeGRPVO) throws EventException{
		
		/***************************************************************************************************************************************
		 * <Save Sequence>
		 ***************************************************************************************************************************************
		 * 1. PSO_YD_CHG 테이블에 데이터 생성
		 * 2. PSO_YD_CHG_OBJ_LIST 테이블에 데이터 생성	*[2010.01.13] ReadOnly로 변경
		 * 3. PSO_TRF_DTL, PSO_TARIFF, PSO_CHG_XPR_DTL, PSO_CHG_XPR, PSO_YD_CHG_XPR 테이블의 이전 데이터 삭제 ("UPDATE"일 경우)
		 * 4. PSO_CHG_XPR, (PSO_CHG_XPR_DTL,) PSO_YD_CHG_XPR 테이블에 데이터 생성
		 * 		- FOML_NO와 COND_NO를 가지고 PSO_CHG_XPR_DTL 테이블에서 CHG_XPR_NO를 찾는다. (개발시 Fetch ROWNUM=1)
		 * 		- CHG_XPR_NO를 찾지 못하면 PSO_CHG_XPR 테이블에 데이터 생성, PSO_CHG_XPR_DTL 테이블(Simple화면에서는 CHG_XPR_SEQ=1)에 데이터 생성
		 * 		- PSO_YD_CHG_XPR 테이블에 의미상 Key의 중복여부를 체크하여 데이터를 생성 
		 * 5. (PSO_CHG_XPR_DTL,) PSO_TARIFF, PSO_TRF_DTL 테이블에 데이터 생성
		 * 6. PSO_CHG_XPR 테이블에 Description Update
		 ***************************************************************************************************************************************/
		
		try {
			//화면에서 넘어온 조건 (prefix = v)
			String vYdCd 		= portTariffCodeGRPVO.getPortCd() + portTariffCodeGRPVO.getCombo1();
			//String vAcctCd	 	= portTariffCodeGRPVO.getCombo2();
			String vCostCd	 	= portTariffCodeGRPVO.getCombo3();
			String vVndrSeq 	= portTariffCodeGRPVO.getVndrSeq();
			String vOrgVndrNm 	= portTariffCodeGRPVO.getOrgVndrNm();
			String vFromDate 	= portTariffCodeGRPVO.getFromDate().replace("-", "");	//YYYYMMDD
			String vToDate 		= portTariffCodeGRPVO.getToDate().replace("-", "");		//YYYYMMDD
			String vVersion		= portTariffCodeGRPVO.getCombo4();
			String vCurrency	= portTariffCodeGRPVO.getCombo5();
			String vYdChgNo 	= portTariffCodeGRPVO.getYdChgNo();
			String vCreUsrId 	= portTariffCodeGRPVO.getCreUsrId();
			//String vOfcCd	 	= portTariffCodeGRPVO.getOfcCd();		//등록된 Yard/Cost/Vendor 조회
			String vCplsFlg	 	= portTariffCodeGRPVO.getCplsFlg();
			String portTrfUrl	= portTariffCodeGRPVO.getPortTrfUrl();
			String portTrfRmk	= portTariffCodeGRPVO.getPortTrfRmk();
			
			TariffBaseVO[] arrBaseFomlCond	= portTariffCodeGRPVO.getTariffBaseFomlCondVOs();
			//TariffBaseVO[] arrBaseRegVal	= portTariffCodeGRPVO.getTariffBaseRegValVOs();		//[2010.01.13:ReadOnly로 변경] -> *[2011.11.10] Version up 시 insert 되도록 변경
			TariffBaseVO[] arrBase			= portTariffCodeGRPVO.getTariffBaseVOs();
			TariffBaseVO[] arrSurcharge		= portTariffCodeGRPVO.getTariffSurchargeVOs();
			TariffBaseVO[] arrDiscount		= portTariffCodeGRPVO.getTariffDiscountVOs();
			
			//화면에서 넘어온 조건, From sheet1 (prefix = sheet1_)
			String sheet1_uk 				= "";			//[화면] UK
			String sheet1_fomlNo 			= "";			//[화면] Formula
			String sheet1_condNo 			= "";			//[화면] Condition
			String sheet1_chgXprNo 			= "";			//[서버] CHG_XPR_NO
			String sheet1_psoChgXprTpCd		= "";			//[서버] PSO_CHG_XPR_TP_CD
			String sheet1_dfltFomlFlg		= "";			//[화면] DFLT_FOML_FLG
			String sheet1_psoCtrlStmtTpCd	= "";			//[서버] PSO_CTRL_STMT_TP_CD

			//화면에서 넘어온 조건, From sheet3 (prefix = sheet3_)
			//String sheet3_objListNo		= "";			//[서버]		[2010.01.13:ReadOnly로 변경] -> *[2011.11.10] Version up 시 insert 되도록 변경
			//String sheet3_dfltVal		= "";			//[화면]		[2010.01.13:ReadOnly로 변경] -> *[2011.11.10] Version up 시 insert 되도록 변경
			
			//화면에서 넘어온 조건, From sheet4 (prefix = sheet4_)
			String sheet4_chgXprNo 			= "";			//[서버] CHG_XPR_NO
			//String sheet4_chgXprSeq			= "";			//[서버] CHG_XPR_SEQ

			//화면에서 넘어온 조건, From sheet5 (prefix = sheet5_)
			String sheet5_chgXprNo 			= "";			//[서버] CHG_XPR_NO
			//String sheet5_chgXprSeq			= "";			//[서버] CHG_XPR_SEQ
			
			//화면에서 넘어온 조건, From sheet6 (prefix = sheet6_)
			String sheet6_uk 				= "";			//[화면] UK
			String sheet6_seq 				= "";			//[화면] Seq
			//String sheet6_psoObjCd 			= "";			//[화면] Object
			//String sheet6_psoMeasUtCd 		= "";			//[화면] Unit of Measure
			String sheet6_objListNo 		= "";			//[화면] OBJ_LIST_NO
			String sheet6_psoTrfTpCd 		= "";			//[화면] Rate Type
			String sheet6_fomlNo 			= "";			//[서버] Formula
			String sheet6_condNo 			= "";			//[화면] Condition
			String sheet6_fmVal 			= "";			//[화면] FM_VAL
			String sheet6_toVal				= "";			//[화면] TO_VAL
			String sheet6_trfRtAmt			= "";			//[화면] TRF_RT_AMT
			String sheet6_consAlsNm			= "";			//[화면] CONS_ALS_NM
			
			//Sheet1의 UK와 PSO_CHG_XPR_DTL.CHG_XPR_SEQ 연결하는 Hash
			HashMap<String, String> hashUkChgXprSeq = new HashMap<String, String>();	//key:화면UK, value:PSO_CHG_XPR_DTL.CHG_XPR_SEQ (PSO_CHG_XPR_DTL.CHG_XPR_NO=sheet1_chgXprNo는 한개이므로) 
			HashMap<String, HashMap<String, String>> hashUkSeqTrfSeq 	= new HashMap<String, HashMap<String, String>>();	//Hash의 Hash, key:화면UK, key:화면Seq, value:PSO_TARIFF.TRF_NO_SEQ 

			//PSO_TARIFF:Base 저장시, Formula에 속한 Object인지 체크하기 위해
			HashMap<String, String> hashUkObject = new HashMap<String, String>();	//key:화면UK, value:Formula에 속한 Object(,1,2,3,)  
			
			//Search PSO_YD_CHG By PK (prefix = res) [조회조건과 비교하여 CREATE/VERSIONUP/UPDATE 결정]
			String resIssCtyCd 	= "";
			String resFromDt 	= "";
			//String resToDt 		= "";
			String resLstFlg 	= "";
			
			//사용자 정의 GLOBAL VARIABLES (prefix = g)
			String gYdChgNo 		= "";
			String gYdChgVerSeq 	= "";
			
			//Version Up시 생성될 yd_chg_ver_seq
			String newYdChgVerSeq = "";
			
			/***************************************************************************************************************************************
			 * 1. PSO_YD_CHG 테이블에 데이터 생성
			 *************************************************************************************************************************************** 
			 * PSO_YD_CHG (의미상 KEY : [LGS_COST_CD, YD_CD, VNDR_SEQ, EFF_DT, EXP_DT]=[YD_CHG_NO])
			 * 	- 동일 LGS_COST_CD, YD_CD, VNDR_SEQ 끼리는 같은 EFF_DT~EXP_DT를 갖는다.	
			 * 	- 동일 LGS_COST_CD, YD_CD, VNDR_SEQ 끼리는 날짜가 Overlap될 수 없다.	
			 *  - 동일 LGS_COST_CD, YD_CD           끼리는 같은 CURR_CD를 가져야 한다. [2010.03.19]
			 * 
			 * [CREATE]
			 *	1. 화면에서 보낸 조건(YD_CHG_NO, YD_CHG_VER_SEQ)의 데이터가 없는 경우 
			 *  2. 화면에서 보낸 조건(YD_CHG_NO, YD_CHG_VER_SEQ)의 데이터 존재시 From_Date가 변경되었을 때
			 * 		※ 동일 LGS_COST_CD/YD_CD/VNDR_SEQ의 MAX(EXP_DT)보다 From_Date가 커야 함.
			 * 
			 * [VERSION_UP]
			 * 	1. 화면에서 보낸 조건(YD_CHG_NO, YD_CHG_VER_SEQ)의 데이터 존재하고 PSO_CHG_DTL에도 있을 때 (최종 버전에 LST_FLG='Y', 나머지는 NULL로 업데이트)
			 * 
			 * [UPDATE]
			 * 	1. 일반 업데이트 조건 (To_Date가 변경되면 동일 NO의 다른 VERSION의 To_Date도 같은 날짜로 업데이트)
			 * 
			 * [DELETE]
			 * 	1. LST_FLG='Y' 이고 PSO_CHG_DTL 테이블에 없는 경우 삭제 가능 
			 ***************************************************************************************************************************************/
			//PSO_YD_CHG 존재 확인 (RETURN : 0 or 1 row )
			List<PsoYdChgVO> resultPsoYdChg = dbDao.searchPsoYdChgByPK(vYdChgNo, vVersion);
			
			String checkPsoYdChg = "";	//PSO_YD_CHG (CREATE/VERSIONUP/UPDATE)
			
			
			if(resultPsoYdChg.size() == 0){
				checkPsoYdChg = "CREATE";
			} else{
				resIssCtyCd = resultPsoYdChg.get(0).getCreUsrId();	//PSO_CHG_DTL 존재여부 (없으면  'X')
				resFromDt = resultPsoYdChg.get(0).getEffDt();	//YYYYMMDD
				//resToDt += resultPsoYdChg.get(0).getExpDt();		//YYYYMMDD
				resLstFlg = resultPsoYdChg.get(0).getLstFlg();
				
			
				
				if(!resFromDt.equals(vFromDate)){
					//checkPsoYdChg = "CREATE"; -> from date가 수정되는 경우 create가 아닌 version up 으로 변경
					checkPsoYdChg = "VERSION_UP";
				} else{
					if("X".equals(resIssCtyCd)){		//PSO_CHG_DTL 테이블에 없으면
						checkPsoYdChg = "UPDATE";
					} else{								//PSO_CHG_DTL 테이블에 있으면
						checkPsoYdChg = "VERSION_UP";
					}
				}
			}
			
			
			//PSO_YD_CHG C/U/D 작업
			if(checkPsoYdChg.equals("CREATE")){
				
				//Cost,Yard,Vendor 별 MAX(EXP_DT) 구하기
				String maxExpDt = dbDao.searchPsoYdChgMaxExpDtByYdCostVndr(vCostCd, vYdCd, vVndrSeq);
				if(!"".equals(maxExpDt)){
					if(Integer.parseInt(vFromDate) <= Integer.parseInt(maxExpDt)){		//From_Date는 MAX(EXP_DT)보다 커야 한다.
						throw new EventException(new ErrorHandler("PSO99002", new String[]{}).getMessage());	//Effective Date의 시작일은 기입력된 데이터의 종료일보다 커야 합니다. (You should input the beginning date that is greater than the former data.)	
					}
				}
				
				String newYdChgNo = dbDao.searchYardChgNumber().get(0).getYdChgNo();	//PSO_YD_CHG.YD_CHG_NO 채번
				
				PsoYdChgVO createPsoYdChgVO = new PsoYdChgVO();
				createPsoYdChgVO.setYdChgNo(newYdChgNo);
				createPsoYdChgVO.setYdChgVerSeq("1");		//Version 1
				createPsoYdChgVO.setLgsCostCd(vCostCd);
				createPsoYdChgVO.setYdCd(vYdCd);
				createPsoYdChgVO.setVndrSeq(vVndrSeq);
				createPsoYdChgVO.setEffDt(vFromDate);
				createPsoYdChgVO.setExpDt(vToDate);
				createPsoYdChgVO.setCurrCd(vCurrency);
				createPsoYdChgVO.setCplsFlg(vCplsFlg);
				createPsoYdChgVO.setOrgVndrNm(vOrgVndrNm);
				createPsoYdChgVO.setRltAgmtNo("");
				createPsoYdChgVO.setLstFlg("Y");
				createPsoYdChgVO.setCreUsrId(vCreUsrId);
				createPsoYdChgVO.setPortTrfUrl(portTrfUrl);
				createPsoYdChgVO.setPortTrfRmk(portTrfRmk);				
				dbDao.addPsoYdChg(createPsoYdChgVO);		//새로운 No, 1 Version으로 Insert
				
				//PSO_YD_CHG 테이블의 PK
				gYdChgNo = newYdChgNo;
				gYdChgVerSeq = "1";
				
			} else if(checkPsoYdChg.equals("VERSION_UP")){
				
				newYdChgVerSeq = dbDao.searchPsoYdChgVersionByNo(vYdChgNo);	//Version 채번
				
				PsoYdChgVO versionUpPsoYdChgVO = new PsoYdChgVO();
				versionUpPsoYdChgVO.setYdChgNo(vYdChgNo);
				versionUpPsoYdChgVO.setYdChgVerSeq(newYdChgVerSeq);
				versionUpPsoYdChgVO.setLgsCostCd(vCostCd);
				versionUpPsoYdChgVO.setYdCd(vYdCd);
				versionUpPsoYdChgVO.setVndrSeq(vVndrSeq);
				versionUpPsoYdChgVO.setEffDt(vFromDate);
				versionUpPsoYdChgVO.setExpDt(vToDate);
				versionUpPsoYdChgVO.setCurrCd(vCurrency);
				versionUpPsoYdChgVO.setCplsFlg(vCplsFlg);
				versionUpPsoYdChgVO.setOrgVndrNm(vOrgVndrNm);
				versionUpPsoYdChgVO.setRltAgmtNo("");
				versionUpPsoYdChgVO.setLstFlg("Y");
				versionUpPsoYdChgVO.setCreUsrId(vCreUsrId);
				versionUpPsoYdChgVO.setPortTrfUrl(portTrfUrl);
				versionUpPsoYdChgVO.setPortTrfRmk(portTrfRmk);				
				dbDao.addPsoYdChg(versionUpPsoYdChgVO);		//기존 No, 새로운 Version으로 Insert
				
				dbDao.modifyPsoYdChgExpDtLstFlgByNo(vYdChgNo, vToDate);	//EXP_DT,LST_FLG 바꾸기 
				
				//PSO_YD_CHG 테이블의 PK
				gYdChgNo = vYdChgNo;
				gYdChgVerSeq = newYdChgVerSeq;
				
			} else if(checkPsoYdChg.equals("UPDATE")){
				
				PsoYdChgVO updatePsoYdChgVO = new PsoYdChgVO();
				updatePsoYdChgVO.setYdChgNo(vYdChgNo);
				updatePsoYdChgVO.setYdChgVerSeq(vVersion);
				updatePsoYdChgVO.setLgsCostCd(vCostCd);
				updatePsoYdChgVO.setYdCd(vYdCd);
				updatePsoYdChgVO.setVndrSeq(vVndrSeq);
				updatePsoYdChgVO.setEffDt(vFromDate);
				updatePsoYdChgVO.setExpDt(vToDate);
				updatePsoYdChgVO.setCurrCd(vCurrency);
				updatePsoYdChgVO.setCplsFlg(vCplsFlg);
				updatePsoYdChgVO.setOrgVndrNm(vOrgVndrNm);
				updatePsoYdChgVO.setRltAgmtNo("");
				updatePsoYdChgVO.setLstFlg(resLstFlg);
				updatePsoYdChgVO.setCreUsrId(vCreUsrId);
				updatePsoYdChgVO.setPortTrfUrl(portTrfUrl);
				updatePsoYdChgVO.setPortTrfRmk(portTrfRmk);								
				dbDao.modifyPsoYdChg(updatePsoYdChgVO);	//UPDATE
				
				dbDao.modifyPsoYdChgExpDtLstFlgByNo(vYdChgNo, vToDate);	//EXP_DT,LST_FLG 바꾸기
				
				//PSO_YD_CHG 테이블의 PK
				gYdChgNo = vYdChgNo;
				gYdChgVerSeq = vVersion;
			}
			
			//[2010.03.19] 제약사항 체크 : PSO_YD_CHG (동일 Yard/Cost인 경우, 같은 CURR_CD를 가져야 한다. 값 입력후, 중복 Currency가 있는지 조사)
//			String[] arrCurr = dbDao.searchCurrByYardAndCost(vYdCd, vCostCd);
//			if(!"".equals(arrCurr[0])){
//				if(!arrCurr[0].equals(arrCurr[1])){
//					throw new EventException(new ErrorHandler("PSO90011", new String[]{"The currency is different from what is input as the same yard and cost before."}).getMessage());	//
//				}
//			}
			/***************************************************************************************************************************************
			 * 2. PSO_YD_CHG_OBJ_LIST 테이블에 데이터 생성	[2010.01.13:ReadOnly로 변경] -> *[2011.11.10] Version up 시 insert 되도록 변경
			 *************************************************************************************************************************************** 
			 *		- PSO_YD_CHG_OBJ_LIST 테이블 YardCharge별로 삭제한다. 
			 *		- PSO_YD_CHG_OBJ_LIST 테이블에 Insert
			 ***************************************************************************************************************************************/
//			/*
			//2015.04.16		if(checkPsoYdChg.equals("VERSION_UP")){ 
				//PSO_YD_CHG_OBJ_LIST 테이블 YardCharge별로 삭제한다. 
//			PsoYdChgObjListVO deletePsoYdChgObjListVO = new PsoYdChgObjListVO();
//			deletePsoYdChgObjListVO.setYdChgNo(gYdChgNo);
//			deletePsoYdChgObjListVO.setYdChgVerSeq(gYdChgVerSeq);
//			deletePsoYdChgObjListVO.setObjListNo("");	//YardCharge 모두를 삭제하기 위해
//			dbDao.removePsoYdChgObjList(deletePsoYdChgObjListVO);
				
			//2015.04.16	if(arrBaseRegVal != null && arrBaseRegVal.length > 0){
			//2015.04.16		for(int i=0; i<arrBaseRegVal.length; i++){
			//2015.04.16		sheet3_dfltVal   = arrBaseRegVal[i].getRegularValue();		
			//2015.04.16		sheet3_objListNo = arrBaseRegVal[i].getObjListNo();
						
						//PSO_YD_CHG_OBJ_LIST 테이블에 Insert
			//2015.04.16		PsoYdChgObjListVO insertPsoYdChgObjListVO = new PsoYdChgObjListVO();
			//2015.04.16		insertPsoYdChgObjListVO.setYdChgNo(gYdChgNo);
			//2015.04.16	insertPsoYdChgObjListVO.setYdChgVerSeq(newYdChgVerSeq);
			//2015.04.16	insertPsoYdChgObjListVO.setObjListNo(sheet3_objListNo);
			//2015.04.16	insertPsoYdChgObjListVO.setDfltCtnt("");
			//2015.04.16		insertPsoYdChgObjListVO.setDfltVal(sheet3_dfltVal);
			//2015.04.16		insertPsoYdChgObjListVO.setDfltFlg("");
			//2015.04.16		insertPsoYdChgObjListVO.setCreUsrId(vCreUsrId);
			//2015.04.16		dbDao.mergePsoYdChgObjList(insertPsoYdChgObjListVO);
			//2015.04.16		}
			//2015.04.16	}
			//2015.04.16}
//			*/
			
			/***************************************************************************************************************************************
			 * 3. PSO_TRF_DTL, PSO_TARIFF, PSO_CHG_XPR_DTL, PSO_CHG_XPR, PSO_YD_CHG_XPR 테이블의 이전 데이터 삭제
			 *************************************************************************************************************************************** 
			 *		- "UPDATE"일 경우, PSO_TRF_DTL, PSO_TARIFF, PSO_CHG_XPR_DTL, PSO_CHG_XPR, PSO_YD_CHG_XPR 삭제	 	
			 ***************************************************************************************************************************************/
			//
			if("UPDATE".equals(checkPsoYdChg)){	
				//PSO_TRF_DTL		 삭제
				dbDao.removePsoTrfDtlByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				//PSO_TARIFF 		삭제	
				dbDao.removePsoTariffByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				//PSO_CHG_XPR_DTL 	삭제
				dbDao.removePsoChgXprDtlByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				//PSO_CHG_XPR 		삭제
				dbDao.removePsoChgXprByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
				//PSO_YD_CHG_XPR	삭제
				dbDao.removePsoYdChgXprByChgNoChgVerTpCd(gYdChgNo, gYdChgVerSeq, "ALL");
			}
			/***************************************************************************************************************************************
			 * 4. PSO_CHG_XPR, (PSO_CHG_XPR_DTL,) PSO_YD_CHG_XPR 테이블에 데이터 생성
			 *************************************************************************************************************************************** 
			 * 	[Base]
			 * 		- PSO_CHG_XPR 		채번, 신규
			 * 		- PSO_CHG_XPR_DTL 	신규
			 * 		- PSO_YD_CHG_XPR 	업데이트
			 * 	[Surcharge]
			 * 		- PSO_CHG_XPR 		채번, 신규
			 * 		- PSO_YD_CHG_XPR 	업데이트
			 * 	[Discount]
			 * 		- PSO_CHG_XPR 		채번, 신규
			 * 		- PSO_YD_CHG_XPR 	업데이트
			 ***************************************************************************************************************************************/
			//[Base]
			if(arrBaseFomlCond != null && arrBaseFomlCond.length > 0){
				
				//PSO_CHG_XPR Insert 단건 (채번, 신규)
				sheet1_chgXprNo = dbDao.searchPsoChgXprPK();	//채번
				if(arrBaseFomlCond.length == 1){	
					sheet1_condNo = arrBaseFomlCond[0].getCondition();
					sheet1_psoChgXprTpCd = "".equals(sheet1_condNo) ? "1" : "2";	//Condition이 없으면 1, 있으면 2
				} else{
					sheet1_psoChgXprTpCd = "4";
				}
				PsoChgXprVO insertPsoChgXprVO = new PsoChgXprVO();
				insertPsoChgXprVO.setChgXprNo(sheet1_chgXprNo);
				insertPsoChgXprVO.setPsoChgXprTpCd(sheet1_psoChgXprTpCd);
				//XPR_DESC, DFLT_XPR_DESC, SYS_XPR_DESC, DFLT_SYS_XPR_DESC 입력은 PSO_CHG_XPR_DTL 생성후 업데이트 처리함
				insertPsoChgXprVO.setUpdMnuNo("2");		//0002:1, 0004:2
				insertPsoChgXprVO.setCreUsrId(vCreUsrId);
				insertPsoChgXprVO.setUpdUsrId(vCreUsrId);
				dbDao.mergePsoChgXpr(insertPsoChgXprVO);		//신규
				
				//PSO_CHG_XPR_DTL Insert 다건 (신규)
				for(int i=0; i<arrBaseFomlCond.length; i++){
					sheet1_uk 			= arrBaseFomlCond[i].getUk();
					sheet1_fomlNo 		= arrBaseFomlCond[i].getFormulaNo();
					sheet1_condNo 		= arrBaseFomlCond[i].getCondition();
					
					sheet1_dfltFomlFlg 	= "1".equals(arrBaseFomlCond[i].getDefault2()) ? "Y" : "N";
					
					sheet1_psoCtrlStmtTpCd = "".equals(sheet1_condNo) ? "4" : "1";	//Condition이 없으면 4, 있으면 1
					
					PsoChgXprDtlVO insertPsoChgXprDtlVO = new PsoChgXprDtlVO();
					insertPsoChgXprDtlVO.setChgXprNo(sheet1_chgXprNo);	//Key 1
					insertPsoChgXprDtlVO.setChgXprSeq(i + 1 + "");		//Key 2
					insertPsoChgXprDtlVO.setPsoCtrlStmtTpCd(sheet1_psoCtrlStmtTpCd);	//Condition 有 : 1, Condition 無 : 4  
					insertPsoChgXprDtlVO.setDfltFomlFlg(sheet1_dfltFomlFlg);
					insertPsoChgXprDtlVO.setCondNo(sheet1_condNo);
					insertPsoChgXprDtlVO.setFomlNo(sheet1_fomlNo);
					insertPsoChgXprDtlVO.setCreUsrId(vCreUsrId);
					insertPsoChgXprDtlVO.setUpdUsrId(vCreUsrId);
					dbDao.mergePsoChgXprDtl(insertPsoChgXprDtlVO);
					
					hashUkChgXprSeq.put(sheet1_uk, i + 1 + "");
					hashUkSeqTrfSeq.put(sheet1_uk, new HashMap<String, String>());
					
					//Formula에 속한 Object 구해놓기 (PSO_TARIFF:Base 저장시, Formula에 속한 Object인지 체크하기 위해)
					List<PsoObjListVO> psoObjListVO = dbDao.searchObjectsByFormula(sheet1_fomlNo);
					StringBuffer objectsByFormula = new StringBuffer(",");
					for(int j=0; j<psoObjListVO.size(); j++){
						objectsByFormula.append(psoObjListVO.get(j).getObjListNo() + ",");
					}
					hashUkObject.put(sheet1_uk, objectsByFormula.toString());
				}
					
				//PSO_YD_CHG_XPR 단건 (신규 or CHG_XPR_NO업데이트)
				PsoYdChgXprVO insertPsoYdChgXprVO = new PsoYdChgXprVO();
				insertPsoYdChgXprVO.setPsoChgTpCd("B");
				insertPsoYdChgXprVO.setYdChgNo(gYdChgNo);
				insertPsoYdChgXprVO.setYdChgVerSeq(gYdChgVerSeq);
				insertPsoYdChgXprVO.setChgXprNo(sheet1_chgXprNo);
				insertPsoYdChgXprVO.setCreUsrId(vCreUsrId);
				dbDao.mergePsoYdChgXprByFK(insertPsoYdChgXprVO);
				
			}
			
			//[Surcharge]
			if(arrSurcharge != null && arrSurcharge.length > 0){
				if("".equals(sheet4_chgXprNo)){
					//PSO_CHG_XPR Insert (채번, 신규)
					sheet4_chgXprNo = dbDao.searchPsoChgXprPK();	//채번
					//sheet4_chgXprSeq += "1";	//단순은 1
					PsoChgXprVO insertPsoChgXprVO = new PsoChgXprVO();
					insertPsoChgXprVO.setChgXprNo(sheet4_chgXprNo);
					insertPsoChgXprVO.setPsoChgXprTpCd("7");		//Surcharge, Discount는 7
					//XPR_DESC, DFLT_XPR_DESC, SYS_XPR_DESC, DFLT_SYS_XPR_DESC 입력要
					//insertPsoChgXprVO.setXprDesc(xprDesc)
					insertPsoChgXprVO.setUpdMnuNo("2");				//0002:1, 0004:2
					insertPsoChgXprVO.setCreUsrId(vCreUsrId);
					dbDao.mergePsoChgXpr(insertPsoChgXprVO);		//신규
				}
				
				//PSO_YD_CHG_XPR (신규 or CHG_XPR_NO업데이트)
				PsoYdChgXprVO insertPsoYdChgXprVO = new PsoYdChgXprVO();
				insertPsoYdChgXprVO.setPsoChgTpCd("S");
				insertPsoYdChgXprVO.setYdChgNo(gYdChgNo);
				insertPsoYdChgXprVO.setYdChgVerSeq(gYdChgVerSeq);
				insertPsoYdChgXprVO.setChgXprNo(sheet4_chgXprNo);
				insertPsoYdChgXprVO.setCreUsrId(vCreUsrId);
				dbDao.mergePsoYdChgXprByFK(insertPsoYdChgXprVO);
			}
			
			//[Discount]
			if(arrDiscount != null && arrDiscount.length > 0){
				if("".equals(sheet5_chgXprNo)){
					//PSO_CHG_XPR Insert (채번, 신규)
					sheet5_chgXprNo = dbDao.searchPsoChgXprPK();	//채번
					//sheet5_chgXprSeq += "1";	//단순은 1
					PsoChgXprVO insertPsoChgXprVO = new PsoChgXprVO();
					insertPsoChgXprVO.setChgXprNo(sheet5_chgXprNo);
					insertPsoChgXprVO.setPsoChgXprTpCd("7");		//Surcharge, Discount는 7
					//XPR_DESC, DFLT_XPR_DESC, SYS_XPR_DESC, DFLT_SYS_XPR_DESC 입력要
					//insertPsoChgXprVO.setXprDesc(xprDesc)
					insertPsoChgXprVO.setUpdMnuNo("2");				//0002:1, 0004:2
					insertPsoChgXprVO.setCreUsrId(vCreUsrId);
					dbDao.mergePsoChgXpr(insertPsoChgXprVO);		//신규
				}
				
				//PSO_YD_CHG_XPR (신규 or CHG_XPR_NO업데이트)
				PsoYdChgXprVO insertPsoYdChgXprVO = new PsoYdChgXprVO();
				insertPsoYdChgXprVO.setPsoChgTpCd("D");
				insertPsoYdChgXprVO.setYdChgNo(gYdChgNo);
				insertPsoYdChgXprVO.setYdChgVerSeq(gYdChgVerSeq);
				insertPsoYdChgXprVO.setChgXprNo(sheet5_chgXprNo);
				insertPsoYdChgXprVO.setCreUsrId(vCreUsrId);
				dbDao.mergePsoYdChgXprByFK(insertPsoYdChgXprVO);
			}
			/***************************************************************************************************************************************
			 * 5. (PSO_CHG_XPR_DTL,) PSO_TARIFF, PSO_TRF_DTL 테이블에 데이터 생성
			 *************************************************************************************************************************************** 
			 * 	[Base]
			 * 		- FOML_NO Map Creation (OBJ_LIST_NO, RATE_TYPE)
			 * 		- PSO_TARIFF 		채번, 신규
			 * 		- PSO_TRF_DTL	 	신규
			 * 	[Surcharge]
			 * 		- PSO_CHG_XPR_DTL	신규
			 * 		- PSO_TARIFF 		채번, 신규
			 * 		- PSO_TRF_DTL 		신규
			 * 	[Discount]
			 * 		- PSO_CHG_XPR_DTL	신규
			 * 		- PSO_TARIFF 		채번, 신규
			 * 		- PSO_TRF_DTL 		신규
			 ***************************************************************************************************************************************/
			//[Base]
			if(arrBase != null && arrBase.length > 0){ 
				String newPortTrfNo = "";
				int	   trfSeq 		= 1;
				List<PsoTrfDtlVO> insert4BasePsoTrfDtlVOs = new ArrayList<PsoTrfDtlVO>();
				
				//FOML_NO Map Creation (OBJ_LIST_NO, RATE_TYPE)
				List<PsoFormulaVO> fomlNoList = dbDao.searchFomlNoByObjAndType("", "");
				Map<String, String> mapFomlNo = new HashMap<String, String>();
				for(int i=0; i<fomlNoList.size(); i++){
					//Key 	-> RT_OBJ_LIST_NO + ":" + FOML_SEQ
					//Value -> FOML_NO
					mapFomlNo.put(fomlNoList.get(i).getCreUsrId(), fomlNoList.get(i).getFomlNo());	
				}
				for(int i=0; i<arrBase.length; i++){
					sheet6_uk 				= arrBase[i].getUk();
					sheet6_seq 				= arrBase[i].getSeq();
					//sheet6_psoObjCd 		= arrBase[i].getObject();
					//sheet6_psoMeasUtCd 		= arrBase[i].getObjectCode();
					sheet6_psoTrfTpCd		= arrBase[i].getRateCode();
					sheet6_objListNo 		= arrBase[i].getObjListNo();
					
					if("".equals(sheet6_objListNo)){
						throw new EventException(new ErrorHandler("PSO90002", new String[]{"Object List No "}).getMessage());
					}
					//선택한 Object가 Formula에 없을때
					if(hashUkObject.get(sheet6_uk).indexOf("," + sheet6_objListNo + ",") < 0){
						throw new EventException(new ErrorHandler("PSO90002", new String[]{"Please input 'Object Code' that belongs to 'Formula Code'"}).getMessage());
					}
					
					//OBJ_LIST_NO, Rate Type을 이용하여 Formula No를 얻는다. (건수가 많아져서 FOML_NO Map Creation으로 대체)
					///List<PsoFormulaVO> fomlNoList = dbDao.searchFomlNoByObjAndType(sheet6_objListNo, sheet6_psoTrfTpCd);
					/*
					if(fomlNoList.size() > 0){
						sheet6_fomlNo 		= fomlNoList.get(0).getFomlNo();
					} else{
						throw new EventException(new ErrorHandler("PSO90002", new String[]{"[Formula No] "}).getMessage());	//Data를 찾을 수 없습니다.
					}
					*/
					//Fomular No를 Map에서 꺼낸다.
					String psoTrfTpCd = sheet6_psoTrfTpCd.equals("R") ? "3" : (sheet6_psoTrfTpCd.equals("S") ? "1" : "3");	//DECODE(@[pso_trf_tp_cd], 'R', 3, 'S', 1, 'F', 3)
					
					if(mapFomlNo.containsKey(sheet6_objListNo + ":" + psoTrfTpCd)){
						sheet6_fomlNo = mapFomlNo.get(sheet6_objListNo + ":" + psoTrfTpCd);
					} else{
						throw new EventException(new ErrorHandler("PSO90002", new String[]{"[Formula No] " + "OBJ_LIST_NO=" + sheet6_objListNo + ", TYPE=" + sheet6_psoTrfTpCd}).getMessage());	//Data를 찾을 수 없습니다.
					}
					sheet6_condNo			= arrBase[i].getCondition();
					sheet6_fmVal 			= arrBase[i].getRangeFrom().replace(":", "").replace(",", "");			
					sheet6_toVal			= arrBase[i].getRangeTo().replace(":", "").replace(",", "");	
					sheet6_trfRtAmt			= arrBase[i].getRateValue();	
					sheet6_consAlsNm		= arrBase[i].getConsAlsNm();	
					
					if(hashUkSeqTrfSeq.get(sheet6_uk).get(sheet6_seq) == null){
						
						//PSO_TARIFF 채번
						newPortTrfNo = dbDao.searchPsoTariffPK();
						//PSO_TARIFF 입력
						List<PsoTariffVO> insertPsoTariffVOList = new ArrayList<PsoTariffVO>();
						PsoTariffVO insertPsoTariffVO = new PsoTariffVO();
						insertPsoTariffVO.setPortTrfNo(newPortTrfNo);
						insertPsoTariffVO.setPsoTrfTpCd(sheet6_psoTrfTpCd);
						insertPsoTariffVO.setFomlNo(sheet6_fomlNo);
						insertPsoTariffVO.setFomlSeq("2");			//단순은 1
						insertPsoTariffVO.setChgXprNo(sheet1_chgXprNo);		//PSO_CHG_XPR.CHG_XPR_NO는 하나뿐임
						insertPsoTariffVO.setChgXprSeq(hashUkChgXprSeq.get(sheet6_uk));
						insertPsoTariffVO.setObjListNo(sheet6_objListNo);
						insertPsoTariffVO.setCurrCd(vCurrency);
						insertPsoTariffVO.setPsoRtTpCd(null);
						insertPsoTariffVO.setDpNo(sheet6_seq);
						insertPsoTariffVO.setConsAlsNm(sheet6_consAlsNm);
						insertPsoTariffVO.setCreUsrId(vCreUsrId);
						insertPsoTariffVOList.add(insertPsoTariffVO);
						dbDao.addTariff(insertPsoTariffVOList);
						
						hashUkSeqTrfSeq.get(sheet6_uk).put(sheet6_seq, newPortTrfNo);
					
						trfSeq = 1;
						
					} else{
						trfSeq++;
					}
					
					//PSO_TRF_DTL 입력 (executeUpdate)
					/*
					PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					insertPsoTrfDtlVO.setTrfSeq(trfSeq + "");
					insertPsoTrfDtlVO.setFmVal(sheet6_fmVal);
					insertPsoTrfDtlVO.setToVal(sheet6_toVal);
					insertPsoTrfDtlVO.setTrfRtAmt(sheet6_trfRtAmt);
					insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					insertPsoTrfDtlVO.setCondNo(sheet6_condNo);
					dbDao.addPsoTrfDtl(insertPsoTrfDtlVO);
					*/
					
					//PSO_TRF_DTL 입력 (executeBatch)
					PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					insertPsoTrfDtlVO.setTrfSeq(trfSeq + "");
					insertPsoTrfDtlVO.setFmVal(sheet6_fmVal);
					insertPsoTrfDtlVO.setToVal(sheet6_toVal);
					insertPsoTrfDtlVO.setTrfRtAmt(sheet6_trfRtAmt);
					insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					insertPsoTrfDtlVO.setCondNo(sheet6_condNo);
					insert4BasePsoTrfDtlVOs.add(insertPsoTrfDtlVO);
				}
				//PSO_TRF_DTL 입력 (executeBatch)
				//dbDao.addPsoTrfDtl(insert4BasePsoTrfDtlVOs.get(insert4BasePsoTrfDtlVOs.size()-1));
				dbDao.addPsoTrfDtl(insert4BasePsoTrfDtlVOs);
			}
			
			//[Surcharge]
			if(arrSurcharge != null && arrSurcharge.length > 0){ 
				
				for(int i=0; i<arrSurcharge.length; i++){
					//PSO_CHG_XPR_DTL Insert (신규)
					PsoChgXprDtlVO insertPsoChgXprDtlVO = new PsoChgXprDtlVO();
					insertPsoChgXprDtlVO.setChgXprNo(sheet4_chgXprNo);
					insertPsoChgXprDtlVO.setChgXprSeq(i + 1 + "");
					insertPsoChgXprDtlVO.setPsoCtrlStmtTpCd(arrSurcharge[i].getSumOption());
					insertPsoChgXprDtlVO.setCondNo(arrSurcharge[i].getCondition());
					insertPsoChgXprDtlVO.setFomlNo(arrSurcharge[i].getFormulaNo());
					insertPsoChgXprDtlVO.setCreUsrId(vCreUsrId);
					dbDao.mergePsoChgXprDtl(insertPsoChgXprDtlVO);
					
					//PSO_TARIFF 채번
					String newPortTrfNo = dbDao.searchPsoTariffPK();
					//PSO_TARIFF 입력
					List<PsoTariffVO> insertPsoTariffVOList = new ArrayList<PsoTariffVO>();
					PsoTariffVO insertPsoTariffVO = new PsoTariffVO();
					insertPsoTariffVO.setPortTrfNo(newPortTrfNo);
					insertPsoTariffVO.setPsoTrfTpCd(null);
					insertPsoTariffVO.setFomlNo(arrSurcharge[i].getFormulaNo());
					insertPsoTariffVO.setFomlSeq("1");			//단순은 1
					insertPsoTariffVO.setChgXprNo(sheet4_chgXprNo);
					insertPsoTariffVO.setChgXprSeq(i + 1 + "");
					insertPsoTariffVO.setObjListNo(null);
					insertPsoTariffVO.setCurrCd(vCurrency);
					insertPsoTariffVO.setPsoRtTpCd(arrSurcharge[i].getMethodCode());
					insertPsoTariffVO.setDpNo("10");
					insertPsoTariffVO.setCreUsrId(vCreUsrId);
					insertPsoTariffVOList.add(insertPsoTariffVO);
					dbDao.addTariff(insertPsoTariffVOList);
					
					//PSO_TRF_DTL 입력
					PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					insertPsoTrfDtlVO.setTrfSeq("1");
					insertPsoTrfDtlVO.setFmVal(null);
					insertPsoTrfDtlVO.setToVal(null);
					insertPsoTrfDtlVO.setTrfRtAmt(arrSurcharge[i].getRateValue());
					insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					insertPsoTrfDtlVO.setCondNo(null);
					dbDao.addPsoTrfDtl(insertPsoTrfDtlVO);
				}
				
			}			

			//[Discount]	
			if(arrDiscount != null && arrDiscount.length > 0){ 
				
				for(int i=0; i<arrDiscount.length; i++){
					//PSO_CHG_XPR_DTL Insert (신규)
					PsoChgXprDtlVO insertPsoChgXprDtlVO = new PsoChgXprDtlVO();
					insertPsoChgXprDtlVO.setChgXprNo(sheet5_chgXprNo);
					insertPsoChgXprDtlVO.setChgXprSeq(i + 1 + "");
					insertPsoChgXprDtlVO.setPsoCtrlStmtTpCd(arrDiscount[i].getSumOption());
					insertPsoChgXprDtlVO.setCondNo(arrDiscount[i].getCondition());
					insertPsoChgXprDtlVO.setFomlNo(arrDiscount[i].getFormulaNo());
					insertPsoChgXprDtlVO.setCreUsrId(vCreUsrId);
					dbDao.mergePsoChgXprDtl(insertPsoChgXprDtlVO);
					
					//PSO_TARIFF 채번
					String newPortTrfNo = dbDao.searchPsoTariffPK();
					//PSO_TARIFF 입력
					List<PsoTariffVO> insertPsoTariffVOList = new ArrayList<PsoTariffVO>();
					PsoTariffVO insertPsoTariffVO = new PsoTariffVO();
					insertPsoTariffVO.setPortTrfNo(newPortTrfNo);
					insertPsoTariffVO.setPsoTrfTpCd(null);
					insertPsoTariffVO.setFomlNo(arrDiscount[i].getFormulaNo());
					insertPsoTariffVO.setFomlSeq("1");			//단순은 1
					insertPsoTariffVO.setChgXprNo(sheet5_chgXprNo);
					insertPsoTariffVO.setChgXprSeq(i + 1 + "");
					insertPsoTariffVO.setObjListNo(null);
					insertPsoTariffVO.setCurrCd(vCurrency);
					insertPsoTariffVO.setPsoRtTpCd(arrDiscount[i].getMethodCode());
					insertPsoTariffVO.setDpNo("10");
					insertPsoTariffVO.setCreUsrId(vCreUsrId);
					insertPsoTariffVOList.add(insertPsoTariffVO);
					dbDao.addTariff(insertPsoTariffVOList);
					
					//PSO_TRF_DTL 입력
					PsoTrfDtlVO insertPsoTrfDtlVO = new PsoTrfDtlVO();
					insertPsoTrfDtlVO.setPortTrfNo(newPortTrfNo);
					insertPsoTrfDtlVO.setTrfSeq("1");
					insertPsoTrfDtlVO.setFmVal(null);
					insertPsoTrfDtlVO.setToVal(null);
					insertPsoTrfDtlVO.setTrfRtAmt(arrDiscount[i].getRateValue());
					insertPsoTrfDtlVO.setCreUsrId(vCreUsrId);
					insertPsoTrfDtlVO.setCondNo(null);
					dbDao.addPsoTrfDtl(insertPsoTrfDtlVO);
				}
			}	
			
			/***************************************************************************************************************************************
			 * 2. PSO_YD_CHG_OBJ_LIST 테이블에 데이터 생성	[2015.04 ] 변경 
			 ***************************************************************************************************************************************/
			if(checkPsoYdChg.equals("CREATE")){
				//newYdChgNo    1
				 log.debug("1create");
				 dbDao.addPsoYdChgObjList(gYdChgNo,gYdChgVerSeq,gYdChgVerSeq,vCreUsrId);			
			}			
			 else if(checkPsoYdChg.equals("VERSION_UP")){
				//vYdChgNo  vVersion     vYdChgNo      newYdChgVerSeq
				 log.debug("1version_up");
				 log.debug("vYdChgNo+"+vYdChgNo);
				 log.debug("gYdChgNo+"+gYdChgNo);
				 log.debug("vVersion+"+vVersion);
				 log.debug("newYdChgVerSeq+"+gYdChgVerSeq);		 
				 
				 dbDao.addPsoYdChgObjList(gYdChgNo,vVersion,gYdChgVerSeq,vCreUsrId);				 
			 }
			
			 else if(checkPsoYdChg.equals("UPDATE")){
				 //merge --> delete 문장
				 log.debug("1update"); 
				 log.debug("1update+gYdChgNo+"+gYdChgNo);
				 log.debug("1update+gYdChgVerSeq+"+gYdChgVerSeq);
				 dbDao.modifyPsoYdChgObjList(gYdChgNo,gYdChgVerSeq,vCreUsrId);	
				 dbDao.deletePsoYdChgObjList(gYdChgNo,gYdChgVerSeq);
				
				 //vYdChgNo   vVersion
			 }
			
			

			/***************************************************************************************************************************************
			 * 6. PSO_CHG_XPR 테이블에 Description Update
			 *************************************************************************************************************************************** 
			 * 	[Base]
			 * 		- PSO_CHG_XPR 		Description Update
			 * 	[Surcharge]
			 * 		- PSO_CHG_XPR 		Description Update
			 * 	[Discount]
			 * 		- PSO_CHG_XPR 		Description Update
			 ***************************************************************************************************************************************/
			//[Base]	
			if(arrBase != null && arrBase.length > 0){ 
				log.debug("sheet1_chgXprNo :="+sheet1_chgXprNo);
				// Base 등록시 Validation Check 추가  formula 등록시 object rate는 반드시 등록되어져야 함.
		  		   String rVal = dbDao.validateChgXprDescByChgXprNo(sheet1_chgXprNo);
				
				if(!rVal.equals("Y")){	//Valid하지 않으면 
					throw new EventException(new ErrorHandler("PSO_OBJECT").getMessage());
				}		
				
				if(dbDao.modifyChgXprDescByChgXprNo(sheet1_chgXprNo) < 1){
					throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invalid Expression Description, Base"}).getMessage());	//Unexpected Error Occurred.
				}
			}

			//[Surcharge]	
			if(arrSurcharge != null && arrSurcharge.length > 0){ 
				if(dbDao.modifyChgXprDescByChgXprNo(sheet4_chgXprNo) < 1){
					throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invalid Expression Description, Surcharge"}).getMessage());	//Unexpected Error Occurred.
				}
			}
			
			//[Discount]	
			if(arrDiscount != null && arrDiscount.length > 0){ 
				if(dbDao.modifyChgXprDescByChgXprNo(sheet5_chgXprNo) < 1){
					throw new EventException(new ErrorHandler("PSO90010", new String[]{"Invalid Expression Description, Discount"}).getMessage());	//Unexpected Error Occurred.
				}
			}
			
		} catch (EventException ex) {
			throw ex;	
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Tariff Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Tariff Creation"}).getMessage(), de);
		}
	}
	/**
	 * Condition/Formula 선택에 따라 조회분기
	 * 
	 * @param  UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO
	 * @return List<UseStatusConditonFormulaDtlVO>
	 * @throws EventException
	 */
	public List<UseStatusConditonFormulaDtlVO> searchUseIdConditonFormulaDetail(UseStatusConditonFormulaDtlVO useStatusConditonFormulaDtlVO) throws EventException {
		List<UseStatusConditonFormulaDtlVO> list = null;
		try {
			if("C".equalsIgnoreCase(useStatusConditonFormulaDtlVO.getIdTp())){
				list = dbDao.searchUseIdConditonDetail(useStatusConditonFormulaDtlVO);	//Condition
			} else if("F".equalsIgnoreCase(useStatusConditonFormulaDtlVO.getIdTp())){
				list = dbDao.searchUseIdFormulaDetail(useStatusConditonFormulaDtlVO);	//Formula
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Condition/Formula"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Condition/Formula"}).getMessage(), de);
		}
		
		return list;
	}
	
	/**
	 * Terminal 별로  Tariff List(Account/Vendor/Update ID/Update Date)를 조회함
	 * @category VOP_PSO_0036_RetrieveBtnClick 
	 * @param  String ydCd
	 * @param  String year
	 * @param  String acctCd
	 * @return List<PortTariffListVO>
	 * @throws EventException
	 */
	public List<PortTariffListVO> searchPortTariffList(String ydCd, String year,String acctCd)
			throws EventException {
		try {
			
			return dbDao.searchPortChargeList(ydCd, year,acctCd);
			
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff List"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Tariff List"}).getMessage(), de);
		}
	}

	/**
	 * Charge Creation(Invoice 생성)시에 필요한 Effective Date(지불일)를 조회한다.
	 * @category VOP_PSO_0036_VerClick
	 * @param  PortTariffListVO portTariffListVO
	 * @return List<EffectiveDateListVO>
	 * @throws EventException
	 */
	public List<EffectiveDateListVO> searchDistinctEffectiveDateList(
			PortTariffListVO portTariffListVO) throws EventException {
		try {
			
			return dbDao.searchDistinctEffectiveDateList(portTariffListVO);
			
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Charge Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Charge Creation"}).getMessage(), de);
		}
	}

	/**
	 * Charge Creation(Invoice 생성)시에 필요한 Effective Date(지불일)의 Version 을 조회한다.
	 * @category VOP_PSO_0036_EffDateClick
	 * @param  PortTariffListVO portTariffListVO
	 * @return List<YardChargeVersionVO>
	 * @throws EventException
	 */
	public List<YardChargeVersionVO> searchYardChargeVersion(
			PortTariffListVO portTariffListVO) throws EventException {
		try {
			
			return dbDao.searchYardChargeVersion(portTariffListVO);
			
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Charge Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Charge Creation"}).getMessage(), de);
		}
	}
	
	/**
	 * PSO yard Charge 정보와 비교하여 조건에 따흔 Account Code를 조회한다.
	 * @category VOP_PSO_0036_Account Code
	 * @param  String ydCd
	 * @param  String year
	 * @return List<AccountAndCostVO>
	 * @throws EventException
	 */
	public List<AccountAndCostVO> searchAccountAndCostByCondition(String ydCd, String year) throws EventException {
		try {
			
			return dbDao.searchAccountAndCostByCondition(ydCd, year);
			
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("COM12244").getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12244").getMessage(), de);
		}
	}

	/**
	 * Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Formula 정보 조회 
	 * @category VOP_PSO_0007_RetrieveBtnClickFormula
	 * @param String formulaNo
	 * @return List<FormulaVO>
	 */
	public List<FormulaVO> searchFormula(String formulaNo) throws EventException {
		try {
			
			return dbDao.searchPsoFormula(formulaNo);
			
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Formula N' Condition Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Formula N' Condition Creation"}).getMessage(), de);
		}
	}

	/**
	 * Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Formula 정보 조회 (Hidden Grid 용)
	 * @category VOP_PSO_0007_RetrieveBtnClickFormula
	 * @param String formulaNo
	 * @return List<FormulaVO>
	 */
	public List<FormulaVO> searchFormulaSys(String formulaNo) throws EventException {
		try {
			
			return dbDao.searchPsoFormulaSys(formulaNo);
			
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Formula N' Condition Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Formula N' Condition Creation"}).getMessage(), de);
		}
	}

	/**
	 * Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Condition 정보 조회
	 * @category VOP_PSO_0007_RetrieveBtnClickCondition
	 * @param String conditionNo
	 * @return List<FormulaVO>
	 */
	public List<FormulaVO> searchCondition(String conditionNo)
			throws EventException {
		try {
			
			return dbDao.searchPsoCondition(conditionNo);
			
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Formula N' Condition Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Formula N' Condition Creation"}).getMessage(), de);
		}
	}

	/**
	 * Formula N' Condition Creation 화면의 Retrieve Button을 ClicK 했을 경우의 Condition 정보 조회 (Hidden Grid 용)
	 * @category VOP_PSO_0007_RetrieveBtnClickCondition
	 * @param String conditionNo
	 * @return List<FormulaVO>
	 */
	public List<FormulaVO> searchConditionSys(String conditionNo)
			throws EventException {
		try {
			
			return dbDao.searchPsoConditionSys(conditionNo);
			
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Formula N' Condition Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Formula N' Condition Creation"}).getMessage(), de);
		}
	}

	/**
	 * Formula N' Condition Creation 화면의 Delete Button을 ClicK 했을 경우 처리
	 * @category VOP_PSO_0007_DeleteBtnClickFormula
	 * @param String formulaNo
	 * @throws EventException
	 */
	public void removeFormula(String formulaNo) throws EventException {
		try {
			//해당 Formula가 Charge Expression Detail 에서 사용되고 있는지 확인한다. 
			String[] arrCheckFoml = dbDao.checkFormulaUsing ( formulaNo );
			String bUsed = arrCheckFoml[0];
			String updMnuNo = arrCheckFoml[1];
			
			if(!bUsed.equals("0") && !updMnuNo.equals("2")){//쌀집에서 만든 것이 아니면 
				throw new EventException(new ErrorHandler("PSO90001", new String[]{"The formula that you want to delete isn't created by this program."}).getMessage());
			}
			
			if(bUsed.equals("0")){//delete대상이 없는 경우 
				return;
			}
			else if(bUsed.equals("1")){//
				dbDao.removeFormulaDetail ( formulaNo );
				dbDao.removeFormula ( formulaNo );
				log.debug("bUsed:>>>"+bUsed);
			}
			else{//ServerMessage Throw? //Delete 대상이 Tariff에서 사용되고 있는 경우 
				throw new EventException(new ErrorHandler("PSO97001").getMessage());
			}
		} catch (EventException ex) {
			throw ex;		
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90012", new String[]{"Formula N' Condition Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90012", new String[]{"Formula N' Condition Creation"}).getMessage(), de);
		}
	}

	/**
	 * Formula N' Condition Creation 화면의 Delete Button을 ClicK 했을 경우 처리
	 * @category VOP_PSO_0007_DeleteBtnClickCondition
	 * @param String conditionNo
	 * @throws EventException
	 */
	public void removeCondition(String conditionNo) throws EventException {
		try {
			//해당 Condition가 Charge Expression Detail 에서 사용되고 있는지 확인한다. [2010.03.16:jmh]
			String[] arrCheckFoml = dbDao.checkConditionUsing ( conditionNo );
			String bUsed = arrCheckFoml[0];
			//String updMnuNo = arrCheckFoml[1];
			
			//if(!bUsed.equals("0") && !updMnuNo.equals("2")){//쌀집에서 만든 것이 아니면 
				//쌀집에서 만든 것이 아니라도 삭제 가능
				//throw new EventException(new ErrorHandler("PSO90001", new String[]{"The condition that you want to delete isn't created by this program."}).getMessage());
			//}
			
			if(bUsed.equals("0")){//delete대상이 없는 경우 
				return;
			} else if(bUsed.equals("1")){//
				dbDao.removeConditionDetail ( conditionNo );
				dbDao.removeCondtion ( conditionNo );
				log.debug("bUsed:>>>"+bUsed);
			} else{//ServerMessage Throw? //Delete 대상이 Tariff에서 사용되고 있는 경우 
				throw new EventException(new ErrorHandler("PSO97002").getMessage());
			}
		} catch (EventException ex) {
			throw ex;	
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90012", new String[]{"Formula N' Condition Creation"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90012", new String[]{"Formula N' Condition Creation"}).getMessage(), de);
		}
	}

	/**
	 * Condition 정보를 저장한다.
	 * @category VOP_PSO_0007_SaveBtnClickCondtion
	 * @param FormulaGRPVO formulaGRPVO
	 * @return String
	 * @throws EventException
	 */
	public String manageCondition(FormulaGRPVO formulaGRPVO)	throws EventException {
		String newId = "";								//신규생성 ID
		String id = formulaGRPVO.getId().trim() + "";	//화면에서 입력된 ID

		try {
			//입력한 Formula가 Valid한지 체크 
			String bVal = dbDao.validateFormulaCondition(formulaGRPVO, "2");
			
			if(!bVal.equals("Y")){	//Valid하지 않으면 
				throw new EventException(new ErrorHandler("PSO90001", new String[]{"validation pass failed"}).getMessage());
			}	
			
			//해당 Condition가 Charge Expression Detail 에서 사용되고 있는지 확인한다. [2010.03.16:jmh]
			String[] arrCheckFoml = dbDao.checkConditionUsing ( id );
			String bUsed = arrCheckFoml[0];
			//String updMnuNo = arrCheckFoml[1];
			
			//[2010.03.17:jmh]
			//if(!bUsed.equals("0") && !updMnuNo.equals("2")){//쌀집에서 만든 것이 아니면	 
				//throw new EventException(new ErrorHandler("PSO90001", new String[]{"The condition that you want to update isn't created by this program."}).getMessage());
			//}
			
			if(bUsed.equals("0")/* && "".equals(id)*/){//신규 처리 
				//newId = dbDao.searchPsoConditionPK();	//[2010.03.16:jmh] 추가	
				//formulaGRPVO.setId(newId);
				dbDao.addPsoCondition ( formulaGRPVO );
				dbDao.addPsoConditionDetail ( formulaGRPVO );
				log.debug("bUsed:>>>"+bUsed);
			//} else if(bUsed.equals("0") && !"".equals(id)){//존재하지 않는 Condition을 업데이트하려 할 때
				
			} else if(bUsed.equals("1")){//CONDITION 존재 하나 사용되지 않을 경우 
				dbDao.modifyPsoCondition ( formulaGRPVO );//Description정보를 Update해야 된다. 
				dbDao.removeConditionDetail ( id );
				dbDao.addPsoConditionDetail ( formulaGRPVO );
			} else if(bUsed.equals("2")){//Condition 존재 하고 사용 중인 경우 
				throw new EventException(new ErrorHandler("PSO97002").getMessage());
			}

		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Condition"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Condition"}).getMessage(), de);
		}
		
		return newId;
	}

	/**
	 * Formula 정보를 저장한다. 
	 * @category VOP_PSO_0007_SaveBtnClickFormula
	 * @param FormulaGRPVO formulaGRPVO
	 * @return String
	 * @throws EventException
	 */
	public String manageFormula(FormulaGRPVO formulaGRPVO) throws EventException {
		String newId = "";								//신규생성 ID
		String id = formulaGRPVO.getId().trim() + "";	//화면에서 입력된 ID
		
		try {
			//입력한 Formula가 Valid한지 체크 
			String bVal = dbDao.validateFormulaCondition(formulaGRPVO, "1");
			
			if(!bVal.equals("Y")){	//Valid하지 않으면 
				throw new EventException(new ErrorHandler("PSO90001", new String[]{"validation pass failed"}).getMessage());
			}	
			//입력한 Formula가 Rate가 포함 되어 있는지  체크 
			String rVal = dbDao.validateFormulaRate(formulaGRPVO);
			
			if(!rVal.equals("Y")){	//Valid하지 않으면 
				throw new EventException(new ErrorHandler("PSO_OBJECT").getMessage());
			}	
			
			//해당 Formula가 Charge Expression Detail 에서 사용되고 있는지 확인한다. 
			String[] arrCheckFoml = dbDao.checkFormulaUsing ( id );
			String bUsed = arrCheckFoml[0];
			String updMnuNo = arrCheckFoml[1];
	
			if(!bUsed.equals("0") && !updMnuNo.equals("2")){//쌀집에서 만든 것이 아니면 
				throw new EventException(new ErrorHandler("PSO90001", new String[]{"The formula that you want to update isn't created by this program."}).getMessage());
			}
			
			if(bUsed.equals("0")/* && "".equals(id)*/){//신규 처리 
				//if(formulaGRPVO.getFormulaVOs()==null) return;//저장 정보가 없을 경우
				//newId = dbDao.searchPsoFormulaPK();	//[2010.03.16:jmh] 추가	
				//formulaGRPVO.setId(newId);
				dbDao.addPsoFormula ( formulaGRPVO );
				dbDao.addPsoFormulaDetail ( formulaGRPVO );
				log.debug("bUsed:>>>"+bUsed);
			//} else if(bUsed.equals("0") && !"".equals(id)){//존재하지 않는 Formula을 업데이트하려 할 때	
			
			} else if(bUsed.equals("1")){//FORMULA 존재 하나 사용되지 않을 경우 
				//if(formulaGRPVO.getFormulaVOs()==null) return;//저장 정보가 없을 경우 
				dbDao.modifyPsoFormula ( formulaGRPVO );//Description정보를 Update해야 된다. 
				dbDao.removeFormulaDetail ( id );
				dbDao.addPsoFormulaDetail ( formulaGRPVO );
			} else if(bUsed.equals("2")){//FORMULA 존재 하고 사용 중인 경우 
				throw new EventException(new ErrorHandler("PSO97001").getMessage());
			}
		} catch (EventException ex) {
			throw ex;	
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Formula"}).getMessage(), de);
		}
		
		return newId;
	}
	
	/**
	 * Formula 정보를 저장한다. 
	 * @category autoCreateFormula
	 * @return String
	 * @throws EventException
	 */
	public String autoCreateFormula() throws EventException {	
		try {
			return dbDao.searchPsoFormulaContinuousPK();
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Formula"}).getMessage(), de);
		}

	}
	
	/**
	 * Formula 정보를 저장한다. 
	 * @category autoCreateFormula
	 * @return String
	 * @throws EventException
	 */
	public String autoCreateCondition() throws EventException {
		try {
			return dbDao.searchPsoConditionContinuousPK();
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Formula"}).getMessage(), de);
		}
		
	}
	
	/**
	 * VOP_PSO_0002 화면 로딩시 초기formula를 가져온다.
	 * @category VOP_PSO_0002_Loading (jmh)
	 * @return List<PsoFormulaVO>
	 * @throws EventException
	 */
	public List<PsoFormulaVO> searchFormulaNoForLoading() throws EventException {
		try {
			return dbDao.searchFormulaNoForLoading();
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Formula"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Formula"}).getMessage(), de);
		}
	}
	
	/**
	 * Condition 정보를 저장한다.
	 * @category VOP_PSO_0206_OKBtnClick (jmh)
	 * @param ConditionVO[] conditionVOs
	 * @return String
	 * @throws EventException
	 */
	public String manageConditionByPopup(ConditionVO[] conditionVOs)	throws EventException {
		/***************************************************************************************************************************************
		 * <Create Condition Sequence>
		 ***************************************************************************************************************************************
		 * 1. PSO_CONDITION 테이블에 데이터 생성 (채번, 신규)
		 * 2. PSO_COND_DTL  테이블에 데이터 생성 
		 * 3. PSO_CONDITION 테이블에 데이터 업데이트 (COND_DESC, COND_SYS_DESC : COND_DESC가 UK이므로 업데이트시 Exception발생하면 데이터 중복임)
		 ***************************************************************************************************************************************/
		try { 
			
			String condition = "";	//AND or OR
			String objListNo = "";	//OBJ_LIST_NO
			String operator  = "";	//Comparison Operator
			String value 	 = "";	//Value
			
			String condDesc  = "";		//Condition Description
			String condSysDesc  = "";	//Condition System Description
			
			//String newCondNo = dbDao.searchPsoConditionPK();			//Condition No. 채번 : MAX()
			String newCondNo = dbDao.searchPsoConditionContinuousPK();	//Condition No. 채번 : 비어있는 No.
			
			PsoConditionVO psoConditionVO = new PsoConditionVO();
			psoConditionVO.setCondNo(newCondNo);
			psoConditionVO.setUpdMnuNo("1");
			psoConditionVO.setCreUsrId(conditionVOs[0].getCreUsrId());
			psoConditionVO.setUpdUsrId(conditionVOs[0].getCreUsrId());
			
			dbDao.addPsoConditionByRow(psoConditionVO);
			
			int sizePsoCondDtlVOList	= 0;
			List<PsoCondDtlVO> psoCondDtlVOList = new ArrayList<PsoCondDtlVO>();
			
			if(conditionVOs != null && conditionVOs.length > 0){
				for(int i=0; i<conditionVOs.length; i++){

					condition = conditionVOs[i].getCondition();	//AND or OR
					objListNo = conditionVOs[i].getObjListNo();	//OBJ_LIST_NO
					operator  = conditionVOs[i].getOperator();	//Comparison Operator
					value 	  = conditionVOs[i].getObjValue();	//Value
					
					int rows = 0;
					
					rows = (i == 0) ? 3 : 4;	//첫행은 3rows, 나머지는 4rows 생성
					
					for(int j=0; j<rows; j++){
						++sizePsoCondDtlVOList;
						PsoCondDtlVO psoCondDtlVO = new PsoCondDtlVO();
						if(sizePsoCondDtlVOList % 4 == 1){
							psoCondDtlVO.setPsoCondDtlTpCd("O");
							psoCondDtlVO.setPsoCondOprCd(null);
							psoCondDtlVO.setObjListNo(objListNo);
							psoCondDtlVO.setCondOprValCtnt(null);
						} else if(sizePsoCondDtlVOList % 4 == 2){
							psoCondDtlVO.setPsoCondDtlTpCd("P");
							psoCondDtlVO.setPsoCondOprCd(operator);
							psoCondDtlVO.setObjListNo("-1");
							psoCondDtlVO.setCondOprValCtnt(null);
						} else if(sizePsoCondDtlVOList % 4 == 3){
							psoCondDtlVO.setPsoCondDtlTpCd("C");
							psoCondDtlVO.setPsoCondOprCd(null);
							psoCondDtlVO.setObjListNo("-1");
							
							value = "Y".equalsIgnoreCase(value) || "N".equalsIgnoreCase(value) ? "'" + value + "'" : value;
							psoCondDtlVO.setCondOprValCtnt(value);
						} else if(sizePsoCondDtlVOList % 4 == 0){
							psoCondDtlVO.setPsoCondDtlTpCd("P");
							psoCondDtlVO.setPsoCondOprCd(condition);
							psoCondDtlVO.setObjListNo("-1");
							psoCondDtlVO.setCondOprValCtnt(null);
						}
						psoCondDtlVO.setCondNo(newCondNo);
						psoCondDtlVO.setCondSeq(sizePsoCondDtlVOList + "");
						psoCondDtlVO.setRowNo((i+1)*10 + "");
						psoCondDtlVO.setCreUsrId(conditionVOs[0].getCreUsrId());
						psoCondDtlVO.setUpdUsrId(conditionVOs[0].getCreUsrId());
						
						psoCondDtlVOList.add(psoCondDtlVO);
					}
				}
			}
			
			//PSO_CONDITION
			for(int i=0; i<psoCondDtlVOList.size(); i++){
				dbDao.addPsoCondDtlByRow(psoCondDtlVOList.get(i));
			}
			
			//COND_DESC, COND_SYS_DESC
			//condDesc = "";	//Unique
			List<PsoConditionVO> descPsoConditionVOList = dbDao.searchTariffConditionDesc(newCondNo);
			condDesc = descPsoConditionVOList.get(0).getCondDesc();
			condSysDesc = descPsoConditionVOList.get(0).getCondSysDesc();
			
			//PSO_COND_DTL (PSO_CONDITION Insert시 DESCRIPTION을 입력할 수 있으나, 기존재하는 Operation등을 사용하기 위하여)
			List<PsoConditionVO> psoConditionVOList = new ArrayList<PsoConditionVO>();
			PsoConditionVO updatePsoConditionVO = new PsoConditionVO();
			updatePsoConditionVO.setCondNo(newCondNo);
			updatePsoConditionVO.setCondNm("");
			updatePsoConditionVO.setCondDesc(condDesc);
			updatePsoConditionVO.setCondSysDesc(condSysDesc);
			updatePsoConditionVO.setUpdMnuNo("1");
			updatePsoConditionVO.setCreUsrId(conditionVOs[0].getCreUsrId());
			updatePsoConditionVO.setUpdUsrId(conditionVOs[0].getCreUsrId());
			psoConditionVOList.add(updatePsoConditionVO);
			dbDao.modifyPsoCondition(psoConditionVOList);
			
			return newCondNo + "||" + condDesc;
			
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011",new String[]{"Condition Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90011",new String[]{"Condition Creation"}).getMessage(), ex);
		}

	}	
	
	/**
	 * VOP_PSO_0206 화면 로딩시 조회한다.
	 * @category VOP_PSO_0206_Open
	 * @param  String condNo
	 * @return List<SearchTariffConditionVO>
	 * @throws EventException
	 */
	public List<SearchTariffConditionVO> searchTariffCondition(String condNo) throws EventException {
		try {
			return dbDao.searchTariffCondition(condNo);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Condition"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Condition"}).getMessage(), ex);
		}
	}

	/**
	 * PORT_CD로 LOCAL CURRENCY를 조회한다.
	 * @category PORT_CD로 LOCAL CURRENCY조회
	 * @param  String portCd
	 * @return String
	 * @throws EventException
	 */
	public String searchLocalCurrencyByPortCd(String portCd) throws EventException {
		try {
			return dbDao.searchLocalCurrencyByPortCd(portCd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Local Currency"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Local Currency"}).getMessage(), ex);
		}
	}
	
	/**
	 * OBJECT 정보를 조회한다.
	 * @category VOP_PSO_0004_페이지로딩시
	 * @param 	 String psoObjListTpCd	
	 * @return   List<PsoObjListVO>
	 * @throws   EventException
	 */		
	public List<PsoObjListVO> searchPsoObjListByPsoObjListTpCd(String psoObjListTpCd)  throws EventException {
		try {
			return dbDao.searchPsoObjListByPsoObjListTpCd(psoObjListTpCd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Object"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Object"}).getMessage(), ex);
		}
	}
	
	/**
	 * YD_CHG_NO, YD_CHG_VER_SEQ, OBJ_LIST_NO 별 DFLT_VAL 정보를 조회한다.
	 * @category VOP_PSO_0004_조회시
	 * @param 	 PsoYdChgObjListVO psoYdChgObjListVO
	 * @return   List<YdChgObjVO>
	 * @throws   EventException
	 */			
	public List<YdChgObjVO> searchPsoYdChgObjListByPK(PsoYdChgObjListVO psoYdChgObjListVO)  throws EventException {
		try {
			return dbDao.searchPsoYdChgObjListByPK(psoYdChgObjListVO);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Default Value"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Default Value"}).getMessage(), ex);
		}
	}

	/**
	 * [PSO_YD_CHD] Vendor 정보를 조회한다.
	 * @category VOP_PSO_0211,2
	 * @param  String ydCd
	 * @param  String costCd
	 * @param  String year
	 * @param  String uid
	 * @param  String acctcd
	 * @return   List<MdmVendorVO>
	 * @throws   EventException
	 */			
	public List<MdmVendorVO> searchVendorByYardAndCost(String ydCd, String costCd, String year, String uid, String acctcd)  throws EventException {
		try {
			return dbDao.searchVendorByYardAndCost(ydCd, costCd, year, uid, acctcd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Vendor"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Vendor"}).getMessage(), ex);
		}
	}
	
	/**
	 * 모든 Account & Cost를 조회한다.
	 * @category VOP_PSO_0037
	 * @return   List<AccountAndCostVO>
	 * @throws   EventException
	 */		
	public List<AccountAndCostVO> searchAccountAndCost()  throws EventException {
		try {
			return dbDao.searchAccountAndCost();
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Account & Cost"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Account & Cost"}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Value Management를 조회한다.
	 * @category VOP_PSO_0037
	 * @param    YardChargeVO yardChargeVO
	 * @return   List<YardChargeVO>
	 * @throws   EventException
	 */		
	public List<YardChargeVO> searchYardChargeList(YardChargeVO yardChargeVO)  throws EventException{
		try {
			return dbDao.searchYardChargeList(yardChargeVO);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Tariff Value Management"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Tariff Value Management"}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Value Management를 조회한다.
	 * @category VOP_PSO_0237
	 * @param    YdChgNoDataInfoVO ydChgNoDataInfoVO
	 * @return   List<YdChgNoDataInfoVO>
	 * @throws   EventException
	 */	
	public List<YdChgNoDataInfoVO> searchYdChgNoDataInfo(YdChgNoDataInfoVO ydChgNoDataInfoVO) throws EventException{
		try {
			return dbDao.searchYdChgNoDataInfo(ydChgNoDataInfoVO);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Tariff Value Management"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Tariff Value Management"}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Value Management를  copy한다.
	 * @category VOP_PSO_0237
	 * @param    YdChgNoDataInfoVO[] ydChgNoDataInfoVOs
	 * @param    SignOnUserAccount account
	 * @param    String newYdCd	 
	 * @throws   EventException
	 */	
	
	public void copyTariff(YdChgNoDataInfoVO[] ydChgNoDataInfoVOs, SignOnUserAccount account, String newYdCd) throws EventException{
		try {
		
			//YdChgNoDataInfoVO insertVo = new YdChgNoDataInfoVO();
		
			for ( int i=0; i<ydChgNoDataInfoVOs.length; i++ ) {
				    List<YdChgNoDataInfoVO> insertVoList = new ArrayList<YdChgNoDataInfoVO>();
				    ydChgNoDataInfoVOs[i].setNewYdCd(newYdCd);
					String newYdChgNo = dbDao.searchYardChgNumber().get(0).getYdChgNo(); // yd_chg_no 생성

					String usrid      = account.getUsr_id();
					ydChgNoDataInfoVOs[i].setCreUsrId(usrid);
					ydChgNoDataInfoVOs[i].setUpdUsrId(usrid);
					
					ydChgNoDataInfoVOs[i].setNewYdChgNo(newYdChgNo);
				    insertVoList.add(ydChgNoDataInfoVOs[i]);
				    
				    
				     dbDao.copyPsoChgNo(insertVoList);
				     dbDao.copyPsoYdChgObjList(insertVoList);
				     
				     
				     String ydchgno    = ydChgNoDataInfoVOs[i].getYdChgNo();
				     String ydchgnoseq = ydChgNoDataInfoVOs[i].getYdChgVerSeq();
				     List<SearchChgXprNoVO> lst =  dbDao.searchChgXprNo(ydchgno,ydchgnoseq);
				     
		
				     SearchChgXprNoVO rvo = null;
				     
				     for (int k = 0; k < lst.size(); k++) {
							rvo = lst.get(k);
						
							String chgxprno    = rvo.getChgXprNo();
							String newchgxprno = dbDao.searchPsoChgXprPK();
							dbDao.copyPsoChgXpr(chgxprno,newchgxprno,usrid);
							dbDao.copyPsoChgXprDtl(chgxprno,newchgxprno,usrid);
							
							 List<PsoTariffVO> rlst = dbDao.searchPsoTariff(chgxprno);
							 PsoTariffVO rlvo = null;
							   for (int a = 0; a < rlst.size(); a++) {
								    String newtrfno = dbDao.searchPsoTariffPK();
									rlvo = rlst.get(a);
								
									String psotrfno = rlvo.getPortTrfNo();
									dbDao.copyPsoTariff(psotrfno,newtrfno,newchgxprno,usrid );
									dbDao.copyPsoTrfDtl(psotrfno,newtrfno,usrid );
									
							   }
							   dbDao.copyPsoYdChgXpr( newYdChgNo, newchgxprno, ydchgno, ydchgnoseq, chgxprno, usrid ) ;	
							   dbDao.modifyChgXprDescByChgXprNo(newchgxprno);
				     }
				     
				     
			}
			

	
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Tariff Value Management"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Tariff Value Management"}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Value Management를  copy한다.
	 * @category VOP_PSO_0237
	 * @param    YdChgNoDataInfoVO[] ydChgNoDataInfoVOs
	 * @param    String newYdCd
	 * @throws   EventException
	 */	
	
	public void validationTariff(YdChgNoDataInfoVO[] ydChgNoDataInfoVOs, String newYdCd) throws EventException{
		try {
		
			//YdChgNoDataInfoVO insertVo = new YdChgNoDataInfoVO();
		
			for ( int i=0; i<ydChgNoDataInfoVOs.length; i++ ) {
				     String vndrseq2 = ydChgNoDataInfoVOs[i].getVndrSeq2();
				     String acctcd = ydChgNoDataInfoVOs[i].getAcctCd();
				     dbDao.searchVendorTariffCheck(vndrseq2,newYdCd,acctcd);
				  
				     }
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Tariff of vendor exists."}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Tariff of vendor exists"}).getMessage(), ex);
		}
	}
	
	/**
	 * YD_CHG_NO, YD_CHG_VER_SEQ별로 Object를 조회한다.
	 * @category VOP_PSO_0037
	 * @param    YdChgObjVO ydChgObjVO
	 * @return   List<YdChgObjVO>
	 * @throws   EventException
	 */		
	public List<YdChgObjVO> searchObjByYdChg(YdChgObjVO ydChgObjVO)  throws EventException{
		try {
			return dbDao.searchObjByYdChg(ydChgObjVO);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Regular Value Management"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Regular Value Management"}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Value List를 저장합니다.
	 * @category VOP_PSO_0037
	 * @param TariffValueMgtGRPVO tariffValueMgtGRPVO
	 */
	public void manageTariffValue(TariffValueMgtGRPVO tariffValueMgtGRPVO) throws EventException {
		
		HashMap<String, String> retHash = new HashMap<String, String>();
		try {
			YardChargeVO[] yardChargeVOs = tariffValueMgtGRPVO.getYardChargeVOs();	//Master
			YdChgObjVO[]   ydChgObjVOs   = tariffValueMgtGRPVO.getYdChgObjVOs();	//Detail
			
			/***************************************************************************************************************************************
			 * 1. PSO_YD_CHG 테이블에 데이터 업데이트
			 *************************************************************************************************************************************** 
			 *		- EXP_DT 유효성 체크
			 *		- PSO_YD_CHG 테이블 업데이트
			 ***************************************************************************************************************************************/
			if(yardChargeVOs != null){
				String ydChgNo 		= "";
				String ydChgVerSeq  = "";
				String expDt 		= "";
				String cplsFlg 		= "";
				for(int i=0; i<yardChargeVOs.length; i++){
					ydChgNo 	= yardChargeVOs[i].getYdChgNo();
					ydChgVerSeq = yardChargeVOs[i].getYdChgVerSeq();
					expDt 		= (yardChargeVOs[i].getExpDt() + "").replace("-", "");
					cplsFlg 	= yardChargeVOs[i].getCplsFlg();
					
					//2011.10.31 진마리아, cpls flg와 eff dt 업데이트 로직 분리
					if("O".equals(dbDao.checkExpDateForTariffMgt(yardChargeVOs[i]))){		//EXP_DT 유효성 체크
						dbDao.modifyPsoYdChgExpDtByNo(ydChgNo, ydChgVerSeq, expDt, cplsFlg);	//PSO_YD_CHG 테이블 업데이트(exp dt)
					} else{	
						//throw new EventException(new ErrorHandler("PSO90001", new String[]{"validation pass failed"}).getMessage());
						retHash.put(yardChargeVOs[i].getYdChgNo() + ":" + yardChargeVOs[i].getYdChgVerSeq(), "X");
					}
					
					dbDao.modifyPsoYdChgCplsFlgByNo(ydChgNo, ydChgVerSeq, expDt, cplsFlg);	//PSO_YD_CHG 테이블 업데이트(cpls flg)
				}
			}
			
			/***************************************************************************************************************************************
			 * 2. PSO_YD_CHG_OBJ_LIST 테이블에 데이터 생성 (항상 삭제후)
			 *************************************************************************************************************************************** 
			 *		- PSO_YD_CHG_OBJ_LIST 테이블 YardCharge별로 삭제한다. 
			 *		- PSO_YD_CHG_OBJ_LIST 테이블에 Insert
			 ***************************************************************************************************************************************/
			if(ydChgObjVOs != null){
				//PSO_YD_CHG_OBJ_LIST 테이블 YardCharge별로 삭제한다. 
				if(ydChgObjVOs.length > 0){
					PsoYdChgObjListVO deletePsoYdChgObjListVO = new PsoYdChgObjListVO();
					deletePsoYdChgObjListVO.setYdChgNo(ydChgObjVOs[0].getYdChgNo());
					deletePsoYdChgObjListVO.setYdChgVerSeq(ydChgObjVOs[0].getYdChgVerSeq());
					deletePsoYdChgObjListVO.setObjListNo("");	//YardCharge 모두를 삭제하기 위해
					dbDao.removePsoYdChgObjList(deletePsoYdChgObjListVO);
				}
				//PSO_YD_CHG_OBJ_LIST 테이블에 Insert
				for(int i=0; i<ydChgObjVOs.length; i++){
					if(!"".equals(ydChgObjVOs[i].getRegularValue())){
						PsoYdChgObjListVO insertPsoYdChgObjListVO = new PsoYdChgObjListVO();
						insertPsoYdChgObjListVO.setYdChgNo(ydChgObjVOs[i].getYdChgNo());
						insertPsoYdChgObjListVO.setYdChgVerSeq(ydChgObjVOs[i].getYdChgVerSeq());
						insertPsoYdChgObjListVO.setObjListNo(ydChgObjVOs[i].getObjListNo());
						insertPsoYdChgObjListVO.setDfltCtnt("");
						insertPsoYdChgObjListVO.setDfltVal(ydChgObjVOs[i].getRegularValue());
						insertPsoYdChgObjListVO.setDfltFlg("");
						insertPsoYdChgObjListVO.setCreUsrId(tariffValueMgtGRPVO.getAccount().getUsr_id());
						dbDao.mergePsoYdChgObjList(insertPsoYdChgObjListVO);
					}
				}
			}

		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Tariff Value Management"}).getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Tariff Value Management"}).getMessage(), de);
		}
	}
	
	/**
	 * Expired Date 유효성 체크
	 * @category VOP_PSO_0037
	 * @param    YardChargeVO yardChargeVO
	 * @return   String
	 * @throws   EventException
	 */		
	public String checkExpDateForTariffMgt(YardChargeVO yardChargeVO)  throws EventException{
		try {
			return dbDao.checkExpDateForTariffMgt(yardChargeVO);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Invalid Expired Date"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Invalid Expired Date"}).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice Count 체크
	 * @category VOP_PSO_0037
	 * @param    YardChargeVO yardChargeVO
	 * @return   String
	 * @throws   EventException
	 */		
	public String getInvCnt(YardChargeVO yardChargeVO)  throws EventException{
		try {
			return dbDao.getInvCnt(yardChargeVO);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Invoice Count"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Invoice Count"}).getMessage(), ex);
		}
	}

	/**
	 * Tariff 정보를 삭제한다.
	 * 
	 * @category VOP_PSO_0037
	 * @param yardChargeVO
	 * @throws EventException
	 */
	public void deleteTariffAttribute( YardChargeVO yardChargeVO )throws EventException{
		
		/***************************************************************************************************************************************
		 * <Delete Sequence>
		 ***************************************************************************************************************************************
		 * 1. PSO_COND_DTL		  데이터 삭제
		 * 2. PSO_CONDITION	  	  데이터 삭제
		 * 3. PSO_FOML_DTL		  데이터 삭제	
		 * 4. PSO_FORMULA	  	  데이터 삭제 	
		 * 5. PSO_CHG_XPR_DTL	  데이터 삭제
		 * 6. PSO_CHG_XPR		  데이터 삭제
		 * 7. PSO_YD_CHG_OBJ_LIST 데이터 삭제
		 * 8. PSO_YD_CHG		  데이터 삭제	
		 * 9. PSO_YD_CHG_XPR	  데이터 삭제	
		 * 10.PSO_TRF_DTL        데이터 삭제
		 * 11.PSO_TARIFF         데이터 삭제 
		 ***************************************************************************************************************************************/
		
		String vYdChgNo 	= yardChargeVO.getYdChgNo();
		String vYdChgVerSeq	= yardChargeVO.getYdChgVerSeq();
		
		try {
			
			
			YardChargeVO deleteYardChargeVO = new YardChargeVO();
			deleteYardChargeVO.setYdChgNo(vYdChgNo);
			deleteYardChargeVO.setYdChgVerSeq(vYdChgVerSeq);
			
//			//1. PSO_COND_DTL		  데이터 삭제
//			dbDao.removeTariffFromPsoCondDtl(deleteYardChargeVO);
//
//			//2. PSO_CONDITION	  데이터 삭제
//			dbDao.removeTariffFromPsoCondition(deleteYardChargeVO);
//			
//			//3. PSO_FOML_DTL		  	데이터 삭제	
//			dbDao.removeTariffFromPsoFomlDtl(deleteYardChargeVO);
//			
//			//4. PSO_FORMULA	  	데이터 삭제 	
//			dbDao.removeTariffFromPsoFormula(deleteYardChargeVO);
		
			//10. PSO_TRF_DTL		 	 데이터 삭제
			dbDao.removeTariffFromPsoTrfDtl(deleteYardChargeVO);
			
			//11. PSO_TARIFF 	 	 데이터 삭제
			dbDao.removeTariffFromPsoTariff(deleteYardChargeVO);
			
			//5. PSO_CHG_XPR_DTL
			dbDao.removeTariffFromPsoChgXprDtl(deleteYardChargeVO);
	
			//6. PSO_CHG_XPR
			dbDao.removeTariffFromPsoChgXpr(deleteYardChargeVO);

			//7. PSO_YD_CHG_OBJ_LIST 데이터 삭제
			dbDao.removeTariffFromPsoYdChgObjList(deleteYardChargeVO);
			
			//8. PSO_YD_CHG		  데이터 삭제	
			dbDao.removeTariffFromPsoYdChg(deleteYardChargeVO);
			
			//9. PSO_YD_CHG_XPR		 	 데이터 삭제
			dbDao.removeTariffFromPsoYdChgXpr(deleteYardChargeVO);
			
		
			
		} catch (EventException ex) {
			throw ex;	
		} catch(DAOException ex) {
			log.error(">>DAOException :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90012",new String[]{"Tariff"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90012",new String[]{"Tariff"}).getMessage(), ex);
		}
	}	
	
	/**
	 * Tariff upload file 을 조회합니다.
	 * 
	 * @category VOP_PSO_0041
	 * @param TariffAtchFileVO tariffAtchFileVO
	 * @return List<PsoTrfAtchFileVO>
	 * @throws EventException
	 */
	public List<PsoTrfAtchFileVO> searchPsoTrfAtchFileList(TariffAtchFileVO tariffAtchFileVO) throws EventException {

		List<PsoTrfAtchFileVO> list = null;
		try {
			list = dbDao.searchPsoTrfAtchFileList(tariffAtchFileVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}

		return list;		
	}
	
	/**
	 * Tariff upload file 을 저장합니다.
	 * 
	 * @category VOP_PSO_0041
	 * @param TariffAtchFileVO tariffAtchFileVO
	 * @throws EventException
	 */
	public void manageTariffUploadFile(TariffAtchFileVO tariffAtchFileVO) throws EventException {
		
		PsoTrfAtchFileVO[] fileVOs = tariffAtchFileVO.getPsoTrfAtchFileVOs();
		String[] fileSavId = tariffAtchFileVO.getKeys();
		
		SignOnUserAccount account = tariffAtchFileVO.getAccount();

		try {
			List<PsoTrfAtchFileVO> insertVoList = new ArrayList<PsoTrfAtchFileVO>();
			List<PsoTrfAtchFileVO> deleteVoList = new ArrayList<PsoTrfAtchFileVO>();
			
			int fileSavIdIndex = 0;
			
			for (PsoTrfAtchFileVO fileVO : fileVOs) {
				
				fileVO.setYdChgNo(tariffAtchFileVO.getYdChgNo());
				fileVO.setYdChgVerSeq(tariffAtchFileVO.getYdChgVerSeq());
				fileVO.setAtchFileDivCd(tariffAtchFileVO.getAtchFileDivCd());
				
				if (fileVO.getIbflag().equals("U")) {
					deleteVoList.add(fileVO);
					fileVO.setIbflag("I");
				}
				
				if (fileVO.getIbflag().equals("D")) {
					deleteVoList.add(fileVO);
					UpdateFileMetaInfo.delete(fileVO.getFileSavId());
				}
				else if (fileVO.getIbflag().equals("I")) {
					if (StringUtils.isEmpty(fileVO.getFileSavId())) {
						fileVO.setFileSavId(fileSavId[fileSavIdIndex++]);
					}				
					fileVO.setCreUsrId(account.getUsr_id());
					fileVO.setUpdUsrId(account.getUsr_id());					

					insertVoList.add(fileVO);
				}				
			}
			
			if (deleteVoList.size() > 0) {
				dbDao.removePsoTrfAtchFile(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addPsoTrfAtchFile(insertVoList);
			}
			
		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} 
		catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
	}
	
	/**
	 * VNDR_SEQ로 CURRENCY를 조회한다.
	 * @category VNDR_SEQ로 CURRENCY조회
	 * @param  String vndrSeq
	 * @return String
	 * @throws EventException
	 */
	public String searchCurrencyByVndrSeq(String vndrSeq) throws EventException {
		try {
			return dbDao.searchCurrencyByVndrSeq(vndrSeq);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Local Currency"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Local Currency"}).getMessage(), ex);
		}
	}	
	
	/**
	 * Yard Charge에 등록된 Remark를 조회한다.
	 * @category VOP_PSO_0042
	 * @param  PortTariffListVO portTariffListVO
	 * @return List<YardChargeVersionVO>
	 * @throws EventException
	 */	
	public List<YardChargeVersionVO> searchYardChargeRemark(PortTariffListVO portTariffListVO) throws EventException {
		try {
			return dbDao.searchYardChargeRemark(portTariffListVO);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Local Currency"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Local Currency"}).getMessage(), ex);
		}
	}	
	
//	/**
//	 *  vendor 로  tariff 존재 여부 확인
//	 * @category VOP_PSO_0237
//	 * @param  String vndrSeq
//	 * @return String
//	 * @throws EventException
//	 */	
//	public String searchVendorTariffCheck(String vndrSeq)throws EventException {
//		try {
//			return dbDao.searchVendorTariffCheck(vndrSeq);
//		} catch(DAOException ex) {
//			log.error(">>DAOException BC :" + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Local Currency"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error(">>Exception BC : " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Local Currency"}).getMessage(), ex);
//		}
//	}	
//	
	/**
	 * yard 존재 여부 확인
	 * @category VOP_PSO_0237
	 * @param  String ydCd
	 * @return String
	 * @throws EventException
	 */	
	public String searchMdmYardCheck(String ydCd)throws EventException {
		try {
			return dbDao.searchMdmYardCheck(ydCd);
		} catch(DAOException ex) {
			log.error(">>DAOException BC :" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Local Currency"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Local Currency"}).getMessage(), ex);
		}
	}	
	
//	/*
//	 * CHM-201006949-01
//	 */
//	/**
//	 * 해당 PortCd와 CostCd를 가지는 Tariff List를 조회한다.
//	 * 
//	 * @param String portCd
//	 * @param String costCd
//	 * @return List<TariffListWithYdNmVO>
//	 * @exception EventException
//	 */
//	public List<TariffListWithYdNmVO> searchTariffWithCostCd(String portCd, String costCd) throws EventException {
//		try {
//			return dbDao.searchTariffWithCostCd(portCd, costCd);
//		} catch(DAOException ex) {
//			log.error(">>DAOException BC :" + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Tariff List"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error(">>Exception BC : " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("PSO90010",new String[]{"Tariff List"}).getMessage(), ex);
//		}
//	}
}