/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName       : StatusManageBackEndJob.java
*@FileTitle      : Qta Freezing
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.08.19
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.08.19 CSQ USER
* 1.0 Creation
* History
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.statusmanage.basic;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.planning.statusmanage.basic.StatusManageBC;
import com.clt.apps.opus.esm.csq.planning.statusmanage.integration.StatusManageDBDAO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * - Qta Freezing 에 대한 BackEndJob<br>
 *
 * @author CSQ USER
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
			} else if ( conditionVO.getFGubun().equals("Transfer") ) {
				dbDao.createTransferCsqDatRlt(conditionVO);
				dbDao.createTransferCsqDirConv(conditionVO);
				dbDao.createTransferCsqQtaTgtVvd(conditionVO);
				dbDao.createTransferCsqQtaLaneOfc(conditionVO);
				dbDao.createTransferCsqQtaLaneOfcCost(conditionVO);
				dbDao.createTransferCsqQtaStepVer(conditionVO);
				dbDao.createTransferCsqQtaLodRev(conditionVO);
				dbDao.createTransferCsqQtaPotnMgmt(conditionVO);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return null;
	}
}
