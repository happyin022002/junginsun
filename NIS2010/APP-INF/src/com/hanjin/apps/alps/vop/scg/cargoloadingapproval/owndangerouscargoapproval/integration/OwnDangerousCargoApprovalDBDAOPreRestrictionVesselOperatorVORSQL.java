/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOPreRestrictionVesselOperatorVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOPreRestrictionVesselOperatorVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pre Checking Report 화면의 Vessel Operator’s Prohibition 목록을 가져온다.
	  * History------------------------------------------------------------------------------------
	  * 2011.12.21 [CHM-201115154-01] 김민아 [VOP-SCG] Pre checking Report 시스템 개선 요청 : CRR_REGU_DESC 컬럼 추가 조회
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOPreRestrictionVesselOperatorVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opt_clss",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOPreRestrictionVesselOperatorVORSQL").append("\n"); 
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
		query.append("##------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("##설명" ).append("\n"); 
		query.append("##1. IN_UN_NO_TBL    : 컨테이너별 Un No. 의 임시 테이블을 생성한다." ).append("\n"); 
		query.append("##2. IN_CRR_RSTR_TBL : 자사/타사(Target Lane에 해당하는 VVD만)의 Vessel에 대한 Un No./Class 별 제약목록을 임시 테이블로 생성한다." ).append("\n"); 
		query.append("##3. <Main Query>    : 2번에 해당하는 1번의 목록을 생성한다." ).append("\n"); 
		query.append("##4. <Note>          : (1)위의 쿼리가 2번 수행된다." ).append("\n"); 
		query.append("##                     (2)먼저 Un No.에 대한 체크, 이후 Class에 대한 체크를 수행한다." ).append("\n"); 
		query.append("##                     (3)UN No.로 체크했을 경우 C(Excepted fm Class Prohibition, Target Lane에 포함되지 않은 VVD일 경우-타사제외)일 경우만 제외하고 Class로 재체크를 한다." ).append("\n"); 
		query.append("##                     (4)두개의 체크 모두 Prohibition이 L,P,T인 경우만 목록으로 리턴한다." ).append("\n"); 
		query.append("##------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("WITH IN_UN_NO_TBL AS (" ).append("\n"); 
		query.append("#foreach(${obj} in ${opt_obj})" ).append("\n"); 
		query.append("     SELECT '$obj.getSpclCntrSeq()' AS SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("          , '$obj.getSpclCgoSeq()'  AS SPCL_CGO_SEQ" ).append("\n"); 
		query.append("          , '$obj.getImdgUnNo()'    AS IMDG_UN_NO" ).append("\n"); 
		query.append("          , '$obj.getImdgUnNoSeq()' AS IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("          , '$obj.getImdgClssCd()'  AS IMDG_CLSS_CD" ).append("\n"); 
		query.append("          , @[vsl_cd]               AS VSL_CD" ).append("\n"); 
		query.append("          , @[skd_voy_no]           AS SKD_VOY_NO" ).append("\n"); 
		query.append("          , @[skd_dir_cd]           AS SKD_DIR_CD" ).append("\n"); 
		query.append("          , @[crr_cd]               AS CRR_CD" ).append("\n"); 
		query.append("          , @[slan_cd]              AS SLAN_CD" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("     #if($velocityCount < ${obj_size})" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("IN_VVD_TBL AS (" ).append("\n"); 
		query.append("	 SELECT E.BKG_NO" ).append("\n"); 
		query.append("       	  , E.VSL_CD" ).append("\n"); 
		query.append("       	  , E.SKD_VOY_NO" ).append("\n"); 
		query.append("	   	  , E.SKD_DIR_CD" ).append("\n"); 
		query.append("      	  , E.CRR_CD" ).append("\n"); 
		query.append("     	  , E.SLAN_CD" ).append("\n"); 
		query.append("	   	  , SUM(E.SOURCE) AS SOURCE" ).append("\n"); 
		query.append("	  FROM ( " ).append("\n"); 
		query.append("	     SELECT A.BKG_NO" ).append("\n"); 
		query.append("              , A.VSL_CD" ).append("\n"); 
		query.append("       		  , A.SKD_VOY_NO" ).append("\n"); 
		query.append("	          , A.SKD_DIR_CD" ).append("\n"); 
		query.append("              , B.CRR_CD" ).append("\n"); 
		query.append("       		  , A.SLAN_CD" ).append("\n"); 
		query.append("	          , 2 AS SOURCE" ).append("\n"); 
		query.append("          FROM  BKG_VVD          A                  " ).append("\n"); 
		query.append("    		  , MDM_VSL_CNTR     B" ).append("\n"); 
		query.append("		 WHERE A.BKG_NO   = @[bkg_no]                " ).append("\n"); 
		query.append("           AND A.VSL_CD   = B.VSL_CD" ).append("\n"); 
		query.append("		 UNION ALL" ).append("\n"); 
		query.append("         SELECT @[bkg_no]               AS BKG_NO" ).append("\n"); 
		query.append("         	  , @[vsl_cd]               AS VSL_CD" ).append("\n"); 
		query.append("		      , @[skd_voy_no]           AS SKD_VOY_NO" ).append("\n"); 
		query.append("              , @[skd_dir_cd]           AS SKD_DIR_CD" ).append("\n"); 
		query.append("        	  , @[crr_cd]               AS CRR_CD" ).append("\n"); 
		query.append("		      , @[slan_cd]              AS SLAN_CD" ).append("\n"); 
		query.append("              , 1 AS SOURCE" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("	#if (${dummy_cd} != 'SML')" ).append("\n"); 
		query.append("		 UNION ALL" ).append("\n"); 
		query.append("         SELECT @[bkg_no]               AS BKG_NO" ).append("\n"); 
		query.append("         	  , ''               		AS VSL_CD" ).append("\n"); 
		query.append("		      , ''           			AS SKD_VOY_NO" ).append("\n"); 
		query.append("              , ''           			AS SKD_DIR_CD" ).append("\n"); 
		query.append("        	  , 'SML'                   AS CRR_CD" ).append("\n"); 
		query.append("		      , 'AKJ'					AS SLAN_CD" ).append("\n"); 
		query.append("              , 1 AS SOURCE" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			) E" ).append("\n"); 
		query.append("		,	MDM_VSL_SVC_LANE  F" ).append("\n"); 
		query.append("	 WHERE E.SLAN_CD  = F.VSL_SLAN_CD" ).append("\n"); 
		query.append("       AND F.DELT_FLG = 'N'" ).append("\n"); 
		query.append("	   AND DECODE(E.SOURCE, 1, '1', 'Y') = DECODE(E.SOURCE, 1, '1', F.SPCL_CGO_RQST_TGT_LANE_FLG)" ).append("\n"); 
		query.append("       GROUP BY E.BKG_NO" ).append("\n"); 
		query.append("		      , E.VSL_CD" ).append("\n"); 
		query.append("        	  , E.SKD_VOY_NO" ).append("\n"); 
		query.append("	          , E.SKD_DIR_CD" ).append("\n"); 
		query.append("    	      , E.CRR_CD" ).append("\n"); 
		query.append("        	  , E.SLAN_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("IN_UN_VVD_TBL AS (" ).append("\n"); 
		query.append("	 SELECT A.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("          , A.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("          , A.IMDG_UN_NO" ).append("\n"); 
		query.append("          , A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("          , A.IMDG_CLSS_CD" ).append("\n"); 
		query.append("          , B.VSL_CD" ).append("\n"); 
		query.append("          , B.SKD_VOY_NO" ).append("\n"); 
		query.append("          , B.SKD_DIR_CD" ).append("\n"); 
		query.append("          , B.CRR_CD" ).append("\n"); 
		query.append("          , B.SLAN_CD" ).append("\n"); 
		query.append("	  FROM  IN_UN_NO_TBL A" ).append("\n"); 
		query.append("		, 	IN_VVD_TBL B" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("IN_RSTR_VVD_TBL AS ( " ).append("\n"); 
		query.append("	 SELECT IMDG_UN_NO" ).append("\n"); 
		query.append("          , IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("          , IMDG_CLSS_CD" ).append("\n"); 
		query.append("          , DECODE(IMDG_CRR_RSTR_EXPT_SEQ,4,'L',3,'P',2,'C',1,'R','T') AS IMDG_CRR_RSTR_EXPT_CD" ).append("\n"); 
		query.append("          , VSL_OPR_TP_CD" ).append("\n"); 
		query.append("          , CRR_REGU_DESC" ).append("\n"); 
		query.append("	 FROM (" ).append("\n"); 
		query.append("		 SELECT D.IMDG_UN_NO" ).append("\n"); 
		query.append("    	      , D.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("        	  , D.IMDG_CLSS_CD" ).append("\n"); 
		query.append("          	  , MAX(DECODE(D.IMDG_CRR_RSTR_EXPT_CD,'L',4,'P',3,'C',2,'R',1,0)) AS IMDG_CRR_RSTR_EXPT_SEQ" ).append("\n"); 
		query.append("	          , D.VSL_OPR_TP_CD" ).append("\n"); 
		query.append("	          , D.CRR_REGU_DESC" ).append("\n"); 
		query.append("    	  FROM  SCG_IMDG_CRR_RSTR D " ).append("\n"); 
		query.append("			,	IN_VVD_TBL E" ).append("\n"); 
		query.append("    	 WHERE  D.VSL_OPR_TP_CD			= E.CRR_CD" ).append("\n"); 
		query.append("           AND	DECODE(D.IMDG_CRR_RSTR_EXPT_CD, 'L', D.SLAN_CD, 1) = DECODE(D.IMDG_CRR_RSTR_EXPT_CD, 'L', E.SLAN_CD, 1)" ).append("\n"); 
		query.append("	#if (${opt_clss} == 'U')" ).append("\n"); 
		query.append("    	   AND  D.IMDG_UN_NO IS NOT NULL" ).append("\n"); 
		query.append("	#elseif (${opt_clss} == 'C')" ).append("\n"); 
		query.append("    	   AND  D.IMDG_CRR_RSTR_EXPT_CD != 'R'" ).append("\n"); 
		query.append("           AND  D.IMDG_UN_NO            IS NULL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		 GROUP BY D.IMDG_UN_NO" ).append("\n"); 
		query.append("         	    , D.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("          	    , D.IMDG_CLSS_CD" ).append("\n"); 
		query.append("          	    , D.VSL_OPR_TP_CD" ).append("\n"); 
		query.append("          	    , D.CRR_REGU_DESC" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT UT.SPCL_CNTR_SEQ                                             AS SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("     , UT.SPCL_CGO_SEQ                                              AS SPCL_CGO_SEQ" ).append("\n"); 
		query.append("     , UT.IMDG_UN_NO                                                AS IMDG_UN_NO" ).append("\n"); 
		query.append("     , UT.IMDG_UN_NO_SEQ                                            AS IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("     , UT.IMDG_CLSS_CD                                              AS IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , UT.VSL_CD                                                    AS VSL_CD" ).append("\n"); 
		query.append("     , UT.SKD_VOY_NO                                                AS SKD_VOY_NO" ).append("\n"); 
		query.append("     , UT.SKD_DIR_CD                                                AS SKD_DIR_CD" ).append("\n"); 
		query.append("     , UT.VSL_CD||UT.SKD_VOY_NO||UT.SKD_DIR_CD                      AS VVD_CD" ).append("\n"); 
		query.append("     , UT.CRR_CD                                                    AS CRR_CD" ).append("\n"); 
		query.append("     , UT.SLAN_CD                                                   AS SLAN_CD" ).append("\n"); 
		query.append("	 , RT.IMDG_CRR_RSTR_EXPT_CD         							AS PROHIBITION_CD" ).append("\n"); 
		query.append("     , DECODE(@[opt_clss],'U','UN No.','Class')||' - '||" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT CD.INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL CD " ).append("\n"); 
		query.append("         WHERE CD.INTG_CD_ID = 'CD01950' " ).append("\n"); 
		query.append("           AND CD.INTG_CD_VAL_CTNT = RT.IMDG_CRR_RSTR_EXPT_CD" ).append("\n"); 
		query.append("       )                                        AS PROHIBITION_DESC " ).append("\n"); 
		query.append("     , DECODE(@[opt_clss],'U','UN No.','Class') AS CHK_TYPE" ).append("\n"); 
		query.append("     , RT.CRR_REGU_DESC                         AS CRR_REGU_DESC" ).append("\n"); 
		query.append("  FROM IN_UN_VVD_TBL    UT" ).append("\n"); 
		query.append("     , IN_RSTR_VVD_TBL  RT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${opt_clss} == 'U')" ).append("\n"); 
		query.append("   AND UT.IMDG_UN_NO     = RT.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("   AND UT.IMDG_UN_NO_SEQ = RT.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("   AND UT.CRR_CD         = RT.VSL_OPR_TP_CD(+)" ).append("\n"); 
		query.append("#elseif (${opt_clss} == 'C') " ).append("\n"); 
		query.append("   AND UT.IMDG_CLSS_CD   = RT.IMDG_CLSS_CD" ).append("\n"); 
		query.append("   AND UT.CRR_CD         = RT.VSL_OPR_TP_CD" ).append("\n"); 
		query.append("--   AND (UT.SLAN_CD IS NOT NULL OR UT.SOURCE = 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY " ).append("\n"); 
		query.append("       UT.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("     , UT.SPCL_CGO_SEQ" ).append("\n"); 

	}
}