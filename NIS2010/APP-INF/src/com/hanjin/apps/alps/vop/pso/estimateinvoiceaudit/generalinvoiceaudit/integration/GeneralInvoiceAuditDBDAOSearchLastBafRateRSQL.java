/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchLastBafRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.17 
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

public class GeneralInvoiceAuditDBDAOSearchLastBafRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd, yard,account 의 최종 baf rate가져오기
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchLastBafRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchLastBafRateRSQL").append("\n"); 
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
		query.append("SELECT NVL(extractvalue(xmltype(nvl(max(X.INV_COND_DESC),'<o></o>')), '//o176'),0) AS bafrt" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("SELECT  T2.*--NVL(extractvalue(xmltype(nvl(max(T2.INV_COND_DESC),'<o></o>')), '//o176'),0) AS bafrt" ).append("\n"); 
		query.append(" FROM PSO_CHARGE T1, PSO_CHG_DTL T2" ).append("\n"); 
		query.append(" WHERE T1.ISS_CTY_CD  = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("   AND T1.SO_SEQ      = T2.SO_SEQ" ).append("\n"); 
		query.append("   AND T1.VNDR_SEQ    = @[vndr_seq] " ).append("\n"); 
		query.append("   AND T1.YD_CD       = @[yd_cd] " ).append("\n"); 
		query.append("   AND T2.LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 
		query.append("ORDER BY T2.ISS_CTY_CD, T2.SO_SEQ DESC, SO_DTL_SEQ DESC ) X" ).append("\n"); 
		query.append("WHERE ROWNUM =1" ).append("\n"); 

	}
}