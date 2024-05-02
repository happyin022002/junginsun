/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WORejectManageDBDAOmultiRejectWOListWoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.05 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.worejectmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WORejectManageDBDAOmultiRejectWOListWoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiRejectWOList
	  * </pre>
	  */
	public WORejectManageDBDAOmultiRejectWOListWoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_WO_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_WO_OFC_CTY_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.worejectmanage.integration").append("\n"); 
		query.append("FileName : WORejectManageDBDAOmultiRejectWOListWoUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_WRK_ORD SET" ).append("\n"); 
		query.append("UPD_USR_ID  		= 'SPP_IF'," ).append("\n"); 
		query.append("UPD_DT     			=  GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[OFC_CD])," ).append("\n"); 
		query.append("WO_ISS_STS_CD =" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN  0 <  (" ).append("\n"); 
		query.append("SELECT COUNT(TRSP_SO_OFC_CTY_CD || TRSP_SO_SEQ)  FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE  TRSP_WO_OFC_CTY_CD = @[TRSP_WO_OFC_CTY_CD]" ).append("\n"); 
		query.append("AND    TRSP_WO_SEQ = @[TRSP_WO_SEQ]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("THEN 'P'" ).append("\n"); 
		query.append("ELSE 'J'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHERE  TRSP_WO_OFC_CTY_CD = @[TRSP_WO_OFC_CTY_CD]" ).append("\n"); 
		query.append("AND    TRSP_WO_SEQ = @[TRSP_WO_SEQ]" ).append("\n"); 

	}
}