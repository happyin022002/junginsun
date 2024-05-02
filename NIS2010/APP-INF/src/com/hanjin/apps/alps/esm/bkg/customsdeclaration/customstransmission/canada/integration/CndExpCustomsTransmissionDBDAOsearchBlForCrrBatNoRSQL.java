/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpCustomsTransmissionDBDAOsearchBlForCrrBatNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpCustomsTransmissionDBDAOsearchBlForCrrBatNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CndExpCustomsTransmissionDBDAOsearchBlForCrrBatNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndExpCustomsTransmissionDBDAOsearchBlForCrrBatNoRSQL").append("\n"); 
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
		query.append("SELECT A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,B.BL_NO" ).append("\n"); 
		query.append("      ,A.POL_CD AS CSTMS_POL_CD" ).append("\n"); 
		query.append("      ,A.POD_CD AS CSTMS_POD_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_SND_LOG     A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_EDI_BL_RSPN B" ).append("\n"); 
		query.append(" WHERE A.CNT_CD     = B.CNT_CD" ).append("\n"); 
		query.append("   AND A.CRR_BAT_NO = B.CRR_BAT_NO" ).append("\n"); 
		query.append("   AND A.CNT_CD     = 'CA'" ).append("\n"); 
		query.append("   AND A.CRR_BAT_NO   = @[crr_bat_no]" ).append("\n"); 

	}
}