/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDAOScgAuthStsCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDAOScgAuthStsCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Save/Request 구분
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDAOScgAuthStsCdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDAOScgAuthStsCdVORSQL").append("\n"); 
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
		query.append("SELECT  CASE	WHEN AUTH_STS_CD = '*' 			THEN 'INSERT'" ).append("\n"); 
		query.append("		  		WHEN AUTH_STS_CD IN('Y','N') 	THEN 'INSERT'" ).append("\n"); 
		query.append("		  		WHEN AUTH_STS_CD = 'R' 			THEN 'INSERT'" ).append("\n"); 
		query.append("             	WHEN AUTH_STS_CD = 'X' 			THEN 'UPDATE'" ).append("\n"); 
		query.append("             	ELSE 'X'" ).append("\n"); 
		query.append("        END 	AS UPD_INDICATOR" ).append("\n"); 
		query.append("	,	AUTH_STS_CD" ).append("\n"); 
		query.append("	,	SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("	,	PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("         --==============================================================" ).append("\n"); 
		query.append("          SELECT   NVL(MAX(XX.CRR_CD              ),'*')  AS CRR_CD            " ).append("\n"); 
		query.append("                ,  NVL(MAX(XX.BKG_REF_NO          ),'*')  AS BKG_REF_NO        " ).append("\n"); 
		query.append("                ,  NVL(MAX(XX.SPCL_CGO_RQST_SEQ   ),'0')  AS SPCL_CGO_RQST_SEQ " ).append("\n"); 
		query.append("				,  NVL(MAX(XX.PRNR_CGO_RQST_SEQ   ),'0')  AS PRNR_CGO_RQST_SEQ " ).append("\n"); 
		query.append("                ,  NVL(MAX(XX.CGO_OPR_CD          ),'*')  AS CGO_OPR_CD        " ).append("\n"); 
		query.append("                ,  NVL(MAX(XX.VSL_CD              ),'*')  AS VSL_CD            " ).append("\n"); 
		query.append("                ,  NVL(MAX(XX.SKD_VOY_NO          ),'*')  AS SKD_VOY_NO        " ).append("\n"); 
		query.append("                ,  NVL(MAX(XX.SKD_DIR_CD          ),'*')  AS SKD_DIR_CD        " ).append("\n"); 
		query.append("               -- ,  NVL(MAX(XX.POL_CD              ),'*')  AS POL_CD            " ).append("\n"); 
		query.append("               -- ,  NVL(MAX(XX.POD_CD              ),'*')  AS POD_CD            " ).append("\n"); 
		query.append("                ,  NVL(MAX(XX.AUTH_STS_CD         ),'*')  AS AUTH_STS_CD       " ).append("\n"); 
		query.append("                ,  NVL(MAX(XX.RNK                 ),'9')  AS RNK                              " ).append("\n"); 
		query.append("          FROM    (" ).append("\n"); 
		query.append("                   ----------------------------------------------------------------" ).append("\n"); 
		query.append("                  SELECT   X.CRR_CD" ).append("\n"); 
		query.append("                        ,  X.BKG_REF_NO" ).append("\n"); 
		query.append("                        ,  X.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("						,  X.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                        ,  Y.CGO_OPR_CD" ).append("\n"); 
		query.append("                        ,  X.VSL_CD" ).append("\n"); 
		query.append("                        ,  X.SKD_VOY_NO" ).append("\n"); 
		query.append("                        ,  X.SKD_DIR_CD" ).append("\n"); 
		query.append("                       -- ,  X.POL_CD" ).append("\n"); 
		query.append("                       -- ,  X.POD_CD" ).append("\n"); 
		query.append("                        ,  NVL(Y.AUTH_STS_CD, 'X') AS AUTH_STS_CD" ).append("\n"); 
		query.append("                        --,ROW_NUMBER() OVER (PARTITION BY X.CRR_CD,X.BKG_REF_NO,X.SPCL_CGO_RQST_SEQ,Y.CGO_OPR_CD,X.VSL_CD,X.SKD_VOY_NO,X.SKD_DIR_CD,X.POL_CD ORDER BY DECODE(NULL,'1','Y','2','N','3','R','8','9')) AS RNK" ).append("\n"); 
		query.append("						,  ROW_NUMBER() OVER (PARTITION BY X.CRR_CD,X.BKG_REF_NO,X.SPCL_CGO_RQST_SEQ,Y.CGO_OPR_CD,X.VSL_CD,X.SKD_VOY_NO,X.SKD_DIR_CD ORDER BY DECODE(NULL,'1','Y','2','N','3','R','8','9')) AS RNK" ).append("\n"); 
		query.append("                  FROM     SCG_PRNR_APRO_RQST       X" ).append("\n"); 
		query.append("                        ,  SCG_PRNR_APRO_RQST_CGO   Y" ).append("\n"); 
		query.append("                  WHERE    X.CRR_CD                 = Y.CRR_CD" ).append("\n"); 
		query.append("                  AND      X.BKG_REF_NO             = Y.BKG_REF_NO" ).append("\n"); 
		query.append("                  AND      X.SPCL_CGO_RQST_SEQ      = Y.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                  AND      X.PRNR_CGO_RQST_SEQ      = Y.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                  AND      X.LST_RQST_DAT_FLG       = 'Y'" ).append("\n"); 
		query.append("                  AND      X.DG_FLG                 = 'Y' " ).append("\n"); 
		query.append("                  AND      X.SRC_TP_CD              = @[src_tp_cd]" ).append("\n"); 
		query.append("                  AND      X.CRR_CD                 = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("                  AND      X.BKG_REF_NO             = @[bkg_ref_no]      " ).append("\n"); 
		query.append("                  AND      X.VSL_CD                 = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND      X.SKD_VOY_NO             = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND      X.SKD_DIR_CD             = @[skd_dir_cd]" ).append("\n"); 
		query.append("                  --AND      X.POL_CD                 = SUBSTR([pol_cd],1,5)" ).append("\n"); 
		query.append("                  --AND      X.POD_CD                 = SUBSTR([pod_cd],1,5)" ).append("\n"); 
		query.append("                  AND      Y.CGO_OPR_CD             = @[cgo_opr_cd]" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                  GROUP BY X.CRR_CD" ).append("\n"); 
		query.append("                        ,  X.BKG_REF_NO" ).append("\n"); 
		query.append("                        ,  X.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("						,  x.PRNR_CGO_RQST_SEQ " ).append("\n"); 
		query.append("                        ,  Y.CGO_OPR_CD" ).append("\n"); 
		query.append("                        ,  X.VSL_CD" ).append("\n"); 
		query.append("                        ,  X.SKD_VOY_NO" ).append("\n"); 
		query.append("                        ,  X.SKD_DIR_CD" ).append("\n"); 
		query.append("                    --    ,  X.POL_CD" ).append("\n"); 
		query.append("                    --    ,  X.POD_CD" ).append("\n"); 
		query.append("                        ,  Y.AUTH_STS_CD" ).append("\n"); 
		query.append("         ----------------------------------------------------------------" ).append("\n"); 
		query.append("        ) XX" ).append("\n"); 
		query.append("WHERE   XX.RNK      = 1            " ).append("\n"); 
		query.append("         --==============================================================" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}