/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName       : StatusManageBackEndJob.java
*@FileTitle      : Qta Freezing
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.08.19
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.08.19 SQM USER
* 1.0 Creation
* History
* 2016.03.21 [CHM-201640188] 연간 QTA 수립 시 1Q Transfer 관련 로직 수정
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.statusmanage.basic;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration.StatusManageDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * - Qta Freezing 에 대한 BackEndJob<br>
 *
 * @author SQM USER
 * @see StatusManageBC
 * @since J2EE 1.6
 */
public class StatusManageBackEndJob  extends BackEndCommandSupport{
	
	private static final long serialVersionUID = -2031526954169419719L;
	
	private StatusManageDBDAO dbDao = new StatusManageDBDAO();
	
	private ConditionVO conditionVO;
	
	/**
	 * BackEndJob  조회조건을 셋팅한다. <br>
	 *  
	 * @param ConditionVO conditionVO
	 * @exception
	 */	
	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}
	
	/**
	 * BackEndJob 실행 - 프로시져 호출 <br>
	 *  
	 * @return ParamProcedureVO
	 * @exception Exception
	 */	
	@Override
	public Object doStart() throws Exception {
		// TODO Auto-generated method stub
		try{
			if ( conditionVO.getFGubun().equals("Freezing") ) {
				dbDao.createQtaRlseVer(conditionVO);
				dbDao.createCfmTgtVvd(conditionVO);
				dbDao.createCfmQta(conditionVO);
				dbDao.updateCfmQtaAqCd(conditionVO);
				dbDao.createCfmQtaRbcco(conditionVO);
			} else if ( conditionVO.getFGubun().equals("Transfer") ) {				
				
				dbDao.createTransferSqmDatRlt(conditionVO);    	//Basic Data Relation Setting ESM_SQM_0001
				dbDao.createTransferSqmDirConv(conditionVO);	//Lane Direction Change ESM_SQM_0002
				//dbDao.createTransferSqmQtaTgtVvd(conditionVO);//Target VVD Fix ESM_SQM_0005  ->이 부분은 추후 삭제되어야 함(연간 vvd를 1q vvd로 transfter하는 부분. 연간 vvd는 사업계획용 vvd이므로 정확하지 않음)
				dbDao.createTransferSqmQtaLaneOfc(conditionVO);	//Lane Office Relation Setting ESM_SQM_0008
				dbDao.createTransferSqmQtaRbc(conditionVO);		//RBC Lane QTA ESM_SQM_0015 -> RBC 노선 전용 데이터. 최근 이 부분에 data가 없는 것으로 보아 이 부분은 insert가 0건 되더라도 정상 처리로 간주
				dbDao.createTransferSqmQtaLaneOfcCost(conditionVO);	//Basic CMCB (CM Cost Per Box) ESM_SQM_0011
				dbDao.createTransferSqmQtaStepVer(conditionVO);	//QTA Establishing Status Management ESM_SQM_0028
				dbDao.createTransferSqmQtaLodRev(conditionVO);	//QTA Set up by Head Office QTA Set up by Head Office (L/F & G.RPB)
				dbDao.createTransferSqmQtaPotnMgmt(conditionVO);//QTA Set up 관련 4개 화면(by HO, by RHQ_OB Loading, by RHQ_NON OB Contract, by RHQ_OB Contract) 
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return null;
	}
}
