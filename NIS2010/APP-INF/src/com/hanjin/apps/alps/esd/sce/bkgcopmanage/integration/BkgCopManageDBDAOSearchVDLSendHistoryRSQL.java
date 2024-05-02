/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchVDLSendHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.18 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchVDLSendHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_no, cntr_no 로 315 EDI 로 VDL status 가 전송된 기록이 없으면 row 가 조회 된다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchVDLSendHistoryRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchVDLSendHistoryRSQL").append("\n"); 
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
		query.append("SELECT HDR.CNTR_NO ," ).append("\n"); 
		query.append("  'VDL' AS STND_EDI_STS_CD," ).append("\n"); 
		query.append("  HDR.BKG_NO ," ).append("\n"); 
		query.append("  BKG.BL_NO," ).append("\n"); 
		query.append("  DTL.VSL_CD," ).append("\n"); 
		query.append("  DTL.SKD_VOY_NO ," ).append("\n"); 
		query.append("  DTL.SKD_DIR_CD ," ).append("\n"); 
		query.append("  TO_CHAR(DTL.ACT_DT, 'YYYYMMDDHH24MISS') AS ACT_DT," ).append("\n"); 
		query.append("  DTL.NOD_CD," ).append("\n"); 
		query.append("  DTL.COP_DTL_SEQ," ).append("\n"); 
		query.append("  DTL.VPS_PORT_CD," ).append("\n"); 
		query.append("  DTL.COP_NO" ).append("\n"); 
		query.append("FROM SCE_COP_HDR HDR ," ).append("\n"); 
		query.append("  SCE_COP_DTL DTL," ).append("\n"); 
		query.append("  BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE HDR.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("  AND HDR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND HDR.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("  AND HDR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("  AND DTL.STND_EDI_STS_CD = 'VDL'" ).append("\n"); 
		query.append("  AND HDR.CNTR_NO <> 'SMCU0000000'" ).append("\n"); 
		query.append("  AND ACT_DT IS NULL" ).append("\n"); 
		query.append("  AND NOT EXISTS ( /* VDL에 대한 전송 내역이 없어야 함*/" ).append("\n"); 
		query.append("    SELECT RSLT.BKG_NO," ).append("\n"); 
		query.append("      RSLT.CNTR_NO" ).append("\n"); 
		query.append("    FROM SCE_EDI_SND_RSLT RSLT" ).append("\n"); 
		query.append("    WHERE RSLT.BKG_NO = HDR.BKG_NO" ).append("\n"); 
		query.append("      AND RSLT.CNTR_NO = HDR.CNTR_NO" ).append("\n"); 
		query.append("      AND RSLT.EDI_STS_CD = DTL.STND_EDI_STS_CD )" ).append("\n"); 

	}
}