/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstDupSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.05.19 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstDupSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dangerous CGO Application Details for Partner Lines 의 Booking 중복 Sequence 조회
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstDupSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstDupSeqRSQL").append("\n"); 
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
		query.append("##SELECT CGO.CGO_OPR_CD" ).append("\n"); 
		query.append("##     , BKG.BKG_REF_NO" ).append("\n"); 
		query.append("##     , BKG.VSL_CD" ).append("\n"); 
		query.append("##     , BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("##     , BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("##     , BKG.POL_CD" ).append("\n"); 
		query.append("##     , BKG.POD_CD" ).append("\n"); 
		query.append("##  FROM SCG_PRNR_APRO_RQST     BKG" ).append("\n"); 
		query.append("##     , SCG_PRNR_APRO_RQST_CGO CGO" ).append("\n"); 
		query.append("## WHERE BKG.CRR_CD            = CGO.CRR_CD" ).append("\n"); 
		query.append("##   AND BKG.BKG_REF_NO        = CGO.BKG_REF_NO" ).append("\n"); 
		query.append("##   AND BKG.SPCL_CGO_RQST_SEQ = CGO.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("##   AND DECODE(NVL(CGO.APRO_REF_NO,'X'),'0','X',CGO.APRO_REF_NO) != 'X'" ).append("\n"); 
		query.append("##   AND (CGO.CGO_OPR_CD, BKG.BKG_REF_NO, BKG.VSL_CD, BKG.SKD_VOY_NO, BKG.SKD_DIR_CD, BKG.POL_CD, BKG.POD_CD) IN (" ).append("\n"); 
		query.append("##       SELECT G.CGO_OPR_CD, G.BKG_REF_NO, G.VSL_CD, G.SKD_VOY_NO, G.SKD_DIR_CD, G.POL_CD, G.POD_CD" ).append("\n"); 
		query.append("##         FROM (" ).append("\n"); 
		query.append("##              SELECT B.CGO_OPR_CD" ).append("\n"); 
		query.append("##                   , A.BKG_REF_NO" ).append("\n"); 
		query.append("##                   , A.VSL_CD" ).append("\n"); 
		query.append("##                   , A.SKD_VOY_NO" ).append("\n"); 
		query.append("##                   , A.SKD_DIR_CD" ).append("\n"); 
		query.append("##                   , A.POL_CD" ).append("\n"); 
		query.append("##                   , A.POD_CD" ).append("\n"); 
		query.append("##                   , A.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("##                   , DECODE(NVL(B.APRO_REF_NO,'X'),'0','X',B.APRO_REF_NO) APRO_REF_NO" ).append("\n"); 
		query.append("##                   , AVG(DECODE(B.AUTH_STS_CD,'Y',1,0)) OVER(PARTITION BY B.CRR_CD, B.BKG_REF_NO, B.SPCL_CGO_RQST_SEQ) STS_CT" ).append("\n"); 
		query.append("##                FROM SCG_PRNR_APRO_RQST A" ).append("\n"); 
		query.append("##                   , SCG_PRNR_APRO_RQST_CGO B" ).append("\n"); 
		query.append("##               WHERE A.CRR_CD            = B.CRR_CD" ).append("\n"); 
		query.append("##                 AND A.BKG_REF_NO        = B.BKG_REF_NO" ).append("\n"); 
		query.append("##                 AND A.SPCL_CGO_RQST_SEQ = B.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("##                AND (" ).append("\n"); 
		query.append("###foreach(${obj} in ${opt_obj})" ).append("\n"); 
		query.append("##                   (A.SPCL_CGO_RQST_SEQ = '$obj.getSpclCgoRqstSeq()'" ).append("\n"); 
		query.append("##                AND B.CGO_OPR_CD        = '$obj.getCgoOprCd()'" ).append("\n"); 
		query.append("##                AND A.BKG_REF_NO        = '$obj.getBkgRefNo()'" ).append("\n"); 
		query.append("##                AND A.VSL_CD            = '$obj.getVslCd()'" ).append("\n"); 
		query.append("##                AND A.SKD_VOY_NO        = '$obj.getSkdVoyNo()'" ).append("\n"); 
		query.append("##                AND A.SKD_DIR_CD        = '$obj.getSkdDirCd()'" ).append("\n"); 
		query.append("##                AND A.POL_CD            = '$obj.getPolCd()'" ).append("\n"); 
		query.append("##                AND A.POD_CD            = '$obj.getPodCd()'" ).append("\n"); 
		query.append("##                AND A.AWK_FLG           = '$obj.getAwkFlg()'" ).append("\n"); 
		query.append("##                AND A.DG_FLG            = '$obj.getDgFlg()')" ).append("\n"); 
		query.append("##     #if($velocityCount < ${obj_size})" ).append("\n"); 
		query.append("##                 OR" ).append("\n"); 
		query.append("##     #end" ).append("\n"); 
		query.append("###end" ).append("\n"); 
		query.append("##                    )" ).append("\n"); 
		query.append("##         ) G" ).append("\n"); 
		query.append("##        WHERE G.STS_CT            = 1" ).append("\n"); 
		query.append("##          AND G.APRO_REF_NO       = 'X'" ).append("\n"); 
		query.append("##   )" ).append("\n"); 
		query.append("## GROUP BY" ).append("\n"); 
		query.append("##       CGO.CGO_OPR_CD" ).append("\n"); 
		query.append("##     , BKG.BKG_REF_NO" ).append("\n"); 
		query.append("##     , BKG.VSL_CD" ).append("\n"); 
		query.append("##     , BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("##     , BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("##     , BKG.POL_CD" ).append("\n"); 
		query.append("##     , BKG.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT T.CGO_OPR_CD" ).append("\n"); 
		query.append(", T.BKG_REF_NO" ).append("\n"); 
		query.append(", T.VSL_CD" ).append("\n"); 
		query.append(", T.SKD_VOY_NO" ).append("\n"); 
		query.append(", T.SKD_DIR_CD" ).append("\n"); 
		query.append(", T.POL_CD" ).append("\n"); 
		query.append(", T.POD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.CGO_OPR_CD" ).append("\n"); 
		query.append(", A.BKG_REF_NO" ).append("\n"); 
		query.append(", A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD" ).append("\n"); 
		query.append(", (A.POL_CD||A.POL_CLPT_IND_SEQ) AS POL_CD" ).append("\n"); 
		query.append(", (A.POD_CD||A.POD_CLPT_IND_SEQ) AS POD_CD" ).append("\n"); 
		query.append(", A.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("FROM SCG_PRNR_APRO_RQST A" ).append("\n"); 
		query.append(", SCG_PRNR_APRO_RQST_CGO B" ).append("\n"); 
		query.append("WHERE A.CRR_CD            = B.CRR_CD" ).append("\n"); 
		query.append("AND A.BKG_REF_NO        = B.BKG_REF_NO" ).append("\n"); 
		query.append("AND A.SPCL_CGO_RQST_SEQ = B.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("AND A.DG_FLG            = @[dg_flg]" ).append("\n"); 
		query.append("AND A.AWK_FLG           = @[awk_flg]" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("B.CGO_OPR_CD" ).append("\n"); 
		query.append(", A.BKG_REF_NO" ).append("\n"); 
		query.append(", A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD" ).append("\n"); 
		query.append(", A.POL_CD||A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", A.POD_CD||A.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", A.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("T.CGO_OPR_CD" ).append("\n"); 
		query.append(", T.BKG_REF_NO" ).append("\n"); 
		query.append(", T.VSL_CD" ).append("\n"); 
		query.append(", T.SKD_VOY_NO" ).append("\n"); 
		query.append(", T.SKD_DIR_CD" ).append("\n"); 
		query.append(", T.POL_CD" ).append("\n"); 
		query.append(", T.POD_CD" ).append("\n"); 
		query.append("HAVING COUNT(T.SPCL_CGO_RQST_SEQ) > 1" ).append("\n"); 

	}
}