/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AdjustmentManageDBDAOAddSecondReviewCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.03 
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

public class AdjustmentManageDBDAOAddSecondReviewCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Adjustment 2nd Review History Table Insert
	  * </pre>
	  */
	public AdjustmentManageDBDAOAddSecondReviewCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration").append("\n"); 
		query.append("FileName : AdjustmentManageDBDAOAddSecondReviewCSQL").append("\n"); 
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
		query.append("INSERT INTO TPB_ADJ_N2ND_RVW_HIS (" ).append("\n"); 
		query.append("N3PTY_NO" ).append("\n"); 
		query.append(",ADJ_STS_SEQ" ).append("\n"); 
		query.append(",ADJ_N2ND_RVW_SEQ" ).append("\n"); 
		query.append(",STL_RQST_OFC_CD" ).append("\n"); 
		query.append(",N3PTY_STL_TP_CD" ).append("\n"); 
		query.append(",STL_APRO_OFC_CD" ).append("\n"); 
		query.append(",STL_TO_CLT_CNG_OFC_CD" ).append("\n"); 
		query.append(",STL_RJCT_OFC_CD" ).append("\n"); 
		query.append(",STL_CLT_OFC_CNG_AMT" ).append("\n"); 
		query.append(",STL_FWRD_OFC_CD" ).append("\n"); 
		query.append(",STL_CPY_OFC_CD" ).append("\n"); 
		query.append(",STL_RJCT_DT" ).append("\n"); 
		query.append(",STL_RQST_DT" ).append("\n"); 
		query.append(",STL_RJCT_USR_ID" ).append("\n"); 
		query.append(",STL_RQST_USR_ID" ).append("\n"); 
		query.append(",STL_APRO_DT" ).append("\n"); 
		query.append(",STL_APRO_USR_ID" ).append("\n"); 
		query.append(",STL_FWRD_DT" ).append("\n"); 
		query.append(",STL_FWRD_USR_ID" ).append("\n"); 
		query.append(",STL_CPY_DT" ).append("\n"); 
		query.append(",STL_CPY_USR_ID" ).append("\n"); 
		query.append(",STL_RQST_RMK" ).append("\n"); 
		query.append(",STL_APRO_RMK" ).append("\n"); 
		query.append(",STL_RJCT_RMK" ).append("\n"); 
		query.append(",STL_STS_LST_FLG" ).append("\n"); 
		query.append(",N2ND_RVW_AVAL_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",ADJ_N2ND_RVW_STS_CD )" ).append("\n"); 
		query.append("SELECT N3PTY_NO" ).append("\n"); 
		query.append(",ADJ_STS_SEQ" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",STL_RQST_OFC_CD" ).append("\n"); 
		query.append(",N3PTY_STL_TP_CD" ).append("\n"); 
		query.append(",STL_APRO_OFC_CD" ).append("\n"); 
		query.append(",STL_TO_CLT_CNG_OFC_CD" ).append("\n"); 
		query.append(",STL_RJCT_OFC_CD" ).append("\n"); 
		query.append(",STL_CLT_OFC_CNG_AMT" ).append("\n"); 
		query.append(",STL_FWRD_OFC_CD" ).append("\n"); 
		query.append(",STL_CPY_OFC_CD" ).append("\n"); 
		query.append(",STL_RJCT_DT" ).append("\n"); 
		query.append(",STL_RQST_DT" ).append("\n"); 
		query.append(",STL_RJCT_USR_ID" ).append("\n"); 
		query.append(",STL_RQST_USR_ID" ).append("\n"); 
		query.append(",STL_APRO_DT" ).append("\n"); 
		query.append(",STL_APRO_USR_ID" ).append("\n"); 
		query.append(",STL_FWRD_DT" ).append("\n"); 
		query.append(",STL_FWRD_USR_ID" ).append("\n"); 
		query.append(",STL_CPY_DT" ).append("\n"); 
		query.append(",STL_CPY_USR_ID" ).append("\n"); 
		query.append(",STL_RQST_RMK" ).append("\n"); 
		query.append(",STL_APRO_RMK" ).append("\n"); 
		query.append(",STL_RJCT_RMK" ).append("\n"); 
		query.append(",STL_STS_LST_FLG" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",STL_FWRD_OFC_CD" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",DECODE(STL_FWRD_OFC_CD,TPB_GET_HNDL_OFC_FNC('R',STL_TO_CLT_CNG_OFC_CD),'R2',TPB_GET_HNDL_OFC_FNC('R',STL_RQST_OFC_CD),'R3','R4')" ).append("\n"); 
		query.append("FROM TPB_ADJ_STS A" ).append("\n"); 
		query.append("WHERE A.N3PTY_NO = @[n3pty_no]" ).append("\n"); 
		query.append("AND A.STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.STL_FWRD_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM TPB_ADJ_N2ND_RVW_HIS H" ).append("\n"); 
		query.append("WHERE H.N3PTY_NO=A.N3PTY_NO" ).append("\n"); 
		query.append("AND H.ADJ_STS_SEQ=A.ADJ_STS_SEQ" ).append("\n"); 
		query.append("AND H.ADJ_N2ND_RVW_STS_CD = DECODE(A.STL_FWRD_OFC_CD,TPB_GET_HNDL_OFC_FNC('R',A.STL_TO_CLT_CNG_OFC_CD),'R2',TPB_GET_HNDL_OFC_FNC('R',A.STL_RQST_OFC_CD),'R3','R4')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}