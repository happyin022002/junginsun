/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName       : ConstraintMasterBackEndJob.java
*@FileTitle      : Reprocess
*Open Issues     :
*Change history  :
*@LastModifyDate : 2015.05.08
*@LastModifier   : SPC USER
*@LastVersion    : 1.0
* 2015.05.08 SPC USER
* 1.0 Creation
* History
* 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.basic;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration.ConstraintMasterDBDAO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.sqm.planning.statusmanage.basic.StatusManageBC;
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

public class ConstraintMasterBackEndJob  extends BackEndCommandSupport{
	
	private static final long serialVersionUID = -2031526954169419719L;
	
	private ConstraintMasterDBDAO dbDao = new ConstraintMasterDBDAO();
	
	private SearchConditionVO vo;
	
	/**
	 * BackEndJob  조회조건을 셋팅한다. <br>
	 *  
	 * @param ConditionVO conditionVO
	 * @exception
	 */	
	public void setSearchConditionVO(SearchConditionVO vo) {
		this.vo = vo;
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
			dbDao.doReprocess(vo);

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return null;
	}
}
