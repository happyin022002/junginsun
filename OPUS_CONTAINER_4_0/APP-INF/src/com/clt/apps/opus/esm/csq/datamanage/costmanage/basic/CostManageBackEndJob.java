/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CostManageBackEndJob.java
*@FileTitle      : 
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.14
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2014.01.14 CSQ USER
* 1.0 Creation
* History
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.basic;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.basic.CostManageBC;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.integration.CostManageDBDAO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * - Qta Freezing 에 대한 BackEndJob<br>
 *
 * @author CSQ USER
 * @see CostManageBC
 * @since J2EE 1.6
 */
public class CostManageBackEndJob  extends BackEndCommandSupport{
	
	private static final long serialVersionUID = -2031526954169419719L;
	
	private CostManageDBDAO dbDao = new CostManageDBDAO();
	
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
			if ( conditionVO.getFGubun().equals("CmcbSector") ) {
				dbDao.createBasicCmcbForIasSector(conditionVO, conditionVO.getFUsrId());
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return null;
	}
}
