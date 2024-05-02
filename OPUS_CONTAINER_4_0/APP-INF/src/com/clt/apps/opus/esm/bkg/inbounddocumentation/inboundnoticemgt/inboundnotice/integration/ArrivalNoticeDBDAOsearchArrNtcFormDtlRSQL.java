/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcFormDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrNtcFormDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI-243
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcFormDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("an_fom_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agent",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcFormDtlRSQL").append("\n"); 
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
		query.append("SELECT  NTWD.AN_SEQ                          AS AN_SEQ" ).append("\n"); 
		query.append("       ,NVL(WDTL.AN_FOM_CD,'GE')             AS AN_FOM_CD" ).append("\n"); 
		query.append("       ,WDTL.ADDR_CTNT                       AS ADDR_CTNT" ).append("\n"); 
		query.append("       ,WDTL.IMPT_NTC_RMK                    AS IMPT_NTC_RMK" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("     SELECT  NTWD.AN_TP_CD   AS AN_TP_CD" ).append("\n"); 
		query.append("           , NTWD.AN_SEQ     AS AN_SEQ" ).append("\n"); 
		query.append("           , ROW_NUMBER() OVER (PARTITION BY NTWD.AN_TP_CD " ).append("\n"); 
		query.append("                                ORDER BY DECODE(NVL(@[agent], '*'), NTWD.CHN_AGN_CD, 0, 1)" ).append("\n"); 
		query.append("                                       , DECODE(@[pod_cd], NTWD.POD_CD, 0, 1)) ODR" ).append("\n"); 
		query.append("     FROM BKG_ARR_NTC_WD NTWD" ).append("\n"); 
		query.append("     WHERE NTWD.AN_TP_CD='ARN' -- 고정값       " ).append("\n"); 
		query.append("       AND NTWD.OFC_CD = @[ofc_cd] " ).append("\n"); 
		query.append("       AND NTWD.POD_CD IN ('*', @[pod_cd])" ).append("\n"); 
		query.append("       AND NTWD.CHN_AGN_CD IN ('*', @[agent])" ).append("\n"); 
		query.append(") NTWD" ).append("\n"); 
		query.append(", BKG_ARR_NTC_WD_DTL WDTL" ).append("\n"); 
		query.append("WHERE ODR = 1" ).append("\n"); 
		query.append("  AND WDTL.AN_SEQ(+) = NTWD.AN_SEQ" ).append("\n"); 
		query.append("  AND WDTL.AN_FOM_CD(+) = NVL(@[an_fom_cd],'GE')" ).append("\n"); 

	}
}