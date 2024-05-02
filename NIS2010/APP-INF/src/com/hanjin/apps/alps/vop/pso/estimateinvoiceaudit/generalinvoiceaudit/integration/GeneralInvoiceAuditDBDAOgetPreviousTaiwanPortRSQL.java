/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetPreviousTaiwanPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.29
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.09.29 진마리아
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

public class GeneralInvoiceAuditDBDAOgetPreviousTaiwanPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 어떤 Vessel이 특정 포트 접안일 기준, 과거 120일 이내에 Taiwan을 접안 하였는지 조회 
	  * 
	  * --------------------------------
	  * 2011.09.29 진마리아 CHM-201113488 [VOP-VSK] 신규 Object 등록 요청 (Previous Port)
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetPreviousTaiwanPortRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOgetPreviousTaiwanPortRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*), 0, 'N', 'Y') FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND NVL(SKD_CNG_STS_CD, 'X')<>'S'" ).append("\n"); 
		query.append("AND VPS_PORT_CD LIKE 'TW%'" ).append("\n"); 
		query.append("AND TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("AND TO_DATE(TO_CHAR(VPS_ETB_DT, 'YYYYMMDD'), 'YYYYMMDD')+120 >= (" ).append("\n"); 
		query.append("    SELECT TO_DATE(TO_CHAR(VPS_ETB_DT, 'YYYYMMDD'), 'YYYYMMDD') FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("    AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("    AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("    AND VPS_PORT_CD = SUBSTR(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}