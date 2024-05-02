/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselPositionPollingManagementDBDAOSearchPositionPollingDetailVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselPositionPollingManagementDBDAOSearchPositionPollingDetailVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPositionPollingDetailVvd
	  * </pre>
	  */
	public VesselPositionPollingManagementDBDAOSearchPositionPollingDetailVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plng_gen_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dly_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.integration").append("\n"); 
		query.append("FileName : VesselPositionPollingManagementDBDAOSearchPositionPollingDetailVvdRSQL").append("\n"); 
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
		query.append("SELECT  YY.VSL_CD      " ).append("\n"); 
		query.append("	,	YY.SKD_VOY_NO  " ).append("\n"); 
		query.append("	,	YY.SKD_DIR_CD  " ).append("\n"); 
		query.append("	,	YY.VPS_PORT_CD " ).append("\n"); 
		query.append("	,	YY.CLPT_IND_SEQ" ).append("\n"); 
		query.append("	,	YY.CLPT_SEQ    " ).append("\n"); 
		query.append("	,	YY.FIRST_VPS_ETA_DT" ).append("\n"); 
		query.append("	,	YY.PRE_VSL_CD " ).append("\n"); 
		query.append("	,	YY.PRE_SKD_VOY_NO" ).append("\n"); 
		query.append("    ,	YY.PRE_SKD_DIR_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        --==================================================================================================" ).append("\n"); 
		query.append("        SELECT  XX.*" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                --==================================================================================================" ).append("\n"); 
		query.append("                SELECT  X.VSL_CD" ).append("\n"); 
		query.append("                      , X.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , X.SKD_DIR_CD" ).append("\n"); 
		query.append("                      , X.VPS_PORT_CD" ).append("\n"); 
		query.append("                      , X.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                      , X.CLPT_SEQ" ).append("\n"); 
		query.append("                      , X.VPS_ETA_DT        AS FIRST_VPS_ETA_DT" ).append("\n"); 
		query.append("                      , LAG(X.VSL_CD)       OVER (PARTITION BY X.VSL_CD ORDER BY X.VPS_ETB_DT  ASC) PRE_VSL_CD" ).append("\n"); 
		query.append("                      , LAG(X.SKD_VOY_NO)   OVER (PARTITION BY X.VSL_CD ORDER BY X.VPS_ETB_DT  ASC) PRE_SKD_VOY_NO" ).append("\n"); 
		query.append("                      , LAG(X.SKD_DIR_CD)   OVER (PARTITION BY X.VSL_CD ORDER BY X.VPS_ETB_DT  ASC) PRE_SKD_DIR_CD" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                FROM    VSK_VSL_PORT_SKD            X" ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                AND     X.VSL_CD                    = @[vsl_cd]" ).append("\n"); 
		query.append("                AND     X.TURN_PORT_IND_CD          IN ('Y','N')" ).append("\n"); 
		query.append("                AND     NVL(X.SKD_CNG_STS_CD,'*')   <> 'S'" ).append("\n"); 
		query.append("                AND     X.CLPT_SEQ                  = (SELECT   MIN(PS.CLPT_SEQ)" ).append("\n"); 
		query.append("                                                       FROM     VSK_VSL_PORT_SKD            PS" ).append("\n"); 
		query.append("                                                       WHERE    PS.VSL_CD                   = X.VSL_CD" ).append("\n"); 
		query.append("                                                       AND      PS.SKD_VOY_NO               = X.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                       AND      PS.SKD_DIR_CD               = X.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                       AND      X.TURN_PORT_IND_CD          IN ('Y','N')" ).append("\n"); 
		query.append("                                                       AND      NVL(X.SKD_CNG_STS_CD,'*')   <> 'S'" ).append("\n"); 
		query.append("                                                       )    " ).append("\n"); 
		query.append("                --==================================================================================================              " ).append("\n"); 
		query.append("                ) XX" ).append("\n"); 
		query.append("                , VSK_VSL_PSN_PLNG_DTL PS" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     PS.RCV_DT           = @[rcv_dt]" ).append("\n"); 
		query.append("        AND     PS.DLY_RCV_SEQ      = @[dly_rcv_seq]" ).append("\n"); 
		query.append("        AND     PS.IF_RCV_SEQ       = @[if_rcv_seq]" ).append("\n"); 
		query.append("        AND     NVL(GLOBALDATE_PKG.TIME_CONV_FNC(XX.VPS_PORT_CD, XX.FIRST_VPS_ETA_DT, 'GBFXT'),XX.FIRST_VPS_ETA_DT) < TO_DATE(@[plng_gen_gdt],'YYYYMMDDHH24MISS')                                 " ).append("\n"); 
		query.append("        ORDER BY XX.FIRST_VPS_ETA_DT                DESC      " ).append("\n"); 
		query.append("        --==================================================================================================" ).append("\n"); 
		query.append("        ) YY" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     ROWNUM  = 1" ).append("\n"); 

	}
}