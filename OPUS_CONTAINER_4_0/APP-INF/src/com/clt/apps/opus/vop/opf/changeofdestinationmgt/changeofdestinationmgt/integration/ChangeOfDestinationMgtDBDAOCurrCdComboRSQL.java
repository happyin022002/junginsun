/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOCurrCdComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOCurrCdComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOCurrCdComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rhnd_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOCurrCdComboRSQL").append("\n"); 
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
		query.append("SELECT 	A.CURR_CD" ).append("\n"); 
		query.append("FROM 	( 	" ).append("\n"); 
		query.append("			--SELECT 	C.CURR_CD" ).append("\n"); 
		query.append("       		--FROM   	MDM_LOCATION 	L" ).append("\n"); 
		query.append("			--	, 	MDM_CURRENCY 	C" ).append("\n"); 
		query.append("       		--WHERE  	L.LOC_CD 		= [cod_rhnd_port_cd]" ).append("\n"); 
		query.append("       		--AND    	L.CNT_CD 		= C.CNT_CD" ).append("\n"); 
		query.append("       		" ).append("\n"); 
		query.append("			SELECT 	MC.CURR_CD " ).append("\n"); 
		query.append("			FROM 	MDM_COUNTRY 	MC " ).append("\n"); 
		query.append("			WHERE 	MC.CNT_CD 		= SUBSTR(@[cod_rhnd_port_cd],1,2)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("			SELECT 'USD' CURR_CD FROM DUAL" ).append("\n"); 
		query.append("     ) A" ).append("\n"); 
		query.append("GROUP BY A.CURR_CD" ).append("\n"); 

	}
}