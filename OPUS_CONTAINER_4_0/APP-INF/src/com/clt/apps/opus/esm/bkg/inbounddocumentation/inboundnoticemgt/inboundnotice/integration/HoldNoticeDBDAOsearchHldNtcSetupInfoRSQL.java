/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HoldNoticeDBDAOsearchHldNtcSetupInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HoldNoticeDBDAOsearchHldNtcSetupInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pre Hold Notice 전송방식과 내용에 따른 Setup 선택 및 Original B/L 추가 송부 Setup정보등을 조회한다.
	  * </pre>
	  */
	public HoldNoticeDBDAOsearchHldNtcSetupInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hld_ntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOsearchHldNtcSetupInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(A.AUTO_NTC_FLG, B.AUTO_NTC_FLG) AS AUTO_NTC_FLG" ).append("\n"); 
		query.append("      ,NVL(A.ECLZ_OBL_FLG, B.ECLZ_OBL_FLG) AS ECLZ_OBL_FLG" ).append("\n"); 
		query.append("      ,NVL(A.OFC_CD, B.OFC_CD) AS OFC_CD" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT NVL(AUTO_NTC_FLG,'N') AS AUTO_NTC_FLG" ).append("\n"); 
		query.append("              ,NVL(ECLZ_OBL_FLG,'N') AS ECLZ_OBL_FLG" ).append("\n"); 
		query.append("              ,STUP.OFC_CD" ).append("\n"); 
		query.append("              ,1 FLAG" ).append("\n"); 
		query.append("        FROM   BKG_HLD_WD WD" ).append("\n"); 
		query.append("             ,(SELECT DSTP.HNDL_OFC_CD OFC_CD" ).append("\n"); 
		query.append("               FROM   BKG_AN_DEST_OFC_STUP DSTP" ).append("\n"); 
		query.append("                     ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("               WHERE  LOC.LOC_CD            = @[loc_cd]" ).append("\n"); 
		query.append("               AND    LOC.EQ_CTRL_OFC_CD    = DSTP.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("               AND    DSTP.DEST_OFC_CNTC_CD ='I') STUP" ).append("\n"); 
		query.append("        WHERE  WD.OFC_CD(+)        = STUP.OFC_CD" ).append("\n"); 
		query.append("        AND    WD.POD_CD(+)        = @[pod_cd]" ).append("\n"); 
		query.append("        AND    WD.HLD_NTC_TP_CD(+) = @[hld_ntc_tp_cd]" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT 'N' AS AUTO_NTC_FLG" ).append("\n"); 
		query.append("              ,'N' AS ECLZ_OBL_FLG" ).append("\n"); 
		query.append("              ,''  AS OFC_CD" ).append("\n"); 
		query.append("              ,1 FLAG" ).append("\n"); 
		query.append("        FROM  DUAL" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("WHERE B.FLAG = A.FLAG(+)" ).append("\n"); 

	}
}