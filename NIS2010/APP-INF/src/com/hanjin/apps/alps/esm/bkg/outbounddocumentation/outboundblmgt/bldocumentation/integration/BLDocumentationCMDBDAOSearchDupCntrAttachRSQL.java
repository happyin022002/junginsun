/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchDupCntrAttachRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchDupCntrAttachRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationCMDBDAOSearchDupCntrAttach
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchDupCntrAttachRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOSearchDupCntrAttachRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO, CNTR_VOL_QTY, RSTR" ).append("\n"); 
		query.append("FROM   (SELECT A1.BKG_NO" ).append("\n"); 
		query.append(",              A3.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",              A1.BKG_NO || ' : ' || TO_CHAR (A3.CNTR_VOL_QTY, '0.00') AS RSTR" ).append("\n"); 
		query.append(",              SUM(A3.CNTR_VOL_QTY) OVER (PARTITION BY A3.CNTR_NO, A1.VSL_CD, A1.SKD_VOY_NO, A1.SKD_DIR_CD) AS VOLSUM" ).append("\n"); 
		query.append("        FROM   BKG_VVD A1, (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                            FROM   BKG_VVD" ).append("\n"); 
		query.append("                            WHERE  BKG_NO = @[bkg_no]) A2, BKG_CONTAINER A3" ).append("\n"); 
		query.append("        WHERE  A1.VSL_CD = A2.VSL_CD" ).append("\n"); 
		query.append("           AND A1.SKD_VOY_NO = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A1.SKD_DIR_CD = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND A1.BKG_NO = A3.BKG_NO" ).append("\n"); 
		query.append("           AND A3.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("           AND A3.CNTR_PRT_FLG ='N'" ).append("\n"); 
		query.append("           AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                       FROM   BKG_BOOKING A4" ).append("\n"); 
		query.append("                       WHERE  A1.BKG_NO = A4.BKG_NO" ).append("\n"); 
		query.append("                          AND A4.BKG_STS_CD IN ('F', 'W')" ).append("\n"); 
		query.append("                          AND A4.BKG_CGO_TP_CD <> 'P'))" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND BKG_NO <> @[bkg_no]" ).append("\n"); 
		query.append("AND VOLSUM >= 1" ).append("\n"); 

	}
}