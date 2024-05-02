/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WORejectManageDBDAOmultiRejectWOListRejectUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.05 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.worejectmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WORejectManageDBDAOmultiRejectWOListRejectUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiRejectWOList
	  * </pre>
	  */
	public WORejectManageDBDAOmultiRejectWOListRejectUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_SEQ",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("TRSP_SO_OFC_CTY_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.sppcomplement.worejectmanage.integration").append("\n"); 
		query.append("FileName : WORejectManageDBDAOmultiRejectWOListRejectUSQL").append("\n"); 
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
		query.append("UPDATE  TRS_TRSP_SVC_ORD SET" ).append("\n"); 
		query.append("WO_RJCT_FLG			= 'Y'," ).append("\n"); 
		query.append("UPD_USR_ID  		= 'SPP_IF'," ).append("\n"); 
		query.append("UPD_DT     			=  GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[OFC_CD])" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND 	TRSP_SO_OFC_CTY_CD  = @[TRSP_SO_OFC_CTY_CD]" ).append("\n"); 
		query.append("AND 	TRSP_SO_SEQ			= @[TRSP_SO_SEQ]" ).append("\n"); 

	}
}