/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PrdCreateManageDBDAOSearchAutoIRGSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.09
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2010.12.09 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOSearchAutoIRGSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check and generate Inland Route Guide Sequence
	  * </pre>
	  */
	public PrdCreateManageDBDAOSearchAutoIRGSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOSearchAutoIRGSeqRSQL").append("\n"); 
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
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("     , ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("     , ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("     , PCTL_IO_BND_CD" ).append("\n"); 
		query.append("     , PRD_INLND_ROUT_SEQ.NEXTVAL AS ROUT_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT MIN(PCTL_NO) PCTL_NO -- 대표 번호" ).append("\n"); 
		query.append("         , ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("         , ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("         , PCTL_IO_BND_CD" ).append("\n"); 
		query.append("    FROM PRD_PROD_CTL_ROUT_DTL RDTL" ).append("\n"); 
		query.append("    WHERE PCTL_NO LIKE @[hd_pctl_no] || '%'" ).append("\n"); 
		query.append("      AND RDTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("      AND RDTL.TRSP_MOD_CD <> 'X'" ).append("\n"); 
		query.append("      AND RDTL.ROUT_SEQ = -1 " ).append("\n"); 
		query.append("    GROUP BY ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("           , ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("           , PCTL_IO_BND_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}