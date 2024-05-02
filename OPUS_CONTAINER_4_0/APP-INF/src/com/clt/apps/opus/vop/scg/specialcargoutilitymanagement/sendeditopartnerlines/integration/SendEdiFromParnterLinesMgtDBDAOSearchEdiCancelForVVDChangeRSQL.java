/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SendEdiFromParnterLinesMgtDBDAOSearchEdiCancelForVVDChangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SendEdiFromParnterLinesMgtDBDAOSearchEdiCancelForVVDChangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiCancelForVVDChange
	  * </pre>
	  */
	public SendEdiFromParnterLinesMgtDBDAOSearchEdiCancelForVVDChangeRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration").append("\n"); 
		query.append("FileName : SendEdiFromParnterLinesMgtDBDAOSearchEdiCancelForVVDChangeRSQL").append("\n"); 
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
		query.append("SELECT    H.BKG_REF_NO                						AS BKG_NO" ).append("\n"); 
		query.append("       ,  TO_CHAR(H.BKG_CRE_LOCL_DT, 'YYYYMMDDHH24MI')     	AS BKG_DT" ).append("\n"); 
		query.append("       ,  H.CGO_OPR_CD" ).append("\n"); 
		query.append("       ,  H.SLAN_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       ,  H.VSL_CD" ).append("\n"); 
		query.append("       ,  H.VSL_ENG_FULL_NM                                	AS VSL_ENG_NM" ).append("\n"); 
		query.append("       ,  H.CALL_SGN_NO" ).append("\n"); 
		query.append("       ,  H.LLOYD_NO       " ).append("\n"); 
		query.append("       ,  H.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,  H.SKD_DIR_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       ,  H.POR_CD" ).append("\n"); 
		query.append("       ,  H.POR_NM" ).append("\n"); 
		query.append("       ,  H.POR_YD_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       ,  H.POL_CD" ).append("\n"); 
		query.append("       ,  H.POL_NM" ).append("\n"); 
		query.append("       ,  H.POL_YD_CD                                      	AS POL_NOD_CD" ).append("\n"); 
		query.append("       ,  H.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       ,  H.POD_CD" ).append("\n"); 
		query.append("       ,  H.POD_NM" ).append("\n"); 
		query.append("       ,  H.POD_YD_CD                                      	AS POD_NOD_CD" ).append("\n"); 
		query.append("       ,  H.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       ,  H.DEL_CD" ).append("\n"); 
		query.append("       ,  H.DEL_NM" ).append("\n"); 
		query.append("       ,  H.DEL_YD_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       ,  H.OUT_BND_CSSM_VOY_NO								AS OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("FROM      SCG_PRNR_SPCL_CGO_TRSM_HDR  H" ).append("\n"); 
		query.append("WHERE     (H.TRSM_BND_CD,H.TRSM_DT,H.SPCL_CGO_CATE_CD,H.PRNR_SPCL_CGO_SEQ)" ).append("\n"); 
		query.append("          IN" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("          -----------------------------------------------------" ).append("\n"); 
		query.append("          SELECT     YY.MAPG_TRSM_BND_CD" ).append("\n"); 
		query.append("                  ,  YY.MAPG_TRSM_DT" ).append("\n"); 
		query.append("                  ,  YY.MAPG_TRSM_SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                  ,  YY.MAPG_PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("          FROM       SCG_VVD_APRO_RQST          YY" ).append("\n"); 
		query.append("          WHERE      YY.BKG_NO                  = @[bkg_no]" ).append("\n"); 
		query.append("          AND        YY.SPCL_CGO_APRO_RQST_SEQ  = @[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append("          AND        YY.VSL_CD                  = @[vsl_cd]" ).append("\n"); 
		query.append("          AND        YY.SKD_VOY_NO              = @[skd_voy_no]" ).append("\n"); 
		query.append("          AND        YY.SKD_DIR_CD              = @[skd_dir_cd]" ).append("\n"); 
		query.append("          AND        YY.MAPG_EDI_TRSM_STS_CD    = 'S'" ).append("\n"); 
		query.append("          -----------------------------------------------------" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}