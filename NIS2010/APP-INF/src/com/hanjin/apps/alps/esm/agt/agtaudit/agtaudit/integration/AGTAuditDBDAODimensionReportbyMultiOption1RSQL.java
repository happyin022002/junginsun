/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAODimensionReportbyMultiOption1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.04.14 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAODimensionReportbyMultiOption1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_0041 화면에서 RPT Form 선택시 컬럼 정보를 조회
	  * </pre>
	  */
	public AGTAuditDBDAODimensionReportbyMultiOption1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slct_itm_fom_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAODimensionReportbyMultiOption1RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("LPAD (MST.SLCT_ITM_FOM_SEQ, 3, '0') AS SLCT_ITM_FOM_SEQ," ).append("\n"); 
		query.append("MST.SLCT_ITM_FOM_DESC AS SLCT_ITM_FOM_DESC," ).append("\n"); 
		query.append("DTL.AC_RPT_ITM_CD AS RPT_ITM_CD," ).append("\n"); 
		query.append("DTL.RPT_ITM_COL_NM AS RPT_ITM_COL_NM," ).append("\n"); 
		query.append("DTL.RPT_ITM_DESC AS RPT_ITM_DESC" ).append("\n"); 
		query.append("FROM AGT_RPT_ITM_INFO_MST MST, AGT_RPT_ITM_INFO_DTL DTL" ).append("\n"); 
		query.append("WHERE MST.CRE_USR_ID = DTL.CRE_USR_ID(+)" ).append("\n"); 
		query.append("AND MST.SLCT_ITM_FOM_SEQ = DTL.SLCT_ITM_FOM_SEQ(+)" ).append("\n"); 
		query.append("AND MST.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("AND MST.SLCT_ITM_FOM_SEQ = @[slct_itm_fom_seq]" ).append("\n"); 

	}
}