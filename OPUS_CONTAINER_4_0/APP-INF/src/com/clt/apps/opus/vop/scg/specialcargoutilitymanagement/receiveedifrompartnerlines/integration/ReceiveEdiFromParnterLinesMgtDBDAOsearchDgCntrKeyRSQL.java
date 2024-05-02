/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOsearchDgCntrKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOsearchDgCntrKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDgCgoCnt
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOsearchDgCntrKeyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_trsm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_trsm_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_trsm_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOsearchDgCntrKeyRSQL").append("\n"); 
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
		query.append("SELECT CRR_CD" ).append("\n"); 
		query.append("     , BKG_REF_NO" ).append("\n"); 
		query.append("     , SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("  FROM SCG_PRNR_APRO_RQST" ).append("\n"); 
		query.append(" WHERE MAPG_TRSM_BND_CD           = @[mapg_trsm_bnd_cd]" ).append("\n"); 
		query.append("   AND MAPG_TRSM_DT               = TO_DATE(@[mapg_trsm_dt],'yyyy-MM-dd')" ).append("\n"); 
		query.append("   AND MAPG_PRNR_SPCL_CGO_SEQ     = @[mapg_prnr_spcl_cgo_seq]" ).append("\n"); 
		query.append("   AND MAPG_TRSM_SPCL_CGO_CATE_CD = @[mapg_trsm_cgo_cate_cd]" ).append("\n"); 

	}
}