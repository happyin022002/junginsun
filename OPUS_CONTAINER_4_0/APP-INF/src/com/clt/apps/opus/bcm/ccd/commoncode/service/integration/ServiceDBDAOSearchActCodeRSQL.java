/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ServiceDBDAOSearchActCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAOSearchActCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACTIVITY CODE의 상세 내용 조회
	  * </pre>
	  */
	public ServiceDBDAOSearchActCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAOSearchActCodeRSQL").append("\n"); 
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
		query.append("SELECT ACT_NM" ).append("\n"); 
		query.append("      ,ACT_DESC" ).append("\n"); 
		query.append("      ,ACT_TP_CD" ).append("\n"); 
		query.append("      ,FULL_MTY_CD" ).append("\n"); 
		query.append("      ,BND_VSKD_SEQ_CD" ).append("\n"); 
		query.append("      ,NOD_TP_CD" ).append("\n"); 
		query.append("      ,ACT_OP_TP_CD" ).append("\n"); 
		query.append("      ,TRSP_MOD_CD" ).append("\n"); 
		query.append("      ,ORG_DEST_CD" ).append("\n"); 
		query.append("      ,ACT_FLG" ).append("\n"); 
		query.append("      ,ACT_STND_EDI_STS_CD" ).append("\n"); 
		query.append("      ,COP_SKD_LGC_NO" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("  FROM MDM_ACTIVITY" ).append("\n"); 
		query.append(" WHERE ACT_CD = @[act_cd]" ).append("\n"); 

	}
}