/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DwellNotificationDBDAOInsertMSExptListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOInsertMSExptListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MS Exception Dwell Reason 내역 저장
	  * </pre>
	  */
	public DwellNotificationDBDAOInsertMSExptListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ms_dwll_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ms_dwll_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_oc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_tt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_oc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_tt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOInsertMSExptListCSQL").append("\n"); 
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
		query.append("MERGE INTO SCE_MS_DWLL_NTFC T1" ).append("\n"); 
		query.append("USING (SELECT COP_NO FROM" ).append("\n"); 
		query.append("			(SELECT COP_NO" ).append("\n"); 
		query.append("			 FROM SCE_MS_DWLL_NTFC" ).append("\n"); 
		query.append("			 WHERE COP_NO = (SELECT COP_NO FROM SCE_COP_HDR WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append("			 UNION ALL" ).append("\n"); 
		query.append("			 SELECT NULL COP_NO FROM DUAL" ).append("\n"); 
		query.append("			) WHERE ROWNUM = 1" ).append("\n"); 
		query.append("	   ) T2" ).append("\n"); 
		query.append("ON (T1.COP_NO = T2.COP_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("T1.MS_DWLL_RSN_CD = @[ms_dwll_rsn_cd]" ).append("\n"); 
		query.append(", T1.MS_DWLL_RMK = @[ms_dwll_rmk]" ).append("\n"); 
		query.append(",T1.UPD_USR_ID = @[upd_usr_id], T1.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("INSERT (  T1.MS_DWLL_NTFC_SEQ " ).append("\n"); 
		query.append("        , T1.COP_NO" ).append("\n"); 
		query.append("        , T1.BKG_NO" ).append("\n"); 
		query.append("        , T1.CNTR_NO" ).append("\n"); 
		query.append("        , T1.VSL_CD" ).append("\n"); 
		query.append("        , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("        , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("        , T1.FM_ESTM_DT" ).append("\n"); 
		query.append("        , T1.TO_ESTM_DT" ).append("\n"); 
		query.append("        , T1.ESTM_TZTM_DESC" ).append("\n"); 
		query.append("        , T1.FM_ACT_DT" ).append("\n"); 
		query.append("        , T1.TO_ACT_DT" ).append("\n"); 
		query.append("        , T1.ACT_TZTM_DESC" ).append("\n"); 
		query.append("        , T1.DWLL_GAP_DESC" ).append("\n"); 
		query.append("        , T1.MS_DWLL_RSN_CD" ).append("\n"); 
		query.append("        , T1.MS_DWLL_RMK" ).append("\n"); 
		query.append("		, T1.CRE_USR_ID" ).append("\n"); 
		query.append("        , T1.CRE_DT" ).append("\n"); 
		query.append("        , T1.UPD_USR_ID" ).append("\n"); 
		query.append("        , T1.UPD_DT)" ).append("\n"); 
		query.append(" VALUES ( SCE_MS_DWLL_NTFC_SEQ.NEXTVAL" ).append("\n"); 
		query.append("		,(SELECT COP_NO FROM SCE_COP_HDR WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append("		, @[bkg_no]" ).append("\n"); 
		query.append("        , @[cntr_no]" ).append("\n"); 
		query.append("        , SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("        , SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("        , SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("        , TO_DATE(@[estm_oc],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("        , TO_DATE(@[estm_id],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("        , @[estm_tt]" ).append("\n"); 
		query.append("        , TO_DATE(@[act_oc],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("        , TO_DATE(@[act_id],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("        , @[act_tt]" ).append("\n"); 
		query.append("        , @[diff]" ).append("\n"); 
		query.append("        , @[ms_dwll_rsn_cd]" ).append("\n"); 
		query.append("        , @[ms_dwll_rmk]" ).append("\n"); 
		query.append("		, @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE)" ).append("\n"); 

	}
}