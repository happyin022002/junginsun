/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchCncusDangerCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchCncusDangerCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChinaCncusDangerCntrVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchCncusDangerCntrRSQL(){
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
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchCncusDangerCntrRSQL").append("\n"); 
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
		query.append("        ,SCD.IMDG_PG_NO				AS PAGE" ).append("\n"); 
		query.append("    	,SCD.IMDG_UN_NO				AS UNDGNO" ).append("\n"); 
		query.append("    	,SCD.IMDG_SUBS_RSK_LBL_CD	AS LABEL" ).append("\n"); 
		query.append("		,SCD.FLSH_PNT_CDO_TEMP		AS FLASH_POINT" ).append("\n"); 
		query.append("		,SCD.EMS_NO					AS EMS_NO" ).append("\n"); 
		query.append("    	,SCD.CNTC_PSON_NM			AS CONTACT_NAME" ).append("\n"); 
		query.append("    	,SCD.CNTC_PSON_TELCM_NO		AS CONTACT_TEL" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_CHN_DG_CGO SCD	" ).append("\n"); 
		query.append("WHERE	SCD.BL_NO		=	@[bl_no]" ).append("\n"); 
		query.append("AND	    SCD.CHN_MF_SND_IND_CD =	@[trans_mode]" ).append("\n"); 

	}
}