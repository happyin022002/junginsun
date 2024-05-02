/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOUpdateClptSeqforVirtualAddCallOnlyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOUpdateClptSeqforVirtualAddCallOnlyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Virtual Add Calling이 포함된 VVD의 CLPT_SEQ 보정
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOUpdateClptSeqforVirtualAddCallOnlyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOUpdateClptSeqforVirtualAddCallOnlyUSQL").append("\n"); 
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
		query.append("MERGE INTO VSK_VSL_PORT_SKD XX" ).append("\n"); 
		query.append("USING      (" ).append("\n"); 
		query.append("			-------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("            SELECT    X.VSL_CD" ).append("\n"); 
		query.append("                   ,  X.SKD_VOY_NO" ).append("\n"); 
		query.append("                   ,  X.SKD_DIR_CD" ).append("\n"); 
		query.append("                   ,  X.VPS_PORT_CD" ).append("\n"); 
		query.append("                   ,  X.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   ,  X.CLPT_SEQ" ).append("\n"); 
		query.append("                   ,  X.VT_ADD_CALL_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   --:2016-07-08:--,  ROW_NUMBER() OVER (ORDER BY DECODE(X.VT_ADD_CALL_FLG,'Y',9,1) ASC, X.CLPT_SEQ ASC)  CORR_CLPT_SEQ" ).append("\n"); 
		query.append("                   ,  ROW_NUMBER() OVER (ORDER BY X.VPS_ETB_DT ASC, X.VPS_ETA_DT ASC, X.VPS_ETD_DT ASC, X.CLPT_SEQ ASC)  CORR_CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            FROM      VSK_VSL_PORT_SKD   X" ).append("\n"); 
		query.append("            WHERE     X.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("            AND       X.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("            AND       X.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("            AND       EXISTS             (SELECT    ''" ).append("\n"); 
		query.append("                                          FROM      VSK_VSL_PORT_SKD    PS" ).append("\n"); 
		query.append("                                          WHERE     PS.VSL_CD           = X.VSL_CD" ).append("\n"); 
		query.append("                                          AND       PS.SKD_VOY_NO       = X.SKD_VOY_NO" ).append("\n"); 
		query.append("                                          AND       PS.SKD_DIR_CD       = X.SKD_DIR_CD" ).append("\n"); 
		query.append("                                          AND       PS.VT_ADD_CALL_FLG  = 'Y'" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("			-------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("            ) YY" ).append("\n"); 
		query.append("ON          (" ).append("\n"); 
		query.append("     XX.VSL_CD        	= YY.VSL_CD" ).append("\n"); 
		query.append(" AND XX.SKD_VOY_NO    	= YY.SKD_VOY_NO" ).append("\n"); 
		query.append(" AND XX.SKD_DIR_CD    	= YY.SKD_DIR_CD" ).append("\n"); 
		query.append(" AND XX.VPS_PORT_CD   	= YY.VPS_PORT_CD" ).append("\n"); 
		query.append(" AND XX.CLPT_IND_SEQ  	= YY.CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" --:2016-07-08:--AND XX.VT_ADD_CALL_FLG	= 'Y'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("            UPDATE    SET" ).append("\n"); 
		query.append("               XX.CLPT_SEQ = YY.CORR_CLPT_SEQ" ).append("\n"); 

	}
}