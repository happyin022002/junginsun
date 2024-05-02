/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TerminalDepartureReportDBDAODischVolTotalTdrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.20
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAODischVolTotalTdrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ssss
	  * </pre>
	  */
	public TerminalDepartureReportDBDAODischVolTotalTdrVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAODischVolTotalTdrVORSQL").append("\n"); 
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
		query.append("SELECT S.OPR_CD," ).append("\n"); 
		query.append("	   @[port_cd] as POD_CD," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, '2', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_BO_20," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, '3', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_BO_2H," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, '4', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_BO_40," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, 'H', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_BO_4H," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, 'L', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_BO_45," ).append("\n"); 
		query.append("	   SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, 'X', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_BO_DX," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, '2', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_TS_20," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, '3', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_TS_2H," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, '4', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_TS_40," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, 'H', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_TS_4H," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, 'L', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_TS_45," ).append("\n"); 
		query.append("	   SUM(DECODE(S.CNTR_TYPE, 'E', NULL, DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, 'X', DECODE(QTY,0, NULL, QTY), NULL), NULL))) FULL_TS_DX," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, '2', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_BO_20," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, '3', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_BO_2H," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, '4', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_BO_40," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, 'H', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_BO_4H," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, 'L', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_BO_45," ).append("\n"); 
		query.append("	   SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DS', DECODE(S.CNTR_SIZE, 'X', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_BO_DX," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, '2', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_TS_20," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, '3', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_TS_2H," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, '4', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_TS_40," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, 'H', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_TS_4H," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, 'L', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_TS_45," ).append("\n"); 
		query.append("	   SUM(DECODE(S.CNTR_TYPE, 'E', DECODE(S.STATUS, 'DT', DECODE(S.CNTR_SIZE, 'X', DECODE(QTY,0, NULL, QTY), NULL), NULL), NULL)) ET_TS_DX," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_SIZE, '2', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL)) WT_20," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_SIZE, '3', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL)) WT_2H," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_SIZE, '4', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL)) WT_40," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_SIZE, 'H', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL)) WT_4H," ).append("\n"); 
		query.append("       SUM(DECODE(S.CNTR_SIZE, 'L', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL)) WT_45," ).append("\n"); 
		query.append("	   SUM(DECODE(S.CNTR_SIZE, 'X', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL)) WT_DX" ).append("\n"); 
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
		query.append("#if (${sys_create} != 'Externally Produced')" ).append("\n"); 
		query.append("AND	   S.CNTR_TYPE NOT IN ('D', 'R', 'A')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY S.OPR_CD" ).append("\n"); 
		query.append("ORDER BY S.OPR_CD, POD_CD" ).append("\n"); 

	}
}