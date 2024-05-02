/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSendDBDAO.java
*@FileTitle : VskEmailSend
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.26
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.07.26 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.vo.SceEmlJbSubscSubVO;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.vo.SceEmlSndRsltSubscVO;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.vo.vslSkdCtntVO;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.vo.vslSkdEmlVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * VskEmailSendEAIDAO <br>
 * - EmailJobManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Jun Yong
 * @see VskEmailSendBCImpl 참조
 * @since J2EE 1.6
 */
public class VskEmailSendDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * @param String eml_jb_id
	 * @return List<SceVslSkdEmlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<vslSkdEmlVO> searchVslSkdEmlJob (String eml_jb_id) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<vslSkdEmlVO> vslSkdEmlVo = new ArrayList<vslSkdEmlVO>();

		try {
			param.put("emlJbId", eml_jb_id);
			velParam.put("emlJbId", eml_jb_id);
			
			dbRowset = new SQLExecuter("")
			.executeQuery(
					(ISQLTemplate) new VskEmailSendDBDAOSearchVslSkdEmlJobRSQL(),
					param, velParam);
			
			vslSkdEmlVo = (List)RowSetUtil.rowSetToVOs(dbRowset, vslSkdEmlVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslSkdEmlVo;
	}
	
	/**
	 * @param vslSkdEmlVO vslSkdEmlVo
	 * @returnList List<vslSkdCtntVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<vslSkdCtntVO> searchVslSkdCtnt(vslSkdEmlVO vslSkdEmlVo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int durId = 0;
		
		List<vslSkdCtntVO> vslSkdCtntVo = new ArrayList<vslSkdCtntVO>();
		
		try {
			if( vslSkdEmlVo.getVskdDurId().length() == 2 ){
				if( vslSkdEmlVo.getVskdDurId().substring(1).equals("D") ){
					durId = Integer.parseInt(vslSkdEmlVo.getVskdDurId().substring(0, 1)) * 1;					
				}else if( vslSkdEmlVo.getVskdDurId().substring(1).equals("W") ){
					durId = Integer.parseInt(vslSkdEmlVo.getVskdDurId().substring(0, 1)) * 7;					
				}else if( vslSkdEmlVo.getVskdDurId().substring(1).equals("Q") ){
					durId = Integer.parseInt(vslSkdEmlVo.getVskdDurId().substring(0, 1)) * 30;
				}
			}else if( vslSkdEmlVo.getVskdDurId().length() == 3 ){
				if( vslSkdEmlVo.getVskdDurId().substring(2).equals("D") ){
					durId = Integer.parseInt(vslSkdEmlVo.getVskdDurId().substring(0, 2)) * 1;					
				}else if( vslSkdEmlVo.getVskdDurId().substring(2).equals("W") ){
					durId = Integer.parseInt(vslSkdEmlVo.getVskdDurId().substring(0, 2)) * 7;					
				}else if( vslSkdEmlVo.getVskdDurId().substring(2).equals("Q") ){
					durId = Integer.parseInt(vslSkdEmlVo.getVskdDurId().substring(0, 2)) * 30;
				}
			}
			
			param.put("slanCd", vslSkdEmlVo.getVslSlanCd());
			velParam.put("slanCd", vslSkdEmlVo.getVslSlanCd());
			
			param.put("toPortCd", vslSkdEmlVo.getToPortCd());
			velParam.put("toPortCd", vslSkdEmlVo.getToPortCd());
			
			param.put("vskdDurId", durId);
			velParam.put("vskdDurId", durId);
			
			dbRowset = new SQLExecuter("")
			.executeQuery(
					(ISQLTemplate) new VskEmailSendDBDAOSearchVslSkdCtntRSQL(),
					param, velParam);
			
			vslSkdCtntVo = (List) RowSetUtil.rowSetToVOs(dbRowset, vslSkdCtntVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vslSkdCtntVo;
	}

	/**
	 * @param vslSkdEmlVO vslSkdEmlVo
	 * @return SceEmlJbSubscSubVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SceEmlJbSubscSubVO> searchVslSkdEmlSubsc(vslSkdEmlVO vslSkdEmlVo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<SceEmlJbSubscSubVO> sceEmlJbSubscSubVO = new ArrayList<SceEmlJbSubscSubVO>();
		
		try {
			param.put("emlGrpId", vslSkdEmlVo.getEmlGrpId());
			velParam.put("emlGrpId", vslSkdEmlVo.getEmlGrpId());
			
			param.put("subScEml", vslSkdEmlVo.getSubscEml());
			velParam.put("subScEml", vslSkdEmlVo.getSubscEml());
			
			dbRowset = new SQLExecuter("")
			.executeQuery(
					(ISQLTemplate) new VskEmailSendDBDAOSearchVslSkdEmlSubscRSQL(),
					param, velParam);
			
			sceEmlJbSubscSubVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SceEmlJbSubscSubVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sceEmlJbSubscSubVO;
	}

	/**
	 * @param sceEmlSndRsltSubscVO
	 * @throws DAOException
	 */
	public void addEmlSndRslt(SceEmlSndRsltSubscVO sceEmlSndRsltSubscVO) throws DAOException {
		List<SceEmlSndRsltSubscVO> model = new ArrayList<SceEmlSndRsltSubscVO>();
		try {			
			model.add(sceEmlSndRsltSubscVO);
			new SQLExecuter("DEFAULT")
			.executeBatch((ISQLTemplate) new VskEmailSendDBDAOAddEmlSndRsltCSQL(),
					model, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
}