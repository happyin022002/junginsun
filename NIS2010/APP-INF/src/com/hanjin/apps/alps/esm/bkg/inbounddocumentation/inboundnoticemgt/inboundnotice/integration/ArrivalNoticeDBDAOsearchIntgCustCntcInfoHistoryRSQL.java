/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchIntgCustCntcInfoHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 윤한
*@LastVersion : 1.0
* 2010.05.14 윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchIntgCustCntcInfoHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Data Management Update History
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchIntgCustCntcInfoHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cng_dt_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cng_dt_e",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_sel_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchIntgCustCntcInfoHistoryRSQL").append("\n"); 
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
		query.append("SELECT HIST.CUST_CNT_CD" ).append("\n"); 
		query.append("     , HIST.CUST_SEQ" ).append("\n"); 
		query.append("     , HIST.CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("     , COCD.INTG_CD_VAL_DP_DESC AS CUST_CNTC_TP_CD_DESC" ).append("\n"); 
		query.append("     , HIST.NEW_CNTC_CTNT " ).append("\n"); 
		query.append("	 , HIST.OLD_CNTC_CTNT" ).append("\n"); 
		query.append("	 , HIST.AUTO_MNL_FLG" ).append("\n"); 
		query.append("     , DECODE(HIST.AUTO_MNL_FLG, 'Y', 'Auto', 'N','Manual', NULL) AS AUTO_MNL_FLG_DESC" ).append("\n"); 
		query.append("	 , HIST.BL_NO" ).append("\n"); 
		query.append("	 , HIST.SND_SEL_FLG" ).append("\n"); 
		query.append("     , DECODE(HIST.SND_SEL_FLG, 'N', 'Select', 'Y', 'Deselect', NULL) AS SND_SEL_FLG_DESC" ).append("\n"); 
		query.append("	 , TO_CHAR(HIST.CNG_DT, 'YYYYMMDDHH24MI') CNG_DT" ).append("\n"); 
		query.append("	 , DECODE(HIST.CNG_USR_ID,'BAT_BKG_B014','Auto',HIST.CNG_USR_ID)   AS CNG_USR_ID" ).append("\n"); 
		query.append("	 , DECODE(HIST.CNG_USR_ID,'BAT_BKG_B014','Auto',CUSR.OFC_CD)       AS OFC_CD" ).append("\n"); 
		query.append("	 , DECODE(HIST.CNG_USR_ID,'BAT_BKG_B014','Auto',CUSR.USR_NM)       AS CNG_USR_NM" ).append("\n"); 
		query.append("FROM  BKG_IB_CUST_CNTC_HIS HIST" ).append("\n"); 
		query.append("	, COM_USER CUSR" ).append("\n"); 
		query.append("    , COM_INTG_CD_DTL COCD" ).append("\n"); 
		query.append("WHERE HIST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND HIST.CUST_SEQ      = @[cust_seq]" ).append("\n"); 
		query.append("AND HIST.CNG_DT        >= TO_DATE(@[cng_dt_s], 'YYYYMMDD') " ).append("\n"); 
		query.append("AND HIST.CNG_DT        < (TO_DATE(@[cng_dt_e], 'YYYYMMDD') + 0.9999)" ).append("\n"); 
		query.append("AND HIST.OFC_CD        = @[ofc_cd]" ).append("\n"); 
		query.append("AND CUSR.USR_ID(+)     = HIST.CNG_USR_ID" ).append("\n"); 
		query.append("#if (${cust_cntc_tp_cd} != '')" ).append("\n"); 
		query.append("AND HIST.CUST_CNTC_TP_CD = @[cust_cntc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auto_mnl_flg} != '')" ).append("\n"); 
		query.append("AND HIST.AUTO_MNL_FLG = @[auto_mnl_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '' && ${auto_mnl_flg} != 'N' )" ).append("\n"); 
		query.append("AND HIST.BL_NO = @[bl_no]   -- OPTIONAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${snd_sel_flg} != '')" ).append("\n"); 
		query.append("AND HIST.SND_SEL_FLG = @[snd_sel_flg] -- OPTIONAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND COCD.INTG_CD_ID = 'CD02129'" ).append("\n"); 
		query.append("AND COCD.INTG_CD_VAL_CTNT = HIST.CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("AND 1 = DECODE(HIST.AUTO_MNL_FLG, 'N', 1, DECODE(HIST.OLD_CNTC_CTNT, HIST.NEW_CNTC_CTNT, 0, 1 )) -- Auto의 경우 old와 new가 다른경우만 보여줌" ).append("\n"); 
		query.append("ORDER BY HIST.CUST_CNTC_TP_CD ASC, TO_CHAR(HIST.CNG_DT, 'YYYYMMDDHH24MI') DESC" ).append("\n"); 

	}
}