/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Edi324SendDBDAOSearchEdi324EdiMaxSndIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.05
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.03.05 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi324send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi324SendDBDAOSearchEdi324EdiMaxSndIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이미 생성된 EDI_SND_ID의 count의 +1 한 값을 구해온다.
	  * </pre>
	  */
	public Edi324SendDBDAOSearchEdi324EdiMaxSndIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_current_day",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi324send.integration").append("\n"); 
		query.append("FileName : Edi324SendDBDAOSearchEdi324EdiMaxSndIdRSQL").append("\n"); 
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
		query.append("SELECT MAX(SUBSTR(EDI_SND_ID ,10,12))+1 MAXSNDID FROM  SCE_EDI_324_SND_RSLT" ).append("\n"); 
		query.append("WHERE EDI_SND_ID LIKE '%'||@[edi_current_day]||'%'" ).append("\n"); 

	}
}