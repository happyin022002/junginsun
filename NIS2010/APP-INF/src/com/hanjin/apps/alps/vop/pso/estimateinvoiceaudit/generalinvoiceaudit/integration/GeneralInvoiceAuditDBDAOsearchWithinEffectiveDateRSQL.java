/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchWithinEffectiveDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
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

public class GeneralInvoiceAuditDBDAOsearchWithinEffectiveDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * tonnage 생성시 기존 invoice에서 이미 청구된 건인지 확인하기 위한 object
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchWithinEffectiveDateRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchWithinEffectiveDateRSQL").append("\n"); 
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
		query.append("SELECT ''''||DECODE(A.CNT,0,'N','Y')||''''" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("SELECT COUNT(1) CNT FROM PSO_CHG_DTL A, VSK_VSL_PORT_SKD B, PSO_CHARGE C" ).append("\n"); 
		query.append("WHERE A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("  AND B.VPS_ETA_DT BETWEEN A.COST_CALC_EFF_FM_DT AND A.COST_CALC_EFF_TO_DT " ).append("\n"); 
		query.append("  AND B.VSL_CD     = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("  AND B.SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("  AND B.SKD_DIR_CD = substr(@[vvd], 9)" ).append("\n"); 
		query.append("  AND B.YD_CD      = @[yd_cd]" ).append("\n"); 
		query.append("  AND A.ISS_CTY_CD = C.ISS_CTY_CD" ).append("\n"); 
		query.append("  AND A.SO_SEQ     = C.SO_SEQ" ).append("\n"); 
		query.append("  AND SUBSTR(C.YD_CD,1,2) = SUBSTR(B.YD_CD,1,2)) A" ).append("\n"); 

	}
}