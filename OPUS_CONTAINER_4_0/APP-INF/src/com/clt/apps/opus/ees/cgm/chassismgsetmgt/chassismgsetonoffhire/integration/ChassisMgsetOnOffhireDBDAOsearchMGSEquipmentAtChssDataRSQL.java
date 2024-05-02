/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchMGSEquipmentAtChssDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.10.06 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Shung, Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchMGSEquipmentAtChssDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091006 MGSET에 ATTACH된 CHSS를 찾는다.
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchMGSEquipmentAtChssDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration ").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchMGSEquipmentAtChssDataRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(A XPKCGM_EQ_ATCH_DTCH_HIS ) */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CHSS_NO AS EQ_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND DTCH_YD_CD IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 

	}
}