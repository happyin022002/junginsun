/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSMSendDBDAOSearchFlatFilePKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.csmsend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendDBDAOSearchFlatFilePKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFlatFilePK
	  * </pre>
	  */
	public CSMSendDBDAOSearchFlatFilePKRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.csmsend.integration").append("\n"); 
		query.append("FileName : CSMSendDBDAOSearchFlatFilePKRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SYSDATE, 'YYMMDD') AS EDI_SND_YRMONDY, " ).append("\n"); 
		query.append("		SCE_CNTR_STS_MSG_FLT_FILE_SEQ1.NEXTVAL AS EDI_SND_SEQ, " ).append("\n"); 
		query.append("		  STND_EDI_STS_CD, " ).append("\n"); 
		query.append("		  TGT.ACT_STS_MAPG_CD, " ).append("\n"); 
		query.append("		  'CSM'||SUBSTR(TO_CHAR(SYSDATE, 'YYMMDD'), 2, 5)||LPAD(TO_CHAR(SCE_CNTR_STS_MSG_FLT_FILE_SEQ1.CURRVAL), 6, '0') AS FLT_FILE_REF_NO " ).append("\n"); 
		query.append("		FROM SCE_CNTR_STS_MSG_TGT TGT, " ).append("\n"); 
		query.append("		  SCE_CNTR_STS_MSG_MVMT_MAPG MAPG " ).append("\n"); 
		query.append("		WHERE TGT.ACT_STS_MAPG_CD = MAPG.ACT_STS_MAPG_CD " ).append("\n"); 
		query.append("		  AND TGT.ACT_RCV_DT = @[act_rcv_dt]" ).append("\n"); 
		query.append("		  AND TGT.ACT_RCV_NO = @[act_rcv_no]" ).append("\n"); 
		query.append("		  AND MAPG.CSM_CNT_CD = 'US' " ).append("\n"); 
		query.append("		  AND NVL(MAPG.DELT_FLG, 'N') = 'N'" ).append("\n"); 

	}
}