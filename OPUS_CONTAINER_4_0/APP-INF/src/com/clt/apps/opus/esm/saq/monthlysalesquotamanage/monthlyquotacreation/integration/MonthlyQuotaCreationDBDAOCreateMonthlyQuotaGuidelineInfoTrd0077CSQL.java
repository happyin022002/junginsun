/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOCreateMonthlyQuotaGuidelineInfoTrd0077CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.02.24 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCreationDBDAOCreateMonthlyQuotaGuidelineInfoTrd0077CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * guideline data 생성 2. saq_mon_qta_gline_trd insert
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOCreateMonthlyQuotaGuidelineInfoTrd0077CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("userId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOCreateMonthlyQuotaGuidelineInfoTrd0077CSQL").append("\n"); 
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
		query.append("-- 2. SAQ_MON_QTA_GLINE_TRD INSERT                                                 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT INTO SAQ_MON_QTA_GLINE_TRD (                           " ).append("\n"); 
		query.append("  BSE_YR          ,                                           " ).append("\n"); 
		query.append("  BSE_QTR_CD         ,                                           " ).append("\n"); 
		query.append("  SAQ_TGT_GRP_CD  ,                                           " ).append("\n"); 
		query.append("  GLINE_VER_NO    ,                                           " ).append("\n"); 
		query.append("  TRD_CD          ,                                           " ).append("\n"); 
		query.append("  DIR_CD          ,                                           " ).append("\n"); 
		query.append("  BSE_MON         ,                                           " ).append("\n"); 
		query.append("  LOD_QTY         ,                                           " ).append("\n"); 
		query.append("  GRS_REV         ,                                           " ).append("\n"); 
		query.append("  CM_AMT          ,                                           " ).append("\n"); 
		query.append("  OPFIT_AMT       ,                                           " ).append("\n"); 
		query.append("  CRE_USR_ID      ,                                           " ).append("\n"); 
		query.append("  CRE_DT          ,                                           " ).append("\n"); 
		query.append("  UPD_USR_ID      ,                                           " ).append("\n"); 
		query.append("  UPD_DT          )                                           " ).append("\n"); 
		query.append("SELECT                                                        " ).append("\n"); 
		query.append("  D.BSE_YR          ,                                         " ).append("\n"); 
		query.append("  D.BSE_QTR_CD         ,                                         " ).append("\n"); 
		query.append("  C.SAQ_TGT_GRP_CD  ,                                         " ).append("\n"); 
		query.append("  (SELECT MAX(GLINE_VER_NO)                                   " ).append("\n"); 
		query.append("     FROM SAQ_MON_QTA_GLINE_VER                               " ).append("\n"); 
		query.append("     WHERE BSE_YR = D.BSE_YR                                  " ).append("\n"); 
		query.append("     AND BSE_QTR_CD = D.BSE_QTR_CD                                  " ).append("\n"); 
		query.append("     AND SAQ_TGT_GRP_CD = C.SAQ_TGT_GRP_CD                    " ).append("\n"); 
		query.append("     AND CRE_OFC_CD = C.OFC_CD),                              " ).append("\n"); 
		query.append("  A.TRD_CD          ,                                         " ).append("\n"); 
		query.append("  A.DIR_CD          ,                                         " ).append("\n"); 
		query.append("  A.BSE_MON         ,                                         " ).append("\n"); 
		query.append("  SUM(LOD_QTY)      ,                                         " ).append("\n"); 
		query.append("  SUM(GRS_RPB_REV * LOD_QTY) ,                                " ).append("\n"); 
		query.append("  SUM(GRS_RPB_REV * LOD_QTY) - SUM(CM_UC_AMT * LOD_QTY) ,     " ).append("\n"); 
		query.append("  SUM(GRS_RPB_REV * LOD_QTY) - SUM(OPFIT_UC_AMT * LOD_QTY) ,  " ).append("\n"); 
		query.append("  @[userId] ,                                         " ).append("\n"); 
		query.append("  SYSDATE ,                                         " ).append("\n"); 
		query.append("  @[userId] ,                                         " ).append("\n"); 
		query.append("  SYSDATE                                                     " ).append("\n"); 
		query.append("FROM SAQ_MON_MDL_CTRT_SMRY A,                             " ).append("\n"); 
		query.append("     SAQ_TGT_GRP_TRD_V B,                                     " ).append("\n"); 
		query.append("     SAQ_TGT_GRP C,                                           " ).append("\n"); 
		query.append("     SAQ_MON_QTA_MDL_EXE D                                    " ).append("\n"); 
		query.append("WHERE B.TRD_CD = A.TRD_CD                                     " ).append("\n"); 
		query.append("AND   C.SAQ_TGT_GRP_CD = B.SAQ_TGT_GRP_CD                     " ).append("\n"); 
		query.append("AND   D.MQTA_MDL_VER_NO = A.MQTA_MDL_VER_NO                   " ).append("\n"); 
		query.append("AND   A.MQTA_MDL_VER_NO = @[version]                                   " ).append("\n"); 
		query.append("GROUP BY                                                      " ).append("\n"); 
		query.append("  D.BSE_YR          ,                                         " ).append("\n"); 
		query.append("  D.BSE_QTR_CD         ,                                         " ).append("\n"); 
		query.append("  C.SAQ_TGT_GRP_CD  ,                                         " ).append("\n"); 
		query.append("  C.OFC_CD          ,                                         " ).append("\n"); 
		query.append("  A.TRD_CD          ,                                         " ).append("\n"); 
		query.append("  A.DIR_CD          ,                                         " ).append("\n"); 
		query.append("  A.BSE_MON" ).append("\n"); 

	}
}