/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceiveOwnBkgCancelRequestMgtDBDAOSearchScgVvdKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveOwnBkgCancelRequestMgtDBDAOSearchScgVvdKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDgCgoCnt
	  * </pre>
	  */
	public ReceiveOwnBkgCancelRequestMgtDBDAOSearchScgVvdKeyRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.integration").append("\n"); 
		query.append("FileName : ReceiveOwnBkgCancelRequestMgtDBDAOSearchScgVvdKeyRSQL").append("\n"); 
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
		query.append("SELECT		X.BKG_NO" ).append("\n"); 
		query.append("		,	X.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("		,	X.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("		,	X.VSL_SEQ" ).append("\n"); 
		query.append("		,	X.SLAN_CD" ).append("\n"); 
		query.append("		,	X.VSL_CD" ).append("\n"); 
		query.append("		,	X.SKD_VOY_NO" ).append("\n"); 
		query.append("		,	X.SKD_DIR_CD" ).append("\n"); 
		query.append("		,	X.POL_CD" ).append("\n"); 
		query.append("		,	X.POD_CD" ).append("\n"); 
		query.append("		,	X.MAPG_EDI_TRSM_STS_CD" ).append("\n"); 
		query.append("FROM		SCG_VVD_APRO_RQST            X" ).append("\n"); 
		query.append("WHERE		1 = 1" ).append("\n"); 
		query.append("AND			X.BKG_NO           			=     @[bkg_no]" ).append("\n"); 
		query.append("AND			X.VSL_CD           			= NVL(@[vsl_cd]		, X.VSL_CD		)" ).append("\n"); 
		query.append("AND			X.SKD_VOY_NO       			= NVL(@[skd_voy_no]	, X.SKD_VOY_NO	)" ).append("\n"); 
		query.append("AND			X.SKD_DIR_CD       			= NVL(@[skd_dir_cd]	, X.SKD_DIR_CD	)" ).append("\n"); 
		query.append("AND			X.POL_CD           			= NVL(@[pol_cd]		, X.POL_CD		)" ).append("\n"); 
		query.append("AND			X.MAPG_EDI_TRSM_STS_CD      = 'S'										-- << S:EDI SEND SUCCESS, SX:CANCELLATION EDI SEND SUCCESS >> --" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND      	X.SPCL_CGO_APRO_RQST_SEQ 	= 			(	SELECT   MAX(XX.SPCL_CGO_APRO_RQST_SEQ)" ).append("\n"); 
		query.append("                                     					FROM     SCG_VVD_APRO_RQST XX" ).append("\n"); 
		query.append("                                     					WHERE    XX.BKG_NO                  = X.BKG_NO" ).append("\n"); 
		query.append("                        								AND      XX.VSL_PRE_PST_CD          = X.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                        								AND      XX.VSL_SEQ                 = X.VSL_SEQ						" ).append("\n"); 
		query.append("                        								AND      XX.MAPG_EDI_TRSM_STS_CD    = 'S'			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND      1                           	= CASE WHEN (	SELECT   MAX(SPCL_CGO_APRO_RQST_SEQ)" ).append("\n"); 
		query.append("                                                  	 	FROM     SCG_VVD_APRO_RQST          XX" ).append("\n"); 
		query.append("                                                  		WHERE    XX.BKG_NO                  = X.BKG_NO" ).append("\n"); 
		query.append("                                                  		AND      XX.VSL_PRE_PST_CD          = X.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                                  		AND      XX.VSL_SEQ                 = X.VSL_SEQ" ).append("\n"); 
		query.append("                                                  		AND      XX.MAPG_EDI_TRSM_STS_CD    = 'SX'         	) " ).append("\n"); 
		query.append("														> X.SPCL_CGO_APRO_RQST_SEQ THEN 0" ).append("\n"); 
		query.append("                                               ELSE 1" ).append("\n"); 
		query.append("                                       	  END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("------------------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("--SELECT 		A.BKG_NO" ).append("\n"); 
		query.append("--      	, 	A.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("--      	, 	A.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("--      	, 	A.VSL_SEQ" ).append("\n"); 
		query.append("--      	, 	A.MAPG_EDI_TRSM_STS_CD" ).append("\n"); 
		query.append("--		,	''							AS DCGO_CXL_RQST_SEQ" ).append("\n"); 
		query.append("--		,	''							AS CXL_CGO_KND_CD" ).append("\n"); 
		query.append("--		,	''							AS CXL_CGO_RQST_DT" ).append("\n"); 
		query.append("--		,	''							AS CXL_CGO_RSN" ).append("\n"); 
		query.append("--		,	''							AS UPD_USR_ID" ).append("\n"); 
		query.append("--   FROM 	SCG_VVD_APRO_RQST 			A" ).append("\n"); 
		query.append("--      	, 	SCG_APRO_RQST 				B" ).append("\n"); 
		query.append("--  WHERE 	A.BKG_NO           			= [bkg_no]" ).append("\n"); 
		query.append("--    AND 	A.VSL_CD           			= NVL([vsl_cd]		, A.VSL_CD		)" ).append("\n"); 
		query.append("--    AND 	A.SKD_VOY_NO       			= NVL([skd_voy_no]	, A.SKD_VOY_NO	)" ).append("\n"); 
		query.append("--    AND 	A.SKD_DIR_CD       			= NVL([skd_dir_cd]	, A.SKD_DIR_CD	)" ).append("\n"); 
		query.append("--    AND 	A.POL_CD           			= NVL([pol_cd]		, A.POL_CD		)" ).append("\n"); 
		query.append("--    AND 	A.BKG_NO           			= B.BKG_NO" ).append("\n"); 
		query.append("--    AND 	B.LST_RQST_DAT_FLG 			= 'Y'" ).append("\n"); 
		query.append("--    AND 	B.SPCL_CGO_CATE_CD 			= 'DG'    " ).append("\n"); 
		query.append("--    AND 	A.SPCL_CGO_APRO_RQST_SEQ 	= B.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("--	AND		A.MAPG_EDI_TRSM_STS_CD		= 'S'		-- ::EDI SEND SUCCESS:: --" ).append("\n"); 

	}
}