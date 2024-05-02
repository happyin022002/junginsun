/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RASCommonDBDAOManualSettleTypeCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RASCommonDBDAOManualSettleTypeCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual Settle Type Code를 조회한다
	  * </pre>
	  */
	public RASCommonDBDAOManualSettleTypeCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration").append("\n"); 
		query.append("FileName : RASCommonDBDAOManualSettleTypeCodeRSQL").append("\n"); 
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
		query.append("SELECT MNL_STL_TP_CD CD, " ).append("\n"); 
		query.append("       MNL_STL_TP_DESC NM, " ).append("\n"); 
		query.append("       MNL_STL_TP_CD||'\t'||MNL_STL_TP_DESC||'\t'||(SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD03476'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = MNL_STL_CATE_CD) ETC2, " ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD03476'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = MNL_STL_CATE_CD) ETC1" ).append("\n"); 
		query.append("FROM BKG_REV_UMCH_MNL_STL_TP" ).append("\n"); 
		query.append("ORDER BY MNL_STL_TP_DP_SEQ" ).append("\n"); 

	}
}