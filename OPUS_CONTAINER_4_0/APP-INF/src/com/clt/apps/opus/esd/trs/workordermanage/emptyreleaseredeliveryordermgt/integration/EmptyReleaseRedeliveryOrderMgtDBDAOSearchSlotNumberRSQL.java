/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchSlotNumberRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchSlotNumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyReleaseRedeliveryOrderMgtDBDAOSearchSlotNumber
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchSlotNumberRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slot_cnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchSlotNumberRSQL").append("\n"); 
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
		query.append("WITH V AS" ).append("\n"); 
		query.append(" (select rownum r" ).append("\n"); 
		query.append("        ,V1.ABC || V2.ABC ABC" ).append("\n"); 
		query.append("    from (SELECT chr(ASCII('A') + LEVEL - 1) ABC FROM DUAL connect by level <= 26) V1" ).append("\n"); 
		query.append("        ,(SELECT chr(ASCII('A') + LEVEL - 1) ABC FROM DUAL connect by level <= 26) V2)" ).append("\n"); 
		query.append("SELECT SUBSTR(@[wo_no], -5) || V.ABC AS SLOT_NUM FROM V WHERE R = @[slot_cnt]" ).append("\n"); 

	}
}