/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchPopCompanyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchPopCompanyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0420  -- Company Popup
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchPopCompanyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchPopCompanyListRSQL").append("\n"); 
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
		query.append("SELECT  SLD.LU_CD    AS LU_CD," ).append("\n"); 
		query.append("        SLD.LU_DESC  AS LU_DESC" ).append("\n"); 
		query.append("FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("      , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("AND     SLH.LU_TP_CD = 'GL COMPANY'" ).append("\n"); 
		query.append("AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("AND     SLH.LU_APPL_CD = 'SCO'" ).append("\n"); 
		query.append("#if (${lu_cd} != '')" ).append("\n"); 
		query.append("   AND  LU_CD = @[lu_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}