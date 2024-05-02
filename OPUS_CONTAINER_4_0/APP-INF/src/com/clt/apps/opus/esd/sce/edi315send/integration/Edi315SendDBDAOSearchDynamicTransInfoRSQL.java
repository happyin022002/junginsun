/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOSearchDynamicTransInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.04.27 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchDynamicTransInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 동적 TransInfo 조회
	  * </pre>
	  */
	public Edi315SendDBDAOSearchDynamicTransInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchDynamicTransInfoRSQL").append("\n"); 
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
		query.append("SELECT TRANS_TP_CD" ).append("\n"); 
		query.append("     , VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("     , COP_DTL_SEQ -- 다음 단계의 Parameter" ).append("\n"); 
		query.append("     , NOD_CD" ).append("\n"); 
		query.append("     , TRANS_TP_CD||TO_CHAR(ROWNUM + 1) AS TRANS_TP_KEY /*OBSTRT, OBIMD 2개의 아이템 다음에 오기대문에 Key 를 만들때 +2 를 해준다.*/ -- OBSTRT를 포함하기 위해 + 1" ).append("\n"); 
		query.append("  FROM (SELECT TRANS_TP_CD" ).append("\n"); 
		query.append("             , VSL_CD" ).append("\n"); 
		query.append("             , SKD_VOY_NO" ).append("\n"); 
		query.append("             , SKD_DIR_CD" ).append("\n"); 
		query.append("             , NOD_CD -- 0715 추가" ).append("\n"); 
		query.append("             , COP_DTL_SEQ" ).append("\n"); 
		query.append("          FROM (SELECT 'OBIMD' AS TRANS_TP_CD" ).append("\n"); 
		query.append("                     , '' AS VSL_CD" ).append("\n"); 
		query.append("                     , '' AS SKD_VOY_NO" ).append("\n"); 
		query.append("                     , '' AS SKD_DIR_CD" ).append("\n"); 
		query.append("                     , NOD_CD AS NOD_CD -- 0715 추가" ).append("\n"); 
		query.append("                     , COP_DTL_SEQ" ).append("\n"); 
		query.append("                  FROM SCE_COP_HDR SCH" ).append("\n"); 
		query.append("                     , SCE_COP_DTL SCD" ).append("\n"); 
		query.append("                 WHERE SCH.COP_NO = @[cop_no] --paremter" ).append("\n"); 
		query.append("                   AND SCH.COP_NO = SCD.COP_NO" ).append("\n"); 
		query.append("                   AND SUBSTR(ACT_CD,2,1) = 'O'" ).append("\n"); 
		query.append("                   AND SUBSTR(ACT_CD,5,2) IN  ('DO') -- 출발지 기준 조회" ).append("\n"); 
		query.append("                   AND SUBSTR(ACT_CD,1,1) = 'F'" ).append("\n"); 
		query.append("                   AND SUBSTR(SCH.POR_NOD_CD, 1, 5) <> SUBSTR(SCH.POL_NOD_CD,1,5)" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT DECODE(VSL_PRE_PST_CD, 'S','TRNKPC', 'T', 'TRNKMC', 'U','TRNKOC') AS TRANS_TP_CD" ).append("\n"); 
		query.append("                     , BV.VSL_CD" ).append("\n"); 
		query.append("                     , BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , POL_YD_CD AS NOD_CD -- 0717 추가 " ).append("\n"); 
		query.append("                     , MIN(COP_DTL_SEQ)" ).append("\n"); 
		query.append("                  FROM SCE_COP_HDR SCH" ).append("\n"); 
		query.append("                     , MDM_VSL_CNTR MVC" ).append("\n"); 
		query.append("                     , BKG_VVD BV" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                     , MDM_VSL_SVC_LANE MV" ).append("\n"); 
		query.append("                     , SCE_COP_DTL SCD" ).append("\n"); 
		query.append("                 WHERE SCH.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("                   AND SCH.COP_NO = @[cop_no] --parameter" ).append("\n"); 
		query.append("                   AND BV.VSL_CD = MVC.VSL_CD(+)" ).append("\n"); 
		query.append("                   AND SCH.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_VOY_NO(+) = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD.SKD_DIR_CD(+) = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SKD.VPS_PORT_CD(+) = BV.POL_YD_CD" ).append("\n"); 
		query.append("                   AND SKD.CLPT_IND_SEQ(+) = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   AND BV.SLAN_CD = MV.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("                   AND SUBSTR(SCD.NOD_CD, 1, 5)  = SUBSTR(BV.POL_YD_CD, 1, 5)" ).append("\n"); 
		query.append("                   AND SCH.COP_NO = SCD.COP_NO" ).append("\n"); 
		query.append("                   AND SCD.VSL_CD is not null" ).append("\n"); 
		query.append("                   GROUP BY DECODE(VSL_PRE_PST_CD, 'S','TRNKPC', 'T', 'TRNKMC', 'U','TRNKOC') " ).append("\n"); 
		query.append("                     , BV.VSL_CD" ).append("\n"); 
		query.append("                     , BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , POL_YD_CD" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("            SELECT 'TRNKTT' AS TRANS_TP_CD" ).append("\n"); 
		query.append("                     , '' AS VSL_CD" ).append("\n"); 
		query.append("                     , '' AS SKD_VOY_NO" ).append("\n"); 
		query.append("                     , '' AS SKD_DIR_CD" ).append("\n"); 
		query.append("                     , NOD_CD AS NOD_CD -- 0715 추가" ).append("\n"); 
		query.append("                     , COP_DTL_SEQ" ).append("\n"); 
		query.append("                  FROM SCE_COP_DTL" ).append("\n"); 
		query.append("                 WHERE COP_NO = @[cop_no] --paremter" ).append("\n"); 
		query.append("                   AND ACT_CD = 'FTTMDO'" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("            SELECT 'IBIMD' AS TRANS_TP_CD" ).append("\n"); 
		query.append("                     , '' AS VSL_CD" ).append("\n"); 
		query.append("                     , '' AS SKD_VOY_NO" ).append("\n"); 
		query.append("                     , '' AS SKD_DIR_CD" ).append("\n"); 
		query.append("                     , NOD_CD AS NOD_CD -- 0715 추가" ).append("\n"); 
		query.append("                     , COP_DTL_SEQ" ).append("\n"); 
		query.append("                  FROM SCE_COP_HDR SCH" ).append("\n"); 
		query.append("                     , SCE_COP_DTL SCD" ).append("\n"); 
		query.append("                 WHERE SCH.COP_NO = @[cop_no] --paremter" ).append("\n"); 
		query.append("                   AND SCH.COP_NO = SCD.COP_NO" ).append("\n"); 
		query.append("                   AND SUBSTR(ACT_CD,2,1) = 'I'" ).append("\n"); 
		query.append("                   AND SUBSTR(ACT_CD,5,2) IN ('AD') --- 도착지 " ).append("\n"); 
		query.append("                   AND SUBSTR(ACT_CD,1,1) = 'F'" ).append("\n"); 
		query.append("                   AND SUBSTR(SCH.DEL_NOD_CD, 1, 5) <> SUBSTR(SCH.POD_NOD_CD,1,5) -- IMD " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("         ORDER BY COP_DTL_SEQ " ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}