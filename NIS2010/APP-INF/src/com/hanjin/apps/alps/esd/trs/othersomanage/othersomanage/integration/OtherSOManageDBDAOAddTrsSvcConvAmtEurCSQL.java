/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtherSOManageDBDAOAddTrsSvcConvAmtEurCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.09.18 김진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OtherSOManageDBDAOAddTrsSvcConvAmtEurCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EUR 통화변환 금액을 입력한다.
	  * </pre>
	  */
	public OtherSOManageDBDAOAddTrsSvcConvAmtEurCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OVR_WGT_SCG_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_USR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FUEL_SCG_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ETC_ADD_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CURR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_OFC_CTY_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BZC_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration").append("\n"); 
		query.append("FileName : OtherSOManageDBDAOAddTrsSvcConvAmtEurCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_EXPN_CONV_AMT											(" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD								," ).append("\n"); 
		query.append("TRSP_SO_SEQ										," ).append("\n"); 
		query.append("CURR_CD											," ).append("\n"); 
		query.append("BZC_AMT											," ).append("\n"); 
		query.append("FUEL_SCG_AMT									," ).append("\n"); 
		query.append("OVR_WGT_SCG_AMT									," ).append("\n"); 
		query.append("ETC_ADD_AMT										," ).append("\n"); 
		query.append("CRE_OFC_CD										," ).append("\n"); 
		query.append("CRE_USR_ID										," ).append("\n"); 
		query.append("CRE_DT											," ).append("\n"); 
		query.append("UPD_USR_ID										," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[TRSP_SO_OFC_CTY_CD]								," ).append("\n"); 
		query.append("@[TRSP_SO_SEQ]										," ).append("\n"); 
		query.append("'USD'												," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROUND(( TO_NUMBER(@[BZC_AMT]) / RAT.USD_LOCL_XCH_RT),2) BZC_USD" ).append("\n"); 
		query.append("FROM   GL_MON_XCH_RT RAT" ).append("\n"); 
		query.append("WHERE  RAT.CURR_CD								= @[CURR_CD]" ).append("\n"); 
		query.append("AND    RAT.ACCT_XCH_RT_LVL						= '1'" ).append("\n"); 
		query.append("AND    RAT.ACCT_XCH_RT_YRMON					= TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append(")												," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROUND((TO_NUMBER(@[FUEL_SCG_AMT]) / RAT.USD_LOCL_XCH_RT),2) FUEL_UDS" ).append("\n"); 
		query.append("FROM   GL_MON_XCH_RT RAT" ).append("\n"); 
		query.append("WHERE  RAT.CURR_CD								= @[CURR_CD]" ).append("\n"); 
		query.append("AND    RAT.ACCT_XCH_RT_LVL						= '1'" ).append("\n"); 
		query.append("AND    RAT.ACCT_XCH_RT_YRMON					= TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append(")												," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROUND((TO_NUMBER(@[OVR_WGT_SCG_AMT]) / RAT.USD_LOCL_XCH_RT),2) OVR_USD" ).append("\n"); 
		query.append("FROM   GL_MON_XCH_RT RAT" ).append("\n"); 
		query.append("WHERE  RAT.CURR_CD								= @[CURR_CD]" ).append("\n"); 
		query.append("AND    RAT.ACCT_XCH_RT_LVL						= '1'" ).append("\n"); 
		query.append("AND    RAT.ACCT_XCH_RT_YRMON					= TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append(")												," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROUND((TO_NUMBER(@[ETC_ADD_AMT]) / RAT.USD_LOCL_XCH_RT),2) ETC_USD" ).append("\n"); 
		query.append("FROM   GL_MON_XCH_RT RAT" ).append("\n"); 
		query.append("WHERE  RAT.CURR_CD								= @[CURR_CD]" ).append("\n"); 
		query.append("AND    RAT.ACCT_XCH_RT_LVL						= '1'" ).append("\n"); 
		query.append("AND    RAT.ACCT_XCH_RT_YRMON					= TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append(")												," ).append("\n"); 
		query.append("@[FORM_USR_OFC_CD]								," ).append("\n"); 
		query.append("@[FORM_CRE_USR_ID]								," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC( @[FORM_USR_OFC_CD])," ).append("\n"); 
		query.append("@[FORM_CRE_USR_ID]								," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC( @[FORM_USR_OFC_CD])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}