/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchMailContentsByEdiRefIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchMailContentsByEdiRefIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchMailContentsByEdiRefIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_ref_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchMailContentsByEdiRefIdRSQL").append("\n"); 
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
		query.append("SELECT (SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_CHN_SND_LOG" ).append("\n"); 
		query.append("         WHERE EDI_REF_ID = @[edi_ref_id]" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS VVD," ).append("\n"); 
		query.append("       LOGBL.BL_NO," ).append("\n"); 
		query.append("       LOGBL.BKG_POL_CD AS POL_CD," ).append("\n"); 
		query.append("       (SELECT LOC.LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION LOC" ).append("\n"); 
		query.append("         WHERE LOC.LOC_CD = LOGBL.BKG_POL_CD) AS POL_NM," ).append("\n"); 
		query.append("       LOGBL.BKG_POD_CD AS POD_CD," ).append("\n"); 
		query.append("       (SELECT LOC.LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION LOC" ).append("\n"); 
		query.append("         WHERE LOC.LOC_CD = LOGBL.BKG_POD_CD) AS POD_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_CHN_SND_LOG_BL LOGBL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE LOGBL.EDI_REF_ID = @[edi_ref_id]" ).append("\n"); 

	}
}