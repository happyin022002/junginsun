/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchLocalIpiStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
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
		query.append("--여기서 단순히 L은 Local을 의미하는것이 아니라 EDI 전송을 막기위한 flag I이면 F/O 상관없이 J 전송됨" ).append("\n"); 
		query.append("SELECT CASE WHEN @[pod_cd] IN ('USLGB','USLAX') THEN " ).append("\n"); 
		query.append("            CASE WHEN @[del_cd] IN ('MXTIJ','MXSXN','MXMXL') OR IPI_LOCAL.STE_CD IN ('CA','NV','SZ','NM') " ).append("\n"); 
		query.append("                 THEN 'L' ELSE IPI_LOCAL.IPI_IND END" ).append("\n"); 
		query.append("            ELSE IPI_LOCAL.IPI_IND" ).append("\n"); 
		query.append("             END IPI_STATUS" ).append("\n"); 
		query.append("  FROM (SELECT CASE WHEN IBD.CSTMS_CLR_TP_CD = 'I' AND IBD.IBD_TRSP_TP_CD ='62' THEN 'L' --Redmine 41976 Logic 추가  T&E일 경우 F/O clear되어야 J전송이 가능 (20150707)" ).append("\n"); 
		query.append("                    WHEN IBD.CSTMS_CLR_TP_CD = 'I' AND BKG.DEST_TRNS_MOD_CD ='T' and BKG.DE_TERM_CD ='D' THEN 'L' --Redmine 41976 Truck이고 Door이면 F/O clear되어야 J전송 (20150707)" ).append("\n"); 
		query.append("                    WHEN IBD.CSTMS_CLR_TP_CD = 'I' THEN 'I' " ).append("\n"); 
		query.append("                    WHEN IBD.CSTMS_CLR_TP_CD = 'L' THEN 'L'" ).append("\n"); 
		query.append("                    WHEN IBD.CSTMS_CLR_TP_CD = 'N' AND IBD_TRSP_NO > ' ' THEN 'I'" ).append("\n"); 
		query.append("                    ELSE 'L' END IPI_IND," ).append("\n"); 
		query.append("               (SELECT NVL(STE_CD,' ') FROM MDM_LOCATION WHERE LOC_CD = @[del_cd]) STE_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_IBD IBD, BKG_BOOKING BKG" ).append("\n"); 
		query.append("         WHERE IBD.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND IBD.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("           AND IBD.BL_NO  = @[bl_no]) IPI_LOCAL" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}