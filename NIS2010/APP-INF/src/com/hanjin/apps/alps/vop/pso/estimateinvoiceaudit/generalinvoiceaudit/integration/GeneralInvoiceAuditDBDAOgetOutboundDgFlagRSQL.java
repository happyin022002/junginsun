/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetOutboundDgFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.08 
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

public class GeneralInvoiceAuditDBDAOgetOutboundDgFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 port에서 위험물 cargo 선적 여부
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetOutboundDgFlagRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetOutboundDgFlagRSQL").append("\n"); 
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
		query.append("SELECT ''''||DECODE(X.CNT, 0, 'N','Y')||''''" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("  FROM BAY_PLAN A, VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("  WHERE A.PLAN_TYPE  = 'F'" ).append("\n"); 
		query.append("    AND A.VSL_CD     =  B.VSL_CD " ).append("\n"); 
		query.append("    AND A.VOY_NO     =  B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND A.DIR_CD     =  B.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND A.PORT_CD    =  B.VPS_PORT_CD" ).append("\n"); 
		query.append("    AND A.CALL_IND   =  B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    AND A.CARGO_TYPE =  'DG'" ).append("\n"); 
		query.append("    AND B.VSL_CD     =  SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("    AND B.SKD_VOY_NO =  SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("    AND B.SKD_DIR_CD =  SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("    AND B.YD_CD      =  @[yd_cd]" ).append("\n"); 
		query.append("    AND NVL(SKD_CNG_STS_CD,'X') <> 'S' ) X" ).append("\n"); 

	}
}