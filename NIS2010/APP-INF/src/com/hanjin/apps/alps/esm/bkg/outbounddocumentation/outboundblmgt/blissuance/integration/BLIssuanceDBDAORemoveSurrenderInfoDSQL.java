/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAORemoveSurrenderInfoDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.31 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAORemoveSurrenderInfoDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveSurrenderInfo
	  * </pre>
	  */
	public BLIssuanceDBDAORemoveSurrenderInfoDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAORemoveSurrenderInfoDSQL").append("\n"); 
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
		query.append("UPDATE" ).append("\n"); 
		query.append("BKG_BL_ISS" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("OBL_RDEM_OFC_CD =  NULL" ).append("\n"); 
		query.append(",OBL_RDEM_DT =  NULL" ).append("\n"); 
		query.append(",OBL_RDEM_KNT = 0" ).append("\n"); 
		query.append(",OBL_RDEM_USR_ID =  NULL" ).append("\n"); 
		query.append(",DIFF_RMK =  NULL" ).append("\n"); 
		query.append(",OBL_SRND_FLG = 'N'" ).append("\n"); 
		query.append(",OBL_ISS_KNT =  0" ).append("\n"); 
		query.append(",OBL_RLSE_FLG = 'N'" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO =@[bkg_no]" ).append("\n"); 

	}
}