/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi10514701TrdAddrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi10514701TrdAddrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_105147_01_TRD_ADDR
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi10514701TrdAddrRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi10514701TrdAddrRSQL").append("\n"); 
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
		query.append("SELECT TROA.TRO_SUB_SEQ	TRD_ADDR_SEQ" ).append("\n"); 
		query.append("	  ,TROA.DOR_ADDR_TP_CD TRD_TYPE" ).append("\n"); 
		query.append("	  ,TROA.LOC_CD TRD_DOOR_LOC" ).append("\n"); 
		query.append("	  ,(SELECT UPPER(LOC_NM) FROM MDM_LOCATION WHERE LOC_CD = TROA.LOC_CD) AS TRD_DOOR_LOC_NM" ).append("\n"); 
		query.append("      ,CASE WHEN TROA.UPD_DT < (SELECT TO_DATE(ATTR_CTNT1, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                		     	  FROM BKG_HRD_CDG_CTNT    				" ).append("\n"); 
		query.append("                  		   		 WHERE HRD_CDG_ID = 'EUR_TRO_ADDRESS') THEN " ).append("\n"); 
		query.append("        		 TRIM(SUBSTR(TROA.DOR_ADDR,1,30))||' '|| TRIM(SUBSTR(TROA.DOR_ADDR,31,30))||' '||TRIM(SUBSTR(TROA.DOR_ADDR,61,30))||' '||TRIM(SUBSTR(TROA.DOR_ADDR,91,30))  " ).append("\n"); 
		query.append("       	    ELSE    															" ).append("\n"); 
		query.append("          		 TRIM(SUBSTR(TROA.DOR_ADDR,1,50))||' '|| TRIM(SUBSTR(TROA.DOR_ADDR,51,50))||' '||TRIM(SUBSTR(TROA.DOR_ADDR,101,50))||' '||TRIM(SUBSTR(TROA.DOR_ADDR,151,50))" ).append("\n"); 
		query.append(" 		END AS TRD_DOOR_ADDR" ).append("\n"); 
		query.append("	  ,UPPER(CASE WHEN TROA.UPD_DT < (SELECT TO_DATE(ATTR_CTNT1, 'YYYYMMDDHH24MISS') FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'EUR_TRO_ADDRESS') THEN" ).append("\n"); 
		query.append("			TRIM(SUBSTR(TROA.DOR_ADDR,1,30))" ).append("\n"); 
		query.append("       ELSE " ).append("\n"); 
		query.append("			TRIM(SUBSTR(TROA.DOR_ADDR,1,50))" ).append("\n"); 
		query.append("	   END) AS TRD_DOOR_ADDR1" ).append("\n"); 
		query.append("	  ,UPPER(CASE WHEN TROA.UPD_DT < (SELECT TO_DATE(ATTR_CTNT1, 'YYYYMMDDHH24MISS') FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'EUR_TRO_ADDRESS') THEN" ).append("\n"); 
		query.append("			TRIM(SUBSTR(TROA.DOR_ADDR,31,30))" ).append("\n"); 
		query.append("       ELSE " ).append("\n"); 
		query.append("			TRIM(SUBSTR(TROA.DOR_ADDR,51,50))" ).append("\n"); 
		query.append("	   END) AS TRD_DOOR_ADDR2" ).append("\n"); 
		query.append("	  ,UPPER(CASE WHEN TROA.UPD_DT < (SELECT TO_DATE(ATTR_CTNT1, 'YYYYMMDDHH24MISS') FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'EUR_TRO_ADDRESS') THEN" ).append("\n"); 
		query.append("			TRIM(SUBSTR(TROA.DOR_ADDR,61,30))" ).append("\n"); 
		query.append("       ELSE " ).append("\n"); 
		query.append("			TRIM(SUBSTR(TROA.DOR_ADDR,101,50))" ).append("\n"); 
		query.append("	   END) AS TRD_DOOR_ADDR3" ).append("\n"); 
		query.append("	  ,UPPER(CASE WHEN TROA.UPD_DT < (SELECT TO_DATE(ATTR_CTNT1, 'YYYYMMDDHH24MISS') FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'EUR_TRO_ADDRESS') THEN" ).append("\n"); 
		query.append("			TRIM(SUBSTR(TROA.DOR_ADDR,91,30))" ).append("\n"); 
		query.append("       ELSE " ).append("\n"); 
		query.append("			TRIM(SUBSTR(TROA.DOR_ADDR,151,50))" ).append("\n"); 
		query.append("	   END) AS TRD_DOOR_ADDR4" ).append("\n"); 
		query.append("	  ,TO_CHAR(SO.DOR_NOD_PLN_DT,'YYYYMMDDHH24MI') AS	TRD_DOOR_DT" ).append("\n"); 
		query.append("	  ,TROA.DOR_ZIP_ID TRD_DOOR_POSTAL" ).append("\n"); 
		query.append("	  ,TROA.CNTC_PSON_NM TRD_PERSON" ).append("\n"); 
		query.append("	  ,TROA.CNTC_PHN_NO TRD_TEL" ).append("\n"); 
		query.append("  FROM BKG_EUR_TRO_DTL TROA" ).append("\n"); 
		query.append("	  ,TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append(" WHERE SO.DELT_FLG <> 'Y'    " ).append("\n"); 
		query.append("   AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_SEQ  = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND SO.HJL_NO IS NULL" ).append("\n"); 
		query.append("   AND SO.BKG_NO = TROA.BKG_NO" ).append("\n"); 
		query.append("   AND TROA.TRO_SEQ = SO.TRO_SEQ" ).append("\n"); 

	}
}