/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAO.java
*@FileTitle : SPCL CGO APVL for Partner Lines (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.24 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.cargoapprovalcommon.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.cargoapprovalcommon.vo.ScgCargoApprovalCommonVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBCImpl;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstFileVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrRequestListOptionVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.SearchPrnrDGListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.SearchPrnrScgListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ScgAuthorizationVO;


/**
 * OPUS CargoApprovalCommonDBDAO <br>
 * - OPUS-CargoLoadingApproval system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HyunUk Kim
 * @see PartnerLinesDangerousCargoApprovalBCImpl 참조
 * @since J2EE 1.6
 */
public class CargoApprovalCommonDBDAO extends DBDAOSupport { 
	
	   /**
		 * SPCL CGO APVL for Own BKG, SPCL CGO APVL/Inquiry for Partner Lines 의 Approval Reference No. 를 조회 합니다. <br>
		 * 
		 * @param scgCargoApprovalCommonVO ScgCargoApprovalCommonVO
		 * @return String
		 * @throws DAOException
		 */
		
			public String searchSpclAproRefNo(ScgCargoApprovalCommonVO scgCargoApprovalCommonVO) throws DAOException {
			
			DBRowSet dbRowset = null;
			String aproRefNo = "";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(scgCargoApprovalCommonVO != null ){
					Map<String, String> mapVO = scgCargoApprovalCommonVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CargoApprovalCommonDBDAOSearchAproRefNoRSQL(), param, velParam);
				if(dbRowset.next()) aproRefNo = dbRowset.getString(1);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return aproRefNo;
		}
		
	}