/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanCompareDBDAO.java
*@FileTitle : 이송계획 및 비용 상세 비교 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.10.12 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.basic.CntrRepoPlanCompareBCImpl;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.vo.EesEqr0135ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.vo.EesEqr0070ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS CntrRepoPlanCompareDBDAO <br>
 * - ALPS-RepoPlanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author ChungEunHo
 * @see CntrRepoPlanCompareBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrRepoPlanCompareDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param EesEqr0070ConditionVO eesEqr0070ConditionVO
	 * @return List<searchRepoPlanAndCostFromToDetail>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CommonRsVO searchRepoPlanAndCostDetail(EesEqr0070ConditionVO eesEqr0070ConditionVO) throws DAOException {
		// 2015.02.25 CHM-201534210 EQR 소스 보안
		DBRowSet dbRowset = new DBRowSet();
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        String matched = eesEqr0070ConditionVO.getMatched();
        String compared =eesEqr0070ConditionVO.getCompared(); 
        String fmtoat  = eesEqr0070ConditionVO.getFmtoat();
        String fmtypeby = eesEqr0070ConditionVO.getFmtypeby();
        String totypeby = eesEqr0070ConditionVO.getTotypeby();
        String fmtype   = eesEqr0070ConditionVO.getFmtype();
        String totype   = eesEqr0070ConditionVO.getTotype();
        String attype   = eesEqr0070ConditionVO.getAttype();
        String attypeby = eesEqr0070ConditionVO.getAttypeby();
        String fmecccd   = eesEqr0070ConditionVO.getFmecccd();
		String arrfmecccd = Utils.convertStr(eesEqr0070ConditionVO.getFmecccd(), true);
        String toecccd    = eesEqr0070ConditionVO.getToecccd();
		String arrtoecccd = Utils.convertStr(eesEqr0070ConditionVO.getToecccd(), true);
		String atecccd    = eesEqr0070ConditionVO.getAtecccd();
		String arratecccd = Utils.convertStr(eesEqr0070ConditionVO.getAtecccd(), true);
		String repo_pln_id =Constants.REPO_WORD+eesEqr0070ConditionVO.getYyyyww()+Constants.REPO_WEEK+eesEqr0070ConditionVO.getSeq();
		String arritem = Utils.convertStr(eesEqr0070ConditionVO.getItem(), true);
		String arrlane = Utils.convertStr(eesEqr0070ConditionVO.getLane(), true);
		String fm_yrwk = eesEqr0070ConditionVO.getFmplnyr() + eesEqr0070ConditionVO.getFmplnwk();
		String to_yrwk = eesEqr0070ConditionVO.getToplnyr() + eesEqr0070ConditionVO.getToplnwk();
		String fm_to_yrwk = eesEqr0070ConditionVO.getFmtoplnyr() + eesEqr0070ConditionVO.getFmtoplnwk();
		String to_to_yrwk = eesEqr0070ConditionVO.getTotoplnyr() + eesEqr0070ConditionVO.getTotoplnwk();
		String at_fm_yrwk = eesEqr0070ConditionVO.getAtfmplnyr() + eesEqr0070ConditionVO.getAtfmplnwk();
		String at_to_yrwk = eesEqr0070ConditionVO.getAttoplnyr() + eesEqr0070ConditionVO.getAttoplnwk();
		String fmplnwk = eesEqr0070ConditionVO.getFmplnyr();
		String fmtoplnwk = eesEqr0070ConditionVO.getFmtoplnyr();
		String arroddtpsz   = Utils.convertStr(eesEqr0070ConditionVO.getOddtype());
		String arrvvd       = Utils.convertStr(eesEqr0070ConditionVO.getVvd());
		String item        = eesEqr0070ConditionVO.getItem();
		String lane        = eesEqr0070ConditionVO.getLane();
		String vvd         = eesEqr0070ConditionVO.getVvd();
		String plan_id      = eesEqr0070ConditionVO.getPlanid();
		ArrayList arrCntrTpsz = (ArrayList) Utils.replaceStrToList(eesEqr0070ConditionVO.getCntrtpszcd());
		
		try{
			
			velParam.put("matched", matched);
			velParam.put("fmtoat", fmtoat);
			velParam.put("fmtypeby",fmtypeby);
			velParam.put("totypeby", totypeby);
			velParam.put("attype", attype);
			velParam.put("arrtpszcd", arrCntrTpsz);
			velParam.put("fmecccd", fmecccd);
			velParam.put("arrfmecccd", arrfmecccd);
			velParam.put("toecccd" ,toecccd);
			velParam.put("arrtoecccd", arrtoecccd);
			velParam.put("atecccd", atecccd);
			velParam.put("arratecccd", arratecccd);
			velParam.put("arritem", arritem);
			velParam.put("arrlane" , arrlane);
			velParam.put("fmplnwk" , fmplnwk);
			velParam.put("fmtoplnwk", fmtoplnwk);
			velParam.put("arrcntrtpzcd" ,arrCntrTpsz);
			velParam.put("arroddtpsz", arroddtpsz);
			velParam.put("item" ,item);
			velParam.put("lane" ,lane);
			velParam.put("compared", compared);
			velParam.put("fmtype" ,fmtype);
			velParam.put("totype" ,totype);
			velParam.put("fmecccd" ,fmecccd);
			velParam.put("toecccd" ,toecccd);
			velParam.put("atecccd" ,atecccd);
			velParam.put("vvd"  , vvd);
			velParam.put("arrvvd" , arrvvd);
			velParam.put("attypeby", attypeby);
			
			
		    param.put("repo_pln_id",repo_pln_id);
		    param.put("plan_id", plan_id);
		    param.put("fm_yrwk" ,fm_yrwk);
		    param.put("to_yrwk" ,to_yrwk);
		    param.put("fm_to_yrwk" , fm_to_yrwk);
		    param.put("to_to_yrwk", to_to_yrwk);
		    param.put("at_fm_yrwk" , at_fm_yrwk);
		    param.put("at_to_yrwk", at_to_yrwk);
			 
		    log.info("==item===" + item);
		    if (!matched.equals("T")){
		    	if (compared.equals("SO")){
		    		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanCompareDBDAOSearchRepoPlanAndCostDetailRSQL(), param, velParam);
		    	}else if (compared.equals("PD")){
		    		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanCompareDBDAOSearchRepoPlanAndCostDetail01RSQL(), param, velParam);	
		    	}
		    }else {
		    	if (compared.equals("SO")){
			      dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanCompareDBDAOSearchRepoPlanAndCostDetail02RSQL(), param, velParam);
		    	}else if (compared.equals("PD")){
		    	  dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanCompareDBDAOSearchRepoPlanAndCostDetail03RSQL(), param, velParam);	
		    	}
		    }
		    
		    
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param EesEqr0135ConditionVO eesEqr0135ConditionVO
	 * @return List<EesEqr0135ConditionVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CommonRsVO searchRepoPlanAndCostFromToDetail(EesEqr0135ConditionVO eesEqr0135ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        
		try{
			String repo_pln_Id = Constants.REPO_WORD+eesEqr0135ConditionVO.getYyyyww()+Constants.REPO_WEEK+eesEqr0135ConditionVO.getSeq();
			String basicWeek = eesEqr0135ConditionVO.getYyyyww();
			String nextWeek  = eesEqr0135ConditionVO.getNextWeek();
			
	    	String tpsz     = eesEqr0135ConditionVO.getCntrTpsz();    // TYPE SIZE 종류(ALL, DRY, RFR...)
	 		String tpsztype = eesEqr0135ConditionVO.getCntrTpszCd();  // TYPE SIZE 선택값
	 		List tpszArr = Utils.replaceStrToList(tpsztype);
	 		
	 		String fmtoat      = eesEqr0135ConditionVO.getFmToAt();
	 		 		
	 		String fmStatus    = eesEqr0135ConditionVO.getFmType();
	 		String toStatus    = eesEqr0135ConditionVO.getToType();
	 		String atStatus    = eesEqr0135ConditionVO.getAtType();
	 		
	 		String fmByEcc     = eesEqr0135ConditionVO.getFmTypeBy();
	 		String toByEcc     = eesEqr0135ConditionVO.getToTypeBy();
	 		String atByEcc     = eesEqr0135ConditionVO.getAtTypeBy();

	 		String fmtoall   = eesEqr0135ConditionVO.getFmToAll();
	 		String itemname = eesEqr0135ConditionVO.getItem();
	 		String itemname_ecc = "";
	 		String lane     = eesEqr0135ConditionVO.getLane();
	 		String vvd      = eesEqr0135ConditionVO.getVvd();
	 		
	 		String fmEcc	= eesEqr0135ConditionVO.getFromEcc();
	 		String toEcc	= eesEqr0135ConditionVO.getToEcc();
	 		 // 조건값 셋팅 변수 
	 		
	 		String fromLocStr = "";
	 		String toLocStr = "";
	 		String tpszStr = "";
	 		String itemnameStr = "";
	 		String laneStr = "";
	 		String vvdStr = "";
	 		
	 	// from location 검색조건 ('','',''.....)
	    	if((fmtoat.equals("1") || fmtoat.equals("2")) && (!fmStatus.equals("") || !atStatus.equals(""))) {
	    		fromLocStr = Utils.convertStr(fmEcc, true);
	    		
	    	}
	    	
	    	// to location 검색조건 ('','',''.....)
	    	if(fmtoat.equals("1") && !toStatus.equals("")) {
	    		toLocStr = Utils.convertStr(toEcc, true);
	    	}    	
	    	
	        // TP/SZ 에 따른 조건값을 넣어 준다.
	        if(!tpsz.equals("") && !tpsztype.equals("")) {
	        	tpszStr = Utils.convertStr(tpsztype, true);
	    	}    	
	        // REASON 에 따른 조건값을 넣어 준다.
	        if(!itemname.equals("")) {
	        	itemnameStr = Utils.convertStr(itemname, true);
	        	String[] temp = itemname.split(",");
	        	for(int j=0; j<temp.length; j++) {        		
	        		if(temp[j].equals("S")){
	        			itemname_ecc = "S";  // ECC INTERNAL 데이터 집계에 사용됨. 
	        			j = temp.length;
	        		}
	        	}
	    	}   
	        // LANE 에 따른 조건값을 넣어 준다.
	        if(!lane.equals("")) {
	        	laneStr = Utils.convertStr(lane, true);
	    	}         
	        
	        // VVD 에 따른 조건값을 넣어 준다.
	        if(!vvd.equals("")) {
	        	vvdStr = Utils.convertStr(vvd, true);
	    	}     
	         
	        param.put("repo_pln_Id",repo_pln_Id);
	        param.put("basicWeek",basicWeek);
	        param.put("nextWeek",nextWeek);
	        param.put("fmtoall",fmtoall);

	        velParam.put("tpsz",tpsz);
	        velParam.put("tpsztype",tpsztype);
	        velParam.put("tpszArr",tpszArr);
	        velParam.put("fmtoat",fmtoat);
	        velParam.put("fmStatus",fmStatus);
	        velParam.put("toStatus",toStatus);
	        velParam.put("atStatus",atStatus);
	        velParam.put("fmByEcc",fmByEcc);
	        velParam.put("toByEcc",toByEcc);
	        velParam.put("atByEcc",atByEcc);
	        velParam.put("fmtoall",fmtoall);
	        velParam.put("itemname",itemname);
	        velParam.put("itemname_ecc",itemname_ecc);
	        velParam.put("lane",lane);
	        velParam.put("vvd",vvd);
	        velParam.put("fromLocStr",fromLocStr);
	        velParam.put("toLocStr",toLocStr);
	        velParam.put("tpszStr",tpszStr);
	        velParam.put("itemnameStr",itemnameStr);
	        velParam.put("laneStr",laneStr);
	        velParam.put("vvdStr",vvdStr);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanCompareDBDAOSearchRepoPlanAndCostFromToDetailRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
}