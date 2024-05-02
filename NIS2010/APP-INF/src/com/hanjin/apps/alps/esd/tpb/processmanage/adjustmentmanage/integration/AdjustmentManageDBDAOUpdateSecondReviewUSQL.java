/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AdjustmentManageDBDAOUpdateSecondReviewUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentManageDBDAOUpdateSecondReviewUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [각R1~R4를 처리한 후 2nd Review를 위해 COPY]
	  * 2-1.<FOR R3>R2:[재차:ADJ_N2ND_RVW_SEQ>1] ROC-IN  RHQ에서    REJECT(Reject As Forward) 매 처리시 처리 내용을 UPDATE
	  * 3-1.<FOR R4>R3:[재차:ADJ_N2ND_RVW_SEQ>1] ROC-OUT RHQ에서    ACCEPT(Approval As Forward) 매 처리시 처리 내용을 UPDATE
	  * </pre>
	  */
	public AdjustmentManageDBDAOUpdateSecondReviewUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_sts_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration").append("\n"); 
		query.append("FileName : AdjustmentManageDBDAOUpdateSecondReviewUSQL").append("\n"); 
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
		query.append("UPDATE   TPB_ADJ_N2ND_RVW_HIS H" ).append("\n"); 
		query.append("SET      ( STL_RQST_OFC_CD" ).append("\n"); 
		query.append("        ,N3PTY_STL_TP_CD" ).append("\n"); 
		query.append("        ,STL_APRO_OFC_CD" ).append("\n"); 
		query.append("        ,STL_TO_CLT_CNG_OFC_CD" ).append("\n"); 
		query.append("        ,STL_RJCT_OFC_CD" ).append("\n"); 
		query.append("        ,STL_CLT_OFC_CNG_AMT" ).append("\n"); 
		query.append("        ,STL_FWRD_OFC_CD" ).append("\n"); 
		query.append("        ,STL_CPY_OFC_CD" ).append("\n"); 
		query.append("        ,STL_RJCT_DT" ).append("\n"); 
		query.append("        ,STL_RQST_DT" ).append("\n"); 
		query.append("        ,STL_RJCT_USR_ID" ).append("\n"); 
		query.append("        ,STL_RQST_USR_ID" ).append("\n"); 
		query.append("        ,STL_APRO_DT" ).append("\n"); 
		query.append("        ,STL_APRO_USR_ID" ).append("\n"); 
		query.append("        ,STL_FWRD_DT" ).append("\n"); 
		query.append("        ,STL_FWRD_USR_ID" ).append("\n"); 
		query.append("        ,STL_CPY_DT" ).append("\n"); 
		query.append("        ,STL_CPY_USR_ID" ).append("\n"); 
		query.append("        ,STL_RQST_RMK" ).append("\n"); 
		query.append("        ,STL_APRO_RMK" ).append("\n"); 
		query.append("        ,STL_RJCT_RMK" ).append("\n"); 
		query.append("        ,STL_STS_LST_FLG" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("       ) = " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT STL_RQST_OFC_CD" ).append("\n"); 
		query.append("                ,N3PTY_STL_TP_CD" ).append("\n"); 
		query.append("                ,STL_APRO_OFC_CD" ).append("\n"); 
		query.append("                ,STL_TO_CLT_CNG_OFC_CD" ).append("\n"); 
		query.append("                ,STL_RJCT_OFC_CD" ).append("\n"); 
		query.append("                ,STL_CLT_OFC_CNG_AMT" ).append("\n"); 
		query.append("                ,STL_FWRD_OFC_CD" ).append("\n"); 
		query.append("                ,STL_CPY_OFC_CD" ).append("\n"); 
		query.append("                ,STL_RJCT_DT" ).append("\n"); 
		query.append("                ,STL_RQST_DT" ).append("\n"); 
		query.append("                ,STL_RJCT_USR_ID" ).append("\n"); 
		query.append("                ,STL_RQST_USR_ID" ).append("\n"); 
		query.append("                ,STL_APRO_DT" ).append("\n"); 
		query.append("                ,STL_APRO_USR_ID" ).append("\n"); 
		query.append("                ,STL_FWRD_DT" ).append("\n"); 
		query.append("                ,STL_FWRD_USR_ID" ).append("\n"); 
		query.append("                ,STL_CPY_DT" ).append("\n"); 
		query.append("                ,STL_CPY_USR_ID" ).append("\n"); 
		query.append("                ,STL_RQST_RMK" ).append("\n"); 
		query.append("                ,STL_APRO_RMK" ).append("\n"); 
		query.append("                ,STL_RJCT_RMK" ).append("\n"); 
		query.append("                ,STL_STS_LST_FLG" ).append("\n"); 
		query.append("                ,UPD_DT" ).append("\n"); 
		query.append("            FROM TPB_ADJ_STS" ).append("\n"); 
		query.append("           WHERE N3PTY_NO =  H.N3PTY_NO" ).append("\n"); 
		query.append("             AND ADJ_STS_SEQ = H.ADJ_STS_SEQ" ).append("\n"); 
		query.append("             AND STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("             AND ROWNUM = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE N3PTY_NO = @[n3pty_no]" ).append("\n"); 
		query.append("   AND ADJ_STS_SEQ = @[adj_sts_seq]" ).append("\n"); 
		query.append("   AND ADJ_N2ND_RVW_STS_CD = (" ).append("\n"); 
		query.append("                                SELECT   CASE WHEN STL_FWRD_OFC_CD = TPB_GET_HNDL_OFC_FNC('R',STL_TO_CLT_CNG_OFC_CD) THEN 'R3'" ).append("\n"); 
		query.append("                                              WHEN STL_FWRD_OFC_CD IN ( SELECT ATTR_CTNT1 AS OFC_CD FROM TPB_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'HO_OFC_CD' ) THEN 'R4'" ).append("\n"); 
		query.append("                                         END" ).append("\n"); 
		query.append("                                FROM     TPB_ADJ_STS" ).append("\n"); 
		query.append("                                WHERE    1 = 1" ).append("\n"); 
		query.append("                                AND      N3PTY_NO = H.N3PTY_NO" ).append("\n"); 
		query.append("                                AND      ADJ_STS_SEQ = H.ADJ_STS_SEQ" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("   AND STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}