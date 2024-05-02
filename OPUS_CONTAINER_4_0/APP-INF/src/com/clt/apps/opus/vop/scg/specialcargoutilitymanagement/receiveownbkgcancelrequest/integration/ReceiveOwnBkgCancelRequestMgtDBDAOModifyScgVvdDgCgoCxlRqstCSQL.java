/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceiveOwnBkgCancelRequestMgtDBDAOModifyScgVvdDgCgoCxlRqstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.02 
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

public class ReceiveOwnBkgCancelRequestMgtDBDAOModifyScgVvdDgCgoCxlRqstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddScgVvdDgCgoCxlRqst
	  * </pre>
	  */
	public ReceiveOwnBkgCancelRequestMgtDBDAOModifyScgVvdDgCgoCxlRqstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_vrfy_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_vrfy_rslt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_cxl_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.integration").append("\n"); 
		query.append("FileName : ReceiveOwnBkgCancelRequestMgtDBDAOModifyScgVvdDgCgoCxlRqstCSQL").append("\n"); 
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
		query.append(" UPDATE SCG_VVD_DG_CGO_CXL_RQST" ).append("\n"); 
		query.append("	SET RQST_VRFY_RSLT_CD  = @[rqst_vrfy_rslt_cd]" ).append("\n"); 
		query.append("      , RQST_VRFY_RSLT_RMK = @[rqst_vrfy_rslt_rmk]" ).append("\n"); 
		query.append("      , UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append("      , UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("  WHERE BKG_NO             = @[bkg_no]" ).append("\n"); 
		query.append("    AND DCGO_CXL_RQST_SEQ  = @[dcgo_cxl_rqst_seq]" ).append("\n"); 

	}
}