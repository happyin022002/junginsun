/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchLocalIpiStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.10.22 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchLocalIpiStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchLocalIpiStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchLocalIpiStatusRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[pod_cd],'USLGB'," ).append("\n"); 
		query.append("CASE WHEN @[del_cd] IN ('MXTIJ','MXSXN','MXMXL') OR IPI_LOCAL.STE_CD IN ('CA','NV','SZ','NM')" ).append("\n"); 
		query.append("THEN 'L' ELSE IPI_LOCAL.IPI_IND END," ).append("\n"); 
		query.append("IPI_LOCAL.IPI_IND) AS IPI_STATUS" ).append("\n"); 
		query.append("FROM (SELECT CASE WHEN CSTMS_CLR_TP_CD = 'I' THEN 'I'" ).append("\n"); 
		query.append("WHEN CSTMS_CLR_TP_CD = 'L' THEN 'L'" ).append("\n"); 
		query.append("WHEN CSTMS_CLR_TP_CD = 'N' AND IBD_TRSP_NO > ' ' THEN 'I'" ).append("\n"); 
		query.append("ELSE 'L' END IPI_IND," ).append("\n"); 
		query.append("(SELECT NVL(STE_CD,' ') FROM MDM_LOCATION WHERE LOC_CD = @[del_cd]) STE_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_IBD" ).append("\n"); 
		query.append("WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("AND BL_NO  = @[bl_no]) IPI_LOCAL" ).append("\n"); 

	}
}