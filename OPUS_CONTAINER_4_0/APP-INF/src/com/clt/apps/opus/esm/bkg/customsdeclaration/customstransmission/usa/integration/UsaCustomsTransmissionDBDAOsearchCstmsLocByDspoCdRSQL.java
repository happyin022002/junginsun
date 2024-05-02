/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCstmsLocByDspoCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.18 
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

public class UsaCustomsTransmissionDBDAOsearchCstmsLocByDspoCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaCustomsTransmissionDBDAOsearchCstmsLocByDspoCd - Disposition Code 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCstmsLocByDspoCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("icr_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCstmsLocByDspoCdRSQL").append("\n"); 
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
		query.append("SELECT CSTMS_DSPO_CD FROM BKG_CSTMS_ADV_DSPO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (DSPO_TP_CD IN ('HP','HM', 'RL')" ).append("\n"); 
		query.append("    OR CSTMS_DSPO_CD IN( '1C', '12'))" ).append("\n"); 
		query.append("AND CNT_CD='US'" ).append("\n"); 
		query.append("AND CSTMS_DSPO_CD = @[icr_code]" ).append("\n"); 

	}
}