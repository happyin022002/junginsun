/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewZealandCustomsTransmissionDBDAOSearchDescInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
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

public class NewZealandCustomsTransmissionDBDAOSearchDescInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NewZealandCustomsTransmissionDBDAOSearchDescInfoRSQL(){
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
		query.append("FileName : NewZealandCustomsTransmissionDBDAOSearchDescInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG_SPCLCHAR_CONV_FNC(SUBSTR(DOC.PCK_CMDT_DESC||DOC.CNTR_CMDT_DESC||MK.CMDT_DESC, 1, 279), 'Y') AS DESCRIPTION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_BL_MK_DESC MK," ).append("\n"); 
		query.append("       BKG_BL_DOC DOC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND MK.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("   AND DOC.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}