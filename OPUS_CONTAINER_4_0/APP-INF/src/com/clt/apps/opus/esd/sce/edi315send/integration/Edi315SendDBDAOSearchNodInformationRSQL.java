/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi315SendDBDAOSearchNodInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 김인규
*@LastVersion : 1.0
* 2015.01.02 김인규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author In Gyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchNodInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for search_nod_information
	  * </pre>
	  */
	public Edi315SendDBDAOSearchNodInformationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_event_yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchNodInformationRSQL").append("\n"); 
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
		query.append("SELECT    LOC_NM event_loc_name, " ).append("\n"); 
		query.append("               DECODE(CNT_CD, 'US', 'D', 'K') event_loc_amsqual, " ).append("\n"); 
		query.append("               LOC_AMS_PORT_CD event_loc_amsport, " ).append("\n"); 
		query.append("               RGN_CD reg_cd," ).append("\n"); 
		query.append("               LOC_NM, CNT_CD, STE_CD " ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("        WHERE LOC_CD = substr(@[e_event_yard], 1, 5)" ).append("\n"); 

	}
}