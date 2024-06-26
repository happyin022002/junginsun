/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchVskPortMnvrTimeZoneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchVskPortMnvrTimeZoneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchVskPortMnvrTimeZoneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchVskPortMnvrTimeZoneRSQL").append("\n"); 
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
		query.append("SELECT		NVL(PORT_DIST		,0) 	AS PORT_DIST	-- LNK_DIST" ).append("\n"); 
		query.append("    	,	NVL(VSL_SVC_SPD		,0) 	AS SPD" ).append("\n"); 
		query.append("    	,	CASE 	WHEN VSL_SVC_SPD = 0 THEN 0" ).append("\n"); 
		query.append("               		ELSE ROUND(PORT_DIST/VSL_SVC_SPD,0)" ).append("\n"); 
		query.append("          	END  	AS TZTM_HRS" ).append("\n"); 
		query.append("		, 	NVL(TIME_DIFF		,0) 	AS TIME_DIFF" ).append("\n"); 
		query.append("        , 	NVL(MNVR_IO_TIME	,0) 	AS MNVR_IN_HRS" ).append("\n"); 
		query.append("		, 	NVL(MNVR_IO_TIME	,0) 	AS MNVR_OUT_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		----, 	NVL(PORT_BUF_TIME	,0) 	AS PORT_BUF_HRS" ).append("\n"); 
		query.append("		,	0							AS PORT_BUF_HRS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ----, 	TO_NUMBER(SUBSTR(CRANES_TMNL_PRD,1,INSTR(CRANES_TMNL_PRD,':')-1)) AS CRN_KNT" ).append("\n"); 
		query.append("		,	0							AS CRN_KNT" ).append("\n"); 
		query.append("        ----, 	ROUND(TO_NUMBER(SUBSTR(CRANES_TMNL_PRD,INSTR(CRANES_TMNL_PRD,':')+1)),1) AS TML_PROD_QTY" ).append("\n"); 
		query.append("		,	0							AS TML_PROD_QTY" ).append("\n"); 
		query.append("FROM    	(" ).append("\n"); 
		query.append("            SELECT  (   SELECT  STND_DIST" ).append("\n"); 
		query.append("                        FROM    VSK_PORT_DIST" ).append("\n"); 
		query.append("                        WHERE   FM_LOC_CD   	= @[fm_loc_cd]" ).append("\n"); 
		query.append("                        AND     TO_LOC_CD   	= @[to_loc_cd]" ).append("\n"); 
		query.append("                    ) 	AS PORT_DIST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    --------------------------------" ).append("\n"); 
		query.append("                  ,  (   SELECT  NVL(VC.VSL_SVC_SPD,0)" ).append("\n"); 
		query.append("                        FROM    MDM_VSL_CNTR  	VC" ).append("\n"); 
		query.append("                        WHERE   VC.VSL_CD     	= @[vsl_cd]" ).append("\n"); 
		query.append("                    )   AS VSL_SVC_SPD" ).append("\n"); 
		query.append("                  ,  (  SELECT  LTRIM(TO_CHAR(GMT_HRS/60.0, '999,990'))" ).append("\n"); 
		query.append("                        FROM    MDM_LOCATION  	ML" ).append("\n"); 
		query.append("                        WHERE   ML.LOC_CD     	= @[loc_cd]" ).append("\n"); 
		query.append("                    )   AS TIME_DIFF " ).append("\n"); 
		query.append("                    --------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  --, (   SELECT  GMT_HRS / 60" ).append("\n"); 
		query.append("                  --      FROM    MDM_LOCATION" ).append("\n"); 
		query.append("                  --      WHERE   LOC_CD      	= [loc_cd]" ).append("\n"); 
		query.append("                  --  ) 	AS PORT_GMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  , (   SELECT  ROUND(AVG(PLT_MNVR_TM_HRS),0)" ).append("\n"); 
		query.append("                        FROM    VSK_PORT_MNVR" ).append("\n"); 
		query.append("                        WHERE   YD_CD   		LIKE @[yd_cd]||'%'" ).append("\n"); 
		query.append("                    ) 	AS MNVR_IO_TIME" ).append("\n"); 
		query.append("                  , (   SELECT  DOC_HRS + DEAD_HRS" ).append("\n"); 
		query.append("                        FROM    VSK_PORT_DOC_BUF_TM" ).append("\n"); 
		query.append("                        WHERE   LOC_CD  		= @[loc_cd]" ).append("\n"); 
		query.append("                    ) 	AS PORT_BUF_TIME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    --,(  SELECT  AVG_CRANES ||':'|| ROUND(DECODE(GROSS_WORK, 0, 0, TTL_MOVES / GROSS_WORK), 2) AS TMNL_PRD" ).append("\n"); 
		query.append("                    --    FROM    (" ).append("\n"); 
		query.append("                    --                SELECT ROUND(SUM(1) / DECODE(COUNT(DISTINCT T2.VSL_CD||T2.VOY_NO||T2.DIR_CD||T2.PORT_CD||T2.CALL_IND||T2.CALL_IND), 0, 1, COUNT(DISTINCT T2.VSL_CD||T2.VOY_NO||T2.DIR_CD||T2.PORT_CD||T2.CALL_IND||T2.CALL_IND)))  AS AVG_CRANES" ).append("\n"); 
		query.append("                    --                       ,SUM(T1.MVS)        AS TTL_MOVES" ).append("\n"); 
		query.append("                    --                       ,SUM(TO_NUMBER(SUBSTR(T1.GROSS_WORK,1,INSTR(T1.GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(T1.GROSS_WORK,INSTR(T1.GROSS_WORK,':')+1)/60)) AS GROSS_WORK" ).append("\n"); 
		query.append("                    --                FROM   TDR_HEADER T1, TDR_CRANE T2" ).append("\n"); 
		query.append("                    --                WHERE  T1.PORT_CD  = [loc_cd]" ).append("\n"); 
		query.append("                    --                AND    T1.VSL_CD   = T2.VSL_CD  (+)" ).append("\n"); 
		query.append("                    --                AND    T1.VOY_NO   = T2.VOY_NO  (+)" ).append("\n"); 
		query.append("                    --                AND    T1.DIR_CD   = T2.DIR_CD  (+)" ).append("\n"); 
		query.append("                    --                AND    T1.PORT_CD  = T2.PORT_CD (+)" ).append("\n"); 
		query.append("                    --                AND    T1.CALL_IND = T2.CALL_IND(+)" ).append("\n"); 
		query.append("                    --                AND    T1.UPDATE_TIME BETWEEN SYSDATE - 365 " ).append("\n"); 
		query.append("                    --                                     AND     SYSDATE" ).append("\n"); 
		query.append("                    --            )" ).append("\n"); 
		query.append("                    --) AS CRANES_TMNL_PRD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            FROM    DUAL" ).append("\n"); 
		query.append("        	)" ).append("\n"); 

	}
}