/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReplanManageDBDAOSearchActualToBeUpdatedTmpVSKUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.26
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.07.26 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchActualToBeUpdatedTmpVSKUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임시처리를 위해 vsk 정보를 가져오는 부분 조회
	  * </pre>
	  */
	public ReplanManageDBDAOSearchActualToBeUpdatedTmpVSKUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchActualToBeUpdatedTmpVSKUSQL").append("\n"); 
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
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("ACT_DT," ).append("\n"); 
		query.append("ACT_STS_MAPG_CD," ).append("\n"); 
		query.append("COP_DTL_SEQ," ).append("\n"); 
		query.append("NOD_CD," ).append("\n"); 
		query.append("ACT_RCV_TP_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("VPS_PORT_CD," ).append("\n"); 
		query.append("EDI_SND_RSLT_FLG," ).append("\n"); 
		query.append("USR_ID," ).append("\n"); 
		query.append("ACT_UMCH_TP_CD," ).append("\n"); 
		query.append("CLPT_IND_SEQ," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("EDI_MSG_TP_CD," ).append("\n"); 
		query.append("ACT_DAT_RCV_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT --DECODE(MIN(SRC),'0','VVD','1','ORG','2','SPL','3','CMB','4','LCL') SCR," ).append("\n"); 
		query.append("MAX(BKG_NO)BKG_NO," ).append("\n"); 
		query.append("ACT_RCV_DT," ).append("\n"); 
		query.append("ACT_RCV_NO ," ).append("\n"); 
		query.append("MAX(CNTR_NO)CNTR_NO," ).append("\n"); 
		query.append("MAX(COP_NO)COP_NO," ).append("\n"); 
		query.append("MAX(ACT_DT)ACT_DT," ).append("\n"); 
		query.append("MAX(ACT_STS_MAPG_CD)ACT_STS_MAPG_CD ," ).append("\n"); 
		query.append("MAX(COP_DTL_SEQ) COP_DTL_SEQ ," ).append("\n"); 
		query.append("MAX(NOD_CD)NOD_CD," ).append("\n"); 
		query.append("MAX(ACT_RCV_TP_CD)ACT_RCV_TP_CD ," ).append("\n"); 
		query.append("MAX(VSL_CD)VSL_CD," ).append("\n"); 
		query.append("MAX(SKD_VOY_NO)SKD_VOY_NO," ).append("\n"); 
		query.append("MAX(SKD_DIR_CD)SKD_DIR_CD," ).append("\n"); 
		query.append("MAX(VPS_PORT_CD)VPS_PORT_CD ," ).append("\n"); 
		query.append("MAX(EDI_SND_RSLT_FLG)EDI_SND_RSLT_FLG," ).append("\n"); 
		query.append("MAX(USR_ID)USR_ID," ).append("\n"); 
		query.append("MAX(ACT_UMCH_TP_CD)ACT_UMCH_TP_CD ," ).append("\n"); 
		query.append("MAX(CLPT_IND_SEQ)CLPT_IND_SEQ," ).append("\n"); 
		query.append("MAX(ACT_DAT_RCV_DT) ACT_DAT_RCV_DT," ).append("\n"); 
		query.append("USR_ID AS UPD_USR_ID," ).append("\n"); 
		query.append("EDI_MSG_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT '0'," ).append("\n"); 
		query.append("AD.BKG_NO," ).append("\n"); 
		query.append("ACT_RCV_DT," ).append("\n"); 
		query.append("ACT_RCV_NO," ).append("\n"); 
		query.append("AD.CNTR_NO," ).append("\n"); 
		query.append("@[cop_no] as cop_no," ).append("\n"); 
		query.append("TO_CHAR(ACT_DT, 'YYYYMMDDHH24MISS')ACT_DT," ).append("\n"); 
		query.append("AD.ACT_STS_MAPG_CD," ).append("\n"); 
		query.append("V.COP_DTL_SEQ," ).append("\n"); 
		query.append("AD.NOD_CD," ).append("\n"); 
		query.append("ACT_RCV_TP_CD ," ).append("\n"); 
		query.append("AD.VSL_CD," ).append("\n"); 
		query.append("AD.SKD_VOY_NO," ).append("\n"); 
		query.append("AD.SKD_DIR_CD," ).append("\n"); 
		query.append("AD.VPS_PORT_CD," ).append("\n"); 
		query.append("EDI_SND_RSLT_FLG," ).append("\n"); 
		query.append("'ACT_MAPG_RPLNV' USR_ID ," ).append("\n"); 
		query.append("ACT_UMCH_TP_CD," ).append("\n"); 
		query.append("AD.CLPT_IND_SEQ," ).append("\n"); 
		query.append("TO_CHAR(ACT_DAT_RCV_DT, 'YYYYMMDDHH24MISS') ACT_DAT_RCV_DT," ).append("\n"); 
		query.append("AD.EDI_MSG_TP_CD," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (PARTITION BY AD.COP_NO, AD.ACT_STS_MAPG_CD, COP_DTL_SEQ, AD.NOD_CD" ).append("\n"); 
		query.append("ORDER BY ACT_RCV_DT, ACT_RCV_NO) AS INIT_CNT" ).append("\n"); 
		query.append("FROM SCE_ACT_RCV_IF AD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT SUBSTR(NOD_CD, 1, 5) NOD_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("'AT'||SUBSTR(ACT_CD, 5, 1) ACT_STS_MAPG_CD," ).append("\n"); 
		query.append("CLPT_IND_SEQ," ).append("\n"); 
		query.append("COP_DTL_SEQ" ).append("\n"); 
		query.append("FROM SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND VSL_CD IS NOT NULL" ).append("\n"); 
		query.append("AND SKD_VOY_NO IS NOT NULL" ).append("\n"); 
		query.append("AND SKD_DIR_CD IS NOT NULL" ).append("\n"); 
		query.append("AND SUBSTR(ACT_CD, 5, 1) IN ('A'," ).append("\n"); 
		query.append("'B'," ).append("\n"); 
		query.append("'D')" ).append("\n"); 
		query.append("GROUP BY NOD_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, SUBSTR(ACT_CD, 5, 1), CLPT_IND_SEQ, COP_DTL_SEQ)V" ).append("\n"); 
		query.append("WHERE AD.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("AND AD.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND AD.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND AD.VPS_PORT_CD = V.NOD_CD" ).append("\n"); 
		query.append("AND AD.CLPT_IND_SEQ = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND AD.BKG_NO IS NULL" ).append("\n"); 
		query.append("AND AD.ACT_STS_MAPG_CD = V.ACT_STS_MAPG_CD" ).append("\n"); 
		query.append("AND AD.ACT_UMCH_TP_CD NOT IN ('00'," ).append("\n"); 
		query.append("'XX') )" ).append("\n"); 
		query.append("WHERE INIT_CNT = 1" ).append("\n"); 
		query.append("GROUP BY ACT_RCV_DT, ACT_RCV_NO, USR_ID, EDI_MSG_TP_CD )" ).append("\n"); 

	}
}