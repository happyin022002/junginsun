/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WORejectManageDBDAOselectRejectWOSoDataRSQL.java
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

public class WORejectManageDBDAOselectRejectWOSoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * selectRejectWOSoData
	  * </pre>
	  */
	public WORejectManageDBDAOselectRejectWOSoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : WORejectManageDBDAOselectRejectWOSoDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'R'	AS ibflag," ).append("\n"); 
		query.append("trsp_so_ofc_cty_cd," ).append("\n"); 
		query.append("trsp_so_seq," ).append("\n"); 
		query.append("NVL(WO_RJCT_FLG,'N') AS wo_cxl_flg," ).append("\n"); 
		query.append("dtn_use_flg," ).append("\n"); 
		query.append("wo_bl_no_iss_flg," ).append("\n"); 
		query.append("vndr_seq," ).append("\n"); 
		query.append("curr_cd," ).append("\n"); 
		query.append("bzc_amt," ).append("\n"); 
		query.append("nego_amt," ).append("\n"); 
		query.append("etc_add_amt," ).append("\n"); 
		query.append("fuel_scg_amt," ).append("\n"); 
		query.append("ovr_wgt_scg_amt," ).append("\n"); 
		query.append("n3pty_bil_flg" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE   TRSP_WO_OFC_CTY_CD = @[TRSP_WO_OFC_CTY_CD]" ).append("\n"); 
		query.append("AND		TRSP_WO_SEQ = @[TRSP_WO_SEQ]" ).append("\n"); 
		query.append("AND		DELT_FLG = 'N'" ).append("\n"); 

	}
}