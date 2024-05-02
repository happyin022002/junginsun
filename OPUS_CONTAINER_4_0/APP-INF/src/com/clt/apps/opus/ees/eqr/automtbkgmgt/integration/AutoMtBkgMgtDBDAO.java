/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: CntrAccuracyTrendDBDAO.java
*@FileTitle 	: Accuracy
*Open Issues 	:
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.automtbkgmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.clt.apps.opus.ees.eqr.automtbkgmgt.vo.AutoMtBkgVO;
import com.clt.apps.opus.ees.eqr.common.Constants;
import com.clt.apps.opus.ees.eqr.common.Utils;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.event.EesCommonEvent;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.integration.CommonDBDAOSearchLocYardInfoRSQL;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.*;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.CheckBkgVolumeTargetVO;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.vo.EesEqr0059ConditionVO;
import com.clt.apps.opus.ees.eqr.automtbkgmgt.vo.EesEqr0059MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0080MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0094ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0112ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0113ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0130ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0143MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.ModifyFromTrsOffHireReturnVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgCntrVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchBeforeCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCheckCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchCntrRepoExecutionPlanEstablishVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrAllWeeksPlanAccessGrantVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrOnfHirExePlnByOffHireReturnVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchEqrOrganizationVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanBkgNoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoExcelVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrListVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanSplitCntrVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchSendHistoryVO;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.EqrEccInterExePlnQtyVO;
import com.clt.syscommon.common.table.EqrEccInterExePlnVO;
import com.clt.syscommon.common.table.EqrExePlnCntrVO;
import com.clt.syscommon.common.table.EqrInlndTrspExePlnQtyVO;
import com.clt.syscommon.common.table.EqrInlndTrspExePlnVO;
import com.clt.syscommon.common.table.EqrInlndTrspPlnQtyVO;
import com.clt.syscommon.common.table.EqrInlndTrspPlnVO;
import com.clt.syscommon.common.table.EqrOnfHirExePlnQtyVO;
import com.clt.syscommon.common.table.EqrOnfHirExePlnVO;
import com.clt.syscommon.common.table.EqrOnfHirPlnQtyVO;
import com.clt.syscommon.common.table.EqrOnfHirPlnVO;
import com.clt.syscommon.common.table.EqrRepoExeSoIfVO;
import com.clt.syscommon.common.table.EqrVslExePlnQtyVO;
import com.clt.syscommon.common.table.EqrVslLodgDchgExePlnVO;
import com.clt.syscommon.common.table.EqrVslLodgDchgPlnQtyVO;

/**
 * OPUS AutoMtBkgMgtDBDAO <br>
 * - OPUS-Accuracy system Business Logic.<br>
 * @author 	
 * @see 	CntrAccuracyTrendBCImpl.java
 * @since 	J2EE 1.6
 */
public class AutoMtBkgMgtDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Retrieve<br>
	 * 정보를 조회합니다.<br>
	 * 
	 * @return List<AutoMtBkgVO>
	 * @exception DAOException
	 */
	public List<AutoMtBkgVO> searchAutoMtBkg() throws DAOException { 
		DBRowSet dbRowset = null;
		List<AutoMtBkgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AutoMtBkgMgtDBDAOSearchBasicDataRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutoMtBkgVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}