/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchASACltRfndAdjListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAgentDBDAOSearchASACltRfndAdjListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search ASA adjust target list
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchASACltRfndAdjListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOSearchASACltRfndAdjListRSQL").append("\n"); 
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
		query.append("SELECT          A.ASA_NO" ).append("\n"); 
		query.append("              , A.BL_NO" ).append("\n"); 
		query.append("              , A.INV_NO" ).append("\n"); 
		query.append("              , A.CHG_TP_CD" ).append("\n"); 
		query.append("              , A.ASA_CLT_SEQ" ).append("\n"); 
		query.append("              , A.AR_OFC_CD" ).append("\n"); 
		query.append("              , A.VVD_CD" ).append("\n"); 
		query.append("              , A.PORT_CD" ).append("\n"); 
		query.append("              , A.DUE_DT" ).append("\n"); 
		query.append("              , A.ASA_TP_CD" ).append("\n"); 
		query.append("              , A.USD_AMT" ).append("\n"); 
		query.append("              , A.ASA_XCH_RT1" ).append("\n"); 
		query.append("              , A.EQV_LOCL_AMT" ).append("\n"); 
		query.append("              , A.LOCL_AMT" ).append("\n"); 
		query.append("              , A.ASA_XCH_RT2" ).append("\n"); 
		query.append("              , A.CHG_USD_AMT" ).append("\n"); 
		query.append("              , A.TTL_AMT" ).append("\n"); 
		query.append("              , A.ASA_RMK" ).append("\n"); 
		query.append("              , A.EFF_DT              " ).append("\n"); 
		query.append("              , A.SVC_SCP_CD" ).append("\n"); 
		query.append("              , A.IB_OB_CD" ).append("\n"); 
		query.append("              , A.ASA_CURR_CD" ).append("\n"); 
		query.append("              , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("              , A.GL_YRMON" ).append("\n"); 
		query.append("              , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("              , A.N3RD_CURR_CD1" ).append("\n"); 
		query.append("              , A.N3RD_AMT1" ).append("\n"); 
		query.append("              , A.N3RD_XCH_RT1" ).append("\n"); 
		query.append("              , A.N3RD_LOCL_AMT1" ).append("\n"); 
		query.append("              , A.N3RD_CURR_CD2" ).append("\n"); 
		query.append("              , A.N3RD_AMT2" ).append("\n"); 
		query.append("              , A.N3RD_XCH_RT2" ).append("\n"); 
		query.append("              , A.N3RD_LOCL_AMT2" ).append("\n"); 
		query.append("              , A.N3RD_CURR_CD3" ).append("\n"); 
		query.append("              , A.N3RD_AMT3" ).append("\n"); 
		query.append("              , A.N3RD_XCH_RT3" ).append("\n"); 
		query.append("              , A.N3RD_LOCL_AMT3" ).append("\n"); 
		query.append("              , A.N3RD_CURR_CD4" ).append("\n"); 
		query.append("              , A.N3RD_AMT4" ).append("\n"); 
		query.append("              , A.N3RD_XCH_RT4" ).append("\n"); 
		query.append("              , A.N3RD_LOCL_AMT4" ).append("\n"); 
		query.append("              , A.EQV_LOCL_AMT2" ).append("\n"); 
		query.append("              , A.APRO_FLG" ).append("\n"); 
		query.append("              , B.AGN_CD" ).append("\n"); 
		query.append("              , B.ASA_PRD_FM_DT" ).append("\n"); 
		query.append("              , B.ASA_PRD_TO_DT" ).append("\n"); 
		query.append("              , B.CURR_CD" ).append("\n"); 
		query.append("              , B.ASA_STS_CD" ).append("\n"); 
		query.append("              , '' AS BL_CURR_CD" ).append("\n"); 
		query.append("              , '0' AS ADJ_AMT" ).append("\n"); 
		query.append("    FROM      SAR_AGN_CLT_RFND_MST A" ).append("\n"); 
		query.append("            , SAR_ASA_MST B" ).append("\n"); 
		query.append("    WHERE     A.ASA_NO = B.ASA_NO" ).append("\n"); 
		query.append("      AND     B.ASA_STS_CD  = 'F'" ).append("\n"); 
		query.append("      AND     A.ASA_NO = @[asa_no]" ).append("\n"); 

		
	}
}