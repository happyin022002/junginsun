/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOAddRowOusRdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.03.18 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOAddRowOusRdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Row Add로 VVD변경시 create에서 가져오는 모든 정보를 가져온다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOAddRowOusRdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOAddRowOusRdrRSQL").append("\n"); 
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
		query.append("SELECT T.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("     , T.BZC_PORT_ETA_DT" ).append("\n"); 
		query.append("     , TO_CHAR(T.BZC_PORT_ETA_DT,'YYYYMMDDHH24MISS') AS ETA_DT" ).append("\n"); 
		query.append("     , T.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("     , TO_CHAR(T.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("     , 0 AS FNL_OWN_BSA_QTY" ).append("\n"); 
		query.append("     , 0 AS FNL_BSA_WGT" ).append("\n"); 
		query.append("     , T.BSA_PER_WGT" ).append("\n"); 
		query.append("     , T.STL_VVD_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT J.STL_VVD_SEQ, J.STL_BZC_PORT_CD, J.BZC_PORT_ETD_DT BZC_PORT_ETA_DT, J.UC_BSS_PORT_CD, J.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("             -- 2010.01.19 PER WEIGHT는 CARRIER MERGE하지말고 해당 선사것만 가져온다." ).append("\n"); 
		query.append("             , TRUNC(SUM(C.CRR_BSA_CAPA),2) BSA_PER_WGT" ).append("\n"); 
		query.append("        FROM   JOO_STL_VVD     J" ).append("\n"); 
		query.append("              ,BSA_VVD_OTR_CRR C " ).append("\n"); 
		query.append("        WHERE  J.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("        AND    J.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("        AND    J.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("        AND    J.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("        AND    J.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("        -- OUS M/S 인 것을 제외하기 위함 => OTH에서 처리" ).append("\n"); 
		query.append("        AND    J.JO_MNU_NM     IN ('RDR','TDR')" ).append("\n"); 
		query.append("        AND    J.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("        AND    J.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("        AND    J.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND    J.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND    J.REV_DIR_CD    = @[rev_dir_cd]" ).append("\n"); 
		query.append("        AND    J.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("        AND    J.VSL_CD        = C.VSL_CD    (+)" ).append("\n"); 
		query.append("        AND    J.SKD_VOY_NO    = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND    J.SKD_DIR_CD    = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        AND    J.RLANE_CD      = C.RLANE_CD  (+)" ).append("\n"); 
		query.append("        AND    J.JO_CRR_CD     = C.CRR_CD    (+)" ).append("\n"); 
		query.append("        AND    J.TRD_CD        = C.TRD_CD    (+)" ).append("\n"); 
		query.append("        AND    C.BSA_OP_JB_CD(+) = '008'" ).append("\n"); 
		query.append("        GROUP  BY J.STL_VVD_SEQ, J.STL_BZC_PORT_CD, J.BZC_PORT_ETD_DT, J.UC_BSS_PORT_CD, J.UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("       )T" ).append("\n"); 

	}
}