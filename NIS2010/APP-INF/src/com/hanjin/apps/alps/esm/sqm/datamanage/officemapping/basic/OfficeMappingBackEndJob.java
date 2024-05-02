/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : OfficeMappingBackEndJob.java
*@FileTitle      : 
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.22
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.22 SQM USER
* 1.0 Creation
* History
* 2015.05.12 김용습 [CHM-201535562] [SQM] Sector-Office Relation Setting for IAS Sector - 타임아웃 방지를 위해 데이터를 반으로 나누어 생성되게 함 
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.basic;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.basic.BasicDataBC;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration.OfficeMappingDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * - Qta Freezing 에 대한 BackEndJob<br>
 *
 * @author SQM USER
 * @see BasicDataBC
 * @since J2EE 1.6
 */
public class OfficeMappingBackEndJob  extends BackEndCommandSupport{
	
	private static final long serialVersionUID = -2031526954169419719L;
	
	private OfficeMappingDBDAO dbDao = new OfficeMappingDBDAO();
	
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
			if ( conditionVO.getFGubun().equals("SectorOffice") ) {
				dbDao.createSectorOfcRelationSet(conditionVO, conditionVO.getFUsrId());
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return null;
	}
}
