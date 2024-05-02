/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HoldNoticeDBDAOmergeHldNtcFormCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.28 
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

public class HoldNoticeDBDAOmergeHldNtcFormCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정 국가별로 등록된 Hold Code정보를 생성한다
	  * </pre>
	  */
	public HoldNoticeDBDAOmergeHldNtcFormCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eclz_obl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("addr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_ofc_cntc_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hld_ntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOmergeHldNtcFormCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_HLD_WD A" ).append("\n"); 
		query.append("USING (SELECT @[ofc_cd]            AS OFC_CD" ).append("\n"); 
		query.append(",decode(nvl(@[pod_cd],'ALL'),'ALL','*',@[pod_cd]) AS POD_CD" ).append("\n"); 
		query.append(",@[hld_ntc_tp_cd]     AS HLD_NTC_TP_CD" ).append("\n"); 
		query.append(",@[auto_ntc_flg]      AS AUTO_NTC_FLG" ).append("\n"); 
		query.append(",@[eclz_obl_flg]      AS ECLZ_OBL_FLG" ).append("\n"); 
		query.append(",@[addr_ctnt]         AS ADDR_CTNT" ).append("\n"); 
		query.append(",@[snd_ofc_cntc_ctnt] AS SND_OFC_CNTC_CTNT" ).append("\n"); 
		query.append(",@[cre_usr_id]        AS CRE_USR_ID" ).append("\n"); 
		query.append(",@[upd_usr_id]        AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM   DUAL) B" ).append("\n"); 
		query.append("ON (A.OFC_CD        = B.OFC_CD" ).append("\n"); 
		query.append("AND A.POD_CD        = B.POD_CD" ).append("\n"); 
		query.append("AND A.HLD_NTC_TP_CD = B.HLD_NTC_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET AUTO_NTC_FLG      = B.AUTO_NTC_FLG" ).append("\n"); 
		query.append(",ECLZ_OBL_FLG      = B.ECLZ_OBL_FLG" ).append("\n"); 
		query.append(",ADDR_CTNT         = B.ADDR_CTNT" ).append("\n"); 
		query.append(",SND_OFC_CNTC_CTNT = B.SND_OFC_CNTC_CTNT" ).append("\n"); 
		query.append(",UPD_USR_ID        = B.UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("OFC_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	HLD_NTC_TP_CD" ).append("\n"); 
		query.append(",	AUTO_NTC_FLG" ).append("\n"); 
		query.append(",	ECLZ_OBL_FLG" ).append("\n"); 
		query.append(",	ADDR_CTNT" ).append("\n"); 
		query.append(",	SND_OFC_CNTC_CTNT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("B.OFC_CD" ).append("\n"); 
		query.append(",	B.POD_CD" ).append("\n"); 
		query.append(",	B.HLD_NTC_TP_CD" ).append("\n"); 
		query.append(",	B.AUTO_NTC_FLG" ).append("\n"); 
		query.append(",	B.ECLZ_OBL_FLG" ).append("\n"); 
		query.append(",	B.ADDR_CTNT" ).append("\n"); 
		query.append(",	B.SND_OFC_CNTC_CTNT" ).append("\n"); 
		query.append(",	B.CRE_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	B.UPD_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}