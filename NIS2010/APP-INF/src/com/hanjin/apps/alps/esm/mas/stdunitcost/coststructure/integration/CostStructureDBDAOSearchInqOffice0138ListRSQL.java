/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CostStructureDBDAOSearchInqOffice0138ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.22
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.10.22 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOSearchInqOffice0138ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _NOD_AVG_STND_COST/_LNK_AVG_STND_COST 테이블의 TES/TRS 단가 조회 
	  * 
	  * 2010.10.14 아키 위배사항 테스트 중 조회 데이터가 정렬이 필요한듯 쿼리 수정  
	  * </pre>
	  */
	public CostStructureDBDAOSearchInqOffice0138ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOSearchInqOffice0138ListRSQL").append("\n"); 
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
		query.append("#if (${f_sls_ofc_cd} == '' )" ).append("\n"); 
		query.append("SELECT A1.OFC_CD" ).append("\n"); 
		query.append("       , DECODE(A1.OFC_N2ND_LVL_TP_CD,NULL,' ', A1.OFC_N2ND_LVL_CD) AS ROOT2" ).append("\n"); 
		query.append("       , DECODE(A1.OFC_N3RD_LVL_TP_CD,NULL,' ', A1.OFC_N3RD_LVL_CD) AS ROOT3" ).append("\n"); 
		query.append("       , DECODE(A1.OFC_N4TH_LVL_TP_CD,NULL,' ', A1.OFC_N4TH_LVL_CD) AS ROOT4" ).append("\n"); 
		query.append("       , DECODE(A1.OFC_N5TH_LVL_TP_CD,NULL,' ', A1.OFC_N5TH_LVL_CD) AS ROOT5" ).append("\n"); 
		query.append("       , DECODE(A1.OFC_N6TH_LVL_TP_CD,NULL,' ', A1.OFC_N6TH_LVL_CD) AS ROOT6" ).append("\n"); 
		query.append("       , DECODE(A1.OFC_N7TH_LVL_TP_CD,NULL,' ', A1.OFC_N7TH_LVL_CD) AS ROOT7" ).append("\n"); 
		query.append("FROM   MAS_OFC_LVL A1" ).append("\n"); 
		query.append("       , (SELECT DISTINCT DECODE(@[f_ofc_lvl],'1',OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("                                , '2',OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("                                , '3',OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                                , '4',OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("                                , '5',OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                                , '6',OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("                                , '7',OFC_N7TH_LVL_CD) AS OFC_CD" ).append("\n"); 
		query.append("        FROM   MAS_OFC_LVL" ).append("\n"); 
		query.append("        WHERE  DECODE(@[f_ofc_lvl],'1',OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("                       , '2',OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("                       , '3',OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                       , '4',OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("                       , '5',OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                       , '6',OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("                       , '7',OFC_N7TH_LVL_CD) = @[f_ofc_cd]" ).append("\n"); 
		query.append("               AND TO_CHAR(SYSDATE,'YYYYMM') BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON ) A2" ).append("\n"); 
		query.append("WHERE  DECODE(@[f_ofc_lvl],'1',A1.OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("               , '2',A1.OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("               , '3',A1.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("               , '4',A1.OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("               , '5',A1.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("               , '6',A1.OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("               , '7',A1.OFC_N7TH_LVL_CD) = A2.OFC_CD" ).append("\n"); 
		query.append("       AND DECODE(@[f_ofc_lvl],'1',A1.OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("                   , '2',A1.OFC_N2ND_LVL_TP_CD" ).append("\n"); 
		query.append("                   , '3',A1.OFC_N3RD_LVL_TP_CD" ).append("\n"); 
		query.append("                   , '4',A1.OFC_N4TH_LVL_TP_CD" ).append("\n"); 
		query.append("                   , '5',A1.OFC_N5TH_LVL_TP_CD" ).append("\n"); 
		query.append("                   , '6',A1.OFC_N6TH_LVL_TP_CD" ).append("\n"); 
		query.append("                   , '7',A1.OFC_N7TH_LVL_TP_CD) IS NOT NULL" ).append("\n"); 
		query.append("       AND TO_CHAR(SYSDATE,'YYYYMM') BETWEEN A1.OFC_APLY_FM_YRMON AND A1.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("       AND (" ).append("\n"); 
		query.append("            A1.OFC_CD = A1.OFC_N1ST_LVL_CD AND A1.OFC_LVL = '1' " ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N2ND_LVL_CD AND A1.OFC_LVL = '2' AND A1.OFC_N2ND_LVL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N3RD_LVL_CD AND A1.OFC_LVL = '3' AND A1.OFC_N3RD_LVL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N4TH_LVL_CD AND A1.OFC_LVL = '4' AND A1.OFC_N4TH_LVL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N5TH_LVL_CD AND A1.OFC_LVL = '5' AND A1.OFC_N5TH_LVL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N6TH_LVL_CD AND A1.OFC_LVL = '6' AND A1.OFC_N6TH_LVL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N7TH_LVL_CD AND A1.OFC_LVL = '7' AND A1.OFC_N7TH_LVL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N7TH_LVL_CD AND A1.OFC_LVL = '9' " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("ORDER BY A1.OFC_LVL, A1.OFC_N1ST_LVL_CD,A1.OFC_N2ND_LVL_CD,A1.OFC_N3RD_LVL_CD,A1.OFC_N4TH_LVL_CD,A1.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("       , DECODE(OFC_N2ND_LVL_TP_CD,NULL,' ', OFC_N2ND_LVL_CD) AS ROOT2" ).append("\n"); 
		query.append("       , DECODE(OFC_N2ND_LVL_TP_CD,NULL,' ', OFC_N3RD_LVL_CD) AS ROOT3" ).append("\n"); 
		query.append("       , DECODE(OFC_N4TH_LVL_TP_CD,NULL,' ', OFC_N4TH_LVL_CD) AS ROOT4" ).append("\n"); 
		query.append("       , DECODE(OFC_N5TH_LVL_TP_CD,NULL,' ', OFC_N5TH_LVL_CD) AS ROOT5" ).append("\n"); 
		query.append("       , DECODE(OFC_N6TH_LVL_TP_CD,NULL,' ', OFC_N6TH_LVL_CD) AS ROOT6" ).append("\n"); 
		query.append("       , DECODE(OFC_N7TH_LVL_TP_CD,NULL,' ', OFC_N7TH_LVL_CD) AS ROOT7" ).append("\n"); 
		query.append("FROM   MAS_OFC_LVL A1" ).append("\n"); 
		query.append("WHERE  DECODE(@[f_rhq_cd],'1',OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("               , '2',OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("               , '3',OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("               , '4',OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("               , '5',OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("               , '6',OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("               , '7',OFC_N7TH_LVL_CD) = @[f_sls_ofc_cd]" ).append("\n"); 
		query.append("       AND DECODE(@[f_rhq_cd],'1',OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("                   , '2',OFC_N2ND_LVL_TP_CD" ).append("\n"); 
		query.append("                   , '3',OFC_N3RD_LVL_TP_CD" ).append("\n"); 
		query.append("                   , '4',OFC_N4TH_LVL_TP_CD" ).append("\n"); 
		query.append("                   , '5',OFC_N5TH_LVL_TP_CD" ).append("\n"); 
		query.append("                   , '6',OFC_N6TH_LVL_TP_CD" ).append("\n"); 
		query.append("                   , '7',OFC_N7TH_LVL_TP_CD) IS NOT NULL" ).append("\n"); 
		query.append("       AND TO_CHAR(SYSDATE,'YYYYMM') BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("       AND (" ).append("\n"); 
		query.append("            A1.OFC_CD = A1.OFC_N1ST_LVL_CD AND A1.OFC_LVL = '1' " ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N2ND_LVL_CD AND A1.OFC_LVL = '2' AND A1.OFC_N2ND_LVL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N3RD_LVL_CD AND A1.OFC_LVL = '3' AND A1.OFC_N3RD_LVL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N4TH_LVL_CD AND A1.OFC_LVL = '4' AND A1.OFC_N4TH_LVL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N5TH_LVL_CD AND A1.OFC_LVL = '5' AND A1.OFC_N5TH_LVL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N6TH_LVL_CD AND A1.OFC_LVL = '6' AND A1.OFC_N6TH_LVL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N7TH_LVL_CD AND A1.OFC_LVL = '7' AND A1.OFC_N7TH_LVL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("         OR A1.OFC_CD = A1.OFC_N7TH_LVL_CD AND A1.OFC_LVL = '9' " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("ORDER BY A1.OFC_LVL, A1.OFC_N1ST_LVL_CD,A1.OFC_N2ND_LVL_CD,A1.OFC_N3RD_LVL_CD,A1.OFC_N4TH_LVL_CD,A1.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}