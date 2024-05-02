/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchSPPOFCInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.14
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.02.14 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchSPPOFCInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSPPOFCInfoData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchSPPOFCInfoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_ptal_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchSPPOFCInfoDataRSQL").append("\n"); 
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
		query.append("SELECT MCM.OFC_CD AS SPP_OFC_CD FROM MDM_CUSTOMER MCM,MNR_PARTNER MP" ).append("\n"); 
		query.append("WHERE MCM.CUST_CNT_CD = MP.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("AND MCM.CUST_SEQ = MP.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("AND MP.SP_PTAL_ID = @[sp_ptal_id]" ).append("\n"); 
		query.append("AND MP.MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}