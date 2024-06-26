/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetBoundRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.03.28 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetBoundRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 비용 계산을 위해 Bound 를 구한다.
	  * =====================================================================
	  * 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetBoundRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOgetBoundRSQL").append("\n"); 
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
		query.append("SELECT NVL(SVC_SCP_BND_CD," ).append("\n"); 
		query.append("	CASE WHEN SUBSTR(@[yd_cd], 1, 5)='EGSUZ' AND A.SKD_DIR_CD='W' THEN" ).append("\n"); 
		query.append("		'N'" ).append("\n"); 
		query.append("	WHEN SUBSTR(@[yd_cd], 1, 5)='EGSUZ' AND A.SKD_DIR_CD='E' THEN" ).append("\n"); 
		query.append("		'S'" ).append("\n"); 
		query.append("	WHEN SUBSTR(@[yd_cd], 1, 5)='PAPAC' AND A.SKD_DIR_CD='W' THEN" ).append("\n"); 
		query.append("		'S'" ).append("\n"); 
		query.append("	WHEN SUBSTR(@[yd_cd], 1, 5)='PAPAC' AND A.SKD_DIR_CD='E' THEN" ).append("\n"); 
		query.append("		'N'" ).append("\n"); 
		query.append("	END) AS SVC_SCP_BND_CD" ).append("\n"); 
		query.append("#if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("FROM VSK_BUD_VSL_SKD A, MDM_VSL_SVC_LANE_DIR B" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("FROM VSK_VSL_SKD A, MDM_VSL_SVC_LANE_DIR B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD = B.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 

	}
}