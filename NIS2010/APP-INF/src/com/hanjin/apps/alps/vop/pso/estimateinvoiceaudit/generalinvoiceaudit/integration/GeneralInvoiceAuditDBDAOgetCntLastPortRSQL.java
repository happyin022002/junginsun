/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetCntLastPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.13 
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

public class GeneralInvoiceAuditDBDAOgetCntLastPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 비용 계산을 위해 직전 Calling Port 의 Country을 구한다.
	  * =====================================================================
	  * 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
	  * 2014.04.01 SKY  CHM-201429116 Object 로직 수정 요청 - Country of Last Port
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetCntLastPortRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOgetCntLastPortRSQL").append("\n"); 
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
		query.append("SELECT ''''||NVL(SUBSTR(MAX(TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MI')||B.yd_cd ),-7,2), '0')||''''" ).append("\n"); 
		query.append("#if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("FROM vsk_bud_vsl_port_skd A, vsk_bud_vsl_port_skd B" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("FROM vsk_vsl_port_skd A, vsk_vsl_port_skd B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE A.VSL_CD   = B.VSL_CD" ).append("\n"); 
		query.append("AND A.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND A.yd_cd = @[yd_cd]" ).append("\n"); 
		query.append("AND A.VPS_ETD_DT > B.VPS_ETD_DT" ).append("\n"); 
		query.append("AND NVL (A.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND A.TURN_PORT_IND_CD IN ('N', 'Y')" ).append("\n"); 
		query.append("AND NVL (B.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND B.TURN_PORT_IND_CD IN ('N', 'Y')" ).append("\n"); 

	}
}