/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AdjustmentManageDBDAOSearchROCToOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.02.05 최 선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentManageDBDAOSearchROCToOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchROCToOfficeList
	  * </pre>
	  */
	public AdjustmentManageDBDAOSearchROCToOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.integration").append("\n"); 
		query.append("FileName : AdjustmentManageDBDAOSearchROCToOfficeListRSQL").append("\n"); 
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
		query.append("SELECT TPB_GET_HNDL_OFC_FNC('R',NVL(N3PTY_OFC_CD,OFC_CD)) AS RHQ_CD," ).append("\n"); 
		query.append("N3PTY_OFC_CD," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("DELT_FLG" ).append("\n"); 
		query.append("FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TPB_GET_HNDL_OFC_FNC('R',NVL(N3PTY_OFC_CD,OFC_CD)) IS NOT NULL" ).append("\n"); 
		query.append("AND N3PTY_OFC_TP_CD = 'G'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("AND TPB_GET_HNDL_OFC_FNC('R',N3PTY_OFC_CD) = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_if_ofc_cd} != '')" ).append("\n"); 
		query.append("AND N3PTY_OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_ofc_cd} != '')" ).append("\n"); 
		query.append("AND OFC_CD LIKE @[s_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RHQ_CD, N3PTY_OFC_CD, OFC_CD" ).append("\n"); 

	}
}