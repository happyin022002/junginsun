/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtDBDAOBSACreateByVesselVoyageVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.12.08 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Chang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxOutputMasterDataMgtDBDAOBSACreateByVesselVoyageVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BAS Creation by Vessel Voyage 조회
	  * </pre>
	  */
	public TonnageTaxOutputMasterDataMgtDBDAOBSACreateByVesselVoyageVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration").append("\n"); 
		query.append("FileName : TonnageTaxOutputMasterDataMgtDBDAOBSACreateByVesselVoyageVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.TRD_CD" ).append("\n"); 
		query.append(", A.SLAN_CD" ).append("\n"); 
		query.append(", A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD" ).append("\n"); 
		query.append(", A.NRT_WGT" ).append("\n"); 
		query.append(", A.INTL_TONG_CERTI_FLG" ).append("\n"); 
		query.append(", A.LDB_CAPA_QTY" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT MAX(T.LDB_CAPA_QTY)" ).append("\n"); 
		query.append("FROM TOT_BSA T" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("T.STL_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[stl_yrmon],'YYYYMM'),-1),'YYYYMM')" ).append("\n"); 
		query.append("AND T.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append(") PREV_LDB_CAPA_QTY" ).append("\n"); 
		query.append(", A.T_FNL                            FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append(", C_FNL                              FNL_HJS_COA_CAPA" ).append("\n"); 
		query.append(", C_FNL-A.T_FNL                      DIFF" ).append("\n"); 
		query.append(",	A.STL_YRMON" ).append("\n"); 
		query.append(",	A.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append(",	A.MODI_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT T.TRD_CD, T.SLAN_CD, T.VSL_CD, T.SKD_VOY_NO, T.SKD_DIR_CD, T.NRT_WGT, T.INTL_TONG_CERTI_FLG" ).append("\n"); 
		query.append(", T.LDB_CAPA_QTY, T.FNL_HJS_BSA_CAPA T_FNL, T.CRR_BSA_CAPA T_CRR, C.FNL_HJS_BSA_CAPA C_FNL, T.STL_YRMON, T.TONG_STL_BAT_JB_SEQ, T.MODI_FLG" ).append("\n"); 
		query.append("FROM TOT_BSA T, BSA_VVD_MST C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${search_flg} == 'A')" ).append("\n"); 
		query.append("#if (${trd_cd} != 'ALL')" ).append("\n"); 
		query.append("AND T.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND T.TRD_CD = C.TRD_CD(+)" ).append("\n"); 
		query.append("AND C.RLANE_CD(+) LIKE T.SLAN_CD||'%'" ).append("\n"); 
		query.append("AND T.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("AND T.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND T.SKD_DIR_CD = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND T.STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append(") A,  BSA_VVD_CRR_PERF B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.TRD_CD = B.TRD_CD(+)" ).append("\n"); 
		query.append("AND B.RLANE_CD(+) LIKE A.SLAN_CD||'%'" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND B.BSA_OP_JB_CD(+) = '002'" ).append("\n"); 
		query.append("AND B.CRR_CD(+) = 'UAC'" ).append("\n"); 
		query.append("AND B.TRD_CD(+) = 'TPS'" ).append("\n"); 

	}
}