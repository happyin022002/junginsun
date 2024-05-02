/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetSludgeVolRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.05
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.10.05 진마리아
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

public class GeneralInvoiceAuditDBDAOgetSludgeVolRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 비용 계산을 위해 Sludge Volume 를 구한다.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetSludgeVolRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOgetSludgeVolRSQL").append("\n"); 
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
		query.append("SELECT NVL(A.TTL_SLG_WGT, 0)" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V, VSK_ACT_PORT_SKD A" ).append("\n"); 
		query.append("WHERE (V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("                                           SELECT VSL_CD," ).append("\n"); 
		query.append("                                                DECODE(TURN_PORT_IND_CD, 'Y', SKD_VOY_NO, 'N', SKD_VOY_NO, TURN_SKD_VOY_NO) SKD_VOY_NO," ).append("\n"); 
		query.append("                                                DECODE(TURN_PORT_IND_CD, 'Y', SKD_DIR_CD, 'N', SKD_DIR_CD, TURN_SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append("                                           FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                           WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                           AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                           AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("                                           AND VPS_PORT_CD = SUBSTR(@[yd_cd], 1, 5))" ).append("\n"); 
		query.append("AND V.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND V.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = A.VPS_PORT_CD" ).append("\n"); 

	}
}