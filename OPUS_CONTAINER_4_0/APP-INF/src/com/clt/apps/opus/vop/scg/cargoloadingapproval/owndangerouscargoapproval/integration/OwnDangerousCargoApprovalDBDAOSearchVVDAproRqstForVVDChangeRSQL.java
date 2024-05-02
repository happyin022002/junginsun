/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchVVDAproRqstForVVDChangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOSearchVVDAproRqstForVVDChangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVVDAproRqstForVVDChange
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchVVDAproRqstForVVDChangeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_apro_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchVVDAproRqstForVVDChangeRSQL").append("\n"); 
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
		query.append("SELECT		YY.BKG_NO" ).append("\n"); 
		query.append("     	, 	YY.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("     	, 	YY.VSL_CD" ).append("\n"); 
		query.append("     	, 	YY.SKD_VOY_NO" ).append("\n"); 
		query.append("     	, 	YY.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,	RSO.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     	, 	YY.POL_CD" ).append("\n"); 
		query.append("     	, 	YY.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     	, 	YY.POL_YD_CD" ).append("\n"); 
		query.append("     	, 	YY.POD_CD" ).append("\n"); 
		query.append("     	, 	YY.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("     	, 	YY.POD_YD_CD" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     	,  	'' 							EDI_DEL_STS_CD" ).append("\n"); 
		query.append("     	, 	'R' 						EDI_MSG_STS_CD" ).append("\n"); 
		query.append("     	, 	'EDI_AUTO_CXL'				EDI_STATUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     	, 	NVL(G.ACT_CRR_CD,D.CRR_CD)  CRR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			     	, 	(" ).append("\n"); 
		query.append("			        	SELECT (" ).append("\n"); 
		query.append("			                	SELECT 	FLT_FILE_REF_NO" ).append("\n"); 
		query.append("			                  	FROM 	SCG_PRNR_SPCL_CGO_TRSM_HDR  A" ).append("\n"); 
		query.append("			                 	WHERE 	1 = 1" ).append("\n"); 
		query.append("			           			AND 	A.TRSM_MZD_CD               = 'EDI'              --::EDI, EML::--" ).append("\n"); 
		query.append("			           			AND 	A.BKG_REF_NO              	= SC2.BKG_NO" ).append("\n"); 
		query.append("			                   	AND 	A.PRNR_SPCL_CGO_SEQ       	= SC2.MAPG_PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("			               		) " ).append("\n"); 
		query.append("			           	FROM 	SCG_APRO_RQST 						SC1" ).append("\n"); 
		query.append("			              	, 	SCG_VVD_APRO_RQST 					SC2" ).append("\n"); 
		query.append("			          	WHERE 	1 = 1" ).append("\n"); 
		query.append("			            AND 	SC1.SPCL_CGO_APRO_RQST_SEQ 			= (	SELECT 		MAX(T1.SPCL_CGO_APRO_RQST_SEQ)" ).append("\n"); 
		query.append("			                                                       		FROM 		SCG_APRO_RQST 				T1" ).append("\n"); 
		query.append("			                                                          			, 	SCG_VVD_APRO_RQST 			T2" ).append("\n"); 
		query.append("			                                                      		WHERE 		T1.BKG_NO                 	= T2.BKG_NO" ).append("\n"); 
		query.append("																		AND 		T1.SPCL_CGO_APRO_RQST_SEQ 	= T2.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("			                                                        	AND 		T2.MAPG_EDI_TRSM_STS_CD   	= 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			                                                        	AND 		T2.BKG_NO                 	= SC2.BKG_NO" ).append("\n"); 
		query.append("                                                                		AND   		T2.VSL_CD                 	= SC2.VSL_CD" ).append("\n"); 
		query.append("                                                                		AND   		T2.SKD_VOY_NO             	= SC2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                		AND   		T2.SKD_DIR_CD             	= SC2.SKD_DIR_CD" ).append("\n"); 
		query.append("			                                                      		)" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("						AND 	SC1.BKG_NO                 			= SC2.BKG_NO" ).append("\n"); 
		query.append("						AND 	SC1.SPCL_CGO_APRO_RQST_SEQ 			= SC2.SPCL_CGO_APRO_RQST_SEQ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						--AND 	SC2.VSL_PRE_PST_CD         			= YY.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("						--AND 	SC2.VSL_SEQ                			= YY.VSL_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						AND		SC2.BKG_NO                 			= YY.BKG_NO" ).append("\n"); 
		query.append("                        AND   	SC2.VSL_CD                 			= YY.VSL_CD" ).append("\n"); 
		query.append("                        AND   	SC2.SKD_VOY_NO             			= YY.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND   	SC2.SKD_DIR_CD             			= YY.SKD_DIR_CD             " ).append("\n"); 
		query.append("			       		) 		FLT_FILE_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     	, 	XX.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("     	, 	YY.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("     	, 	YY.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("     	, 	YY.VSL_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM 		VSK_VSL_SKD          		G" ).append("\n"); 
		query.append("     	, 	SCG_APRO_RQST        		XX" ).append("\n"); 
		query.append("     	, 	SCG_VVD_APRO_RQST    		YY" ).append("\n"); 
		query.append("     	, 	MDM_VSL_CNTR         		D" ).append("\n"); 
		query.append("		,	SCG_RGN_SHP_OPR_PORT		RSO" ).append("\n"); 
		query.append("WHERE 		1 = 1" ).append("\n"); 
		query.append("AND 		YY.VSL_CD                   = G.VSL_CD" ).append("\n"); 
		query.append("AND 		YY.SKD_VOY_NO               = G.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 		YY.SKD_DIR_CD               = G.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 		YY.VSL_CD                   = D.VSL_CD" ).append("\n"); 
		query.append("AND 		YY.BKG_NO                   = XX.BKG_NO" ).append("\n"); 
		query.append("AND 		YY.SPCL_CGO_APRO_RQST_SEQ   = XX.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("AND        	XX.SPCL_CGO_CATE_CD       	= 'DG'" ).append("\n"); 
		query.append("AND			YY.POL_CD					= LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    		YY.BKG_NO                   = @[bkg_no]" ).append("\n"); 
		query.append("AND    		YY.SPCL_CGO_APRO_RQST_SEQ   = @[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND       	YY.VSL_PRE_PST_CD       = [vsl_pre_pst_cd]" ).append("\n"); 
		query.append("--AND       	YY.VSL_SEQ              = [vsl_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND       	YY.MAPG_EDI_TRSM_STS_CD   	= 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND         YY.VSL_CD                   = @[vsl_cd]" ).append("\n"); 
		query.append("AND         YY.SKD_VOY_NO               = @[skd_voy_no]" ).append("\n"); 
		query.append("AND         YY.SKD_DIR_CD               = @[skd_dir_cd]" ).append("\n"); 

	}
}