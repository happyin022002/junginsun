/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationCMDBDAOPkgForCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.15
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.10.15 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOPkgForCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOPkgForCntrRSQL(){
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
		query.append("FileName : BLDocumentationCMDBDAOPkgForCntrRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      (SELECT SUM (OP_CNTR_QTY)" ).append("\n"); 
		query.append("        FROM   BKG_QTY_HIS" ).append("\n"); 
		query.append("        WHERE  BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("           AND CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("        GROUP BY BKG_NO) QUANTITY" ).append("\n"); 
		query.append(",      (SELECT SUM (OP_CNTR_QTY)" ).append("\n"); 
		query.append("        FROM   BKG_QTY_HIS" ).append("\n"); 
		query.append("        WHERE  BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("           AND (AWK_CGO_QTY > 0" ).append("\n"); 
		query.append("             OR BB_CGO_QTY > 0" ).append("\n"); 
		query.append("             OR DCGO_QTY > 0" ).append("\n"); 
		query.append("             OR RC_QTY > 0)" ).append("\n"); 
		query.append("        GROUP BY BKG_NO) SPC_QTY" ).append("\n"); 
		query.append(",      A.PCK_QTY" ).append("\n"); 
		query.append(",      A.ACT_WGT" ).append("\n"); 
		query.append(",      A.WGT_UT_CD" ).append("\n"); 
		query.append(",      A.MEAS_QTY" ).append("\n"); 
		query.append(",      A.MEAS_UT_CD" ).append("\n"); 
		query.append("FROM   BKG_BL_DOC_HIS A" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      (SELECT   SUM(OP_CNTR_QTY)" ).append("\n"); 
		query.append("        FROM     BKG_QUANTITY" ).append("\n"); 
		query.append("        WHERE    BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND    CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("        GROUP BY BKG_NO) QUANTITY" ).append("\n"); 
		query.append(",      (SELECT   sum(OP_CNTR_QTY)" ).append("\n"); 
		query.append("        FROM     BKG_QUANTITY" ).append("\n"); 
		query.append("        WHERE    BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND      (AWK_CGO_QTY > 0 OR BB_CGO_QTY > 0 OR DCGO_QTY > 0 OR RC_QTY > 0)" ).append("\n"); 
		query.append("        GROUP BY BKG_NO) SPC_QTY" ).append("\n"); 
		query.append(",      A.PCK_QTY" ).append("\n"); 
		query.append(",      A.ACT_WGT" ).append("\n"); 
		query.append(",      A.WGT_UT_CD" ).append("\n"); 
		query.append(",      A.MEAS_QTY" ).append("\n"); 
		query.append(",      A.MEAS_UT_CD" ).append("\n"); 
		query.append("FROM   BKG_BL_DOC A" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}