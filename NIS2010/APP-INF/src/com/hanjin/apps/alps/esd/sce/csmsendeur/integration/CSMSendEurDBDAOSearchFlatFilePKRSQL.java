/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSMSendEurDBDAOSearchFlatFilePKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.csmsendeur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendEurDBDAOSearchFlatFilePKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFlatFilePK
	  * </pre>
	  */
	public CSMSendEurDBDAOSearchFlatFilePKRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.csmsendeur.integration").append("\n"); 
		query.append("FileName : CSMSendEurDBDAOSearchFlatFilePKRSQL").append("\n"); 
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
		query.append("	   SCE_CSM_FLT_FILE_EUR_SEQ1.NEXTVAL AS EDI_SND_SEQ, " ).append("\n"); 
		query.append("	   STND_EDI_STS_CD, " ).append("\n"); 
		query.append("	   TGT.ACT_STS_MAPG_CD, " ).append("\n"); 
		query.append("	   'CSM'||SUBSTR(TO_CHAR(SYSDATE, 'YYMMDD'), 2, 5)||LPAD(TO_CHAR(SCE_CSM_FLT_FILE_EUR_SEQ1.CURRVAL), 6, '0') AS FLT_FILE_REF_NO " ).append("\n"); 
		query.append("  FROM SCE_CSM_TGT_EUR TGT, " ).append("\n"); 
		query.append("	   SCE_CNTR_STS_MSG_MVMT_MAPG MAPG " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("       AND TGT.ACT_STS_MAPG_CD = MAPG.ACT_STS_MAPG_CD " ).append("\n"); 
		query.append("       AND TGT.CSM_CNT_CD = MAPG.CSM_CNT_CD -- MAPG 테이블에 CSM_CNT_CD 컬럼 추가 - 국가별 등록 MAPPING 코드 전체 추가" ).append("\n"); 
		query.append("	   AND TGT.ACT_RCV_DT = @[act_rcv_dt]" ).append("\n"); 
		query.append("	   AND TGT.ACT_RCV_NO = @[act_rcv_no] " ).append("\n"); 
		query.append("	   AND NVL(MAPG.DELT_FLG, 'N') = 'N'" ).append("\n"); 

	}
}