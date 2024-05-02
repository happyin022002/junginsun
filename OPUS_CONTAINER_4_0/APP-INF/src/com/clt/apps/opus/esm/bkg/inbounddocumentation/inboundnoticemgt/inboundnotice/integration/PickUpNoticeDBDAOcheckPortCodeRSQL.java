/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PickUpNoticeDBDAOcheckPortCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.03.07 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang HO Chae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOcheckPortCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port Location 코드에 대한 유효성 여부를 체크한다
	  * </pre>
	  */
	public PickUpNoticeDBDAOcheckPortCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOcheckPortCodeRSQL").append("\n"); 
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
		query.append("SELECT '1'" ).append("\n"); 
		query.append("FROM	MDM_LOCATION" ).append("\n"); 
		query.append("WHERE	LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND	PORT_INLND_FLG='Y'" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 

	}
}