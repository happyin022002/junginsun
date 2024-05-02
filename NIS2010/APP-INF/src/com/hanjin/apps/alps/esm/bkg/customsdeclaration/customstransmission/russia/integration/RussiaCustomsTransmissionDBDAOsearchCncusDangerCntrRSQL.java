/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RussiaCustomsTransmissionDBDAOsearchCncusDangerCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RussiaCustomsTransmissionDBDAOsearchCncusDangerCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCncusDangerCntr
	  * </pre>
	  */
	public RussiaCustomsTransmissionDBDAOsearchCncusDangerCntrRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration").append("\n"); 
		query.append("FileName : RussiaCustomsTransmissionDBDAOsearchCncusDangerCntrRSQL").append("\n"); 
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
		query.append("SELECT   SCD.IMDG_CLSS_CD			AS CLSS" ).append("\n"); 
		query.append("        ,''							AS PAGE" ).append("\n"); 
		query.append("    	,SCD.IMDG_UN_NO				AS UNDGNO" ).append("\n"); 
		query.append("    	,SCD.IMDG_SUBS_RSK_LBL_CD1	AS LABEL" ).append("\n"); 
		query.append("		,SCD.FLSH_PNT_CDO_TEMP		AS FLASH_POINT" ).append("\n"); 
		query.append("		,SCD.EMS_NO					AS EMS_NO" ).append("\n"); 
		query.append("    	,SCD.EMER_CNTC_PSON_NM			AS CONTACT_NAME" ).append("\n"); 
		query.append("    	,SCD.EMER_CNTC_PHN_NO_CTNT 		AS CONTACT_TEL" ).append("\n"); 
		query.append("FROM	BKG_DG_CGO SCD	" ).append("\n"); 
		query.append("WHERE	SCD.BKG_NO		=	@[bl_no]" ).append("\n"); 

	}
}