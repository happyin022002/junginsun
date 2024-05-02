/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrHeaderSkdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.22 
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

public class TerminalDepartureReportDBDAOTdrHeaderSkdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrHeaderSkdVORSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTdrHeaderSkdVORSQL").append("\n"); 
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
		query.append("SELECT		H.VSL_CD" ).append("\n"); 
		query.append("		,	H.VOY_NO" ).append("\n"); 
		query.append("		,	H.DIR_CD" ).append("\n"); 
		query.append("		,	H.PORT_CD" ).append("\n"); 
		query.append("		,	H.CALL_IND" ).append("\n"); 
		query.append("		,	TML_CD" ).append("\n"); 
		query.append("		,	TDR_DATE" ).append("\n"); 
		query.append("		,	TDR_USER" ).append("\n"); 
		query.append("		,	TO_CHAR(COMMENCE, 'YYYYMMDDHH24MI') AS COMMENCE" ).append("\n"); 
		query.append("		,	TO_CHAR(COMPLETE, 'YYYYMMDDHH24MI') AS COMPLETE" ).append("\n"); 
		query.append("		,	GROSS_WORK" ).append("\n"); 
		query.append("		,	NET_WORK" ).append("\n"); 
		query.append("		,	LOSE_HR" ).append("\n"); 
		query.append("		,	GROSS_GANG" ).append("\n"); 
		query.append("		,	NET_GANG" ).append("\n"); 
		query.append("		,	MVS" ).append("\n"); 
		query.append("		,	NET_TML" ).append("\n"); 
		query.append("		,	GROSS_TML" ).append("\n"); 
		query.append("		,	NET_GC" ).append("\n"); 
		query.append("		,	GROSS_GC" ).append("\n"); 
		query.append("		,	REMARK" ).append("\n"); 
		query.append("		,	HATCH" ).append("\n"); 
		query.append("		,	CON" ).append("\n"); 
		query.append("		,	TO_CHAR(PILOT_ARR, 'YYYYMMDDHH24MI') AS PILOT_ARR" ).append("\n"); 
		query.append("		,	TO_CHAR(PILOT_DEP, 'YYYYMMDDHH24MI') AS PILOT_DEP" ).append("\n"); 
		query.append("		,	TO_CHAR(ANCHOR_ARR, 'YYYYMMDDHH24MI') AS ANCHOR_ARR" ).append("\n"); 
		query.append("		,	TO_CHAR(ANCHOR_DEP, 'YYYYMMDDHH24MI') AS ANCHOR_DEP" ).append("\n"); 
		query.append("		,	TO_CHAR(BERTH, 'YYYYMMDDHH24MI') AS BERTH" ).append("\n"); 
		query.append("		,	TO_CHAR(UNBERTH, 'YYYYMMDDHH24MI') AS UNBERTH" ).append("\n"); 
		query.append("		,	DRAFT_FWD_ARR" ).append("\n"); 
		query.append("		,	DRAFT_FWD_DEP" ).append("\n"); 
		query.append("		,	DRAFT_AFT_ARR" ).append("\n"); 
		query.append("		,	DRAFT_AFT_DEP" ).append("\n"); 
		query.append("		,	BALLAST_ARR" ).append("\n"); 
		query.append("		,	BALLAST_DEP" ).append("\n"); 
		query.append("		,	ROB_FO_ARR" ).append("\n"); 
		query.append("		,	ROB_FO_DEP" ).append("\n"); 
		query.append("		,	ROB_DO_ARR" ).append("\n"); 
		query.append("		,	ROB_DO_DEP" ).append("\n"); 
		query.append("		,	ROB_FW_ARR" ).append("\n"); 
		query.append("		,	ROB_FW_DEP" ).append("\n"); 
		query.append("		,	BUNKER_FO_ARR" ).append("\n"); 
		query.append("		,	BUNKER_FO_DEP" ).append("\n"); 
		query.append("		,	BUNKER_DO_ARR" ).append("\n"); 
		query.append("		,	BUNKER_DO_DEP" ).append("\n"); 
		query.append("		,	BUNKER_FW_ARR" ).append("\n"); 
		query.append("		,	BUNKER_FW_DEP" ).append("\n"); 
		query.append("		,	DWT_ARR" ).append("\n"); 
		query.append("		,	DWT_DEP" ).append("\n"); 
		query.append("		,	DISPL_ARR" ).append("\n"); 
		query.append("		,	DISPL_DEP" ).append("\n"); 
		query.append("		,	GM_ARR" ).append("\n"); 
		query.append("		,	GM_DEP" ).append("\n"); 
		query.append("		,	TUG_ARR" ).append("\n"); 
		query.append("		,	TUG_DEP" ).append("\n"); 
		query.append("		,	SULPHUR_FO_ARR" ).append("\n"); 
		query.append("		,	SULPHUR_FO_DEP" ).append("\n"); 
		query.append("		,	SULPHUR_DO_ARR" ).append("\n"); 
		query.append("		,	SULPHUR_DO_DEP" ).append("\n"); 
		query.append("		,	SUPPLY_SULPHUR_FO" ).append("\n"); 
		query.append("		,	SUPPLY_SULPHUR_DO" ).append("\n"); 
		query.append("		,	TO_CHAR(ETA, 'YYYYMMDDHH24MI') AS ETA" ).append("\n"); 
		query.append("		,	TO_CHAR(ETA_CANAL, 'YYYYMMDDHH24MI') AS ETA_CANAL" ).append("\n"); 
		query.append("		,	INFO" ).append("\n"); 
		query.append("		,	UPDATE_USER" ).append("\n"); 
		query.append("		,	UPDATE_TIME" ).append("\n"); 
		query.append("        , 	NEXT_PORT" ).append("\n"); 
		query.append("        ,   NEXT_CANAL" ).append("\n"); 
		query.append("       ,   (   SELECT	CASE WHEN NVL(COUNT(VSL_CD), 0) > 0 THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("        		FROM	OPF_TML_DEP_RPT_DTL" ).append("\n"); 
		query.append("            	WHERE   VSL_CD      	=	V.VSL_CD      	  " ).append("\n"); 
		query.append("            	AND     SKD_VOY_NO      =	V.SKD_VOY_NO      " ).append("\n"); 
		query.append("            	AND     SKD_DIR_CD      =	V.SKD_DIR_CD      " ).append("\n"); 
		query.append("            	AND     CLPT_CD         =	V.VPS_PORT_CD         " ).append("\n"); 
		query.append("            	AND     CLPT_IND_SEQ    =	V.CLPT_IND_SEQ    " ).append("\n"); 
		query.append("         	)  AS EXISTS_TML_DEP_RPT_DTL" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD 	V" ).append("\n"); 
		query.append("	 , 	TDR_HEADER 			H" ).append("\n"); 
		query.append("WHERE	V.VSL_CD       		= H.VSL_CD  " ).append("\n"); 
		query.append("AND     V.SKD_VOY_NO   		= H.VOY_NO  " ).append("\n"); 
		query.append("AND     V.SKD_DIR_CD   		= H.DIR_CD  " ).append("\n"); 
		query.append("AND     V.VPS_PORT_CD  		= H.PORT_CD " ).append("\n"); 
		query.append("AND     V.CLPT_IND_SEQ 		= H.CALL_IND" ).append("\n"); 
		query.append("AND     V.VSL_CD       		= @[vsl_cd]" ).append("\n"); 
		query.append("AND		V.SKD_VOY_NO   		= @[voy_no]" ).append("\n"); 
		query.append("AND		V.SKD_DIR_CD   		= @[dir_cd]" ).append("\n"); 
		query.append("AND		V.YD_CD        		= @[yd_cd]" ).append("\n"); 
		query.append("AND     V.CLPT_IND_SEQ 		= @[clpt_ind_seq]" ).append("\n"); 

	}
}