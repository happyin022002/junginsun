/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiCustomsTransmissionDBDAOsearchFlatFileCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiCustomsTransmissionDBDAOsearchFlatFileCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DubaiCntrInfoVO
	  * </pre>
	  */
	public DubaiCustomsTransmissionDBDAOsearchFlatFileCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.dubai.integration").append("\n"); 
		query.append("FileName : DubaiCustomsTransmissionDBDAOsearchFlatFileCntrListRSQL").append("\n"); 
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
		query.append("SELECT A.BL_NO, " ).append("\n"); 
		query.append("       SUBSTR(A.CNTR_NO, 1, LENGTH(A.CNTR_NO)-1) AS CNTR_NO," ).append("\n"); 
		query.append("       SUBSTR(A.CNTR_NO, LENGTH(A.CNTR_NO), 1) AS CHECK_DIGIT," ).append("\n"); 
		query.append("       A.DU_PCK_TP_CD, " ).append("\n"); 
		query.append("       A.CNTR_TARE_WGT, " ).append("\n"); 
		query.append("       A.CNTR_SEAL_NO, " ).append("\n"); 
		query.append("       (SELECT SUBSTR(CNTR_SZ_DESC, 1, 2) " ).append("\n"); 
		query.append("        FROM MDM_CNTR_SZ " ).append("\n"); 
		query.append("        WHERE CNTR_SZ_CD = SUBSTR(B.CNTR_TPSZ_CD, 2, 1)" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') SZ," ).append("\n"); 
		query.append("       (SELECT C.CNTR_TPSZ_ISO_CD " ).append("\n"); 
		query.append("        FROM MDM_CNTR_TP_SZ C " ).append("\n"); 
		query.append("        WHERE C.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        AND DELT_FLG = 'N') CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_DU_CNTR A, MST_CONTAINER B" ).append("\n"); 
		query.append(" WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND POD_CD = @[pod_cd]   " ).append("\n"); 
		query.append("   AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 

	}
}