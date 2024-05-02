/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StandardWordingDBDAOPriScStndWdgVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.13 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.standardwording.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class StandardWordingDBDAOPriScStndWdgVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Delete
	  * </pre>
	  */
	public StandardWordingDBDAOPriScStndWdgVODSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "2,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_wdg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM pri_sc_stnd_wdg" ).append("\n"); 
		query.append("WHERE	stnd_wdg_seq = @[stnd_wdg_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.standardwording.integration ").append("\n"); 
		query.append("FileName : StandardWordingDBDAOPriScStndWdgVODSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}