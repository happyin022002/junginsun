/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : USARailWoAckManageDBDAOUpdateInbondNoUSARail417WoAckUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
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

public class USARailWoAckManageDBDAOUpdateInbondNoUSARail417WoAckUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateInbondNoUSARail417WoAck
	  * </pre>
	  */
	public USARailWoAckManageDBDAOUpdateInbondNoUSARail417WoAckUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inbond_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : USARailWoAckManageDBDAOUpdateInbondNoUSARail417WoAckUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_ORD T" ).append("\n"); 
		query.append("   SET T.IBD_NO          = @[inbond_no]," ).append("\n"); 
		query.append("       T.RAIL_CRR_REF_NO = @[cnru_no]," ).append("\n"); 
		query.append("       T.UPD_DT          = SYSDATE," ).append("\n"); 
		query.append("       T.UPD_USR_ID      = 'EDIUSER'" ).append("\n"); 
		query.append(" WHERE (T.TRSP_SO_OFC_CTY_CD, T.TRSP_SO_SEQ) IN" ).append("\n"); 
		query.append("       (SELECT TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ" ).append("\n"); 
		query.append("          FROM TRS_TRSP_RAIL_BIL_ORD O" ).append("\n"); 
		query.append("         WHERE O.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("           AND O.EQ_NO LIKE (CASE WHEN LENGTH(@[cntr_no]) >= 10 THEN SUBSTR(@[cntr_no], 1, 10) ELSE '-' END) || '%'" ).append("\n"); 
		query.append("		   AND O.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}