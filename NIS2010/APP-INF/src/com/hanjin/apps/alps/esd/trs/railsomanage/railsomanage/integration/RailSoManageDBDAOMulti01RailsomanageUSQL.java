/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailSoManageDBDAOMulti01RailsomanageUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.09.07 최진오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JIN O CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOMulti01RailsomanageUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multi01Railsomanage UPDATE
	  * </pre>
	  */
	public RailSoManageDBDAOMulti01RailsomanageUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_rqst_rjct_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("suer_ctl_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soffice_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOMulti01RailsomanageUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("SET    CXL_RQST_RJCT_RSN = @[cxl_rqst_rjct_rsn]," ).append("\n"); 
		query.append("CXL_RQST_RJCT_FLG = 'Y'," ).append("\n"); 
		query.append("CXL_RQST_FLG      = 'N'," ).append("\n"); 
		query.append("CXL_RQST_RJCT_DT  = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[soffice_cd])," ).append("\n"); 
		query.append("UPD_DT            = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[soffice_cd])," ).append("\n"); 
		query.append("UPD_USR_ID        = @[suer_ctl_id]" ).append("\n"); 
		query.append("WHERE  TRSP_SO_OFC_CTY_CD= @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND    TRSP_SO_SEQ       = @[trsp_so_seq]" ).append("\n"); 

	}
}