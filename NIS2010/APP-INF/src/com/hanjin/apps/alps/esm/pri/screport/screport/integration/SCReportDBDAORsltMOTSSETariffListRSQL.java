/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCReportDBDAORsltMOTSSETariffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltMOTSSETariffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MOT/SSE Tariff List 조회
	  * </pre>
	  */
	public SCReportDBDAORsltMOTSSETariffListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mot_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cmdt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_org_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltMOTSSETariffListRSQL").append("\n"); 
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
		query.append("WITH MOT_TRF_MN_RT AS (" ).append("\n"); 
		query.append("    SELECT  MN.SVC_SCP_CD" ).append("\n"); 
		query.append("        ,   MN.MOT_TRF_SEQ" ).append("\n"); 
		query.append("        ,   MN.EFF_DT" ).append("\n"); 
		query.append("        ,   MN.FILE_DT" ).append("\n"); 
		query.append("        ,   MN.CFM_DT" ).append("\n"); 
		query.append("        ,   MN.CFM_FLG" ).append("\n"); 
		query.append("        ,   RT.RT_SEQ" ).append("\n"); 
		query.append("        ,   RT.MOT_TRF_ORG_CD" ).append("\n"); 
		query.append("        ,   RT.MOT_TRF_DEST_CD" ).append("\n"); 
		query.append("        ,   RT.MOT_TRF_CNTR_TP_CD" ).append("\n"); 
		query.append("        ,   RT.MOT_TRF_CMDT_TP_CD" ).append("\n"); 
		query.append("        ,   RT.MOT_TRF_CNTR_SZ_CD" ).append("\n"); 
		query.append("        ,   RT.MOT_TRF_RT_AMT" ).append("\n"); 
		query.append("        ,   RT.MOT_TRF_RMK" ).append("\n"); 
		query.append("    FROM    PRI_MOT_TRF_MN  MN" ).append("\n"); 
		query.append("        ,   PRI_MOT_TRF_RT  RT" ).append("\n"); 
		query.append("    WHERE   MN.SVC_SCP_CD = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     MN.MOT_TRF_SEQ = RT.MOT_TRF_SEQ" ).append("\n"); 
		query.append("    AND     MN.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND     MN.MOT_TRF_SEQ = @[mot_trf_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("), MOT_TRF_SCG_LIST AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT  SD.SVC_SCP_CD" ).append("\n"); 
		query.append("        ,   SD.MOT_TRF_SEQ" ).append("\n"); 
		query.append("        ,   SD.RT_SEQ" ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '01', SD.MOT_TRF_CHG_AMT ) ) AS BAF_AMT  " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '02', SD.MOT_TRF_CHG_AMT ) ) AS CAF_AMT  " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '03', SD.MOT_TRF_CHG_AMT ) ) AS OTHC_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '04', SD.MOT_TRF_CHG_AMT ) ) AS DTHC_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '05', SD.MOT_TRF_CHG_AMT ) ) AS APS_AMT  " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '06', SD.MOT_TRF_CHG_AMT ) ) AS CSR_AMT  " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '07', SD.MOT_TRF_CHG_AMT ) ) AS PCC_AMT  " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '08', SD.MOT_TRF_CHG_AMT ) ) AS PCS_AMT  " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '09', SD.MOT_TRF_CHG_AMT ) ) AS STF_AMT  " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '10', SD.MOT_TRF_CHG_AMT ) ) AS DACT_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '11', SD.MOT_TRF_CHG_AMT ) ) AS DDDC_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '12', SD.MOT_TRF_CHG_AMT ) ) AS DDDF_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '13', SD.MOT_TRF_CHG_AMT ) ) AS DNFC_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '14', SD.MOT_TRF_CHG_AMT ) ) AS OENS_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '15', SD.MOT_TRF_CHG_AMT ) ) AS OD_AMT   " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '16', SD.MOT_TRF_CHG_AMT ) ) AS TDIS_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '17', SD.MOT_TRF_CHG_AMT ) ) AS TGOH_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '18', SD.MOT_TRF_CHG_AMT ) ) AS TWSC_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '19', SD.MOT_TRF_CHG_AMT ) ) AS PSC_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '20', SD.MOT_TRF_CHG_AMT ) ) AS BUC_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '21', SD.MOT_TRF_CHG_AMT ) ) AS EIC_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '22', SD.MOT_TRF_CHG_AMT ) ) AS OSLF_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '23', SD.MOT_TRF_CHG_AMT ) ) AS OOBS_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '24', SD.MOT_TRF_CHG_AMT ) ) AS ODHF_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '25', SD.MOT_TRF_CHG_AMT ) ) AS ODCS_AMT   " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '26', SD.MOT_TRF_CHG_AMT ) ) AS DDTS_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '27', SD.MOT_TRF_CHG_AMT ) ) AS OCMS_AMT " ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( SD.MOT_TRF_CHG_CD, '28', SD.MOT_TRF_CHG_AMT ) ) AS DOCP_AMT " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    FROM    PRI_MOT_TRF_RT_SCG_DTL SD" ).append("\n"); 
		query.append("        ,   MOT_TRF_MN_RT RT" ).append("\n"); 
		query.append("    WHERE   SD.SVC_SCP_CD = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     SD.MOT_TRF_SEQ = RT.MOT_TRF_SEQ" ).append("\n"); 
		query.append("    AND     SD.RT_SEQ = RT.RT_SEQ" ).append("\n"); 
		query.append("    GROUP   BY " ).append("\n"); 
		query.append("            SD.SVC_SCP_CD" ).append("\n"); 
		query.append("        ,   SD.MOT_TRF_SEQ" ).append("\n"); 
		query.append("        ,   SD.RT_SEQ" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("            ROW_NUMBER () OVER ( ORDER BY 1, 2, 3) AS SEQ" ).append("\n"); 
		query.append("        ,   MN.SVC_SCP_CD" ).append("\n"); 
		query.append("        ,   MN.MOT_TRF_SEQ" ).append("\n"); 
		query.append("        ,   MN.EFF_DT" ).append("\n"); 
		query.append("        ,   MN.FILE_DT" ).append("\n"); 
		query.append("        ,   MN.CFM_DT" ).append("\n"); 
		query.append("        ,   MN.CFM_FLG" ).append("\n"); 
		query.append("        ,   MN.RT_SEQ" ).append("\n"); 
		query.append("        ,   'SML' AS CARRIER" ).append("\n"); 
		query.append("        ,   LP.MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("        ,   MN.MOT_TRF_ORG_CD" ).append("\n"); 
		query.append("        ,   MN.MOT_TRF_DEST_CD" ).append("\n"); 
		query.append("        ,   MN.MOT_TRF_CNTR_TP_CD" ).append("\n"); 
		query.append("        ,   MN.MOT_TRF_CMDT_TP_CD" ).append("\n"); 
		query.append("        ,   MN.MOT_TRF_CNTR_SZ_CD" ).append("\n"); 
		query.append("        ,   MN.MOT_TRF_RT_AMT" ).append("\n"); 
		query.append("        ,   SL.BAF_AMT  " ).append("\n"); 
		query.append("        ,   SL.CAF_AMT  " ).append("\n"); 
		query.append("        ,   SL.OTHC_AMT " ).append("\n"); 
		query.append("        ,   SL.DTHC_AMT " ).append("\n"); 
		query.append("        ,   SL.APS_AMT  " ).append("\n"); 
		query.append("        ,   SL.CSR_AMT  " ).append("\n"); 
		query.append("        ,   SL.PCC_AMT  " ).append("\n"); 
		query.append("        ,   SL.PCS_AMT  " ).append("\n"); 
		query.append("        ,   SL.STF_AMT  " ).append("\n"); 
		query.append("        ,   SL.DACT_AMT " ).append("\n"); 
		query.append("        ,   SL.DDDC_AMT " ).append("\n"); 
		query.append("        ,   SL.DDDF_AMT " ).append("\n"); 
		query.append("        ,   SL.DNFC_AMT " ).append("\n"); 
		query.append("        ,   SL.OENS_AMT " ).append("\n"); 
		query.append("        ,   SL.OD_AMT   " ).append("\n"); 
		query.append("        ,   SL.TDIS_AMT " ).append("\n"); 
		query.append("        ,   SL.TGOH_AMT " ).append("\n"); 
		query.append("        ,   SL.TWSC_AMT " ).append("\n"); 
		query.append("        ,   SL.PSC_AMT " ).append("\n"); 
		query.append("        ,   SL.BUC_AMT " ).append("\n"); 
		query.append("        ,   SL.EIC_AMT " ).append("\n"); 
		query.append("        ,   SL.OSLF_AMT " ).append("\n"); 
		query.append("        ,   SL.OOBS_AMT " ).append("\n"); 
		query.append("        ,   SL.ODHF_AMT " ).append("\n"); 
		query.append("        ,   SL.ODCS_AMT   " ).append("\n"); 
		query.append("        ,   SL.DDTS_AMT " ).append("\n"); 
		query.append("        ,   SL.OCMS_AMT " ).append("\n"); 
		query.append("        ,   SL.DOCP_AMT " ).append("\n"); 
		query.append("        ,   MN.MOT_TRF_RMK" ).append("\n"); 
		query.append("    FROM    MOT_TRF_MN_RT MN" ).append("\n"); 
		query.append("        ,   MOT_TRF_SCG_LIST SL" ).append("\n"); 
		query.append("        ,   PRI_MOT_FILE_LOC_PPT LP" ).append("\n"); 
		query.append("    WHERE   MN.SVC_SCP_CD = SL.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     MN.MOT_TRF_SEQ = SL.MOT_TRF_SEQ" ).append("\n"); 
		query.append("    AND     MN.RT_SEQ = SL.RT_SEQ  " ).append("\n"); 
		query.append("    AND     MN.MOT_TRF_DEST_CD = LP.MOT_FILE_LOC_CD" ).append("\n"); 
		query.append("    AND     LP.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("#if ( ${f_lane_cd} != '' && ${f_lane_cd} != ' ' )" ).append("\n"); 
		query.append("    AND     LP.MOT_FILE_LANE_CD = @[f_lane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_cntr_tp_cd} != '' && ${f_cntr_tp_cd} != ' ' )" ).append("\n"); 
		query.append("    AND     MN.MOT_TRF_CNTR_TP_CD = @[f_cntr_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_cntr_sz_cd} != '' && ${f_cntr_sz_cd} != ' ' )" ).append("\n"); 
		query.append("    AND     MN.MOT_TRF_CNTR_SZ_CD = @[f_cntr_sz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_cmdt_tp_cd} != '' && ${f_cmdt_tp_cd} != ' ' )" ).append("\n"); 
		query.append("    AND     MN.MOT_TRF_CMDT_TP_CD = @[f_cmdt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_org_cd} != '' && ${f_org_cd} != ' ' )" ).append("\n"); 
		query.append("    AND     MN.MOT_TRF_ORG_CD = @[f_org_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_dest_cd} != '' && ${f_dest_cd} != ' ' )" ).append("\n"); 
		query.append("    AND     MN.MOT_TRF_DEST_CD = @[f_dest_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}