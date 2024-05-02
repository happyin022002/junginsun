/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselPositionPollingManagementDBDAOCreatePositionPollingDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselPositionPollingManagementDBDAOCreatePositionPollingDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert the position polling detail data from EDI
	  * </pre>
	  */
	public VesselPositionPollingManagementDBDAOCreatePositionPollingDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_prog_dir_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plng_gen_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dly_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lat",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.integration").append("\n"); 
		query.append("FileName : VesselPositionPollingManagementDBDAOCreatePositionPollingDetailCSQL").append("\n"); 
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
		query.append("INSERT  INTO    VSK_VSL_PSN_PLNG_DTL X" ).append("\n"); 
		query.append("        (   X.RCV_DT" ).append("\n"); 
		query.append("          , X.DLY_RCV_SEQ" ).append("\n"); 
		query.append("          , X.IF_RCV_SEQ" ).append("\n"); 
		query.append("          , X.PLNG_GEN_GDT" ).append("\n"); 
		query.append("--          , X.PLNG_GEN_LOCL_DT" ).append("\n"); 
		query.append("          , X.VSL_CD" ).append("\n"); 
		query.append("          , X.VSL_ENG_NM" ).append("\n"); 
		query.append("          , X.CALL_SGN_NO" ).append("\n"); 
		query.append("          , X.LLOYD_NO " ).append("\n"); 
		query.append("--          , X.SKD_VOY_NO" ).append("\n"); 
		query.append("--          , X.SKD_DIR_CD" ).append("\n"); 
		query.append("          , X.VSL_LAT" ).append("\n"); 
		query.append("          , X.VSL_LON" ).append("\n"); 
		query.append("          , X.VSL_SPD" ).append("\n"); 
		query.append("          , X.VSL_PROG_DIR_CTNT" ).append("\n"); 
		query.append("--          , X.PLNG_GEN_DIFF_HRS" ).append("\n"); 
		query.append("--          , X.VSL_PRE_LAT" ).append("\n"); 
		query.append("--          , X.VSL_PRE_LON" ).append("\n"); 
		query.append("--          , X.VSL_PLNG_DIST" ).append("\n"); 
		query.append("--          , X.VSL_PRE_SPD" ).append("\n"); 
		query.append("--          , X.VSL_PRE_PROG_DIR_CTNT" ).append("\n"); 
		query.append("          , X.CRE_USR_ID" ).append("\n"); 
		query.append("          , X.CRE_DT" ).append("\n"); 
		query.append("          , X.UPD_USR_ID" ).append("\n"); 
		query.append("          , X.UPD_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("VALUES  (   @[rcv_dt]" ).append("\n"); 
		query.append("          , @[dly_rcv_seq]" ).append("\n"); 
		query.append("		  , PSN_PLNG_IF_RCV_SEQ.NEXTVAL" ).append("\n"); 
		query.append("          , TO_DATE(@[plng_gen_gdt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		  , CASE WHEN   (" ).append("\n"); 
		query.append("                      SELECT    COUNT(1)" ).append("\n"); 
		query.append("                      FROM      MDM_VSL_CNTR     X" ).append("\n"); 
		query.append("                      WHERE     X.LLOYD_NO       = @[lloyd_no]" ).append("\n"); 
		query.append("                      AND       X.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                      ) = 1 THEN (SELECT X.VSL_CD FROM MDM_VSL_CNTR X WHERE X.LLOYD_NO = @[lloyd_no] AND X.DELT_FLG = 'N')" ).append("\n"); 
		query.append("               WHEN   (" ).append("\n"); 
		query.append("                      SELECT    COUNT(1)" ).append("\n"); 
		query.append("                      FROM      MDM_VSL_CNTR     X" ).append("\n"); 
		query.append("                      WHERE     X.CALL_SGN_NO    = @[call_sgn_no]" ).append("\n"); 
		query.append("                      AND       X.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                      ) = 1 THEN (SELECT X.VSL_CD FROM MDM_VSL_CNTR X WHERE X.CALL_SGN_NO = @[call_sgn_no] AND X.DELT_FLG = 'N')                      " ).append("\n"); 
		query.append("               ELSE   ( " ).append("\n"); 
		query.append("                      --------------------------------------------------------------------------------" ).append("\n"); 
		query.append("                      SELECT    XX.VSL_CD" ).append("\n"); 
		query.append("                      FROM      (" ).append("\n"); 
		query.append("                                SELECT    PS.VSL_CD" ).append("\n"); 
		query.append("                                FROM      MDM_VSL_CNTR                   X" ).append("\n"); 
		query.append("                                      ,   VSK_VSL_SKD                    VS" ).append("\n"); 
		query.append("                                      ,   VSK_VSL_PORT_SKD               PS" ).append("\n"); 
		query.append("                                WHERE     1 = 1" ).append("\n"); 
		query.append("                                AND       X.VSL_CD                       = VS.VSL_CD" ).append("\n"); 
		query.append("                                AND       VS.VSL_CD                      = PS.VSL_CD" ).append("\n"); 
		query.append("                                AND       VS.SKD_VOY_NO                  = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND       VS.SKD_DIR_CD                  = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND       X.LLOYD_NO                     = @[lloyd_no]" ).append("\n"); 
		query.append("                                AND       GLOBALDATE_PKG.TIME_CONV_FNC(PS.VPS_PORT_CD,PS.VPS_ETA_DT,'GBFXT') <= TO_DATE(@[plng_gen_gdt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                                AND       NVL(PS.SKD_CNG_STS_CD,'*')     <> 'S'" ).append("\n"); 
		query.append("                                AND       PS.TURN_PORT_IND_CD            IN ('Y','N')" ).append("\n"); 
		query.append("                                AND       PS.CLPT_SEQ                    = (SELECT   MIN(PPS.CLPT_SEQ)" ).append("\n"); 
		query.append("                                                                            FROM     VSK_VSL_PORT_SKD             PPS" ).append("\n"); 
		query.append("                                                                            WHERE    PPS.VSL_CD                   = PS.VSL_CD" ).append("\n"); 
		query.append("                                                                            AND      PPS.SKD_VOY_NO               = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                            AND      PPS.SKD_DIR_CD               = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                            AND      PPS.TURN_PORT_IND_CD         IN ('Y','N')" ).append("\n"); 
		query.append("                                                                            AND      NVL(PPS.SKD_CNG_STS_CD,'*')  <> 'S'" ).append("\n"); 
		query.append("                                                                            )" ).append("\n"); 
		query.append("                                ORDER BY  VS.N1ST_PORT_BRTH_DT   DESC" ).append("\n"); 
		query.append("                                ) XX" ).append("\n"); 
		query.append("                      WHERE     ROWNUM    = 1    " ).append("\n"); 
		query.append("                      --------------------------------------------------------------------------------" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("          END " ).append("\n"); 
		query.append("          , @[vsl_eng_nm]" ).append("\n"); 
		query.append("          , @[call_sgn_no]" ).append("\n"); 
		query.append("          , @[lloyd_no]" ).append("\n"); 
		query.append("          , @[vsl_lat]" ).append("\n"); 
		query.append("          , @[vsl_lon]" ).append("\n"); 
		query.append("          , @[vsl_spd]" ).append("\n"); 
		query.append("          , @[vsl_prog_dir_ctnt]" ).append("\n"); 
		query.append("          , 'EDI_POLPSN_USER_ID'" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("		  , 'EDI_POLPSN_USER_ID'" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}