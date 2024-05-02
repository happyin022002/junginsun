/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOAddVskPfCallPortCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.27
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.05.27 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author RYU HYUK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOAddVskPfCallPortCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddVskPfCallPort
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOAddVskPfCallPortCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOAddVskPfCallPortCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_PF_CALL_PORT" ).append("\n"); 
		query.append("(VSL_SLAN_CD, PF_SVC_TP_CD, SKD_DIR_CD, PORT_CD, CLPT_SEQ,PORT_ROTN_SEQ,YD_CD,CALL_YD_IND_SEQ,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT )" ).append("\n"); 
		query.append("SELECT  LANE_CD, PF_TYPE, DIR_CD" ).append("\n"); 
		query.append("        ,PORT_CD" ).append("\n"); 
		query.append("        ,ROW_NUMBER () OVER (PARTITION BY DIR_CD, PF_TYPE, PORT_CD ORDER BY PF_TYPE, DIR_CD, SEQ ) CALL_SEQ" ).append("\n"); 
		query.append("        ,ROW_NUMBER () OVER (PARTITION BY DIR_CD, PF_TYPE ORDER BY PF_TYPE, DIR_CD, SEQ ) CALL_SEQ" ).append("\n"); 
		query.append("        ,YD_CD  ,ROW_NUMBER () OVER (PARTITION BY DIR_CD, PF_TYPE, YD_CD ORDER BY PF_TYPE, DIR_CD, SEQ) YARD_SEQ" ).append("\n"); 
		query.append("        ,@[cre_usr_id], SYSDATE, @[cre_usr_id], SYSDATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT  LANE_CD, PF_TYPE, PORT_CD, SKD_DIR_CD,YD_CD" ).append("\n"); 
		query.append("                ,CASE WHEN (TURN_IND = 'Y' AND T11.VSL_SLAN_DIR_SEQ <> SEQ) THEN (SELECT VSL_SLAN_DIR_CD FROM MDM_VSL_SVC_LANE_DIR WHERE VSL_SLAN_CD = T11.LANE_CD AND VSL_SLAN_DIR_SEQ = SEQ AND DELT_FLG = 'N') ELSE SKD_DIR_CD END DIR_CD" ).append("\n"); 
		query.append("                ,CASE WHEN (TURN_IND = 'Y' AND T11.VSL_SLAN_DIR_SEQ <> SEQ) THEN PORT_ROTN_SEQ + 100 ELSE PORT_ROTN_SEQ END SEQ" ).append("\n"); 
		query.append("        FROM    " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT  T11.VSL_SLAN_CD         AS LANE_CD" ).append("\n"); 
		query.append("                        ,T11.PF_SVC_TP_CD       AS PF_TYPE" ).append("\n"); 
		query.append("                        ,T11.PORT_CD            AS PORT_CD" ).append("\n"); 
		query.append("                        ,T11.SKD_DIR_CD,T12.VSL_SLAN_DIR_SEQ, T11.PORT_ROTN_SEQ,T11.YD_CD" ).append("\n"); 
		query.append("                        ,DECODE(T11.PORT_ROTN_SEQ ||T11.TURN_PORT_IND_CD, '1N', 'Y', T11.TURN_PORT_IND_CD) TURN_IND" ).append("\n"); 
		query.append("						,FIRST_VALUE(T11.SKD_DIR_CD) OVER (PARTITION BY T11.VSL_SLAN_CD, T11.PF_SVC_TP_CD ORDER BY T11.PORT_ROTN_SEQ) AS DIR_1ST" ).append("\n"); 
		query.append("		        		,LAST_VALUE (T11.SKD_DIR_CD) OVER (PARTITION BY T11.VSL_SLAN_CD, T11.PF_SVC_TP_CD ORDER BY T11.PORT_ROTN_SEQ ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS DIR_2ND" ).append("\n"); 
		query.append("                FROM    VSK_PF_SKD_DTL T11, MDM_VSL_SVC_LANE_DIR T12" ).append("\n"); 
		query.append("                WHERE   T11.VSL_SLAN_CD     = T12.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND     T11.SKD_DIR_CD      = T12.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                AND     T11.VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append("				AND     T11.PF_SVC_TP_CD    = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("                AND     T11.TURN_PORT_IND_CD != 'F'		/* 첫번째 turn = Y 에서 다시 만들기 때문 제외 한다.			*/" ).append("\n"); 
		query.append("                ORDER BY T11.PF_SVC_TP_CD, PORT_ROTN_SEQ" ).append("\n"); 
		query.append("            ) T11, (SELECT 1 SEQ   FROM DUAL UNION ALL SELECT 2 SEQ FROM DUAL) T12" ).append("\n"); 
		query.append("        WHERE  TURN_IND||SEQ <> 'N2'					/* 일반 Port에 Virtual Port가 생성되지 않도록 한다.			*/" ).append("\n"); 
		query.append("		AND		DIR_1ST <>	DIR_2ND						/* Lane, Lane Type별 처음, 마지막 dir 같을 경우에 제외 한다.	*/" ).append("\n"); 
		query.append("    ) T21" ).append("\n"); 

	}
}