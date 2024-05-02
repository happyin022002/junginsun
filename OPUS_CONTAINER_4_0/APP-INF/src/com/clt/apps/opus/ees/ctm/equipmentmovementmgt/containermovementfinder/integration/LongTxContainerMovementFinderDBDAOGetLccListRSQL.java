/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongTxContainerMovementFinderDBDAOGetLccListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.09.01 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongTxContainerMovementFinderDBDAOGetLccListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LongTxContainerMovementFinderDBDAO.java
	  * </pre>
	  */
	public LongTxContainerMovementFinderDBDAOGetLccListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.longtxcontainermovementfinder.integration").append("\n"); 
		query.append("FileName : LongTxContainerMovementFinderDBDAOGetLccListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT LCC_CD FROM MDM_LOCATION LOC, MDM_EQ_ORZ_CHT EQ" ).append("\n"); 
		query.append("WHERE  RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("AND    LOC.SCC_CD = EQ.SCC_CD" ).append("\n"); 
		query.append("ORDER  BY LCC_CD" ).append("\n"); 

	}
}