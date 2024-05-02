/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AncsCustomsTransmissionDBDAOsearchDupSsrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.18
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.10.18 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsCustomsTransmissionDBDAOsearchDupSsrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT
	  * </pre>
	  */
	public AncsCustomsTransmissionDBDAOsearchDupSsrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation").append("\n"); 
		query.append("FileName : AncsCustomsTransmissionDBDAOsearchDupSsrNoRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN (SELECT COUNT(*) " ).append("\n"); 
		query.append("                 FROM BKG_CSTMS_ANR_VVD" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                 AND SVC_RQST_NO = (SELECT SVC_RQST_NO FROM BKG_CSTMS_ANR_VVD WHERE 1=1 AND VSL_CD = SUBSTR(@[vvd],1,4) AND SKD_VOY_NO = SUBSTR(@[vvd],5,4) AND SKD_DIR_CD = SUBSTR(@[vvd],9,1))" ).append("\n"); 
		query.append("                 AND LLOYD_NO = (SELECT LLOYD_NO FROM BKG_CSTMS_ANR_VVD WHERE 1=1 AND VSL_CD = SUBSTR(@[vvd],1,4) AND SKD_VOY_NO = SUBSTR(@[vvd],5,4) AND SKD_DIR_CD = SUBSTR(@[vvd],9,1))" ).append("\n"); 
		query.append("				 AND VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                 ) > 1 THEN 'Y'||B.KNT_VVD_SEQ" ).append("\n"); 
		query.append("                 ELSE 'N' " ).append("\n"); 
		query.append("                 END AS KNT_SSR" ).append("\n"); 
		query.append("FROM DUAL, (SELECT DECODE(COUNT(VVD_SEQ),0,'Y','N') AS KNT_VVD_SEQ" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_ANR_BL" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("			AND VSL_CD = SUBSTR(@[vvd],1,4) AND SKD_VOY_NO = SUBSTR(@[vvd],5,4) AND SKD_DIR_CD = SUBSTR(@[vvd],9,1)) B" ).append("\n"); 

	}
}