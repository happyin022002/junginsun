/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoCntrLogCSQL.java
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

public class ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoCntrLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INSERT
	  * SCG_PRNR_SPCL_CGO_CNTR_LOG
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoCntrLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iso_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsd_flg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoCntrLogCSQL").append("\n"); 
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
		query.append("INSERT INTO" ).append("\n"); 
		query.append("       SCG_PRNR_SPCL_CGO_CNTR_LOG" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	  TRSM_BND_CD" ).append("\n"); 
		query.append("	, TRSM_DT" ).append("\n"); 
		query.append("	, SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("	, PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("	, CNTR_SEQ" ).append("\n"); 
		query.append("	, CNTR_REF_NO" ).append("\n"); 
		query.append("	, CNTR_TPSZ_CD_CTNT" ).append("\n"); 
		query.append("	, ISO_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, RSD_FLG_CTNT" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("  SELECT @[trsm_bnd_cd]" ).append("\n"); 
		query.append("	   , TO_DATE(@[trsm_dt],'yyyy-MM-dd')" ).append("\n"); 
		query.append("	   , @[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("	   , @[prnr_spcl_cgo_seq]" ).append("\n"); 
		query.append("	   , @[cntr_seq]" ).append("\n"); 
		query.append("	   , @[cntr_ref_no]" ).append("\n"); 
		query.append("	   , @[cntr_tpsz_cd_ctnt]" ).append("\n"); 
		query.append("	   , @[iso_cntr_tpsz_cd]" ).append("\n"); 
		query.append("	   , @[rsd_flg_ctnt]" ).append("\n"); 
		query.append("	   , @[cre_usr_id]" ).append("\n"); 
		query.append("	   , SYSDATE" ).append("\n"); 
		query.append("	   , @[upd_usr_id]" ).append("\n"); 
		query.append("	   , SYSDATE" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}