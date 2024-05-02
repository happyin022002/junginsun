/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : USARailWoAckManageDBDAOAddManageUSARail417WoAckUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.usarailwoack.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USARailWoAckManageDBDAOAddManageUSARail417WoAckUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddManageUSARail417WoAck
	  * </pre>
	  */
	public USARailWoAckManageDBDAOAddManageUSARail417WoAckUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnru_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.usarailwoack.integration").append("\n"); 
		query.append("FileName : USARailWoAckManageDBDAOAddManageUSARail417WoAckUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_EDI_RAIL_ORD T" ).append("\n"); 
		query.append("	 SET T.RAIL_CRR_REF_NO = @[cnru_no]" ).append("\n"); 
		query.append("        ,T.UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE (T.TRSP_SO_OFC_CTY_CD, T.TRSP_SO_SEQ) = (SELECT TRSP_SO_OFC_CTY_CD ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("													FROM TRS_TRSP_RAIL_BIL_ORD O" ).append("\n"); 
		query.append("												WHERE O.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("												  AND O.EQ_NO LIKE (CASE WHEN LENGTH(@[cntr_no]) >= 10 THEN SUBSTR(@[cntr_no], 1, 10) ELSE '-'  END) || '%')" ).append("\n"); 

	}
}