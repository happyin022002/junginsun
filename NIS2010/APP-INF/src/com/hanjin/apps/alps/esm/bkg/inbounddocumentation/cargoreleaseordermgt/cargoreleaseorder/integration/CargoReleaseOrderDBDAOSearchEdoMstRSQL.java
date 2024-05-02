/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdoMstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 윤한
*@LastVersion : 1.0
* 2010.04.28 윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdoMstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI_BKG_0133 화면에서 사용하는 searchEdoMst 메소드에서 사용하는 쿼리이다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdoMstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqstNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdoMstRSQL").append("\n"); 
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
		query.append("SELECT A.EDO_RQST_NO," ).append("\n"); 
		query.append("       A.EDO_RQST_SEQ," ).append("\n"); 
		query.append("       A.EDO_TP_CD," ).append("\n"); 
		query.append("       A.EDO_FUNC_CD," ).append("\n"); 
		query.append("       A.BKG_NO," ).append("\n"); 
		query.append("       A.BL_NO," ).append("\n"); 
		query.append("       A.MF_SEQ_NO," ).append("\n"); 
		query.append("       A.EDO_VSL_NM," ).append("\n"); 
		query.append("       A.EDO_SKD_VOY_NO," ).append("\n"); 
		query.append("       A.EDO_SKD_DIR_CD," ).append("\n"); 
		query.append("       A.POD_CD," ).append("\n"); 
		query.append("       DECODE(A.EDO_TP_CD, '5JK', TO_CHAR(A.VSL_ARR_DT, 'YYYY-MM-DD HH24:MI:SS'), TO_CHAR(A.VSL_ARR_DT, 'YYYY-MM-DD'))  AS VSL_ARR_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.EDO_RCT_DT, 'YYYY-MM-DD HH24:MI:SS') AS EDO_RCT_DT," ).append("\n"); 
		query.append("       A.EDO_RCT_LOC_CD," ).append("\n"); 
		query.append("       B.LOC_NM         AS EDO_RCT_LOC_NM," ).append("\n"); 
		query.append("       A.EDO_ACK_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.EDO_ACK_DT, 'YYYY-MM-DD HH24:MI:SS') AS EDO_ACK_DT," ).append("\n"); 
		query.append("       A.EDO_ACK_USR_ID," ).append("\n"); 
		query.append("       A.EDO_RJCT_RSN," ).append("\n"); 
		query.append("       A.DELT_FLG," ).append("\n"); 
		query.append("       A.DELT_DT," ).append("\n"); 
		query.append("       A.DELT_USR_ID," ).append("\n"); 
		query.append("       A.DIFF_RMK," ).append("\n"); 
		query.append("       A.CRE_USR_ID," ).append("\n"); 
		query.append("       A.CRE_DT," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       A.UPD_DT," ).append("\n"); 
		query.append("       A.EDO_ACK_OFC_CD" ).append("\n"); 
		query.append("  FROM BKG_EDO_MST   A," ).append("\n"); 
		query.append("       MDM_LOCATION  B" ).append("\n"); 
		query.append(" WHERE A.EDO_RQST_NO    = @[rqstNo]" ).append("\n"); 
		query.append("   AND A.EDO_RQST_SEQ   = (SELECT MAX(EDO_RQST_SEQ)" ).append("\n"); 
		query.append("                             FROM BKG_EDO_MST" ).append("\n"); 
		query.append("                            WHERE EDO_RQST_NO    = @[rqstNo]" ).append("\n"); 
		query.append("                              AND EDO_TP_CD      = @[tpCd])" ).append("\n"); 
		query.append("   AND A.EDO_TP_CD      = @[tpCd]" ).append("\n"); 
		query.append("   AND A.EDO_RCT_LOC_CD = B.LOC_CD (+)" ).append("\n"); 

	}
}