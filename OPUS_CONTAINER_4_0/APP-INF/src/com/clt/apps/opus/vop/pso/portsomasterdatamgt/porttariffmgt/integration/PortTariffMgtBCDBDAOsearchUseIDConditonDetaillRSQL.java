/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchUseIDConditonDetaillRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchUseIDConditonDetaillRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 현재 Terminal에서 해당 Condtion를 사용하고 있는 Terminal List를 조회한다.
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchUseIDConditonDetaillRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("id_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchUseIDConditonDetaillRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT T3.YD_CD            AS YD_CD" ).append("\n"); 
		query.append("     , T4.ACCT_CD                   AS ACCT_CD" ).append("\n"); 
		query.append("     , T3.LGS_COST_CD               AS COST_CD" ).append("\n"); 
		query.append("     , VNDR.VNDR_LGL_ENG_NM         AS VNDR_NM" ).append("\n"); 
		query.append("     , T3.YD_CHG_VER_SEQ            AS VER" ).append("\n"); 
		query.append("     , T2.PSO_CHG_TP_CD             AS CHG_TP" ).append("\n"); 
		query.append("     , CODE.INTG_CD_VAL_DP_DESC     AS CHG_TP_NM" ).append("\n"); 
		query.append("     , @[id_no]                       AS ID_NO" ).append("\n"); 
		query.append("     , 'C'                          AS ID_TP" ).append("\n"); 
		query.append("  FROM PSO_CHG_XPR_DTL  T1" ).append("\n"); 
		query.append("     , PSO_YD_CHG_XPR   T2" ).append("\n"); 
		query.append("     , PSO_YD_CHG       T3" ).append("\n"); 
		query.append("     , TES_LGS_COST     T4" ).append("\n"); 
		query.append("     , (SELECT B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("             , B.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD A" ).append("\n"); 
		query.append("             , COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.INTG_CD_ID = 'CD01842'" ).append("\n"); 
		query.append("           AND A.INTG_CD_ID = B.INTG_CD_ID ) CODE" ).append("\n"); 
		query.append("     , MDM_VENDOR       VNDR" ).append("\n"); 
		query.append(" WHERE T1.CHG_XPR_NO        = T2.CHG_XPR_NO" ).append("\n"); 
		query.append("   AND T3.LGS_COST_CD       = T4.LGS_COST_CD" ).append("\n"); 
		query.append("   AND T2.YD_CHG_NO         = T3.YD_CHG_NO" ).append("\n"); 
		query.append("   AND T2.YD_CHG_VER_SEQ    = T3.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("   AND T3.YD_CHG_VER_SEQ    = (SELECT MAX(YD_CHG_VER_SEQ) FROM PSO_YD_CHG WHERE YD_CHG_NO = T2.YD_CHG_NO ) /*최신버전은 항상 Max Version*/" ).append("\n"); 
		query.append("   AND T2.PSO_CHG_TP_CD     = CODE.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("   AND T1.COND_NO           = @[id_no]" ).append("\n"); 
		query.append("   AND VNDR.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("   AND VNDR.VNDR_SEQ = T3.VNDR_SEQ" ).append("\n"); 
		query.append(" ORDER BY 1" ).append("\n"); 
		query.append("     , 2" ).append("\n"); 
		query.append("     , 3" ).append("\n"); 
		query.append("     , 4" ).append("\n"); 
		query.append("     , 5" ).append("\n"); 
		query.append("     , 6 " ).append("\n"); 

	}
}