/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOsearchTotMoveDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.15 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOsearchTotMoveDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOsearchTotMoveDataRSQL(){
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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOsearchTotMoveDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(" ).append("\n"); 
		query.append("SUM( NVL( FULL_BO_20, 0) )+-- FULL_BO_20" ).append("\n"); 
		query.append("SUM( NVL( FULL_BO_2H, 0) )+-- FULL_BO_2H" ).append("\n"); 
		query.append("SUM( NVL( FULL_BO_40, 0) )+-- FULL_BO_40" ).append("\n"); 
		query.append("SUM( NVL( FULL_BO_4H, 0) )+-- FULL_BO_4H" ).append("\n"); 
		query.append("SUM( NVL( FULL_BO_45, 0) )+-- FULL_BO_45" ).append("\n"); 
		query.append("SUM( NVL( FULL_TS_20, 0) )+-- FULL_TS_20" ).append("\n"); 
		query.append("SUM( NVL( FULL_TS_2H, 0) )+-- FULL_TS_2H" ).append("\n"); 
		query.append("SUM( NVL( FULL_TS_40, 0) )+-- FULL_TS_40" ).append("\n"); 
		query.append("SUM( NVL( FULL_TS_4H, 0) )+-- FULL_TS_4H" ).append("\n"); 
		query.append("SUM( NVL( FULL_TS_45, 0) )+-- FULL_TS_45" ).append("\n"); 
		query.append("SUM( NVL( ET_BO_20  , 0) )+--   ET_BO_20" ).append("\n"); 
		query.append("SUM( NVL( ET_BO_2H  , 0) )+--   ET_BO_2H" ).append("\n"); 
		query.append("SUM( NVL( ET_BO_40  , 0) )+--   ET_BO_40" ).append("\n"); 
		query.append("SUM( NVL( ET_BO_4H  , 0) )+--   ET_BO_4H" ).append("\n"); 
		query.append("SUM( NVL( ET_BO_45  , 0) )+--   ET_BO_45" ).append("\n"); 
		query.append("SUM( NVL( ET_TS_20  , 0) )+--   ET_TS_20" ).append("\n"); 
		query.append("SUM( NVL( ET_TS_2H  , 0) )+--   ET_TS_2H" ).append("\n"); 
		query.append("SUM( NVL( ET_TS_40  , 0) )+--   ET_TS_40" ).append("\n"); 
		query.append("SUM( NVL( ET_TS_4H  , 0) )+--   ET_TS_4H" ).append("\n"); 
		query.append("SUM( NVL( ET_TS_45  , 0) )+" ).append("\n"); 
		query.append("MAX(RH_MISHAND.RH_MISHAND_CNT), 0)   TOT_MVS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, '2', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_BO_20," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, '3', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_BO_2H," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, '4', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_BO_40," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, 'H', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_BO_4H," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, 'L', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_BO_45," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, '2', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_TS_20," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, '3', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_TS_2H," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, '4', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_TS_40," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, 'H', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_TS_4H," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, 'L', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_TS_45," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, '2', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_BO_20," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, '3', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_BO_2H," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, '4', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_BO_40," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, 'H', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_BO_4H," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, 'L', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_BO_45," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, '2', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_TS_20," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, '3', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_TS_2H," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, '4', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_TS_40," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, 'H', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_TS_4H," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, 'L', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_TS_45" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_SUMMARY S" ).append("\n"); 
		query.append("WHERE  V.VSL_CD  		= @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO  	= @[voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD  	= @[dir_cd]" ).append("\n"); 
		query.append("AND    V.YD_CD 			= @[yd_cd]" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    V.VSL_CD       	= H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   	= H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   	= H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD  	= H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ 	= H.CALL_IND" ).append("\n"); 
		query.append("AND    H.VSL_CD       	= S.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO       	= S.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD       	= S.DIR_CD" ).append("\n"); 
		query.append("AND    H.PORT_CD      	= S.PORT_CD" ).append("\n"); 
		query.append("AND    H.CALL_IND     	= S.CALL_IND" ).append("\n"); 
		query.append("AND    S.STATUS   IN ('DS','DT')" ).append("\n"); 
		query.append("AND	   S.CNTR_TYPE NOT IN ('D', 'R', 'A')" ).append("\n"); 
		query.append("GROUP BY S.OPR_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_20," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_2H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_40," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_4H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_45," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_20," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_2H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_40," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_4H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_45," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_20," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_2H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_40," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_4H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LM', DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_45," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_20," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_2H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_40," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_4H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'OT', DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_45" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_SUMMARY S" ).append("\n"); 
		query.append("WHERE  V.VSL_CD  		= @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO  	= @[voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD  	= @[dir_cd]" ).append("\n"); 
		query.append("AND    V.YD_CD 			= @[yd_cd]" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    S.STATUS IN ('LM', 'OT')" ).append("\n"); 
		query.append("AND    S.CNTR_TYPE NOT IN ('D', 'R', 'A')" ).append("\n"); 
		query.append("AND    V.VSL_CD       	= H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   	= H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   	= H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD  	= H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ 	= H.CALL_IND" ).append("\n"); 
		query.append("AND    H.VSL_CD       	= S.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO       	= S.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD       	= S.DIR_CD" ).append("\n"); 
		query.append("AND    H.PORT_CD      	= S.PORT_CD" ).append("\n"); 
		query.append("AND    H.CALL_IND     	= S.CALL_IND" ).append("\n"); 
		query.append("GROUP BY OPR_CD,  POD_ISO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_20," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_2H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_40," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_4H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_45," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_20," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_2H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_40," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_4H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_45," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_20," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_2H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_40," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_4H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LI', DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_45," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_20," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_2H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_40," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_4H," ).append("\n"); 
		query.append("SUM(DECODE(STATUS, 'LT', DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_45" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_SUMMARY S" ).append("\n"); 
		query.append("WHERE  V.VSL_CD  		= @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO  	= @[voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD  	= @[dir_cd]" ).append("\n"); 
		query.append("AND    V.YD_CD 			= @[yd_cd]" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    S.STATUS IN ('LI', 'LT')" ).append("\n"); 
		query.append("AND    S.CNTR_TYPE NOT IN ('D', 'R', 'A')" ).append("\n"); 
		query.append("AND    V.VSL_CD       	= H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   	= H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   	= H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD  	= H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ 	= H.CALL_IND" ).append("\n"); 
		query.append("AND    H.VSL_CD       	= S.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO       	= S.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD       	= S.DIR_CD" ).append("\n"); 
		query.append("AND    H.PORT_CD      	= S.PORT_CD" ).append("\n"); 
		query.append("AND    H.CALL_IND     	= S.CALL_IND" ).append("\n"); 
		query.append("GROUP BY OPR_CD,  POD_ISO" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("SUM(RH_MISHAND_SUB_SUM.CNT) RH_MISHAND_CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(/*MISHANDLE*/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("COUNT(*) CNT" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_CNTR_DETAIL C" ).append("\n"); 
		query.append("WHERE  V.VSL_CD  		= @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO  	= @[voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD  	= @[dir_cd]" ).append("\n"); 
		query.append("AND    V.YD_CD 			= @[yd_cd]" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    V.VSL_CD       	= H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   	= H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   	= H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD  	= H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ 	= H.CALL_IND" ).append("\n"); 
		query.append("AND    H.VSL_CD       	= C.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO       	= C.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD       	= C.DIR_CD" ).append("\n"); 
		query.append("AND    H.PORT_CD      	= C.PORT_CD" ).append("\n"); 
		query.append("AND    H.CALL_IND     	= C.CALL_IND" ).append("\n"); 
		query.append("AND    C.STATUS        	= 'MI'" ).append("\n"); 
		query.append("AND    C.MISHANDLE_CHK  IN ( 'SD', 'OD','SL','OL')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT /* R/H  */" ).append("\n"); 
		query.append("NVL( SUM( DECODE(C.SHIFT_TYPE, 'Q', 2, 1 )  ), 0) CNT" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_CNTR_DETAIL C" ).append("\n"); 
		query.append("WHERE  V.VSL_CD  		= @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO  	= @[voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD  	= @[dir_cd]" ).append("\n"); 
		query.append("AND    V.YD_CD 			= @[yd_cd]" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    V.VSL_CD       	= H.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   	= H.VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   	= H.DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD  	= H.PORT_CD" ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ 	= H.CALL_IND" ).append("\n"); 
		query.append("AND    H.VSL_CD       	= C.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO       	= C.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD       	= C.DIR_CD" ).append("\n"); 
		query.append("AND    H.PORT_CD      	= C.PORT_CD" ).append("\n"); 
		query.append("AND    H.CALL_IND     	= C.CALL_IND" ).append("\n"); 
		query.append("AND    C.STATUS         = 'ST'" ).append("\n"); 
		query.append("AND    TRIM(C.PRECELL) IS NOT NULL" ).append("\n"); 
		query.append(") RH_MISHAND_SUB_SUM" ).append("\n"); 
		query.append(")RH_MISHAND" ).append("\n"); 

	}
}