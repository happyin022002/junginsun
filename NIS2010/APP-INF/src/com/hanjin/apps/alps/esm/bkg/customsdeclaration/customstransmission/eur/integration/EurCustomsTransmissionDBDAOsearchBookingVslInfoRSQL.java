/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchBookingVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchBookingVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking vvd, pol, pod로 배 정보를 조회한다.
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchBookingVslInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchBookingVslInfoRSQL").append("\n"); 
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
		query.append("SELECT  @[vvd_cd] VVD" ).append("\n"); 
		query.append("        ,NVL(VSL_ENG_NM, '') VSL_FULLNAME" ).append("\n"); 
		query.append("		,NVL(VSL_RGST_CNT_CD, '') VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("        ,NVL(DECODE(@[pol_cd], NULL, @[pod_cd], @[pol_cd]),'') PORT" ).append("\n"); 
		query.append("        ,NVL((SELECT LOC_NM" ).append("\n"); 
		query.append("              FROM MDM_LOCATION" ).append("\n"); 
		query.append("             WHERE LOC_CD = NVL(@[pol_cd],@[pod_cd])" ).append("\n"); 
		query.append("             AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("             ), '') PORTNAME" ).append("\n"); 
		query.append("        , @[comp_id] COMP_ID" ).append("\n"); 
		query.append("FROM   MDM_VSL_CNTR  " ).append("\n"); 
		query.append("WHERE  VSL_CD =  SUBSTR (@[vvd_cd], 1, 4)" ).append("\n"); 

	}
}