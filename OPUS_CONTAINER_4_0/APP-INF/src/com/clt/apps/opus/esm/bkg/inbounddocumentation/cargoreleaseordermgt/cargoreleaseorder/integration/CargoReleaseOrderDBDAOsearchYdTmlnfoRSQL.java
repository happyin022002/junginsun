/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchYdTmlnfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchYdTmlnfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchYdTmlnfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchYdTmlnfoRSQL").append("\n"); 
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
		query.append("SELECT MAX(BKG_FULL_RLSE_EDI_CD)  AS FULL_RLSE_EDI_CD, " ).append("\n"); 
		query.append("        MAX(BKG_TERM_ID)   AS TERM_ID" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("        SELECT C.BL_NO AS BKG_BL_NO," ).append("\n"); 
		query.append("               D.MSG_TP_DESC AS BKG_FULL_RLSE_EDI_CD," ).append("\n"); 
		query.append("               SUBSTR(B.RCVR_TRD_PRNR_ID, 1, 3) AS BKG_TERM_ID" ).append("\n"); 
		query.append("            FROM BKG_CGO_RLSE A," ).append("\n"); 
		query.append("              BKG_EDI_TRD_PRNR_SUB_LNK B," ).append("\n"); 
		query.append("              BKG_BOOKING C," ).append("\n"); 
		query.append("              BKG_EDI_SUB_LNK_MSG D" ).append("\n"); 
		query.append("            WHERE A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("              AND A.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("              AND B.PRNR_SUB_LNK_CD = C.POD_NOD_CD" ).append("\n"); 
		query.append("              AND B.TRD_PRNR_SUB_LNK_SEQ = D.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("              AND D.EDI_MSG_TP_ID = 'TDC315'" ).append("\n"); 
		query.append("              AND (D.EDI_MSG_IND_CD = 0 OR D.EDI_MSG_IND_CD = 1)" ).append("\n"); 
		query.append("              AND ROWNUM = 1" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}