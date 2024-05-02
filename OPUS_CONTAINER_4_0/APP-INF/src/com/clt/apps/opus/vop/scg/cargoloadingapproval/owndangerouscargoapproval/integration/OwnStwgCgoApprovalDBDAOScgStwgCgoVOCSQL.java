/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OwnStwgCgoApprovalDBDAOScgStwgCgoVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.15 
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

public class OwnStwgCgoApprovalDBDAOScgStwgCgoVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public OwnStwgCgoApprovalDBDAOScgStwgCgoVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("stwg_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnStwgCgoApprovalDBDAOScgStwgCgoVOCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_STWG_CGO (" ).append("\n"); 
		query.append("	 BKG_NO" ).append("\n"); 
		query.append("	,SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("	,STWG_CGO_SEQ" ).append("\n"); 
		query.append("	,STWG_CD" ).append("\n"); 
		query.append("	,STWG_RMK" ).append("\n"); 
		query.append("	,RQST_DT" ).append("\n"); 
		query.append("	,RQST_GDT" ).append("\n"); 
		query.append("	,RQST_USR_ID" ).append("\n"); 
		query.append("	,SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("	,APLY_NO" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("      --,SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("			#if (${spcl_cgo_apro_rqst_seq} != '') " ).append("\n"); 
		query.append("			,	@[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			,	(	SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) FROM SCG_APRO_RQST WHERE BKG_NO = @[bkg_no] AND SPCL_CGO_CATE_CD = 'SS'	)" ).append("\n"); 
		query.append("			#end      " ).append("\n"); 
		query.append("      ,STWG_SEQ --STWG_CGO_SEQ" ).append("\n"); 
		query.append("      ,STWG_CD" ).append("\n"); 
		query.append("      ,STWG_RMK" ).append("\n"); 
		query.append("      ,RQST_DT" ).append("\n"); 
		query.append("      ,RQST_GDT" ).append("\n"); 
		query.append("      ,RQST_USR_ID" ).append("\n"); 
		query.append("      ,SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("      ,APLY_NO" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("FROM BKG_STWG_CGO" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${spcl_cgo_apro_rqst_seq} != '' || ${cgo_seq} == '') " ).append("\n"); 
		query.append("AND SPCL_CGO_APRO_CD not in ('C','D')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${stwg_cgo_seq} != '') " ).append("\n"); 
		query.append("AND STWG_CGO_SEQ = @[stwg_cgo_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}