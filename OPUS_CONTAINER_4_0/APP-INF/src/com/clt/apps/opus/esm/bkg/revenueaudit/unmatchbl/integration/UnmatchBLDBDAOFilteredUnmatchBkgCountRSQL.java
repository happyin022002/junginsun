/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOFilteredUnmatchBkgCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.15
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.08.15 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOFilteredUnmatchBkgCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Filterd Bkg count
	  * </pre>
	  */
	public UnmatchBLDBDAOFilteredUnmatchBkgCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rater_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("contract_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_rat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_status_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rct_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOFilteredUnmatchBkgCountRSQL").append("\n"); 
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
		query.append("SELECT  MAX(A4.FILERED_BKG_COUNT) AS FILERED_BKG_COUNT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT  A3.AUTO_RAT_FLG" ).append("\n"); 
		query.append("        	   ,ROWNUM AS FILERED_BKG_COUNT	" ).append("\n"); 
		query.append("        FROM   (    " ).append("\n"); 
		query.append("                SELECT  A2.BKG_NO , A2.CTRT_NO" ).append("\n"); 
		query.append("                      ,(" ).append("\n"); 
		query.append("		                SELECT  MAX(DECODE(AUTO_RAT_CD, 'A', 'A', 'I', 'A', 'M'))" ).append("\n"); 
		query.append("        		        FROM    BKG_CHG_RT  A" ).append("\n"); 
		query.append("                		WHERE   A.BKG_NO    = A2.BKG_NO" ).append("\n"); 
		query.append("                		) AS AUTO_RAT_FLG					  " ).append("\n"); 
		query.append("                FROM   (" ).append("\n"); 
		query.append("                        SELECT  A1.BKG_NO" ).append("\n"); 
		query.append("						,       CASE" ).append("\n"); 
		query.append("       							WHEN B1.BKG_CTRT_TP_CD = 'T' THEN A1.TAA_NO" ).append("\n"); 
		query.append("       							WHEN B1.BKG_CTRT_TP_CD = 'R' THEN A1.RFA_NO" ).append("\n"); 
		query.append("       							WHEN B1.BKG_CTRT_TP_CD = 'S' THEN A1.SC_NO" ).append("\n"); 
		query.append("       							END AS CTRT_NO" ).append("\n"); 
		query.append("                        FROM    BKG_BOOKING A1" ).append("\n"); 
		query.append("                        	   ,BKG_RATE B1" ).append("\n"); 
		query.append("							   ,BKG_BL_DOC C1" ).append("\n"); 
		query.append("							   ,BKG_REV_UMCH_BKG D1" ).append("\n"); 
		query.append("							   ,MDM_LOCATION POR" ).append("\n"); 
		query.append("							   ,MDM_LOCATION DEL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						WHERE   A1.BKG_NO = B1.BKG_NO" ).append("\n"); 
		query.append("						AND     A1.BKG_NO = C1.BKG_NO" ).append("\n"); 
		query.append("						AND     A1.BKG_NO = D1.BKG_NO" ).append("\n"); 
		query.append("						AND     A1.POR_CD = POR.LOC_CD" ).append("\n"); 
		query.append("						AND     A1.DEL_CD = DEL.LOC_CD" ).append("\n"); 
		query.append("						AND     POR.DELT_FLG ='N'" ).append("\n"); 
		query.append("						AND     DEL.DELT_FLG ='N'   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				        #if (${rev_aud_sts_cd} != '')" ).append("\n"); 
		query.append("					        AND D1.REV_AUD_STS_CD     = @[rev_aud_sts_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						#if (${conti_cd} != '')" ).append("\n"); 
		query.append("							AND POR.CONTI_CD = @[conti_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${conti_cd2} != '')" ).append("\n"); 
		query.append("							AND DEL.CONTI_CD = @[conti_cd2]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        #if (${rct_ofc_cd} != '') " ).append("\n"); 
		query.append("                        AND     A1.BKG_OFC_CD = @[rct_ofc_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    --revise" ).append("\n"); 
		query.append("                        #if (${rt_aply_dt_from} != '')" ).append("\n"); 
		query.append("						  	AND     D1.N1ST_UMCH_FND_DT >= TO_DATE(@[rt_aply_dt_from],'YYYY/MM/DD')" ).append("\n"); 
		query.append("				        #end" ).append("\n"); 
		query.append("				        #if (${rt_aply_dt_to} != '')" ).append("\n"); 
		query.append("					        AND     D1.N1ST_UMCH_FND_DT <= TO_DATE(@[rt_aply_dt_to],'YYYY/MM/DD') + 0.99999" ).append("\n"); 
		query.append("				        #end" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("                       #if (${conti_cd} != '')" ).append("\n"); 
		query.append("  							AND A1.POR_CD  IN (SELECT LOC_CD FROM MDM_LOCATION WHERE CONTI_CD=@[conti_cd])" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("		               #if (${conti_cd2} != '')" ).append("\n"); 
		query.append("   						    AND A1.DEL_CD IN(SELECT LOC_CD FROM MDM_LOCATION WHERE CONTI_CD=@[conti_cd2])" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("					--revise" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        #if (${vvd_cd} != '') " ).append("\n"); 
		query.append("                        AND     A1.VSL_CD		= SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("						AND		A1.SKD_VOY_NO	= SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("						AND		A1.SKD_DIR_CD)	= SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${bkg_ctrt_tp_cd} != '') " ).append("\n"); 
		query.append("                        AND     B1.BKG_CTRT_TP_CD = @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("						#if (${rct_rhq_cd} != '')" ).append("\n"); 
		query.append("						AND EXISTS (" ).append("\n"); 
		query.append("									SELECT 'X'" ).append("\n"); 
		query.append(" 									FROM   MDM_ORGANIZATION A " ).append("\n"); 
		query.append(" 									WHERE  A.OFC_TP_CD = 'HQ' " ).append("\n"); 
		query.append(" 									START  WITH A.OFC_CD = @[rct_rhq_cd]" ).append("\n"); 
		query.append(" 									CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${bdr_status_cd} != '')" ).append("\n"); 
		query.append("						AND 	C1.BDR_FLG = @[bdr_status_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${rater_id} != '')" ).append("\n"); 
		query.append("							AND	B1.UPD_USR_ID LIKE @[rater_id] || '%'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("				        #if (${bl_no} != '')" ).append("\n"); 
		query.append("					        AND	A1.BL_NO	LIKE @[bl_no] || '%'" ).append("\n"); 
		query.append("				        #end" ).append("\n"); 
		query.append("                       ) A2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${contract_no} != '') " ).append("\n"); 
		query.append("				--CONTRACT_NO" ).append("\n"); 
		query.append("				WHERE A2.CTRT_NO = @[contract_no]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ) A3" ).append("\n"); 
		query.append("		#if (${auto_rat_flg} != '') " ).append("\n"); 
		query.append("        WHERE  A3.AUTO_RAT_FLG = @[auto_rat_flg]" ).append("\n"); 
		query.append("		#end		" ).append("\n"); 
		query.append("       ) A4" ).append("\n"); 

	}
}