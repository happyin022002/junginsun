/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi315SendDBDAOSearchBkgqtyInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchBkgqtyInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi315SendDBDAOSearchBkgqtyInformationRSQL
	  * </pre>
	  */
	public Edi315SendDBDAOSearchBkgqtyInformationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchBkgqtyInformationRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("WGT_UT_CD W_UNIT" ).append("\n"); 
		query.append(",ACT_WGT WEIGHT" ).append("\n"); 
		query.append(",MEAS_UT_CD MEA_UNIT" ).append("\n"); 
		query.append(",MEAS_QTY MEA_QTY" ).append("\n"); 
		query.append(",PCK_TP_CD P_UNIT" ).append("\n"); 
		query.append(",PCK_QTY PACKAGE" ).append("\n"); 
		query.append(",REPLACE(REPLACE(NVL(DEL_NM, ' '), CHR(13), ''), CHR(10), '') bl_store_nbr" ).append("\n"); 
		query.append("from BKG_BL_DOC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("and BKG_NO = @[e_bkg_no]" ).append("\n"); 

	}
}