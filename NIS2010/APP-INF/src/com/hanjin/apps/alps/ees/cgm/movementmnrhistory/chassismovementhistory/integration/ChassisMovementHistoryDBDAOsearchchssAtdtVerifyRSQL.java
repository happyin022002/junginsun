/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOsearchchssAtdtVerifyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.29 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOsearchchssAtdtVerifyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOsearchchssAtdtVerifyRSQL(){
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
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOsearchchssAtdtVerifyRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN EQ_TPSZ_CD IN ('CB4','SF4') AND  CNTR_TPSZ_CD = 'D2' AND @[cntr_tpsz] = 'D2' AND KNT = 1 THEN 'OK'" ).append("\n"); 
		query.append("ELSE 'ERROR'" ).append("\n"); 
		query.append("END CHK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B.CNTR_TPSZ_CD, C.EQ_TPSZ_CD, COUNT(*) KNT" ).append("\n"); 
		query.append("FROM  CGM_EQ_ATCH_DTCH_HIS A , MST_CONTAINER B, CGM_EQUIPMENT C" ).append("\n"); 
		query.append("WHERE  A.EQ_NO =  @[chss_no]" ).append("\n"); 
		query.append("AND A.DTCH_DT  >to_date( @[from_dt],'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("AND A.ATCH_DT  < NVL( to_date(@[to_dt],'YYYYMMDD HH24:MI') , to_date('88881231','YYYYMMDD') )" ).append("\n"); 
		query.append("AND A.CNTR_NO <> NVL(  @[cntr_no] , 'XX')" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("AND A.EQ_NO = C.EQ_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY B.CNTR_TPSZ_CD,C.EQ_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}