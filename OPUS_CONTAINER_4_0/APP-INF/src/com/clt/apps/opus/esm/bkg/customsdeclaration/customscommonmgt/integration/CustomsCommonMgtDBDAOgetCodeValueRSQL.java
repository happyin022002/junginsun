/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsCommonMgtDBDAOgetCodeValueRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomsCommonMgtDBDAOgetCodeValueRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CustomsCommonMgtDBDAOgetCodeValueRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration").append("\n"); 
		query.append("FileName : CustomsCommonMgtDBDAOgetCodeValueRSQL").append("\n"); 
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
		query.append("SELECT ${rtn_col_1}" ).append("\n"); 
		query.append("#if (${rtn_col_2} != '')" ).append("\n"); 
		query.append("      ,${rtn_col_2}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rtn_col_3} != '')" ).append("\n"); 
		query.append("      ,${rtn_col_3}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rtn_col_4} != '')" ).append("\n"); 
		query.append("      ,${rtn_col_4}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rtn_col_5} != '')" ).append("\n"); 
		query.append("      ,${rtn_col_5}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rtn_col_6} != '')" ).append("\n"); 
		query.append("      ,${rtn_col_6}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rtn_col_7} != '')" ).append("\n"); 
		query.append("      ,${rtn_col_7}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rtn_col_8} != '')" ).append("\n"); 
		query.append("      ,${rtn_col_8}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rtn_col_9} != '')" ).append("\n"); 
		query.append("      ,${rtn_col_9}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM ${tbl_nm_1}" ).append("\n"); 
		query.append("#if (${tbl_nm_2} != '')" ).append("\n"); 
		query.append("      ,${tbl_nm_2}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tbl_nm_3} != '')" ).append("\n"); 
		query.append("      ,${tbl_nm_3}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tbl_nm_4} != '')" ).append("\n"); 
		query.append("      ,${tbl_nm_4}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tbl_nm_5} != '')" ).append("\n"); 
		query.append("      ,${tbl_nm_5}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tbl_nm_6} != '')" ).append("\n"); 
		query.append("      ,${tbl_nm_6}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tbl_nm_7} != '')" ).append("\n"); 
		query.append("      ,${tbl_nm_7}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tbl_nm_8} != '')" ).append("\n"); 
		query.append("      ,${tbl_nm_8}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tbl_nm_9} != '')" ).append("\n"); 
		query.append("      ,${tbl_nm_9}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE ${whr_val_1}" ).append("\n"); 
		query.append("#if (${whr_val_2} != '')" ).append("\n"); 
		query.append("   AND ${whr_val_2}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${whr_val_3} != '')" ).append("\n"); 
		query.append("   AND ${whr_val_3}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${whr_val_4} != '')" ).append("\n"); 
		query.append("   AND ${whr_val_4}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${whr_val_5} != '')" ).append("\n"); 
		query.append("   AND ${whr_val_5}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${whr_val_6} != '')" ).append("\n"); 
		query.append("   AND ${whr_val_6}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${whr_val_7} != '')" ).append("\n"); 
		query.append("   AND ${whr_val_7}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${whr_val_8} != '')" ).append("\n"); 
		query.append("   AND ${whr_val_8}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${whr_val_9} != '')" ).append("\n"); 
		query.append("   AND ${whr_val_9}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}