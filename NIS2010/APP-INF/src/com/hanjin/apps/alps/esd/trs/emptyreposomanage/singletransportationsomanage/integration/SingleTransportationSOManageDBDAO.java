/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAO.java
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-10-30 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.basic.SingleTransportationSOManageBCImpl;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.event.EsdTrs0012Event;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo.SingleTransportationSOManageHdrVO;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo.SingleTransportationSOManageSearchVO;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo.SingleTransportationSOManageVO;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo.TrspSoSeqVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author kim_sang_geun
 * @see SingleTransportationSOManageBCImpl 참조
 * @since J2EE 1.4
 */
public class SingleTransportationSOManageDBDAO extends DBDAOSupport {

	/**
	 * SingleTransportationSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSingleTransportationSOManage(EsdTrs0012Event event) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		SingleTransportationSOManageSearchVO stsoVO = event.getSingleTransportationSOManageSearchVO();
		
		try {
			String reference_no  = stsoVO.getReferenceNo();			
			if( !reference_no.equals("") && !reference_no.equals("null") && reference_no != null) {
				ArrayList<String> arr_ref = null;
				
				arr_ref = CommonUtil.seperationParameter(reference_no, ",");
				param.put("arr_ref", arr_ref);
			}
			String cntr_no = stsoVO.getCntrNo();
			if( !cntr_no.equals("") && !cntr_no.equals("null") && cntr_no != null) {
				ArrayList<String> arr_cntr = null;
				
				arr_cntr = CommonUtil.seperationParameter(cntr_no, ",");
				param.put("arr_cntr", arr_cntr);
			}
			String ctrl_so_office = stsoVO.getCtrlSoOffice();
			if( !ctrl_so_office.equals("") && !ctrl_so_office.equals("null") && ctrl_so_office != null) {
				ArrayList<String> arr_office = null;
				
				arr_office = CommonUtil.seperationParameter(ctrl_so_office, ",");
				param.put("arr_office", arr_office);
			}
			
			param.put("hid_frmreqdate",	 stsoVO.getHidFrmreqdate());  
			param.put("hid_toreqdate",	 stsoVO.getHidToreqdate());
			param.put("sel_kind",		 stsoVO.getSelKind());
			param.put("frm_node",		 stsoVO.getFrmNode()+stsoVO.getHidFmYardCd());
			param.put("to_node",		 stsoVO.getToNode()+stsoVO.getHidToYardCd());
			param.put("cntr_type",		 stsoVO.getCntrType());
			param.put("cntr_size",		 stsoVO.getCntrSize());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new SingleTransportationSOManageDBDAOEmptySearchSingleTrsSoManageRSQL(), param,param);
			

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;
	}

	/**
	 * SingleTransportationSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search01SingleTransportationSOManage(EsdTrs0012Event event) throws DAOException {
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		SingleTransportationSOManageSearchVO stsoVO = event.getSingleTransportationSOManageSearchVO();
		String strOfccd = null;
		try {
			String hid_ref_id  = stsoVO.getHidRefId();		
			if( !hid_ref_id.equals("") && !hid_ref_id.equals("null") && hid_ref_id != null) {
				ArrayList<String> arr_refid = null;
				
				arr_refid = CommonUtil.seperationParameter(hid_ref_id, ",");
				param.put("arr_refid", arr_refid);
			}
			String hid_fm_nod_cd  = stsoVO.getHidFmNodCd();	
			if( !hid_fm_nod_cd.equals("") && !hid_fm_nod_cd.equals("null") && hid_fm_nod_cd != null) {
				ArrayList<String> arr_fmnode = null;
				
				arr_fmnode = CommonUtil.seperationParameter(hid_fm_nod_cd, ",");
				param.put("arr_fmnode", arr_fmnode);
			}
			String hid_to_nod_cd  = stsoVO.getHidToNodCd();
			if( !hid_to_nod_cd.equals("") && !hid_to_nod_cd.equals("null") && hid_to_nod_cd != null) {
				ArrayList<String> arr_tonode = null;
				
				arr_tonode = CommonUtil.seperationParameter(hid_to_nod_cd, ",");
				param.put("arr_tonode", arr_tonode);
			}
			
			String hid_eq_tpsz_cd = stsoVO.getHidEqTpszCd();
			if( !hid_eq_tpsz_cd.equals("") && !hid_eq_tpsz_cd.equals("null") && hid_eq_tpsz_cd != null) {
				ArrayList<String> arr_eq_tpsz = null;
				
				arr_eq_tpsz = CommonUtil.seperationParameter(hid_eq_tpsz_cd, ",");
				param.put("arr_eq_tpsz", arr_eq_tpsz);
			}
			String ctrl_so_office = stsoVO.getCtrlSoOffice();
			if( !ctrl_so_office.equals("") && !ctrl_so_office.equals("null") && ctrl_so_office != null) {
				ArrayList<String> arr_office = null;
				
				arr_office = CommonUtil.seperationParameter(ctrl_so_office, ",");
				param.put("arr_office", arr_office);
			}
			if( stsoVO.getCtrlOfcCd().length() > 2 ) {
				strOfccd = stsoVO.getCtrlOfcCd().substring(0,3);
			}else{
				strOfccd = stsoVO.getCtrlOfcCd();
			}
			param.put("ofc_cty_cd", strOfccd);
			param.put("ctrl_user_id", stsoVO.getCtrlUserId());
						
			dRs = new SQLExecuter("DEFAULT").executeQuery(new SingleTransportationSOManageDBDAOEmptySearch01SingleTrsSOManageRSQL(), param,param);
			

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return dRs;
	}

	/**
	 * SingleTransportationSOManage의 데이타 모델에 해당되는 값을 불러온다. Container Verify check<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search02SingleTransportationSOManage(EsdTrs0012Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			
			String hid_eq_no = event.getHidEqNo();
			ArrayList arr_size    = new ArrayList();
			ArrayList arr_eqno    = new ArrayList();
			
			ArrayList arrParaList = new ArrayList();
			          arrParaList = this.seperationParameter(hid_eq_no, ",");
			int       arrParasize = 0;
			if( arrParaList != null )          
					  arrParasize = arrParaList.size();
			
			if( arrParaList != null && arrParasize > 0 ){
				for(int idx = 0; idx < arrParasize; idx++){
					arr_size.add(idx);
					arr_eqno.add("'"+arrParaList.get(idx)+"'");
				}
			}
			
			param.put("arrEqNo" , arr_eqno );
			param.put("arrSize" , arr_size );
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageDBDAOsearch02SingleTransportationSOManageRSQL sql = new SingleTransportationSOManageDBDAOsearch02SingleTransportationSOManageRSQL();
			dbRowset = sqlExe.executeQuery(sql, param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset;
	}

	/**
	 * SingleTransportationSOManage의 모든 목록을 가져온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search03SingleTransportationSOManage(EsdTrs0012Event event) throws DAOException {

		DBRowSet rs2 = null;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dRs = null;
		try {	
			ArrayList arr_cntr = new ArrayList();
			ArrayList arr_referencno = new ArrayList();	
	
			String srad_date = event.getRadDate(); //R:Request, S:s/o
			String sfrmreqdate = event.getHidFrmreqdate();
			String storeqdate = event.getHidToreqdate();
			String skind = event.getSelKind();
			String stransmodcd = event.getSelTransmode(); //Rail, Truck, Water
			String sfrmnode = event.getFrmNode() + event.getFrmYard();
			String stonode = event.getToNode() + event.getToYard();
			String scntrno = event.getCntrNo(); //multi
			String sreferecneno = event.getReferenceNo(); //multi
			String sctrlofccd = event.getCtrlOfcCd();
			String spotBidFlg = event.getSpotBidFlg();
			String spotBidNo = event.getSpotBidNo();
			
			arr_cntr = this.seperationParameter(scntrno, ",");
			arr_referencno = this.seperationParameter(sreferecneno, ",");
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("sctrlofccd",sctrlofccd);
			param.put("sfrmreqdate",sfrmreqdate);
			param.put("sstoreqdate",storeqdate);
			param.put("skind",skind);
			param.put("stransmodcd",stransmodcd);
			param.put("sfrmnode",sfrmnode);
			param.put("stonode",stonode);
			param.put("spotBidFlg",spotBidFlg);
			param.put("spotBidNo",spotBidNo);
			
			Map<String, Object> vParam = new HashMap<String, Object>();
			vParam.put("sfrmreqdate",sfrmreqdate);
			vParam.put("sstoreqdate",storeqdate);
			vParam.put("srad_date",srad_date);
			vParam.put("skind",skind);
			vParam.put("stransmodcd",stransmodcd);
			vParam.put("arrCntr",arr_cntr);
			vParam.put("arrReferencno",arr_referencno);
			vParam.put("sfrmnode",sfrmnode);
			vParam.put("stonode",stonode);	
			vParam.put("spotBidFlg",spotBidFlg);
			vParam.put("spotBidNo",spotBidNo);
			Boolean bsqlchk = false; //CMD_SEQ를 가지고 오기 위한 쿼리문.	
			String chk = "";
			if( !skind.equals("ALL")||!stransmodcd.equals("ALL")|| !sfrmnode.equals("")||!stonode.equals("")||arr_cntr != null||arr_referencno != null) {
				bsqlchk = true;
				chk = "OK"; 
			}		
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			
			if( bsqlchk) {					        
				SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageSoRSQL template = new SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageSoRSQL();
				rs2 = sqlExe.executeQuery(template,param,vParam);
				ArrayList arrStrcmbseq = new ArrayList();
				while( rs2.next() ) {
					arrStrcmbseq.add(rs2.getString("TRSP_SO_CMB_SEQ"));
				}
				param.put("arrStrcmbseq", arrStrcmbseq);
				//이렇게 한 이유는 컬럼별로 값이 다를 수 있기 때문이다.
				//SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageChkRSQL templateChk = new SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageChkRSQL();
				//dRs = sqlExe.executeQuery(templateChk,param,vParam);	
			}
			
			vParam.put("chk", chk);
			SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageRSQL template = new SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageRSQL();
			dRs = sqlExe.executeQuery(template,param,vParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	
	/**
	 * SingleTransportationSOManage의 데이타 모델에 해당되는 값을 불러온다. Container Verify check<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search04SingleTransportationSOManage(EsdTrs0012Event event) throws DAOException {
		DBRowSet dRs = null;
		String scntr_no = JSPUtil.getNull(event.getHidCntrNo());
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("scntr_no", scntr_no);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			SingleTransportationSOManageDBDAOSearch04SingleTransportationSOManageRSQL template = new SingleTransportationSOManageDBDAOSearch04SingleTransportationSOManageRSQL();	        
			dRs = sqlExe.executeQuery(template,param,null);			
			} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * SingleTransportationSOManage의 데이타 모델에 해당되는 값을 불러온다. Container Verify check<br>
	 * 
	 * VERIFY 로직 날짜 수정. 2008.1.11 장민지. 30일 중복체크 적용. 생성불가
	 * 
	 * @param soffice_cd
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search05SingleTransportationSOManage(String soffice_cd, EsdTrs0012Event event) throws DAOException {
		DBRowSet dRs = null;
	try{
		ArrayList arr_eqno = null;
		ArrayList arr_frmnodecd = null;

		String seq_no = JSPUtil.getNull(event.getEqNoVerify());
		String sfrom_node = JSPUtil.getNull(event.getFrmNodeVerify());

		arr_eqno = this.seperationParameter(seq_no, ",");
		arr_frmnodecd = this.seperationParameter(sfrom_node, ",");

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 param.put("soffice_cd",soffice_cd);

		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 velParam.put("arr_eqno",arr_eqno);
		 velParam.put("arr_frmnodecd",arr_frmnodecd); 	
		 SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
		 SingleTransportationSOManageDBDAOsearch05SingleTransportationSOManageRSQL template = new SingleTransportationSOManageDBDAOsearch05SingleTransportationSOManageRSQL();	        
		 dRs = sqlExe.executeQuery(template,param,velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * CHM-201327722 MT repo & EQ on/off-hire 메뉴 개선사항1
	 * 2013.11.21 by SHIN DONG IL
	 * Off Hire일 경우 Node Combo정보를 MDM YARD와 LSE YARD정보를 모두 가져온다.
     * @param event EsdTrs0012Event
     * @return String
     * @exception DAOException
    */
	public String searchNodCdForOffHire(EsdTrs0012Event event) throws DAOException {
	    String rtn_nod_cd  = "";
	    StringBuffer sb = new StringBuffer();
	    
	    try {
			DBRowSet dbRowset = null;
			
			String loc_cd = JSPUtil.getNull(event.getLocCd());

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("loc_cd", loc_cd);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchNodCdForOffHireRSQL(), param, param);
	    	
	    	while(dbRowset.next()){
	    		//소스품질 결함 수정
	        	//rtn_nod_cd = rtn_nod_cd+ dbRowset.getString("NOD_CD")+"|";
	        	sb.append(dbRowset.getString("NOD_CD")+"|");
	        }
	    	rtn_nod_cd = sb.toString();
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    
	    return rtn_nod_cd;
	}
	
