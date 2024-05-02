/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByOFCDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.14
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2010.03.14 이주현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByOFCDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByOFCDataUSQL
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByOFCDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByOFCDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DAT_VRFY A" ).append("\n"); 
		query.append("SET INP_MSG4 = 'UO'" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND   A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("AND   NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("FROM  MNR_OFC_GEN_INFO MOGI, MNR_ORD_HDR MOH" ).append("\n"); 
		query.append("WHERE MOH.COST_OFC_CD       = MOGI.OFC_CD" ).append("\n"); 
		query.append("AND   MOGI.MNR_GRP_TP_CD     = 'OFC'" ).append("\n"); 
		query.append("AND   MOGI.COST_CD           = 'RPRINV'" ).append("\n"); 
		query.append("AND   MOGI.UPPR_OFC_CD       = @[user_ofc_cd]" ).append("\n"); 
		query.append("AND   SUBSTR(A.INP_MSG1,1,3) = MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   SUBSTR(A.INP_MSG1,4)   = MOH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM MNR_ORD_HDR MOH" ).append("\n"); 
		query.append("WHERE SUBSTR(A.INP_MSG1,1,3) = MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   SUBSTR(A.INP_MSG1,4)   = MOH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   MOH.COST_OFC_CD        = @[user_ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}