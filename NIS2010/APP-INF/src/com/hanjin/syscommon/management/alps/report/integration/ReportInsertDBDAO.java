/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ReportInsertDBDAO.java
*@FileTitle : Report Designer Insert
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-21
*@LastModifier : YongHoo-Kim
*@LastVersion : 1.0
* 2013-05-21 YongHoo-Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.report.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.management.alps.report.event.ReportInsertHTMLAction;
import com.hanjin.syscommon.management.alps.report.vo.ComEmlVO;
import com.hanjin.syscommon.management.alps.report.vo.ComFaxVO;
import com.hanjin.syscommon.management.alps.report.vo.ReportDesignerVO;


/**
 * NIS2010 ManagementDAO <br>
 * - NIS2010-ReportDesigner system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author YongHoo-Kim
 * @see  ReportInsertHTMLAction 참조
 * @since J2SE 6.0
 */
public class ReportInsertDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 458301050418886379L;
	private String checkFlag = "등록 성공 :)";

	/**
	 * MRD를 등록한다<br>
	 * 
	 * @param ReportDesignerVO reportDesignerVO
	 * @return checkFlag insert의 성공여부를 담은 변수
	 * @Exception DAOException
	 */
	public String insertReportDesigner(ReportDesignerVO reportDesignerVO) throws DAOException {
		try {
			int insCnt;
			Map<String, Object> mapParam = new HashMap<String, Object>();
			Map<String, String> mapVO = reportDesignerVO.getColumnValues();
			mapParam.putAll(mapVO);

			insCnt = new SQLExecuter("").executeUpdate(new ReportInsertDAOComRDCSQL(), mapParam, null);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert No SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return checkFlag;
	}
	
	/**
	 * MRD에 등록하기위한 RDnumber 계산을 위핸 가장 최근 RDnumber 조회<br>
	 * 
	 * @param String rdsubsyscd
	 * @return rdapplcd
	 * @Exception SQLException, DAOException
	 */
	public String getRdAppCdDBData(String rdsubsyscd) throws SQLException, DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("rd_appl_cd", rdsubsyscd);
		DBRowSet dbRowset = new SQLExecuter("").executeQuery(new ReportInsertDAORdAppCdRSQL(), param, null);
		dbRowset.next();
		String rdapplcd = dbRowset.getString(1);
		return rdapplcd;
	}
	
	/**
	 * RD를 조회한다<br>
	 * 
	 * @param String rdSubSysCdDbValue
	 * @return List<ReportDesignerVO>
	 * @Exception DAOException
	 */
	public List<ReportDesignerVO> searchReportDesigner(String rdSubSysCdDbValue) throws DAOException{
		List<ReportDesignerVO> searchRdModulVOs = null;
		try{
			Map<String,Object> mapParam = new HashMap<String, Object>();
			mapParam.put("rd_sub_sys_cd", rdSubSysCdDbValue);
			searchRdModulVOs = (List) new SQLExecuter("").executeQuery(new ReportSearchDAOComRDRSQL(), mapParam,null,ReportDesignerVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchRdModulVOs;
	}
	
	/**
	 * Email RD Info를 조회한다<br>
	 * 
	 * @param String emlSndNo
	 * @return List<ComEmlVO>
	 * @Exception DAOException
	 */
	public List<ComEmlVO> searchRdEmlInfo(String emlSndNo) throws DAOException{
		List<ComEmlVO> emlVOs = null;
		try{
			Map<String,Object> mapParam = new HashMap<String, Object>();
			mapParam.put("EML_SND_NO", emlSndNo);
			emlVOs = (List) new SQLExecuter("").executeQuery(new RdSndInfoDAOComEmlRSQL(), mapParam, null, ComEmlVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return emlVOs;
	}
	
	/**
	 * Fax RD Info를 조회한다<br>
	 * 
	 * @param String faxSndNo
	 * @return List<ComFaxVO>
	 * @Exception DAOException
	 */
	public List<ComFaxVO> searchRdFaxInfo(String faxSndNo) throws DAOException{
		List<ComFaxVO> faxVOs = null;
		try{
			Map<String,Object> mapParam = new HashMap<String, Object>();
			mapParam.put("FAX_SND_NO", faxSndNo);
			faxVOs = (List) new SQLExecuter("").executeQuery(new RdSndInfoDAOComFaxRSQL(), mapParam, null, ComFaxVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return faxVOs;
	}
}
