/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOsearchPortSkdDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.08 
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

public class MarineTerminalInvoiceManageDBDAOsearchPortSkdDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPortSkdDetailList
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOsearchPortSkdDetailListRSQL(){
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
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yn",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOsearchPortSkdDetailListRSQL").append("\n"); 
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
		query.append("SELECT VX.*," ).append("\n"); 
		query.append("       TES_GET_CNTR_CHK_FNC(@[atb_dt], @[yd_cd], @[vvd], VX.RVIS_CNTR_NO, @[io_bnd_cd]) AS CNTR_CHK" ).append("\n"); 
		query.append("  FROM (SELECT C.CNTR_NO AS RVIS_CNTR_NO," ).append("\n"); 
		query.append("               C.SZTP AS RVIS_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               C.POL," ).append("\n"); 
		query.append("               C.OPR_CD," ).append("\n"); 
		query.append("               C.PRECELL," ).append("\n"); 
		query.append("               C.POSITION," ).append("\n"); 
		query.append("               NVL(C.SHIFT_TYPE, '') || NVL(C.SHIFT_RSN, '') AS SHIFT_RSN," ).append("\n"); 
		query.append("               C.ACCOUNT," ).append("\n"); 
		query.append("               C.PARTY," ).append("\n"); 
		query.append("               C.RESPB_CNTR_NO," ).append("\n"); 
		query.append("               (SELECT DECODE ( SIGN ( COUNT(1) ), 1, 'File Attached', NULL )" ).append("\n"); 
		query.append("                  FROM OPF_TDR_ATCH_FILE F" ).append("\n"); 
		query.append("                 WHERE C.VSL_CD = F.VSL_CD" ).append("\n"); 
		query.append("                   AND C.VOY_NO = F.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND C.DIR_CD = F.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND C.PORT_CD = F.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND C.CALL_IND = F.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   AND C.STATUS = F.CNTR_HNDL_KND_CD" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = F.CNTR_NO ) AS FILE_ATCH," ).append("\n"); 
		query.append("               C.FE," ).append("\n"); 
		query.append("               V.YD_CD," ).append("\n"); 
		query.append("               V.CLPT_IND_SEQ," ).append("\n"); 
		query.append("               V.VSL_CD," ).append("\n"); 
		query.append("               V.SKD_VOY_NO," ).append("\n"); 
		query.append("               V.SKD_DIR_CD," ).append("\n"); 
		query.append("               TURN_PORT_FLG," ).append("\n"); 
		query.append("               V.TURN_SKD_DIR_CD," ).append("\n"); 
		query.append("               V.TURN_SKD_VOY_NO," ).append("\n"); 
		query.append("               C.SHIFT_TYPE," ).append("\n"); 
		query.append("               MAX(DECODE(V.SKD_VOY_NO, SUBSTR(@[vvd], 5, 4), DECODE(TURN_PORT_FLG, 'Y', V.TURN_SKD_VOY_NO, ''), '')) OVER() AS MAX_TURN_SKD_VOY_NO," ).append("\n"); 
		query.append("               MAX(DECODE(V.SKD_VOY_NO, SUBSTR(@[vvd], 5, 4), DECODE(TURN_PORT_FLG, 'Y', V.TURN_SKD_DIR_CD, ''), '')) OVER() AS MAX_TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("               TDR_HEADER H," ).append("\n"); 
		query.append("               TDR_CNTR_DETAIL C" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND V.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND V.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("           AND C.ACCOUNT = 'SML'" ).append("\n"); 
		query.append("#if (${lgs_cost_cd} != 'SVRHCC' )" ).append("\n"); 
		query.append("           AND C.SHIFT_TYPE = 'Q'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("           AND C.SHIFT_TYPE = 'B'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${yn} != 'A' )" ).append("\n"); 
		query.append("           AND NVL(C.FE, 'E') = @[yn]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND V.VSL_CD = H.VSL_CD" ).append("\n"); 
		query.append("           AND V.SKD_VOY_NO = H.VOY_NO" ).append("\n"); 
		query.append("           AND V.SKD_DIR_CD = H.DIR_CD" ).append("\n"); 
		query.append("           AND V.VPS_PORT_CD = H.PORT_CD" ).append("\n"); 
		query.append("           AND V.CLPT_IND_SEQ = H.CALL_IND" ).append("\n"); 
		query.append("           AND H.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("           AND H.VOY_NO = C.VOY_NO" ).append("\n"); 
		query.append("           AND H.DIR_CD = C.DIR_CD" ).append("\n"); 
		query.append("           AND H.PORT_CD = C.PORT_CD" ).append("\n"); 
		query.append("           AND H.CALL_IND = C.CALL_IND" ).append("\n"); 
		query.append("           AND C.STATUS = 'ST'" ).append("\n"); 
		query.append("           AND TRIM(C.PRECELL) IS NOT NULL" ).append("\n"); 
		query.append("-- Status로 조회시 (MULTI 리스트로 파라메터 받아 loop문에서 처리)" ).append("\n"); 
		query.append("#if ($param_tpsz_cd.size() > 0)" ).append("\n"); 
		query.append("      AND C.SZTP IN (" ).append("\n"); 
		query.append("	#foreach($key in ${param_tpsz_cd}) " ).append("\n"); 
		query.append("		#if($velocityCount < $param_tpsz_cd.size()) " ).append("\n"); 
		query.append("			'$key', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			'$key' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 	) VX" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND ( (VX.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4) AND VX.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1) )" ).append("\n"); 
		query.append("            OR (VX.SKD_VOY_NO = VX.MAX_TURN_SKD_VOY_NO AND VX.SKD_DIR_CD = VX.MAX_TURN_SKD_DIR_CD))" ).append("\n"); 

	}
}