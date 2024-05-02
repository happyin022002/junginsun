/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AdjustmentManageDBDAOSearchSecondReviewCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.04 
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

public class AdjustmentManageDBDAOSearchSecondReviewCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Review Check
	  * </pre>
	  */
	public AdjustmentManageDBDAOSearchSecondReviewCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration").append("\n"); 
		query.append("FileName : AdjustmentManageDBDAOSearchSecondReviewCheckRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(H.N3PTY_NO),0,'N','Y') N2ND_RVW_CHK, H.ADJ_STS_SEQ, H.ADJ_N2ND_RVW_SEQ, H.ADJ_N2ND_RVW_STS_CD" ).append("\n"); 
		query.append("FROM TPB_ADJ_STS S, TPB_ADJ_N2ND_RVW_HIS H" ).append("\n"); 
		query.append("WHERE S.N3PTY_NO = @[n3pty_no]" ).append("\n"); 
		query.append("AND S.STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND H.N3PTY_NO = S.N3PTY_NO" ).append("\n"); 
		query.append("AND H.ADJ_STS_SEQ = S.ADJ_STS_SEQ" ).append("\n"); 
		query.append("AND H.UPD_USR_ID IN (" ).append("\n"); 
		query.append("SELECT DECODE(N3PTY_OFC_TP_CD,'S',RHQ_CD,OFC_CD)" ).append("\n"); 
		query.append("FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("WHERE OFC_CD = @[user_ofc_cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND H.ADJ_N2ND_RVW_STS_CD = DECODE(H.UPD_USR_ID" ).append("\n"); 
		query.append(",TPB_GET_HNDL_OFC_FNC('R',S.STL_TO_CLT_CNG_OFC_CD),'R2'" ).append("\n"); 
		query.append(",TPB_GET_HNDL_OFC_FNC('R',S.STL_RQST_OFC_CD),'R3','R4')" ).append("\n"); 
		query.append("AND NVL(H.N2ND_RVW_AVAL_FLG,'X') = 'Y'" ).append("\n"); 
		query.append("AND H.ADJ_N2ND_RVW_SEQ > 0" ).append("\n"); 
		query.append("GROUP BY H.N3PTY_NO,H.ADJ_STS_SEQ, H.ADJ_N2ND_RVW_SEQ, H.ADJ_N2ND_RVW_STS_CD" ).append("\n"); 

	}
}