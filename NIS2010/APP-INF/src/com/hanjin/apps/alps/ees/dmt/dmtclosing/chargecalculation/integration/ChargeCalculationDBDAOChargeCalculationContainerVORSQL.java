/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeCalculationDBDAOChargeCalculationContainerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOChargeCalculationContainerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationContainerVO
	  * </pre>
	  */
	public ChargeCalculationDBDAOChargeCalculationContainerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_provdr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fx_ft_ovr_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uclm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOChargeCalculationContainerVORSQL").append("\n"); 
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
		query.append("SELECT  ( " ).append("\n"); 
		query.append("			SELECT  INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("              FROM  COM_INTG_CD_DTL " ).append("\n"); 
		query.append("             WHERE  INTG_CD_ID = 'CD03382' " ).append("\n"); 
		query.append("               AND  INTG_CD_VAL_CTNT = A.DMDT_DELT_RQST_STS_CD " ).append("\n"); 
		query.append("		) AS INACT_STS_NM" ).append("\n"); 
		query.append("       , A.*" ).append("\n"); 
		query.append("	   --// 2016.07.12 - DAR NO, DAR STATUS CODE 요청에 의해 추가" ).append("\n"); 
		query.append("	   ,AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("       ,DMDT_EXPT_RQST_STS_CD " ).append("\n"); 
		query.append("       ,DECODE(TRIM(DMDT_EXPT_RQST_STS_CD), NULL, NULL, '', NULL, DECODE(DMDT_EXPT_RQST_STS_CD, 'R', 'BLUE', 'J', 'RED', 'O', 'RED', 'A', 'BLACK', 'PINK')) DMDT_EXPT_RQST_STS_COLOR" ).append("\n"); 
		query.append("	   ,CASE " ).append("\n"); 
		query.append("			WHEN DMDT_EXPT_RQST_STS_CD = 'O' THEN " ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					SELECT  DECODE(MAX(AFT_BKG_PATH_LVL), 1, 'SCO PIC ', 2, 'OFC O.Manager', 3, 'SSZ/BAG ', 4, 'RHQ PIC ', 5, 'RHQ MGR ', 6, 'HO PIC ', 7, 'HO MGR ', '') || 'Counter-Offer'" ).append("\n"); 
		query.append("					  FROM  DMT_AFT_BKG_APRO_PATH" ).append("\n"); 
		query.append(" 			         WHERE  AFT_EXPT_DAR_NO = A.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("					   AND  DMDT_EXPT_RQST_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("	 		           AND  AFT_BKG_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			ELSE " ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					SELECT  INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("			          FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		             WHERE  INTG_CD_ID = 'CD01971'" ).append("\n"); 
		query.append("	    	           AND  INTG_CD_VAL_CTNT = DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		END DMDT_EXPT_RQST_STS_CD_DESC" ).append("\n"); 
		query.append("	   --// 2016.07.12 END" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("			SELECT  C.SYS_AREA_GRP_ID SVR_ID" ).append("\n"); 
		query.append("				   ,C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   --// 2016.07.12 - DAR NO, DAR STATUS CODE 요청에 의해 추가" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						SELECT  AA.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                          FROM  DMT_AFT_BKG_ADJ_RQST_DTL 	CC" ).append("\n"); 
		query.append("                               ,DMT_AFT_BKG_CNTR 			BB" ).append("\n"); 
		query.append("                               ,DMT_AFT_BKG_ADJ_RQST 		AA" ).append("\n"); 
		query.append("                         WHERE  CC.BKG_NO              = B.BKG_NO" ).append("\n"); 
		query.append("                           AND  CC.AFT_EXPT_DAR_NO     = BB.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                           AND  CC.AFT_EXPT_ADJ_SEQ    = BB.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("                           AND  CC.DMDT_TRF_CD         = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                           AND  BB.SYS_AREA_GRP_ID     = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                           AND  BB.CNTR_NO             = C.CNTR_NO" ).append("\n"); 
		query.append("                           AND  BB.CNTR_CYC_NO         = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("                           AND  BB.DMDT_TRF_CD         = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                           AND  BB.DMDT_CHG_LOC_DIV_CD = C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("                           AND  BB.CHG_SEQ             = C.CHG_SEQ" ).append("\n"); 
		query.append("                           AND  AA.AFT_EXPT_DAR_NO     = BB.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                           AND  AA.RQST_DT             = " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT  MAX(RQST_DT)" ).append("\n"); 
		query.append("                                      FROM  DMT_AFT_BKG_ADJ_RQST 		A1" ).append("\n"); 
		query.append("                                           ,DMT_AFT_BKG_ADJ_RQST_DTL 	B1" ).append("\n"); 
		query.append("									 WHERE  A1.AFT_EXPT_DAR_NO = B1.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                       AND  B1.BKG_NO = CC.BKG_NO" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						   AND  DMDT_EXPT_RQST_STS_CD != 'T'" ).append("\n"); 
		query.append("					) AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						SELECT  DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("                          FROM  DMT_AFT_BKG_ADJ_RQST_DTL 	CC" ).append("\n"); 
		query.append("                               ,DMT_AFT_BKG_CNTR 			BB" ).append("\n"); 
		query.append("                               ,DMT_AFT_BKG_ADJ_RQST 		AA" ).append("\n"); 
		query.append("                         WHERE  CC.BKG_NO              = B.BKG_NO" ).append("\n"); 
		query.append("                           AND  CC.AFT_EXPT_DAR_NO     = BB.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                           AND  CC.AFT_EXPT_ADJ_SEQ    = BB.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("                           AND  CC.DMDT_TRF_CD         = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                           AND  BB.SYS_AREA_GRP_ID     = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                           AND  BB.CNTR_NO             = C.CNTR_NO" ).append("\n"); 
		query.append("                           AND  BB.CNTR_CYC_NO         = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("                           AND  BB.DMDT_TRF_CD         = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("                           AND  BB.DMDT_CHG_LOC_DIV_CD = C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("                           AND  BB.CHG_SEQ             = C.CHG_SEQ" ).append("\n"); 
		query.append("                           AND  AA.AFT_EXPT_DAR_NO     = BB.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                           AND  AA.RQST_DT             = " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT  MAX(RQST_DT)" ).append("\n"); 
		query.append("									  FROM  DMT_AFT_BKG_ADJ_RQST 		A1" ).append("\n"); 
		query.append("                                           ,DMT_AFT_BKG_ADJ_RQST_DTL 	B1" ).append("\n"); 
		query.append("                                 WHERE A1.AFT_EXPT_DAR_NO = B1.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                   AND B1.BKG_NO = CC.BKG_NO )" ).append("\n"); 
		query.append("						   AND  DMDT_EXPT_RQST_STS_CD != 'T'" ).append("\n"); 
		query.append("					) DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("					--// 2016.07.12 END" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						SELECT  INACT_RQST_NO" ).append("\n"); 
		query.append("						  FROM  DMT_CHG_DELT_RQST_APRO DD" ).append("\n"); 
		query.append("						 WHERE  DD.SYS_AREA_GRP_ID     = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND	DD.CNTR_NO		       = C.CNTR_NO" ).append("\n"); 
		query.append("						   AND	DD.CNTR_CYC_NO		   = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND	DD.DMDT_TRF_CD		   = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND	DD.DMDT_CHG_LOC_DIV_CD = C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND	DD.CHG_SEQ			   = C.CHG_SEQ" ).append("\n"); 
		query.append("						   AND  DD.CHG_OFC_CD          = C.OFC_CD" ).append("\n"); 
		query.append("						   AND  DD.DELT_SEQ            = " ).append("\n"); 
		query.append("								( " ).append("\n"); 
		query.append("									SELECT  NVL(MAX(DS.DELT_SEQ), 0) " ).append("\n"); 
		query.append("									  FROM  DMT_CHG_DELT_RQST_APRO DS" ).append("\n"); 
		query.append("									 WHERE  DS.SYS_AREA_GRP_ID     = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("									   AND  DS.CNTR_NO	           = DD.CNTR_NO" ).append("\n"); 
		query.append("									   AND  DS.CNTR_CYC_NO	       = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("									   AND  DS.DMDT_TRF_CD	       = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("									   AND  DS.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("									   AND  DS.CHG_SEQ		       = DD.CHG_SEQ" ).append("\n"); 
		query.append("									   AND  DS.CHG_OFC_CD          = DD.CHG_OFC_CD   " ).append("\n"); 
		query.append("									   AND  DS.DMDT_DELT_RQST_STS_CD != 'C'" ).append("\n"); 
		query.append("								)  " ).append("\n"); 
		query.append("					) AS INACT_RQST_NO" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						SELECT  CASE " ).append("\n"); 
		query.append("									WHEN NVL(MAX(DD.DMDT_DELT_RQST_STS_CD), 'N') IN ('C','N') THEN 'N'" ).append("\n"); 
		query.append("									WHEN 0 < MAX((	" ).append("\n"); 
		query.append("												SELECT  COUNT(1)" ).append("\n"); 
		query.append("												  FROM  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("												 WHERE  SYS_AREA_GRP_ID     = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("												   AND  CNTR_NO             = DD.CNTR_NO" ).append("\n"); 
		query.append("												   AND  CNTR_CYC_NO         = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("												   AND  DMDT_TRF_CD         = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("												   AND  DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("												   AND  CHG_SEQ             = DD.CHG_SEQ" ).append("\n"); 
		query.append("												   AND  CHG_OFC_CD          = DD.CHG_OFC_CD" ).append("\n"); 
		query.append("												   AND  DELT_SEQ            = DD.DELT_SEQ" ).append("\n"); 
		query.append("												   AND  CHG_DELT_PATH_LVL  >=" ).append("\n"); 
		query.append("														(" ).append("\n"); 
		query.append("															SELECT  MAX(CHG_DELT_PATH_LVL)" ).append("\n"); 
		query.append("															  FROM  DMT_CHG_DELT_PATH " ).append("\n"); 
		query.append("															 WHERE  SYS_AREA_GRP_ID        = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("															   AND  CNTR_NO                = DD.CNTR_NO" ).append("\n"); 
		query.append("															   AND  CNTR_CYC_NO            = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("															   AND  DMDT_TRF_CD            = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("															   AND  DMDT_CHG_LOC_DIV_CD    = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("															   AND  CHG_SEQ                = DD.CHG_SEQ" ).append("\n"); 
		query.append("															   AND  CHG_OFC_CD             = DD.CHG_OFC_CD" ).append("\n"); 
		query.append("															   AND  DELT_SEQ               = DD.DELT_SEQ" ).append("\n"); 
		query.append("															   AND  CHG_DELT_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("												   AND  CHG_DELT_STS_CD  = 'A'" ).append("\n"); 
		query.append("											 )) THEN 'X'		--// Charge Deletion 요청 불가, Charge Deletion Cancel 불가" ).append("\n"); 
		query.append("									ELSE MAX(DD.DMDT_DELT_RQST_STS_CD)" ).append("\n"); 
		query.append("								END" ).append("\n"); 
		query.append("									" ).append("\n"); 
		query.append("						  FROM  DMT_CHG_DELT_RQST_APRO DD" ).append("\n"); 
		query.append("						 WHERE  DD.SYS_AREA_GRP_ID     = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND	DD.CNTR_NO		       = C.CNTR_NO" ).append("\n"); 
		query.append("						   AND	DD.CNTR_CYC_NO		   = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND	DD.DMDT_TRF_CD		   = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND	DD.DMDT_CHG_LOC_DIV_CD = C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND	DD.CHG_SEQ			   = C.CHG_SEQ" ).append("\n"); 
		query.append("						   AND  DD.CHG_OFC_CD          = C.OFC_CD" ).append("\n"); 
		query.append("						   AND  DD.DELT_SEQ            = " ).append("\n"); 
		query.append("								( " ).append("\n"); 
		query.append("									SELECT  NVL(MAX(DS.DELT_SEQ), 0) " ).append("\n"); 
		query.append("									  FROM  DMT_CHG_DELT_RQST_APRO DS" ).append("\n"); 
		query.append("									 WHERE  DS.SYS_AREA_GRP_ID     = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("									   AND  DS.CNTR_NO	           = DD.CNTR_NO" ).append("\n"); 
		query.append("									   AND  DS.CNTR_CYC_NO	       = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("									   AND  DS.DMDT_TRF_CD	       = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("									   AND  DS.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("									   AND  DS.CHG_SEQ		       = DD.CHG_SEQ" ).append("\n"); 
		query.append("									   AND  DS.CHG_OFC_CD          = DD.CHG_OFC_CD   " ).append("\n"); 
		query.append("									   AND  DS.DMDT_DELT_RQST_STS_CD != 'C'" ).append("\n"); 
		query.append("								)  " ).append("\n"); 
		query.append("					) AS DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("				   ,C.CNTR_NO    " ).append("\n"); 
		query.append("				   ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				   ,C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("				   ,C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("				   ,C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("				   ,C.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("				   ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("				   ,C.FT_DYS" ).append("\n"); 
		query.append("				   ,C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("				   -- 조건추가(S) 2013.12.13" ).append("\n"); 
		query.append("				   ,TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(NVL(C.TO_MVMT_DT, C.FT_END_DT), 'YYYYMMDD'), 'YYYYMMDD') AS OVR_DUE" ).append("\n"); 
		query.append("				   -- 조건추가(E)" ).append("\n"); 
		query.append("				   ,C.ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("				   ,TO_CHAR(C.FM_MVMT_DT, 'yyyymmdd') FM_MVMT_DT" ).append("\n"); 
		query.append("				   ,TO_CHAR(C.TO_MVMT_DT, 'yyyymmdd') TO_MVMT_DT" ).append("\n"); 
		query.append("				   ,TO_CHAR(C.FT_CMNC_DT, 'yyyymmdd') FT_CMNC_DT" ).append("\n"); 
		query.append("				   ,TO_CHAR(C.FT_END_DT, 'yyyymmdd') FT_END_DT" ).append("\n"); 
		query.append("				   ,C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("				   ,C.ORG_CHG_AMT" ).append("\n"); 
		query.append("				   ,C.SC_RFA_EXPT_AMT    " ).append("\n"); 
		query.append("				   ,C.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("				   ,C.BIL_AMT" ).append("\n"); 
		query.append("				   ,B.BKG_NO" ).append("\n"); 
		query.append("				   ,B.BL_NO" ).append("\n"); 
		query.append("				   ,B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVD_CD    " ).append("\n"); 
		query.append("				   ,( " ).append("\n"); 
		query.append("						SELECT  V.VSL_SLAN_CD LANE   " ).append("\n"); 
		query.append("						  FROM  VSK_VSL_SKD V" ).append("\n"); 
		query.append("						 WHERE  B.VSL_CD	 = V.VSL_CD" ).append("\n"); 
		query.append("						   AND  B.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("						   AND  B.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("				    ) AS LANE" ).append("\n"); 
		query.append("				   ,B.POR_CD" ).append("\n"); 
		query.append("				   ,B.POL_CD" ).append("\n"); 
		query.append("				   ,B.POD_CD" ).append("\n"); 
		query.append("				   ,B.DEL_CD" ).append("\n"); 
		query.append("				   ,B.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("				   ,B.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("				   ,B.SC_NO" ).append("\n"); 
		query.append("				   ,B.RFA_NO" ).append("\n"); 
		query.append("				   ,DECODE( BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')), '000000', NULL" ).append("\n"); 
		query.append("				  		   ,BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')) ) AS ACUST	" ).append("\n"); 
		query.append("				   ,DECODE(C.CHG_SEQ, 1, 'G', 'B') AS CHG_TYPE" ).append("\n"); 
		query.append("				   ,NVL(C.UCLM_FLG, 'N')AS UCLM_FLG" ).append("\n"); 
		query.append("				   ,C.CHG_SEQ" ).append("\n"); 
		query.append("				   ,NVL(B.SOC_FLG, 'N') AS SOC_FLG" ).append("\n"); 
		query.append("				   ,CASE" ).append("\n"); 
		query.append("						WHEN C.DMDT_TRF_CD='DMIF' AND C.TO_MVMT_STS_CD='ID' THEN 'L'" ).append("\n"); 
		query.append("						WHEN C.DMDT_TRF_CD='DMIF' AND C.TO_MVMT_STS_CD NOT IN ('ID','CS','DR') THEN 'I'" ).append("\n"); 
		query.append("						WHEN C.DMDT_TRF_CD='DMOF' AND C.DMDT_CHG_LOC_DIV_CD <> 'POL' THEN 'L'" ).append("\n"); 
		query.append("						WHEN C.DMDT_TRF_CD='DMOF' AND C.DMDT_CHG_LOC_DIV_CD='POL' THEN 'I'" ).append("\n"); 
		query.append("				    END AS LI" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						SELECT  NVL(HLG_TP_CD, 'N')" ).append("\n"); 
		query.append("						  FROM  BKG_EUR_TRO" ).append("\n"); 
		query.append("						 WHERE  BKG_NO			  = B.BKG_NO" ).append("\n"); 
		query.append("						   AND  IO_BND_CD		  = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("						   AND  NVL(CXL_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("						   AND  CNTR_NO	          = C.CNTR_NO" ).append("\n"); 
		query.append("						   AND  ROWNUM            = 1 " ).append("\n"); 
		query.append("					) AS CH" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						SELECT  'Y'" ).append("\n"); 
		query.append("						  FROM  DUAL      " ).append("\n"); 
		query.append("						 WHERE  EXISTS" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT  BDD.RLSE_STS_CD" ).append("\n"); 
		query.append("									  FROM  BKG_DO     BDO" ).append("\n"); 
		query.append("										   ,BKG_DO_DTL BDD" ).append("\n"); 
		query.append("									 WHERE  BDO.BKG_NO        = BDD.BKG_NO" ).append("\n"); 
		query.append("									   AND  BDO.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("									   AND  BDD.RLSE_STS_CD IN ('R', 'I')" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("					) AS D_O" ).append("\n"); 
		query.append("				   ,(	" ).append("\n"); 
		query.append("						SELECT  BDD.EVNT_OFC_CD" ).append("\n"); 
		query.append("						  FROM  BKG_DO     BDO" ).append("\n"); 
		query.append("							   ,BKG_DO_DTL BDD" ).append("\n"); 
		query.append("						 WHERE  BDO.BKG_NO	= BDD.BKG_NO   " ).append("\n"); 
		query.append("						   AND  BDO.BKG_NO	= B.BKG_NO   " ).append("\n"); 
		query.append("						   AND  BDD.RLSE_STS_CD IN ('R', 'I')" ).append("\n"); 
		query.append("						   AND  ROWNUM = 1 " ).append("\n"); 
		query.append("					) AS RLSE_OFC" ).append("\n"); 
		query.append("	               ,BR.CLT_OFC_CD" ).append("\n"); 
		query.append("	               ,NVL(C.OFC_TRNS_FLG, 'N') AS OFC_TRNS_FLG" ).append("\n"); 
		query.append("	               ,(" ).append("\n"); 
		query.append("						SELECT  'C'" ).append("\n"); 
		query.append("						  FROM  DUAL" ).append("\n"); 
		query.append("						 WHERE  EXISTS" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT  1" ).append("\n"); 
		query.append("									  FROM  BKG_ROLL_OVR R" ).append("\n"); 
		query.append("									 WHERE  R.BKG_NO = B.BKG_NO    			" ).append("\n"); 
		query.append("									   AND  R.ROLL_OVR_RSN_CD IN ('C', 'H')" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("					) AS ROLL_OVR	" ).append("\n"); 
		query.append("                   ,C.WEB_IND_FLG" ).append("\n"); 
		query.append("                   ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("                   ,C.DMDT_CHG_LOC_DIV_CD	" ).append("\n"); 
		query.append("	               ,C.OFC_CD" ).append("\n"); 
		query.append("	               ,C.OFC_RHQ_CD" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						CASE " ).append("\n"); 
		query.append("							WHEN   (C.DMDT_TRF_CD IN ('DTIC', 'CTIC') AND SUBSTR(BK.DEL_CD,1,2) = 'US' AND BK.DE_TERM_CD = 'Y') " ).append("\n"); 
		query.append("								OR (C.DMDT_TRF_CD IN ('DTOC', 'CTOC') AND SUBSTR(BK.POR_CD,1,2) = 'US' AND BK.RCV_TERM_CD = 'Y') " ).append("\n"); 
		query.append("								THEN " ).append("\n"); 
		query.append("									(SELECT	LPAD(VNDR_SEQ,6,'0') AS VNDR_CD FROM	MDM_VENDOR WHERE	VNDR_SEQ = C.VNDR_SEQ AND	DELT_FLG <> 'Y')" ).append("\n"); 
		query.append("                             " ).append("\n"); 
		query.append("							ELSE " ).append("\n"); 
		query.append("								CASE " ).append("\n"); 
		query.append("									WHEN SUBSTR(C.DMDT_TRF_CD,3,1) = 'I' AND SUBSTR(BK.DEL_CD,1,2) IN ('US', 'CA') " ).append("\n"); 
		query.append("										THEN  " ).append("\n"); 
		query.append("                                            NVL(( SELECT CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') " ).append("\n"); 
		query.append("                                                                 FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("                                                                WHERE BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("                                                                  AND BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("																  AND CUST_CNT_CD IS NOT NULL AND CUST_SEQ IS NOT NULL)," ).append("\n"); 
		query.append("                                                             ( SELECT CUST_CNT_CD||LPAD(CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("                                                                 FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("                                                                WHERE BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("                                                                  AND BKG_CUST_TP_CD = 'N'))" ).append("\n"); 
		query.append("                                                                  " ).append("\n"); 
		query.append("                                    WHEN SUBSTR(C.DMDT_TRF_CD,3,1) = 'O' AND SUBSTR(BK.POR_CD,1,2) IN ('US', 'CA') THEN  " ).append("\n"); 
		query.append("                                            ( SELECT CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') " ).append("\n"); 
		query.append("                                                                 FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("                                                                WHERE BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("                                                                  AND BKG_CUST_TP_CD = 'S')" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("                                    ELSE " ).append("\n"); 
		query.append("                                          NVL(" ).append("\n"); 
		query.append("											   (SELECT ACT_CUST_CNT_CD || LPAD(ACT_CUST_SEQ, 6, '0')" ).append("\n"); 
		query.append("													FROM INV_AR_MN AR" ).append("\n"); 
		query.append("													WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("													AND IO_BND_CD = SUBSTR(C.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("													AND AR_IF_NO = (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("																			FROM INV_AR_MN" ).append("\n"); 
		query.append("																			WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("																			AND   IO_BND_CD = SUBSTR(C.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("																	)" ).append("\n"); 
		query.append("												), NVL(DECODE(C.ACT_CNT_CD, '00', '', C.ACT_CNT_CD)|| DECODE(C.ACT_CUST_SEQ,NULL,'',0,'',LPAD(C.ACT_CUST_SEQ, 6, '0')), '')" ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("                                    END" ).append("\n"); 
		query.append("						END " ).append("\n"); 
		query.append("					) AS PAYER_CD" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						CASE " ).append("\n"); 
		query.append("							WHEN   (C.DMDT_TRF_CD IN ('DTIC', 'CTIC') AND SUBSTR(BK.DEL_CD,1,2) = 'US' AND BK.DE_TERM_CD = 'Y') " ).append("\n"); 
		query.append("							    OR (C.DMDT_TRF_CD IN ('DTOC', 'CTOC') AND SUBSTR(BK.POR_CD,1,2) = 'US' AND BK.RCV_TERM_CD = 'Y') " ).append("\n"); 
		query.append("								THEN " ).append("\n"); 
		query.append("									(SELECT	VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = C.VNDR_SEQ AND DELT_FLG <> 'Y' AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             " ).append("\n"); 
		query.append("							ELSE " ).append("\n"); 
		query.append("								CASE " ).append("\n"); 
		query.append("									WHEN SUBSTR(C.DMDT_TRF_CD,3,1) = 'I' AND SUBSTR(BK.DEL_CD,1,2) IN ('US', 'CA') " ).append("\n"); 
		query.append("										THEN  " ).append("\n"); 
		query.append("                                            NVL(( SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                                                 FROM BKG_CUSTOMER A, MDM_CUSTOMER B" ).append("\n"); 
		query.append("                                                                WHERE A.BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("                                                                  AND A.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("																  AND A.CUST_CNT_CD IS NOT NULL AND A.CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("                                                                  AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                  AND A.CUST_SEQ = B.CUST_SEQ " ).append("\n"); 
		query.append("                                                                  AND ROWNUM = 1 )," ).append("\n"); 
		query.append("                                                             ( SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                                                 FROM BKG_CUSTOMER A, MDM_CUSTOMER B" ).append("\n"); 
		query.append("                                                                WHERE A.BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("                                                                  AND A.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                                                                  AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                  AND A.CUST_SEQ = B.CUST_SEQ " ).append("\n"); 
		query.append("                                                                  AND ROWNUM = 1 ))" ).append("\n"); 
		query.append("                                                                  " ).append("\n"); 
		query.append("                                    WHEN SUBSTR(C.DMDT_TRF_CD,3,1) = 'O' AND SUBSTR(BK.POR_CD,1,2) IN ('US', 'CA') " ).append("\n"); 
		query.append("										THEN  " ).append("\n"); 
		query.append("                                            ( SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                                                 FROM BKG_CUSTOMER A, MDM_CUSTOMER B" ).append("\n"); 
		query.append("                                                                WHERE A.BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("                                                                  AND A.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                                                                  AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                  AND A.CUST_SEQ = B.CUST_SEQ " ).append("\n"); 
		query.append("                                                                  AND ROWNUM = 1 )" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("                                    ELSE " ).append("\n"); 
		query.append("                                          NVL((SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("											FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                                            WHERE (CUST_SEQ, CUST_CNT_CD) = (" ).append("\n"); 
		query.append("												SELECT ACT_CUST_SEQ, ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("												FROM INV_AR_MN AR" ).append("\n"); 
		query.append("												WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("												AND IO_BND_CD = SUBSTR(C.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("												AND AR_IF_NO = (" ).append("\n"); 
		query.append("                                                	SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("													FROM INV_AR_MN" ).append("\n"); 
		query.append("													WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("													AND IO_BND_CD = SUBSTR(C.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("											AND ROWNUM = 1" ).append("\n"); 
		query.append("										), (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("											FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                                            WHERE CUST_CNT_CD = C.ACT_CNT_CD " ).append("\n"); 
		query.append("											AND CUST_SEQ = C.ACT_CUST_SEQ))" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("						END " ).append("\n"); 
		query.append("					) AS PAYER_NM" ).append("\n"); 
		query.append("				   ,BS.CUST_CNT_CD || TRIM(TO_CHAR(BS.CUST_SEQ, '000000')) SHIPPER_CD " ).append("\n"); 
		query.append("				   ,REPLACE(BS.CUST_NM, CHR(13) || CHR(10), ' ') SHIPPER_NM   " ).append("\n"); 
		query.append("				   ,DECODE(BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000')), '000000', NULL, BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000'))) CNEE_CD" ).append("\n"); 
		query.append("				   ,REPLACE(BC.CUST_NM, CHR(13) || CHR(10), ' ') CNEE_NM" ).append("\n"); 
		query.append("				   ,DECODE(BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000')), '000000', NULL, BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000'))) NTFY_CD" ).append("\n"); 
		query.append("				   ,NVL(RTRIM(REPLACE(REPLACE(BN.CUST_NM, CHR(34), ''), CHR(13)||CHR(10), ' ')), '-') NTFY_NM" ).append("\n"); 
		query.append("				  ,(" ).append("\n"); 
		query.append("						SELECT  I.ACT_CUST_CNT_CD || TRIM(TO_CHAR(ACT_CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("						  FROM  INV_AR_MN I" ).append("\n"); 
		query.append("						 WHERE  I.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("						   AND  I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("						   AND  AR_IF_NO = " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT  MAX(AR_IF_NO) " ).append("\n"); 
		query.append("									  FROM  INV_AR_MN" ).append("\n"); 
		query.append("									 WHERE  BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("									   AND  IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						   AND  ROWNUM  = 1" ).append("\n"); 
		query.append("					) AS AR_ACT_CD" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						SELECT  MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("						  FROM  MDM_CUSTOMER 	MC" ).append("\n"); 
		query.append("							   ,INV_AR_MN 		I" ).append("\n"); 
		query.append("						 WHERE  MC.CUST_CNT_CD = I.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("						   AND  MC.CUST_SEQ    = I.ACT_CUST_SEQ" ).append("\n"); 
		query.append("						   AND  I.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("						   AND  I.IO_BND_CD    = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("						   AND  AR_IF_NO	   = " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT	MAX(AR_IF_NO) " ).append("\n"); 
		query.append("									FROM	INV_AR_MN" ).append("\n"); 
		query.append("									WHERE	BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("									AND		IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						   AND  ROWNUM  = 1" ).append("\n"); 
		query.append("					) AS AR_ACT_NM" ).append("\n"); 
		query.append("				   ,DECODE(TRIM(TO_CHAR(C.VNDR_SEQ, '000000')), '000000', NULL, TRIM(TO_CHAR(C.VNDR_SEQ, '000000'))) AS SVC_PROVDR_CD" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						SELECT  MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("						  FROM  MDM_VENDOR MV" ).append("\n"); 
		query.append("						 WHERE  MV.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("					) AS SVC_PROVDR_NM" ).append("\n"); 
		query.append("				   ,M.AR_CURR_CD" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			  FROM  DMT_CHG_BKG_CNTR   B" ).append("\n"); 
		query.append("                   ,DMT_CHG_CALC       C" ).append("\n"); 
		query.append("                   ,BKG_BOOKING        BK" ).append("\n"); 
		query.append("                   ,BKG_RATE           BR" ).append("\n"); 
		query.append("                   ,MDM_ORGANIZATION   M" ).append("\n"); 
		query.append("                   ,BKG_CUSTOMER       BS" ).append("\n"); 
		query.append("                   ,BKG_CUSTOMER       BC" ).append("\n"); 
		query.append("                   ,BKG_CUSTOMER       BN" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("			 WHERE  B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("               AND  B.CNTR_NO         = C.CNTR_NO" ).append("\n"); 
		query.append("               AND  B.CNTR_CYC_NO     = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("               AND  B.BKG_NO          = BK.BKG_NO" ).append("\n"); 
		query.append("               AND  B.BKG_NO		  = BR.BKG_NO(+)" ).append("\n"); 
		query.append("               AND  C.OFC_CD          = M.OFC_CD" ).append("\n"); 
		query.append("               AND  C.OFC_CD          = @[ofc_cd]" ).append("\n"); 
		query.append("               AND  C.DMDT_TRF_CD   IN (" ).append("\n"); 
		query.append("						#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("							#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("               AND  NOT (C.DUL_TP_EXPT_FLG = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("               AND  B.BKG_NO			 = BS.BKG_NO(+)" ).append("\n"); 
		query.append("               AND  BS.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("               AND  B.BKG_NO             = BC.BKG_NO(+)" ).append("\n"); 
		query.append("               AND  BC.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("               AND  B.BKG_NO             = BN.BKG_NO(+)" ).append("\n"); 
		query.append("               AND  BN.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("               AND  C.DMDT_CHG_LOC_DIV_CD <> 'SZP'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${dmdt_chg_sts_cd} != '') " ).append("\n"); 
		query.append("			   AND  (1 = 0" ).append("\n"); 
		query.append("				   #foreach( $chg_sts_cd in ${chg_sts_cd_list} )	" ).append("\n"); 
		query.append("					   #if (${cond_type} != 'date') ## && $chg_sts_cd != 'A')" ).append("\n"); 
		query.append("							OR C.DMDT_CHG_STS_CD = '$chg_sts_cd'" ).append("\n"); 
		query.append("					   #else" ).append("\n"); 
		query.append("							#if ($chg_sts_cd == 'C' || $chg_sts_cd == 'F' || $chg_sts_cd == 'R')" ).append("\n"); 
		query.append("								OR (C.DMDT_CHG_STS_CD = '$chg_sts_cd'" ).append("\n"); 
		query.append("									AND C.TO_MVMT_DT BETWEEN TO_DATE(@[fm_mvmt_dt], 'yyyymmdd') " ).append("\n"); 
		query.append("														 AND TO_DATE(@[to_mvmt_dt], 'yyyymmdd') + 0.99999 )" ).append("\n"); 
		query.append("							#elseif ($chg_sts_cd == 'L')" ).append("\n"); 
		query.append("								OR (C.DMDT_CHG_STS_CD = 'L'" ).append("\n"); 
		query.append("									AND C.FM_MVMT_DT BETWEEN TO_DATE(@[fm_mvmt_dt], 'yyyymmdd') " ).append("\n"); 
		query.append("														AND TO_DATE(@[to_mvmt_dt], 'yyyymmdd') + 0.99999 ) " ).append("\n"); 
		query.append("							#elseif ($chg_sts_cd == 'U')" ).append("\n"); 
		query.append("								OR (C.DMDT_CHG_STS_CD = 'U'" ).append("\n"); 
		query.append("									AND C.FM_MVMT_DT BETWEEN TO_DATE(@[fm_mvmt_dt], 'yyyymmdd') " ).append("\n"); 
		query.append("														AND TO_DATE(@[to_mvmt_dt], 'yyyymmdd') + 0.99999 ) " ).append("\n"); 
		query.append("							#elseif ($chg_sts_cd == 'E')" ).append("\n"); 
		query.append("								OR (C.DMDT_CHG_STS_CD = 'E'" ).append("\n"); 
		query.append("									AND ( (C.FM_MVMT_DT BETWEEN TO_DATE(@[fm_mvmt_dt], 'yyyymmdd') " ).append("\n"); 
		query.append("														AND TO_DATE(@[to_mvmt_dt], 'yyyymmdd') + 0.99999 )" ).append("\n"); 
		query.append("										 OR (C.TO_MVMT_DT BETWEEN TO_DATE(@[fm_mvmt_dt], 'yyyymmdd') " ).append("\n"); 
		query.append("														AND TO_DATE(@[to_mvmt_dt], 'yyyymmdd') + 0.99999) ) )" ).append("\n"); 
		query.append("							#elseif ($chg_sts_cd == 'T')" ).append("\n"); 
		query.append("								OR C.DMDT_CHG_STS_CD = 'L' " ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("			        )" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${chg_type} == 'G')" ).append("\n"); 
		query.append("               AND  C.CHG_SEQ = 1" ).append("\n"); 
		query.append("			   #elseif (${chg_type} == 'B') " ).append("\n"); 
		query.append("               AND  C.CHG_SEQ > 1" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${fx_ft_ovr_dys} != '0') " ).append("\n"); 
		query.append("			   AND  C.FX_FT_OVR_DYS >= TO_NUMBER(@[fx_ft_ovr_dys])" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 조건추가(S) 2013.09.13" ).append("\n"); 
		query.append("			   #if(${uclm_flg} != 'ALL')          " ).append("\n"); 
		query.append("			   AND  NVL(C.UCLM_FLG, 'N') = @[uclm_flg]" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("-- 조건추가(E)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${cond_type} == 'date')" ).append("\n"); 
		query.append("				   #if (${fm_mvmt_yd_cd} != '')" ).append("\n"); 
		query.append("						##${fm_mvmt_yd_cd}" ).append("\n"); 
		query.append("						#if ($fm_mvmt_yd_cd.length() == 5)" ).append("\n"); 
		query.append("							AND SUBSTR(C.FM_MVMT_YD_CD, 1, 5) = @[fm_mvmt_yd_cd]" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							AND C.FM_MVMT_YD_CD = @[fm_mvmt_yd_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("				   #elseif (${to_mvmt_yd_cd} != '')" ).append("\n"); 
		query.append("						##${to_mvmt_yd_cd}" ).append("\n"); 
		query.append("						#if ($to_mvmt_yd_cd.length() == 5)" ).append("\n"); 
		query.append("							AND SUBSTR(C.TO_MVMT_YD_CD,1, 5) = @[to_mvmt_yd_cd]" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							AND C.TO_MVMT_YD_CD = @[to_mvmt_yd_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("			   #else" ).append("\n"); 
		query.append("			   AND  C.DMDT_CHG_STS_CD NOT IN ('D','N','U','I')" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${cond_type} == 'vvd_cd')" ).append("\n"); 
		query.append("				   #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("				   AND  B.VSL_CD     = SUBSTR(@[vvd_cd],1,4) " ).append("\n"); 
		query.append("				   AND  B.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4) " ).append("\n"); 
		query.append("				   AND  B.SKD_DIR_CD = SUBSTR(@[vvd_cd],9) " ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("				   #if (${pod_cd} != '' || ${pol_cd} != '')" ).append("\n"); 
		query.append("				   AND  (1=0" ).append("\n"); 
		query.append("						#if (${pod_cd} != '')" ).append("\n"); 
		query.append("						OR  B.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${pol_cd} != '')" ).append("\n"); 
		query.append("						OR  B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   #if (${dem_type} == 'I') " ).append("\n"); 
		query.append("				   AND ((C.DMDT_TRF_CD='DMIF' AND C.TO_MVMT_STS_CD NOT IN ('ID','CS','DR'))" ).append("\n"); 
		query.append("						OR (C.DMDT_TRF_CD='DMOF' AND C.DMDT_CHG_LOC_DIV_CD='POL')" ).append("\n"); 
		query.append("						OR (C.DMDT_TRF_CD IN ('CTOC','CTIC','DTOC','DTIC'))" ).append("\n"); 
		query.append("					   )" ).append("\n"); 
		query.append("				   #elseif (${dem_type} == 'L') " ).append("\n"); 
		query.append("				   AND ((C.DMDT_TRF_CD='DMIF' AND C.TO_MVMT_STS_CD='ID')" ).append("\n"); 
		query.append("						OR (C.DMDT_TRF_CD='DMOF' AND C.DMDT_CHG_LOC_DIV_CD<>'POL')" ).append("\n"); 
		query.append("						OR (C.DMDT_TRF_CD IN ('CTOC','CTIC','DTOC','DTIC'))" ).append("\n"); 
		query.append("					   )" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${cond_type} == 'cntr')" ).append("\n"); 
		query.append("				   #if (${bkg_no} != '')	" ).append("\n"); 
		query.append("				   AND B.BKG_NO IN (" ).append("\n"); 
		query.append("						#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("							#if($velocityCount < $bkg_no_list.size()) '$bkg_cd', #else '$bkg_cd' #end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   #if (${bl_no} != '')" ).append("\n"); 
		query.append("				   AND B.BL_NO IN (" ).append("\n"); 
		query.append("						#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("							#if($velocityCount < $bl_no_list.size()) '$bl_cd', #else '$bl_cd' #end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   #if (${cntr_no} != '')" ).append("\n"); 
		query.append("				   AND C.CNTR_NO IN (" ).append("\n"); 
		query.append("						#foreach( $cntr_cd in ${cntr_no_list} )" ).append("\n"); 
		query.append("							#if($velocityCount < $cntr_no_list.size()) '$cntr_cd', #else '$cntr_cd' #end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${cust_cd} != '')" ).append("\n"); 
		query.append("				   #if (${cust_type} == '')" ).append("\n"); 
		query.append("				   AND  (" ).append("\n"); 
		query.append("								C.ACT_CNT_CD	= SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("							AND C.ACT_CUST_SEQ	= LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("						OR		BS.CUST_CNT_CD	= SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("							AND BS.CUST_SEQ		= LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("						OR		BC.CUST_CNT_CD	= SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("							AND BC.CUST_SEQ		= LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("						OR 		BN.CUST_CNT_CD	= SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("							AND BN.CUST_SEQ		= LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("						OR (" ).append("\n"); 
		query.append("							EXISTS (" ).append("\n"); 
		query.append("								SELECT  'X'" ).append("\n"); 
		query.append("								  FROM  INV_AR_MN I" ).append("\n"); 
		query.append("								 WHERE  I.BKG_NO	= B.BKG_NO" ).append("\n"); 
		query.append("								   AND  I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("								   AND  AR_IF_NO	= " ).append("\n"); 
		query.append("										(" ).append("\n"); 
		query.append("											SELECT  MAX(AR_IF_NO) " ).append("\n"); 
		query.append("											  FROM  INV_AR_MN" ).append("\n"); 
		query.append("											 WHERE  BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("											   AND  IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("								   AND  ROWNUM  = 1" ).append("\n"); 
		query.append("								   AND  I.ACT_CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("								   AND  I.ACT_CUST_SEQ    = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("						    )" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				   #elseif (${cust_type} == 'P')" ).append("\n"); 
		query.append("				   AND C.ACT_CNT_CD   = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("				   AND C.ACT_CUST_SEQ = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("				   #elseif (${cust_type} == 'S') " ).append("\n"); 
		query.append("				   AND  BS.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("				   AND  BS.CUST_SEQ    = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("				   #elseif (${cust_type} == 'C') " ).append("\n"); 
		query.append("				   AND  BC.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("				   AND  BC.CUST_SEQ    = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("				   #elseif (${cust_type} == 'N') " ).append("\n"); 
		query.append("				   AND  BN.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("				   AND  BN.CUST_SEQ    = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("				   #elseif (${cust_type} == 'A')		" ).append("\n"); 
		query.append("				   AND  EXISTS " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							SELECT  'X'" ).append("\n"); 
		query.append("							  FROM  INV_AR_MN I" ).append("\n"); 
		query.append("							 WHERE  I.BKG_NO	= B.BKG_NO" ).append("\n"); 
		query.append("							   AND  I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("							   AND  AR_IF_NO	= " ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("										SELECT  MAX(AR_IF_NO) " ).append("\n"); 
		query.append("										  FROM  INV_AR_MN" ).append("\n"); 
		query.append("										 WHERE  BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("										   AND  IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("							   AND  ROWNUM  = 1" ).append("\n"); 
		query.append("							   AND  I.ACT_CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("							   AND  I.ACT_CUST_SEQ    = LTRIM(SUBSTR(@[cust_cd],3),'0')" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${svc_provdr} != '') " ).append("\n"); 
		query.append("			   AND  C.VNDR_SEQ = LTRIM(@[svc_provdr],'0')" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${sc_no} != '') " ).append("\n"); 
		query.append("			   AND  B.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${rfa_no} != '') " ).append("\n"); 
		query.append("			   AND  B.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${inact_no} != '')" ).append("\n"); 
		query.append("			   AND  EXISTS " ).append("\n"); 
		query.append("					( " ).append("\n"); 
		query.append("						SELECT  'X' " ).append("\n"); 
		query.append("						  FROM  DMT_CHG_DELT_RQST_APRO" ).append("\n"); 
		query.append("					     WHERE  1=1" ).append("\n"); 
		query.append("						   AND  INACT_RQST_NO IN (" ).append("\n"); 
		query.append("							#foreach( $inact_no in ${inact_no_list} )" ).append("\n"); 
		query.append("								#if($velocityCount < $inact_no_list.size()) '$inact_no', #else '$inact_no' #end" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						   AND  SYS_AREA_GRP_ID     = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  CNTR_NO             = C.CNTR_NO" ).append("\n"); 
		query.append("						   AND  CNTR_CYC_NO         = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND  DMDT_TRF_CD         = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND  DMDT_CHG_LOC_DIV_CD = C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND  CHG_SEQ             = C.CHG_SEQ" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			ORDER BY B.CNTR_NO" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("   #if (${inact_sts_cd} != '')" ).append("\n"); 
		query.append("   AND  A.DMDT_DELT_RQST_STS_CD IN (" ).append("\n"); 
		query.append("		#foreach( $inact_sts_cd in ${inact_sts_cd_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $inact_sts_cd_list.size()) '$inact_sts_cd', #else '$inact_sts_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--// 2016.07.12 - DAR NO, DAR STATUS CODE 요청에 의해 추가" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${aft_dar_sts_cd_list} != '')" ).append("\n"); 
		query.append("	   #if (${aft_dar_sts_all_flg} != '')" ).append("\n"); 
		query.append("	   AND  (DMDT_EXPT_RQST_STS_CD IS NOT NULL AND DMDT_EXPT_RQST_STS_CD <>'T')" ).append("\n"); 
		query.append("	   #else" ).append("\n"); 
		query.append("	   AND ( 1=0" ).append("\n"); 
		query.append("				#if (${aft_dar_sts_process_flg} != '')" ).append("\n"); 
		query.append("				OR DMDT_EXPT_RQST_STS_CD NOT IN ('A', 'R', 'J', 'O', 'T')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				OR DMDT_EXPT_RQST_STS_CD IN (" ).append("\n"); 
		query.append("				#foreach($aft_dar_sts_cd in ${aft_dar_sts_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $aft_dar_sts_cd_list.size())" ).append("\n"); 
		query.append("						'$aft_dar_sts_cd', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$aft_dar_sts_cd' " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("	   #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--// 2016.07.12 END" ).append("\n"); 

	}
}