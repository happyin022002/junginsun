/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMReportDBDAOGetReportItemListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.10.09 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMReportDBDAOGetReportItemListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ACMReportDBDAOGetReportItemListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slct_itm_fom_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmreport.acmreport.integration").append("\n"); 
		query.append("FileName : ACMReportDBDAOGetReportItemListRSQL").append("\n"); 
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
		query.append("SELECT DTL.AC_RPT_ITM_CD," ).append("\n"); 
		query.append("       LOWER(DTL.RPT_ITM_COL_NM) AS RPT_ITM_COL_NM," ).append("\n"); 
		query.append("       DTL.RPT_ITM_DESC" ).append("\n"); 
		query.append("  FROM AGT_RPT_ITM_INFO_MST MST," ).append("\n"); 
		query.append("       AGT_RPT_ITM_INFO_DTL DTL" ).append("\n"); 
		query.append(" WHERE MST.CRE_USR_ID = DTL.CRE_USR_ID(+)" ).append("\n"); 
		query.append("   AND MST.SLCT_ITM_FOM_SEQ = DTL.SLCT_ITM_FOM_SEQ(+)" ).append("\n"); 
		query.append("#if (${slct_itm_fom_seq} != '')" ).append("\n"); 
		query.append("   AND MST.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   AND MST.SLCT_ITM_FOM_SEQ = @[slct_itm_fom_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND MST.CRE_USR_ID = 'SYSTEM'" ).append("\n"); 
		query.append("   AND MST.SLCT_ITM_FOM_SEQ = 1" ).append("\n"); 
		query.append("   ORDER BY DTL.AC_RPT_ITM_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}