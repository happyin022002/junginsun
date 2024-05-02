/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchSpaceAllocationModelListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.11.26 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchSpaceAllocationModelListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 모델 재 실행
	  * 
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchSpaceAllocationModelListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchSpaceAllocationModelListRSQL").append("\n"); 
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
		query.append("SELECT A.TRD_CD     AS TRADE   ," ).append("\n"); 
		query.append("         A.SUB_TRD_CD AS SUBTRADE," ).append("\n"); 
		query.append("         A.RLANE_CD   AS LANE    ," ).append("\n"); 
		query.append("         A.DIR_CD     AS BOUND   ," ).append("\n"); 
		query.append("         SUBSTR(A.SLS_YRMON, 1, 4)||A.COST_WK AS WEEK," ).append("\n"); 
		query.append("         A.VSL_CD||A.SKD_VOY_NO||A.DIR_CD     AS VVD ," ).append("\n"); 
		query.append("         A.VSL_CD     AS VSL_CD    ," ).append("\n"); 
		query.append("         A.SKD_VOY_NO AS SKD_VOY_NO," ).append("\n"); 
		query.append("         A.DIR_CD     AS DIR_CD" ).append("\n"); 
		query.append("    FROM MAS_MON_VVD A" ).append("\n"); 
		query.append("   WHERE A.TRD_CD     = SPC_GET_REP_TRD_FNC(A.RLANE_CD)" ).append("\n"); 
		query.append("     AND A.SUB_TRD_CD = SPC_GET_REP_SUB_TRD_FNC(A.RLANE_CD)" ).append("\n"); 
		query.append("     AND SUBSTR(A.SLS_YRMON, 1, 4) || A.COST_WK BETWEEN @[year1]||@[week1] AND @[year2]||@[week2]" ).append("\n"); 
		query.append("     AND A.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("		    " ).append("\n"); 
		query.append("#if (${trade} != '')" ).append("\n"); 
		query.append("     AND A.TRD_CD = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${subtrade} != '')" ).append("\n"); 
		query.append("     AND A.SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("     AND A.RLANE_CD = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("     AND A.DIR_CD = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     AND (A.DELT_FLG IS NULL OR A.DELT_FLG = 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${office} != 'SELHO')" ).append("\n"); 
		query.append("     AND SPC_CONTI_CONV_FNC('','','',A.LST_LODG_PORT_CD) = ( SELECT SPC_CONTI_CONV_FNC('','','',T.LOC_CD)" ).append("\n"); 
		query.append("                                                               FROM MDM_ORGANIZATION T" ).append("\n"); 
		query.append("                                                              WHERE T.OFC_CD = @[office] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY 1," ).append("\n"); 
		query.append("         2," ).append("\n"); 
		query.append("         3," ).append("\n"); 
		query.append("         4," ).append("\n"); 
		query.append("         5," ).append("\n"); 
		query.append("         6" ).append("\n"); 

	}
}
