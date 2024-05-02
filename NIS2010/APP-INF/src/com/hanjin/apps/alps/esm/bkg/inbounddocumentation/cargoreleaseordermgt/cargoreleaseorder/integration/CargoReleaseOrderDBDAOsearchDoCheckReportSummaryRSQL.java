/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchDoCheckReportSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchDoCheckReportSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * D/O Release 실적에 대해 조회한다
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchDoCheckReportSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("evnt_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchDoCheckReportSummaryRSQL").append("\n"); 
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
		query.append("SELECT    TRIM(TO_CHAR(SUM(TEU)  ,'999999990.99')) TOT_TEU" ).append("\n"); 
		query.append("        , TRIM(TO_CHAR(SUM(FEU)  ,'999999990.99')) TOT_FEU  " ).append("\n"); 
		query.append("        , TRIM(TO_CHAR(ROUND(SUM(BKG_ACTWGT_QTY)  /1000) ,'999,999,999')) TOT_WGT" ).append("\n"); 
		query.append("		, TRIM(TO_CHAR(SUM(BKG_MEA_QTY)  ,'999,999,990.999')) TOT_MEA" ).append("\n"); 
		query.append("		, COUNT(1)  TOT_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM ( " ).append("\n"); 
		query.append("        SELECT BKG_NO  " ).append("\n"); 
		query.append("            , X.BL_NO" ).append("\n"); 
		query.append("        	, ( SELECT TRIM(TO_CHAR(SUM(DECODE(GREATEST('2', SUBSTR(CNTR_TPSZ_CD, 2, 1)), '2', NVL(OP_CNTR_QTY, 0), 0)) , '999999990.99')) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) TEU" ).append("\n"); 
		query.append("            , ( SELECT TRIM(TO_CHAR(SUM(DECODE(GREATEST('2', SUBSTR(CNTR_TPSZ_CD, 2, 1)), '2', 0, NVL(OP_CNTR_QTY, 0))) , '999999990.99')) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) FEU" ).append("\n"); 
		query.append("            , X.BKG_ACTWGT_QTY" ).append("\n"); 
		query.append("            , X.BKG_MEA_QTY     " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT   BKGM.BKG_NO              AS BKG_NO" ).append("\n"); 
		query.append("                   , BKGM.POD_CD              AS POD_CD" ).append("\n"); 
		query.append("                   , BKGM.POL_CD              AS POL_CD" ).append("\n"); 
		query.append("                   , BKGM.BL_NO||BKGM.BL_TP_CD  AS BL_NO            " ).append("\n"); 
		query.append("                   , TRIM(TO_CHAR(DECODE(NVL(BDOC.ACT_WGT,0),  0, DECODE(NVL(BDOC.WGT_UT_CD,0),'LBS',ROUND(NVL(BDOC.ACT_WGT,0)*0.4536,3),NVL(BDOC.ACT_WGT,0))," ).append("\n"); 
		query.append("                                         DECODE(NVL(BDOC.WGT_UT_CD,0),'LBS',ROUND(NVL(BDOC.ACT_WGT,0)*0.4536,3),NVL(BDOC.ACT_WGT,0)) ),'999999999.999')) AS BKG_ACTWGT_QTY" ).append("\n"); 
		query.append("                   , TRIM(TO_CHAR(DECODE(NVL(BDOC.MEAS_UT_CD, 0),'CBF',ROUND (NVL(BDOC.MEAS_QTY,0)*0.02), NVL(BDOC.MEAS_QTY,0)),'999999990.999')) AS BKG_MEA_QTY" ).append("\n"); 
		query.append("            FROM  BKG_DO_DTL  DOTL" ).append("\n"); 
		query.append("            	 ,BKG_DO      BKDO   " ).append("\n"); 
		query.append("            	 ,BKG_BOOKING BKGM" ).append("\n"); 
		query.append("                 ,BKG_BL_DOC  BDOC" ).append("\n"); 
		query.append("                 ,BKG_VVD     BVVD" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("    #if (${rd_flag} == 'F')" ).append("\n"); 
		query.append("	        AND DOTL.EVNT_DT BETWEEN TO_DATE (@[evnt_dt_fm], 'YYYYMMDD') AND TO_DATE (@[evnt_dt_to], 'YYYYMMDD') + 0.99999   ---  OPTIONAL 2 MANDATORY GROUP1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rd_flag} == 'F' && ${evnt_ofc_cd} != '')" ).append("\n"); 
		query.append("	        AND DOTL.EVNT_OFC_CD = @[evnt_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rd_flag} == 'F' && ${evnt_usr_id} != '')" ).append("\n"); 
		query.append("	        AND DOTL.EVNT_USR_ID = @[evnt_usr_id]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rd_flag} == 'S')" ).append("\n"); 
		query.append("	        AND BKGM.BL_NO  = @[bl_no] -- OPTIONAL 5 MANDATORY GROUP3   " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rd_flag} == 'T')" ).append("\n"); 
		query.append("	        AND BVVD.VSL_CD     = @[vsl_cd]         -- OPTIONAL 3 MANDATORY GROUP2" ).append("\n"); 
		query.append("	        AND BVVD.SKD_VOY_NO = @[skd_voy_no] -- OPTIONAL 3 MANDATORY GROUP2" ).append("\n"); 
		query.append("	        AND BVVD.SKD_DIR_CD = @[skd_dir_cd] -- OPTIONAL 3 MANDATORY GROUP2" ).append("\n"); 
		query.append("	        AND BKGM.POD_CD   = @[pod_cd] -- OPTIONAL 4 MANDATORY GROUP2" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rd_flag} == 'T' && ${del_cd} != '')" ).append("\n"); 
		query.append("	        AND BKGM.DEL_CD = @[del_cd] -- OPTIONAL 10" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("            AND   BKGM.BKG_NO     = BVVD.BKG_NO " ).append("\n"); 
		query.append("            AND   BKGM.POD_CD     = BVVD.POD_CD   " ).append("\n"); 
		query.append("            AND   BDOC.BKG_NO     = BKGM.BKG_NO           " ).append("\n"); 
		query.append("            AND   DOTL.BKG_NO     = BKGM.BKG_NO" ).append("\n"); 
		query.append("            AND   DOTL.RLSE_STS_CD IN ('I', 'R') -- 20091126 심영우 과장 Release되지 않은 것은 리스트에서 제외시켜야 함" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            AND   BKDO.BKG_NO = DOTL.BKG_NO" ).append("\n"); 
		query.append("            AND   BKDO.RLSE_SEQ = DOTL.RLSE_SEQ  " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("           ) X" ).append("\n"); 
		query.append("     ) Y" ).append("\n"); 

	}
}