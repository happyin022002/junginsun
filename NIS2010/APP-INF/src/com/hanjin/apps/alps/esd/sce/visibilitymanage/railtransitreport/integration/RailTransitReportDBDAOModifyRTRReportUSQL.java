/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailTransitReportDBDAOModifyRTRReportUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailTransitReportDBDAOModifyRTRReportUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyRTRReport
	  * </pre>
	  */
	public RailTransitReportDBDAOModifyRTRReportUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_dwll_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_gate_in_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration").append("\n"); 
		query.append("FileName : RailTransitReportDBDAOModifyRTRReportUSQL").append("\n"); 
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
		query.append("UPDATE SCE_RAIL_TZ_RPT              " ).append("\n"); 
		query.append("SET    ORG_GATE_IN_DT = TO_DATE(@[org_gate_in_date],'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("	   ,TML_DEP_FLG = " ).append("\n"); 
		query.append("			DECODE(@[org_gate_in_date],   " ).append("\n"); 
		query.append("	     	     NULL,   " ).append("\n"); 
		query.append("	     	     DECODE(ORG_GATE_OUT_DT,   " ).append("\n"); 
		query.append("	     		    NULL,  " ).append("\n"); 
		query.append("	     		    DECODE(ITCHG_GATE_IN_DT,  " ).append("\n"); 
		query.append("	     			   NULL,  " ).append("\n"); 
		query.append("	     			   DECODE(ITCHG_DT,  " ).append("\n"); 
		query.append("	     				  NULL,   " ).append("\n"); 
		query.append("	     				  DECODE(ITCHG_GATE_OUT_DT,  " ).append("\n"); 
		query.append("	     					 NULL,  " ).append("\n"); 
		query.append("	     					 DECODE(DEST_GATE_IN_DT,  " ).append("\n"); 
		query.append("	     						NULL,  " ).append("\n"); 
		query.append("	     						DECODE(DEST_AVAL_DT,  " ).append("\n"); 
		query.append("	     						       NULL,  " ).append("\n"); 
		query.append("	     						       DECODE(DEST_GATE_OUT_DT,  " ).append("\n"); 
		query.append("	     							      NULL, 'N', 'Y'),   " ).append("\n"); 
		query.append("	     						       'Y'),   " ).append("\n"); 
		query.append("	     						'Y'),   " ).append("\n"); 
		query.append("	     					 'Y'),   " ).append("\n"); 
		query.append("	     				  'Y'),  " ).append("\n"); 
		query.append("	     			   'Y'),  " ).append("\n"); 
		query.append("	     		    'Y'),  " ).append("\n"); 
		query.append("	     	     'Y')" ).append("\n"); 
		query.append(" 		,TML_DWLL_TM_HRS=" ).append("\n"); 
		query.append("                    DECODE(VD_DT,      " ).append("\n"); 
		query.append("    	     		 NULL, 0,     " ).append("\n"); 
		query.append("    	     		 DECODE(TRSP_BND_CD,    " ).append("\n"); 
		query.append("    	     		 'I', DECODE(@[org_gate_in_date], NULL, TRUNC((SYSDATE - VD_DT)*24) ,     " ).append("\n"); 
		query.append("    	     							   TRUNC((TO_DATE(@[org_gate_in_date],'YYYY-MM-DD HH24:MI') - VD_DT)*24))    " ).append("\n"); 
		query.append("    	     		,'O', 0))" ).append("\n"); 
		query.append("		,RAIL_RUN_TM_HRS=" ).append("\n"); 
		query.append("    	       	 DECODE(TRSP_BND_CD,  " ).append("\n"); 
		query.append("	     	        'O',   " ).append("\n"); 
		query.append("	     	     	DECODE(FLOOR((( DEST_GATE_OUT_DT - TO_DATE(@[org_gate_in_date],'YYYY-MM-DD HH24:MI') )*24)),  " ).append("\n"); 
		query.append("	     		    		NULL, '',  " ).append("\n"); 
		query.append("	     		    		0, '',   " ).append("\n"); 
		query.append("	     		    		FLOOR(((DEST_GATE_OUT_DT - TO_DATE(@[org_gate_in_date],'YYYY-MM-DD HH24:MI') )*24))" ).append("\n"); 
		query.append("					),  " ).append("\n"); 
		query.append("	     		    DECODE(FLOOR(((DEST_AVAL_DT - VD_DT)*24)),  -- INBOUND" ).append("\n"); 
		query.append("	     			   	   NULL, '',  " ).append("\n"); 
		query.append("	     			   	   0, '',   " ).append("\n"); 
		query.append("	     			   	   FLOOR(((DEST_AVAL_DT - VD_DT)*24)))" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("		,ORG_DWLL_TM_HRS=" ).append("\n"); 
		query.append("			DECODE( @[org_gate_in_date],  " ).append("\n"); 
		query.append("	     	      NULL, 0,  " ).append("\n"); 
		query.append("	     	      DECODE(ORG_GATE_OUT_DT,  " ).append("\n"); 
		query.append("	     		     NULL,  " ).append("\n"); 
		query.append("	     		     TRUNC((SYSDATE - TO_DATE(@[org_gate_in_date],'YYYY-MM-DD HH24:MI'))*24),  " ).append("\n"); 
		query.append("	     		     TRUNC((ORG_GATE_OUT_DT - TO_DATE(@[org_gate_in_date],'YYYY-MM-DD HH24:MI'))*24))) " ).append("\n"); 
		query.append("		,ORG_GATE_IN_UPD_FLG='N'" ).append("\n"); 
		query.append("#if(${crnt_dwll_rmk} != '')" ).append("\n"); 
		query.append("		,CRNT_DWLL_RMK = @[crnt_dwll_rmk]" ).append("\n"); 
		query.append("		,CRNT_DWLL_RMK_UPD_DT = SYSDATE" ).append("\n"); 
		query.append("        ,DWLL_RSN_LOC_NM = @[arr_loc_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND    TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 

	}
}