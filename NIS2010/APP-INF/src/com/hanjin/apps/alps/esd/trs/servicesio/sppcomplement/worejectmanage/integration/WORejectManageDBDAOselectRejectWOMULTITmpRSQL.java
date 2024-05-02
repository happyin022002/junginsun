/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WORejectManageDBDAOselectRejectWOMULTITmpRSQL.java
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

public class WORejectManageDBDAOselectRejectWOMULTITmpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * selectRejectWOMULTITmp
	  * </pre>
	  */
	public WORejectManageDBDAOselectRejectWOMULTITmpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WO_PRV_GRP_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WO_ISS_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.worejectmanage.integration").append("\n"); 
		query.append("FileName : WORejectManageDBDAOselectRejectWOMULTITmpRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT 'MULTI01' as f_cmd," ).append("\n"); 
		query.append("WO_PRV_GRP_SEQ," ).append("\n"); 
		query.append("DECODE(WO_FMT_TP_CD,'NC','WO_NORMAL','CC','WO_COMBINED1','IB','WO_COMBINED2_1','CY','WO_COMBINED2_2','CM','WO_COMBINED2_3','MM','WO_EMPTY')||'.mrd'  AS FAX_APP_CD," ).append("\n"); 
		query.append("WO_ISS_NO," ).append("\n"); 
		query.append("'' AS FAX_PARAM," ).append("\n"); 
		query.append("VNDR_LGL_ENG_NM AS FAX_RCV_INFO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD_PRV_TMP WO," ).append("\n"); 
		query.append("MDM_VENDOR VD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("WO.VNDR_SEQ = VD.VNDR_SEQ" ).append("\n"); 
		query.append("AND WO_PRV_GRP_SEQ = @[WO_PRV_GRP_SEQ]" ).append("\n"); 
		query.append("AND WO_ISS_NO = @[WO_ISS_NO]" ).append("\n"); 

	}
}