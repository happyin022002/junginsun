/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchYardsByVvdRSQL.java
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

public class GeneralInvoiceAuditDBDAOSearchYardsByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 VVD의 Yard를 조회합니다.
	  * 
	  * =========================
	  * History
	  * 2011.06.15 진마리아 CHM-201111910-01 [PSO] Tariff Simulation By VVD 신규화면 생성
	  * 2011.07.18 진마리아 CHM-201111882-01 [VOP-PSO] COA data I/F
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchYardsByVvdRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchYardsByVvdRSQL").append("\n"); 
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
		query.append("SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("     , CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , YD_CD" ).append("\n"); 
		query.append("     , TO_CHAR(VPS_ETB_DT, 'YYYYMMDD') VPS_ETB_DT" ).append("\n"); 
		query.append("     , TO_CHAR(VPS_ETD_DT, 'YYYYMMDD') VPS_ETD_DT" ).append("\n"); 
		query.append("  FROM (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("             , CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , YD_CD" ).append("\n"); 
		query.append("             , CLPT_SEQ" ).append("\n"); 
		query.append("             , VPS_ETB_DT" ).append("\n"); 
		query.append("             , VPS_ETD_DT" ).append("\n"); 
		query.append("             , ROW_NUMBER() OVER (PARTITION BY YD_CD ORDER BY CLPT_IND_SEQ) NUM" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("           AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("           AND NVL(VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/)" ).append("\n"); 
		query.append(" WHERE NUM = 1" ).append("\n"); 
		query.append(" ORDER BY CLPT_SEQ" ).append("\n"); 

	}
}