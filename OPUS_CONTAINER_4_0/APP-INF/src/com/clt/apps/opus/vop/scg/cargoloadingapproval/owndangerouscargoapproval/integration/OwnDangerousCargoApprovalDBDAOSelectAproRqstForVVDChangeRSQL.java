/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSelectAproRqstForVVDChangeRSQL.java
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

public class OwnDangerousCargoApprovalDBDAOSelectAproRqstForVVDChangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * selectAproRqstForVVDChange
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSelectAproRqstForVVDChangeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSelectAproRqstForVVDChangeRSQL").append("\n"); 
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
		query.append("SELECT     	XX.BKG_NO" ).append("\n"); 
		query.append("      	,   XX.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("      	,   YY.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("      	,   YY.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("      	,   YY.VSL_SEQ" ).append("\n"); 
		query.append("		,	YY.VSL_CD" ).append("\n"); 
		query.append("		,	YY.SKD_VOY_NO" ).append("\n"); 
		query.append("		,	YY.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,  	YY.POL_CD  					AS LOC_CD" ).append("\n"); 
		query.append("    	,  (SELECT    	NVL(VS.ACT_CRR_CD,VC.CRR_CD)" ).append("\n"); 
		query.append("        	FROM      	VSK_VSL_SKD   	VS" ).append("\n"); 
		query.append("               		,  	MDM_VSL_CNTR  	VC" ).append("\n"); 
		query.append("        	WHERE     	1 = 1" ).append("\n"); 
		query.append("        	AND       	VS.VSL_CD     	= VC.VSL_CD" ).append("\n"); 
		query.append("        	AND       	VS.VSL_CD     	= YY.VSL_CD" ).append("\n"); 
		query.append("			AND			VS.SKD_VOY_NO	= YY.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND			VS.SKD_DIR_CD	= YY.SKD_DIR_CD" ).append("\n"); 
		query.append("        	)			AS CRR_CD" ).append("\n"); 
		query.append("FROM       	SCG_APRO_RQST             	XX" ).append("\n"); 
		query.append("        ,  	SCG_VVD_APRO_RQST         	YY" ).append("\n"); 
		query.append("WHERE      	XX.BKG_NO                 	= YY.BKG_NO" ).append("\n"); 
		query.append("AND        	XX.SPCL_CGO_APRO_RQST_SEQ 	= YY.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("AND        	XX.SPCL_CGO_CATE_CD       	= 'DG'" ).append("\n"); 
		query.append("AND        	XX.LST_RQST_DAT_FLG       	= 'N'" ).append("\n"); 
		query.append("AND        	YY.MAPG_EDI_TRSM_STS_CD   	= 'S'" ).append("\n"); 
		query.append("AND        	XX.BKG_NO                 	= @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND         YY.SPCL_CGO_APRO_RQST_SEQ   = (SELECT    MAX(T.SPCL_CGO_APRO_RQST_SEQ)" ).append("\n"); 
		query.append("                                           FROM      SCG_VVD_APRO_RQST   		T" ).append("\n"); 
		query.append("                                           WHERE     T.BKG_NO            		= YY.BKG_NO" ).append("\n"); 
		query.append("                                           AND       T.VSL_CD            		= YY.VSL_CD" ).append("\n"); 
		query.append("                                           AND       T.SKD_VOY_NO        		= YY.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND       T.SKD_DIR_CD        		= YY.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND        	NOT EXISTS                	(SELECT   	''" ).append("\n"); 
		query.append("                                      	 FROM     	SCG_APRO_RQST            	X" ).append("\n"); 
		query.append("                                            	,  	SCG_VVD_APRO_RQST        	Y       " ).append("\n"); 
		query.append("                                      	 WHERE    	X.BKG_NO                 	= Y.BKG_NO" ).append("\n"); 
		query.append("                                      	 AND      	X.SPCL_CGO_APRO_RQST_SEQ 	= Y.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                                      	 AND      	X.SPCL_CGO_CATE_CD       	= 'DG'" ).append("\n"); 
		query.append("                                      	 AND      	X.LST_RQST_DAT_FLG       	= 'Y'" ).append("\n"); 
		query.append("                                      	 AND      	X.BKG_NO                 	= XX.BKG_NO" ).append("\n"); 
		query.append("                                      	 AND      	Y.VSL_CD                 	= YY.VSL_CD" ).append("\n"); 
		query.append("                                      	 AND      	Y.SKD_VOY_NO             	= YY.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      	 AND      	Y.SKD_DIR_CD             	= YY.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND			1 							= CASE 	WHEN (	SELECT   MAX(T.SPCL_CGO_APRO_RQST_SEQ)" ).append("\n"); 
		query.append("                                                       	FROM     SCG_VVD_APRO_RQST			T" ).append("\n"); 
		query.append("                                                      	WHERE    T.BKG_NO                  	= YY.BKG_NO" ).append("\n"); 
		query.append("                                                      	AND      T.VSL_PRE_PST_CD          	= YY.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                                      	AND      T.VSL_SEQ                 	= YY.VSL_SEQ" ).append("\n"); 
		query.append("                                                      	AND      T.MAPG_EDI_TRSM_STS_CD    	= 'SX'           " ).append("\n"); 
		query.append("													 )	> YY.SPCL_CGO_APRO_RQST_SEQ THEN 0" ).append("\n"); 
		query.append("                                               	ELSE 1" ).append("\n"); 
		query.append("                                          END" ).append("\n"); 

	}
}