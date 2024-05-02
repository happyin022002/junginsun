/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchScgRequestDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOSearchScgRequestDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchScgRequestDetail 조회한다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchScgRequestDetailRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchScgRequestDetailRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	A.RQST_USR_ID, " ).append("\n"); 
		query.append("    B.USR_NM AS RQST_USR_NM, " ).append("\n"); 
		query.append("    B.OFC_CD AS RQST_OFC_CD,  " ).append("\n"); 
		query.append("    TO_CHAR(A.RQST_DT,'YYYY-MM-DD HH24:MI') AS RQST_DT, " ).append("\n"); 
		query.append("    TO_CHAR(A.RQST_GDT,'YYYY-MM-DD HH24:MI') AS RQST_GDT, " ).append("\n"); 
		query.append("    B.MPHN_NO AS RQST_USR_PHN_NO, " ).append("\n"); 
		query.append("    B.USR_EML AS RQST_USR_EML," ).append("\n"); 
		query.append("    NVL2(( SELECT DISTINCT BKG_NO" ).append("\n"); 
		query.append("        FROM SCG_APRO_RQST WHERE BKG_NO = @[bkg_no] AND SPCL_CGO_CATE_CD = 'DG'),'Y',NULL) AS DG_FLAG" ).append("\n"); 
		query.append("FROM SCG_APRO_RQST A, COM_USER B" ).append("\n"); 
		query.append("WHERE	A.RQST_USR_ID = B.USR_ID(+)" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	A.SPCL_CGO_APRO_RQST_SEQ = @[spcl_cgo_apro_rqst_seq]" ).append("\n"); 

	}
}