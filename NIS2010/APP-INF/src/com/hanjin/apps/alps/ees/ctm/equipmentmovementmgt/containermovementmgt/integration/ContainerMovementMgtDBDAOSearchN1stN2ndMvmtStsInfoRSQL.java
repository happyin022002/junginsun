/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchN1stN2ndMvmtStsInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchN1stN2ndMvmtStsInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ContainerMovementMgtDBDAOSearchN1stN2ndMvmtStsInfoRSQL
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchN1stN2ndMvmtStsInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchN1stN2ndMvmtStsInfoRSQL").append("\n"); 
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
		query.append("SELECT  /*+ INDEX_DESC( T1 XUK1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("        T1.CNTR_NO" ).append("\n"); 
		query.append("       ,T1.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("       ,T1.ORG_YD_CD" ).append("\n"); 
		query.append("       ,RTRIM(T1.DEST_YD_CD) 						AS DESC_YD_CD" ).append("\n"); 
		query.append("       ,T1.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("       ,T1.CNMV_LVL_NO" ).append("\n"); 
		query.append("       ,T1.TRNK_VSL_CD" ).append("\n"); 
		query.append("       ,T1.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("       ,T1.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("       ,T1.OB_CNTR_FLG" ).append("\n"); 
		query.append("       ,T1.FCNTR_FLG" ).append("\n"); 
		query.append("       ,T1.CNTR_SEAL_NO" ).append("\n"); 
		query.append("       ,TO_CHAR(T1.CNMV_EVNT_DT, 'YYYYMMDD') 		AS CNTR_EVNT_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,T1.BKG_NO" ).append("\n"); 
		query.append("       ,T1.BKG_KNT" ).append("\n"); 
		query.append("       ,TO_CHAR(T1.CNMV_EVNT_DT, 'YYYYMMDD')        AS EVNT_DT" ).append("\n"); 
		query.append("       ,'' 											AS CM_MSG_ID" ).append("\n"); 
		query.append("       ,T1.SYS_AREA_GRP_ID 							AS CNTR_SVR_ID" ).append("\n"); 
		query.append("       ,T1.CNTR_ACT_CD 								AS ACIAC_DIV_CD" ).append("\n"); 
		query.append("       ,T1.MVMT_CRE_TP_CD" ).append("\n"); 
		query.append("       ,T1.BL_NO" ).append("\n"); 
		query.append("       ,T1.CNMV_YR" ).append("\n"); 
		query.append("       ,T1.CNMV_ID_NO" ).append("\n"); 
		query.append("       ,T1.CNMV_SEQ" ).append("\n"); 
		query.append("       ,T1.MVMT_INP_TP_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(T1.CNMV_EVNT_DT, 'YYYYMMDDHH24MI') 	AS CNMV_EVNT_DT" ).append("\n"); 
		query.append("       ,T1.DEST_YD_CD" ).append("\n"); 
		query.append("       ,T1.CRNT_VSL_CD" ).append("\n"); 
		query.append("       ,T1.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("       ,T1.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("       ,'' 											AS NEW_FLG" ).append("\n"); 
		query.append("       ,T1.UPD_USR_ID" ).append("\n"); 
		query.append("       ,T1.IMDT_EXT_FLG" ).append("\n"); 
		query.append("       ,T1.CNTR_RFUB_FLG" ).append("\n"); 
		query.append("       ,T1.CNTR_HNGR_RCK_FLG" ).append("\n"); 
		query.append("       ,T1.CNTR_DMG_FLG" ).append("\n"); 
		query.append("       ,T1.CNTR_DISP_FLG" ).append("\n"); 
		query.append("       ,T1.CNTR_ACT_CD" ).append("\n"); 
		query.append("       ,T1.PRE_STS_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,'Y' 										AS CTM_UI_YN" ).append("\n"); 
		query.append("	   ,T1.CNMV_CYC_NO" ).append("\n"); 
		query.append("	   ,T2.CNMV_CYC_NO  							AS N2ND_CNMV_CYC_NO" ).append("\n"); 
		query.append("	   ,T1.MVMT_STS_CD" ).append("\n"); 
		query.append("	   ,T2.MVMT_STS_CD  							AS N2ND_MVMT_STS_CD" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  FROM  CTM_MOVEMENT  T1		--// 1번째 MVMT STS" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("			SELECT  *" ).append("\n"); 
		query.append("			  FROM  (" ).append("\n"); 
		query.append("						SELECT  /*+ INDEX_DESC( CTM_MOVEMENT XUK1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("								CNTR_NO" ).append("\n"); 
		query.append("							   ,CNMV_CYC_NO" ).append("\n"); 
		query.append("							   ,MVMT_STS_CD" ).append("\n"); 
		query.append("							   ,ROWNUM       AS RNUM" ).append("\n"); 
		query.append("						  FROM  CTM_MOVEMENT" ).append("\n"); 
		query.append("						 WHERE  CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("						   AND  ROWNUM <= 2" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			 WHERE  RNUM = 2" ).append("\n"); 
		query.append("	    ) T2					--// 2번째 MVMT STS" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append(" WHERE  T1.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND  ROWNUM = 1" ).append("\n"); 

	}
}