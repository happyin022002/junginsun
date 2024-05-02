/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvPartyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewEdiDBDAOsearchFlatFileEsvPartyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND
	  * {PORT_VOYAGE_DETAIL
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileEsvPartyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvPartyRSQL").append("\n"); 
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
		query.append("SELECT T1.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT DECODE(SO.TRSP_BND_CD, 'I', 'Consignee', 'O', 'Shipper') AS PARTY_TYPE" ).append("\n"); 
		query.append("			  ,NVL(M.CUST_LGL_ENG_NM, C.CUST_NM) AS PARTY_NAME" ).append("\n"); 
		query.append("			  ,C.CUST_ADDR AS PARTY_ADD1" ).append("\n"); 
		query.append("			  ,'' AS PARTY_ADD2" ).append("\n"); 
		query.append("			  ,C.CUST_CTY_NM AS PARTY_CITY" ).append("\n"); 
		query.append("			  ,C.CUST_ZIP_ID AS PARTY_POSTAL" ).append("\n"); 
		query.append("			  ,C.CUST_STE_CD AS PARTY_STATE" ).append("\n"); 
		query.append("			  ,CN.CNT_NM AS PARTY_CNT" ).append("\n"); 
		query.append("		  FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("			  ,BKG_CUSTOMER     C" ).append("\n"); 
		query.append("			  ,MDM_CUSTOMER     M" ).append("\n"); 
		query.append("			  ,MDM_COUNTRY      CN" ).append("\n"); 
		query.append("		 WHERE SO.TRSP_BND_CD IN ('I', 'O')" ).append("\n"); 
		query.append("		   AND SO.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("		   AND DECODE(SO.TRSP_BND_CD, 'I', 'C', 'O', 'S') = C.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("		   AND C.CUST_CNT_CD = M.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("		   AND C.CUST_SEQ = M.CUST_SEQ(+)" ).append("\n"); 
		query.append("		   AND C.CUST_CNT_CD = CN.CNT_CD(+)" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 'Bill to' AS PARTY_TYPE" ).append("\n"); 
		query.append("			  ,M.OFC_ADDR AS PARTY_NAME" ).append("\n"); 
		query.append("			  ,'' AS PARTY_ADD1" ).append("\n"); 
		query.append("			  ,'' AS PARTY_ADD2" ).append("\n"); 
		query.append("			  ,'' AS PARTY_CITY" ).append("\n"); 
		query.append("			  ,'' AS PARTY_POSTAL" ).append("\n"); 
		query.append("			  ,'' AS PARTY_STATE" ).append("\n"); 
		query.append("			  ,'' AS PARTY_CNT" ).append("\n"); 
		query.append("		  FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("			  ,MDM_YARD         C" ).append("\n"); 
		query.append("			  ,MDM_ORGANIZATION M" ).append("\n"); 
		query.append("		 WHERE SO.FM_NOD_CD = C.YD_CD(+)" ).append("\n"); 
		query.append("		   AND C.OFC_CD = M.OFC_CD(+)" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append(" ) T1" ).append("\n"); 
		query.append(" RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("    ON 1 = 1" ).append("\n"); 

	}
}