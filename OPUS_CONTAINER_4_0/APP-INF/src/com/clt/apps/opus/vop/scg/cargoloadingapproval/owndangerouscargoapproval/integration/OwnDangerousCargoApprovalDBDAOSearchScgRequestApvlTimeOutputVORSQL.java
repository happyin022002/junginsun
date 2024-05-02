/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeOutputVORSQL.java
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

public class OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeOutputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일정기간 동안 Request 된 Special Cargo 승인요청에 대한 처리 시간을 조회한다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeOutputVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("proc_hour",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchScgRequestApvlTimeOutputVORSQL").append("\n"); 
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
		query.append("SELECT C.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(", C.TERM" ).append("\n"); 
		query.append("#foreach($key IN ${cgo_type_obj})" ).append("\n"); 
		query.append(", SUM(DECODE(C.SPCL_CGO_CATE_CD, '$key', C.TTL_NO, 0)) T_$key" ).append("\n"); 
		query.append(", SUM(DECODE(C.SPCL_CGO_CATE_CD, '$key', DECODE(C.AUTH_FLG, 0, 0, C.IN_NO), 0)) IN_$key" ).append("\n"); 
		query.append(", SUM(DECODE(C.SPCL_CGO_CATE_CD, '$key', DECODE(C.AUTH_FLG, 0, 0, C.OUT_NO), 0)) OUT_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT B.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(", (B.YYYY||DECODE(B.D_TERM, '', B.D_TERM, ' '||B.D_TERM||DECODE(@[term],'M','',@[term]))) AS TERM" ).append("\n"); 
		query.append(", A.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(", DECODE(B.TERM, A.C_TERM, 1, 0) TTL_NO" ).append("\n"); 
		query.append(", (CASE WHEN A.TRET_GAP <= TO_NUMBER(@[proc_hour]) THEN DECODE(B.TERM,A.C_TERM,1,0) ELSE 0 END) IN_NO" ).append("\n"); 
		query.append(", (CASE WHEN A.TRET_GAP >  TO_NUMBER(@[proc_hour]) THEN DECODE(B.TERM,A.C_TERM,1,0) ELSE 0 END) OUT_NO" ).append("\n"); 
		query.append(", A.AUTH_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT S1.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(", TO_CHAR(S1.RQST_GDT, 'YYYY') C_YYYY" ).append("\n"); 
		query.append(", DECODE(@[term], 'H', CEIL(EXTRACT(MONTH FROM S1.RQST_GDT)/6)" ).append("\n"); 
		query.append(", 'Q', CEIL(EXTRACT(MONTH FROM S1.RQST_GDT)/3)" ).append("\n"); 
		query.append(", 'M', EXTRACT(MONTH FROM S1.RQST_GDT)" ).append("\n"); 
		query.append(", 1" ).append("\n"); 
		query.append(") C_TERM" ).append("\n"); 
		query.append(", S1.BKG_NO" ).append("\n"); 
		query.append(", S1.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(", S1.VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", S1.VSL_SEQ" ).append("\n"); 
		query.append(", S1.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(", S1.AUTH_GDT" ).append("\n"); 
		query.append(", S1.RQST_GDT" ).append("\n"); 
		query.append(", S1.AUTH_FLG" ).append("\n"); 
		query.append(", CEIL((TO_DATE(SUBSTR(S1.AUTH_GDT,2),'YYYYMMDDHH24MISS')-S1.RQST_GDT)*24) TRET_GAP" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT RS.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(", R1.BKG_NO" ).append("\n"); 
		query.append(", R1.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(", R1.VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", R1.VSL_SEQ" ).append("\n"); 
		query.append(", R3.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(", R3.LST_RQST_DAT_FLG" ).append("\n"); 
		query.append(", AVG(DECODE(NVL(R2.SPCL_CGO_AUTH_CD,'R'),'Y',NULL,'P',-1,'N',1,0)) AUTH_FLG --AUTH_FLG=NULL --> Y, AUTH_FLG<0 --> P, AUTH_FLG>0 --> N, AUTH_FLG=0 --> R" ).append("\n"); 
		query.append(", MAX(R3.RQST_GDT) RQST_GDT" ).append("\n"); 
		query.append(", MAX(DECODE(NVL(R2.SPCL_CGO_AUTH_CD,'R'),'P',4,'N',3,'R',2,1)||TO_CHAR(NVL(R2.AUTH_GDT,R3.RQST_GDT),'YYYYMMDDHH24MISS')) AUTH_GDT" ).append("\n"); 
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
		query.append("AND VO.CRR_CD          = @[crr_cd] 		    --(5) VSL OPR" ).append("\n"); 
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
		query.append("GROUP BY" ).append("\n"); 
		query.append("RS.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(", R1.BKG_NO" ).append("\n"); 
		query.append(", R1.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(", R1.VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", R1.VSL_SEQ" ).append("\n"); 
		query.append(", R3.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(", R3.LST_RQST_DAT_FLG" ).append("\n"); 
		query.append(") S1" ).append("\n"); 
		query.append("WHERE S1.AUTH_FLG IS NULL OR S1.AUTH_FLG > 0 OR (S1.AUTH_FLG = 0 AND S1.LST_RQST_DAT_FLG = 'Y')" ).append("\n"); 
		query.append("#if (${option_pending} == 'Y')" ).append("\n"); 
		query.append("OR AUTH_FLG < 0 --(2) Option" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT TT.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(", TT.YYYY" ).append("\n"); 
		query.append(", TT.D_TERM" ).append("\n"); 
		query.append(", TT.TERM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT TS.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(", SUBSTR(TM.YYYYMM,1,4) YYYY" ).append("\n"); 
		query.append(", DECODE(@[term],'H',CEIL(EXTRACT(MONTH FROM TO_DATE(TM.YYYYMM,'YYYYMM'))/6)||''" ).append("\n"); 
		query.append(",'Q',CEIL(EXTRACT(MONTH FROM TO_DATE(TM.YYYYMM,'YYYYMM'))/3)||''" ).append("\n"); 
		query.append(",'M',TO_CHAR(TO_DATE(TM.YYYYMM,'YYYYMM'),'MM')" ).append("\n"); 
		query.append(",''" ).append("\n"); 
		query.append(") D_TERM" ).append("\n"); 
		query.append(", DECODE(@[term],'H',CEIL(EXTRACT(MONTH FROM TO_DATE(TM.YYYYMM,'YYYYMM'))/6)" ).append("\n"); 
		query.append(",'Q',CEIL(EXTRACT(MONTH FROM TO_DATE(TM.YYYYMM,'YYYYMM'))/3)" ).append("\n"); 
		query.append(",'M',EXTRACT(MONTH FROM TO_DATE(TM.YYYYMM,'YYYYMM'))" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(") TERM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT LEVEL TERM" ).append("\n"); 
		query.append(", TO_CHAR(ADD_MONTHS(TO_DATE(@[from_rqst_dt],'YYYYMMDD'),LEVEL-1),'YYYYMM') YYYYMM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("CONNECT BY LEVEL <= CEIL(MONTHS_BETWEEN(TO_DATE(@[to_rqst_dt],'YYYYMMDD'),TO_DATE(@[from_rqst_dt],'YYYYMMDD')+1))" ).append("\n"); 
		query.append(") TM" ).append("\n"); 
		query.append(", SCG_RGN_SHP_OPR_CD TS" ).append("\n"); 
		query.append("WHERE NVL(TS.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#if (${rgn_shp_opr_cd} != '')" ).append("\n"); 
		query.append("AND TS.RGN_SHP_OPR_CD = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") TT" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("TT.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(", TT.YYYY" ).append("\n"); 
		query.append(", TT.D_TERM" ).append("\n"); 
		query.append(", TT.TERM" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE B.RGN_SHP_OPR_CD = A.RGN_SHP_OPR_CD(+)" ).append("\n"); 
		query.append("AND B.YYYY           = A.C_YYYY(+)" ).append("\n"); 
		query.append("AND B.TERM           = A.C_TERM(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("GROUP BY C.RGN_SHP_OPR_CD, C.TERM" ).append("\n"); 
		query.append("ORDER BY C.RGN_SHP_OPR_CD, C.TERM" ).append("\n"); 

	}
}