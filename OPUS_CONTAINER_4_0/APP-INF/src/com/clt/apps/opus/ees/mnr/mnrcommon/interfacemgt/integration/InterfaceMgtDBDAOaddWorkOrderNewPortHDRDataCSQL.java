/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceMgtDBDAOaddWorkOrderNewPortHDRDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOaddWorkOrderNewPortHDRDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addWorkOrderNewPortHDRData
	  * </pre>
	  */
	public InterfaceMgtDBDAOaddWorkOrderNewPortHDRDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_spl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOaddWorkOrderNewPortHDRDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_ORD_HDR(" ).append("\n"); 
		query.append("		 MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("		,MNR_ORD_SEQ" ).append("\n"); 
		query.append("		,EQ_KND_CD" ).append("\n"); 
		query.append("		,MNR_GRP_TP_CD" ).append("\n"); 
		query.append("		,MNR_WO_TP_CD" ).append("\n"); 
		query.append("		,COST_CD" ).append("\n"); 
		query.append("		,TRSM_MOD_CD" ).append("\n"); 
		query.append("		,AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		,AGMT_SEQ" ).append("\n"); 
		query.append("		,AGMT_VER_NO" ).append("\n"); 
		query.append("		,CURR_CD" ).append("\n"); 
		query.append("		,MNR_AGMT_AMT" ).append("\n"); 
		query.append("		,MNR_WRK_AMT" ).append("\n"); 
		query.append("		,INV_AMT" ).append("\n"); 
		query.append("		,ORD_ISS_OFC_CD" ).append("\n"); 
		query.append("		,MNR_ORD_SND_DT" ).append("\n"); 
		query.append("		,COST_OFC_CD" ).append("\n"); 
		query.append("		,VNDR_SEQ" ).append("\n"); 
		query.append("        ,SPR_PRT_SPL_DT" ).append("\n"); 
		query.append("		,CRE_USR_ID" ).append("\n"); 
		query.append("		,CRE_DT" ).append("\n"); 
		query.append("		,UPD_USR_ID" ).append("\n"); 
		query.append("		,UPD_DT" ).append("\n"); 
		query.append("        ,VSL_CD" ).append("\n"); 
		query.append("        ,SKD_VOY_NO" ).append("\n"); 
		query.append("        ,SKD_DIR_CD" ).append("\n"); 
		query.append("        ,MNR_INP_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("            @[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append("           ,@[mnr_ord_seq]" ).append("\n"); 
		query.append("           ,@[eq_knd_cd] " ).append("\n"); 
		query.append("           ,'RPR'" ).append("\n"); 
		query.append("           ,(SELECT DECODE(MNR_ORD_TP_CD, 'LB', 'EST', 'TS', 'SPL', 'QT', DECODE(MNR_CD_ID, 'MRRUSP', 'RFS', 'EXT'), 'EST')" ).append("\n"); 
		query.append("               FROM MNR_GEN_CD" ).append("\n"); 
		query.append("              WHERE PRNT_CD_ID = @[eq_knd_cd]||'G'" ).append("\n"); 
		query.append("                AND MNR_CD_ID = @[cost_cd] " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("		   ,@[cost_cd]" ).append("\n"); 
		query.append("           ,(SELECT TRSM_MOD_CD " ).append("\n"); 
		query.append("               FROM MNR_PARTNER " ).append("\n"); 
		query.append("              WHERE MNR_PRNR_SEQ = @[vndr_seq]  " ).append("\n"); 
		query.append("                AND MNR_GRP_TP_CD = 'RPR' " ).append("\n"); 
		query.append("                AND CTRL_OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append("                AND (AGMT_OFC_CTY_CD, AGMT_SEQ, AGMT_VER_NO) IN (SELECT AGMT_OFC_CTY_CD, AGMT_SEQ, AGMT_VER_NO" ).append("\n"); 
		query.append("                                                                   FROM MNR_AGMT_HDR" ).append("\n"); 
		query.append("                                                                  WHERE AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("                                                                    AND AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("                                                                    AND AGMT_LST_VER_FLG = 'Y'))" ).append("\n"); 
		query.append("           ,@[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("           ,@[agmt_seq]" ).append("\n"); 
		query.append("           ,(SELECT A.AGMT_VER_NO FROM MNR_AGMT_HDR A WHERE AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd] AND AGMT_SEQ = @[agmt_seq] AND AGMT_LST_VER_FLG = 'Y')" ).append("\n"); 
		query.append("		   ,@[curr_cd]" ).append("\n"); 
		query.append("		   ,@[inv_amt] " ).append("\n"); 
		query.append("		   ,@[inv_amt]" ).append("\n"); 
		query.append("		   ,@[inv_amt]" ).append("\n"); 
		query.append("		   ,@[cost_ofc_cd]" ).append("\n"); 
		query.append("		   ,TO_DATE(@[mnr_ord_snd_dt], 'yyyymmdd') " ).append("\n"); 
		query.append("		   ,@[cost_ofc_cd]" ).append("\n"); 
		query.append("		   ,@[vndr_seq]" ).append("\n"); 
		query.append("           ,TO_DATE(@[spr_prt_spl_dt], 'yyyymmdd') " ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[upd_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[vsl_cd]" ).append("\n"); 
		query.append("           ,@[skd_voy_no]" ).append("\n"); 
		query.append("           ,@[skd_dir_cd]" ).append("\n"); 
		query.append("           ,TO_DATE(@[mnr_ord_snd_dt], 'yyyymmdd')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}