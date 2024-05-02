/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchPreMFRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchPreMFRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchPreMFRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchPreMFRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) BL_COUNT " ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("     ,BKG_CSTMS_ADV_RCV_LOG R_LOG" ).append("\n"); 
		query.append("     ,BKG_CSTMS_ADV_EDI_BL_RSPN EDI" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     BL.BL_NO = EDI.BL_NO" ).append("\n"); 
		query.append("AND     BL.CNT_CD = EDI.CNT_CD" ).append("\n"); 
		query.append("AND     R_LOG.CNT_CD     = EDI.CNT_CD" ).append("\n"); 
		query.append("AND     R_LOG.CRR_BAT_NO = EDI.CRR_BAT_NO" ).append("\n"); 
		query.append("AND     BL.CNT_CD     = 'US'" ).append("\n"); 
		query.append("AND     BL.MF_SND_DT IS NOT NULL" ).append("\n"); 
		query.append("AND     BL.BL_NO IN (" ).append("\n"); 
		query.append("                        SELECT PRE_MF_NO" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("                         WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                           AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                    )" ).append("\n"); 

	}
}