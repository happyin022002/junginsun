/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCstmsPortTmlCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.22 
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

public class UsaCustomsTransmissionDBDAOsearchCstmsPortTmlCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaCustomsTransmissionDBDAOsearchCstmsPortTmlCdRSQL
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCstmsPortTmlCdRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCstmsPortTmlCdRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	( SELECT ATTR_CTNT2 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("	  WHERE CNT_CD='US'" ).append("\n"); 
		query.append("	  AND CSTMS_DIV_ID='AMS_TML_CD_MAP'" ).append("\n"); 
		query.append("	  AND ATTR_CTNT1= YD_CD" ).append("\n"); 
		query.append("	  AND ROWNUM=1" ).append("\n"); 
		query.append("	) AMS_TML_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("    #if (${pre_pod_cd} == 'US')" ).append("\n"); 
		query.append("        SELECT YD_CD" ).append("\n"); 
		query.append("              ,ROW_NUMBER() OVER(ORDER BY CLPT_SEQ) AS RNUM" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE 1=1 " ).append("\n"); 
		query.append("           AND VPS_PORT_CD   LIKE 'US%'" ).append("\n"); 
		query.append("           AND VSL_CD        = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND SKD_VOY_NO    = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND SKD_DIR_CD    = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("		   AND VPS_PORT_cD =  @[pod_cd]" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("	    #if (${pre_pol_cd} == 'CA')" ).append("\n"); 
		query.append("	        SELECT S.YD_CD" ).append("\n"); 
		query.append("	              ,ROW_NUMBER() OVER(ORDER BY S.CLPT_SEQ) AS RNUM" ).append("\n"); 
		query.append("	          FROM (" ).append("\n"); 
		query.append("	               SELECT CLPT_SEQ" ).append("\n"); 
		query.append("	                 FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("	                WHERE 1=1" ).append("\n"); 
		query.append("	                  AND VSL_CD        = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("	                  AND SKD_VOY_NO    = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("	                  AND SKD_DIR_CD    = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("	                  AND VPS_PORT_CD   = @[pol_cd]" ).append("\n"); 
		query.append("	                  AND CLPT_IND_SEQ  = '1'" ).append("\n"); 
		query.append("	               ) P" ).append("\n"); 
		query.append("	              ,VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("	         WHERE 1=1" ).append("\n"); 
		query.append("	           AND S.VSL_CD        = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("	           AND S.SKD_VOY_NO    = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("	           AND S.SKD_DIR_CD    = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("	           AND S.VPS_PORT_CD   LIKE 'US%'" ).append("\n"); 
		query.append("	           AND S.CLPT_SEQ > P.CLPT_SEQ" ).append("\n"); 
		query.append("	    #else " ).append("\n"); 
		query.append("	        SELECT YD_CD" ).append("\n"); 
		query.append("	              ,ROW_NUMBER() OVER(ORDER BY CLPT_SEQ) AS RNUM" ).append("\n"); 
		query.append("	          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("	         WHERE 1=1" ).append("\n"); 
		query.append("	           AND VPS_PORT_CD   LIKE 'US%'" ).append("\n"); 
		query.append("	           AND VSL_CD        = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("	           AND SKD_VOY_NO    = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("	           AND SKD_DIR_CD    = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RNUM = 1" ).append("\n"); 

	}
}