	/**
	 * SingleTransportationSOManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * Empty and Repo Corretion
	 * 
	 * @param soffice_cd
	 * @param event
	 * @throws DAOException
	 */
	public void emptyModifySingleTrs(String soffice_cd, EsdTrs0012Event event) throws DAOException {
		try{
			String cbstatus = event.getCbstatus();
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageVO[] model = event.getSingleTransportationSOManageVOs();
			Collection<SingleTransportationSOManageVO> updateVoList = new ArrayList<SingleTransportationSOManageVO>();
			DBRowSet rs = null;
			HashMap hmSeq = new HashMap();
			if( cbstatus.equals("CF") ) {
				for ( int i=0; i<model.length; i++ ) {
					if (model[i].getIbflag().length() > 0) {
						String cmbSeq = String.valueOf(model[i].getTrspSoCmbSeq());
						if( cmbSeq.substring(2).equals("1") && cmbSeq.length() > 2 ) {
							SingleTransportationSOManageDBDAOEmptyModifySingleTrsCombineSeqRSQL template = new SingleTransportationSOManageDBDAOEmptyModifySingleTrsCombineSeqRSQL();	        
							rs = sqlExe.executeQuery(template,null,null);							
							if( rs.next() ) {
								hmSeq.put(cmbSeq.substring(0,1), rs.getString("CMB_SEQ"));
							}
						}
					}
				}
			}			
			
			for ( int i=0; i<model.length; i++ ) {
				if ( model[i].getIbflag().equals("U")){
					if( cbstatus.equals("CF") ) {
						 String cmbSeq = String.valueOf(model[i].getTrspSoCmbSeq());
						 model[i].setTrspSoCmbSeq(String.valueOf(hmSeq.get(cmbSeq.substring(0,1))));
						 model[i].setTrspSoCmbSrtNo(cmbSeq);
					}
					updateVoList.add(model[i]);
				}
			}
			
			if(updateVoList.size() > 0){
				Map<String,Object> param = new HashMap<String,Object>();
				param.put("cbstatus", cbstatus);
				param.put("soffice_cd", soffice_cd);
				sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAOEmptyModifySingleTrsSoUSQL(), updateVoList, param, param);
				sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAOEmptyModifySingleTrsEqrUSQL(), updateVoList, null, null);
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
	}

