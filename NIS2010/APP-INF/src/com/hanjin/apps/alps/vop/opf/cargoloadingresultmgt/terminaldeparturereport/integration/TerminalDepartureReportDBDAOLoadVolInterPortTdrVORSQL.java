/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOLoadVolInterPortTdrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.21
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.21 
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

public class TerminalDepartureReportDBDAOLoadVolInterPortTdrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TDR Creation - Load Vol. Tab. - Inter Port Query
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOLoadVolInterPortTdrVORSQL(){
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
		params.put("status1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("status2",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOLoadVolInterPortTdrVORSQL").append("\n"); 
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
		query.append("SELECT  XX.OPR_CD" ).append("\n"); 
		query.append("  , XX.POD_CD" ).append("\n"); 
		query.append("  , DECODE(NVL(XX.FULL_BO_20,0) + NVL(XX.FULL_TS_20,0), 0, NULL, NVL(XX.FULL_BO_20,0) + NVL(XX.FULL_TS_20,0))  AS FULL_BO_20" ).append("\n"); 
		query.append("  , DECODE(NVL(XX.FULL_BO_2H,0) + NVL(XX.FULL_TS_2H,0), 0, NULL, NVL(XX.FULL_BO_2H,0) + NVL(XX.FULL_TS_2H,0))  AS FULL_BO_2H" ).append("\n"); 
		query.append("  , DECODE(NVL(XX.FULL_BO_40,0) + NVL(XX.FULL_TS_40,0), 0, NULL, NVL(XX.FULL_BO_40,0) + NVL(XX.FULL_TS_40,0))  AS FULL_BO_40" ).append("\n"); 
		query.append("  , DECODE(NVL(XX.FULL_BO_4H,0) + NVL(XX.FULL_TS_4H,0), 0, NULL, NVL(XX.FULL_BO_4H,0) + NVL(XX.FULL_TS_4H,0))  AS FULL_BO_4H" ).append("\n"); 
		query.append("  , DECODE(NVL(XX.FULL_BO_45,0) + NVL(XX.FULL_TS_45,0), 0, NULL, NVL(XX.FULL_BO_45,0) + NVL(XX.FULL_TS_45,0))  AS FULL_BO_45" ).append("\n"); 
		query.append("  , DECODE(NVL(XX.FULL_BO_DX,0) + NVL(XX.FULL_TS_DX,0), 0, NULL, NVL(XX.FULL_BO_DX,0) + NVL(XX.FULL_TS_DX,0))  AS FULL_BO_DX" ).append("\n"); 
		query.append("  --, XX.FULL_TS_20" ).append("\n"); 
		query.append("  --, XX.FULL_TS_2H" ).append("\n"); 
		query.append("  --, XX.FULL_TS_40" ).append("\n"); 
		query.append("  --, XX.FULL_TS_4H" ).append("\n"); 
		query.append("  --, XX.FULL_TS_45" ).append("\n"); 
		query.append("  , DECODE(NVL(XX.ET_BO_20,0) + NVL(XX.ET_TS_20,0), 0, NULL, NVL(XX.ET_BO_20,0) + NVL(XX.ET_TS_20,0)) AS ET_BO_20" ).append("\n"); 
		query.append("  , DECODE(NVL(XX.ET_BO_2H,0) + NVL(XX.ET_TS_2H,0), 0, NULL, NVL(XX.ET_BO_2H,0) + NVL(XX.ET_TS_2H,0)) AS ET_BO_2H" ).append("\n"); 
		query.append("  , DECODE(NVL(XX.ET_BO_40,0) + NVL(XX.ET_TS_40,0), 0, NULL, NVL(XX.ET_BO_40,0) + NVL(XX.ET_TS_40,0)) AS ET_BO_40" ).append("\n"); 
		query.append("  , DECODE(NVL(XX.ET_BO_4H,0) + NVL(XX.ET_TS_4H,0), 0, NULL, NVL(XX.ET_BO_4H,0) + NVL(XX.ET_TS_4H,0)) AS ET_BO_4H" ).append("\n"); 
		query.append("  , DECODE(NVL(XX.ET_BO_45,0) + NVL(XX.ET_TS_45,0), 0, NULL, NVL(XX.ET_BO_45,0) + NVL(XX.ET_TS_45,0)) AS ET_BO_45" ).append("\n"); 
		query.append("  , DECODE(NVL(XX.ET_BO_DX,0) + NVL(XX.ET_TS_DX,0), 0, NULL, NVL(XX.ET_BO_DX,0) + NVL(XX.ET_TS_DX,0)) AS ET_BO_DX" ).append("\n"); 
		query.append("  --, XX.ET_TS_20" ).append("\n"); 
		query.append("  --, XX.ET_TS_2H" ).append("\n"); 
		query.append("  --, XX.ET_TS_40" ).append("\n"); 
		query.append("  --, XX.ET_TS_4H" ).append("\n"); 
		query.append("  --, XX.ET_TS_45" ).append("\n"); 
		query.append("  , XX.WT_20" ).append("\n"); 
		query.append("  , XX.WT_2H" ).append("\n"); 
		query.append("  , XX.WT_40" ).append("\n"); 
		query.append("  , XX.WT_4H" ).append("\n"); 
		query.append("  , XX.WT_45" ).append("\n"); 
		query.append("  , XX.WT_DX" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT OPR_CD," ).append("\n"); 
		query.append("       POD_ISO AS POD_CD," ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_20, " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_2H, " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_40, " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_4H, " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_45, " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, 'X', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_BO_DX," ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status2], DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_20,  " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status2], DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_2H,  " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status2], DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_40,  " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status2], DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_4H,  " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status2], DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_45,  " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status2], DECODE(CNTR_SIZE, 'X', DECODE(CNTR_TYPE, 'F', DECODE(QTY, 0, NULL, QTY), 'R', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))      				FULL_TS_DX," ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_20,   " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_2H,   " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_40,   " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_4H,   " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_45,   " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, 'X', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_BO_DX," ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status2], DECODE(CNTR_SIZE, '2', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_20,    " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status2], DECODE(CNTR_SIZE, '3', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_2H,    " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status2], DECODE(CNTR_SIZE, '4', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_40,    " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status2], DECODE(CNTR_SIZE, 'H', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_4H,    " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status2], DECODE(CNTR_SIZE, 'L', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_45,    " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status2], DECODE(CNTR_SIZE, 'X', DECODE(CNTR_TYPE, 'E', DECODE(QTY, 0, NULL, QTY), NULL), NULL), NULL))                										ET_TS_DX, " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, '2', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), @[status2], DECODE(CNTR_SIZE, '2', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), NULL)) 	WT_20,       " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, '3', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), @[status2], DECODE(CNTR_SIZE, '3', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), NULL)) 	WT_2H,       " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, '4', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), @[status2], DECODE(CNTR_SIZE, '4', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), NULL)) 	WT_40,       " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, 'H', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), @[status2], DECODE(CNTR_SIZE, 'H', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), NULL)) 	WT_4H,       " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, 'L', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), @[status2], DECODE(CNTR_SIZE, 'L', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), NULL)) 	WT_45,       " ).append("\n"); 
		query.append("       SUM(DECODE(STATUS, @[status1], DECODE(CNTR_SIZE, 'X', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), @[status2], DECODE(CNTR_SIZE, 'L', DECODE(WEIGHT, 0, NULL, WEIGHT), NULL), NULL)) 	WT_DX " ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V, TDR_HEADER H, TDR_SUMMARY S " ).append("\n"); 
		query.append("WHERE  V.VSL_CD  		= @[vsl_cd] " ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO  	= @[voy_no] " ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD  	= @[dir_cd] " ).append("\n"); 
		query.append("AND    V.YD_CD 			= @[yd_cd] " ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    S.STATUS IN (@[status1], @[status2])" ).append("\n"); 
		query.append("#if (${sys_create} != 'Externally Produced')" ).append("\n"); 
		query.append("AND    S.CNTR_TYPE NOT IN ('D', 'R', 'A')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    V.VSL_CD       	= H.VSL_CD " ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO   	= H.VOY_NO " ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD   	= H.DIR_CD " ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD  	= H.PORT_CD " ).append("\n"); 
		query.append("AND    V.CLPT_IND_SEQ 	= H.CALL_IND " ).append("\n"); 
		query.append("AND    H.VSL_CD       	= S.VSL_CD " ).append("\n"); 
		query.append("AND    H.VOY_NO       	= S.VOY_NO " ).append("\n"); 
		query.append("AND    H.DIR_CD       	= S.DIR_CD " ).append("\n"); 
		query.append("AND    H.PORT_CD      	= S.PORT_CD " ).append("\n"); 
		query.append("AND    H.CALL_IND     	= S.CALL_IND " ).append("\n"); 
		query.append("GROUP BY OPR_CD,  POD_ISO" ).append("\n"); 
		query.append("ORDER BY OPR_CD,  POD_ISO ) XX" ).append("\n"); 

	}
}