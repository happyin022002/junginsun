/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetLastPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.03 
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

public class GeneralInvoiceAuditDBDAOgetLastPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 비용 계산을 위해 LastPort 를 구한다.
	  * =====================================================================
	  * 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
	  * 2014.04.16 박다은 [CHM-201429497] [PSO] Object 수정 - Last/Next Port
	  * 2014.06.02 이윤정 [CHM-201430485] Last/Next Port 조회 로직 변경
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetLastPortRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOgetLastPortRSQL").append("\n"); 
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
		query.append("SELECT ''''||NVL(NVL(SUBSTR(MAX(TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MI')||B.VPS_PORT_CD ),-5), ''),'ZZZZZ')||''''" ).append("\n"); 
		query.append("#if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("FROM vsk_bud_vsl_port_skd A, vsk_bud_vsl_port_skd B" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("FROM vsk_vsl_port_skd A, vsk_vsl_port_skd B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.VSL_CD      = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD  = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("AND A.YD_CD       = @[yd_cd]" ).append("\n"); 
		query.append("AND A.CALL_YD_IND_SEQ = 1" ).append("\n"); 
		query.append("AND B.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND B.VPS_ETD_DT < A.VPS_ETD_DT" ).append("\n"); 
		query.append("AND NVL(B.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("AND B.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 

	}
}