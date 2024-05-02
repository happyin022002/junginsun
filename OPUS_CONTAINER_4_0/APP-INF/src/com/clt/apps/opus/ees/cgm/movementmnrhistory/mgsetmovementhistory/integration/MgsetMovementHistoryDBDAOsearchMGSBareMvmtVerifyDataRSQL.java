/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MgsetMovementHistoryDBDAOsearchMGSBareMvmtVerifyDataRSQL.java
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

public class MgsetMovementHistoryDBDAOsearchMGSBareMvmtVerifyDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MgsetMovementHistoryDBDAOsearchMGSBareMvmtVerifyDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt_day",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt_hd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration ").append("\n"); 
		query.append("FileName : MgsetMovementHistoryDBDAOsearchMGSBareMvmtVerifyDataRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append(" CASE " ).append("\n"); 
		query.append("      WHEN   SYSDATE  < TO_DATE(@[mvmt_dt_day]||' '|| @[mvmt_dt_hd] ,'YYYY-MM-DD HH24:MI:SS')  THEN" ).append("\n"); 
		query.append("        'The time is invalid.'" ).append("\n"); 
		query.append("      WHEN  (( SELECT  COUNT(BB.CHSS_NO)   " ).append("\n"); 
		query.append("                 FROM CGM_MGST_MVMT_HIS BB" ).append("\n"); 
		query.append("                 WHERE BB.MGST_NO = @[eq_no]" ).append("\n"); 
		query.append("                  AND  BB.MVMT_DT = TO_DATE(@[mvmt_dt_day]||' '||@[mvmt_dt_hd],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("                  AND  BB.YD_CD = @[dest_yd_cd]) >0)  THEN" ).append("\n"); 
		query.append("       'Already data exists.'" ).append("\n"); 
		query.append("       WHEN  ( (SELECT ACIAC_DIV_CD FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("                 WHERE EQ_NO =@[eq_no]) ='I') THEN" ).append("\n"); 
		query.append("       'M.G. Set is inactive.'" ).append("\n"); 
		query.append("       WHEN  ( (SELECT ACIAC_DIV_CD FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("                 WHERE EQ_NO =@[chss_no]) ='I') " ).append("\n"); 
		query.append("               THEN" ).append("\n"); 
		query.append("       'Chassis is inactive.'" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("      ELSE" ).append("\n"); 
		query.append("      'OK'" ).append("\n"); 
		query.append("      END AS VERIFY" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}