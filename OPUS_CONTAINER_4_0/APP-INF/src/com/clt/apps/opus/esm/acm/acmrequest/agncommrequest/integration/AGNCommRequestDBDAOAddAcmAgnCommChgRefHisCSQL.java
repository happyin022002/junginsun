/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommRequestDBDAOAddAcmAgnCommChgRefHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOAddAcmAgnCommChgRefHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAcmAgnCommChgRefHis
	  * </pre>
	  */
	public AGNCommRequestDBDAOAddAcmAgnCommChgRefHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOAddAcmAgnCommChgRefHisCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("INSERT INTO ACM_AGN_COMM_CHG_REF_HIS" ).append("\n"); 
		query.append("(BKG_NO, CHG_CD, BKG_AGMT_UT_CD, SPCL_CGO_CTNT, CURR_CD, CALC_NO, ROUT_TRF_FX_AMT, ROUT_TRF_RT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT BKG_NO,CHG_CD,BKG_AGMT_UT_CD,SPCL_CGO_CTNT,CURR_CD,@[calc_no] AS CALC_NO,ROUT_TRF_FX_AMT,ROUT_TRF_RT,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT" ).append("\n"); 
		query.append("FROM ACM_AGN_COMM_CHG_REF" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}