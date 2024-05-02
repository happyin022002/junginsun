/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTORRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTORRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTOR
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTORRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("no_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTORRSQL").append("\n"); 
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
		query.append("SELECT V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD, V.YD_CD, H.HATCH HATCH_HANDL, to_char(MIN(C.START_DATE),'YYYY-MM-DD HH24:MI') WORK_COMM, to_char(MAX(C.END_DATE), 'YYYY-MM-DD HH24:MI') WORK_COMP" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("  TDR_HEADER H," ).append("\n"); 
		query.append("  TDR_CRANE C" ).append("\n"); 
		query.append("WHERE V.VSL_CD = H.VSL_CD" ).append("\n"); 
		query.append("  AND V.SKD_VOY_NO = H.VOY_NO" ).append("\n"); 
		query.append("  AND V.SKD_DIR_CD = H.DIR_CD" ).append("\n"); 
		query.append("  AND V.VPS_PORT_CD = H.PORT_CD" ).append("\n"); 
		query.append("  AND V.CLPT_IND_SEQ = H.CALL_IND" ).append("\n"); 
		query.append("  AND H.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("  AND H.VOY_NO = C.VOY_NO(+)" ).append("\n"); 
		query.append("  AND H.DIR_CD = C.DIR_CD(+)" ).append("\n"); 
		query.append("  AND H.PORT_CD = C.PORT_CD(+)" ).append("\n"); 
		query.append("  AND H.CALL_IND = C.CALL_IND(+)" ).append("\n"); 
		query.append("  AND V.VSL_CD = SUBSTR(@[vvd],1,4) --vvd 변수 (빡)" ).append("\n"); 
		query.append("  AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("  AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("  AND V.YD_CD = @[no_yd_cd]  -- yard 변수" ).append("\n"); 
		query.append("  AND V.CLPT_IND_SEQ = '1' --default로 박아줌" ).append("\n"); 
		query.append("  AND C.START_DATE BETWEEN TO_DATE(SUBSTR(REPLACE(@[atb_dt],'-'),1,8),'YYYYMMDD')-7 AND TO_DATE(SUBSTR(REPLACE(@[atb_dt],'-'),1,8),'YYYYMMDD')+7   --MR invoice atb date를 넣음" ).append("\n"); 
		query.append("GROUP BY V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, V.YD_CD, H.GROSS_WORK, H.NET_WORK, H.LOSE_HR, H.GROSS_GANG, H.NET_GANG, H.HATCH, H.CON, H.MVS, H.GROSS_TML, H.NET_TML, H.GROSS_GC, H.NET_GC, H.COMMENCE, H.COMPLETE" ).append("\n"); 

	}
}