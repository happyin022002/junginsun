/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetSameVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetSameVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getSameVvd
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetSameVvdRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetSameVvdRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX('''Y'''), '''Y''')" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("     , PSO_CHARGE P" ).append("\n"); 
		query.append("     , PSO_CHG_DTL D" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.VPS_PORT_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND B.VPS_PORT_CD = SUBSTR(@[yd_cd], 1, 5) --'KRPUS'" ).append("\n"); 
		query.append("   AND A.VPS_ETD_DT < B.VPS_ETD_DT" ).append("\n"); 
		query.append("   AND P.ISS_CTY_CD = D.ISS_CTY_CD" ).append("\n"); 
		query.append("   AND P.SO_SEQ = D.SO_SEQ" ).append("\n"); 
		query.append("   AND A.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.YD_CD = P.YD_CD" ).append("\n"); 
		query.append("   AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("   AND NVL(A.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 

	}
}