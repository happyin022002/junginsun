/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchPfSkdBerthWdoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchPfSkdBerthWdoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPfSkdBerthWdo
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchPfSkdBerthWdoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_tm_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_rotn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_dy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_dy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("etb_tm_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchPfSkdBerthWdoRSQL").append("\n"); 
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
		query.append("SELECT PORT_CD, SUBSTR(YD_CD,6,7) AS YD_CD, YD_NM, PORT_ROTN_SEQ,VSL_SLAN_CD, SKD_DIR_CD,NFLG" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'SUNSUN' THEN" ).append("\n"); 
		query.append("   -- Same day" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("                 ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("                 ''" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETB_TM" ).append("\n"); 
		query.append("            WHEN ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETD_TM" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                ''" ).append("\n"); 
		query.append("            END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'SUN' AND ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'SUN' AND ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("       ''" ).append("\n"); 
		query.append("   END LSUN" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'SUNSUN' THEN" ).append("\n"); 
		query.append("   -- Same day" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("             ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("             ''" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETB_TM" ).append("\n"); 
		query.append("        WHEN ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETD_TM" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("        END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'SUN' AND ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'SUN' AND ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("        ''" ).append("\n"); 
		query.append("   END AS RSUN" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'MONMON' THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("                 ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("                 ''" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETB_TM" ).append("\n"); 
		query.append("            WHEN ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETD_TM" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                ''" ).append("\n"); 
		query.append("            END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'MON' AND ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'MON' AND ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("       ''" ).append("\n"); 
		query.append("   END LMON" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'MONMON' THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("             ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("             ''" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETB_TM" ).append("\n"); 
		query.append("        WHEN ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETD_TM" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("        END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'MON' AND ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'MON' AND ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("        ''" ).append("\n"); 
		query.append("   END AS RMON" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'TUETUE' THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("                 ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("                 ''" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETB_TM" ).append("\n"); 
		query.append("            WHEN ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETD_TM" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                ''" ).append("\n"); 
		query.append("            END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'TUE' AND ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'TUE' AND ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("       ''" ).append("\n"); 
		query.append("   END LTUE" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'TUETUE' THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("             ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("             ''" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETB_TM" ).append("\n"); 
		query.append("        WHEN ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETD_TM" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("        END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'TUE' AND ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'TUE' AND ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("        ''" ).append("\n"); 
		query.append("   END AS RTUE" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'WEDWED' THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("                 ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("                 ''" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETB_TM" ).append("\n"); 
		query.append("            WHEN ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETD_TM" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                ''" ).append("\n"); 
		query.append("            END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'WED' AND ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'WED' AND ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("       ''" ).append("\n"); 
		query.append("   END LWED" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'WEDWED' THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("             ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("             ''" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETB_TM" ).append("\n"); 
		query.append("        WHEN ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETD_TM" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("        END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'WED' AND ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'WED' AND ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("        ''" ).append("\n"); 
		query.append("   END AS RWED" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'THUTHU' THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("                 ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("                 ''" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETB_TM" ).append("\n"); 
		query.append("            WHEN ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETD_TM" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                ''" ).append("\n"); 
		query.append("            END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'THU' AND ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'THU' AND ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("       ''" ).append("\n"); 
		query.append("   END LTHU" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'THUTHU' THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("             ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("             ''" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETB_TM" ).append("\n"); 
		query.append("        WHEN ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETD_TM" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("        END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'THU' AND ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'THU' AND ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("        ''" ).append("\n"); 
		query.append("   END AS RTHU" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'FRIFRI' THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("                 ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("                 ''" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETB_TM" ).append("\n"); 
		query.append("            WHEN ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETD_TM" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                ''" ).append("\n"); 
		query.append("            END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'FRI' AND ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'FRI' AND ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("       ''" ).append("\n"); 
		query.append("   END LFRI" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'FRIFRI' THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("             ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("             ''" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETB_TM" ).append("\n"); 
		query.append("        WHEN ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETD_TM" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("        END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'FRI' AND ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'FRI' AND ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("        ''" ).append("\n"); 
		query.append("   END AS RFRI" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'SATSAT' THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("                 ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("                 ''" ).append("\n"); 
		query.append("            WHEN ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETB_TM" ).append("\n"); 
		query.append("            WHEN ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("                 ETD_TM" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                ''" ).append("\n"); 
		query.append("            END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'SAT' AND ETB_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'SAT' AND ETD_TM_HRMNT <= '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("       ''" ).append("\n"); 
		query.append("   END LSAT" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("   WHEN ETB_DY_CD||ETD_DY_CD = 'SATSAT' THEN" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT >  '1159' AND ETD_TM_HRMNT >  '1159' THEN " ).append("\n"); 
		query.append("             ETB_TM||'/'||ETD_TM" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT <= '1159' AND ETD_TM_HRMNT <= '1159' THEN " ).append("\n"); 
		query.append("             ''" ).append("\n"); 
		query.append("        WHEN ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETB_TM" ).append("\n"); 
		query.append("        WHEN ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("             ETD_TM" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            ''" ).append("\n"); 
		query.append("        END          " ).append("\n"); 
		query.append("   WHEN ETB_DY_CD = 'SAT' AND ETB_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETB_TM" ).append("\n"); 
		query.append("   WHEN ETD_DY_CD = 'SAT' AND ETD_TM_HRMNT > '1159' THEN" ).append("\n"); 
		query.append("        ETD_TM" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("        ''" ).append("\n"); 
		query.append("   END AS RSAT" ).append("\n"); 
		query.append("  , CASE WHEN NO = 1 THEN /* 화면의 proforma schedul 정보*/" ).append("\n"); 
		query.append("        DECODE(SUM(DECODE(CHK, 'X', 1, 0)) OVER (PARTITION BY PORT_ROTN_SEQ), 1 , 'X', 'O') /*  VSK_PORT_BRTH_WDO의 결과가 X일 경우 화면의 proforma schedul 정보도 X로 치환한다*/" ).append("\n"); 
		query.append("    ELSE CHK /*  VSK_PORT_BRTH_WDO 정보*/" ).append("\n"); 
		query.append("    END  AS CHK" ).append("\n"); 
		query.append(", B_ETB_DY" ).append("\n"); 
		query.append(", B_ETD_DY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        SELECT  NO, NFLG,VSL_SLAN_CD, SKD_DIR_CD, CLPT_SEQ, PORT_ROTN_SEQ, PORT_CD, T42.YD_CD" ).append("\n"); 
		query.append("                , DECODE(NO,1,ETB_DY_CD, B_ETB_DY_CD        ) ETB_DY_CD" ).append("\n"); 
		query.append("                , DECODE(NO,1,ETB_TM_HRMNT,B_ETB_TM_HRMNT   ) ETB_TM_HRMNT" ).append("\n"); 
		query.append("                , SUBSTR(DECODE(NO,1,ETB_TM_HRMNT,B_ETB_TM_HRMNT   ), 1, 2) ETB_TM" ).append("\n"); 
		query.append("                , DECODE(NO,1,ETD_DY_CD,B_ETD_DY_CD         ) ETD_DY_CD" ).append("\n"); 
		query.append("                , DECODE(NO,1,ETD_TM_HRMNT,B_ETD_TM_HRMNT   ) ETD_TM_HRMNT" ).append("\n"); 
		query.append("                , SUBSTR(DECODE(NO,1,ETD_TM_HRMNT,B_ETD_TM_HRMNT   ), 1, 2) ETD_TM" ).append("\n"); 
		query.append("                , DECODE(CASE WHEN NO=1 THEN SUM(SW) OVER (PARTITION BY VSL_SLAN_CD, PORT_CD, SKD_DIR_CD, CLPT_SEQ) ELSE SW END, 0, 'O', 'X') CHK" ).append("\n"); 
		query.append("                , NVL(B_ETB_DY, DECODE(ETB_DY_CD,'SUN','01','MON','02','TUE','03','WED','04','THU', '05','FRI', '06', 'SAT','07')) B_ETB_DY" ).append("\n"); 
		query.append("                , NVL(B_ETD_DY, CASE WHEN  ETB_DY > ETD_DY THEN '1'||SUBSTR(ETD_DY,2) ELSE ETD_DY END) B_ETD_DY" ).append("\n"); 
		query.append("                , YD_NM" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                SELECT  T32.*" ).append("\n"); 
		query.append("                        , CASE WHEN ETD_DY  ||ETD_TM_HRMNT   BETWEEN B_ETB_DY||B_ETB_TM_HRMNT AND B_ETD_DY||B_ETD_TM_HRMNT " ).append("\n"); 
		query.append("                                 OR B_ETD_DY||B_ETD_TM_HRMNT BETWEEN ETB_DY||ETB_TM_HRMNT     AND ETD_DY||ETD_TM_HRMNT    THEN 1 ELSE 0 END SW" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                       SELECT    NO, NFLG,CLPT_SEQ, PORT_ROTN_SEQ, T31.VSL_SLAN_CD, SKD_DIR_CD, PORT_CD,  YD_CD" ).append("\n"); 
		query.append("                                , ETB_DY_CD, ETB_DY_NO,ETB_TM_HRMNT,ETD_DY_CD, ETD_DY_NO, ETD_TM_HRMNT,ETB_DY" ).append("\n"); 
		query.append("                                , CASE WHEN  ETB_DY > ETD_DY THEN '1'||SUBSTR(ETD_DY,2) ELSE ETD_DY END ETD_DY" ).append("\n"); 
		query.append("                                , B_ETB_DY_CD, B_ETB_TM_HRMNT,B_ETD_DY_CD, B_ETD_TM_HRMNT,B_ETB_DY" ).append("\n"); 
		query.append("                                , CASE WHEN  B_ETB_DY > B_ETD_DY THEN '1'||SUBSTR(B_ETD_DY,2) ELSE B_ETD_DY END B_ETD_DY" ).append("\n"); 
		query.append("                      FROM      (" ).append("\n"); 
		query.append("                                SELECT  T21.NO" ).append("\n"); 
		query.append("                                        ,DECODE(T21.NO,'1','0NEW','1OLD') AS NFLG" ).append("\n"); 
		query.append("                                        ,T21.CLPT_SEQ, T21.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("										, DECODE(T21.NO,'1',T21.VSL_SLAN_CD, T22.REF_SLAN_NM) AS VSL_SLAN_CD" ).append("\n"); 
		query.append("										, DECODE(T21.NO,'1',T21.SKD_DIR_CD, T22.SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("                                        , T21.PORT_CD, T21.YD_CD" ).append("\n"); 
		query.append("                                        , T21.ETB_DY_CD, T21.ETB_DY_NO, T21.ETB_TM_HRMNT, T21.ETB_DY" ).append("\n"); 
		query.append("                                        , T21.ETD_DY_CD, T21.ETD_DY_NO, T21.ETD_TM_HRMNT, T21.ETD_DY" ).append("\n"); 
		query.append("                                        , T22.ETB_DY_CD B_ETB_DY_CD, T22.ETB_TM_HRMNT B_ETB_TM_HRMNT" ).append("\n"); 
		query.append("                                        , DECODE(T22.ETB_DY_CD,'SUN','01','MON','02','TUE','03','WED','04','THU','05','FRI','06','SAT','07') B_ETB_DY" ).append("\n"); 
		query.append("                                        , T22.ETD_DY_CD B_ETD_DY_CD, T22.ETD_TM_HRMNT B_ETD_TM_HRMNT" ).append("\n"); 
		query.append("                                        , DECODE(T22.ETD_DY_CD,'SUN','01','MON','02','TUE','03','WED','04','THU','05','FRI','06','SAT','07') B_ETD_DY" ).append("\n"); 
		query.append("										, DECODE(T21.NO,'1','0NEW','1OLD') || DECODE(T22.ETB_DY_CD, NULL, 'X', 'Y') AS CHK_IND" ).append("\n"); 
		query.append("										/* BERTH WINDOW ('1OLD')에 NULL인 것을 삭제하기 위함 */" ).append("\n"); 
		query.append("                                FROM" ).append("\n"); 
		query.append("                                (" ).append("\n"); 
		query.append("                                        SELECT T11.*, NO" ).append("\n"); 
		query.append("                                        FROM" ).append("\n"); 
		query.append("                                        (" ).append("\n"); 
		query.append("                                            SELECT  @[vsl_slan_cd] AS VSL_SLAN_CD" ).append("\n"); 
		query.append("        											,@[port_cd] AS PORT_CD" ).append("\n"); 
		query.append("        											,@[skd_dir_cd] AS SKD_DIR_CD" ).append("\n"); 
		query.append("        											,@[clpt_seq] AS CLPT_SEQ" ).append("\n"); 
		query.append("											        ,@[port_rotn_seq] AS PORT_ROTN_SEQ" ).append("\n"); 
		query.append("											        ,@[yd_cd] AS YD_CD" ).append("\n"); 
		query.append("											        ,@[etb_dy_cd] AS ETB_DY_CD" ).append("\n"); 
		query.append("											        ,@[etb_dy_no] AS ETB_DY_NO" ).append("\n"); 
		query.append("											        ,@[etb_tm_hrmnt] AS ETB_TM_HRMNT" ).append("\n"); 
		query.append("											        ,DECODE(@[etb_dy_cd],'SUN','01','MON','02','TUE','03','WED','04','THU','05','FRI','06','SAT','07') AS ETB_DY" ).append("\n"); 
		query.append("											        ,@[etd_dy_cd] AS ETD_DY_CD" ).append("\n"); 
		query.append("											        ,@[etd_dy_no] AS ETD_DY_NO" ).append("\n"); 
		query.append("											        ,@[etd_tm_hrmnt] AS ETD_TM_HRMNT" ).append("\n"); 
		query.append("											        ,DECODE(@[etd_dy_cd],'SUN','01','MON','02','TUE','03','WED','04','THU','05','FRI','06','SAT','07') AS ETD_DY" ).append("\n"); 
		query.append("											FROM    DUAL" ).append("\n"); 
		query.append("										) T11," ).append("\n"); 
		query.append("                                        (SELECT 1 NO FROM DUAL UNION ALL SELECT 2 NO FROM DUAL) T12" ).append("\n"); 
		query.append("                                ) T21, VSK_PORT_BRTH_WDO T22" ).append("\n"); 
		query.append("                                WHERE   DECODE(NO,2,T21.YD_CD)  =  T22.YD_CD    (+)" ).append("\n"); 
		query.append("                                AND     T21.VSL_SLAN_CD         <> T22.REF_SLAN_NM  (+)" ).append("\n"); 
		query.append("								AND	    T22.LOC_CD(+)			NOT IN ('EGSCA', 'PAPCA')" ).append("\n"); 
		query.append("                          ) T31" ).append("\n"); 
		query.append("						WHERE	CHK_IND != '1OLDX'	/* BERTH WINDOW에 있는 데이터를 누락시킨다. */" ).append("\n"); 
		query.append("                    ) T32" ).append("\n"); 
		query.append("            ) T41, MDM_YARD T42" ).append("\n"); 
		query.append("        WHERE   T41.YD_CD   = T42.YD_CD" ).append("\n"); 
		query.append(") T51" ).append("\n"); 
		query.append("ORDER BY PORT_ROTN_SEQ, NO" ).append("\n"); 

	}
}