/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOSearchMTYREPOByPeriodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.01
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.04.01 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YongChanShin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOSearchMTYREPOByPeriodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_CIM_1043
	  * MTY Repo Inquiry by Period
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOSearchMTYREPOByPeriodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("enddate",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOSearchMTYREPOByPeriodRSQL").append("\n"); 
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
		query.append("        '00000'                                           PORT ," ).append("\n"); 
		query.append("        '000000000'                                       VVD  ," ).append("\n"); 
		query.append("        ''                                                ETB  ," ).append("\n"); 
		query.append("        ''                                                DIV  ," ).append("\n"); 
		query.append("		''                                        	  	  GUBUN," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','D','Y','N')               D2   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','D','Y','N')               D4   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','D','Y','N')               D5   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','D','Y','N')               D7   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','R','Y','N')               R2   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','R','Y','N')               R5   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','R','Y','N')               R9   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','S','Y','N')               O2   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','S','Y','N')               S2   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','S','Y','N')               O4   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','S','Y','N')               S4   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','S','Y','N')               F2   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','S','Y','N')               A2   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','S','Y','N')               F4   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','S','Y','N')               A4   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','S','Y','N')               F5   ," ).append("\n"); 
		query.append("        DECODE(@[tpsz],'A','Y','S','Y','N')               O5   " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("        EP.PORT_CD                                        PORT ," ).append("\n"); 
		query.append("        EP.VSL_CD||EV.SKD_VOY_NO||EV.SKD_DIR_CD           VVD  ," ).append("\n"); 
		query.append("/* 2010.05.10 ---------> */" ).append("\n"); 
		query.append("        --TO_CHAR(EP.ETB_DT,'YYYYMMDD')                     ETB  ," ).append("\n"); 
		query.append("		DECODE( VV.SKD_CNG_STS_CD, 'S', 'SKIP', TO_CHAR(EP.ETB_DT,'YYYYMMDD') )	ETB, " ).append("\n"); 
		query.append("/* <--------- 2010.05.10 */" ).append("\n"); 
		query.append("        DECODE(EP.LODG_DCHG_DIV_CD,'L','Load','D','Disc') DIV  ," ).append("\n"); 
		query.append("        @[div]     										  GUBUN," ).append("\n"); 
		query.append("        NVL(D2_QTY,0)||''                                        D2   ," ).append("\n"); 
		query.append("        NVL(D4_QTY,0)||''                                        D4   ," ).append("\n"); 
		query.append("        NVL(D5_QTY,0)||''                                        D5   ," ).append("\n"); 
		query.append("        NVL(D7_QTY,0)||''                                        D7   ," ).append("\n"); 
		query.append("        NVL(R2_QTY,0)||''                                        R2   ," ).append("\n"); 
		query.append("        NVL(R5_QTY,0)||''                                        R5   ," ).append("\n"); 
		query.append("        NVL(R9_QTY,0)||''                                        R9   ," ).append("\n"); 
		query.append("        NVL(O2_QTY,0)||''                                        O2   ," ).append("\n"); 
		query.append("        NVL(S2_QTY,0)||''                                        S2   ," ).append("\n"); 
		query.append("        NVL(O4_QTY,0)||''                                        O4   ," ).append("\n"); 
		query.append("        NVL(S4_QTY,0)||''                                        S4   ," ).append("\n"); 
		query.append("        NVL(F2_QTY,0)||''                                        F2   ," ).append("\n"); 
		query.append("        NVL(A2_QTY,0)||''                                        A2   ," ).append("\n"); 
		query.append("        NVL(F4_QTY,0)||''                                        F4   ," ).append("\n"); 
		query.append("        NVL(A4_QTY,0)||''                                        A4   ," ).append("\n"); 
		query.append("        NVL(F5_QTY,0)||''                                        F5   ," ).append("\n"); 
		query.append("        NVL(O5_QTY,0)||''                                        O5" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        EQR_MTY_COD_VVD  EV," ).append("\n"); 
		query.append("        EQR_MTY_COD_PORT EP," ).append("\n"); 
		query.append("        MDM_LOCATION     L ," ).append("\n"); 
		query.append("        MDM_EQ_ORZ_CHT   O ," ).append("\n"); 
		query.append("		VSK_VSL_PORT_SKD VV" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("        EP.ETB_DT   BETWEEN    TO_DATE(@[fromdate], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                    AND        TO_DATE(@[enddate] , 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND     EP.COD_CFM_DIV_CD   =  'C'" ).append("\n"); 
		query.append("AND     EP.LODG_DCHG_DIV_CD <> 'C'" ).append("\n"); 
		query.append("AND     EP.LODG_DCHG_DIV_CD =  DECODE(@[div],'A',EP.LODG_DCHG_DIV_CD,@[div])" ).append("\n"); 
		query.append("AND     EV.VSL_CD           =  EP.VSL_CD" ).append("\n"); 
		query.append("AND     EV.SKD_VOY_NO       =  EP.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     EV.SKD_DIR_CD       =  EP.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     EV.COD_CFM_DIV_CD   =  EP.COD_CFM_DIV_CD" ).append("\n"); 
		query.append("AND     EP.PORT_CD          =  L.LOC_CD" ).append("\n"); 
		query.append("AND     L.SCC_CD            =  O.SCC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${inquirylevel} == 'R' )" ).append("\n"); 
		query.append("AND     O.RCC_CD = @[location]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${inquirylevel} == 'L' )" ).append("\n"); 
		query.append("AND     O.LCC_CD = @[location]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${inquirylevel} == 'E' )" ).append("\n"); 
		query.append("AND     O.ECC_CD = @[location]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${inquirylevel} == 'S' )" ).append("\n"); 
		query.append("AND     O.SCC_CD = @[location]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* 2010.05.10 ---------> */" ).append("\n"); 
		query.append("AND     EP.VSL_CD           =   VV.VSL_CD			(+)" ).append("\n"); 
		query.append("AND     EP.SKD_VOY_NO       =   VV.SKD_VOY_NO		(+)" ).append("\n"); 
		query.append("AND     EP.SKD_DIR_CD       =   VV.SKD_DIR_CD		(+)" ).append("\n"); 
		query.append("AND     EP.PORT_CD			=   VV.VPS_PORT_CD		(+)" ).append("\n"); 
		query.append("AND     EP.CLPT_IND_SEQ		= 	VV.CLPT_IND_SEQ		(+)" ).append("\n"); 
		query.append("/* <--------- 2010.05.10 */" ).append("\n"); 
		query.append("ORDER BY PORT, ETB" ).append("\n"); 

	}
}