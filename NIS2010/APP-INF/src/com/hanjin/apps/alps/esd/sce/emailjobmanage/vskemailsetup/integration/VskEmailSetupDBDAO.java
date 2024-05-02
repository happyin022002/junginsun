/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSetupDBDAO.java
*@FileTitle : VSL SKD e-mailing Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.06
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.08.06 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.basic.VskEmailSetupBCImpl;
import com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.event.EsdSce0119Event;
import com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsetup.vo.VslSkdEmlSetUpVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsend.integration.VskEmailSendEAIDAO;


/**
 * ALPS VskEmailSetupDBDAO <br>
 * - ALPS-EmailJobManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Jun Yong
 * @see VskEmailSetupBCImpl 참조
 * @since J2EE 1.6
 */
public class VskEmailSetupDBDAO extends DBDAOSupport {
	
	/**
	 * VSL E-MAIL 대상 조회<br>
	 * @return GeneralEventResponse
	 * @throws DAOException
	 */
	public GeneralEventResponse searchVslSkdEmlSetUp() throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dRs = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new VskEmailSetupDBDAOSearchVslSkdEmlSetUpRSQL(), null, null);
			eventResponse.setRsVo(dRs);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * @param event
	 * @throws DAOException
	 */
	public void addVslSkdEmlSetUp(EsdSce0119Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		ArrayList st = null;
		ArrayList stSeq = null;
		ArrayList stEml = null;
		DBRowSet dRs = null;
		DBRowSet rowSet = null;
		DBRowSet seqRowSet = null;
		int subSeq = 0;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		VslSkdEmlSetUpVO[] model = event.getVslSkdEmlSetUpVos();
		
		int insCnt = 0;
		
		try {
			for( int i=0; i<model.length; i++ ) {
				if( model != null || !"".equals(model[i].getSubscEml()) ){
					st = seperationParameter(model[i].getSubscEml(), ";");
					stSeq = seperationParameter(model[i].getSubscSeqHis(), ";");
					stEml = seperationParameter(model[i].getSubscEmlHis(), ";");
				}
				
				for( int j=0; j<st.size(); j++ ){
					if( st != null || !"".equals((String)st.get(j)) ){
						model[i].setSubscEml((String)st.get(j));
						param.put("subscEml", model[i].getSubscEml());
					}else{
						param.put("subscEml", "");
					}
					
					if( stSeq == null || j > stSeq.size()-1 ){
						param.put("subscSeqHis", "");
					}else if( stSeq != null || !((String)stSeq.get(j)).equals("") ){
						model[i].setSubscSeqHis((String)stSeq.get(j));
						param.put("subscSeqHis", model[i].getSubscSeqHis());
					}
					
					if( stEml == null || j > stSeq.size()-1 ){
						param.put("subscEmlHis", "");					
					}else if( stEml != null || !((String)stEml.get(j)).equals("") ){
						model[i].setSubscEmlHis((String)stEml.get(j));
						param.put("subscEmlHis", model[i].getSubscEmlHis());
					}
					
					
					if( j == 0 ){
						if( model[i].getEmlJbId().equals("")){
							param.put("emlJbId", "VSK_LANE_PORT");
						}else{
							param.put("emlJbId", model[i].getEmlJbId());
						}						
						param.put("emlGrpId", model[i].getEmlGrpId());
						param.put("vslSlanCd", model[i].getVslSlanCd());
						param.put("toPortCd", model[i].getToPortCd());
						param.put("vskdDurId", model[i].getVskdDurId());					
						param.put("svcStDt", model[i].getSvcStDt());
						param.put("svcEndDt", model[i].getSvcEndDt());
						param.put("emlSndHr", model[i].getEmlSndHr());
						
						String emlSndDysCtnt = "";
						
						if( model[i].getEmlSndDysCtntSun().endsWith("1") ){
							emlSndDysCtnt = "1";
						}
						
						if( model[i].getEmlSndDysCtntMon().endsWith("1") ){
							if( emlSndDysCtnt.equals("") ){
								emlSndDysCtnt = "2";
							}else{
								emlSndDysCtnt = emlSndDysCtnt + "," + "2";
							}
						}
						
						if( model[i].getEmlSndDysCtntTue().endsWith("1") ){
							if( emlSndDysCtnt.equals("") ){
								emlSndDysCtnt = "3";
							}else{
								emlSndDysCtnt = emlSndDysCtnt + "," + "3";
							}
						}
						
						if( model[i].getEmlSndDysCtntWeb().endsWith("1") ){
							if( emlSndDysCtnt.equals("") ){
								emlSndDysCtnt = "4";
							}else{
								emlSndDysCtnt = emlSndDysCtnt + "," + "4";
							}
						}
						
						if( model[i].getEmlSndDysCtntThr().endsWith("1") ){
							if( emlSndDysCtnt.equals("") ){
								emlSndDysCtnt = "5";
							}else{
								emlSndDysCtnt = emlSndDysCtnt + "," + "5";
							}
						}
						
						if( model[i].getEmlSndDysCtntFri().endsWith("1") ){
							if( emlSndDysCtnt.equals("") ){
								emlSndDysCtnt = "6";
							}else{
								emlSndDysCtnt = emlSndDysCtnt + "," + "6";
							}
						}
						
						if( model[i].getEmlSndDysCtntSat().endsWith("1") ){
							if( emlSndDysCtnt.equals("") ){
								emlSndDysCtnt = "7";
							}else{
								emlSndDysCtnt = emlSndDysCtnt + "," + "7";
							}
						}
						
						param.put("emlSndDysCtnt", emlSndDysCtnt);
						param.put("emlGrpIdHis", model[i].getEmlGrpIdHis());
						param.put("emlSndHrHis", model[i].getEmlSndHrHis());
						
						String emlSndDysCtntHis = "";
						
						if( model[i].getEmlSndDysCtntSunHis().endsWith("1") ){
							emlSndDysCtntHis = "1";
						}
						
						if( model[i].getEmlSndDysCtntMonHis().endsWith("1") ){
							if( emlSndDysCtntHis.equals("") ){
								emlSndDysCtntHis = "2";
							}else{
								emlSndDysCtntHis = emlSndDysCtntHis + "," + "2";
							}
						}
						
						if( model[i].getEmlSndDysCtntTueHis().endsWith("1") ){
							if( emlSndDysCtntHis.equals("") ){
								emlSndDysCtntHis = "3";
							}else{
								emlSndDysCtntHis = emlSndDysCtntHis + "," + "3";
							}
						}
						
						if( model[i].getEmlSndDysCtntWebHis().endsWith("1") ){
							if( emlSndDysCtntHis.equals("") ){
								emlSndDysCtntHis = "4";
							}else{
								emlSndDysCtntHis = emlSndDysCtntHis + "," + "4";
							}
						}
						
						if( model[i].getEmlSndDysCtntThrHis().endsWith("1") ){
							if( emlSndDysCtntHis.equals("") ){
								emlSndDysCtntHis = "5";
							}else{
								emlSndDysCtntHis = emlSndDysCtntHis + "," + "5";
							}
						}
						
						if( model[i].getEmlSndDysCtntFriHis().endsWith("1") ){
							if( emlSndDysCtntHis.equals("") ){
								emlSndDysCtntHis = "6";
							}else{
								emlSndDysCtntHis = emlSndDysCtntHis + "," + "6";
							}
						}
						
						if( model[i].getEmlSndDysCtntSatHis().endsWith("1") ){
							if( emlSndDysCtntHis.equals("") ){
								emlSndDysCtntHis = "7";
							}else{
								emlSndDysCtntHis = emlSndDysCtntHis + "," + "7";
							}
						}
						
						param.put("emlSndDysCtntHis", emlSndDysCtntHis);
						param.put("vslSlanCdHis", model[i].getVslSlanCdHis());
						param.put("toPortCdHis", model[i].getToPortCdHis());
						param.put("vskdDurIdHis", model[i].getVskdDurIdHis());
						param.put("fmPortCdHis", model[i].getFmPortCdHis());
						param.put("emlGrpCdDescHis", model[i].getEmlGrpCdDescHis());
						
						rowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new VskEmailSetupDBDAOSearchSetUpDBVerifyRSQL(), param, null);
						
						if( rowSet.getRowCount() < 1 ){
							throw new DAOException("Fail to Lane, Port");
						}
					}		
					
					dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new VskEmailSetupDBDAOSearchSetUpDBDupRSQL(), param, null);
					
					if( dRs.getRowCount() > 0 ){
						if( ( i == model.length-1 || !model[i].getEmlGrpId().equals(model[i+1].getEmlGrpId()) ) && j == st.size()-1 ){
							insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new VskEmailSetupDBDAOModifyEmlJbGrpSetUpUSQL(), param, null);
							if(insCnt == Statement.EXECUTE_FAILED) 
								throw new DAOException("Fail to insert No" + " SQL");						
						}	
						
						if( j == st.size()-1 ){
							insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new VskEmailSetupDBDAOModifyVslSkdEmlSetUpUSQL(), param, null);
							if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No" + " SQL");
							
							insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new VskEmailSetupDBDAOModifyEmlJbSubscSetUpDeltUSQL(), param, null);
							if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No" + " SQL");
						}	
						
						insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new VskEmailSetupDBDAOModifyEmlJbSubscSetUpUSQL(), param, null);
						if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + " SQL");				
					}else{
						if( ( i == model.length-1 || !model[i].getEmlGrpId().equals(model[i+1].getEmlGrpId()) ) && j == st.size()-1 && !model[i].getIbflag().equals("U") && !model[i].getSvcEndDt().equals("COPY") ){							
							insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new VskEmailSetupDBDAOAddEmlJbGrpSetUpCSQL(), param, null);
							if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No" + " SQL");
						}else if( model[i].getSvcEndDt().equals("COPY") && !"".equals(model[i].getEmlSndHrHis()) ){
							insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new VskEmailSetupDBDAOModifyEmlJbGrpSetUpUSQL(), param, null);
							if(insCnt == Statement.EXECUTE_FAILED) 
								throw new DAOException("Fail to insert No" + " SQL");
						}else if( ( i == model.length-1 || !model[i].getEmlGrpId().equals(model[i+1].getEmlGrpId()) ) && j == st.size()-1 && !model[i].getIbflag().equals("U") && model[i].getSvcEndDt().equals("COPY") && "".equals(model[i].getEmlSndHrHis()) ){
							insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new VskEmailSetupDBDAOAddEmlJbGrpSetUpCSQL(), param, null);
							if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No" + " SQL");
						}
						
						param.put("svcEndDt", "");
						
						if( !model[i].getIbflag().equals("U") && j == st.size()-1 ){							
							insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new VskEmailSetupDBDAOAddVslSkdEmlSetUpCSQL(), param, null);
							if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No" + " SQL");												
						}
						
						if( subSeq == 0 ){
							seqRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new VskEmailSetupDBDAOSearchEmlSubSeqRSQL(), param, null);
							
							while( seqRowSet.next() ){
								subSeq = seqRowSet.getInt(1);
							}
						}else{
							subSeq++;
						}
						
						param.put("emlSubSeq", subSeq);
						
						insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new VskEmailSetupDBDAOAddEmlJbSubscSetUpCSQL(), param, null);
						if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + " SQL");	
						
						if( j == st.size()-1 ){
							subSeq = 0;
						}
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}
	
	/**
	 * @param event
	 * @throws DAOException
	 */
	public void removeVslSkdEmlSetUp(EsdSce0119Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		ArrayList st = null;
		ArrayList stSeq = null;
		ArrayList stEml = null;
		DBRowSet dRs = null;
		DBRowSet dRsDup = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		VslSkdEmlSetUpVO[] model = event.getVslSkdEmlSetUpVos();
		
		int insCnt = 0;
		
		try {
			
			for( int i=0; i<model.length; i++ ) {	
								
				if( model != null || !"".equals(model[i].getSubscEml()) ){
					st = seperationParameter(model[i].getSubscEml(), ";");
					stSeq = seperationParameter(model[i].getSubscSeqHis(), ";");
					stEml = seperationParameter(model[i].getSubscEmlHis(), ";");
				}
				
				for( int j=0; j<st.size(); j++ ){
					model[i].setSubscEml((String)st.get(j));
					model[i].setSubscSeqHis((String)stSeq.get(j));
					model[i].setSubscEmlHis((String)stEml.get(j));
					
					param.put("subscEml", model[i].getSubscEml());
					param.put("subscSeqHis", model[i].getSubscSeqHis());
					param.put("subscEmlHis", model[i].getSubscEmlHis());
					
					if( j == 0 ){
						if( model[i].getEmlJbId().equals("")){
							param.put("emlJbId", "VSK_LANE_PORT");
						}else{
							param.put("emlJbId", model[i].getEmlJbId());
						}						
						param.put("emlGrpId", model[i].getEmlGrpId());
						param.put("vslSlanCd", model[i].getVslSlanCd());
						param.put("toPortCd", model[i].getToPortCd());
						param.put("vskdDurId", model[i].getVskdDurId());					
						param.put("svcStDt", model[i].getSvcStDt());
						param.put("svcEndDt", model[i].getSvcEndDt());
						param.put("emlSndHr", model[i].getEmlSndHr());
						param.put("emlGrpIdHis", model[i].getEmlGrpIdHis());
						param.put("emlSndHrHis", model[i].getEmlSndHrHis());
						param.put("vslSlanCdHis", model[i].getVslSlanCdHis());
						param.put("toPortCdHis", model[i].getToPortCdHis());
						param.put("vskdDurIdHis", model[i].getVskdDurIdHis());
						
						String emlSndDysCtntHis = "";
						
						if( model[i].getEmlSndDysCtntSunHis().endsWith("1") ){
							emlSndDysCtntHis = "1";
						}
						
						if( model[i].getEmlSndDysCtntMonHis().endsWith("1") ){
							if( emlSndDysCtntHis.equals("") ){
								emlSndDysCtntHis = "2";
							}else{
								emlSndDysCtntHis = emlSndDysCtntHis + "," + "2";
							}
						}
						
						if( model[i].getEmlSndDysCtntTueHis().endsWith("1") ){
							if( emlSndDysCtntHis.equals("") ){
								emlSndDysCtntHis = "3";
							}else{
								emlSndDysCtntHis = emlSndDysCtntHis + "," + "3";
							}
						}
						
						if( model[i].getEmlSndDysCtntWebHis().endsWith("1") ){
							if( emlSndDysCtntHis.equals("") ){
								emlSndDysCtntHis = "4";
							}else{
								emlSndDysCtntHis = emlSndDysCtntHis + "," + "4";
							}
						}
						
						if( model[i].getEmlSndDysCtntThrHis().endsWith("1") ){
							if( emlSndDysCtntHis.equals("") ){
								emlSndDysCtntHis = "5";
							}else{
								emlSndDysCtntHis = emlSndDysCtntHis + "," + "5";
							}
						}
						
						if( model[i].getEmlSndDysCtntFriHis().endsWith("1") ){
							if( emlSndDysCtntHis.equals("") ){
								emlSndDysCtntHis = "6";
							}else{
								emlSndDysCtntHis = emlSndDysCtntHis + "," + "6";
							}
						}
						
						if( model[i].getEmlSndDysCtntSatHis().endsWith("1") ){
							if( emlSndDysCtntHis.equals("") ){
								emlSndDysCtntHis = "7";
							}else{
								emlSndDysCtntHis = emlSndDysCtntHis + "," + "7";
							}
						}
						
						param.put("emlSndDysCtntHis", emlSndDysCtntHis);
					}		
					
					dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new VskEmailSetupDBDAOSearchSetUpDBDupRSQL(), param, null);
					
					if( dRs.getRowCount() > 0 ){
						if( j == st.size() - 1 ){							
							insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new VskEmailSetupDBDAORemoveEmlJbSubscSetUpDSQL(), param, null);
							if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No" + " SQL");
							
							insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new VskEmailSetupDBDAORemoveVslSkdEmlSetUpDSQL(), param, null);
							if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No" + " SQL");							
							
							dRsDup = new SQLExecuter("").executeQuery((ISQLTemplate)new VskEmailSetupDBDAORemoveSetUpDBDupRSQL(), param, null);
							
							if( dRsDup.getRowCount() < 1 ){
								insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new VskEmailSetupDBDAORemoveEmlJbGrpSetUpDSQL(), param, null);
								if(insCnt == Statement.EXECUTE_FAILED)
									throw new DAOException("Fail to insert No" + " SQL");									
							}
						}												
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}
	
	/**
	 * @param event
	 * @return GeneralEventResponse
	 * @throws DAOException
	 */
	public GeneralEventResponse searchLaneVerify(EsdSce0119Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dRs = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("vslSlanCd", event.getLaneCdVerify());
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new VskEmailSetupDBDAOSearchLaneVerifyRSQL(), param, null);
			
			if( dRs.getRowCount() < 1 ){
				throw new DAOException("Fail to Lane Code");					
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return null;
	}	
	
	/**
	 * @param event
	 * @return GeneralEventResponse
	 * @throws DAOException
	 */
	public GeneralEventResponse searchPortVerify(EsdSce0119Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dRs = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("portCd", event.getPortCdVerify());
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new VskEmailSetupDBDAOSearchPortVerifyRSQL(), param, null);

			if( dRs.getRowCount() < 1 ){
				throw new DAOException("Fail to Port Code");					
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return null;
	}	
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return ArrayList
	 */
	private ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if(sparameter != null && !sparameter.equals("")) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}
}