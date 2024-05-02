/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetArvDrftMeterRSQL.java
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

public class GeneralInvoiceAuditDBDAOgetArvDrftMeterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 비용 계산을 위해 Arrival Draft Meter 를 구한다. 
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetArvDrftMeterRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOgetArvDrftMeterRSQL").append("\n"); 
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
		query.append("SELECT  MAX(ARR_AFTDR_HGT)" ).append("\n"); 
		query.append("FROM  VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND   A.VPS_PORT_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("AND   A.CLPT_IND_SEQ = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND  (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("                                           SELECT VSL_CD," ).append("\n"); 
		query.append("                                                 DECODE(TURN_PORT_IND_CD, 'Y', SKD_VOY_NO, 'N', SKD_VOY_NO, TURN_SKD_VOY_NO) SKD_VOY_NO," ).append("\n"); 
		query.append("                                                 DECODE(TURN_PORT_IND_CD, 'Y', SKD_DIR_CD, 'N', SKD_DIR_CD, TURN_SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append("                                           FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                           WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                           AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                           AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("                                           AND VPS_PORT_CD = SUBSTR(@[yd_cd], 1, 5))" ).append("\n"); 
		query.append("AND   A.YD_CD = @[yd_cd]" ).append("\n"); 

	}
}