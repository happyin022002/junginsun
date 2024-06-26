/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SceAdminManageDBDAOSearchTmlChgRsltRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.01.04 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SceAdminManageDBDAOSearchTmlChgRsltRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * terminal change 결과를 조회한다.
	  * </pre>
	  */
	public SceAdminManageDBDAOSearchTmlChgRsltRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration").append("\n"); 
		query.append("FileName : SceAdminManageDBDAOSearchTmlChgRsltRSQL").append("\n"); 
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
		query.append("SELECT 	A.ACT_RCV_DT, " ).append("\n"); 
		query.append("		A.ACT_RCV_NO, " ).append("\n"); 
		query.append("		A.VSL_CD," ).append("\n"); 
		query.append("		A.SKD_VOY_NO," ).append("\n"); 
		query.append("		A.SKD_DIR_CD," ).append("\n"); 
		query.append("		A.VPS_PORT_CD," ).append("\n"); 
		query.append("		A.CLPT_IND_SEQ," ).append("\n"); 
		query.append("		A.NOD_CD," ).append("\n"); 
		query.append("		B.COP_NO, " ).append("\n"); 
		query.append("		C.BKG_NO," ).append("\n"); 
		query.append("		C.CNTR_NO," ).append("\n"); 
		query.append("		B.TML_IF_DTL_STS_CD, " ).append("\n"); 
		query.append("		B.ERR_MSG, " ).append("\n"); 
		query.append("		B.CRE_USR_ID, " ).append("\n"); 
		query.append("		TO_CHAR(B.CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT, " ).append("\n"); 
		query.append("		B.UPD_USR_ID, " ).append("\n"); 
		query.append("		TO_CHAR(B.UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	    SCE_ACT_TML_IF A," ).append("\n"); 
		query.append("		SCE_ACT_TML_IF_DTL B," ).append("\n"); 
		query.append("		SCE_COP_HDR C" ).append("\n"); 
		query.append("	WHERE" ).append("\n"); 
		query.append("	    A.ACT_RCV_DT = B.ACT_RCV_DT" ).append("\n"); 
		query.append("	    AND A.ACT_RCV_NO = B.ACT_RCV_NO" ).append("\n"); 
		query.append("		AND B.COP_NO = C.COP_NO" ).append("\n"); 
		query.append("	    AND A.ACT_RCV_DT BETWEEN @[tml_fm_dt] AND @[tml_to_dt]" ).append("\n"); 

	}
}