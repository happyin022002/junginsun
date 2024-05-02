/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOActPortSkdHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOActPortSkdHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual SKD 변경 이력을 조회한다.
	  * -----------------------------------------------------------------------------------------
	  * 2010.12.23 진마리아 [CHM-201007578-01] ACTUAL SKD HISTORY 조회 로직 변경
	  * 2011.10.26 김민아 [CHM-201114112-01] VSL SKD History Inquiry 화면 로직 변경 : 페이징 처리
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOActPortSkdHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOActPortSkdHisRSQL").append("\n"); 
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
		query.append("SELECT  VVD" ).append("\n"); 
		query.append("	   ,VSL_SLAN_CD" ).append("\n"); 
		query.append("	   ,VPS_PORT_CD" ).append("\n"); 
		query.append("	   ,OLD_ATA" ).append("\n"); 
		query.append("	   ,OLD_ATB" ).append("\n"); 
		query.append("	   ,OLD_ATD" ).append("\n"); 
		query.append("	   ,OLD_CRE" ).append("\n"); 
		query.append("	   ,OLD_USER_ID" ).append("\n"); 
		query.append("	   ,NEW_ATA" ).append("\n"); 
		query.append("	   ,NEW_ATB" ).append("\n"); 
		query.append("	   ,NEW_ATD" ).append("\n"); 
		query.append("	   ,NEW_CRE" ).append("\n"); 
		query.append("	   ,NEW_USER_ID" ).append("\n"); 
		query.append("	   ,CNG_SEQ" ).append("\n"); 
		query.append("	   ,TOTAL_CNT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT	VVD" ).append("\n"); 
		query.append("        		, VSL_SLAN_CD" ).append("\n"); 
		query.append("        		, VPS_PORT_CD" ).append("\n"); 
		query.append("        		, TO_CHAR(OLD_ATA, 'RRRRMMDDHH24MI') AS OLD_ATA" ).append("\n"); 
		query.append("        		, TO_CHAR(OLD_ATB, 'RRRRMMDDHH24MI') AS OLD_ATB" ).append("\n"); 
		query.append("        		, TO_CHAR(OLD_ATD, 'RRRRMMDDHH24MI') AS OLD_ATD" ).append("\n"); 
		query.append("        		, TO_CHAR(OLD_CRE, 'RRRRMMDDHH24MI') AS OLD_CRE" ).append("\n"); 
		query.append("        		, OLD_USER_ID" ).append("\n"); 
		query.append("        		, TO_CHAR(NEW_ATA, 'RRRRMMDDHH24MI') AS NEW_ATA" ).append("\n"); 
		query.append("        		, TO_CHAR(NEW_ATB, 'RRRRMMDDHH24MI') AS NEW_ATB" ).append("\n"); 
		query.append("        		, TO_CHAR(NEW_ATD, 'RRRRMMDDHH24MI') AS NEW_ATD" ).append("\n"); 
		query.append("        		, TO_CHAR(NEW_CRE, 'RRRRMMDDHH24MI') AS NEW_CRE" ).append("\n"); 
		query.append("        		, NEW_USER_ID" ).append("\n"); 
		query.append("        		, CNG_SEQ" ).append("\n"); 
		query.append("        		, ROW_NUMBER() OVER(ORDER BY CNG_SEQ DESC) AS RNUM" ).append("\n"); 
		query.append("        		, COUNT(1) OVER() AS TOTAL_CNT" ).append("\n"); 
		query.append("        FROM	(" ).append("\n"); 
		query.append("        			SELECT	ROW_NUMBER() OVER (PARTITION BY T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.VPS_PORT_CD, T1.CLPT_IND_SEQ ORDER BY T1.CRE_DT) AS SEQ" ).append("\n"); 
		query.append("        				, T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD   AS VVD" ).append("\n"); 
		query.append("        				, T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("        				, T1.VPS_PORT_CD" ).append("\n"); 
		query.append("        				, LAG(T1.ACT_ARR_DT    ) OVER (PARTITION BY T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.VPS_PORT_CD, T1.CLPT_IND_SEQ ORDER BY T1.CRE_DT) AS OLD_ATA" ).append("\n"); 
		query.append("        				, LAG(T1.ACT_BRTH_DT   ) OVER (PARTITION BY T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.VPS_PORT_CD, T1.CLPT_IND_SEQ ORDER BY T1.CRE_DT) AS OLD_ATB" ).append("\n"); 
		query.append("        				, LAG(T1.ACT_DEP_DT    ) OVER (PARTITION BY T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.VPS_PORT_CD, T1.CLPT_IND_SEQ ORDER BY T1.CRE_DT) AS OLD_ATD" ).append("\n"); 
		query.append("        				, LAG(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', T1.CRE_DT, @[vps_port_cd])) OVER (PARTITION BY T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.VPS_PORT_CD, T1.CLPT_IND_SEQ ORDER BY T1.CRE_DT) AS OLD_CRE" ).append("\n"); 
		query.append("        				, LAG(T1.CRE_USR_ID    ) OVER (PARTITION BY T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.VPS_PORT_CD, T1.CLPT_IND_SEQ ORDER BY T1.CRE_DT) AS OLD_USER_ID" ).append("\n"); 
		query.append("        				, T1.ACT_ARR_DT         AS NEW_ATA" ).append("\n"); 
		query.append("        				, T1.ACT_BRTH_DT        AS NEW_ATB" ).append("\n"); 
		query.append("        				, T1.ACT_DEP_DT         AS NEW_ATD" ).append("\n"); 
		query.append("        				, GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', T1.CRE_DT, @[vps_port_cd])             AS NEW_CRE" ).append("\n"); 
		query.append("        				, T1.CRE_USR_ID         AS NEW_USER_ID" ).append("\n"); 
		query.append("        				, T1.CNG_SEQ" ).append("\n"); 
		query.append("        			FROM	VSK_ACT_PORT_SKD_HIS T1, VSK_VSL_SKD T2" ).append("\n"); 
		query.append("        #if (${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("        					,(	SELECT  GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', TO_DATE(@[fm_dt]||' 00:00', 'YYYY-MM-DD HH24:MI'), @[vps_port_cd]) AS FM_DT" ).append("\n"); 
		query.append("        								, GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', TO_DATE(@[to_dt]||' 23:59:59', 'YYYY-MM-DD HH24:MI:SS'), @[vps_port_cd]) AS TO_DT" ).append("\n"); 
		query.append("        						FROM	DUAL" ).append("\n"); 
		query.append("        					) T3" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        			WHERE	1		= 1" ).append("\n"); 
		query.append("        			AND		T1.VSL_CD		= T2.VSL_CD" ).append("\n"); 
		query.append("        			AND		T1.SKD_VOY_NO	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("        			AND		T1.SKD_DIR_CD	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("        #if (${vsl_cd} != '') " ).append("\n"); 
		query.append("        			AND		T1.VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("        			AND		T1.SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("        			AND		T1.SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("        			AND		T2.VSL_SLAN_CD	= @[vsl_slan_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        			AND		T1.VPS_PORT_CD	= @[vps_port_cd]" ).append("\n"); 
		query.append("        #if (${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("        			AND		T1.CRE_DT	BETWEEN	T3.FM_DT 	AND		T3.TO_DT" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        		)" ).append("\n"); 
		query.append("        WHERE	NEW_USER_ID IS NOT NULL" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     RNUM BETWEEN (@[page_no]-1)*@[pagerows]+1 AND @[page_no]*@[pagerows]" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}