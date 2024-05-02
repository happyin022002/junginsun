/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchAdvCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.10.12 김민정
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

public class UsaCustomsTransmissionDBDAOsearchAdvCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAdvCntr
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchAdvCntrRSQL(){
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
		params.put("crr_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchAdvCntrRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.BL_NO" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_CNTR A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_EDI_BL_RSPN B" ).append("\n"); 
		query.append(" WHERE A.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND A.CNTR_NO LIKE TRIM(@[bl_no])" ).append("\n"); 
		query.append("   AND A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("   AND A.BL_NO  = B.BL_NO" ).append("\n"); 
		query.append("   AND B.CRR_BAT_NO = @[crr_bat_no]" ).append("\n"); 

	}
}