	/**
	 * SingleTransportationSOManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * Seperate를 실행 Combined 해제
	 * 
	 * @param soffice_cd
	 * @param event
	 * @throws DAOException
	 */
	public void emptyModify01SingleTrs(String soffice_cd, EsdTrs0012Event event) throws DAOException {
		try {		
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageVO[] model = event.getSingleTransportationSOManageVOs();
			Collection<SingleTransportationSOManageVO> updateVoList = new ArrayList<SingleTransportationSOManageVO>();
			for ( int i=0; i<model.length; i++ ) {
				if ( model[i].getIbflag().equals("U")){
					updateVoList.add(model[i]);
				}
			}
			if(updateVoList.size() > 0){
				Map<String,Object> param = new HashMap<String,Object>();
				param.put("soffice_cd", soffice_cd);
				sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAOEmptyModify01SingleTrsUSQL(), updateVoList, null, param);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * SingleTransportationSOManage의 데이타 모델을 DB에서 삭제한다.<br>
	 *
	 * @param soffice_cd
	 * @param event
	 * @throws DAOException
	 */
	public void emptyRemoveSingleTrs(String soffice_cd,EsdTrs0012Event event) throws DAOException {
		try{
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SingleTransportationSOManageVO[] model = event.getSingleTransportationSOManageVOs();
			Collection<SingleTransportationSOManageVO> updateVoList = new ArrayList<SingleTransportationSOManageVO>();
			for ( int i=0; i<model.length; i++ ) {
				if ( model[i].getIbflag().equals("U")){
					updateVoList.add(model[i]);
				}
			}
			if(updateVoList.size() > 0){
				Map<String,Object> param = new HashMap<String,Object>();
				param.put("soffice_cd", soffice_cd);
				sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAOEmptyRemoveSingleTrsDelUSQL(), updateVoList, null, param);
				sqlExe.executeBatch((ISQLTemplate)new SingleTransportationSOManageDBDAOEmptyRemoveSingleTrsEqrUSQL(), updateVoList, null, param);
			}		

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
	}
	
	
	/**
	 * ESD_TRS_0012: Row Delete
	 * CHM-201327803 Empty Repo & EQ On/Off Hire 개선 사항2
	 * Check된 복수개의 Row Delete
	 * 2013.11.27 by SHIN DONG IL
	 * @param hdrVO SingleTransportationSOManageHdrVO
	 * @throws DAOException
	 */
	public void removeEmptyRepoPlan(SingleTransportationSOManageHdrVO hdrVO) throws DAOException {
		try{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();		
			Map<String, String> mapVO = hdrVO.getColumnValues();
			
			param.putAll(mapVO);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new SingleTransportationSOManageDBDAODeleteEmptyRepoPlanDSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
	}

	/**
	 * SingleTransportationSOManage의 EmptyRepo SO존재여부 체크<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchMultiSingleTransportationSo(EsdTrs0012Event event) throws DAOException {
		DBRowSet dRs = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		SingleTransportationVO[] stVos = event.getSingleTransportationVOs();
		
		try {

			List<SingleTransportationVO> eqrArr = new ArrayList<SingleTransportationVO>(); 
			int i=0;
			while( i<stVos.length ){
				SingleTransportationVO stVO = stVos[i];

				eqrArr.add(i++,stVO);
			}
			param.put("eqrArr", eqrArr);
			
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new SingleTransportationSOManageDBDAOsearchMultiSingleTransportationSoRSQL(), param,param);
			
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * SingleTransportationSOManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public HashMap searchEmptyRepoCombineSeq(EsdTrs0012Event event) throws DAOException {
		DBRowSet dRs = null;
		
//		Map<String, Object> param = new HashMap<String, Object>();
		SingleTransportationVO[] stVos = event.getSingleTransportationVOs();
		HashMap hmSeq = new HashMap();
		try {

			for( int j=0; j<stVos.length; j++){
				if( stVos[j].getIbflag().length() > 0 ){
					String cmbSeq = String.valueOf(stVos[j].getTrspSoCmbSeq());
					if( cmbSeq.substring(2).equals("1") && cmbSeq.length() > 2 ) {
						dRs = new SQLExecuter("DEFAULT").executeQuery(new SingleTransportationSOManageDBDAOEmptyRepoCombineSeqRSQL(), null,null);
						while(dRs.next()){
							hmSeq.put(cmbSeq.substring(0,1), dRs.getString("CMB_SEQ"));
						}
					}
				}
			}
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return hmSeq;
	}
	
	/**
	 * SingleTransportationSOManage의 FM_NOD_CD, TO_NOD_CD가 동일한 ECC_CD인지 체크<br>
	 *
	 * @param chk_param
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchVerifyECC(Map<String, Object> chk_param) throws DAOException {
		DBRowSet dRs = null;
		
		try {

			dRs = new SQLExecuter("DEFAULT").executeQuery(new SingleTransportationSOManagerDBDAOVerifyECCRSQL(), chk_param,chk_param);
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * SingleTransportationSOManage의 EmptyRepoSeq를 가져온다.<br>
	 *
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEmptyRepoSeq() throws DAOException {
		DBRowSet dRs = null;
		
		try {

			dRs = new SQLExecuter("DEFAULT").executeQuery(new SingleTransportationSOManageDBDAOEmptyRepoSeqRSQL(), null,null);
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * SingleTransportationSOManage의 여러 데이타 모델을 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param insModels
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public ArrayList multiSingleTransportationSOManage5(Collection<SingleTransportationVO> insModels, Map<String, Object> param) throws DAOException {
		// TODO Auto-generated method stub
		int[] insCnt = null;
		int[] insHisCnt = null;
		int[] updHisCnt = null;
		SingleTransportationVO model = null;
		ArrayList arrIns = new ArrayList();
		TrspSoSeqVO tssVo = null;
		int z = 0; //TRSP_SO_SEQ를 담는 객체
		try{
			if(insModels.size()>0){	
				insCnt = new SQLExecuter("DEFAULT").executeBatch(new SingleTransportationSOManageDBDAOMultiSingleTransportationCSQL(), insModels, param, param);
				insHisCnt = new SQLExecuter("DEFAULT").executeBatch(new SingleTransportationSOManageDBDAOMultiSingleTransportationHisCSQL(), insModels, param, param);
				updHisCnt = new SQLExecuter("DEFAULT").executeBatch(new SingleTransportationSOManageDBDAOMultiSingleTransportationEqrUSQL(), insModels, param, param);
				if( insCnt.length == insModels.size()&& insHisCnt.length == insModels.size()&& updHisCnt.length == insModels.size()){
					Iterator itr = insModels.iterator();
					while (itr.hasNext()) {
						model = (SingleTransportationVO)itr.next();
						tssVo = new TrspSoSeqVO();
						tssVo.setTrspSoSeq(model.getTrspSoSeq());
						tssVo.setTrspSoOfcCtyCd(model.getTrspSoOfcCtyCd());
						
						if(model.getSpotBidFlg().equals("1")){
							tssVo.setSpotBidFlg("Y");
							tssVo.setChk("Y");
						}else{
							tssVo.setSpotBidFlg("N");
							tssVo.setChk("N");
						}
						tssVo.setSpotBidDueDt(model.getSpotBidDueDt());
						tssVo.setSpotBidDueDtHms(model.getSpotBidDueDtHms());
						tssVo.setTrspCrrModCd(model.getTrspCrrModCd());
						tssVo.setFmNodCd(model.getFmNodCd());
						tssVo.setViaNodCd(model.getViaNodCd());
						tssVo.setDorNodCd(model.getDorNodCd());
						tssVo.setToNodCd(model.getToNodCd());
						
						arrIns.add(z++, tssVo);
					}
					
				}
			}
		
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return arrIns;
		
	}
	
	/**
     * 입력한 From Location이 US Rail인지 체크<br>
     * ESD_TRS_0012.do
     * @param hdrVO SingleTransportationSOManageHdrVO
     * @return String
     * @exception DAOException
    */
	public String checkUsRail(SingleTransportationSOManageHdrVO hdrVO) throws DAOException {
	    String chk_us_rail  = "";
		
	    try {
			DBRowSet dbRowset = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = hdrVO.getColumnValues();
			param.putAll(mapVO);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchEmptyRepoCheckUsRailRSQL(), param, param);
	        
	        if(dbRowset.next()){
	        	chk_us_rail = dbRowset.getString("CHK_US_RAIL");
	        }
	        
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    
	    return chk_us_rail;
	}
	
	
	/**
	 * EQR_REPO_EXE_SO_IF 데이타 모델을 DB에서 저장한다.<br>
	 *
	 * @param hdrVO 	SingleTransportationSOManageHdrVO
	 * @param account 	SignOnUserAccount
	 * @return String
	 * @throws DAOException
	 */
	public String multi01SingleTransportationSOManage(SingleTransportationSOManageHdrVO hdrVO,SignOnUserAccount account) throws DAOException {
		String ref_id = "";
		
		try{
			
			DBRowSet dbRowset = null;
			
			String repo_pln_id = "";
			String pln_yrwk = "";
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();		
			Map<String, String> mapVO = hdrVO.getColumnValues();
			
			
			param.putAll(mapVO);
			
			int loop_cnt = Integer.parseInt(hdrVO.getAllocated());
			
			//PK인 REPO_PLN_ID, PLN_YRWK 생성한다.
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchEmptyRepoPlanSeqRSQL(), param, param);
			
	        if(dbRowset.next()){
	        	repo_pln_id = dbRowset.getString("REPO_PLN_ID");
	        	pln_yrwk = dbRowset.getString("PLN_YRWK");
	        }
	        
			param.put("repo_pln_id",repo_pln_id);
			param.put("pln_yrwk",pln_yrwk);
			
			//PK인 REF_ID를 생성한다.
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SingleTransportationSOManageDBDAOSearchEmptyRepoRefSeqRSQL(), param, param);
			
	        if(dbRowset.next()){
	        	ref_id = dbRowset.getString("REF_ID");
	        }
	        param.put("ref_id",ref_id);
			param.put("ofc_cd",account.getOfc_cd());
			param.put("usr_id",account.getUsr_id());
	        
			//Allocated수 만큼 데이터를 생성한다.
			for(int i = 0; i<loop_cnt; i++){
				param.put("ref_seq", i+1);
			
				new SQLExecuter("").executeUpdate((ISQLTemplate)new SingleTransportationSOManageDBDAOMulti01SingleTransportationSOManageCSQL(), param, param);
			}
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return ref_id;
	}
	

	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}


	
}