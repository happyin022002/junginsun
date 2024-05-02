/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MonthlyQuotaStatusInquiryDBDAOSearchMonthlyQuotaStatusInquiry0153List01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaStatusInquiryDBDAOSearchMonthlyQuotaStatusInquiry0153List01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Process Status
	  * 2011.02.17 GLOBALDATE_PKG.TIME_CONV_OFC_FNC 수정
	  * </pre>
	  */
	public MonthlyQuotaStatusInquiryDBDAOSearchMonthlyQuotaStatusInquiry0153List01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("step",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaStatusInquiryDBDAOSearchMonthlyQuotaStatusInquiry0153List01RSQL").append("\n"); 
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
		query.append("WITH SEQ AS (										" ).append("\n"); 
		query.append("			     SELECT 									" ).append("\n"); 
		query.append("				     INTG_CD_VAL_CTNT,							" ).append("\n"); 
		query.append("				     INTG_CD_VAL_DP_SEQ 						" ).append("\n"); 
		query.append("			     FROM 									" ).append("\n"); 
		query.append("				     COM_INTG_CD_DTL							" ).append("\n"); 
		query.append("			     WHERE 									" ).append("\n"); 
		query.append("				     INTG_CD_ID='CD00926'						" ).append("\n"); 
		query.append("			     ORDER BY 									" ).append("\n"); 
		query.append("				     INTG_CD_VAL_DP_SEQ ) 						" ).append("\n"); 
		query.append("		    , STEP_CD AS (									" ).append("\n"); 
		query.append("			     SELECT 									" ).append("\n"); 
		query.append("				  INTG_CD_VAL_DP_SEQ  CODE, 						" ).append("\n"); 
		query.append("				  INTG_CD_VAL_DP_DESC  TEXT						" ).append("\n"); 
		query.append("			     FROM  									" ).append("\n"); 
		query.append("				  COM_INTG_CD_DTL                    					" ).append("\n"); 
		query.append("			     WHERE 									" ).append("\n"); 
		query.append("				  INTG_CD_ID = 'CD01214'                    				" ).append("\n"); 
		query.append("			     ORDER BY 									" ).append("\n"); 
		query.append("				  INTG_CD_VAL_DP_SEQ)   						" ).append("\n"); 
		query.append("		    , COM_FLAG AS ( 									" ).append("\n"); 
		query.append("				 SELECT  INTG_CD_VAL_DP_SEQ  CODE, 					" ).append("\n"); 
		query.append("					     INTG_CD_VAL_DP_DESC  TEXT					" ).append("\n"); 
		query.append("				 FROM  									" ).append("\n"); 
		query.append("					 COM_INTG_CD_DTL                    				" ).append("\n"); 
		query.append("				 WHERE 									" ).append("\n"); 
		query.append("					 INTG_CD_ID = 'CD01213'                    			" ).append("\n"); 
		query.append("				 ORDER 									" ).append("\n"); 
		query.append("					BY INTG_CD_VAL_DP_SEQ ) 					" ).append("\n"); 
		query.append("			, STP_DT AS (				" ).append("\n"); 
		query.append("    		 	 SELECT 				" ).append("\n"); 
		query.append("    		 		 MQTA_STEP_CD,			" ).append("\n"); 
		query.append("    		 		BSE_YR,			" ).append("\n"); 
		query.append("    		 		BSE_QTR_CD,			" ).append("\n"); 
		query.append("    		 		TRD_CD,			" ).append("\n"); 
		query.append("    		 		DIR_CD,			" ).append("\n"); 
		query.append("    		 		CRE_OFC_CD,			" ).append("\n"); 
		query.append("    		 		MQTA_VER_NO,			" ).append("\n"); 
		query.append("    		 		DRFT_CFM_GDT,			" ).append("\n"); 
		query.append("    		 		FNL_CFM_GDT			" ).append("\n"); 
		query.append("    		 	FROM SAQ_MON_QTA_STEP_VER )				" ).append("\n"); 
		query.append("		   	, TGT_GRP AS ( 										" ).append("\n"); 
		query.append("		   		SELECT								" ).append("\n"); 
		query.append("		  			TRD_CD,								" ).append("\n"); 
		query.append("		  		 	SAQ_TGT_GRP_CD								" ).append("\n"); 
		query.append("		  	    FROM									" ).append("\n"); 
		query.append("		    	 	SAQ_TGT_GRP_TRD_V  )									" ).append("\n"); 
		query.append("		    , UPD AS (										" ).append("\n"); 
		query.append("			     SELECT 									" ).append("\n"); 
		query.append("				     MQTA_STEP_CD,							" ).append("\n"); 
		query.append("				     BSE_YR,								" ).append("\n"); 
		query.append("				     BSE_QTR_CD,								" ).append("\n"); 
		query.append("				     TRD_CD,								" ).append("\n"); 
		query.append("				     DIR_CD,								" ).append("\n"); 
		query.append("				     SUBSTR(MQTA_VER_NO, 1,LENGTH(MQTA_VER_NO)-9) CRE_OFC_CD,		" ).append("\n"); 
		query.append("				     SUBSTR(MQTA_VER_NO, 1,LENGTH(MQTA_VER_NO)-2) MQTA_VER_GRP_NO,		" ).append("\n"); 
		query.append("				     MAX(UPD_DT) UPD_DT							" ).append("\n"); 
		query.append("			     FROM 									" ).append("\n"); 
		query.append("	   		 	 SAQ_MON_QTA_TRD 													" ).append("\n"); 
		query.append("			     GROUP BY 									" ).append("\n"); 
		query.append("				     MQTA_STEP_CD,							" ).append("\n"); 
		query.append("				     BSE_YR,								" ).append("\n"); 
		query.append("				     BSE_QTR_CD,								" ).append("\n"); 
		query.append("				     TRD_CD,								" ).append("\n"); 
		query.append("				     DIR_CD,								" ).append("\n"); 
		query.append("				     SUBSTR(MQTA_VER_NO, 1,LENGTH(MQTA_VER_NO)-9),			" ).append("\n"); 
		query.append("				     SUBSTR(MQTA_VER_NO, 1,LENGTH(MQTA_VER_NO)-2)			" ).append("\n"); 
		query.append("			     UNION ALL									" ).append("\n"); 
		query.append("			     SELECT 									" ).append("\n"); 
		query.append("				     MQTA_STEP_CD,							" ).append("\n"); 
		query.append("				     BSE_YR,								" ).append("\n"); 
		query.append("				     BSE_QTR_CD,								" ).append("\n"); 
		query.append("				     TRD_CD,								" ).append("\n"); 
		query.append("				     DIR_CD,								" ).append("\n"); 
		query.append("				     SUBSTR(MQTA_VER_NO, 1,LENGTH(MQTA_VER_NO)-9) CRE_OFC_CD,		" ).append("\n"); 
		query.append("				     SUBSTR(MQTA_VER_NO, 1,LENGTH(MQTA_VER_NO)-2) MQTA_VER_GRP_NO,		" ).append("\n"); 
		query.append("				     MAX(UPD_DT) UPD_DT							" ).append("\n"); 
		query.append("			     FROM 									" ).append("\n"); 
		query.append("				   SAQ_MON_QTA_RHQ							" ).append("\n"); 
		query.append("			     GROUP BY 									" ).append("\n"); 
		query.append("				     MQTA_STEP_CD,							" ).append("\n"); 
		query.append("				     BSE_YR,								" ).append("\n"); 
		query.append("				     BSE_QTR_CD,								" ).append("\n"); 
		query.append("				     TRD_CD,								" ).append("\n"); 
		query.append("				     DIR_CD,								" ).append("\n"); 
		query.append("				     SUBSTR(MQTA_VER_NO, 1,LENGTH(MQTA_VER_NO)-9),			" ).append("\n"); 
		query.append("				     SUBSTR(MQTA_VER_NO, 1,LENGTH(MQTA_VER_NO)-2)  			" ).append("\n"); 
		query.append("			     UNION ALL									" ).append("\n"); 
		query.append("			     SELECT 									" ).append("\n"); 
		query.append("				     MQTA_STEP_CD,							" ).append("\n"); 
		query.append("				     BSE_YR,								" ).append("\n"); 
		query.append("				     BSE_QTR_CD,								" ).append("\n"); 
		query.append("				     TRD_CD,								" ).append("\n"); 
		query.append("				     DIR_CD,								" ).append("\n"); 
		query.append("				     SUBSTR(MQTA_VER_NO, 1,LENGTH(MQTA_VER_NO)-9) CRE_OFC_CD,		" ).append("\n"); 
		query.append("				     SUBSTR(MQTA_VER_NO, 1,LENGTH(MQTA_VER_NO)-2) MQTA_VER_GRP_NO,		" ).append("\n"); 
		query.append("				     MAX(UPD_DT) UPD_DT							" ).append("\n"); 
		query.append("			     FROM 									" ).append("\n"); 
		query.append("				   SAQ_MON_QTA_LOD_TGT							" ).append("\n"); 
		query.append("			     GROUP BY 									" ).append("\n"); 
		query.append("				     MQTA_STEP_CD,							" ).append("\n"); 
		query.append("				     BSE_YR,								" ).append("\n"); 
		query.append("				     BSE_QTR_CD,								" ).append("\n"); 
		query.append("				     TRD_CD,								" ).append("\n"); 
		query.append("				     DIR_CD,								" ).append("\n"); 
		query.append("				     SUBSTR(MQTA_VER_NO, 1,LENGTH(MQTA_VER_NO)-9),			" ).append("\n"); 
		query.append("				     SUBSTR(MQTA_VER_NO, 1,LENGTH(MQTA_VER_NO)-2))  				" ).append("\n"); 
		query.append("		    , DATA AS										" ).append("\n"); 
		query.append("		    ( 											" ).append("\n"); 
		query.append("			    SELECT 									" ).append("\n"); 
		query.append("				CASE WHEN VER.MQTA_STEP_CD='01' THEN '1'				" ).append("\n"); 
		query.append("				    WHEN VER.MQTA_STEP_CD='02' THEN '2'					" ).append("\n"); 
		query.append("				    WHEN VER.MQTA_STEP_CD='03' THEN '3'          			" ).append("\n"); 
		query.append("				    WHEN VER.MQTA_STEP_CD='04' THEN '5' 				" ).append("\n"); 
		query.append("				    WHEN VER.MQTA_STEP_CD='08' THEN '9' 				" ).append("\n"); 
		query.append("				    WHEN VER.MQTA_STEP_CD='09' THEN '10' 					" ).append("\n"); 
		query.append("				END AS SEQ,								" ).append("\n"); 
		query.append("				VER.MQTA_STEP_CD,        						" ).append("\n"); 
		query.append("				VER.BSE_YR,								" ).append("\n"); 
		query.append("				VER.BSE_QTR_CD,								" ).append("\n"); 
		query.append("				VER.TRD_CD,								" ).append("\n"); 
		query.append("				VER.DIR_CD,								" ).append("\n"); 
		query.append("				VER.MQTA_VER_NO,							" ).append("\n"); 
		query.append("				VER.GLINE_VER_NO,							" ).append("\n"); 
		query.append("				VER.CRE_OFC_CD, 							" ).append("\n"); 
		query.append("				VER.SAQ_STS_CD,								" ).append("\n"); 
		query.append("				SEQ.INTG_CD_VAL_DP_SEQ STS_SEQ						" ).append("\n"); 
		query.append("			    FROM SAQ_MON_QTA_STEP_VER VER, SEQ						" ).append("\n"); 
		query.append("			    WHERE VER.MQTA_STEP_CD IN ('01','02','03','04','05','06', '08', '09' )			" ).append("\n"); 
		query.append("			    AND VER.SAQ_STS_CD <> 'XX'					" ).append("\n"); 
		query.append("			    AND SEQ.INTG_CD_VAL_CTNT = VER.SAQ_STS_CD					" ).append("\n"); 
		query.append("		            AND VER.BSE_YR = @[year]							" ).append("\n"); 
		query.append("		            AND VER.BSE_QTR_CD = @[quarter]							" ).append("\n"); 
		query.append("		            AND VER.TRD_CD LIKE @[trd_cd]||'%'							" ).append("\n"); 
		query.append("		            AND VER.DIR_CD LIKE @[dir_cd]||'%'            						" ).append("\n"); 
		query.append("													" ).append("\n"); 
		query.append("			    UNION ALL									" ).append("\n"); 
		query.append("			    										" ).append("\n"); 
		query.append("			    SELECT 									" ).append("\n"); 
		query.append("				CASE WHEN VER.MQTA_STEP_CD='02' THEN '4'				" ).append("\n"); 
		query.append("				END AS SEQ,								" ).append("\n"); 
		query.append("				VER.MQTA_STEP_CD,        						" ).append("\n"); 
		query.append("				VER.BSE_YR,								" ).append("\n"); 
		query.append("				VER.BSE_QTR_CD,								" ).append("\n"); 
		query.append("				VER.TRD_CD,								" ).append("\n"); 
		query.append("				VER.DIR_CD,								" ).append("\n"); 
		query.append("				VER.MQTA_VER_NO,							" ).append("\n"); 
		query.append("				VER.GLINE_VER_NO,							" ).append("\n"); 
		query.append("				VER.CRE_OFC_CD, 							" ).append("\n"); 
		query.append("				VER.SAQ_STS_CD,								" ).append("\n"); 
		query.append("				SEQ.INTG_CD_VAL_DP_SEQ STS_SEQ						" ).append("\n"); 
		query.append("		    											" ).append("\n"); 
		query.append("			    FROM SAQ_MON_QTA_STEP_VER VER, SEQ						" ).append("\n"); 
		query.append("			    WHERE VER.MQTA_STEP_CD IN ('02')					" ).append("\n"); 
		query.append("			    AND VER.SAQ_STS_CD <> 'XX'					" ).append("\n"); 
		query.append("			    AND SEQ.INTG_CD_VAL_DP_SEQ > 5						" ).append("\n"); 
		query.append("			    AND SEQ.INTG_CD_VAL_CTNT = VER.SAQ_STS_CD					" ).append("\n"); 
		query.append("		            AND VER.BSE_YR = @[year]							" ).append("\n"); 
		query.append("		            AND VER.BSE_QTR_CD = @[quarter]							" ).append("\n"); 
		query.append("		            AND VER.TRD_CD LIKE @[trd_cd]||'%'							" ).append("\n"); 
		query.append("		            AND VER.DIR_CD LIKE @[dir_cd]||'%'            						" ).append("\n"); 
		query.append("			    ) 										" ).append("\n"); 
		query.append("		    , MAX_STS AS (									" ).append("\n"); 
		query.append("			SELECT 										" ).append("\n"); 
		query.append("				SEQ,									" ).append("\n"); 
		query.append("				BSE_YR,									" ).append("\n"); 
		query.append("				BSE_QTR_CD,								" ).append("\n"); 
		query.append("				TRD_CD,									" ).append("\n"); 
		query.append("				DIR_CD,									" ).append("\n"); 
		query.append("				GLINE_VER_NO,								" ).append("\n"); 
		query.append("				CRE_OFC_CD,								" ).append("\n"); 
		query.append("				MAX(STS_SEQ) MAX_STS							" ).append("\n"); 
		query.append("			FROM 										" ).append("\n"); 
		query.append("				DATA									" ).append("\n"); 
		query.append("			GROUP BY 									" ).append("\n"); 
		query.append("				SEQ,									" ).append("\n"); 
		query.append("				BSE_YR,									" ).append("\n"); 
		query.append("				BSE_QTR_CD,								" ).append("\n"); 
		query.append("				TRD_CD,									" ).append("\n"); 
		query.append("				DIR_CD,									" ).append("\n"); 
		query.append("				GLINE_VER_NO,								" ).append("\n"); 
		query.append("				CRE_OFC_CD             							" ).append("\n"); 
		query.append("			    )										" ).append("\n"); 
		query.append("		    , MST AS (    									" ).append("\n"); 
		query.append("		     SELECT 										" ).append("\n"); 
		query.append("			DATA.SEQ,									" ).append("\n"); 
		query.append("			STEP_CD.TEXT STEP,								" ).append("\n"); 
		query.append("			CASE WHEN DATA.SEQ='1' AND STS_SEQ >3 THEN '1'          			" ).append("\n"); 
		query.append("			 WHEN DATA.SEQ='2' AND STS_SEQ >3 THEN '1' 					" ).append("\n"); 
		query.append("			 WHEN DATA.SEQ='3' AND STS_SEQ >7 THEN '1'  					" ).append("\n"); 
		query.append("			 WHEN DATA.SEQ='4' AND STS_SEQ >6 THEN '1'  					" ).append("\n"); 
		query.append("			 WHEN DATA.SEQ='5' AND STS_SEQ >3 THEN '1'  					" ).append("\n"); 
		query.append("			 WHEN DATA.SEQ='6' AND STS_SEQ >3 THEN '1'   					" ).append("\n"); 
		query.append("			 WHEN DATA.SEQ='7' AND STS_SEQ >7 THEN '1'   					" ).append("\n"); 
		query.append("			 WHEN DATA.SEQ='8' AND STS_SEQ >6 THEN '1' 					" ).append("\n"); 
		query.append("			 WHEN DATA.SEQ='9' AND STS_SEQ >3 THEN '1' 					" ).append("\n"); 
		query.append("			 WHEN DATA.SEQ='10' AND STS_SEQ >6 THEN '1' 						" ).append("\n"); 
		query.append("			 ELSE '2'    									" ).append("\n"); 
		query.append("			END AS COM_FLAG,       								" ).append("\n"); 
		query.append("			DATA.MQTA_STEP_CD,       							" ).append("\n"); 
		query.append("			DATA.BSE_YR,									" ).append("\n"); 
		query.append("			DATA.BSE_QTR_CD,									" ).append("\n"); 
		query.append("			DATA.TRD_CD,									" ).append("\n"); 
		query.append("			DATA.DIR_CD,									" ).append("\n"); 
		query.append("			DATA.CRE_OFC_CD,								" ).append("\n"); 
		query.append("			DATA.MQTA_VER_NO,								" ).append("\n"); 
		query.append("			DATA.GLINE_VER_NO,								" ).append("\n"); 
		query.append("			SUBSTR(DATA.MQTA_VER_NO, 1, LENGTH(DATA.MQTA_VER_NO)-2)              		" ).append("\n"); 
		query.append("			||'-'||SUBSTR(DATA.MQTA_VER_NO, LENGTH(DATA.MQTA_VER_NO)-1)      		" ).append("\n"); 
		query.append("			||DECODE(SAQ_STS_CD, '00', '','XX','', '-'||SAQ_STS_CD) VERSION,         	" ).append("\n"); 
		query.append("			DATA.STS_SEQ									" ).append("\n"); 
		query.append("													" ).append("\n"); 
		query.append("		FROM DATA, MAX_STS, STEP_CD								" ).append("\n"); 
		query.append("		WHERE 											" ).append("\n"); 
		query.append("			STEP_CD.CODE = DATA.SEQ								" ).append("\n"); 
		query.append("		       AND DATA.SEQ = MAX_STS.SEQ							" ).append("\n"); 
		query.append("		       AND DATA.BSE_YR = MAX_STS.BSE_YR							" ).append("\n"); 
		query.append("		       AND DATA.BSE_QTR_CD =MAX_STS.BSE_QTR_CD						" ).append("\n"); 
		query.append("		       AND DATA.TRD_CD = MAX_STS.TRD_CD							" ).append("\n"); 
		query.append("		       AND DATA.DIR_CD = MAX_STS.DIR_CD							" ).append("\n"); 
		query.append("		       AND DATA.CRE_OFC_CD = MAX_STS.CRE_OFC_CD						" ).append("\n"); 
		query.append("		       AND DATA.GLINE_VER_NO = MAX_STS.GLINE_VER_NO					" ).append("\n"); 
		query.append("		       AND DATA.STS_SEQ = MAX_STS.MAX_STS						" ).append("\n"); 
		query.append("		     )    										" ).append("\n"); 
		query.append("		    											" ).append("\n"); 
		query.append("		SELECT 											" ).append("\n"); 
		query.append("			CASE WHEN FDATA.SEQ IN ( '9', '10' ) THEN 'Load Target'										" ).append("\n"); 
		query.append("			ELSE 'Sales Quota'										" ).append("\n"); 
		query.append("			END AS STAGE,										" ).append("\n"); 
		query.append("			CASE WHEN FDATA.SEQ IN ( '9', '10' ) THEN TO_CHAR(TO_NUMBER(FDATA.SEQ)-8)										" ).append("\n"); 
		query.append("			ELSE FDATA.SEQ										" ).append("\n"); 
		query.append("			END AS SEQ,											" ).append("\n"); 
		query.append("		    FDATA.STEP,	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${grp_flg} == '1') " ).append("\n"); 
		query.append("		    FDATA.TRD_GRP_STATUS GRP_STATUS,							" ).append("\n"); 
		query.append("		    TGT_GRP.SAQ_TGT_GRP_CD FILTER1,								" ).append("\n"); 
		query.append("		    FDATA.TRD_CD FILTER2,								" ).append("\n"); 
		query.append("		    FDATA.DIR_CD FILTER3,								" ).append("\n"); 
		query.append("		    FDATA.CRE_OFC_CD FILTER4,								" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		    FDATA.ORG_GRP_STATUS GRP_STATUS,							" ).append("\n"); 
		query.append("		    FDATA.CRE_OFC_CD FILTER1,     							" ).append("\n"); 
		query.append("		    TGT_GRP.SAQ_TGT_GRP_CD FILTER2,								" ).append("\n"); 
		query.append("		    FDATA.TRD_CD FILTER3,								" ).append("\n"); 
		query.append("		    FDATA.DIR_CD FILTER4,								" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		    FDATA.PR_OFC_CD, 									" ).append("\n"); 
		query.append("		    FDATA.SUB_OFC_CD, 									" ).append("\n"); 
		query.append("		    FDATA.VERSION, 									" ).append("\n"); 
		query.append("		    CASE WHEN FDATA.VERSION IS NULL THEN 									" ).append("\n"); 
		query.append("		   		TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC() ,UPD.UPD_DT, @[ofc_cd] ),'yyyy/mm/dd hh24:mi') 									" ).append("\n"); 
		query.append("		    ELSE 									" ).append("\n"); 
		query.append("		    	TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT', 									" ).append("\n"); 
		query.append("		   			 CASE WHEN FDATA.SEQ IN  ('1','2','6','8') THEN STP_DT.DRFT_CFM_GDT  									" ).append("\n"); 
		query.append("		    		 ELSE STP_DT.FNL_CFM_GDT 									" ).append("\n"); 
		query.append("		    		 END 									" ).append("\n"); 
		query.append("		    		 , @[ofc_cd] ),'yyyy/mm/dd hh24:mi') 									" ).append("\n"); 
		query.append("		    		 END AS UPD_DT, 									" ).append("\n"); 
		query.append("		    FDATA.BSE_YR,									" ).append("\n"); 
		query.append("		    FDATA.BSE_QTR_CD,									" ).append("\n"); 
		query.append("		    FDATA.MQTA_VER_GRP_NO MQTA_VER_NO,									" ).append("\n"); 
		query.append("		    FDATA.STATUS   									" ).append("\n"); 
		query.append("		    											" ).append("\n"); 
		query.append("		    											" ).append("\n"); 
		query.append("		FROM	 										" ).append("\n"); 
		query.append("		    (   										" ).append("\n"); 
		query.append("		    SELECT DISTINCT									" ).append("\n"); 
		query.append("			MST.SEQ,									" ).append("\n"); 
		query.append("			MST.STEP,           								" ).append("\n"); 
		query.append("			FLG.TEXT STATUS,								" ).append("\n"); 
		query.append("    #if (${grp_flg} == '1') " ).append("\n"); 
		query.append("		    CASE WHEN TRD_GRP_COM.MX_FLG='1' THEN 'Completed'				" ).append("\n"); 
		query.append("		    ELSE 'In Progress'								" ).append("\n"); 
		query.append("		    END AS  TRD_GRP_STATUS, 							" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("			CASE WHEN ORG_GRP_COM.MX_FLG='1' THEN 'Completed'				" ).append("\n"); 
		query.append("			ELSE 'In Progress'								" ).append("\n"); 
		query.append("			END AS  ORG_GRP_STATUS, 							" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			MST.COM_FLAG,									" ).append("\n"); 
		query.append("			MST.MQTA_STEP_CD,								" ).append("\n"); 
		query.append("			MST.BSE_YR,									" ).append("\n"); 
		query.append("			MST.BSE_QTR_CD,									" ).append("\n"); 
		query.append("			MST.TRD_CD,									" ).append("\n"); 
		query.append("			MST.DIR_CD,									" ).append("\n"); 
		query.append("			CASE WHEN MST.SEQ IN ('6','8','10' ) THEN NVL(PRNT.N2ND_PRNT_OFC_CD,'UNKNOWN')||' / '||MST.CRE_OFC_CD									" ).append("\n"); 
		query.append("    		ELSE MST.CRE_OFC_CD									" ).append("\n"); 
		query.append("    		END AS CRE_OFC_CD,									" ).append("\n"); 
		query.append("    		PRNT.N2ND_PRNT_OFC_CD PR_OFC_CD,									" ).append("\n"); 
		query.append("    		MST.CRE_OFC_CD SUB_OFC_CD,									" ).append("\n"); 
		query.append("			MST.GLINE_VER_NO,								" ).append("\n"); 
		query.append("			SUBSTR(MST.MQTA_VER_NO, 1,LENGTH(MST.MQTA_VER_NO)-2) MQTA_VER_GRP_NO,								" ).append("\n"); 
		query.append("			CASE WHEN MST.STS_SEQ < 3 THEN ''						" ).append("\n"); 
		query.append("			ELSE MST.VERSION								" ).append("\n"); 
		query.append("			END AS VERSION									" ).append("\n"); 
		query.append("													" ).append("\n"); 
		query.append("			   										" ).append("\n"); 
		query.append("		    FROM 										" ).append("\n"); 
		query.append("			MST, COM_FLAG FLG, MAX_STS,	SAQ_ORGANIZATION_V PRNT,						" ).append("\n"); 
		query.append("    #if (${grp_flg} == '1') " ).append("\n"); 
		query.append("		        (										" ).append("\n"); 
		query.append("		        SELECT SEQ, BSE_YR,BSE_QTR_CD,TRD_CD,DIR_CD,MAX(COM_FLAG) MX_FLG			" ).append("\n"); 
		query.append("		        FROM MST									" ).append("\n"); 
		query.append("		        GROUP BY SEQ, BSE_YR,BSE_QTR_CD,TRD_CD,DIR_CD					" ).append("\n"); 
		query.append("		        ) TRD_GRP_COM									" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("			    (										" ).append("\n"); 
		query.append("			    SELECT SEQ, BSE_YR,BSE_QTR_CD,CRE_OFC_CD,MAX(COM_FLAG) MX_FLG			" ).append("\n"); 
		query.append("			    FROM MST									" ).append("\n"); 
		query.append("			    GROUP BY SEQ, BSE_YR,BSE_QTR_CD,CRE_OFC_CD						" ).append("\n"); 
		query.append("			    ) ORG_GRP_COM									" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("													" ).append("\n"); 
		query.append("		    WHERE 										" ).append("\n"); 
		query.append("			MST.COM_FLAG = FLG.CODE 							" ).append("\n"); 
		query.append("	#if(${grp_flg} == '1') " ).append("\n"); 
		query.append("		    AND TRD_GRP_COM.SEQ = MST.SEQ  							" ).append("\n"); 
		query.append("		    AND TRD_GRP_COM.BSE_YR = MST.BSE_YR						" ).append("\n"); 
		query.append("		    AND TRD_GRP_COM.BSE_QTR_CD = MST.BSE_QTR_CD						" ).append("\n"); 
		query.append("		    AND TRD_GRP_COM.TRD_CD = MST.TRD_CD						" ).append("\n"); 
		query.append("		    AND TRD_GRP_COM.DIR_CD = MST.DIR_CD						" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		    AND ORG_GRP_COM.SEQ = MST.SEQ  							" ).append("\n"); 
		query.append("		    AND ORG_GRP_COM.BSE_YR = MST.BSE_YR							" ).append("\n"); 
		query.append("		    AND ORG_GRP_COM.BSE_QTR_CD = MST.BSE_QTR_CD						" ).append("\n"); 
		query.append("		    AND ORG_GRP_COM.CRE_OFC_CD = MST.CRE_OFC_CD						" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		    AND MST.SEQ  = MAX_STS.SEQ								" ).append("\n"); 
		query.append("		    AND MST.BSE_YR  = MAX_STS.BSE_YR							" ).append("\n"); 
		query.append("		    AND MST.BSE_QTR_CD  = MAX_STS.BSE_QTR_CD							" ).append("\n"); 
		query.append("		    AND MST.TRD_CD  = MAX_STS.TRD_CD							" ).append("\n"); 
		query.append("		    AND MST.DIR_CD  = MAX_STS.DIR_CD							" ).append("\n"); 
		query.append("		    AND MST.CRE_OFC_CD  = MAX_STS.CRE_OFC_CD						" ).append("\n"); 
		query.append("		    AND MST.GLINE_VER_NO  = MAX_STS.GLINE_VER_NO					" ).append("\n"); 
		query.append("		    AND MST.STS_SEQ = MAX_STS.MAX_STS							" ).append("\n"); 
		query.append("		    AND PRNT.OFC_CD = MST.CRE_OFC_CD(+)							" ).append("\n"); 
		query.append("													" ).append("\n"); 
		query.append("		    ) FDATA, UPD, STP_DT, TGT_GRP    									" ).append("\n"); 
		query.append("		    											" ).append("\n"); 
		query.append("		WHERE 											" ).append("\n"); 
		query.append("			   UPD.MQTA_STEP_CD(+) = FDATA.MQTA_STEP_CD					" ).append("\n"); 
		query.append("		    AND UPD.BSE_YR(+) = FDATA.BSE_YR							" ).append("\n"); 
		query.append("		    AND UPD.BSE_QTR_CD(+) = FDATA.BSE_QTR_CD							" ).append("\n"); 
		query.append("		    AND UPD.TRD_CD(+) = FDATA.TRD_CD							" ).append("\n"); 
		query.append("		    AND UPD.DIR_CD(+) = FDATA.DIR_CD							" ).append("\n"); 
		query.append("		    AND UPD.MQTA_VER_GRP_NO(+) = FDATA.MQTA_VER_GRP_NO	" ).append("\n"); 
		query.append("		    AND STP_DT.MQTA_STEP_CD(+) = FDATA.MQTA_STEP_CD							" ).append("\n"); 
		query.append("		    AND STP_DT.BSE_YR(+) = FDATA.BSE_YR							" ).append("\n"); 
		query.append("		    AND STP_DT.BSE_QTR_CD(+) = FDATA.BSE_QTR_CD							" ).append("\n"); 
		query.append("		    AND STP_DT.TRD_CD(+) = FDATA.TRD_CD							" ).append("\n"); 
		query.append("		    AND STP_DT.DIR_CD(+) = FDATA.DIR_CD							" ).append("\n"); 
		query.append("		    AND STP_DT.MQTA_VER_NO(+) = SUBSTR(FDATA.VERSION, 1,LENGTH(FDATA.VERSION)-6)||SUBSTR(FDATA.VERSION, LENGTH(FDATA.VERSION)-4,2)							" ).append("\n"); 
		query.append("		    AND TGT_GRP.TRD_CD = FDATA.TRD_CD		" ).append("\n"); 
		query.append("	#if(${step} != '0') 	    " ).append("\n"); 
		query.append("		 	AND FDATA.SEQ = @[step]										" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if(${sts} != '0') 	    " ).append("\n"); 
		query.append("		 	AND FDATA.COM_FLAG = @[sts]											" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		ORDER BY 										" ).append("\n"); 
		query.append("		    STAGE DESC,										" ).append("\n"); 
		query.append("		    SEQ,										" ).append("\n"); 
		query.append("			GRP_STATUS,	" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("    #if(${grp_flg} == '1') " ).append("\n"); 
		query.append("				FILTER1,									" ).append("\n"); 
		query.append("				FILTER2,									" ).append("\n"); 
		query.append("				FILTER3,									" ).append("\n"); 
		query.append("				STATUS DESC,									" ).append("\n"); 
		query.append("				FILTER4,									" ).append("\n"); 
		query.append("				PR_OFC_CD,									" ).append("\n"); 
		query.append("				SUB_OFC_CD,									" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("				PR_OFC_CD,									" ).append("\n"); 
		query.append("				SUB_OFC_CD,											" ).append("\n"); 
		query.append("				STATUS DESC,											" ).append("\n"); 
		query.append("				FILTER1,									" ).append("\n"); 
		query.append("				FILTER2,									" ).append("\n"); 
		query.append("				FILTER3,									" ).append("\n"); 
		query.append("				FILTER4,											" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			VERSION,									" ).append("\n"); 
		query.append("			UPD_DT" ).append("\n"); 

	}
}