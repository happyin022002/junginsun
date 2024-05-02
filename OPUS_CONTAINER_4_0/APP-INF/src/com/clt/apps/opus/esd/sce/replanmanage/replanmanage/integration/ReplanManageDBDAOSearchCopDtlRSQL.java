/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReplanManageDBDAOSearchCopDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.11.30 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchCopDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COP Detail 정보를 cop 단위로 조회한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchCopDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchCopDtlRSQL").append("\n"); 
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
		query.append("SELECT 	COP_NO," ).append("\n"); 
		query.append("COP_DTL_SEQ," ).append("\n"); 
		query.append("ACT_CD," ).append("\n"); 
		query.append("TO_CHAR(PLN_DT, 'YYYYMMDDHH24MISS') AS PLN_DT," ).append("\n"); 
		query.append("TO_CHAR(ESTM_DT, 'YYYYMMDDHH24MISS') AS ESTM_DT," ).append("\n"); 
		query.append("TO_CHAR(ACT_DT, 'YYYYMMDDHH24MISS') AS ACT_DT," ).append("\n"); 
		query.append("NOD_CD," ).append("\n"); 
		query.append("ACT_STS_CD," ).append("\n"); 
		query.append("ACT_RCV_TP_CD," ).append("\n"); 
		query.append("EDI_SND_TP_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("CLPT_IND_SEQ," ).append("\n"); 
		query.append("VPS_PORT_CD," ).append("\n"); 
		query.append("TO_CHAR(ESTM_GDT, 'YYYYMMDDHH24MISS') AS ESTM_GDT," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("EDI_MSG_TP_CD," ).append("\n"); 
		query.append("ACT_STS_MAPG_CD," ).append("\n"); 
		query.append("STND_EDI_STS_CD," ).append("\n"); 
		query.append("TO_CHAR(EDI_ACT_SND_DT, 'YYYYMMDDHH24MISS') AS EDI_ACT_SND_DT," ).append("\n"); 
		query.append("TO_CHAR(ACT_DAT_RCV_DT, 'YYYYMMDDHH24MISS') AS ACT_DAT_RCV_DT," ).append("\n"); 
		query.append("COP_EXPT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(CRE_DT, 'YYYYMMDDHH24MISS') AS CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("FROM SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("COP_NO = @[cop_no]" ).append("\n"); 

	}
}