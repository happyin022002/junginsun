/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOsearchchssTpszOnCntrCHkRSQL.java
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

public class ChassisMovementHistoryDBDAOsearchchssTpszOnCntrCHkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOsearchchssTpszOnCntrCHkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOsearchchssTpszOnCntrCHkRSQL").append("\n"); 
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
		query.append("'OK' RESULT" ).append("\n"); 
		query.append(",A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(", A.ACIAC_DIV_CD" ).append("\n"); 
		query.append(",CASE WHEN SUBSTR(@[eq_tpsz_cd],2,1)='2' AND A.EQ_TPSZ_CD IN ('SF2','SL2','TA2','SF4','CB4') THEN 'OK'" ).append("\n"); 
		query.append("WHEN SUBSTR(@[eq_tpsz_cd],2,1)='4' AND A.EQ_TPSZ_CD IN ('SF4','GN4','CB4','ZT4','GN5','EG5','EG8') THEN 'OK'" ).append("\n"); 
		query.append("WHEN SUBSTR(@[eq_tpsz_cd],2,1)='5' AND A.EQ_TPSZ_CD IN ('SF4','GN4','CB4','ZT4','GN5','EG5','EG8') THEN 'OK'" ).append("\n"); 
		query.append("WHEN SUBSTR(@[eq_tpsz_cd],2,1)='7' AND A.EQ_TPSZ_CD IN ('GN5','EG5','EG8') THEN 'OK'" ).append("\n"); 
		query.append("WHEN SUBSTR(@[eq_tpsz_cd],2,1)='9' AND A.EQ_TPSZ_CD IN ('EG8') THEN 'OK'" ).append("\n"); 
		query.append("ELSE 'ERROR' END TPSZ_CHECK" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD =  @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.EQ_NO = @[chss_no]" ).append("\n"); 

	}
}