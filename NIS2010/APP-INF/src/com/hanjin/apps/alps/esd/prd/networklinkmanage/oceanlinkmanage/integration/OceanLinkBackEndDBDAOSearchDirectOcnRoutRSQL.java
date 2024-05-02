/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OceanLinkBackEndDBDAOSearchDirectOcnRoutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.03
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.08.03 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkBackEndDBDAOSearchDirectOcnRoutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정 Ocean Route를 조회한다. (direct에 대해서만)
	  * </pre>
	  */
	public OceanLinkBackEndDBDAOSearchDirectOcnRoutRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration ").append("\n"); 
		query.append("FileName : OceanLinkBackEndDBDAOSearchDirectOcnRoutRSQL").append("\n"); 
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
		query.append("select ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ from prd_ocn_rout  " ).append("\n"); 
		query.append("where ORG_LOC_CD = @[org]  " ).append("\n"); 
		query.append("and DEST_LOC_CD = @[dest]" ).append("\n"); 
		query.append("and N1ST_LANE_CD = @[seq]" ).append("\n"); 
		query.append("AND TS_IND_CD = 'D'" ).append("\n"); 

	}
}