/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCarrierRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCarrierRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PARTNER EDI의 Carrier code가져오기
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCarrierRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCarrierRSQL").append("\n"); 
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
		query.append("WITH V_CRR AS " ).append("\n"); 
		query.append("   ( SELECT CRR_CD   " ).append("\n"); 
		query.append("      FROM MDM_CARRIER" ).append("\n"); 
		query.append("     WHERE DELT_FLG = 'N' " ).append("\n"); 
		query.append("       AND CRR_CD   = @[crr_nm]" ).append("\n"); 
		query.append("     UNION " ).append("\n"); 
		query.append("     SELECT UNIV_CD AS CRR_CD" ).append("\n"); 
		query.append("       FROM STO_CD_EDI_CNVT" ).append("\n"); 
		query.append("      WHERE CATE_CD  = 'OPER'" ).append("\n"); 
		query.append("        AND PRIV_CD  = @[crr_nm] " ).append("\n"); 
		query.append("        AND PRNR_CD  = 'ZZZZZ') " ).append("\n"); 
		query.append("  SELECT  DECODE( (SELECT COUNT(1) FROM V_CRR), 1, CRR_CD, NULL) AS CRR_CD" ).append("\n"); 
		query.append("    FROM V_CRR" ).append("\n"); 

	}
}