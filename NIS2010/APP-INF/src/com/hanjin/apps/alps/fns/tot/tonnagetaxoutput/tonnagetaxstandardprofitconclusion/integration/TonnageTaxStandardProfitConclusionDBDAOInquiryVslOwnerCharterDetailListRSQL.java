/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOInquiryVslOwnerCharterDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.22
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.11.22 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAOInquiryVslOwnerCharterDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InquiryVslOwnerCharterDetailList
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOInquiryVslOwnerCharterDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration ").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOInquiryVslOwnerCharterDetailListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  A.TRD_CD" ).append("\n"); 
		query.append(", A.SLAN_CD" ).append("\n"); 
		query.append(", A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD     VVD" ).append("\n"); 
		query.append(", A.PORT_CD" ).append("\n"); 
		query.append(", A.LDB_CAPA_QTY" ).append("\n"); 
		query.append(", A.BSA_CAPA" ).append("\n"); 
		query.append(", A.CHTR_BSA_CAPA" ).append("\n"); 
		query.append(", A.ACT_BSA_CAPA" ).append("\n"); 
		query.append(", A.LDB_CAPA_QTY - A.ACT_BSA_CAPA     CAPA_DIFF" ).append("\n"); 
		query.append(", A.USG_RT" ).append("\n"); 
		query.append(", NVL(TO_CHAR(A.ETD_DT, 'YYYYMMDD'),'')   ETD_DT" ).append("\n"); 
		query.append(", A.VOY_DYS" ).append("\n"); 
		query.append(", TRUNC(A.TONG_TAX_AMT,0)  TONG_TAX_AMT" ).append("\n"); 
		query.append(", A.BSA_CAPA_MODI_FLG" ).append("\n"); 
		query.append(", A.CRE_DT" ).append("\n"); 
		query.append(", A.CRE_USR_ID" ).append("\n"); 
		query.append(", A.UPD_DT" ).append("\n"); 
		query.append(", A.UPD_USR_ID" ).append("\n"); 
		query.append(", A.STL_YRMON" ).append("\n"); 
		query.append(", A.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append(", A.VSL_CD" ).append("\n"); 
		query.append(", A.PORT_SEQ" ).append("\n"); 
		query.append(", A.LDB_CAPA_QTY  VSL_DZND_CAPA" ).append("\n"); 
		query.append(", A.VOY_DYS        OLD_VOY_DYS" ).append("\n"); 
		query.append(", B.TONG_FLET_TP_CD" ).append("\n"); 
		query.append(", A.PER_TON_REV" ).append("\n"); 
		query.append(", NVL(TO_CHAR(B.TO_VVD_STL_DT, 'YYYYMMDD'),'')   TO_VVD_STL_DT" ).append("\n"); 
		query.append(", 'N' LAST_ROW_YN" ).append("\n"); 
		query.append(", 0 DYS_DIFF" ).append("\n"); 
		query.append(", 0 TOTAL_VOY_DYS " ).append("\n"); 
		query.append(", 0 TOTAL_TAX_AMT" ).append("\n"); 
		query.append("FROM TOT_PORT_STL_AMT A, TOT_VVD_STL_AMT B" ).append("\n"); 
		query.append("WHERE A.STL_YRMON           = B.STL_YRMON" ).append("\n"); 
		query.append("AND   A.TONG_STL_BAT_JB_SEQ = B.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append("AND   A.VSL_CD              = B.VSL_CD" ).append("\n"); 
		query.append("AND   A.STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND   A.VSL_CD    = @[vsl_cd]" ).append("\n"); 
		query.append("AND	  A.TONG_STL_BAT_JB_SEQ = (" ).append("\n"); 
		query.append("          SELECT MAX(TONG_STL_BAT_JB_SEQ) " ).append("\n"); 
		query.append("          FROM  TOT_VVD_STL_AMT " ).append("\n"); 
		query.append("          WHERE STL_YRMON = @[stl_yrmon] " ).append("\n"); 
		query.append("-- FEEDER 인 것은 뺀 것중에서 MAX SEQ를 구한다." ).append("\n"); 
		query.append("          AND   NVL(TONG_FLET_TP_CD,'C') <> 'F'" ).append("\n"); 
		query.append("#if (${trd_cd} != 'ALL' )" ).append("\n"); 
		query.append("          AND TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#if (${trd_cd} != 'ALL' ) " ).append("\n"); 
		query.append("AND	  A.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.ETD_DT, PORT_SEQ ASC" ).append("\n"); 

	}
}