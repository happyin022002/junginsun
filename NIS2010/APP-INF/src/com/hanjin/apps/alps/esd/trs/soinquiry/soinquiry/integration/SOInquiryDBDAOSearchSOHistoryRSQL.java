/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SOInquiryDBDAOSearchSOHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SOInquiryDBDAOSearchSOHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (CY/Door 건) SO History를 조회한다.
	  * </pre>
	  */
	public SOInquiryDBDAOSearchSOHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sonumber",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.integration").append("\n"); 
		query.append("FileName : SOInquiryDBDAOSearchSOHistoryRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM SEQ" ).append("\n"); 
		query.append("      ,TRSP_SO_OFC_CTY_CD||TRSP_SO_SEQ SO_NO" ).append("\n"); 
		query.append("      ,(SELECT D.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL D WHERE D.INTG_CD_ID = 'CD02852' AND D.INTG_CD_VAL_CTNT = X.TRSP_SO_EVNT_CD) EVENT" ).append("\n"); 
		query.append("      ,TO_CHAR(LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') LOCL_CRE_DT" ).append("\n"); 
		query.append("	  ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,EQ_NO " ).append("\n"); 
		query.append("	  ,BKG_NO" ).append("\n"); 
		query.append("	  ,TRSP_WO_OFC_CTY_CD||TRSP_WO_SEQ WO_NO" ).append("\n"); 
		query.append("      ,INV_NO " ).append("\n"); 
		query.append("      ,INV_VNDR_SEQ " ).append("\n"); 
		query.append("      ,TRSP_SO_STS_CD " ).append("\n"); 
		query.append("      ,SO_ROUT_DESC" ).append("\n"); 
		query.append("      ,ROUT_RPLN_FLG " ).append("\n"); 
		query.append("      ,COP_SO_STS_CD " ).append("\n"); 
		query.append("      ,COP_SO_ROUT_DESC " ).append("\n"); 
		query.append("      ,COP_NO " ).append("\n"); 
		query.append("      ,COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("      ,COST_ACT_GRP_CD " ).append("\n"); 
		query.append("      ,RPLN_UMCH_FLG " ).append("\n"); 
		query.append("      ,UPLN_SO_FLG " ).append("\n"); 
		query.append("      ,TRSP_SO_HIS_DESC		" ).append("\n"); 
		query.append("      ,CRE_USR_ID " ).append("\n"); 
		query.append("      ,CRE_OFC_CD" ).append("\n"); 
		query.append("      ,RQST_SRC_SYS_CD" ).append("\n"); 
		query.append("FROM   TRS_TRSP_SO_HIS X" ).append("\n"); 
		query.append("WHERE  TRSP_SO_OFC_CTY_CD = SUBSTR(@[sonumber],1,3)" ).append("\n"); 
		query.append("AND    TRSP_SO_SEQ = SUBSTR(@[sonumber],4)" ).append("\n"); 
		query.append("AND    (RQST_SRC_SYS_CD, TRSP_SO_EVNT_CD, NVL(ROUT_RPLN_FLG,'N')) NOT IN (('TRS','SC', 'Y'), ('TRS','SR', 'Y'))" ).append("\n"); 
		query.append("ORDER BY TRSP_HIS_SEQ" ).append("\n"); 

	}
}