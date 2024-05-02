/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BLDocumentationCMDBDAOBlByFnlCfmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.08
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.10.08 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOBlByFnlCfmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public BLDocumentationCMDBDAOBlByFnlCfmUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOBlByFnlCfmUSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("UPDATE BKG_BL_DOC_HIS" ).append("\n"); 
		query.append("SET    TTL_PCK_DESC = " ).append("\n"); 
		query.append("           (SELECT BKG_JOIN_FNC(CURSOR(SELECT A1.OP_CNTR_QTY || 'X' || SUBSTR(A2.CNTR_TPSZ_DESC, 1, 4)" ).append("\n"); 
		query.append("                                       FROM   BKG_QTY_HIS A1, MDM_CNTR_TP_SZ A2" ).append("\n"); 
		query.append("                                       WHERE  A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                       AND    A1.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                                       AND    A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                       AND    A1.CNTR_TPSZ_CD NOT LIKE 'Q%'), ',') " ).append("\n"); 
		query.append("                   || ' CONTAINER(S) ONLY'" ).append("\n"); 
		query.append("            FROM DUAL)" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("UPDATE BKG_BL_DOC " ).append("\n"); 
		query.append("SET    TTL_PCK_DESC = " ).append("\n"); 
		query.append("           (SELECT BKG_JOIN_FNC(CURSOR(SELECT A1.OP_CNTR_QTY || 'X' || SUBSTR(A2.CNTR_TPSZ_DESC, 1, 4)" ).append("\n"); 
		query.append("                                       FROM   BKG_QUANTITY A1, MDM_CNTR_TP_SZ A2" ).append("\n"); 
		query.append("                                       WHERE  A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                       AND    A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                       AND    A1.CNTR_TPSZ_CD NOT LIKE 'Q%'), ',') " ).append("\n"); 
		query.append("                   || ' CONTAINER(S) ONLY'" ).append("\n"); 
		query.append("            FROM DUAL)" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}