/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchBasicFreeTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchBasicFreeTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBasicFreeTime
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchBasicFreeTimeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtt_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchBasicFreeTimeRSQL").append("\n"); 
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
		query.append("SELECT  NVL((" ).append("\n"); 
		query.append("				SELECT  TO_NUMBER(ATTR_CTNT8)" ).append("\n"); 
		query.append("				  FROM  DMT_HRD_CDG_CTNT" ).append("\n"); 
		query.append("				 WHERE  HRD_CDG_ID = 'GET_BZC_TRF_FT_DYS'" ).append("\n"); 
		query.append("				   AND  ATTR_CTNT1 = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("				   AND  ATTR_CTNT2 = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("				   AND  ATTR_CTNT3 = T1.TRF_SEQ" ).append("\n"); 
		query.append("				   AND  ATTR_CTNT4 = T1.DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("				   AND  ATTR_CTNT5 = T1.TRF_GRP_SEQ" ).append("\n"); 
		query.append("				   AND  (  ( TO_NUMBER(ATTR_CTNT6) <= @[qty]  AND TO_NUMBER(ATTR_CTNT7) = 0       )" ).append("\n"); 
		query.append("						OR ( TO_NUMBER(ATTR_CTNT6) <= @[qty]  AND ATTR_CTNT7 IS NULL              )" ).append("\n"); 
		query.append("						OR ( TO_NUMBER(ATTR_CTNT6) <= @[qty]  AND TO_NUMBER(ATTR_CTNT7) >= @[qty] )" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("			), FT_DYS) AS FT_DYS" ).append("\n"); 
		query.append("  FROM  DMT_TRF_FREE_TM T1" ).append("\n"); 
		query.append(" WHERE  T1.SYS_AREA_GRP_ID 	= @[svr_id]" ).append("\n"); 
		query.append("   AND  T1.DMDT_TRF_CD 		= @[dtt_code]" ).append("\n"); 
		query.append("   AND  T1.TRF_SEQ 			= @[dtn_seq]" ).append("\n"); 
		query.append("   AND  T1.DMDT_DE_TERM_CD  = @[dmdt_de_term_cd]" ).append("\n"); 
		query.append("   AND  T1.TRF_GRP_SEQ 		= @[grp_id]" ).append("\n"); 
		query.append("   AND  (  ( T1.FT_FM_QTY <= @[qty]  AND T1.FT_TO_QTY = 0       )" ).append("\n"); 
		query.append("        OR ( T1.FT_FM_QTY <= @[qty]  AND T1.FT_TO_QTY IS NULL   )" ).append("\n"); 
		query.append("        OR ( T1.FT_FM_QTY <= @[qty]  AND T1.FT_TO_QTY >= @[qty] )" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}