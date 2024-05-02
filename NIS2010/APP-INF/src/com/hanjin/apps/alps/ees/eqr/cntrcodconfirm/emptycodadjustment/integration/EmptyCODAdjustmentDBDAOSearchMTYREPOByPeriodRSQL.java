/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOSearchMTYREPOByPeriodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * MTY 양하 계획 조정
	  * EES_CIM_1043
	  * MTY Repo Inquiry by Period
	  * 
	  * 2011.06.13 나상보 [CHM-201111555-01] [EQR] R9 코드 생성에 따른 EQR 모듈 보완 작업 요청
	  * 2012.10.31 문동선 [CHM-201220651-01] [EQR] EQR O5 Type Size 추가
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
		params.put("div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("enddate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fromdate",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.integration").append("\n"); 
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
		query.append("        DECODE(@[tpsz],'A','Y','S','Y','N')               A5   ," ).append("\n"); 
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
		query.append("        D2_QTY||''                                        D2   ," ).append("\n"); 
		query.append("        D4_QTY||''                                        D4   ," ).append("\n"); 
		query.append("        D5_QTY||''                                        D5   ," ).append("\n"); 
		query.append("        D7_QTY||''                                        D7   ," ).append("\n"); 
		query.append("        R2_QTY||''                                        R2   ," ).append("\n"); 
		query.append("        R5_QTY||''                                        R5   ," ).append("\n"); 
		query.append("        R9_QTY||''                                        R9   ," ).append("\n"); 
		query.append("        O2_QTY||''                                        O2   ," ).append("\n"); 
		query.append("        S2_QTY||''                                        S2   ," ).append("\n"); 
		query.append("        O4_QTY||''                                        O4   ," ).append("\n"); 
		query.append("        S4_QTY||''                                        S4   ," ).append("\n"); 
		query.append("        F2_QTY||''                                        F2   ," ).append("\n"); 
		query.append("        A2_QTY||''                                        A2   ," ).append("\n"); 
		query.append("        F4_QTY||''                                        F4   ," ).append("\n"); 
		query.append("        A4_QTY||''                                        A4   ," ).append("\n"); 
		query.append("        F5_QTY||''                                        F5   ," ).append("\n"); 
		query.append("        NVL(A5_QTY,0)||''                                        A5   ," ).append("\n"); 
		query.append("        O5_QTY||''                                        O5" ).append("\n"); 
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