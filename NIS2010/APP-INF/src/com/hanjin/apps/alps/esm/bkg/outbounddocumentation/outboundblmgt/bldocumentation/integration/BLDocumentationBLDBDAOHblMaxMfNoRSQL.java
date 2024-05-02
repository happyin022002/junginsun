/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationBLDBDAOHblMaxMfNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.08 
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

public class BLDocumentationBLDBDAOHblMaxMfNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationBLDBDAOHblMaxMfNoRSQL(){
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
		query.append("FileName : BLDocumentationBLDBDAOHblMaxMfNoRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT /*+ ordered use_nl(a1 a2)*/" ).append("\n"); 
		query.append("MAX(A2.CNTR_MF_NO) AS MF_NO" ).append("\n"); 
		query.append("FROM BKG_BKG_HIS A1" ).append("\n"); 
		query.append(",BKG_HBL_HIS A2" ).append("\n"); 
		query.append("WHERE A1.BL_NO LIKE NVL((SELECT SUBSTR(BL_NO, 1, LENGTH(BL_NO) - 3)" ).append("\n"); 
		query.append("FROM BKG_BKG_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'), 'xxxxxxxxxxxxxxxxxxxx') || '%'" ).append("\n"); 
		query.append("AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND A1.CORR_NO = A2.CORR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT /*+ ordered use_nl(a1 a2)*/" ).append("\n"); 
		query.append("MAX(A2.CNTR_MF_NO) AS MF_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING A1" ).append("\n"); 
		query.append(",BKG_HBL A2" ).append("\n"); 
		query.append("WHERE A1.BL_NO LIKE NVL((SELECT SUBSTR(BL_NO, 1, LENGTH(BL_NO) - 3)" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]), 'xxxxxxxxxxxxxxxxxxxx') || '%'" ).append("\n"); 
		query.append("AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}