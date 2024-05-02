/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchAproRqstVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.04.28 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOSearchAproRqstVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * REQUEST한 내용을 조회한다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchAproRqstVORSQL(){
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
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchAproRqstVORSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("	,  SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("	,  SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("	,  SPCL_CGO_RQST_SEQ	" ).append("\n"); 
		query.append("	,  POR_CD" ).append("\n"); 
		query.append("	,  DEL_CD" ).append("\n"); 
		query.append("	,  AWK_CGO_QTY" ).append("\n"); 
		query.append("	,  BB_CGO_QTY" ).append("\n"); 
		query.append("	,  DCGO_QTY" ).append("\n"); 
		query.append("	,  RC_QTY" ).append("\n"); 
		query.append("	,  LST_RQST_DAT_FLG" ).append("\n"); 
		query.append("	,  BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("	,  BKG_DE_TERM_CD" ).append("\n"); 
		query.append("	,  RQST_USR_ID" ).append("\n"); 
		query.append("	,  RQST_OFC_CD" ).append("\n"); 
		query.append("	,  RQST_DT" ).append("\n"); 
		query.append("	,  RQST_GDT" ).append("\n"); 
		query.append("	,  SPCL_BKG_RQST_FLG" ).append("\n"); 
		query.append("	,  EML_SND_NO" ).append("\n"); 
		query.append("	,  CRE_USR_ID" ).append("\n"); 
		query.append("	,  CRE_DT" ).append("\n"); 
		query.append("	,  UPD_USR_ID" ).append("\n"); 
		query.append("	,  UPD_DT" ).append("\n"); 
		query.append("FROM SCG_APRO_RQST" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND SPCL_CGO_CATE_CD = @[spcl_cgo_cate_cd]" ).append("\n"); 

	}
}