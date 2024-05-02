/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOSearchConfirmed01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2010.04.13 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Prak Kwang Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOSearchConfirmed01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MTY 양하 계획 조정
	  * UI_CIM_1039
	  * MTY COD Confirmation
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOSearchConfirmed01RSQL(){
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
		params.put("lddiv",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("COD_CFM_DIV_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOSearchConfirmed01RSQL").append("\n"); 
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
		query.append("SELECT      ''                  VVD     ," ).append("\n"); 
		query.append("            'Original Load'     POD_CD  ," ).append("\n"); 
		query.append("            'Original Load'     YD_CD   ," ).append("\n"); 
		query.append("            ''                  ETB     ," ).append("\n"); 
		query.append("            D2_QTY||''          D2      ," ).append("\n"); 
		query.append("            D4_QTY||''          D4      ," ).append("\n"); 
		query.append("            D5_QTY||''          D5      ," ).append("\n"); 
		query.append("            D7_QTY||''          D7      ," ).append("\n"); 
		query.append("            R2_QTY||''          R2      ," ).append("\n"); 
		query.append("            R5_QTY||''          R5      ," ).append("\n"); 
		query.append("            O2_QTY||''          O2      ," ).append("\n"); 
		query.append("            S2_QTY||''          S2      ," ).append("\n"); 
		query.append("            O4_QTY||''          O4      ," ).append("\n"); 
		query.append("            S4_QTY||''          S4      ," ).append("\n"); 
		query.append("            F2_QTY||''          F2      ," ).append("\n"); 
		query.append("            A2_QTY||''          A2      ," ).append("\n"); 
		query.append("            F4_QTY||''          F4      ," ).append("\n"); 
		query.append("            A4_QTY||''          A4      ," ).append("\n"); 
		query.append("            F5_QTY||''          F5      " ).append("\n"); 
		query.append("    FROM    " ).append("\n"); 
		query.append("            EQR_MTY_COD_VVD     EV      , " ).append("\n"); 
		query.append("            EQR_MTY_COD_PORT    EP" ).append("\n"); 
		query.append("    WHERE   EV.VSL_CD           =   SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("    AND     EV.SKD_VOY_NO       =   SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("    AND     EV.SKD_DIR_CD       =   SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("    AND     EV.COD_CFM_DIV_CD   =   @[COD_CFM_DIV_CD]" ).append("\n"); 
		query.append("    AND     EV.VSL_CD           =   EP.VSL_CD" ).append("\n"); 
		query.append("    AND     EV.SKD_VOY_NO       =   EP.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND     EV.SKD_DIR_CD       =   EP.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND     EV.COD_CFM_DIV_CD   =   EP.COD_CFM_DIV_CD" ).append("\n"); 
		query.append("	AND     LODG_DCHG_DIV_CD    = 	@[lddiv]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT      ''                  VVD     ," ).append("\n"); 
		query.append("            'Additional Load'   POD_CD  ," ).append("\n"); 
		query.append("            'Additional Load'   YD_CD   ," ).append("\n"); 
		query.append("            ''                  ETB     ," ).append("\n"); 
		query.append("            ''                  D2      ," ).append("\n"); 
		query.append("            ''                  D4      ," ).append("\n"); 
		query.append("            ''                  D5      ," ).append("\n"); 
		query.append("            ''                  D7      ," ).append("\n"); 
		query.append("            ''                  R2      ," ).append("\n"); 
		query.append("            ''                  R5      ," ).append("\n"); 
		query.append("            ''                  O2      ," ).append("\n"); 
		query.append("            ''                  S2      ," ).append("\n"); 
		query.append("            ''                  O4      ," ).append("\n"); 
		query.append("            ''                  S4      ," ).append("\n"); 
		query.append("            ''                  F2      ," ).append("\n"); 
		query.append("            ''                  A2      ," ).append("\n"); 
		query.append("            ''                  F4      ," ).append("\n"); 
		query.append("            ''                  A4      ," ).append("\n"); 
		query.append("            ''                  F5      " ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("            DUAL" ).append("\n"); 

	}
}