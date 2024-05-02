/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OpfStowageMgtDBDAOBayPlanCntrVvdPortListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfStowageMgtDBDAOBayPlanCntrVvdPortListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfStowageMgtDBDAOBayPlanCntrVvdPortList
	  * </pre>
	  */
	public OpfStowageMgtDBDAOBayPlanCntrVvdPortListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.integration").append("\n"); 
		query.append("FileName : OpfStowageMgtDBDAOBayPlanCntrVvdPortListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		#if (${vvd_port_gb} == 'VVD')" ).append("\n"); 
		query.append("			A.VSL_CD" ).append("\n"); 
		query.append("			, A.VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("			, A.DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("			, A.VSL_CD||'-'||A.VOY_NO||'-'||A.DIR_CD AS VVD" ).append("\n"); 
		query.append("            ,(SELECT CASE WHEN (SELECT  COUNT(1) CNT" ).append("\n"); 
		query.append("                                FROM    VSK_ACT_PORT_SKD" ).append("\n"); 
		query.append("                                WHERE   ACT_ARR_DT > (SELECT MAX(ACT_ARR_DT)" ).append("\n"); 
		query.append("                                                      FROM VSK_ACT_PORT_SKD" ).append("\n"); 
		query.append("                                                      WHERE VSL_CD   = A.VSL_CD" ).append("\n"); 
		query.append("                                                      AND SKD_VOY_NO = A.VOY_NO" ).append("\n"); 
		query.append("                                                      AND SKD_DIR_CD = A.DIR_CD" ).append("\n"); 
		query.append("                                                     )" ).append("\n"); 
		query.append("                                   AND VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO||SKD_DIR_CD <> A.VOY_NO||A.DIR_CD" ).append("\n"); 
		query.append("                                ) > 0 THEN 'CLOSED'" ).append("\n"); 
		query.append("                          ELSE (SELECT CASE WHEN  MAX(VPS_ETA_DT) > SYSDATE THEN 'ONBOARD'" ).append("\n"); 
		query.append("                                            ELSE 'CLOSED'" ).append("\n"); 
		query.append("                                       END" ).append("\n"); 
		query.append("                                FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                WHERE   VSL_CD    =A.VSL_CD" ).append("\n"); 
		query.append("                                AND     SKD_VOY_NO=A.VOY_NO" ).append("\n"); 
		query.append("                                AND     SKD_DIR_CD=A.DIR_CD" ).append("\n"); 
		query.append("                                AND     NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                AND     TURN_PORT_IND_CD NOT IN('D','V','F') " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("               FROM DUAL ) AS ON_BOARD_MSG" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			A.PORT_CD" ).append("\n"); 
		query.append("			, TO_CHAR(B.VPS_ETA_DT,'YYYY/MM/DD') AS VPS_ETA_DT" ).append("\n"); 
		query.append("			, DECODE(A.POL, A.PORT_CD, A.POL,'') AS ON_BOARD_MSG" ).append("\n"); 
		query.append("			, A.CALL_IND " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("FROM BAY_PLAN A" ).append("\n"); 
		query.append("    , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (A.VSL_CD, A.VOY_NO, A.DIR_CD, A.PORT_CD, A.ID, A.CALL_IND, A.PLAN_TYPE) " ).append("\n"); 
		query.append("    IN (SELECT VSL_CD, VOY_NO, DIR_CD, PORT_CD, ID, CALL_IND" ).append("\n"); 
		query.append("               , CASE WHEN COUNT(PLAN_TYPE) != 1 THEN 'E' ELSE 'F' END AS PLAN_TYPE" ).append("\n"); 
		query.append("        FROM BAY_PLAN A" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("		#if (${vvd_port_gb} == 'PORT')" ).append("\n"); 
		query.append("       		AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("       		AND VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("       		AND DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        AND ID = @[cntr_id]" ).append("\n"); 
		query.append("        GROUP BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, ID, CALL_IND" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.PORT_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("AND A.CALL_IND  = B.CLPT_IND_SEQ " ).append("\n"); 
		query.append("AND NVL(B.SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("AND B.TURN_PORT_IND_CD NOT IN('D','V','F')" ).append("\n"); 
		query.append("AND B.VPS_ETA_DT BETWEEN TO_DATE(@[eta_fr_dt],'YYYY-MM-DD') AND TO_DATE(@[eta_to_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#if (${vvd_port_gb} == 'VVD')" ).append("\n"); 
		query.append("	GROUP BY A.VSL_CD, A.VOY_NO, A.DIR_CD" ).append("\n"); 
		query.append("	ORDER BY MAX(B.VPS_ETA_DT) DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	ORDER BY B.VPS_ETA_DT DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}