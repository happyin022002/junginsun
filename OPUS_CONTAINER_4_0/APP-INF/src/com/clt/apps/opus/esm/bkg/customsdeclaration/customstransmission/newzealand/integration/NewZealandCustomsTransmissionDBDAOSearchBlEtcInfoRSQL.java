/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewZealandCustomsTransmissionDBDAOSearchBlEtcInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewZealandCustomsTransmissionDBDAOSearchBlEtcInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NewZealandCustomsTransmissionDBDAOSearchBlEtcInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration").append("\n"); 
		query.append("FileName : NewZealandCustomsTransmissionDBDAOSearchBlEtcInfoRSQL").append("\n"); 
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
		query.append("SELECT 'F' AS FP_IND," ).append("\n"); 
		query.append("       (SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("         WHERE CNTR.BKG_NO = DOC.BKG_NO) AS TOT_CNTR," ).append("\n"); 
		query.append("       DOC.PCK_QTY AS TOT_PKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_BL_DOC DOC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE DOC.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}