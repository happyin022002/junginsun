/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AvailableOffHireDBDAOAvailableOffHireContainerDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailableOffHireDBDAOAvailableOffHireContainerDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선택된 반납가능 대상 장비의 내역을 조회합니다.
	  * </pre>
	  */
	public AvailableOffHireDBDAOAvailableOffHireContainerDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("used_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_estm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk17",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk18",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complex_pk19",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_onh_dys_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("free_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_estm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration").append("\n"); 
		query.append("FileName : AvailableOffHireDBDAOAvailableOffHireContainerDetailRSQL").append("\n"); 
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
		query.append("WITH PARAM AS ( " ).append("\n"); 
		query.append("    SELECT  @[loc_tp]         AS P_LOC_TP," ).append("\n"); 
		query.append("            @[loc_cd]         AS P_LOC_CD," ).append("\n"); 
		query.append("            @[port_cd]        AS P_PORT_CD," ).append("\n"); 
		query.append("            @[slan_cd]        AS P_VSL_SLAN_CD," ).append("\n"); 
		query.append("            @[del_cd]         AS P_DEL_CD," ).append("\n"); 
		query.append("            @[vvd_cd]         AS P_VVD_CD," ).append("\n"); 
		query.append("            @[estm_tp]        AS P_ESTM_TP," ).append("\n"); 
		query.append("            @[str_estm_dt]    AS P_STR_ESTM_DT," ).append("\n"); 
		query.append("            @[end_estm_dt]    AS P_END_ESTM_DT," ).append("\n"); 
		query.append("            @[lstm_cd]        AS P_LSTM_CD," ).append("\n"); 
		query.append("            @[cntr_tpsz_cd]   AS P_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("            @[cnmv_sts_cd]    AS P_CNMV_STS_CD," ).append("\n"); 
		query.append("            @[agmt_cty_cd]    AS P_AGMT_CTY_CD," ).append("\n"); 
		query.append("            @[agmt_seq]       AS P_AGMT_SEQ," ).append("\n"); 
		query.append("            @[vndr_seq]       AS P_VNDR_SEQ," ).append("\n"); 
		query.append("            @[used_dys]       AS P_USED_DYS," ).append("\n"); 
		query.append("            @[free_dys]       AS P_FREE_DYS," ).append("\n"); 
		query.append("            @[min_onh_dys_tp] AS P_MIN_ONH_DYS_TP" ).append("\n"); 
		query.append("    FROM    DUAL" ).append("\n"); 
		query.append("), TEMP_DROP01 AS (" ).append("\n"); 
		query.append("SELECT  SUBSTR(STR_DATA, 1, 5) AS T_SCC_CD" ).append("\n"); 
		query.append("      , SUBSTR(STR_DATA, 6, 3) AS T_AGMT_CTY_CD" ).append("\n"); 
		query.append("      , TO_NUMBER(SUBSTR(STR_DATA, 9, 6)) AS T_AGMT_SEQ" ).append("\n"); 
		query.append("      , SUBSTR(STR_DATA, 15, 2) AS T_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#if (${complex_pk2} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk2] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk3} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk3] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk4} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk4] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk5} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk5] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk6} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk6] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk7} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk7] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk8} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk8] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk9} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk9] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk10} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk10] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk11} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk11] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk12} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk12] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk13} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk13] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk14} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk14] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk15} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk15] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk16} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk16] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk17} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk17] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk18} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk18] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${complex_pk19} != '')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  SUBSTR( STR_DATA, INSTR(STR_DATA, '|', 1, LEVEL) + 1, INSTR(STR_DATA, '|', 1, LEVEL + 1) - INSTR(STR_DATA, '|', 1, LEVEL) - 1) AS STR_DATA" ).append("\n"); 
		query.append("        FROM    (SELECT  @[complex_pk19] AS STR_DATA  FROM DUAL)" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= LENGTH(STR_DATA) - LENGTH(REPLACE(STR_DATA, '|')) - 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT    T01.LOC_CLSS , T01.CNTR_NO , T01.CNMV_YR , T01.CNMV_ID_NO  , T01.BKG_NO , T01.BL_NO, T01.CNTR_TPSZ_CD , T01.CNMV_STS_CD AS MVMT_STS_CD" ).append("\n"); 
		query.append("        , TO_CHAR(T01.CNMV_DT, 'YYYYMMDD') AS CNMV_DT , T01.CRNT_YD_CD , NULL AS OFF_HIRE_YARD , ROUND(SYSDATE - T01.ONH_DT) AS USED_DAYS" ).append("\n"); 
		query.append("        , T01.MTY_RTN_YD_CD, NULL AS OFF_HIRE_DUE_DATE, DECODE(T01.FULL_FLG,'Y','F','M') AS FULL_FLG, T01.ONH_YD_CD, TO_CHAR(T01.ONH_DT, 'YYYYMMDD') AS ONH_DT" ).append("\n"); 
		query.append("        , T01.SCC_CD , T01.LCC_CD , T01.RCC_CD , T01.POL_CD, T01.POD_CD , T01.DEL_CD , T01.VSL_SLAN_CD  ,  T01.VSL_CD , T01.SKD_VOY_NO , T01.SKD_DIR_CD" ).append("\n"); 
		query.append("        , T01.AGMT_CTY_CD , T01.AGMT_SEQ , T01.AGMT_CTY_CD||LPAD(T01.AGMT_SEQ, 6, '0') AS AGMT_NO , T01.REF_NO , T01.VNDR_SEQ , T01.VNDR_ABBR_NM , T01.VNDR_LGL_ENG_NM , T01.LSTM_CD , T01.ONH_FREE_DYS , T01.MIN_ONH_DYS" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT  /*+ USE_NL( S01 S02 S03 ) */" ).append("\n"); 
		query.append("                  MNR_COMMON_PKG.MNR_GET_RPRCOST_FNC('U', S01.CNTR_NO)" ).append("\n"); 
		query.append("          FROM    LSE_AVAL_OFFH S01" ).append("\n"); 
		query.append("                , MNR_ORD_DTL   S02" ).append("\n"); 
		query.append("                , MNR_ORD_HDR   S03" ).append("\n"); 
		query.append("          WHERE   1=1" ).append("\n"); 
		query.append("          AND     S01.CNTR_NO            = T01.CNTR_NO" ).append("\n"); 
		query.append("          AND     S01.CNTR_NO            = S02.EQ_NO" ).append("\n"); 
		query.append("          AND     S02.MNR_ORD_OFC_CTY_CD = S03.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("          AND     S02.MNR_ORD_SEQ        = S03.MNR_ORD_SEQ" ).append("\n"); 
		query.append("          AND     S01.OFFH_DUE_DT        > TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE, -1)),'YYYYMMDD')" ).append("\n"); 
		query.append("          AND     S01.OFFH_STS_CD        = 'C'" ).append("\n"); 
		query.append("          GROUP BY S01.CNTR_NO" ).append("\n"); 
		query.append("          )  AS MNR_COST" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT  /*+ USE_NL( S1 S2 S3 ) ORDERED */" ).append("\n"); 
		query.append("                  S3.EVNT_OFC_CD " ).append("\n"); 
		query.append("          FROM    BKG_CONTAINER S1" ).append("\n"); 
		query.append("                , BKG_DO_CNTR   S2" ).append("\n"); 
		query.append("                , BKG_DO_DTL    S3" ).append("\n"); 
		query.append("          WHERE   1=1" ).append("\n"); 
		query.append("          AND     S1.BKG_NO   = T01.BKG_NO" ).append("\n"); 
		query.append("          AND     S1.CNTR_NO  = T01.CNTR_NO" ).append("\n"); 
		query.append("          AND     S1.BKG_NO   = S2.BKG_NO      (+)" ).append("\n"); 
		query.append("          AND     S1.CNTR_NO  = S2.CNTR_NO     (+)" ).append("\n"); 
		query.append("          AND     S2.BKG_NO   = S3.BKG_NO      (+)" ).append("\n"); 
		query.append("          AND     S2.RLSE_SEQ = S3.RLSE_SEQ    (+)" ).append("\n"); 
		query.append("          AND     'R'         = S3.RLSE_STS_CD" ).append("\n"); 
		query.append("          AND     ROWNUM      = 1" ).append("\n"); 
		query.append("          ) AS EVNT_OFC_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("         SELECT  /*+ INDEX (S01 XPKBKG_VVD) */" ).append("\n"); 
		query.append("                 TO_CHAR(S02.VPS_ETD_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("         FROM    BKG_VVD          S01" ).append("\n"); 
		query.append("               , VSK_VSL_PORT_SKD S02" ).append("\n"); 
		query.append("         WHERE   1= 1" ).append("\n"); 
		query.append("         AND     S01.BKG_NO           = T01.BKG_NO" ).append("\n"); 
		query.append("         AND     S01.VSL_CD           = S02.VSL_CD      (+)" ).append("\n"); 
		query.append("         AND     S01.SKD_VOY_NO       = S02.SKD_VOY_NO  (+)" ).append("\n"); 
		query.append("         AND     S01.SKD_DIR_CD       = S02.SKD_DIR_CD  (+)" ).append("\n"); 
		query.append("         AND     S01.POL_CD           = S02.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("         AND     S01.POL_CLPT_IND_SEQ = S02.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("         AND     ROWNUM               = 1" ).append("\n"); 
		query.append("         ) AS POL_ETD_DT" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("         SELECT  /*+ INDEX_DESC (S01 XPKBKG_VVD) */" ).append("\n"); 
		query.append("                 TO_CHAR(S02.VPS_ETA_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("         FROM    BKG_VVD          S01" ).append("\n"); 
		query.append("               , VSK_VSL_PORT_SKD S02" ).append("\n"); 
		query.append("         WHERE   1= 1" ).append("\n"); 
		query.append("         AND     S01.BKG_NO           = T01.BKG_NO" ).append("\n"); 
		query.append("         AND     S01.VSL_CD           = S02.VSL_CD      (+)" ).append("\n"); 
		query.append("         AND     S01.SKD_VOY_NO       = S02.SKD_VOY_NO  (+)" ).append("\n"); 
		query.append("         AND     S01.SKD_DIR_CD       = S02.SKD_DIR_CD  (+)" ).append("\n"); 
		query.append("         AND     S01.POD_CD           = S02.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("         AND     S01.POD_CLPT_IND_SEQ = S02.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("         AND     ROWNUM               = 1" ).append("\n"); 
		query.append("         ) AS POD_ETA_DT" ).append("\n"); 
		query.append("       , T01.VSL_CD || T01.SKD_VOY_NO || T01.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("#if (${loc_case} == '0' || ${loc_case} == '1')" ).append("\n"); 
		query.append("        -- MASTER 정보 기준으로 조회" ).append("\n"); 
		query.append("        -- BOOKING이 없는 EN, TN, MT만 조회" ).append("\n"); 
		query.append("        SELECT  'LOCAL' AS LOC_CLSS, T1.CNTR_NO, T1.CNMV_YR, T1.CNMV_ID_NO, NULL AS BKG_NO, NULL AS BL_NO, T1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , T1.CNMV_STS_CD, T1.CNMV_DT, T1.CRNT_YD_CD, T1.CRNT_YD_CD AS MTY_RTN_YD_CD, NULL AS DEL_CD, T1.SCC_CD, T1.LCC_CD, T1.RCC_CD, NULL AS POL_CD, NULL AS POD_CD" ).append("\n"); 
		query.append("              , NULL AS VSL_SLAN_CD, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.FULL_FLG, T1.ONH_YD_CD" ).append("\n"); 
		query.append("              , T1.AGMT_CTY_CD, T1.AGMT_SEQ, T2.REF_NO, T2.VNDR_SEQ, T10.VNDR_ABBR_NM, T10.VNDR_LGL_ENG_NM, T1.LSTM_CD, T1.ONH_FREE_DYS, T1.ONH_DT, T1.MIN_ONH_DYS" ).append("\n"); 
		query.append("        FROM    PARAM               P" ).append("\n"); 
		query.append("              , MST_CONTAINER       T1" ).append("\n"); 
		query.append("              , LSE_AGREEMENT       T2" ).append("\n"); 
		query.append("              , MDM_VENDOR          T10" ).append("\n"); 
		query.append("              , TEMP_DROP01         T11" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T1.AGMT_CTY_CD  = T2.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T1.AGMT_SEQ     = T2.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     T1.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("        AND     T1.CNMV_STS_CD  IN ('EN', 'MT', 'TN')" ).append("\n"); 
		query.append("        AND     T1.LSTM_CD      IN ('OF', 'MI', 'LT', 'SI', 'ST')" ).append("\n"); 
		query.append("        AND     CASE WHEN T1.CNMV_STS_CD = 'MT' THEN" ).append("\n"); 
		query.append("                          1" ).append("\n"); 
		query.append("                     WHEN T1.CNMV_STS_CD IN ('EN', 'TN' ) THEN" ).append("\n"); 
		query.append("                          1" ).append("\n"); 
		query.append("                     END" ).append("\n"); 
		query.append("               =" ).append("\n"); 
		query.append("                CASE WHEN T1.CNMV_STS_CD = 'MT' THEN" ).append("\n"); 
		query.append("                          1" ).append("\n"); 
		query.append("                     WHEN T1.CNMV_STS_CD IN ('EN', 'TN' ) THEN" ).append("\n"); 
		query.append("                           CASE WHEN (T1.BKG_NO IS NULL OR T1.BKG_NO LIKE 'PSEUDO%') THEN -- MASTER의 BOOKING 컬럼값이 PSEUDO001 이란 일부 BOOKING 테이블 없는 데이터 존재함." ).append("\n"); 
		query.append("                           1                                                              -- Booking 정보가 없는 경우(Empty Container) MASTER 정보를 참조." ).append("\n"); 
		query.append("                           ELSE" ).append("\n"); 
		query.append("                           0                                                              -- Booking 정보가 있는 경우(Full Container) Booking 정보를 참조." ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("                     END" ).append("\n"); 
		query.append("        AND     DECODE(T1.LSTM_CD, 'ST', T1.ONH_DT + NVL(T1.MIN_ONH_DYS,0),  T1.ONH_DT ) < SYSDATE" ).append("\n"); 
		query.append("       -- AND     DECODE(T1.LSTM_CD, 'LT', T2.LST_EXP_DT                    , SYSDATE - 1) < SYSDATE" ).append("\n"); 
		query.append("        AND     DECODE(T1.LSTM_CD, 'LT', DECODE(NVL(T1.MIN_ONH_DYS,0), 0, T2.LST_EXP_DT, T1.ONH_DT + NVL(T1.MIN_ONH_DYS,0)),SYSDATE -1) < SYSDATE" ).append("\n"); 
		query.append("        AND     CASE WHEN P_LOC_TP = '0' THEN T1.RCC_CD" ).append("\n"); 
		query.append("                     WHEN P_LOC_TP = '1' THEN T1.LCC_CD" ).append("\n"); 
		query.append("                     WHEN P_LOC_TP = '2' THEN T1.SCC_CD" ).append("\n"); 
		query.append("                     WHEN P_LOC_TP = '3' THEN T1.CRNT_YD_CD END = P_LOC_CD" ).append("\n"); 
		query.append("        AND      T2.VNDR_SEQ      = T10.VNDR_SEQ" ).append("\n"); 
		query.append("        AND      T1.SCC_CD        = T11.T_SCC_CD" ).append("\n"); 
		query.append("        AND      T1.AGMT_CTY_CD   = T11.T_AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND      T1.AGMT_SEQ      = T11.T_AGMT_SEQ" ).append("\n"); 
		query.append("        AND      T1.CNTR_TPSZ_CD  = T11.T_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("        AND     T1.LSTM_CD IN ( " ).append("\n"); 
		query.append("	#foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("        AND     T1.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("        AND     T1.CNMV_STS_CD IN (" ).append("\n"); 
		query.append("    #foreach($key IN ${cnmv_sts_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cnmv_sts_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("        AND     T1.AGMT_CTY_CD = P_AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T1.AGMT_SEQ    = P_AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("        AND     T10.VNDR_SEQ    = P_VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${used_dys} != '')" ).append("\n"); 
		query.append("        AND     SYSDATE        > T1.ONH_DT + P_USED_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${free_dys} != '')" ).append("\n"); 
		query.append("        AND     T1.ONH_FREE_DYS > P_FREE_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        -- BOOKING에 DEL LOCATION 기준으로 조회" ).append("\n"); 
		query.append("        -- CTM 에서 VD 발생시 자동으로 IC를 생성함으로 VD 로직은 별도로 넣지 않는다." ).append("\n"); 
		query.append("        -- EN, TN BOOKING 기준으로 조회 " ).append("\n"); 
		query.append("        SELECT  'LOCAL' AS LOC_CLSS, T1.CNTR_NO, T1.CNMV_YR, T1.CNMV_ID_NO, T2.BKG_NO, T2.BL_NO, T1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , T1.CNMV_STS_CD, T1.CNMV_DT, T1.CRNT_YD_CD, D.NOD_CD MTY_RTN_YD_CD, T2.DEL_CD, T9.SCC_CD, T9.LCC_CD, T9.RCC_CD, T2.POL_CD, T2.POD_CD" ).append("\n"); 
		query.append("              , NULL AS VSL_SLAN_CD, T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD, T1.FULL_FLG, T1.ONH_YD_CD" ).append("\n"); 
		query.append("              , T1.AGMT_CTY_CD, T1.AGMT_SEQ, T3.REF_NO, T3.VNDR_SEQ, T10.VNDR_ABBR_NM, T10.VNDR_LGL_ENG_NM, T1.LSTM_CD, T1.ONH_FREE_DYS, T1.ONH_DT, T1.MIN_ONH_DYS" ).append("\n"); 
		query.append("        FROM    PARAM               P" ).append("\n"); 
		query.append("              , MST_CONTAINER       T1" ).append("\n"); 
		query.append("              , BKG_BOOKING         T2" ).append("\n"); 
		query.append("              , LSE_AGREEMENT       T3" ).append("\n"); 
		query.append("              , MDM_LOCATION        T8" ).append("\n"); 
		query.append("              , MDM_EQ_ORZ_CHT      T9" ).append("\n"); 
		query.append("              , MDM_VENDOR          T10" ).append("\n"); 
		query.append("              , SCE_COP_HDR         H" ).append("\n"); 
		query.append("              , SCE_COP_DTL         D" ).append("\n"); 
		query.append("              , TEMP_DROP01         T11" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     T1.BKG_NO        = T2.BKG_NO" ).append("\n"); 
		query.append("        AND     T1.AGMT_CTY_CD   = T3.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T1.AGMT_SEQ      = T3.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     DECODE(T1.LSTM_CD, 'ST', T1.ONH_DT + NVL(T1.MIN_ONH_DYS,0),  T1.ONH_DT ) < SYSDATE" ).append("\n"); 
		query.append("      --  AND     DECODE(T1.LSTM_CD, 'LT', T3.LST_EXP_DT                    , SYSDATE - 1) < SYSDATE" ).append("\n"); 
		query.append("        AND     DECODE(T1.LSTM_CD, 'LT', DECODE(NVL(T1.MIN_ONH_DYS,0), 0, T3.LST_EXP_DT, T1.ONH_DT + NVL(T1.MIN_ONH_DYS,0)),SYSDATE -1) < SYSDATE" ).append("\n"); 
		query.append("      --  AND     T8.LOC_CD        = SUBSTR(T2.MTY_RTN_YD_CD, 1, 5)                          -- Full Container가 Empty로 반납되는 지역에 해당하는 Empty Return Yard 기준으로 대상 조회" ).append("\n"); 
		query.append("        AND     T8.LOC_CD = SUBSTR(D.NOD_CD, 1, 5)" ).append("\n"); 
		query.append("        AND     H.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("        AND     H.CNTR_NO = T1.CNTR_NO" ).append("\n"); 
		query.append("        AND     H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("        AND     D.ACT_CD = 'MITYAD'" ).append("\n"); 
		query.append("        AND     H.COP_STS_CD <> 'X'       " ).append("\n"); 
		query.append("        AND     T8.SCC_CD        = T9.SCC_CD" ).append("\n"); 
		query.append("        AND     T1.ACIAC_DIV_CD  = 'A'" ).append("\n"); 
		query.append("        AND     T1.CNMV_STS_CD IN ('IC', 'ID', 'EN', 'TN')" ).append("\n"); 
		query.append("        AND     T1.LSTM_CD     IN ('OF', 'MI', 'LT', 'SI', 'ST')" ).append("\n"); 
		query.append("        AND     CASE WHEN P_LOC_TP = '0' THEN T9.RCC_CD" ).append("\n"); 
		query.append("                     WHEN P_LOC_TP = '1' THEN T9.LCC_CD" ).append("\n"); 
		query.append("                     WHEN P_LOC_TP = '2' THEN T9.SCC_CD" ).append("\n"); 
		query.append("                     WHEN P_LOC_TP = '3' THEN NVL(T2.MTY_RTN_YD_CD, T1.CRNT_YD_CD) END      -- BOOKING.MTY_RTN_YD_CD가 NULL인 것이 있어, MASTER.CRNT_YD_CD를 사용하도록 함." ).append("\n"); 
		query.append("                                   = P_LOC_CD" ).append("\n"); 
		query.append("        AND     CASE WHEN T1.CNMV_STS_CD IN ('IC', 'ID')                           THEN 'Y' -- IN BOUND 임으로 MVMT 정보를 조회할 필요 없음" ).append("\n"); 
		query.append("                     WHEN T1.CNMV_STS_CD IN ('EN', 'TN') AND T1.FULL_FLG = 'N'     THEN 'Y' -- EMPTY CONTAINER MOVEMENT로 EN, TN 발생 MVMT 정보를 조회할 필요 없음" ).append("\n"); 
		query.append("                     WHEN T1.CNMV_STS_CD IN ('EN', 'TN') AND T1.FULL_FLG = 'Y'     THEN     -- FULL CONTAINER MOVEMENT로 EN, TN 발생" ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("                          SELECT  DECODE(S.OB_CNTR_FLG, 'N', 'Y', 'N')                      -- IN BOUND EN, TN인 경우에만 대상 됨" ).append("\n"); 
		query.append("                          FROM    CTM_MOVEMENT    S" ).append("\n"); 
		query.append("                          WHERE   T1.CNTR_NO      = S.CNTR_NO" ).append("\n"); 
		query.append("                          AND     T1.CNMV_STS_CD  = S.MVMT_STS_CD" ).append("\n"); 
		query.append("                          AND     T1.CNMV_YR      = S.CNMV_YR" ).append("\n"); 
		query.append("                          AND     T1.CNMV_ID_NO   = S.CNMV_ID_NO" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                     END  = 'Y'" ).append("\n"); 
		query.append("        AND      T3.VNDR_SEQ      = T10.VNDR_SEQ" ).append("\n"); 
		query.append("        AND      T9.SCC_CD        = T11.T_SCC_CD" ).append("\n"); 
		query.append("        AND      T1.AGMT_CTY_CD   = T11.T_AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND      T1.AGMT_SEQ      = T11.T_AGMT_SEQ" ).append("\n"); 
		query.append("        AND      T1.CNTR_TPSZ_CD  = T11.T_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("        AND     T1.LSTM_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("        AND     T1.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("        AND     T1.CNMV_STS_CD IN (" ).append("\n"); 
		query.append("    #foreach($key IN ${cnmv_sts_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cnmv_sts_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("        AND     T1.AGMT_CTY_CD = P_AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T1.AGMT_SEQ    = P_AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("        AND     T10.VNDR_SEQ    = P_VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${used_dys} != '')" ).append("\n"); 
		query.append("        AND     SYSDATE        > T1.ONH_DT + P_USED_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${free_dys} != '')" ).append("\n"); 
		query.append("        AND     T1.ONH_FREE_DYS > P_FREE_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_case} == '0')" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_case} != '1')" ).append("\n"); 
		query.append("        -- BOOKING 정보가 존재하는 CONTAINER만 대상" ).append("\n"); 
		query.append("        -- MASTER YARD 기준, VL,VD 정보를 조회.    (현재 CONTAINER LOADING LOCATION 기준)" ).append("\n"); 
		query.append("        -- BOOKING 정보 DEL CODE 기준로 화면 표시. (최종 CONTAINER DELIVERY LOCATION 기준)" ).append("\n"); 
		query.append("        SELECT  'PORT' AS LOC_CLSS, T1.CNTR_NO, T1.CNMV_YR, T1.CNMV_ID_NO, T2.BKG_NO, T2.BL_NO, T1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , T1.CNMV_STS_CD, T1.CNMV_DT, T1.CRNT_YD_CD, T2.MTY_RTN_YD_CD, T2.DEL_CD, T9.SCC_CD, T9.LCC_CD, T9.RCC_CD, T2.POL_CD, T2.POD_CD" ).append("\n"); 
		query.append("              , T4.VSL_SLAN_CD, T4.VSL_CD, T4.SKD_VOY_NO, T4.SKD_DIR_CD, T1.FULL_FLG, T1.ONH_YD_CD" ).append("\n"); 
		query.append("              , T1.AGMT_CTY_CD, T1.AGMT_SEQ, T6.REF_NO, T10.VNDR_SEQ, T10.VNDR_ABBR_NM, T10.VNDR_LGL_ENG_NM, T1.LSTM_CD, T1.ONH_FREE_DYS, T1.ONH_DT, T1.MIN_ONH_DYS" ).append("\n"); 
		query.append("        FROM    PARAM               P" ).append("\n"); 
		query.append("              , MST_CONTAINER       T1" ).append("\n"); 
		query.append("              , BKG_BOOKING         T2" ).append("\n"); 
		query.append("              , BKG_VVD             T3" ).append("\n"); 
		query.append("              , VSK_VSL_SKD         T4" ).append("\n"); 
		query.append("              , VSK_VSL_PORT_SKD    T5" ).append("\n"); 
		query.append("              , LSE_AGREEMENT       T6" ).append("\n"); 
		query.append("              , MDM_LOCATION        T8" ).append("\n"); 
		query.append("              , MDM_EQ_ORZ_CHT      T9" ).append("\n"); 
		query.append("              , MDM_VENDOR          T10" ).append("\n"); 
		query.append("              , TEMP_DROP01         T11" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     T1.BKG_NO           = T2.BKG_NO" ).append("\n"); 
		query.append("        AND     T1.ACIAC_DIV_CD     = 'A'" ).append("\n"); 
		query.append("        AND     T1.CNMV_STS_CD IN ('TS', 'VL')" ).append("\n"); 
		query.append("        AND     T1.LSTM_CD     IN ('OF', 'MI', 'LT', 'SI', 'ST')" ).append("\n"); 
		query.append("        AND     T1.AGMT_CTY_CD      = T6.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T1.AGMT_SEQ         = T6.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     DECODE(T1.LSTM_CD, 'ST', T1.ONH_DT + NVL(T1.MIN_ONH_DYS,0),  T1.ONH_DT ) < SYSDATE" ).append("\n"); 
		query.append("        AND     DECODE(T1.LSTM_CD, 'LT', T6.LST_EXP_DT                    , SYSDATE - 1) < SYSDATE" ).append("\n"); 
		query.append("        AND     DECODE(T1.LSTM_CD, 'LT', DECODE(NVL(T1.MIN_ONH_DYS,0), 0, T6.LST_EXP_DT, T1.ONH_DT + NVL(T1.MIN_ONH_DYS,0)),SYSDATE -1) < SYSDATE" ).append("\n"); 
		query.append("        AND     T2.BKG_NO           = T3.BKG_NO" ).append("\n"); 
		query.append("        AND     T1.CRNT_YD_CD       = T3.POL_YD_CD" ).append("\n"); 
		query.append("        AND     T3.VSL_CD           = T4.VSL_CD" ).append("\n"); 
		query.append("        AND     T3.SKD_VOY_NO       = T4.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     T3.SKD_DIR_CD       = T4.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     T4.VSL_CD           = T5.VSL_CD" ).append("\n"); 
		query.append("        AND     T4.SKD_VOY_NO       = T5.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     T4.SKD_DIR_CD       = T5.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     T3.POD_CD           = T5.VPS_PORT_CD" ).append("\n"); 
		query.append("        AND     T3.POD_CLPT_IND_SEQ = T5.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND     'S'                <> NVL(T5.SKD_CNG_STS_CD, 'N')" ).append("\n"); 
		query.append("        AND     T2.DEL_CD           = T8.LOC_CD" ).append("\n"); 
		query.append("        AND     T8.SCC_CD           = T9.SCC_CD" ).append("\n"); 
		query.append("        AND     T6.VNDR_SEQ         = T10.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     T9.SCC_CD           = T11.T_SCC_CD" ).append("\n"); 
		query.append("        AND     T1.AGMT_CTY_CD      = T11.T_AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T1.AGMT_SEQ         = T11.T_AGMT_SEQ" ).append("\n"); 
		query.append("        AND     T1.CNTR_TPSZ_CD     = T11.T_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("        AND     T2.POD_CD           = P_PORT_CD                                                                            -- Vessel Port" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("        AND     T5.SLAN_CD          = P_VSL_SLAN_CD                                                                        -- Vessel Lane" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("        AND     T2.DEL_CD           = P_DEL_CD                                                                             -- Delivery SCC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${str_estm_dt} != '')" ).append("\n"); 
		query.append("  #if (${estm_tp} == 'ETA')" ).append("\n"); 
		query.append("        AND     T5.VPS_ETA_DT BETWEEN TO_DATE( REPLACE(P_STR_ESTM_DT, '-',''),'YYYYMMDD') AND TO_DATE( REPLACE(P_END_ESTM_DT, '-',''), 'YYYYMMDD') + 0.99999   -- ETA" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("        AND     T5.VPS_ETD_DT BETWEEN TO_DATE( REPLACE(P_STR_ESTM_DT, '-',''),'YYYYMMDD') AND TO_DATE( REPLACE(P_END_ESTM_DT, '-',''), 'YYYYMMDD') + 0.99999   -- ETD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("        AND     T4.VSL_CD           = SUBSTR(P_VVD_CD, 1, 4)                                                               -- VVD Code" ).append("\n"); 
		query.append("        AND     T4.SKD_VOY_NO       = SUBSTR(P_VVD_CD, 5, 4)                                                               -- VVD Code" ).append("\n"); 
		query.append("        AND     T4.SKD_DIR_CD       = SUBSTR(P_VVD_CD, 9, 1)                                                               -- VVD Code" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("        AND     T1.LSTM_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("        '$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("        '$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("        AND     T1.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("        '$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("        '$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("        AND     T1.CNMV_STS_CD IN (" ).append("\n"); 
		query.append("    #foreach($key IN ${cnmv_sts_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cnmv_sts_cd_seq.size())" ).append("\n"); 
		query.append("        '$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("        '$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end                        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("        AND     T1.AGMT_CTY_CD = P_AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T1.AGMT_SEQ    = P_AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("        AND     T10.VNDR_SEQ    = P_VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${used_dys} != '')" ).append("\n"); 
		query.append("        AND     SYSDATE        > T1.ONH_DT + P_USED_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${free_dys} != '')" ).append("\n"); 
		query.append("        AND     T1.ONH_FREE_DYS > P_FREE_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )               T01" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     NOT EXISTS" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  'X'" ).append("\n"); 
		query.append("        FROM    LSE_AVAL_OFFH S" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T01.AGMT_CTY_CD  = S.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T01.AGMT_SEQ     = S.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     T01.CNTR_NO      = S.CNTR_NO" ).append("\n"); 
		query.append("        AND     S.OFFH_STS_CD    IN ('R', 'C')" ).append("\n"); 
		query.append("        AND     (S.OFFH_DUE_DT > TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE, -1)), 'YYYYMMDD') OR S.OFFH_DUE_DT IS NULL)" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}