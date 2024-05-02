/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOsearchBbContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOsearchBbContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationCMDBDAOsearchBbContainer
	  * </pre>
	  */
	public BLDocumentationCMDBDAOsearchBbContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOsearchBbContainerRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO FROM MST_CONTAINER MST" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND MST.CNTR_TPSZ_CD ='B4'" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT CNTR.CNTR_NO FROM BKG_VVD VVD1, " ).append("\n"); 
		query.append("                                (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                                   FROM   BKG_VVD" ).append("\n"); 
		query.append("                                   WHERE  BKG_NO = @[bkg_no]) VVD2," ).append("\n"); 
		query.append("                                BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                WHERE 1=1  " ).append("\n"); 
		query.append("                  AND VVD1.VSL_CD = VVD2.VSL_CD" ).append("\n"); 
		query.append("                  AND VVD1.SKD_VOY_NO = VVD2.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND VVD1.SKD_DIR_CD = VVD2.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND VVD1.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("                  AND CNTR.CNTR_TPSZ_CD ='B4'" ).append("\n"); 
		query.append("                  AND MST.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("AND ROWNUM <= @[cnt]" ).append("\n"); 

	}
}