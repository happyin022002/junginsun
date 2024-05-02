/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchVslInfoVslRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.04.29 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchVslInfoVslRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel ETA 정보 조회
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchVslInfoVslRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchVslInfoVslRSQL").append("\n"); 
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
		query.append("SELECT BVVD" ).append("\n"); 
		query.append("      ,BPOL" ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = X.POL_CD ) AS BPOL_NAME" ).append("\n"); 
		query.append("      ,BPOD" ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = X.POD_CD ) AS BPOD_NAME" ).append("\n"); 
		query.append("FROM (SELECT " ).append("\n"); 
		query.append("    VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS BVVD" ).append("\n"); 
		query.append("    ,POL_YD_CD AS BPOL" ).append("\n"); 
		query.append("    ,POL_CD" ).append("\n"); 
		query.append("    ,POD_YD_CD AS BPOD" ).append("\n"); 
		query.append("    ,POD_CD" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]) X" ).append("\n"); 

	}
}