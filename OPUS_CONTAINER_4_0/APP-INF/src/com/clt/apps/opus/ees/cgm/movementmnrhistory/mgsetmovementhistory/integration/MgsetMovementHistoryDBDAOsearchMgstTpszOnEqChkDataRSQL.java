/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MgsetMovementHistoryDBDAOsearchMgstTpszOnEqChkDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MgsetMovementHistoryDBDAOsearchMgstTpszOnEqChkDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MgsetMovementHistoryDBDAOsearchMgstTpszOnEqChkDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration ").append("\n"); 
		query.append("FileName : MgsetMovementHistoryDBDAOsearchMgstTpszOnEqChkDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     'OK' RESULT" ).append("\n"); 
		query.append("     ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , A.ACIAC_DIV_CD" ).append("\n"); 
		query.append("     ,CASE WHEN (SELECT CNTR_TPSZ_CD FROM MDM_CNTR_TP_SZ WHERE CNTR_TPSZ_CD = @[eq_tpsz_cd]) IS NOT NULL AND A.EQ_TPSZ_CD = 'CLG' THEN 'OK'" ).append("\n"); 
		query.append("           WHEN (SELECT EQ_TPSZ_CD FROM CGM_EQ_TP_SZ WHERE EQ_TPSZ_CD = @[eq_tpsz_cd]) IS NOT NULL AND A.EQ_TPSZ_CD = 'UMG' THEN 'OK'" ).append("\n"); 
		query.append("      ELSE 'ERROR' END TPSZ_CHECK              " ).append("\n"); 
		query.append("    FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("    WHERE A.EQ_KND_CD =  @[eq_knd_cd]" ).append("\n"); 
		query.append("    AND A.EQ_NO = @[mgst_no]" ).append("\n"); 

	}
}