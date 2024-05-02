/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOEdi315PrefixMainCOPInfoPodDtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.18 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOEdi315PrefixMainCOPInfoPodDtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi315PrefixMainCOPInfoPodDtVO
	  * </pre>
	  */
	public Edi315SendDBDAOEdi315PrefixMainCOPInfoPodDtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration ").append("\n"); 
		query.append("FileName : Edi315SendDBDAOEdi315PrefixMainCOPInfoPodDtVORSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("''POD_ETA" ).append("\n"); 
		query.append(",''POD_ETA_GMT" ).append("\n"); 
		query.append(",''POD_ATA" ).append("\n"); 
		query.append(",''POD_ATA_GMT" ).append("\n"); 
		query.append(",''POD_ETD" ).append("\n"); 
		query.append(",''POD_ETD_GMT" ).append("\n"); 
		query.append(",''POD_ATD" ).append("\n"); 
		query.append(",''POD_ATD_GMT" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}