/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InputDataRlaExamineDBDAO.java
*@FileTitle : Input Data Red Light Alert 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-24
*@LastModifier : ChungEunHo
*@LastVersion : 1.0
* 2009-07-24 ChungEunHo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.basic.InputDataRlaExamineBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.vo.EesEqr0003ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.vo.InputDataRLAExamineRsVO;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrScnrEccLnkVO;
import com.hanjin.syscommon.common.table.EqrScnrEccVO;


/**
 * ALPS-InputDataRlaExamine에 대한 DB 처리를 담당<br>
 * - ALPS-InputDataRlaExamine Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author ChungEunHo
 * @see InputDataRlaExamineBCImpl 참조
 * @since J2EE 1.6
 */
public class InputDataRlaExamineDBDAO extends DBDAOSupport {

    /**
     * Input Data Red Light Alert (EES_EQR_003) 조회
     * 
     * @param vo EesDqr0003ConditionVO
     * @param fromECC String
     * @param toECC String
     * @return InputDataRLAExamineRsVO
     * @exception DAOException
    */
	public InputDataRLAExamineRsVO searchInputDataRLAList(EesEqr0003ConditionVO vo, String fromECC, String toECC) throws DAOException {
		InputDataRLAExamineRsVO retVo = new InputDataRLAExamineRsVO();
		
		DBRowSet dRs 		= null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		

		String scnrPlanID = vo.getScnrPlanId();
		
		
 		String tpsztype = vo.getTpsztype();  // TYPE SIZE 선택값
 		String[] tpszArr= tpsztype.split(",");
 		
 		String datatype = vo.getDatatype();

 		String fmtoat      = vo.getFmtoat();
 		String fromStatus  = vo.getFromStatus();
 		String toStatus    = vo.getToStatus();
 		String atStatus    = vo.getAtStatus();
 		
 		String fmTypeBy    = vo.getFmTypeBy();  // C,E,L,R
 		String toTypeBy    = vo.getToTypeBy();
 		String atTypeBy    = vo.getAtTypeBy(); 		
 		
        String fromWeek 	= "";
        String toWeek   	= "";
        
        List<String> fromeccArr 	= new ArrayList<String>();
        List<String> toeccArr 		= new ArrayList<String>();

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
    	
    	
        if(fmtoat.equals("1")) {
        	fromWeek = vo.getFmSFcastYr() + vo.getFmSFcastWk();
        	toWeek   = vo.getFmEFcastYr() + vo.getFmEFcastWk();
    	}else {     
        	fromWeek = vo.getAtSFcastYr()  + vo.getAtSFcastWk();    		
        	toWeek   = vo.getAtEFcastYr()  + vo.getAtEFcastWk();    		
    	}           
     // from location 검색조건 ('','',''.....)
    	if((fmtoat.equals("1") || fmtoat.equals("2")) && (!fromStatus.equals("") || !atStatus.equals(""))) {
    		fromeccArr = Utils.replaceStrToList(fromECC); // , 로 구분한 결과를 List 로 반환한다.
    		velParam.put("fromeccArr", fromeccArr);
    	}
    	
    	// to location 검색조건 ('','',''.....)
    	if(fmtoat.equals("1") && !toStatus.equals("")) {
    		toeccArr = Utils.replaceStrToList(toECC); // , 로 구분한 결과를 List 로 반환한다.
    		velParam.put("toeccArr", toeccArr);
    	}    

    	
		try {
			// 임시로 사용 
	    	if(! datatype.equals("LNK") && !datatype.equals("ECC") &&
	    	   ! datatype.equals("VSK") && !datatype.equals("OBF") &&
	    	   ! datatype.equals("")
	    	){
	    		// SELECT '' TEST FROM DUAL WHERE 1=0  더미쿼리 사용하지 않고 빈  DBRowSet 을 선언해서 넣는 방법으로 수정함 Modify By ChungEunho 09.12.18
	    		dRs = new DBRowSet();
	    		dRs.setMaxRows(0);
	    	}else{
	    		param.put("scnrPlanID", scnrPlanID);
	    		param.put("fromWeek", fromWeek);
	    		param.put("toWeek", toWeek);
	    		velParam.put("tpsztype",tpsztype);
	    		velParam.put("scnrPlanID",scnrPlanID);
	    		velParam.put("datatype",datatype);
	    		velParam.put("fmtoat",fmtoat);
	    		velParam.put("fromStatus",fromStatus);
	    		velParam.put("toStatus",toStatus);
	    		velParam.put("atStatus",atStatus);
	    		velParam.put("fmTypeBy",fmTypeBy);
	    		velParam.put("toTypeBy",toTypeBy);
	    		velParam.put("atTypeBy",atTypeBy);
	    		velParam.put("fromWeek",fromWeek);
	    		velParam.put("toWeek",toWeek);
	    		velParam.put("tpszArr", tpszArr);
	    		dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new InputDataRLAExamineDBDAOSearchInputDataRLAListRSQL(), param, velParam);
	    	}
			retVo.setDBRowSet(dRs);
			return retVo;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	

	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccLnkVO eqrScnrEccLnkVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAList20(EqrScnrEccLnkVO eqrScnrEccLnkVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccLnkVO.getColumnValues());
	        
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLALinkInfo_20QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}

	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccLnkVO eqrScnrEccLnkVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAList40(EqrScnrEccLnkVO eqrScnrEccLnkVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccLnkVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLALinkInfo_40QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}

	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccLnkVO eqrScnrEccLnkVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAList45(EqrScnrEccLnkVO eqrScnrEccLnkVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccLnkVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLALinkInfo_45QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}

	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccVO eqrScnrEccVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAListStd20(EqrScnrEccVO eqrScnrEccVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLAEccInfo_std20QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}
	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccVO eqrScnrEccVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAListStd40(EqrScnrEccVO eqrScnrEccVO) throws DAOException {
		try {         
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLAEccInfo_std40QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}
	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccVO eqrScnrEccVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAListStd45(EqrScnrEccVO eqrScnrEccVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLAEccInfo_std45QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}
	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccVO eqrScnrEccVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAListStr20(EqrScnrEccVO eqrScnrEccVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLAEccInfo_str20QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}
	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccVO eqrScnrEccVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAListStr40(EqrScnrEccVO eqrScnrEccVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLAEccInfo_str40QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}
	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccVO eqrScnrEccVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAListStr45(EqrScnrEccVO eqrScnrEccVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLAEccInfo_str45QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}
	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccVO eqrScnrEccVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAListHnd20(EqrScnrEccVO eqrScnrEccVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLAEccInfo_hnd20QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}
	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccVO eqrScnrEccVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAListHnd40(EqrScnrEccVO eqrScnrEccVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLAEccInfo_hnd40QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}
	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccVO eqrScnrEccVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAListHnd45(EqrScnrEccVO eqrScnrEccVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLAEccInfo_hnd45QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}
	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccVO eqrScnrEccVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAListSht20(EqrScnrEccVO eqrScnrEccVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLAEccInfo_sht20QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}
	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccVO eqrScnrEccVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAListSht40(EqrScnrEccVO eqrScnrEccVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLAEccInfo_sht40QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}
	/**
	 * Input Data Red Light Alert (EES_EQR_0003) 수정
	 * @param EqrScnrEccVO eqrScnrEccVO
	 * @exception DAOException
	 */
	public void modifyInputDataRLAListSht45(EqrScnrEccVO eqrScnrEccVO) throws DAOException {
		try {     
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.putAll(eqrScnrEccVO.getColumnValues());
			new SQLExecuter("").executeUpdate((ISQLTemplate)new InputDataRLAExamineDBDAOUpdateRLAEccInfo_sht45QueryUSQL(), param, null);
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}    
}