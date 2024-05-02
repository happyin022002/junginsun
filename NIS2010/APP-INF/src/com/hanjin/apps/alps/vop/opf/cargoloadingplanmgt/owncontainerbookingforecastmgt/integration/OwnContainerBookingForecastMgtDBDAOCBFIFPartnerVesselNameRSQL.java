/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerVesselNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOCBFIFPartnerVesselNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * partner EDI의 VESSEL CODE.
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFPartnerVesselNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerVesselNameRSQL").append("\n"); 
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
		query.append("WITH VSLNM AS" ).append("\n"); 
		query.append("( SELECT MAX(VSL_CD) AS VSL_CD , MAX(VSL_CD2) AS VSL_CD2" ).append("\n"); 
		query.append(" FROM " ).append("\n"); 
		query.append("( SELECT VSL_CD, NULL VSL_CD2 FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("   WHERE VSL_ENG_NM = @[edi_vsl_nm]" ).append("\n"); 
		query.append("     AND DELT_FLG   = 'N'" ).append("\n"); 
		query.append("     AND ROWNUM     =  1" ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("   SELECT NULL VSL_CD, VSL_CD AS VSL_CD2 FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("    WHERE CALL_SGN_NO = @[call_sgn_no]" ).append("\n"); 
		query.append("      AND DELT_FLG    = 'N'" ).append("\n"); 
		query.append("      AND ROWNUM      =  1  ) ) " ).append("\n"); 
		query.append("    SELECT CASE WHEN VSL_CD IS NOT NULL THEN VSL_CD" ).append("\n"); 
		query.append("                WHEN VSL_CD2 IS NOT NULL THEN VSL_CD2" ).append("\n"); 
		query.append("                ELSE NULL" ).append("\n"); 
		query.append("           END AS VSL_CD " ).append("\n"); 
		query.append("      FROM VSLNM" ).append("\n"); 

	}
}