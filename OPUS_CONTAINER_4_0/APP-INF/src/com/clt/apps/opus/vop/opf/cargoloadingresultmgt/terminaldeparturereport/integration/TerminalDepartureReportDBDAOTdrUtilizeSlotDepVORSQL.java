/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrUtilizeSlotDepVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.02 
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

public class TerminalDepartureReportDBDAOTdrUtilizeSlotDepVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrUtilizeSlotDepVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sl_status1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sl_status2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTdrUtilizeSlotDepVORSQL").append("\n"); 
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
		query.append("SELECT		X.OPR_CD," ).append("\n"); 
		query.append("			------------------" ).append("\n"); 
		query.append("			-- Trade " ).append("\n"); 
		query.append("			------------------" ).append("\n"); 
		query.append("			TRADE_FULL," ).append("\n"); 
		query.append("			TRADE_MT," ).append("\n"); 
		query.append("			TRADE_AB," ).append("\n"); 
		query.append("			(NVL(TRADE_FULL, 0) + NVL(TRADE_MT, 0) + NVL(TRADE_AB, 0)) AS TRADE_SUB_SLOT," ).append("\n"); 
		query.append("			(NVL(TRADE_FULL_W, 0) + NVL(TRADE_MT_W, 0) + NVL(TRADE_AB_W, 0)) AS TRADE_SUB_WGT," ).append("\n"); 
		query.append("			------------------" ).append("\n"); 
		query.append("			-- Inter" ).append("\n"); 
		query.append("			------------------" ).append("\n"); 
		query.append("			INTER_FULL," ).append("\n"); 
		query.append("			INTER_MT," ).append("\n"); 
		query.append("			INTER_AB," ).append("\n"); 
		query.append("			(NVL(INTER_FULL, 0) + NVL(INTER_MT, 0) + NVL(INTER_AB, 0)) AS INTER_SUB_SLOT," ).append("\n"); 
		query.append("			(NVL(INTER_FULL_W, 0) + NVL(INTER_MT_W, 0) + NVL(INTER_AB_W, 0)) AS INTER_SUB_WGT," ).append("\n"); 
		query.append("			------------------" ).append("\n"); 
		query.append("			-- Grand TTL" ).append("\n"); 
		query.append("			------------------" ).append("\n"); 
		query.append("			(NVL(TRADE_FULL, 0) + NVL(TRADE_MT, 0) + NVL(TRADE_AB, 0))  + " ).append("\n"); 
		query.append("			(NVL(INTER_FULL, 0) + NVL(INTER_MT, 0) + NVL(INTER_AB, 0))" ).append("\n"); 
		query.append("			AS GRAND_TTL_SLOT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			(NVL(TRADE_FULL_W, 0) + NVL(TRADE_MT_W, 0) + NVL(TRADE_AB_W, 0))  + " ).append("\n"); 
		query.append("			(NVL(INTER_FULL_W, 0) + NVL(INTER_MT_W, 0) + NVL(INTER_AB_W, 0))" ).append("\n"); 
		query.append("			AS GRAND_TTL_WGT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT  C.OPR_CD," ).append("\n"); 
		query.append("	        SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'A', 0, C.QTY), 0),0))     TRADE_FULL," ).append("\n"); 
		query.append("	        SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_TYPE, 'E', DECODE(C.CNTR_SIZE, 'A', 0, C.QTY), 0),0))     TRADE_MT," ).append("\n"); 
		query.append("	        SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_SIZE, 'A', C.QTY, 0),0))                                	TRADE_AB," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	        SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'A', 0, C.WEIGHT), 0),0))  TRADE_FULL_W," ).append("\n"); 
		query.append("	        SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_TYPE, 'E', DECODE(C.CNTR_SIZE, 'A', 0, C.WEIGHT), 0),0))  TRADE_MT_W," ).append("\n"); 
		query.append("	        SUM(DECODE(C.STATUS, @[sl_status1], DECODE(C.CNTR_SIZE, 'A', C.WEIGHT, 0),0))                               TRADE_AB_W," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	        SUM(DECODE(C.STATUS, @[sl_status2], DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'A', 0, C.QTY), 0), 0))    INTER_FULL," ).append("\n"); 
		query.append("	        SUM(DECODE(C.STATUS, @[sl_status2], DECODE(C.CNTR_TYPE, 'E', DECODE(C.CNTR_SIZE, 'A', 0, C.QTY), 0), 0))    INTER_MT," ).append("\n"); 
		query.append("	        SUM(DECODE(C.STATUS, @[sl_status2], DECODE(C.CNTR_SIZE, 'A', C.QTY, 0),0))                                	INTER_AB," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	        SUM(DECODE(C.STATUS, @[sl_status2], DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'A', 0, C.WEIGHT), 0), 0)) INTER_FULL_W," ).append("\n"); 
		query.append("	        SUM(DECODE(C.STATUS, @[sl_status2], DECODE(C.CNTR_TYPE, 'E', DECODE(C.CNTR_SIZE, 'A', 0, C.WEIGHT), 0), 0)) INTER_MT_W," ).append("\n"); 
		query.append("	        SUM(DECODE(C.STATUS, @[sl_status2], DECODE(C.CNTR_SIZE, 'A', C.WEIGHT, 0),0))                               INTER_AB_W" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_UTILIZE C" ).append("\n"); 
		query.append("	WHERE  V.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("	AND    V.SKD_VOY_NO   = @[voy_no]" ).append("\n"); 
		query.append("	AND    V.SKD_DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("	AND	   V.YD_CD		  = @[yd_cd]" ).append("\n"); 
		query.append("    AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("	AND    V.VSL_CD       = H.VSL_CD" ).append("\n"); 
		query.append("	AND    V.SKD_VOY_NO   = H.VOY_NO" ).append("\n"); 
		query.append("	AND    V.SKD_DIR_CD   = H.DIR_CD" ).append("\n"); 
		query.append("	AND    V.VPS_PORT_CD  = H.PORT_CD" ).append("\n"); 
		query.append("	AND    V.CLPT_IND_SEQ = H.CALL_IND" ).append("\n"); 
		query.append("	AND    H.VSL_CD       = C.VSL_CD" ).append("\n"); 
		query.append("	AND    H.VOY_NO       = C.VOY_NO" ).append("\n"); 
		query.append("	AND    H.DIR_CD       = C.DIR_CD" ).append("\n"); 
		query.append("	AND    H.PORT_CD      = C.PORT_CD" ).append("\n"); 
		query.append("	AND    H.CALL_IND     = C.CALL_IND" ).append("\n"); 
		query.append("	AND	   C.STATUS		  IN (@[sl_status1], @[sl_status2])" ).append("\n"); 
		query.append("	GROUP BY C.OPR_CD" ).append("\n"); 
		query.append(")X" ).append("\n"); 
		query.append("ORDER BY X.OPR_CD" ).append("\n"); 

	}
}