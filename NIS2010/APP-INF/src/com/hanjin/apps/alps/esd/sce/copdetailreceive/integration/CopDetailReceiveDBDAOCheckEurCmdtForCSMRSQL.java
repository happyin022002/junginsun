/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CopDetailReceiveDBDAOCheckEurCmdtForCSMRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOCheckEurCmdtForCSMRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Europe CSM Outbound Commodity 구분
	  * </pre>
	  */
	public CopDetailReceiveDBDAOCheckEurCmdtForCSMRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOCheckEurCmdtForCSMRSQL").append("\n"); 
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
		query.append("SELECT 'NOT_EU_O/B_CMDT'" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, MDM_COUNTRY M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND M.CNT_CD IN (SUBSTR(B.POR_CD,1,2), SUBSTR(B.POL_CD,1,2))" ).append("\n"); 
		query.append("AND EU_CNT_FLG = 'Y'" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("    SELECT 'X'" ).append("\n"); 
		query.append("      FROM SCE_CSM_CMDT S" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND S.CMDT_CD = B.CMDT_CD" ).append("\n"); 
		query.append("       AND S.ACT_FLG = 'Y'" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}