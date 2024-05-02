/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeInvoiceBCImpl.java
*@FileTitle : Requested Actual Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.23 김진일
* 1.0 Creation
* 
* History
* 2012.03.22 진마리아 CHM-201216307-01 Canal invoice 화면 변경 및 File download 기능 개발
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가 - file download는 전도금이 아닌 invoice 화면으로 수정
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.basic;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzOwnerAccountInterfaceVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration.CanalTransitFeeInvoiceDBDAO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.AtchFileVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlCondVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeSummaryVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzFeeInvDtlByVvdOwnerAccountVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.TariffAtchFileVO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PsoCnlTzAtchFileVO;
import com.hanjin.syscommon.common.table.PsoTrfAtchFileVO;

/**
 * ALPS-EstimateInvoiceAudit Business Logic Basic Command implementation<br>
 * - ALPS-EstimateInvoiceAudit에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0019EventResponse,CanalTransitFeeInvoiceBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CanalTransitFeeInvoiceBCImpl extends BasicCommandSupport implements CanalTransitFeeInvoiceBC {

	// Database Access Object
	private transient CanalTransitFeeInvoiceDBDAO dbDao = null;

	/**
	 * CanalTransitFeeInvoiceBCImpl 객체 생성<br>
	 * CanalTransitFeeInvoiceDBDAO를 생성한다.<br>
	 */
	public CanalTransitFeeInvoiceBCImpl() {
		dbDao = new CanalTransitFeeInvoiceDBDAO();
	}
	/**
	 * Requested Actual Invoice WindowOpen이벤트 조회 : SPP 로 부터 Requested Actual Invoice 를 조회한다
	 * @category VOP_PSO_0019_windowOpen
	 * @param CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO
	 * @return List<CanalTzFeeInvDtlVO>
	 */
	public List<CanalTzFeeInvDtlVO> searchCanalTzFeeInvByVvd(
			CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO)  throws EventException{
		// TODO Auto-generated method stub
		try {
			return dbDao.searchCanalTzFeeInvByVvd(canalTzFeeInvDtlCondVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested Actual Invoice"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested Actual Invoice"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * Requested Actual Invoice WindowOpen이벤트 조회 : SPP 로 부터 온 계정 중 OA 계정만  Requested Actual Invoice 를 조회한다
	 * @category VOP_PSO_0019_windowOpen
	 * @param CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO
	 * @return List<CanalTzFeeInvDtlByVvdOwnerAccountVO>
	 */
	public List<CanalTzFeeInvDtlByVvdOwnerAccountVO> searchCanalTzFeeInvByVvdOwnerAccount(
			CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO)  throws EventException{
		// TODO Auto-generated method stub
		try {
			return dbDao.searchCanalTzFeeInvByVvdOwnerAccount(canalTzFeeInvDtlCondVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested Actual Invoice"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested Actual Invoice"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * Requested Actual Invoice WindowOpen이벤트 조회 : summary data 조회
	 * @category VOP_PSO_0019_windowOpen
	 * @param CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO
	 * @return List<CanalTzFeeSummaryVO>
	 */
	public List<CanalTzFeeSummaryVO> searchCanalTzFeeSummary(
			CanalTzFeeInvDtlCondVO canalTzFeeInvDtlCondVO)  throws EventException{
		// TODO Auto-generated method stub
		try {
			return dbDao.searchCanalTzFeeSummary(canalTzFeeInvDtlCondVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested Actual Invoice"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Requested Actual Invoice"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * FMS 모듈에서 OA 비용에 대한 정보를 조회
	 * @param String vvd
	 * @return List<CanalTzOwnerAccountInterfaceVO>
	 * @throws EventException
	 */
	public List<CanalTzOwnerAccountInterfaceVO> searchCanalTzOwnerAccountInterface(String vvd) throws EventException {
		try {
			return dbDao.searchCanalTzOwnerAccountInterface(vvd); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Canal Invoice"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Canal Invoice"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * Requested Actual Invoice 관련 atch file retrieve
	 * @category VOP_PSO-0215 Open
	 * @param AtchFileVO atchFileVO
	 * @return List<AtchFileVO>
	 */
	public List<AtchFileVO> searchAtchFileList(AtchFileVO atchFileVO) throws EventException {
		try {
			return dbDao.searchAtchFileList(atchFileVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Atch File Retrieve"}).getUserMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Atch File Retrieve"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * Tariff upload file 을 저장합니다.
	 * 
	 * @category VOP_PSO_0215
	 * @param AtchFileVO atchFileVO
	 * @throws EventException
	 */
	public void multiAtchFile(AtchFileVO atchFileVO) throws EventException {
		
		PsoCnlTzAtchFileVO[] fileVOs = atchFileVO.getPsoCnlTzAtchFileVOs();
		String[] fileSavId = atchFileVO.getKeys();
		
		SignOnUserAccount account = atchFileVO.getAccount();

		try {
			List<PsoCnlTzAtchFileVO> insertVoList = new ArrayList<PsoCnlTzAtchFileVO>();
			List<PsoCnlTzAtchFileVO> deleteVoList = new ArrayList<PsoCnlTzAtchFileVO>();
			
			int fileSavIdIndex = 0;
			
			for (PsoCnlTzAtchFileVO fileVO : fileVOs) {	
				
				fileVO.setVslCd(atchFileVO.getVvd().substring(0, 4));
				fileVO.setSkdVoyNo(atchFileVO.getVvd().substring(4, 8));
				fileVO.setSkdDirCd(atchFileVO.getVvd().substring(8));
				fileVO.setYdCd(atchFileVO.getYdCd());
				fileVO.setCallSeq(atchFileVO.getCallSeq());
				fileVO.setLgsCostCd(atchFileVO.getLgsCostCd());

				
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
				dbDao.removeAtchFile(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addAtchFile(insertVoList);
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

}