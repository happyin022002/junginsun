/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DubaiCustomsTransmissionDBDAOsearchFlatFileCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.25 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.integration").append("\n"); 
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
		query.append("SELECT BL_NO" ).append("\n"); 
		query.append("      ,SUBSTR(CNTR_NO, 1, LENGTH(CNTR_NO)-1) AS CNTR_NO" ).append("\n"); 
		query.append("      ,SUBSTR(CNTR_NO, LENGTH(CNTR_NO), 1) AS CHECK_DIGIT" ).append("\n"); 
		query.append("      ,DU_PCK_TP_CD" ).append("\n"); 
		query.append("      ,CNTR_TARE_WGT" ).append("\n"); 
		query.append("      ,TRIM(CNTR_SEAL_NO) AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_DU_CNTR" ).append("\n"); 
		query.append(" WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND POD_CD = @[pod_cd]" ).append("\n"); 

	}
}