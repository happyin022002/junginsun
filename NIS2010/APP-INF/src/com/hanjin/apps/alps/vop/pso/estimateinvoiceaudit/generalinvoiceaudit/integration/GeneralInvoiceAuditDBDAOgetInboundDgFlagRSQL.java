/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetInboundDgFlagRSQL.java
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

public class GeneralInvoiceAuditDBDAOgetInboundDgFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 PORT로 들어오는 화물 중 DG CARGO 여부를 확인하기 위함
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetInboundDgFlagRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOgetInboundDgFlagRSQL").append("\n"); 
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
		query.append("WITH BF_PORT AS " ).append("\n"); 
		query.append(" (" ).append("\n"); 
		query.append(" SELECT VPS_PORT_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, CLPT_IND_SEQ" ).append("\n"); 
		query.append(" FROM ( SELECT *" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE VPS_ETA_DT < (  SELECT MIN(VPS_ETA_DT) " ).append("\n"); 
		query.append("                                 FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                WHERE VSL_CD     = SUBSTR(@[vvd], 1,4) " ).append("\n"); 
		query.append("                                  AND SKD_VOY_NO = SUBSTR(@[vvd], 5,4) " ).append("\n"); 
		query.append("                                  AND SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("                                  AND YD_CD      = @[yd_cd]" ).append("\n"); 
		query.append("                                  AND NVL(SKD_CNG_STS_CD,'X') <> 'S' ) " ).append("\n"); 
		query.append("           AND VSL_CD      = SUBSTR(@[vvd], 1,4) " ).append("\n"); 
		query.append("           AND VPS_PORT_CD NOT IN ('EGSUZ','PAPAC') " ).append("\n"); 
		query.append("           AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("           AND TURN_PORT_IND_CD IN ('N','Y')" ).append("\n"); 
		query.append("   ORDER BY VPS_ETA_DT DESC ) X" ).append("\n"); 
		query.append("   WHERE ROWNUM = 1 ) " ).append("\n"); 
		query.append("  SELECT ''''||DECODE(X.CNT , 0, 'N', 'Y')||''''    " ).append("\n"); 
		query.append("    FROM (  SELECT COUNT(1) CNT FROM BF_PORT A, BAY_PLAN B" ).append("\n"); 
		query.append("             WHERE A.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("               AND A.SKD_VOY_NO   = B.VOY_NO" ).append("\n"); 
		query.append("               AND A.SKD_DIR_CD   = B.DIR_CD" ).append("\n"); 
		query.append("               AND A.VPS_PORT_CD  = B.PORT_CD" ).append("\n"); 
		query.append("               AND B.PLAN_TYPE    = 'F'" ).append("\n"); 
		query.append("               AND A.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("               AND B.CARGO_TYPE   = 'DG') X" ).append("\n"); 

	}
}