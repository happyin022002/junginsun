/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SurchargeDBDAOTotalSurchargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.20
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeDBDAOTotalSurchargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TotalSurcharge
	  * </pre>
	  */
	public SurchargeDBDAOTotalSurchargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOTotalSurchargeRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) " ).append("\n"); 
		query.append("FROM MDM_COUNTRY A, MDM_SUBCONTINENT B, MDM_CONTINENT C  " ).append("\n"); 
		query.append("WHERE 1 = 1 " ).append("\n"); 
		query.append("  AND A.SCONTI_CD = B.SCONTI_CD " ).append("\n"); 
		query.append("  AND B.CONTI_CD=C.CONTI_CD " ).append("\n"); 
		query.append("  AND NVL(A.DELT_FLG,'N') <> 'Y' " ).append("\n"); 
		query.append("  AND NVL(B.DELT_FLG,'N') <> 'Y' " ).append("\n"); 
		query.append("  AND NVL(C.DELT_FLG,'N') <> 'Y' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${conti_cd} != '') " ).append("\n"); 
		query.append("AND B.conti_cd like '%' || @[conti_cd] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sconti_cd} != '') " ).append("\n"); 
		query.append("AND A.sconti_cd like '%' || @[sconti_cd] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("AND A.cnt_cd like '%' || @[cnt_cd] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_nm} != '') " ).append("\n"); 
		query.append("AND A.cnt_nm like '%' || @[cnt_nm] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}