/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchEmlNtfcBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.14
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.10.14 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchEmlNtfcBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchEmlNtfcBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchEmlNtfcBlInfoRSQL").append("\n"); 
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
		query.append("SELECT (SELECT S.CUST_NM" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_CUST S" ).append("\n"); 
		query.append("         WHERE S.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("           AND S.BL_NO  = B.BL_NO" ).append("\n"); 
		query.append("           AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("       ) AS SHIPPER" ).append("\n"); 
		query.append("      ,(SELECT S.CUST_NM" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_CUST S" ).append("\n"); 
		query.append("         WHERE S.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("           AND S.BL_NO  = B.BL_NO" ).append("\n"); 
		query.append("           AND S.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("       ) AS CONSIGNEE" ).append("\n"); 
		query.append("      ,'' AS REASON" ).append("\n"); 
		query.append("      ,NVL(@[pol_cd], B.CSTMS_POL_CD) AS CSTMS_POL_CD" ).append("\n"); 
		query.append("      ,NVL(@[pod_cd], B.CSTMS_POD_CD) AS CSTMS_POD_CD" ).append("\n"); 
		query.append("      ,B.BL_NO" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_BL          B" ).append("\n"); 
		query.append(" WHERE B.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND B.BL_NO = @[bl_no]" ).append("\n"); 

	}
}