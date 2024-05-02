/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOCgoRhndPerformInputRestowReasonCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOCgoRhndPerformInputRestowReasonCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Restow Reason Code List
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOCgoRhndPerformInputRestowReasonCodeListRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOCgoRhndPerformInputRestowReasonCodeListRSQL").append("\n"); 
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
		query.append("SELECT      DISTINCT" ).append("\n"); 
		query.append("            CD.SHIFT_TYPE" ).append("\n"); 
		query.append("        ,   CD.SHIFT_TYPE||CD.SHIFT_RSN||CD.PARTY	AS RESTOW_REASON_LIST" ).append("\n"); 
		query.append("FROM        VSK_VSL_PORT_SKD    PS" ).append("\n"); 
		query.append("        ,   VSK_ACT_PORT_SKD    AK" ).append("\n"); 
		query.append("        ,   TDR_CNTR_DETAIL     CD" ).append("\n"); 
		query.append("WHERE       1 = 1" ).append("\n"); 
		query.append("AND         PS.VSL_CD           = AK.VSL_CD" ).append("\n"); 
		query.append("AND         PS.SKD_VOY_NO       = AK.SKD_VOY_NO" ).append("\n"); 
		query.append("AND         PS.SKD_DIR_CD       = AK.SKD_DIR_CD" ).append("\n"); 
		query.append("AND         PS.VPS_PORT_CD      = AK.VPS_PORT_CD" ).append("\n"); 
		query.append("AND         PS.CLPT_IND_SEQ     = AK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND         PS.VSL_CD           = CD.VSL_CD" ).append("\n"); 
		query.append("AND         PS.SKD_VOY_NO       = CD.VOY_NO" ).append("\n"); 
		query.append("AND         PS.SKD_DIR_CD       = CD.DIR_CD" ).append("\n"); 
		query.append("AND         PS.VPS_PORT_CD      = CD.PORT_CD" ).append("\n"); 
		query.append("AND         PS.CLPT_IND_SEQ     = CD.CALL_IND" ).append("\n"); 
		query.append("AND         AK.PORT_SKD_STS_CD  = 'D'" ).append("\n"); 
		query.append("AND         CD.SHIFT_TYPE||CD.SHIFT_RSN IS NOT NULL" ).append("\n"); 
		query.append("AND         AK.ACT_DEP_DT       BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')			--:fm_dt" ).append("\n"); 
		query.append("                                AND     TO_DATE(REPLACE(@[to_date]	,'-',''),'YYYYMMDD') + 0.99999	--:to_dt   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("AND         PS.SLAN_CD          LIKE @[slan_cd]||'%'   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("AND         PS.YD_CD            LIKE @[loc_cd]||@[yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY    DECODE(CD.SHIFT_TYPE,'S',1,'D',2,9)    ASC" ).append("\n"); 
		query.append("         ,  CD.SHIFT_TYPE||CD.SHIFT_RSN||CD.PARTY  ASC" ).append("\n"); 

	}
}