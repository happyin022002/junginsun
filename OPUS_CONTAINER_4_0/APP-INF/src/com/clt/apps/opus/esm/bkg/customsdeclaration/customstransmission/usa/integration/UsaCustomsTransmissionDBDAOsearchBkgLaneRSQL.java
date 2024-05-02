/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchBkgLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.06.19 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchBkgLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchBkgLaneRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN NVL(@[msg_tp], ' ') = 'OFM' THEN" ).append("\n"); 
		query.append("(SELECT	SLAN_CD" ).append("\n"); 
		query.append("FROM	BKG_BOOKING" ).append("\n"); 
		query.append("WHERE	VSL_CD		= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND	SKD_VOY_NO	= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND	SKD_DIR_CD	= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND	POD_CD		= @[pod]" ).append("\n"); 
		query.append("AND	SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("AND	ROWNUM		= 1)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(SELECT	CASE WHEN INSTR(SLAN_CD, 'MP') = 1 THEN" ).append("\n"); 
		query.append("'USLAX'" ).append("\n"); 
		query.append("WHEN INSTR(SLAN_CD, 'KPN') = 1 OR INSTR(SLAN_CD, 'YPN') = 1 THEN" ).append("\n"); 
		query.append("'USTIW'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'USSEA'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM	BKG_BOOKING" ).append("\n"); 
		query.append("WHERE	VSL_CD		= SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND	SKD_VOY_NO	= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND	SKD_DIR_CD	= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND	POD_CD		= @[pod]" ).append("\n"); 
		query.append("AND	SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("AND	ROWNUM		= 1)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchBkgLaneRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}