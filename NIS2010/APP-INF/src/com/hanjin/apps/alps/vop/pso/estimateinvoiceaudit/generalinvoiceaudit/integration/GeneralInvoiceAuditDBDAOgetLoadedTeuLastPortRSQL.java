/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetLoadedTeuLastPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.19 
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

public class GeneralInvoiceAuditDBDAOgetLoadedTeuLastPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 VVD, Port의 이전 Port에서 선적된 CNTR TEU를 구한다.
	  * =====================================================================
	  * 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
	  * 2014.04.01  SKY  CHM-201429324 : Loaded TEU at Last Port 로직 수정 
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetLoadedTeuLastPortRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOgetLoadedTeuLastPortRSQL").append("\n"); 
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
		query.append("WITH PRE_SKD AS (						" ).append("\n"); 
		query.append("         SELECT  * 						" ).append("\n"); 
		query.append("         FROM (  						" ).append("\n"); 
		query.append("              SELECT *" ).append("\n"); 
		query.append("#if (${budget_flag} == 'B') " ).append("\n"); 
		query.append("                FROM VSK_BUD_VSL_PORT_SKD" ).append("\n"); 
		query.append("#else 						" ).append("\n"); 
		query.append("                FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("#end                						" ).append("\n"); 
		query.append("              WHERE  VPS_ETA_DT <	 ( SELECT MAX(VPS_ETA_DT) 					" ).append("\n"); 
		query.append("                                         FROM VSK_VSL_PORT_SKD 						" ).append("\n"); 
		query.append("                                        WHERE VSL_CD      =  SUBSTR(@[vvd], 1, 4) 					" ).append("\n"); 
		query.append("                                          AND SKD_VOY_NO  =  SUBSTR(@[vvd], 5, 4) 						" ).append("\n"); 
		query.append("                                          AND SKD_DIR_CD  =  SUBSTR(@[vvd], 9, 1)  						" ).append("\n"); 
		query.append("                                          AND YD_CD       =   @[yd_cd] )						" ).append("\n"); 
		query.append("                 AND TURN_PORT_IND_CD IN ('N','Y')	" ).append("\n"); 
		query.append("#if (${skd_dir_cd} ==  ${bound_cd}) 					 -- DIRECTION 이 맞는 것만 나오게 하기 위함." ).append("\n"); 
		query.append("                 AND VSL_CD  = SUBSTR(@[vvd], 1, 4) " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                 AND VSL_CD  = 'XXXX'  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 AND NVL(SKD_CNG_STS_CD,'X') <> 'S'					" ).append("\n"); 
		query.append("                ORDER BY VPS_ETA_DT DESC						" ).append("\n"); 
		query.append("                )						" ).append("\n"); 
		query.append("          WHERE  ROWNUM =1	)					" ).append("\n"); 
		query.append("  SELECT SUM(CASE WHEN SZTP ='DW' THEN '3.02' 						" ).append("\n"); 
		query.append("                  WHEN SZTP ='DX' THEN '3.02'						" ).append("\n"); 
		query.append("                  WHEN SUBSTR(SZTP, 2,1) = '2' THEN '1.00'						" ).append("\n"); 
		query.append("                  WHEN SUBSTR(SZTP, 2,1) = '3' THEN '1.12'						" ).append("\n"); 
		query.append("                  WHEN SUBSTR(SZTP, 2,1) = '4' THEN '2.00'						" ).append("\n"); 
		query.append("                  WHEN SUBSTR(SZTP, 2,1) = '5' THEN '2.24'						" ).append("\n"); 
		query.append("                  WHEN SUBSTR(SZTP, 2,1) = '7' THEN '2.51'						" ).append("\n"); 
		query.append("                  WHEN SUBSTR(SZTP, 2,1) = '8' THEN '2.68'						" ).append("\n"); 
		query.append("                  WHEN SUBSTR(SZTP, 2,1) = '9' THEN '2.68'						" ).append("\n"); 
		query.append("                  WHEN CNTR_SIZE = '2' THEN '1.00' -- 위의 조건에 일치 하지 않을 경우를 대비하여 임시로 Rate 할당						" ).append("\n"); 
		query.append("                  ELSE '2.00' END)  AS TPRATE 						     						" ).append("\n"); 
		query.append("        FROM BAY_PLAN A, PRE_SKD B						" ).append("\n"); 
		query.append("       WHERE A.FE = 'F'					" ).append("\n"); 
		query.append("          AND A.VSL_CD    = B.VSL_CD     				" ).append("\n"); 
		query.append("          AND A.VOY_NO   = B.SKD_VOY_NO   				" ).append("\n"); 
		query.append("          AND A.DIR_CD     =  B.SKD_DIR_CD      				" ).append("\n"); 
		query.append("          AND A.PORT_CD  = B.VPS_PORT_CD						" ).append("\n"); 
		query.append("          AND A.PLAN_TYPE = 'F'" ).append("\n"); 

	}
}