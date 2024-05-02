/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchTonnageDivRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOsearchTonnageDivRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CN,IT,JP의 TONNAGE비용을 해당 VVD별로 배분하기 위함.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchTonnageDivRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchTonnageDivRSQL").append("\n"); 
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
		query.append("SELECT DECODE(CNT,0,'N','Y') FLAG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT COUNT(1) CNT " ).append("\n"); 
		query.append("  FROM PSO_CHARGE A, PSO_CHG_DTL B" ).append("\n"); 
		query.append(" WHERE A.ISS_CTY_CD    = B.ISS_CTY_CD" ).append("\n"); 
		query.append("   AND A.SO_SEQ        = B.SO_SEQ" ).append("\n"); 
		query.append("   AND A.INV_NO        = @[inv_no] " ).append("\n"); 
		query.append("   AND A.VNDR_SEQ      = @[vndr_seq] " ).append("\n"); 
		query.append("   AND SUBSTR(A.YD_CD ,1,2 ) IN ('CN','JP','IT') " ).append("\n"); 
		query.append("   AND SUBSTR(A.YD_CD ,1,5 ) <>   'CNHKG'" ).append("\n"); 
		query.append("   AND B.LGS_COST_CD    = 'PTDUTN' " ).append("\n"); 
		query.append("   AND B.COST_CALC_EFF_FM_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND B.COST_CALC_EFF_TO_DT IS NOT NULL )" ).append("\n"); 

	}
}