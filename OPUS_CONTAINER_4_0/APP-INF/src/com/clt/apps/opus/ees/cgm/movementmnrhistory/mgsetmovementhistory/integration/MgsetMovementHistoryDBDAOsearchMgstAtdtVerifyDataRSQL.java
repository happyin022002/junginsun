/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MgsetMovementHistoryDBDAOsearchMgstAtdtVerifyDataRSQL.java
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

public class MgsetMovementHistoryDBDAOsearchMgstAtdtVerifyDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MgsetMovementHistoryDBDAOsearchMgstAtdtVerifyDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration ").append("\n"); 
		query.append("FileName : MgsetMovementHistoryDBDAOsearchMgstAtdtVerifyDataRSQL").append("\n"); 
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
		query.append(" CASE WHEN EQ_TPSZ_CD IN ('CB4','SF4') AND  CNTR_TPSZ_CD = 'D2' AND @[cntr_tpsz] = 'D2' AND KNT = 1 THEN 'OK'" ).append("\n"); 
		query.append(" ELSE 'ERROR'" ).append("\n"); 
		query.append(" END CHK" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    B.CNTR_TPSZ_CD, C.EQ_TPSZ_CD, COUNT(*) KNT" ).append("\n"); 
		query.append("       FROM  CGM_EQ_ATCH_DTCH_HIS A , MST_CONTAINER B, CGM_EQUIPMENT C" ).append("\n"); 
		query.append("    WHERE  A.EQ_NO =  @[mgst_no]" ).append("\n"); 
		query.append("    AND A.DTCH_DT  >to_date( @[from_dt],'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("    AND A.ATCH_DT  < NVL( to_date(@[to_dt],'YYYYMMDD HH24:MI') , to_date('88881231','YYYYMMDD') )" ).append("\n"); 
		query.append("    AND A.CNTR_NO <> NVL(  @[cntr_no] , 'XX')" ).append("\n"); 
		query.append("    AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("    AND A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("    AND A.EQ_NO = C.EQ_NO" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    GROUP BY B.CNTR_TPSZ_CD,C.EQ_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}