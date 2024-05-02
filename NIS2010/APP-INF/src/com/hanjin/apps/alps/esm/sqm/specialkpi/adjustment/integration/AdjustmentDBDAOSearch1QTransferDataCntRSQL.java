/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AdjustmentDBDAOSearch1QTransferDataCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentDBDAOSearch1QTransferDataCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search1QTransferDataCnt
	  * </pre>
	  */
	public AdjustmentDBDAOSearch1QTransferDataCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOSearch1QTransferDataCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) AS CNT" ).append("\n"); 
		query.append("  FROM SQM_SPCL_CFM_QTA" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BSE_TP_CD   = 'Q' " ).append("\n"); 
		query.append("   AND SPCL_TGT_CD = @[f_spcl_tgt_cd]  --S, R 필수" ).append("\n"); 
		query.append("   AND BSE_YR      = @[f_bse_yr]       --필수" ).append("\n"); 
		query.append("   AND BSE_QTR_CD  = '1Q'" ).append("\n"); 

	}
}