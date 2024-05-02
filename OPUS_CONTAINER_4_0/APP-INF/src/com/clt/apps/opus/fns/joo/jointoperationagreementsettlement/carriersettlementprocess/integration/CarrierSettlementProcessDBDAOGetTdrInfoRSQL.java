/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOGetTdrInfoRSQL.java
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

public class CarrierSettlementProcessDBDAOGetTdrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OUS TDR row add 후 VVD입력시에 기본정보와 단가를 가져온다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOGetTdrInfoRSQL(){
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
		query.append("FileName : CarrierSettlementProcessDBDAOGetTdrInfoRSQL").append("\n"); 
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
		query.append("       A.ACCT_YRMON," ).append("\n"); 
		query.append("       A.STL_VVD_SEQ," ).append("\n"); 
		query.append("       A.TRD_CD," ).append("\n"); 
		query.append("       A.RLANE_CD," ).append("\n"); 
		query.append("       A.JO_CRR_CD," ).append("\n"); 
		query.append("       A.RE_DIVR_CD," ).append("\n"); 
		query.append("       A.JO_STL_ITM_CD," ).append("\n"); 
		query.append("       A.JO_MNU_NM," ).append("\n"); 
		query.append("       A.VSL_CD," ).append("\n"); 
		query.append("       A.SKD_VOY_NO," ).append("\n"); 
		query.append("       A.SKD_DIR_CD," ).append("\n"); 
		query.append("       A.REV_DIR_CD," ).append("\n"); 
		query.append("       A.STL_BZC_PORT_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.BZC_PORT_ETA_DT,'YYYYMMDDHH24MISS') ETA_DT," ).append("\n"); 
		query.append("       A.UC_BSS_PORT_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT," ).append("\n"); 
		query.append("       B.LOCL_CURR_CD," ).append("\n"); 
		query.append("       -- 2010.03.25 PORT 가 있어야 하므로 FM_PORT_CD변경시 가져온다." ).append("\n"); 
		query.append("       0 AS FNL_OWN_BSA_QTY," ).append("\n"); 
		query.append("       0 AS FNL_BSA_WGT," ).append("\n"); 
		query.append("       NVL(C.BSA_PER_WGT,0) AS BSA_PER_WGT" ).append("\n"); 
		query.append("FROM   JOO_STL_VVD  A," ).append("\n"); 
		query.append("       JOO_FINC_MTX B," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD, C.RLANE_CD, C.TRD_CD, C.CRR_CD," ).append("\n"); 
		query.append("              SUM(C.CRR_BSA_CAPA) AS BSA_PER_WGT" ).append("\n"); 
		query.append("         FROM BSA_VVD_OTR_CRR C" ).append("\n"); 
		query.append("        WHERE C.CRR_CD     = @[jo_crr_cd] " ).append("\n"); 
		query.append("          AND C.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("          AND C.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("          AND C.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("          AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("          AND C.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("          AND C.BSA_OP_JB_CD = '008'" ).append("\n"); 
		query.append("        GROUP BY C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD, C.RLANE_CD, C.TRD_CD, C.CRR_CD" ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append("WHERE  A.JO_CRR_CD     = B.JO_CRR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = B.RLANE_CD" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD    = B.RE_DIVR_CD" ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD = B.JO_STL_ITM_CD" ).append("\n"); 
		query.append("AND    A.VSL_CD        = C.VSL_CD    (+)" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO    = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD    = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = C.RLANE_CD  (+)" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = C.CRR_CD    (+)" ).append("\n"); 
		query.append("AND    A.TRD_CD        = C.TRD_CD    (+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("AND    A.JO_MNU_NM    IN ('RDR','TDR')" ).append("\n"); 
		query.append("AND    A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("AND    A.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    A.REV_DIR_CD    = @[rev_dir_cd]" ).append("\n"); 

	}
}