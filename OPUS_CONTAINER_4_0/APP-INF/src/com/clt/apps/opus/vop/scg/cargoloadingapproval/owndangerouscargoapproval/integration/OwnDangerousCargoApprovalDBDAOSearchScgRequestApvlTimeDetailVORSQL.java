/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.05.11 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일정기간 동안 Request 된 Special Cargo 승인요청에 대한 처리 시간에 대한 상세목록을 조회한다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeDetailVORSQL").append("\n"); 
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
		query.append("SELECT S1.SLAN_CD" ).append("\n"); 
		query.append(", S1.VSL_CD||S1.SKD_VOY_NO||S1.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append(", DECODE(S1.VSL_PRE_PST_CD,'S','Pre'||S1.VSL_SEQ,'T','Trunk','U','Post'||S1.VSL_SEQ) AS VSL_PRE_PST_NM" ).append("\n"); 
		query.append(", S1.BKG_NO" ).append("\n"); 
		query.append(", S1.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(", S1.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(", TO_CHAR(S1.RQST_DT, 'YYYY-MM-DD HH24:MI') RQST_DT" ).append("\n"); 
		query.append(", S1.RQST_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(S1.AUTH_DT, 'YYYY-MM-DD HH24:MI') AUTH_DT" ).append("\n"); 
		query.append(", S1.AUTH_USR_ID" ).append("\n"); 
		query.append(", S1.AUTH_FLG" ).append("\n"); 
		query.append(", DECODE(S1.AUTH_FLG,'R','',CEIL((S1.AUTH_DT-S1.RQST_DT)*24)) TRET_GAP" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT R1.SLAN_CD" ).append("\n"); 
		query.append(", R1.VSL_CD" ).append("\n"); 
		query.append(", R1.SKD_VOY_NO" ).append("\n"); 
		query.append(", R1.SKD_DIR_CD" ).append("\n"); 
		query.append(", R1.BKG_NO" ).append("\n"); 
		query.append(", R1.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(", R1.VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", R1.VSL_SEQ" ).append("\n"); 
		query.append(", R3.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(", R3.LST_RQST_DAT_FLG" ).append("\n"); 
		query.append(", R3.RQST_USR_ID" ).append("\n"); 
		query.append(", R2.AUTH_USR_ID" ).append("\n"); 
		query.append(", R3.RQST_DT" ).append("\n"); 
		query.append(", R2.AUTH_DT" ).append("\n"); 
		query.append(", NVL(R2.SPCL_CGO_AUTH_CD,'R') AS AUTH_FLG" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER(PARTITION BY R1.BKG_NO" ).append("\n"); 
		query.append(", R1.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(", R1.VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", R1.VSL_SEQ" ).append("\n"); 
		query.append(", R3.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("DECODE(NVL(R2.SPCL_CGO_AUTH_CD,'R'),'P',1,'N',2,'R',3,4)) AUTH_FIX" ).append("\n"); 
		query.append("FROM SCG_VVD_APRO_RQST    R1" ).append("\n"); 
		query.append(", SCG_AUTHORIZATION    R2" ).append("\n"); 
		query.append(", SCG_APRO_RQST        R3" ).append("\n"); 
		query.append(", SCG_RGN_SHP_OPR_PORT RS" ).append("\n"); 
		query.append(", MDM_VSL_CNTR         VO" ).append("\n"); 
		query.append("WHERE R1.BKG_NO                 = R2.BKG_NO(+)" ).append("\n"); 
		query.append("AND R1.SPCL_CGO_APRO_RQST_SEQ = R2.SPCL_CGO_APRO_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND R1.BKG_NO                 = R3.BKG_NO(+)" ).append("\n"); 
		query.append("AND R1.SPCL_CGO_APRO_RQST_SEQ = R3.SPCL_CGO_APRO_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND R1.POL_CD                 = RS.LOC_CD(+)" ).append("\n"); 
		query.append("AND R1.VSL_CD                 = VO.VSL_CD(+)" ).append("\n"); 
		query.append("AND RS.RGN_SHP_OPR_CD        IS NOT NULL" ).append("\n"); 
		query.append("AND (R2.SPCL_CGO_AUTH_CD != 'D' OR R2.SPCL_CGO_AUTH_CD IS NULL)" ).append("\n"); 
		query.append("AND R3.RQST_GDT BETWEEN TO_DATE(@[from_rqst_dt]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[to_rqst_dt]||'235959','YYYYMMDDHH24MISS') --(3) Period" ).append("\n"); 
		query.append("#if (${rgn_shp_opr_cd} != '')" ).append("\n"); 
		query.append("AND RS.RGN_SHP_OPR_CD   = @[rgn_shp_opr_cd] 	--(1) RSO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("AND VO.CRR_CD           = @[crr_cd] 			--(5) VSL OPR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("AND R1.SLAN_CD          = @[slan_cd] 		--(6) Lane" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND R1.VSL_CD           = @[vsl_cd] 			--(7) VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("AND R1.SKD_VOY_NO       = @[skd_voy_no] 		--(7) VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND R1.SKD_DIR_CD       = @[skd_dir_cd] 		--(7) VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${option_post_vvd} == 'E')" ).append("\n"); 
		query.append("AND R1.VSL_PRE_PST_CD  != 'U' 		        --(9) EXCLUDE POST VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND R3.SPCL_CGO_CATE_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${cgo_type_obj})" ).append("\n"); 
		query.append("#if($velocityCount < $cgo_type_obj.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")    --(8) SPCL CGO Type" ).append("\n"); 
		query.append(") S1" ).append("\n"); 
		query.append("WHERE S1.AUTH_FIX = 1" ).append("\n"); 
		query.append("AND (S1.AUTH_FLG = 'Y' OR S1.AUTH_FLG = 'N' OR (S1.AUTH_FLG = 'R' AND S1.LST_RQST_DAT_FLG = 'Y')" ).append("\n"); 
		query.append("#if (${option_pending} == 'Y')" ).append("\n"); 
		query.append("OR AUTH_FLG = 'P') --(2) Option" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("S1.SLAN_CD" ).append("\n"); 
		query.append(", S1.VSL_CD" ).append("\n"); 
		query.append(", S1.SKD_VOY_NO" ).append("\n"); 
		query.append(", S1.SKD_DIR_CD" ).append("\n"); 
		query.append(", S1.BKG_NO" ).append("\n"); 
		query.append(", S1.VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", S1.VSL_SEQ" ).append("\n"); 
		query.append(", S1.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(", S1.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 

	}
}